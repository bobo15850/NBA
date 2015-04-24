package businesslogic.hotsport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import businesslogic.CACHE;
import businesslogic.players.CalculationOfPlayerPerform;
import businesslogicservice.hotsport.PlayerHotBlSrevice;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.statics.Field;
import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

public class PlayerHotBl implements PlayerHotBlSrevice {
	private PlayerInfoDataService playerData = PlayerInfoData.getInstance();

	public ArrayList<PlayerHotInfo> getPlayerHot(int number, final String field) {
		ArrayList<PlayerHotInfo> playerHotList = new ArrayList<PlayerHotInfo>();
		ArrayList<String> playerNames = this.playerData.getNamesOfAllPlayer();
		for (int i = 0; i < playerNames.size(); i++) {
			String playerName = playerNames.get(i);
			ArrayList<PlayerPerformOfOneMatch> onePlayerPerform = this.playerData.getOnePlayerPerformOfOneSeasonPo(playerName);
			int numOfGame = onePlayerPerform.size();
			if (numOfGame > 5) {
				PlayerHotInfo tempHotInfo = new PlayerHotInfo();
				tempHotInfo.setField(field);
				tempHotInfo.setName(playerName);
				tempHotInfo.setPosition(playerData.getGeneralInfoOfOnePlayer(playerName).getPosition());
				tempHotInfo.setTeamName(onePlayerPerform.get(numOfGame - 1).getTeamName());
				double before = 0;
				double latestFive = 0;
				double all = 0;
				ArrayList<Double> dataList = new ArrayList<Double>(128);
				if (field.equals(Field.point)) {
					dataList = this.getPerform(onePlayerPerform, new Point());
				}
				else if (field.equals(Field.rebound)) {
					dataList = this.getPerform(onePlayerPerform, new Rebond());
				}
				else if (field.equals(Field.assist)) {
					dataList = this.getPerform(onePlayerPerform, new Assist());
				}
				else if (field.equals(Field.steal)) {
					dataList = this.getPerform(onePlayerPerform, new Steal());
				}
				else if (field.equals(Field.blockShot)) {
					dataList = this.getPerform(onePlayerPerform, new BlockShot());
				}
				for (int j = 0; j < dataList.size() - 5; j++) {
					before += dataList.get(j);
				}
				for (int j = dataList.size() - 5; j < dataList.size(); j++) {
					latestFive += dataList.get(j);
				}
				if (before != 0) {
					all = before + latestFive;
					// 以上都为总和，以下为平均
					all /= numOfGame;
					before /= (numOfGame - 5);
					latestFive /= 5;
					double upGradeRate = (CalculationOfPlayerPerform.cutTail(latestFive - before) / before);
					tempHotInfo.setValue(CalculationOfPlayerPerform.cutTail(all));
					tempHotInfo.setUpgradeRate(CalculationOfPlayerPerform.cutTail(upGradeRate));
					playerHotList.add(tempHotInfo);
				}
			}
		}
		Collections.sort(playerHotList, new Comparator<PlayerHotInfo>() {
			public int compare(PlayerHotInfo o1, PlayerHotInfo o2) {
				if (o1.getUpgradeRate() < o2.getUpgradeRate()) {
					return 1;
				}
				else if (o1.getUpgradeRate() == o2.getUpgradeRate()) {
					return 0;
				}
				else {
					return -1;
				}
			}
		});
		if (number > playerHotList.size()) {
			number = playerHotList.size();
		}
		ArrayList<PlayerHotInfo> resultList = new ArrayList<PlayerHotInfo>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(playerHotList.get(i));
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlayerKingInfo> getPlayerKingOfSeason(int number,final String field) {
		ArrayList<PlayerNormalInfo_Expand> playerNormal_avg = new ArrayList<PlayerNormalInfo_Expand>(512);
		for (Entry<String, PlayerNormalInfo_Expand> temp : CACHE.PLAYER_NORMAL.entrySet()) {
			playerNormal_avg.add(temp.getValue().getPlayerNormal_avg());
		}
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		sortFields.add(new BeanComparator(field));
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(playerNormal_avg, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > playerNormal_avg.size()) {
			number = playerNormal_avg.size();
		}
		ArrayList<PlayerKingInfo> resultList = new ArrayList<PlayerKingInfo>(number);
		for (int i = playerNormal_avg.size() - 1; i > playerNormal_avg.size() - number - 1; i--) {
			PlayerKingInfo tempKing = new PlayerKingInfo();
			PlayerNormalInfo_Expand tempNormal_avg = playerNormal_avg.get(i);
			double value = 0;
			if (field.equals(Field.point)) {
				value = tempNormal_avg.getPoint();
			}
			else if (field.equals(Field.rebound)) {
				value = tempNormal_avg.getRebound();
			}
			else if (field.equals(Field.assist)) {
				value = tempNormal_avg.getAssist();
			}
			else if (field.equals(Field.steal)) {
				value = tempNormal_avg.getSteal();
			}
			else if (field.equals(Field.blockShot)) {
				value = tempNormal_avg.getBlockShot();
			}
			else if (field.equals(Field.shot)) {
				value = tempNormal_avg.getShot();
			}
			else if (field.equals(Field.three)) {
				value = tempNormal_avg.getThree();
			}
			else if (field.equals(Field.penalty)) {
				value = tempNormal_avg.getPenalty();
			}
			tempKing.setName(tempNormal_avg.getName());
			tempKing.setTeamName(tempNormal_avg.getTeamName());
			tempKing.setField(field);
			tempKing.setValue(value);
			tempKing.setPosition(this.playerData.getGeneralInfoOfOnePlayer(tempNormal_avg.getName()).getPosition());
			resultList.add(tempKing);
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlayerKingInfo> getPlayerKingOfDaily(int number,final String field) {
		ArrayList<PlayerPerformOfOneMatch> playerPerformOneDay = new ArrayList<PlayerPerformOfOneMatch>();
		for (Entry<String, PlayerPerformOfOneMatch> playerPerformOfOneMatch : CACHE.PLAYER_TODAY.entrySet()) {
			playerPerformOneDay.add(playerPerformOfOneMatch.getValue());
		}
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		sortFields.add(new BeanComparator(field));
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(playerPerformOneDay, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > playerPerformOneDay.size()) {
			number = playerPerformOneDay.size();
		}
		ArrayList<PlayerKingInfo> resultList = new ArrayList<PlayerKingInfo>(number);
		for (int i = playerPerformOneDay.size() - 1; i > playerPerformOneDay.size() - number - 1; i--) {
			PlayerKingInfo tempKing = new PlayerKingInfo();
			PlayerPerformOfOneMatch tempPerformOfOneMatch = playerPerformOneDay.get(i);
			double value = 0;
			if (field.equals(Field.point)) {
				value = tempPerformOfOneMatch.getPoint();
			}
			else if (field.equals(Field.rebound)) {
				value = tempPerformOfOneMatch.getRebound();
			}
			else if (field.equals(Field.assist)) {
				value = tempPerformOfOneMatch.getAssist();
			}
			else if (field.equals(Field.steal)) {
				value = tempPerformOfOneMatch.getSteal();
			}
			else if (field.equals(Field.blockShot)) {
				value = tempPerformOfOneMatch.getBlockShot();
			}
			tempKing.setField(field);
			tempKing.setName(tempPerformOfOneMatch.getName());
			tempKing.setTeamName(tempPerformOfOneMatch.getTeamName());
			tempKing.setPosition(this.playerData.getGeneralInfoOfOnePlayer(tempPerformOfOneMatch.getName()).getPosition());
			tempKing.setValue(value);
			resultList.add(tempKing);
		}
		return resultList;
	}

	private ArrayList<Double> getPerform(ArrayList<PlayerPerformOfOneMatch> playerPerformList, PlayerPerform perform) {
		ArrayList<Double> dataList = new ArrayList<Double>(128);
		for (int i = 0; i < playerPerformList.size(); i++) {
			dataList.add(perform.getPerformance(playerPerformList.get(i)));
		}
		return dataList;
	}

	interface PlayerPerform {
		public double getPerformance(PlayerPerformOfOneMatch player);
	}

	class Rebond implements PlayerPerform {
		public double getPerformance(PlayerPerformOfOneMatch player) {
			return player.getRebound();
		}
	}// 总篮板

	class Assist implements PlayerPerform {
		public double getPerformance(PlayerPerformOfOneMatch player) {
			return player.getAssist();
		}
	}// 总助攻数

	class Steal implements PlayerPerform {
		public double getPerformance(PlayerPerformOfOneMatch player) {
			return player.getSteal();
		}
	}// 总抢断数

	class BlockShot implements PlayerPerform {
		public double getPerformance(PlayerPerformOfOneMatch player) {
			return player.getBlockShot();
		}
	}// 总盖帽数

	class Point implements PlayerPerform {
		public double getPerformance(PlayerPerformOfOneMatch player) {
			return player.getPoint();
		}
	}// 得分
}
