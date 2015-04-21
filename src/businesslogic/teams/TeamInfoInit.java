package businesslogic.teams;

import java.util.TreeMap;
import java.util.Map.Entry;

import businesslogic.CACHE;
import test.data.TeamHighInfo;
import common.mydatastructure.MyDate;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;
import databaseutility.MEM;

public class TeamInfoInit {
	public static void initTeamCache() {
		for (Entry<String, TreeMap<MyDate, TeamPerformOfOneMatch>> temp : MEM.TEAM_PERFORM.entrySet()) {
			TeamNormalInfo_Expand teamNormal = new TeamNormalInfo_Expand();
			TeamHighInfo teamHigh = new TeamHighInfo();
			TreeMap<MyDate, TeamPerformOfOneMatch> oneTeam = temp.getValue();
			String teamName = temp.getKey();
			int numOfGame = oneTeam.size();
			int numOfWin = 0;
			//
			double minute = 0;
			int totalHitNumber = 0;// 总命中数
			int totalShotNumber = 0;// 总出手数
			int threePointHitNumber = 0;// 三分命中数
			int threePointShotNumber = 0;// 三分出手数
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
			for (Entry<MyDate, TeamPerformOfOneMatch> oneMatch : oneTeam.entrySet()) {
				TeamPerformOfOneMatch tempMatch = oneMatch.getValue();
				MyDate tempDate = oneMatch.getKey();
				numOfWin += tempMatch.getWin();
				minute += tempMatch.getMinute();
				totalHitNumber += tempMatch.getTotalHit();// 总命中数
				totalShotNumber += tempMatch.getTotalShot();// 总出手数
				threePointHitNumber += tempMatch.getThreeHit();// 三分命中数
				threePointShotNumber += tempMatch.getThreeShot();// 三分出手数
				freePointHitNumber += tempMatch.getFreeHit();// 罚球命中数
				freePointShootNumber += tempMatch.getFreeShot();// 罚球出手数
				//
				point += tempMatch.getPoint();// 总得分数
				totalReboundNumber += tempMatch.getRebound();// 总篮板
				offendReboundNumber += tempMatch.getOffendRebound();// 进攻篮板数
				defendReboundNumber += tempMatch.getDefendRebound();// 防守篮板数
				assistNumber += tempMatch.getAssist();// 总助攻
				stealNumber += tempMatch.getSteal();// 总抢断数
				blockShotNumber += tempMatch.getBlock();// 总 盖帽数
				faultNumber += tempMatch.getFault();// 总失误数
				foulNumber += tempMatch.getFoul();// 总犯规数
				//
				TeamPerformOfOneMatch opponentTeam = MEM.TEAM_PERFORM.get(tempMatch.getOpponentTeamName()).get(tempDate);
				offendReboundOfCompetitor += opponentTeam.getOffendRebound();
				defendReboundOfCompetitor += opponentTeam.getDefendRebound();
				pointOfCompetitor += opponentTeam.getPoint();
				shotOfCompetitor += opponentTeam.getTotalShot();
				hitOfCompetitor += opponentTeam.getTotalHit();
				foulOfCompetitor += opponentTeam.getFoul();
				faultOfCompetitor += opponentTeam.getFault();
			}
			teamNormal.setTeamName(teamName);
			teamNormal.setNumOfGame(numOfGame);
			teamNormal.setNumOfWin(numOfWin);
			teamNormal.setMinute(minute);
			teamNormal.setPoint(point);
			teamNormal.setRebound(totalReboundNumber);
			teamNormal.setOffendRebound(offendReboundNumber);
			teamNormal.setDefendRebound(defendReboundNumber);
			teamNormal.setAssist(assistNumber);
			teamNormal.setSteal(stealNumber);
			teamNormal.setBlockShot(blockShotNumber);
			teamNormal.setFault(faultNumber);
			teamNormal.setFoul(foulNumber);
			teamNormal.setTotalHit(totalHitNumber);
			teamNormal.setTotalShot(totalShotNumber);
			teamNormal.setThreeHit(threePointHitNumber);
			teamNormal.setThreeShot(threePointShotNumber);
			teamNormal.setFreeHit(freePointHitNumber);
			teamNormal.setFreeShot(freePointShootNumber);
			teamNormal.setShot(CalculationOfTeamPerform.calHitRate(totalHitNumber, totalShotNumber));
			teamNormal.setThree(CalculationOfTeamPerform.calHitRate(threePointHitNumber, threePointShotNumber));
			teamNormal.setPenalty(CalculationOfTeamPerform.calHitRate(freePointHitNumber, freePointShootNumber));

			//
			teamHigh.setTeamName(teamName);
			teamHigh.setWinRate(CalculationOfTeamPerform.calWinRate(numOfWin, numOfGame));
			teamHigh.setOffendRound(CalculationOfTeamPerform.calOffensiveNum(totalShotNumber, foulNumber, offendReboundNumber,
					defendReboundOfCompetitor, totalShotNumber - totalHitNumber, faultNumber));
			teamHigh.setOffendEfficient(CalculationOfTeamPerform.calOffensiveEfficiency(point, totalShotNumber, foulNumber, offendReboundNumber,
					defendReboundOfCompetitor, totalShotNumber - totalHitNumber, faultNumber));
			teamHigh.setDefendEfficient(CalculationOfTeamPerform.calDefensiveEfficiency(pointOfCompetitor, shotOfCompetitor, foulOfCompetitor,
					offendReboundOfCompetitor, defendReboundNumber, shotOfCompetitor - hitOfCompetitor, faultOfCompetitor));
			teamHigh.setOffendReboundEfficient(CalculationOfTeamPerform.calOffensiveReboundEfficiency(offendReboundNumber, defendReboundOfCompetitor));
			teamHigh.setDefendReboundEfficient(CalculationOfTeamPerform.calDefensiveReboundEfficiency(defendReboundNumber, offendReboundOfCompetitor));
			teamHigh.setAssistEfficient(CalculationOfTeamPerform.calAssistRate(assistNumber, totalShotNumber, foulNumber, offendReboundNumber,
					defendReboundOfCompetitor, totalShotNumber - totalHitNumber, faultNumber));
			teamHigh.setStealEfficient(CalculationOfTeamPerform.calStealEfficiency(stealNumber, shotOfCompetitor, foulOfCompetitor,
					offendReboundOfCompetitor, defendReboundNumber, shotOfCompetitor - hitOfCompetitor, faultOfCompetitor));
			CACHE.TEAM_NORMAL.put(teamName, teamNormal);
			CACHE.TEAM_HIGH.put(teamName, teamHigh);
		}
	}
}
