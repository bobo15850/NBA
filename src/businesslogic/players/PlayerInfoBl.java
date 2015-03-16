package businesslogic.players;

import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import vo.GeneralInfoOfPlayerVo;
import vo.OnePlayerPerformOfOneSeasonVo;
import businesslogicservice.players.PlayerInfoBlService;
import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;
import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

/*
 * 该类为球员信息管理的业务逻辑类运用相应的data层接口为界面层提供接口，
 */
public class PlayerInfoBl implements PlayerInfoBlService {
	private PlayerInfoDataService playerInfoData;// 数据层的引用

	public PlayerInfoBl() {
		this.playerInfoData = new PlayerInfoData();
	}

	public ArrayList<OnePlayerPerformOfOneSeasonVo> getOneSeasonPerformOfAllPlayer(Season season) {
		ArrayList<String> namesOfAllPlayer = this.playerInfoData.getNamesOfAllPlayer();
		ArrayList<OnePlayerPerformOfOneSeasonVo> resultList = new ArrayList<OnePlayerPerformOfOneSeasonVo>(512);
		OnePlayerPerformOfOneSeasonVo tempOfOnePlayerVo;
		String tempName;
		for (int i = 0; i < namesOfAllPlayer.size(); i++) {
			tempName = namesOfAllPlayer.get(i);
			tempOfOnePlayerVo = this.getOnePlayerPerformOfOneSeason(tempName, season);
			resultList.add(tempOfOnePlayerVo);
		}
		return resultList;
	}// 获取某一个赛季所有球员的比赛信息

	public ArrayList<OnePlayerPerformOfOneSeasonVo> getOnePlayerPerformOfAllSeason(String nameOfPlayer) {
		return null;
	}// 根据某一球员姓名查找其所有赛季比赛信息

	public OnePlayerPerformOfOneSeasonVo getOnePlayerPerformOfOneSeason(String nameOfPlayer, Season season) {
		ArrayList<PlayerPerformanceOfOneMatchPo> poList = this.playerInfoData.getOnePlayerPerformOfOneSeasonPo(nameOfPlayer, season);
		if (poList.size() == 0) {
			return null;// 返回值为null表示该球员未参加一场比赛
		} else {
			OnePlayerPerformOfOneSeasonVo resultVo = new OnePlayerPerformOfOneSeasonVo();
			String nameOfTeam;// 球队名称
			int numberOfMatch = poList.size();// 比赛场数
			int numberOfFirst = 0;// 先发场数
			int totalReboundNumber = 0;// 总篮板
			int assistNumber = 0;// 总助攻
			double playingTime = 0;// 总上场时间
			int stealNumber = 0;// 总抢断数
			int blockNumber = 0;// 总 盖帽数
			int turnoverNumber = 0;// 总失误数
			int foulNumber = 0;// 总犯规数
			int scoreNumber = 0;// 总得分数
			int offensiveReboundNumber = 0;// 进攻篮板数
			int defensiveReboundNumber = 0;// 防守篮板数
			PlayerPerformanceOfOneMatchPo tempMatch;
			for (int i = 0; i < poList.size(); i++) {
				tempMatch = poList.get(i);
				if (tempMatch.getIsFirst()) {
					numberOfFirst++;
				}
				totalReboundNumber += tempMatch.getTotalReboundNumber();
				assistNumber += tempMatch.getAssistNumber();
				playingTime = tempMatch.getPlayingTime();
				stealNumber = tempMatch.getStealNumber();
				blockNumber = tempMatch.getBlockNumber();
				turnoverNumber = tempMatch.getTurnoverNumber();
				foulNumber = tempMatch.getFoulNumber();
				scoreNumber = tempMatch.getScoreNumber();
				offensiveReboundNumber = tempMatch.getOffensiveReboundNumber();
				defensiveReboundNumber = tempMatch.getDefensiveReboundNumber();
			}
			return resultVo;
		}

	}// 查找某一球员在某一赛季的比赛信息

	public GeneralInfoOfPlayerVo getBaseInformationOfOnePlayer(String nameOfPlayer) {
		GeneralInfoOfPlayerPo po = this.playerInfoData.getBaseInformationOfOnePlayer(nameOfPlayer);
		GeneralInfoOfPlayerVo resultVo = new GeneralInfoOfPlayerVo(po);
		return resultVo;
	}// 根据球员姓名查找某一球员具体基本自然信息

	public void ascendingSort(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {

	}// 根据某一项将所有球员某一赛季成绩升序排序

	public void descendingSort(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {

	}// 根据某一项将所有球员某一赛季成绩降序排序

}
