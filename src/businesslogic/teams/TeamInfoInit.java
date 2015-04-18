package businesslogic.teams;

import java.util.TreeMap;
import java.util.Map.Entry;

import businesslogic.CACHE;
import po.TeamPerformanceOfOneMatchPo;
import test.data.TeamHighInfo;
import test.data.TeamNormalInfo;
import common.mydatastructure.MyDate;
import databaseutility.MEM;

public class TeamInfoInit {
	public static void initTeamCache() {
		for (Entry<String, TreeMap<MyDate, TeamPerformanceOfOneMatchPo>> temp : MEM.TEAM_PERFORM.entrySet()) {
			TeamNormalInfo teamNormal = new TeamNormalInfo();
			TeamHighInfo teamHigh = new TeamHighInfo();
			TreeMap<MyDate, TeamPerformanceOfOneMatchPo> oneTeam = temp.getValue();
			String teamName = temp.getKey();
			int numOfGame = oneTeam.size();
			int numOfWin = 0;
			//
			int totalHitNumber = 0;// 总命中数
			int totalShootNumber = 0;// 总出手数
			int threePointHitNumber = 0;// 三分命中数
			int threePointShootNumber = 0;// 三分出手数
			int freePointHitNumber = 0;// 罚球命中数
			int freePointShootNumber = 0;// 罚球出手数
			//
			int point = 0;// 总得分数
			int totalReboundNumber = 0;// 总篮板
			int offendReboundNumber = 0;// 进攻篮板数
			int defendReboundNumber = 0;// 防守篮板数
			int assistNumber = 0;// 总助攻
			int stealNumber = 0;// 总抢断数
			int blockShotNumber = 0;// 总 盖帽数
			int faultNumber = 0;// 总失误数
			int foulNumber = 0;// 总犯规数
			//
			int offendReboundOfCompetitor = 0;
			int defendReboundOfCompetitor = 0;
			int pointOfCompetitor = 0;
			int shotOfCompetitor = 0;
			int hitOfCompetitor = 0;
			int foulOfCompetitor = 0;
			int faultOfCompetitor = 0;
			//
			for (Entry<MyDate, TeamPerformanceOfOneMatchPo> oneMatch : oneTeam.entrySet()) {
				TeamPerformanceOfOneMatchPo tempMatch = oneMatch.getValue();
				MyDate tempDate = oneMatch.getKey();
				numOfWin += tempMatch.getWin();
				totalHitNumber += tempMatch.getTotalHitNumber();// 总命中数
				totalShootNumber += tempMatch.getTotalShootNumber();// 总出手数
				threePointHitNumber += tempMatch.getThreePointHitNumber();// 三分命中数
				threePointShootNumber += tempMatch.getThreePointShootNumber();// 三分出手数
				freePointHitNumber += tempMatch.getFreePointHitNumber();// 罚球命中数
				freePointShootNumber += tempMatch.getFreePointShootNumber();// 罚球出手数
				//
				point += tempMatch.getScoreNumber();// 总得分数
				totalReboundNumber += tempMatch.getTotalReboundNumber();// 总篮板
				offendReboundNumber += tempMatch.getOffendReboundNumber();// 进攻篮板数
				defendReboundNumber += tempMatch.getDefendReboundNumber();// 防守篮板数
				assistNumber += tempMatch.getAssistNumber();// 总助攻
				stealNumber += tempMatch.getStealNumber();// 总抢断数
				blockShotNumber += tempMatch.getBlockNumber();// 总 盖帽数
				faultNumber += tempMatch.getFaultNumber();// 总失误数
				foulNumber += tempMatch.getFoulNumber();// 总犯规数
				//
				TeamPerformanceOfOneMatchPo opponentTeam = MEM.TEAM_PERFORM.get(tempMatch.getOpponentTeamNameForShort()).get(tempDate);
				offendReboundOfCompetitor += opponentTeam.getOffendReboundNumber();
				defendReboundOfCompetitor += opponentTeam.getDefendReboundNumber();
				pointOfCompetitor += opponentTeam.getScoreNumber();
				shotOfCompetitor += opponentTeam.getTotalShootNumber();
				hitOfCompetitor += opponentTeam.getTotalHitNumber();
				foulOfCompetitor += opponentTeam.getFoulNumber();
				faultOfCompetitor += opponentTeam.getFaultNumber();
			}
			teamNormal.setTeamName(teamName);
			teamNormal.setNumOfGame(numOfGame);
			teamNormal.setPoint(point);
			teamNormal.setRebound(totalReboundNumber);
			teamNormal.setOffendRebound(offendReboundNumber);
			teamNormal.setDefendRebound(defendReboundNumber);
			teamNormal.setAssist(assistNumber);
			teamNormal.setSteal(stealNumber);
			teamNormal.setBlockShot(blockShotNumber);
			teamNormal.setFault(faultNumber);
			teamNormal.setFoul(foulNumber);
			teamNormal.setShot(CalculationOfTeamPerform.calHitRate(totalHitNumber, totalShootNumber));
			teamNormal.setThree(CalculationOfTeamPerform.calHitRate(threePointHitNumber, threePointShootNumber));
			teamNormal.setPenalty(CalculationOfTeamPerform.calHitRate(freePointHitNumber, freePointShootNumber));
			//
			teamHigh.setTeamName(teamName);
			teamHigh.setWinRate(CalculationOfTeamPerform.calWinRate(numOfWin, numOfGame));
			teamHigh.setOffendRound(CalculationOfTeamPerform.calOffensiveNum(totalShootNumber, foulNumber, offendReboundNumber,
					defendReboundOfCompetitor, totalShootNumber - totalHitNumber, faultNumber));
			teamHigh.setOffendEfficient(CalculationOfTeamPerform.calOffensiveEfficiency(point, totalShootNumber, foulNumber, offendReboundNumber,
					defendReboundOfCompetitor, totalShootNumber - totalHitNumber, faultNumber));
			teamHigh.setDefendEfficient(CalculationOfTeamPerform.calDefensiveEfficiency(pointOfCompetitor, shotOfCompetitor, foulOfCompetitor,
					offendReboundOfCompetitor, defendReboundNumber, shotOfCompetitor - hitOfCompetitor, faultOfCompetitor));
			teamHigh.setOffendReboundEfficient(CalculationOfTeamPerform.calOffensiveReboundEfficiency(offendReboundNumber, defendReboundOfCompetitor));
			teamHigh.setDefendReboundEfficient(CalculationOfTeamPerform.calDefensiveReboundEfficiency(defendReboundNumber, offendReboundOfCompetitor));
			teamHigh.setAssistEfficient(CalculationOfTeamPerform.calAssistRate(assistNumber, totalShootNumber, foulNumber, offendReboundNumber,
					defendReboundOfCompetitor, totalShootNumber - totalHitNumber, faultNumber));
			teamHigh.setStealEfficient(CalculationOfTeamPerform.calStealEfficiency(stealNumber, shotOfCompetitor, foulOfCompetitor,
					offendReboundOfCompetitor, defendReboundNumber, shotOfCompetitor - hitOfCompetitor, faultOfCompetitor));
			CACHE.TEAM_NORMAL.put(teamName, teamNormal);
			CACHE.TEAM_HIGH.put(teamName, teamHigh);
		}
	}

	public static void initTeamTodayCache() {

	}

}
