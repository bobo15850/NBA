package businesslogic.players;

import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import vo.GeneralInfoOfPlayerVo;
import vo.GeneralInfoOfTeamVo;
import vo.OnePlayerPerformOfOneSeasonVo;
import businesslogic.teams.CalculationOfTeamPerform;
import businesslogicservice.players.PlayerInfoBlService;

import common.enums.Conference;
import common.enums.Division;
import common.enums.PerformanceOfPlayer;
import common.enums.PlayerPosition;
import common.mydatastructure.Season;
import common.mydatastructure.SelectionCondition;
import common.statics.ResultMessage;

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
		ArrayList<OnePlayerPerformOfOneSeasonVo> resultList = new ArrayList<OnePlayerPerformOfOneSeasonVo>();
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
		ArrayList<PlayerPerformanceOfOneMatchPo> PlayerPerformPoList = this.playerInfoData
				.getOnePlayerPerformOfOneSeasonPo(nameOfPlayer, season);
		ArrayList<TeamPerformanceOfOneMatchPo[]> TeamPerFormPoList = this.playerInfoData.getOneTeamPerformOfOneSeason(
				nameOfPlayer, season);

		if (PlayerPerformPoList.size() == 0) {
			return null;// 返回值为null表示该球员未参加一场比赛
		} else {
			OnePlayerPerformOfOneSeasonVo resultVo = new OnePlayerPerformOfOneSeasonVo();
			String nameOfTeam = PlayerPerformPoList.get(0).getTeamName();// 球队名称
			int numberOfMatch = PlayerPerformPoList.size();// 比赛场数
			int numberOfFirst = 0;// 先发场数
			// 总命中数
			int totalHitNumber = 0;
			// 总出手数
			int totalShootNumber = 0;
			// 三分命中数
			int threePointHitNumber = 0;
			// 三分出手数
			int threePointShootNumber = 0;
			// 罚球命中数
			int freePointHitNumber = 0;
			// 罚球出手数
			int freePointShootNumber = 0;
			// 球队所有球员上场时间
			int timeOfAllPlayer = 0;
			// 球队所有篮板数
			int totalReboundOfTeam = 0;
			// 对手所有篮板数
			int totalReboundOfCompetitor = 0;
			// 球队所有命中数
			int hitOfAllPlayer = 0;
			// 球队所有出手数
			int shootOfAllPlayer = 0;
			// 球队所有罚球数
			int freePointOfAllPlayer = 0;
			// 球队所有失误数
			int turnoverOfAllPlayer = 0;
			// 对手进攻数
			int offensiveReboundOfCompetitor = 0;
			// 对手总命中数
			// int hitNumOfCompetitor=0;
			// 对手总出手数
			int shootNumOfCompetitor = 0;
			// 对手三分命中数
			// int threePointHitOfCompetitor=0;
			// 对手三分出手数
			int threePointShootOfCompetitor = 0;
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
			int doubleDouble = 0;// 两双数
			int tripleDouble = 0;// 三双数

			int doubleOfOneMatch = 0;
			for (int i = 0; i < PlayerPerformPoList.size(); i++) {
				tempMatch = PlayerPerformPoList.get(i);
				if (tempMatch.getIsFirst()) {
					numberOfFirst++;
				}
				totalHitNumber += tempMatch.getTotalHitNumber();
				totalShootNumber += tempMatch.getTotalShootNumber();
				threePointHitNumber += tempMatch.getThreePointHitNumber();
				threePointShootNumber += tempMatch.getThreePointShootNumber();
				freePointHitNumber += tempMatch.getFreePointHitNumber();
				freePointShootNumber += tempMatch.getFreePointShootNumber();
				totalReboundNumber += tempMatch.getTotalReboundNumber();
				assistNumber += tempMatch.getAssistNumber();
				playingTime += tempMatch.getPlayingTime();
				stealNumber += tempMatch.getStealNumber();
				blockNumber += tempMatch.getBlockNumber();
				turnoverNumber += tempMatch.getTurnoverNumber();
				foulNumber += tempMatch.getFoulNumber();
				scoreNumber += tempMatch.getScoreNumber();
				offensiveReboundNumber += tempMatch.getOffensiveReboundNumber();
				defensiveReboundNumber += tempMatch.getDefensiveReboundNumber();

				if (tempMatch.getScoreNumber() >= 9.9) {
					doubleOfOneMatch++;
				}
				if (tempMatch.getTotalReboundNumber() >= 9.9) {
					doubleOfOneMatch++;
				}
				if (tempMatch.getAssistNumber() >= 9.9) {
					doubleOfOneMatch++;
				}
				if (tempMatch.getBlockNumber() >= 9.9) {
					doubleOfOneMatch++;
				}
				if (tempMatch.getStealNumber() >= 9.9) {
					doubleOfOneMatch++;
				}
			}
			if (doubleOfOneMatch == 2) {
				doubleDouble++;
			} else if (doubleOfOneMatch == 3) {
				tripleDouble++;
			}
			for (int i = 0; i < TeamPerFormPoList.size(); i++) {
				TeamPerformanceOfOneMatchPo selfTeam = TeamPerFormPoList.get(i)[0];
				TeamPerformanceOfOneMatchPo opponentTeam = TeamPerFormPoList.get(i)[1];

				timeOfAllPlayer += selfTeam.getPlayingTime();
				totalReboundOfTeam += selfTeam.getTotalReboundNumber();
				freePointOfAllPlayer += selfTeam.getFoulNumber();
				turnoverOfAllPlayer += selfTeam.getTurnoverNumber();
				hitOfAllPlayer += selfTeam.getTotalHitNumber();

				totalReboundOfCompetitor += opponentTeam.getTotalReboundNumber();
				offensiveReboundOfCompetitor += opponentTeam.getOffensiveReboundNumber();
				shootNumOfCompetitor += opponentTeam.getTotalShootNumber();
				threePointShootOfCompetitor += opponentTeam.getThreePointShootNumber();
			}
			// 球队名称
			resultVo.setNameOfTeam(nameOfTeam);
			// 球员名称
			resultVo.setNameOfPlayer(nameOfPlayer);
			// 比赛场数
			resultVo.setNumberOfMatch(numberOfMatch);
			// 先发场数
			resultVo.setNumberOfFirst(numberOfFirst);
			// 总篮板数
			resultVo.setTotalReboundNumber(totalReboundNumber);
			// 总助攻
			resultVo.setAssistNumber(assistNumber);
			// 总上场时间
			resultVo.setPlayingTime(CalculationOfPlayerPerform.cutToTwo(playingTime));
			// 总抢断数
			resultVo.setStealNumber(stealNumber);
			// 总盖帽数
			resultVo.setBlockNumber(blockNumber);
			// 总失误数
			resultVo.setTurnoverNumber(turnoverNumber);
			// 总犯规数
			resultVo.setFoulNumber(foulNumber);
			// 总得分
			resultVo.setScoreNumber(scoreNumber);
			// 进攻篮板数
			resultVo.setOffensiveReboundNumber(offensiveReboundNumber);
			// 防守篮板数
			resultVo.setDefensiveReboundNumber(defensiveReboundNumber);
			// 场均总篮板
			resultVo.setAverageTotalReboundNumber(CalculationOfTeamPerform.average(totalReboundNumber, numberOfMatch));
			// 场均助攻数
			resultVo.setAverageAssistNumber(CalculationOfTeamPerform.average(assistNumber, numberOfMatch));
			// 场均上场时间
			resultVo.setAveragePlayingTime(CalculationOfTeamPerform.average(playingTime, numberOfMatch));
			// 场均抢断数
			resultVo.setAverageStealNumber(CalculationOfTeamPerform.average(stealNumber, numberOfMatch));
			// 场均盖帽数
			resultVo.setAverageBlockNumber(CalculationOfTeamPerform.average(blockNumber, numberOfMatch));
			// 场均失误数
			resultVo.setAverageTurnoverNumber(CalculationOfTeamPerform.average(turnoverNumber, numberOfMatch));
			// 场均犯规数
			resultVo.setAverageFoulNumber(CalculationOfTeamPerform.average(foulNumber, numberOfMatch));
			// 场均得分数
			resultVo.setAverageScoreNumber(CalculationOfTeamPerform.average(scoreNumber, numberOfMatch));
			// 场均进攻篮板数
			resultVo.setAverageOffensiveReboundNumber(CalculationOfTeamPerform.average(offensiveReboundNumber,
					numberOfMatch));
			// 场均防守篮板数
			resultVo.setAverageDefensiveReboundNumber(CalculationOfTeamPerform.average(defensiveReboundNumber,
					numberOfMatch));
			// 投篮命中率
			resultVo.setTotalHitRate(CalculationOfPlayerPerform.calHitRate(totalHitNumber, totalShootNumber));
			// 三分命中率
			resultVo.setThreePointHitRate(CalculationOfPlayerPerform.calHitRate(threePointHitNumber,
					threePointShootNumber));
			// 罚球命中率
			resultVo.setFreePointHitRate(CalculationOfPlayerPerform
					.calHitRate(freePointHitNumber, freePointShootNumber));
			// 效率
			resultVo.setCommonEfficiency(CalculationOfPlayerPerform.calCommonEfficiency(scoreNumber,
					totalReboundNumber, assistNumber, assistNumber, blockNumber, totalShootNumber, totalHitNumber,
					freePointShootNumber, freePointHitNumber, turnoverNumber, numberOfMatch));
			// GmSc效率
			resultVo.setGmScEfficiency(CalculationOfPlayerPerform.calGmScEfficiency(scoreNumber, totalHitNumber,
					totalShootNumber, freePointShootNumber, freePointHitNumber, offensiveReboundNumber,
					defensiveReboundNumber, stealNumber, assistNumber, blockNumber, foulNumber, turnoverNumber,
					numberOfMatch));
			// 真实命中率
			resultVo.setRealHitRate(CalculationOfPlayerPerform.calRealHitRate(scoreNumber, totalShootNumber,
					freePointShootNumber));
			// 投篮效率
			resultVo.setShootEfficiency(CalculationOfPlayerPerform.calShootEfficiency(totalHitNumber,
					threePointHitNumber, totalShootNumber));
			// 篮板效率
			resultVo.setReboundEfficiency(CalculationOfPlayerPerform.calReboundRate(totalReboundNumber,
					timeOfAllPlayer, playingTime, totalReboundOfTeam, totalReboundOfCompetitor));
			// 进攻篮板率
			resultVo.setOffensiveReboundRate(CalculationOfPlayerPerform.calReboundRate(offensiveReboundNumber,
					timeOfAllPlayer, playingTime, totalReboundOfTeam, totalReboundOfCompetitor));
			// 防守篮板率
			resultVo.setDefensiveReboundRate(CalculationOfPlayerPerform.calReboundRate(defensiveReboundNumber,
					timeOfAllPlayer, playingTime, totalReboundOfTeam, totalReboundOfCompetitor));

			// 助攻率
			resultVo.setAssistRate(CalculationOfPlayerPerform.calAssistRate(assistNumber, playingTime, timeOfAllPlayer,
					hitOfAllPlayer, totalHitNumber));
			// 抢断率
			resultVo.setStealRate(CalculationOfPlayerPerform.calStealRate(stealNumber, timeOfAllPlayer, playingTime,
					offensiveReboundOfCompetitor));
			// 盖帽率
			resultVo.setBlockRate(CalculationOfPlayerPerform.calBlockRate(blockNumber, timeOfAllPlayer, playingTime,
					shootNumOfCompetitor - threePointShootOfCompetitor));
			// 失误率
			resultVo.setTurnoverRate(CalculationOfPlayerPerform.calTurnoverRate(turnoverNumber, totalShootNumber
					- threePointShootNumber, freePointShootNumber));
			// 使用率
			resultVo.setUseRate(CalculationOfPlayerPerform.calUseRate(totalShootNumber, freePointShootNumber,
					turnoverNumber, timeOfAllPlayer, playingTime, shootOfAllPlayer, freePointOfAllPlayer,
					turnoverOfAllPlayer));
			// 两双
			resultVo.setDoubleDouble(doubleDouble);
			// 三双
			resultVo.setTripleDouble(tripleDouble);
			// 得分篮板助攻比
			int scoreReboundAssitRate = 0;// 得分篮板助攻比
			scoreReboundAssitRate = scoreNumber + totalReboundNumber + assistNumber;
			resultVo.setScoreReboundAssistRate(scoreReboundAssitRate);
			int averageScoreReboundAssitRate = 0;// 平均得分篮板助攻比
			averageScoreReboundAssitRate = scoreReboundAssitRate / numberOfMatch;
			resultVo.setAveragescoreReboundAssistRate(averageScoreReboundAssitRate);
			return resultVo;
		}

	}// 查找某一球员在某一赛季的比赛信息

	public GeneralInfoOfPlayerVo getGeneralInfoOfOnePlayer(String nameOfPlayer) {
		GeneralInfoOfPlayerPo po = this.playerInfoData.getGeneralInfoOfOnePlayer(nameOfPlayer);
		GeneralInfoOfPlayerVo resultVo = new GeneralInfoOfPlayerVo(po);
		return resultVo;
	}// 根据球员姓名查找某一球员具体基本自然信息

	public void ascendingSort(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {
		int left = 0;
		int right = voList.size();
		switch (dataKind) {
		case PlayerName: {
			for (int i = 0; i < voList.size(); i++) {
				for (int j = 0; j < voList.size() - i - 1; j++) {
					OnePlayerPerformOfOneSeasonVo temp = null;
					if (voList.get(j).getNameOfPlayer().compareTo(voList.get(j + 1).getNameOfPlayer()) > 0) {
						temp = voList.get(j);
						voList.set(j, voList.get(j + 1));
						voList.set(j + 1, temp);
					}
				}
			}
			break;
		}
		case TeamName: {
			for (int i = 0; i < voList.size(); i++) {
				for (int j = 0; j < voList.size() - i - 1; j++) {
					OnePlayerPerformOfOneSeasonVo temp = null;
					if (voList.get(j).getNameOfTeam().compareTo(voList.get(j + 1).getNameOfTeam()) > 0) {
						temp = voList.get(j);
						voList.set(j, voList.get(j + 1));
						voList.set(j + 1, temp);
					}
				}
			}
			break;
		}
		case MatchNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.MatchNumber(), left, right - 1);
			break;
		case FirstNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.FirstNumber(), left, right - 1);
			break;
		case TotalRebondNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TotalRebondNumber(), left, right - 1);
			break;
		case TotalAssistNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TotalAssistNumber(), left, right - 1);
			break;
		case TotalPlayingTime:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TotalPlayingTime(), left, right - 1);
			break;
		case TotalStealNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TotalStealNumber(), left, right - 1);
			break;
		case TotalTurnoverNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TotalTurnoverNumber(), left, right - 1);
			break;
		case TotalFoulNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TotalFoulNumber(), left, right - 1);
			break;
		case ScoreNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.ScoreNumber(), left, right - 1);
			break;
		case OffensiveRebondNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.OffensiveRebondNumber(), left, right - 1);
			break;
		case DeffensiveRebondNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.DeffensiveRebondNumber(), left, right - 1);
			break;
		case AverageTotalReboundNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageTotalReboundNumber(), left, right - 1);
			break;
		case AverageAssistNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageAssistNumber(), left, right - 1);
			break;
		case AveragePlayingTime:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AveragePlayingTime(), left, right - 1);
			break;
		case AverageStealNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageStealNumber(), left, right - 1);
			break;
		case AverageBlockNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageBlockNumber(), left, right - 1);
			break;
		case AverageTurnoverNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageTurnoverNumber(), left, right - 1);
			break;
		case AverageFoulNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageFoulNumber(), left, right - 1);
			break;
		case AverageScoreNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageScoreNumber(), left, right - 1);
			break;
		case AverageOffensiveReboundNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageOffensiveReboundNumber(), left, right - 1);
			break;
		case AverageDefensiveReboundNumber:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageDefensiveReboundNumber(), left, right - 1);
			break;
		case TotalHitRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TotalHitRate(), left, right - 1);
			break;
		case ThreePointHitRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.ThreePointHitRate(), left, right - 1);
			break;
		case FreePointHitRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.FreePointHitRate(), left, right - 1);
			break;
		case CommonEfficiency:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.CommonEfficiency(), left, right - 1);
			break;
		case GmScEfficiency:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.GmScEfficiency(), left, right - 1);
			break;
		case RealHitRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.RealHitRate(), left, right - 1);
			break;
		case ShootEfficiency:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.ShootEfficiency(), left, right - 1);
			break;
		case ReboundEfficiency:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.ReboundEfficiency(), left, right - 1);
			break;
		case OffensiveReboundRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.OffensiveReboundRate(), left, right - 1);
			break;
		case DefensiveReboundRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.DefensiveReboundRate(), left, right - 1);
			break;
		case AssistRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AssistRate(), left, right - 1);
			break;
		case StealRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.StealRate(), left, right - 1);
			break;
		case BlockRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.BlockRate(), left, right - 1);
			break;
		case TurnoverRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TurnoverRate(), left, right - 1);
			break;
		case UseRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.UseRate(), left, right - 1);
			break;
		case DoubleDouble:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.DoubleDouble(), left, right - 1);
			break;
		case TripleDouble:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.TripleDouble(), left, right - 1);
			break;
		case AverageScoreReboundAssistRate:
			SortOfPlayer.sortAscending(voList, new SortOfPlayer.AverageScoreReboundAssistRate(), left, right - 1);
			break;
		default:
			break;
		}
	}// 根据某一项将所有球员某一赛季成绩升序排序

	public void descendingSort(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {
		int left = 0;
		int right = voList.size();
		switch (dataKind) {
		case PlayerName: {
			for (int i = 0; i < voList.size(); i++) {
				for (int j = 0; j < voList.size() - i - 1; j++) {
					OnePlayerPerformOfOneSeasonVo temp = null;
					if (voList.get(j).getNameOfPlayer().compareTo(voList.get(j + 1).getNameOfPlayer()) < 0) {
						temp = voList.get(j);
						voList.set(j, voList.get(j + 1));
						voList.set(j + 1, temp);
					}
				}
			}
			break;
		}
		case TeamName: {
			for (int i = 0; i < voList.size(); i++) {
				for (int j = 0; j < voList.size() - i - 1; j++) {
					OnePlayerPerformOfOneSeasonVo temp = null;
					if (voList.get(j).getNameOfTeam().compareTo(voList.get(j + 1).getNameOfTeam()) < 0) {
						temp = voList.get(j);
						voList.set(j, voList.get(j + 1));
						voList.set(j + 1, temp);
					}
				}
			}
			break;
		}
		case MatchNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.MatchNumber(), left, right - 1);
			break;
		case FirstNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.FirstNumber(), left, right - 1);
			break;
		case TotalRebondNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TotalRebondNumber(), left, right - 1);
			break;
		case TotalAssistNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TotalAssistNumber(), left, right - 1);
			break;
		case TotalPlayingTime:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TotalPlayingTime(), left, right - 1);
			break;
		case TotalStealNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TotalStealNumber(), left, right - 1);
			break;
		case TotalTurnoverNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TotalTurnoverNumber(), left, right - 1);
			break;
		case TotalFoulNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TotalFoulNumber(), left, right - 1);
			break;
		case ScoreNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.ScoreNumber(), left, right - 1);
			break;
		case OffensiveRebondNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.OffensiveRebondNumber(), left, right - 1);
			break;
		case DeffensiveRebondNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.DeffensiveRebondNumber(), left, right - 1);
			break;
		case AverageTotalReboundNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageTotalReboundNumber(), left, right - 1);
			break;
		case AverageAssistNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageAssistNumber(), left, right - 1);
			break;
		case AveragePlayingTime:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AveragePlayingTime(), left, right - 1);
			break;
		case AverageStealNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageStealNumber(), left, right - 1);
			break;
		case AverageBlockNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageBlockNumber(), left, right - 1);
			break;
		case AverageTurnoverNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageTurnoverNumber(), left, right - 1);
			break;
		case AverageFoulNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageFoulNumber(), left, right - 1);
			break;
		case AverageScoreNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageScoreNumber(), left, right - 1);
			break;
		case AverageOffensiveReboundNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageOffensiveReboundNumber(), left, right - 1);
			break;
		case AverageDefensiveReboundNumber:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageDefensiveReboundNumber(), left, right - 1);
			break;
		case TotalHitRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TotalHitRate(), left, right - 1);
			break;
		case ThreePointHitRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.ThreePointHitRate(), left, right - 1);
			break;
		case FreePointHitRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.FreePointHitRate(), left, right - 1);
			break;
		case CommonEfficiency:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.CommonEfficiency(), left, right - 1);
			break;
		case GmScEfficiency:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.GmScEfficiency(), left, right - 1);
			break;
		case RealHitRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.RealHitRate(), left, right - 1);
			break;
		case ShootEfficiency:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.ShootEfficiency(), left, right - 1);
			break;
		case ReboundEfficiency:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.ReboundEfficiency(), left, right - 1);
			break;
		case OffensiveReboundRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.OffensiveReboundRate(), left, right - 1);
			break;
		case DefensiveReboundRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.DefensiveReboundRate(), left, right - 1);
			break;
		case AssistRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AssistRate(), left, right - 1);
			break;
		case StealRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.StealRate(), left, right - 1);
			break;
		case BlockRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.BlockRate(), left, right - 1);
			break;
		case TurnoverRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TurnoverRate(), left, right - 1);
			break;
		case UseRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.UseRate(), left, right - 1);
			break;
		case DoubleDouble:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.DoubleDouble(), left, right - 1);
			break;
		case TripleDouble:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.TripleDouble(), left, right - 1);
			break;
		case ScoreReboundAssistRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.ScoreReboundAssistRate(), left, right - 1);
			break;
		case AverageScoreReboundAssistRate:
			SortOfPlayer.sortDescending(voList, new SortOfPlayer.AverageScoreReboundAssistRate(), left, right - 1);
			break;
		default:
			break;
		}
	}// 根据某一项将所有球员某一赛季成绩降序排序

	public ArrayList<OnePlayerPerformOfOneSeasonVo> selsctPlayer(ArrayList<OnePlayerPerformOfOneSeasonVo> voList,
			SelectionCondition condition, Season season) {
		ArrayList<OnePlayerPerformOfOneSeasonVo> tempVoList = new ArrayList<OnePlayerPerformOfOneSeasonVo>(64);
		PlayerPosition position = condition.getPosition();// 位置
		Conference conference = condition.getConference();// 赛区
		Division division = condition.getDivision();// 联盟
		PerformanceOfPlayer performance = condition.getPerformance();// 排序依据
		for (int i = 0; i < voList.size(); i++) {
			OnePlayerPerformOfOneSeasonVo tempPlayer = voList.get(i);
			GeneralInfoOfPlayerVo infoOfPlayer = getGeneralInfoOfOnePlayer(tempPlayer.getNameOfPlayer());
			GeneralInfoOfTeamVo infoOfTeam = null;
			if (infoOfPlayer.equals(ResultMessage.NOTEXIST_GENERAL_PLAYER_VO)) {
				continue;
			} else {
				if (position != null && position != infoOfPlayer.getPosition()) {
					continue;
				} else {
					infoOfTeam = new GeneralInfoOfTeamVo(playerInfoData.getGeneralInfoOfOneTeam(
							tempPlayer.getNameOfPlayer(), season));
					if (conference != null && infoOfTeam.getConference() != conference) {
						continue;
					} else {
						if (division != null && infoOfTeam.getDivision() != division) {
							continue;
						} else {
							tempVoList.add(tempPlayer);
						}
					}
				}
			}
		}
		this.descendingSort(tempVoList, performance);
		return tempVoList;
	}
}
