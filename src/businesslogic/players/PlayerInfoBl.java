package businesslogic.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import businesslogic.CACHE;
import businesslogic.MySort;
import businesslogicservice.players.PlayerInfoBlService;
import common.mydatastructure.CombineSelectionCell;
import common.mydatastructure.Filter;
import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.SortCell;
import common.statics.Age;
import common.statics.Command;
import common.statics.Field;
import common.statics.League;
import common.statics.NUMBER;
import common.statics.Position;
import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

public class PlayerInfoBl implements PlayerInfoBlService {
	@SuppressWarnings("unchecked")
	public ArrayList<PlayerHighInfo> getPlayerHigh(int number, final SortCell[] sortCells) {
		ArrayList<PlayerHighInfo> playerHighList = new ArrayList<PlayerHighInfo>(512);// 合格的球员链表
		for (Entry<String, PlayerHighInfo> temp : CACHE.PLAYER_HIGH.entrySet()) {
			PlayerHighInfo tempHighInfo = temp.getValue();
			PlayerNormalInfo tempNormalInfo = CACHE.PLAYER_NORMAL.get(tempHighInfo.getName());
			double averageMinute = tempNormalInfo.getMinute() / tempNormalInfo.getNumOfGame();
			if (averageMinute >= 15) {
				playerHighList.add(tempHighInfo);
			}
		}// 筛选出合格的球员，根据上场时间筛选，>=15分钟为合格
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		for (int i = 0; i < sortCells.length; i++) {
			sortFields.add(MySort.getBeanComparator(sortCells[i]));
		}
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(playerHighList, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > playerHighList.size()) {
			number = playerHighList.size();
		}
		ArrayList<PlayerHighInfo> resultList = new ArrayList<PlayerHighInfo>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(playerHighList.get(i));
		}
		return resultList;
	}// 得到球员的高级数据

	@SuppressWarnings("unchecked")
	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_avg(int number, Filter filter, final SortCell[] sortCells) {
		ArrayList<PlayerNormalInfo_Expand> playerNormalList = new ArrayList<PlayerNormalInfo_Expand>(512);
		for (Entry<String, PlayerNormalInfo_Expand> temp : CACHE.PLAYER_NORMAL.entrySet()) {
			PlayerNormalInfo_Expand playerNormal_avg = temp.getValue().getPlayerNormal_avg();
			PlayerInfoDataService playerData = PlayerInfoData.getInstance();
			GeneralInfoOfPlayer generalInfo = playerData.getGeneralInfoOfOnePlayer(playerNormal_avg.getName());
			String league = playerData.getLeague(playerNormal_avg.getName());
			if (this.isAgeSuit(filter.getAge(), generalInfo.getAge()) && this.isLeagueSuit(filter.getLeague(), league)
					&& this.isPositionSuit(filter.getPosition(), generalInfo.getPosition()) && playerNormal_avg.getMinute() >= 15) {
				playerNormalList.add(playerNormal_avg);
			}
		}// 三个筛选条件加上一个默认的出场时间>=15
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		for (int i = 0; i < sortCells.length; i++) {
			sortFields.add(MySort.getBeanComparator(sortCells[i]));
		}
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(playerNormalList, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > playerNormalList.size()) {
			number = playerNormalList.size();
		}
		ArrayList<PlayerNormalInfo_Expand> resultList = new ArrayList<PlayerNormalInfo_Expand>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(playerNormalList.get(i));
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_tot(int number, final Filter filter,final SortCell[] sortCells) {
		ArrayList<PlayerNormalInfo_Expand> playerNormalList = new ArrayList<PlayerNormalInfo_Expand>(512);
		for (Entry<String, PlayerNormalInfo_Expand> temp : CACHE.PLAYER_NORMAL.entrySet()) {
			PlayerNormalInfo_Expand playerNormal = temp.getValue();
			PlayerInfoDataService playerData = PlayerInfoData.getInstance();
			GeneralInfoOfPlayer generalInfo = playerData.getGeneralInfoOfOnePlayer(playerNormal.getName());
			String league = playerData.getLeague(playerNormal.getName());
			double averageMinute = playerNormal.getMinute() / playerNormal.getNumOfGame();
			if (this.isAgeSuit(filter.getAge(), generalInfo.getAge()) && this.isLeagueSuit(filter.getLeague(), league)
					&& this.isPositionSuit(filter.getPosition(), generalInfo.getPosition()) && averageMinute >= 15) {
				playerNormalList.add(playerNormal);
			}
		}// 三个筛选条件加上一个默认的出场时间>=15
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		for (int i = 0; i < sortCells.length; i++) {
			sortFields.add(MySort.getBeanComparator(sortCells[i]));
		}
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(playerNormalList, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > playerNormalList.size()) {
			number = playerNormalList.size();
		}

		ArrayList<PlayerNormalInfo_Expand> resultList = new ArrayList<PlayerNormalInfo_Expand>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(playerNormalList.get(i));
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_avg(CombineSelectionCell[] combineSelectionCells) {
		ArrayList<PlayerNormalInfo_Expand> playerNormalList = new ArrayList<PlayerNormalInfo_Expand>(512);
		for (Entry<String, PlayerNormalInfo_Expand> temp : CACHE.PLAYER_NORMAL.entrySet()) {
			PlayerNormalInfo_Expand playerNormal_avg = temp.getValue().getPlayerNormal_avg();
			boolean isSuit = true;
			for (int i = 0; i < combineSelectionCells.length; i++) {
				CombineSelectionCell tempCell = combineSelectionCells[i];
				String tempField = tempCell.getField();
				double tempNum = tempCell.getNumber();
				if (tempField.equals(Field.point)) {
					if (playerNormal_avg.getPoint() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.rebound)) {
					if (playerNormal_avg.getRebound() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.assist)) {
					if (playerNormal_avg.getAssist() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.steal)) {
					if (playerNormal_avg.getSteal() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.blockShot)) {
					if (playerNormal_avg.getBlockShot() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.defendRebound)) {
					if (playerNormal_avg.getDefend() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.offendRebound)) {
					if (playerNormal_avg.getOffend() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.minute)) {
					if (playerNormal_avg.getMinute() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.penalty)) {
					if (playerNormal_avg.getPenalty() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.shot)) {
					if (playerNormal_avg.getShot() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else if (tempField.equals(Field.three)) {
					if (playerNormal_avg.getThree() < tempNum) {
						isSuit = false;
						break;
					}
				}
				else {
					isSuit = false;
					break;
				}
			}
			if (isSuit) {
				playerNormalList.add(playerNormal_avg);
			}
			ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
			for (int i = 0; i < combineSelectionCells.length; i++) {
				sortFields.add(MySort.getBeanComparator(new SortCell(combineSelectionCells[i].getField() + Command.dot + Command.descend)));
			}
			ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
			Collections.sort(playerNormalList, comChain);// 开始真正的排序，按照先主，后副的规则
		}
		int number = NUMBER.DEFAULT_NUMBER;
		if (playerNormalList.size() < number) {
			number = playerNormalList.size();
		}
		ArrayList<PlayerNormalInfo_Expand> resultList = new ArrayList<PlayerNormalInfo_Expand>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(playerNormalList.get(i));
		}
		return resultList;
	}

	private boolean isAgeSuit(String AgeFilter, int age) {
		if (AgeFilter.equals(Age.All)) {
			return true;
		}
		else if (AgeFilter.equals(Age.M_22_L_E_25)) {
			if (age > 22 && age <= 25) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (AgeFilter.equals(Age.M_25_L_E_30)) {
			if (age > 25 && age <= 30) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (AgeFilter.equals(Age.L_E_22)) {
			if (age <= 22) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (AgeFilter.equals(Age.M_30)) {
			if (age >= 30) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	private boolean isLeagueSuit(String leagueFilter, String league) {
		if (leagueFilter.equals(League.All)) {
			return true;
		}
		else if (leagueFilter.equals(league)) {
			return true;
		}
		else {
			return false;
		}
	}

	private boolean isPositionSuit(String positionFilter, String position) {
		if (positionFilter.equals(Position.All)) {
			return true;
		}
		else if (positionFilter.equals(position)) {
			return true;
		}
		else if (position.contains(positionFilter)) {
			return true;
		}
		else {
			return false;
		}
	}
}
