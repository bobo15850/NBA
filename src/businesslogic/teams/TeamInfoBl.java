package businesslogic.teams;

import java.util.ArrayList;

import po.GeneralInfoOfTeamPo;
import po.TeamPerformanceOfOneMatchPo;
import vo.GeneralInfoOfTeamVo;
import vo.OneTeamPerformOfOneSeasonVo;
import businesslogic.players.CalculationOfPlayerPerform;
import businesslogicservice.teams.TeamInfoBlService;

import common.enums.PerformanceOfTeam;
import common.mydatastructure.Season;

import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoBl implements TeamInfoBlService {
	private TeamInfoDataService teamInfoData;

	public TeamInfoBl() {
		teamInfoData = new TeamInfoData();
	}

	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneSeasonPerformOfAllTeam(Season season) {
		ArrayList<OneTeamPerformOfOneSeasonVo> resultVo = new ArrayList<OneTeamPerformOfOneSeasonVo>(32);
		ArrayList<String> nameOfAllTeam = this.teamInfoData.getNamesForShortOfAllTeam();
		OneTeamPerformOfOneSeasonVo tempOfOneTeamVo;
		String tempName;
		for (int i = 0; i < nameOfAllTeam.size(); i++) {
			tempName = nameOfAllTeam.get(i);
			tempOfOneTeamVo = this.getOneTeamPerformOfOneSeason(tempName, season);
			resultVo.add(tempOfOneTeamVo);
		}
		return resultVo;
	}// 获取某一个赛季所有球队的比赛信息

	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneTeamPerformOfAllSeason(String teamName) {
		return null;
	}// 根据某一球队名称查找其所有赛季比赛信息

	public OneTeamPerformOfOneSeasonVo getOneTeamPerformOfOneSeason(String teamName, Season season) {
		ArrayList<TeamPerformanceOfOneMatchPo[]> poList = this.teamInfoData.getOneTeamPerformOfOneSeason(teamName,
				season);
		if (poList == null) {
			return null;
		} else {
			OneTeamPerformOfOneSeasonVo resultVo = new OneTeamPerformOfOneSeasonVo();
			int numberOfMatch = 0;// 比赛场数
			int winNumber = 0;// 胜利场数
			int totalHitNumber = 0;// 总命中数
			int totalShootNumber = 0;// 总出手数
			int threePointHitNumber = 0;// 三分命中数
			int threePointShootNumber = 0;// 三分出手数
			int freePointHitNumber = 0;// 罚球命中数
			int freePointShootNumber = 0;// 罚球出手数
			int offensiveReboundNumber = 0;// 进攻篮板数
			int defensiveReboundNumber = 0;// 防守篮板数

			int defensiveReboundOfCompetitor = 0;// 对手的防守篮板数
			int totalReboundNumber = 0;// 总篮板
			int assistNumber = 0;// 总助攻
			int stealNumber = 0;// 抢断数
			int blockNumber = 0;// 盖帽数
			int turnoverNumber = 0;// 失误数
			int foulNumber = 0;// 犯规数
			int scoreNumber = 0;// 得分数
			double offensiveNumber = 0;// 进攻回合数
			int scoreOfCompetitor = 0;// 对手得分
			int shootOfCompetitor = 0;// 对手总出手数
			int foulOfCompetitor = 0;// 对手犯规数
			int offensiveReboundOfCompetitor = 0;// 对手进攻篮板数
			int hitOfCompetitor = 0;// 对手总命中数
			int turnoverOfCompetitor = 0;// 对手失误数

			for (int i = 0; i < poList.size(); i++) {
				numberOfMatch++;
				TeamPerformanceOfOneMatchPo ourSide = poList.get(i)[0];
				TeamPerformanceOfOneMatchPo competitor = poList.get(i)[1];
				if (ourSide.getScoreNumber() > competitor.getScoreNumber()) {
					winNumber++;
				}
				totalHitNumber += ourSide.getTotalHitNumber();
				totalShootNumber += ourSide.getTotalShootNumber();
				threePointHitNumber += ourSide.getThreePointHitNumber();
				threePointShootNumber += ourSide.getThreePointShootNumber();
				freePointHitNumber += ourSide.getFreePointHitNumber();
				freePointShootNumber += ourSide.getFreePointShootNumber();
				offensiveReboundNumber += ourSide.getOffensiveReboundNumber();
				defensiveReboundNumber += ourSide.getDefensiveReboundNumber();
				defensiveReboundOfCompetitor += competitor.getDefensiveReboundNumber();
				totalReboundNumber += ourSide.getTotalReboundNumber();
				assistNumber += ourSide.getAssistNumber();
				stealNumber += ourSide.getStealNumber();
				blockNumber += ourSide.getBlockNumber();
				turnoverNumber += ourSide.getTurnoverNumber();
				foulNumber += ourSide.getFoulNumber();
				scoreNumber += ourSide.getScoreNumber();
				scoreOfCompetitor += competitor.getScoreNumber();
				shootOfCompetitor += competitor.getTotalShootNumber();
				foulOfCompetitor += competitor.getFoulNumber();
				offensiveReboundOfCompetitor += competitor.getOffensiveReboundNumber();
				hitOfCompetitor += competitor.getTotalHitNumber();
				turnoverOfCompetitor += competitor.getTurnoverNumber();
			}
			// 球队名称
			resultVo.setTeamName(poList.get(0)[0].getTeamNameForShort());
			// 比赛场数
			resultVo.setNumberOfMatch(numberOfMatch);
			// 投篮命中数
			resultVo.setTotalHitNumber(totalHitNumber);
			// 投篮出手数
			resultVo.setTotalShootNumber(totalShootNumber);
			// 三分命中数
			resultVo.setThreePointHitNumber(threePointHitNumber);
			// 三分出手数
			resultVo.setThreePointShootNumber(threePointShootNumber);
			// 罚球命中数
			resultVo.setFreePointHitNumber(freePointHitNumber);
			// 罚球出手数
			resultVo.setFreePointShootNumber(freePointShootNumber);
			// 进攻篮板数
			resultVo.setOffensiveReboundNumber(offensiveReboundNumber);
			// 防守篮板数
			resultVo.setDefensiveReboundNumber(defensiveReboundNumber);
			// 篮板数
			resultVo.setTotalReboundNumber(totalReboundNumber);
			// 助攻数
			resultVo.setAssistNumber(assistNumber);
			// 抢断数
			resultVo.setStealNumber(stealNumber);
			// 盖帽数
			resultVo.setBlockNumber(blockNumber);
			// 失误数
			resultVo.setTurnoverNumber(turnoverNumber);
			// 犯规数
			resultVo.setFoulNumber(foulNumber);
			// 比赛得分
			resultVo.setScoreNumber(scoreNumber);
			offensiveNumber = CalculationOfTeamPerform.calOffensiveNum(totalShootNumber, freePointShootNumber,
					offensiveReboundNumber, defensiveReboundOfCompetitor, totalShootNumber - totalHitNumber,
					turnoverNumber);
			resultVo.setOffensiveNumber(offensiveNumber);// 总进攻回合数
			// 场均命中数
			resultVo.setAverageTotalHitNumber(CalculationOfTeamPerform.average(totalHitNumber, numberOfMatch));
			// 场均总出手数
			resultVo.setAverageTotalShootNumber(CalculationOfTeamPerform.average(totalShootNumber, numberOfMatch));
			// 场均三分命中数
			resultVo.setAverageThreePointHitNumber(CalculationOfTeamPerform.average(threePointHitNumber, numberOfMatch));
			// 场均三分出手数
			resultVo.setAverageThreePointShootNumber(CalculationOfTeamPerform.average(threePointShootNumber,
					numberOfMatch));
			// 场均罚球命中数
			resultVo.setAverageFreePointHitNumber(CalculationOfTeamPerform.average(freePointHitNumber, numberOfMatch));
			// 场均罚球出手数
			resultVo.setAverageFreePointShootNumber(CalculationOfTeamPerform.average(freePointShootNumber,
					numberOfMatch));
			// 场均进攻篮板数
			resultVo.setAverageOffensiveReboundNumber(CalculationOfTeamPerform.average(offensiveReboundNumber,
					numberOfMatch));
			// 场均防守篮板数
			resultVo.setAverageDefensiveReboundNumber(CalculationOfTeamPerform.average(defensiveReboundNumber,
					numberOfMatch));
			// 场均总篮板
			resultVo.setAverageTotalReboundNumber(CalculationOfTeamPerform.average(totalReboundNumber, numberOfMatch));
			// 场均助攻数
			resultVo.setAverageAssistNumber(CalculationOfTeamPerform.average(assistNumber, numberOfMatch));
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
			// 场均进攻回合
			resultVo.setAverageOffensiveNumber(CalculationOfTeamPerform.average(offensiveNumber, numberOfMatch));
			// 投篮命中率
			resultVo.setTotalHitRate(CalculationOfPlayerPerform.calHitRate(totalHitNumber, totalShootNumber));
			// 三分命中率
			resultVo.setThreePointHitRate(CalculationOfPlayerPerform.calHitRate(threePointHitNumber,
					threePointShootNumber));
			// 罚球命中率
			resultVo.setFreePointHitRate(CalculationOfPlayerPerform
					.calHitRate(freePointHitNumber, freePointShootNumber));
			// 胜率
			resultVo.setWinRate(CalculationOfTeamPerform.calWinRate(winNumber, numberOfMatch - winNumber));
			// 进攻效率
			resultVo.setOffensiveEfficiency(CalculationOfTeamPerform.calOffensiveEfficiency(scoreNumber,
					totalShootNumber, freePointShootNumber, offensiveReboundNumber, defensiveReboundOfCompetitor,
					totalShootNumber - totalHitNumber, turnoverNumber));
			// 防守效率
			resultVo.setDefensiveEfficiency(CalculationOfTeamPerform.calDefensiveEfficiency(scoreOfCompetitor,
					shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor, defensiveReboundNumber,
					shootOfCompetitor - hitOfCompetitor, turnoverOfCompetitor));
			// 篮板效率
			resultVo.setReboundEfficiency(CalculationOfTeamPerform.cutToTwo(CalculationOfTeamPerform
					.calOffensiveEfficiency(scoreNumber, totalShootNumber, freePointShootNumber,
							offensiveReboundNumber, defensiveReboundOfCompetitor, totalShootNumber - totalHitNumber,
							turnoverNumber)
					+ CalculationOfTeamPerform.calDefensiveEfficiency(scoreOfCompetitor, shootOfCompetitor,
							foulOfCompetitor, offensiveReboundOfCompetitor, defensiveReboundNumber, shootOfCompetitor
									- hitOfCompetitor, turnoverOfCompetitor)));
			// 抢断率
			resultVo.setStealEfficiency(CalculationOfTeamPerform.calStealEfficiency(stealNumber, shootOfCompetitor,
					foulOfCompetitor, offensiveReboundOfCompetitor, defensiveReboundNumber, shootOfCompetitor
							- hitOfCompetitor, turnoverOfCompetitor));
			// 助攻率
			resultVo.setAssistEfficiency(CalculationOfTeamPerform.calAssistRate(assistNumber, totalShootNumber,
					freePointShootNumber, offensiveReboundNumber, defensiveReboundOfCompetitor, totalShootNumber
							- totalHitNumber, turnoverNumber));

			return resultVo;
		}
	}// 查找某一球队在某一赛季的比赛信息

	public GeneralInfoOfTeamVo getGeneralInfoOfOneTeam(String teamName) {
		GeneralInfoOfTeamPo po = this.teamInfoData.getBaseInformationOfOneTeam(teamName);
		GeneralInfoOfTeamVo vo = new GeneralInfoOfTeamVo(po);
		return vo;
	}// 根据球队姓名查找某一球队具体基本自然信息

	public void ascendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfTeam dataKind) {
		int left = 0;
		int right = voList.size();
		switch (dataKind) {
		case teamNameForShort:// 球队名称
			// TODO
			break;
		case numberOfMatch:
			SortOfTeam.sortAscending(voList, new SortOfTeam.MatchNumber(), left, right - 1);// 比赛场数
			break;
		case totalHitNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalHitNumber(), left, right - 1);
			break;// 总命中数
		case totalShootNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalShootNumber(), left, right - 1);
			break;// 总出手数
		case threePointHitNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.ThreePointHitNumber(), left, right - 1);
			break;// 三分命中数
		case threePointShootNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.ThreePointShootNumber(), left, right - 1);
			break;// 三分出手数
		case freePointHitNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.FreePointHitNumber(), left, right - 1);
			break;// 罚球命中数
		case freePointShootNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.FreePointShootNumber(), left, right - 1);
			break;// 罚球出手数
		case offensiveReboundNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.OffensiveReboundNumber(), left, right - 1);
			break;// 进攻篮板数
		case defensiveReboundNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.DefensiveReboundNumber(), left, right - 1);
			break; // 防守篮板
		case totalReboundNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalReboundNumber(), left, right - 1);
			break;// 总篮板
		case assistNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalAssistNumber(), left, right - 1);
			break; // 总助攻
		case stealNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalStealNumber(), left, right - 1);
			break;// 抢断数
		case blockNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalBlockNumber(), left, right - 1);
			break;// 盖帽数
		case turnoverNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalTurnoverNumber(), left, right - 1);
			break; // 失误数
		case foulNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalFoulNumber(), left, right - 1);
			break;// 犯规数
		case scoreNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.ScoreNumber(), left, right - 1);
			break;// 得分数
		case offensiveNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.OffensiveNumber(), left, right - 1);
			break;// 进攻回合数
		case averageTotalHitNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageTotalHitNumber(), left, right - 1);
			break; // 场均命中数
		case averageTotalShootNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageTotalShootNumber(), left, right - 1);
			break; // 场均总出手数
		case averageThreePointHitNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageThreePointHitNumber(), left, right - 1);
			break;// 场均三分命中数
		case averageThreePointShootNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageThreePointShootNumber(), left, right - 1);
			break;// 场均三分出手数
		case averageFreePointHitNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageFreePointHitNumber(), left, right - 1);
			break;// 场均罚球命中数
		case averageFreePointShootNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageFreePointShootNumber(), left, right - 1);
			break;// 场均罚球出手数
		case averageOffensiveReboundNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageOffensiveReboundNumber(), left, right - 1);
			break;// 场均进攻篮板数
		case averageDefensiveReboundNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageDefensiveReboundNumber(), left, right - 1);
			break;// 场均防守篮板
		case averageTotalReboundNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageTotalReboundNumber(), left, right - 1);
			break; // 场均总篮板
		case averageAssistNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageAssistNumber(), left, right - 1);
			break;// 场均助攻数
		case averageStealNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageStealNumber(), left, right - 1);
			break;// 场均抢断数
		case averageBlockNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageBlockNumber(), left, right - 1);
			break; // 场均盖帽数
		case averageTurnoverNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageTurnoverNumber(), left, right - 1);
			break; // 场均失误数
		case averageFoulNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageFoulNumber(), left, right - 1);
			break; // 场均犯规数
		case averageScoreNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageScoreNumber(), left, right - 1);
			break;// 场均得分数
		case averageOffensiveNumber:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AverageOffensiveNumber(), left, right - 1);
			break;// 场均进攻回合数
		case totalHitRate:
			SortOfTeam.sortAscending(voList, new SortOfTeam.TotalHitRate(), left, right - 1);
			break; // 投篮命中率
		case threePointHitRate:
			SortOfTeam.sortAscending(voList, new SortOfTeam.ThreePointHitRate(), left, right - 1);
			break; // 三分命中率
		case freePointHitRate:
			SortOfTeam.sortAscending(voList, new SortOfTeam.FreePointHitRate(), left, right - 1);// 罚球命中率
		case winRate:
			SortOfTeam.sortAscending(voList, new SortOfTeam.WinRate(), left, right - 1);
			break; // 胜率
		case offensiveEfficiency:
			SortOfTeam.sortAscending(voList, new SortOfTeam.OffensiveEfficiency(), left, right - 1);
			break;// 进攻效率
		case defensiveEfficiency:
			SortOfTeam.sortAscending(voList, new SortOfTeam.DefensiveEfficiency(), left, right - 1);
			break; // 防守效率
		case reboundEfficiency:
			SortOfTeam.sortAscending(voList, new SortOfTeam.ReboundEfficiency(), left, right - 1);
			break;// 篮板效率
		case stealEfficiency:
			SortOfTeam.sortAscending(voList, new SortOfTeam.StealEfficiency(), left, right - 1);
			break; // 抢断率
		case assistEfficiency:
			SortOfTeam.sortAscending(voList, new SortOfTeam.AssistEfficiency(), left, right - 1);
			break; // 助攻率
		}
	}// 根据某一项将所有球队某一赛季成绩升序排序

	public void descendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfTeam dataKind) {
		int left = 0;
		int right = voList.size();
		switch (dataKind) {
		case teamNameForShort:// 球队名称
			// TODO
			break;
		case numberOfMatch:
			SortOfTeam.sortDescending(voList, new SortOfTeam.MatchNumber(), left, right - 1);// 比赛场数
			break;
		case totalHitNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalHitNumber(), left, right - 1);
			break;// 总命中数
		case totalShootNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalShootNumber(), left, right - 1);
			break;// 总出手数
		case threePointHitNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.ThreePointHitNumber(), left, right - 1);
			break;// 三分命中数
		case threePointShootNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.ThreePointShootNumber(), left, right - 1);
			break;// 三分出手数
		case freePointHitNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.FreePointHitNumber(), left, right - 1);
			break;// 罚球命中数
		case freePointShootNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.FreePointShootNumber(), left, right - 1);
			break;// 罚球出手数
		case offensiveReboundNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.OffensiveReboundNumber(), left, right - 1);
			break;// 进攻篮板数
		case defensiveReboundNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.DefensiveReboundNumber(), left, right - 1);
			break; // 防守篮板
		case totalReboundNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalReboundNumber(), left, right - 1);
			break;// 总篮板
		case assistNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalAssistNumber(), left, right - 1);
			break; // 总助攻
		case stealNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalStealNumber(), left, right - 1);
			break;// 抢断数
		case blockNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalBlockNumber(), left, right - 1);
			break;// 盖帽数
		case turnoverNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalTurnoverNumber(), left, right - 1);
			break; // 失误数
		case foulNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalFoulNumber(), left, right - 1);
			break;// 犯规数
		case scoreNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.ScoreNumber(), left, right - 1);
			break;// 得分数
		case offensiveNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.OffensiveNumber(), left, right - 1);
			break;// 进攻回合数
		case averageTotalHitNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageTotalHitNumber(), left, right - 1);
			break; // 场均命中数
		case averageTotalShootNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageTotalShootNumber(), left, right - 1);
			break; // 场均总出手数
		case averageThreePointHitNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageThreePointHitNumber(), left, right - 1);
			break;// 场均三分命中数
		case averageThreePointShootNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageThreePointShootNumber(), left, right - 1);
			break;// 场均三分出手数
		case averageFreePointHitNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageFreePointHitNumber(), left, right - 1);
			break;// 场均罚球命中数
		case averageFreePointShootNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageFreePointShootNumber(), left, right - 1);
			break;// 场均罚球出手数
		case averageOffensiveReboundNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageOffensiveReboundNumber(), left, right - 1);
			break;// 场均进攻篮板数
		case averageDefensiveReboundNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageDefensiveReboundNumber(), left, right - 1);
			break;// 场均防守篮板
		case averageTotalReboundNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageTotalReboundNumber(), left, right - 1);
			break; // 场均总篮板
		case averageAssistNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageAssistNumber(), left, right - 1);
			break;// 场均助攻数
		case averageStealNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageStealNumber(), left, right - 1);
			break;// 场均抢断数
		case averageBlockNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageBlockNumber(), left, right - 1);
			break; // 场均盖帽数
		case averageTurnoverNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageTurnoverNumber(), left, right - 1);
			break; // 场均失误数
		case averageFoulNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageFoulNumber(), left, right - 1);
			break; // 场均犯规数
		case averageScoreNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageScoreNumber(), left, right - 1);
			break;// 场均得分数
		case averageOffensiveNumber:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AverageOffensiveNumber(), left, right - 1);
			break;// 场均进攻回合数
		case totalHitRate:
			SortOfTeam.sortDescending(voList, new SortOfTeam.TotalHitRate(), left, right - 1);
			break; // 投篮命中率
		case threePointHitRate:
			SortOfTeam.sortDescending(voList, new SortOfTeam.ThreePointHitRate(), left, right - 1);
			break; // 三分命中率
		case freePointHitRate:
			SortOfTeam.sortDescending(voList, new SortOfTeam.FreePointHitRate(), left, right - 1);// 罚球命中率
		case winRate:
			SortOfTeam.sortDescending(voList, new SortOfTeam.WinRate(), left, right - 1);
			break; // 胜率
		case offensiveEfficiency:
			SortOfTeam.sortDescending(voList, new SortOfTeam.OffensiveEfficiency(), left, right - 1);
			break;// 进攻效率
		case defensiveEfficiency:
			SortOfTeam.sortDescending(voList, new SortOfTeam.DefensiveEfficiency(), left, right - 1);
			break; // 防守效率
		case reboundEfficiency:
			SortOfTeam.sortDescending(voList, new SortOfTeam.ReboundEfficiency(), left, right - 1);
			break;// 篮板效率
		case stealEfficiency:
			SortOfTeam.sortDescending(voList, new SortOfTeam.StealEfficiency(), left, right - 1);
			break; // 抢断率
		case assistEfficiency:
			SortOfTeam.sortDescending(voList, new SortOfTeam.AssistEfficiency(), left, right - 1);
			break; // 助攻率
		}
	}// 根据某一项将所有球队某一赛季成绩降序排序
}
