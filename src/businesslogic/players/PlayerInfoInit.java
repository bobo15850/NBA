package businesslogic.players;

import java.util.Map.Entry;
import java.util.TreeMap;

import test.data.PlayerHighInfo;
import businesslogic.CACHE;
import businesslogic.teams.CalculationOfTeamPerform;

import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.MyDate;
import common.mydatastructure.MyTime;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamPerformOfOneMatch;
import common.statics.League;
import common.statics.NUMBER;
import common.statics.Position;

import databaseutility.MEM;

public class PlayerInfoInit {
	public static void initPlayerCache() {
		for (Entry<String, TreeMap<MyDate, PlayerPerformOfOneMatch>> temp : MEM.PLAYERS_PERFORM.entrySet()) {
			PlayerNormalInfo_Expand playerNormal = new PlayerNormalInfo_Expand();
			PlayerHighInfo playerHigh = new PlayerHighInfo();
			//
			String playerName = temp.getKey();// 球员姓名
			String position = Position.Unknown;// 位置
			int age = NUMBER.UNKNOWN_AGE;// 年龄
			String league = League.Unknown;// 联盟
			//
			TreeMap<MyDate, PlayerPerformOfOneMatch> oneplayer = temp.getValue();
			PlayerPerformOfOneMatch latestMatchPo = oneplayer.lastEntry().getValue();// 最后一场比赛
			String teamName = latestMatchPo.getTeamNameForShort();// 得到所属球队
			if (MEM.TEAM_LEAGUE.containsKey(teamName)) {
				league = MEM.TEAM_LEAGUE.get(teamName);
			}// 得到联盟
			if (MEM.PLAYER_GENERALINFO.containsKey(playerName)) {
				GeneralInfoOfPlayer playerGeneralInfo = MEM.PLAYER_GENERALINFO.get(latestMatchPo.getNameOfPlayer());
				age = playerGeneralInfo.getAge();
				position = playerGeneralInfo.getPosition();
			}// 得到年龄
			int numOfGame = oneplayer.size();// 比赛场数
			int start = 0;
			int totalHitNumber = 0;// 总命中数
			int totalShotNumber = 0;// 总出手数
			int threePointHitNumber = 0;// 三分命中数
			int threePointShotNumber = 0;// 三分出手数
			int freePointHitNumber = 0;// 罚球命中数
			int freePointShotNumber = 0;// 罚球出手数
			int doubleTwo = 0;// 两双次数
			int tripleTwo = 0;// 三双次数
			//
			int point = 0;// 总得分数
			int totalReboundNumber = 0;// 总篮板
			int offendReboundNumber = 0;// 进攻篮板数
			int defendReboundNumber = 0;// 防守篮板数
			int assistNumber = 0;// 总助攻
			MyTime playingTime = new MyTime();// 总上场时间
			int stealNumber = 0;// 总抢断数
			int blockShotNumber = 0;// 总 盖帽数
			int faultNumber = 0;// 总失误数
			int foulNumber = 0;// 总犯规数
			//
			MyTime timeOfAllPlayer = new MyTime();// 球队所有球员上场时间
			int totalReboundOfTeam = 0;// 球队所有篮板数
			int offendReboundOfTeam = 0;
			int defendReboundOfTeam = 0;

			int hitOfAllPlayer = 0; // 球队所有命中数
			int shootOfAllPlayer = 0;// 球队所有出手数
			int freePointShotOfAllPlayer = 0;// 球队所有罚球数
			int faultOfAllPlayer = 0;// 球队所有失误数
			//
			int offendNumberOfCompetitor = 0;// 对手进攻次数
			int shootNumOfCompetitor = 0;// 对手总出手数
			int threePointShootOfCompetitor = 0;// 对手三分出手数
			int totalReboundOfCompetitor = 0;// 对手所有篮板数
			int offendReboundOfCompetior = 0;// 对手进攻篮板数
			int defendReboundOfCompetitor = 0;// 对手防守篮板数
			//
			for (Entry<MyDate, PlayerPerformOfOneMatch> onematch : oneplayer.entrySet()) {
				PlayerPerformOfOneMatch tempMatch = onematch.getValue();
				MyDate tempDate = onematch.getKey();
				//
				start += tempMatch.getStart();
				totalHitNumber += tempMatch.getTotalHitNumber();
				totalShotNumber += tempMatch.getTotalShootNumber();
				threePointHitNumber += tempMatch.getThreePointHitNumber();
				threePointShotNumber += tempMatch.getThreePointShootNumber();
				freePointHitNumber += tempMatch.getFreePointHitNumber();
				freePointShotNumber += tempMatch.getFreePointShootNumber();
				totalReboundNumber += tempMatch.getTotalReboundNumber();
				assistNumber += tempMatch.getAssistNumber();
				playingTime.plus(tempMatch.getPlayingTime());
				stealNumber += tempMatch.getStealNumber();
				blockShotNumber += tempMatch.getBlockNumber();
				faultNumber += tempMatch.getFaultNumber();
				foulNumber += tempMatch.getFoulNumber();
				point += tempMatch.getScoreNumber();
				offendReboundNumber += tempMatch.getOffensiveReboundNumber();
				defendReboundNumber += tempMatch.getDefensiveReboundNumber();
				//
				String tempTeam = tempMatch.getTeamNameForShort();// 球队名称
				TeamPerformOfOneMatch selfTeam = MEM.TEAM_PERFORM.get(tempTeam).get(tempDate);// 所属球队战绩
				TeamPerformOfOneMatch opponentTeam = MEM.TEAM_PERFORM.get(selfTeam.getOpponentTeamNameForShort()).get(tempDate);// 对手球队战绩
				//
				timeOfAllPlayer.plus(selfTeam.getPlayingTime());
				totalReboundOfTeam += selfTeam.getTotalReboundNumber();
				offendReboundOfTeam += selfTeam.getOffendReboundNumber();
				defendReboundOfTeam += selfTeam.getDefendReboundNumber();
				shootOfAllPlayer += selfTeam.getTotalShootNumber();
				freePointShotOfAllPlayer += selfTeam.getFreePointShootNumber();
				faultOfAllPlayer += selfTeam.getFaultNumber();
				hitOfAllPlayer += selfTeam.getTotalHitNumber();
				//
				totalReboundOfCompetitor += opponentTeam.getTotalReboundNumber();
				offendReboundOfCompetior += opponentTeam.getOffendReboundNumber();
				defendReboundOfCompetitor += opponentTeam.getDefendReboundNumber();
				offendNumberOfCompetitor += CalculationOfTeamPerform.calOffensiveNum(selfTeam.getTotalShootNumber(), selfTeam.getFoulNumber(),
						selfTeam.getOffendReboundNumber(), opponentTeam.getDefendReboundNumber(),
						selfTeam.getTotalShootNumber() - selfTeam.getTotalHitNumber(), selfTeam.getFaultNumber());
				shootNumOfCompetitor += opponentTeam.getTotalShootNumber();
				threePointShootOfCompetitor += opponentTeam.getThreePointShootNumber();
				int doubleOfOneMatch = 0;// 一场比赛中上双的个数
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
				if (doubleOfOneMatch >= 2) {
					doubleTwo++;
				}
				else if (doubleOfOneMatch >= 3) {
					tripleTwo++;
				}
			}
			playerNormal.setName(playerName);
			playerNormal.setAge(age);
			playerNormal.setTeamName(teamName);
			playerNormal.setStart(start);
			playerNormal.setNumOfGame(numOfGame);
			playerNormal.setPoint(point);
			playerNormal.setRebound(totalReboundNumber);
			playerNormal.setOffend(offendReboundNumber);
			playerNormal.setDefend(defendReboundNumber);
			playerNormal.setAssist(assistNumber);
			playerNormal.setSteal(stealNumber);
			playerNormal.setBlockShot(blockShotNumber);
			playerNormal.setFoul(foulNumber);
			playerNormal.setFault(faultNumber);
			playerNormal.setMinute(playingTime.getTimeAsMinute());
			playerNormal.setTotalHit(totalHitNumber);
			playerNormal.setTotalShot(totalShotNumber);
			playerNormal.setThreeHit(threePointHitNumber);
			playerNormal.setThreeShot(threePointShotNumber);
			playerNormal.setFreeHit(freePointHitNumber);
			playerNormal.setFreeShot(freePointShotNumber);
			playerNormal.setDoubleTwo(doubleTwo);
			playerNormal.setTripleTwo(tripleTwo);
			playerNormal.setShot(CalculationOfPlayerPerform.calHitRate(totalHitNumber, totalShotNumber));
			playerNormal.setThree(CalculationOfPlayerPerform.calHitRate(threePointHitNumber, threePointShotNumber));
			playerNormal.setPenalty(CalculationOfPlayerPerform.calHitRate(freePointHitNumber, freePointShotNumber));
			playerNormal.setEfficiency(CalculationOfPlayerPerform.calEfficiency(point, totalReboundNumber, assistNumber, stealNumber,
					blockShotNumber, totalShotNumber, totalHitNumber, freePointShotNumber, freePointHitNumber, faultNumber, numOfGame));
			//
			playerHigh.setName(playerName);
			playerHigh.setTeamName(teamName);
			playerHigh.setLeague(league);
			playerHigh.setPosition(position);
			playerHigh.setGmSc(CalculationOfPlayerPerform.calGmSc(point, totalHitNumber, totalShotNumber, freePointShotNumber, freePointHitNumber,
					offendReboundNumber, defendReboundNumber, stealNumber, assistNumber, blockShotNumber, foulNumber, faultNumber, numOfGame));
			playerHigh.setShotEfficient(CalculationOfPlayerPerform.calShotEfficiency(totalHitNumber, threePointHitNumber, totalShotNumber));
			playerHigh.setRealShot(CalculationOfPlayerPerform.calRealShot(point, totalShotNumber, freePointShotNumber));
			//
			playerHigh.setOffendReboundEfficient(CalculationOfPlayerPerform.calReboundEfficient(offendReboundNumber, timeOfAllPlayer, playingTime,
					offendReboundOfTeam, defendReboundOfCompetitor));
			playerHigh.setDefendReboundEfficient(CalculationOfPlayerPerform.calReboundEfficient(defendReboundNumber, timeOfAllPlayer, playingTime,
					defendReboundOfTeam, offendReboundOfCompetior));
			//
			playerHigh.setReboundEfficient(CalculationOfPlayerPerform.calReboundEfficient(totalReboundNumber, timeOfAllPlayer, playingTime,
					totalReboundOfTeam, totalReboundOfCompetitor));
			playerHigh.setAssistEfficient(CalculationOfPlayerPerform.calAssistEfficient(assistNumber, playingTime, timeOfAllPlayer, hitOfAllPlayer,
					totalHitNumber));
			playerHigh.setStealEfficient(CalculationOfPlayerPerform.calStealEfficient(stealNumber, timeOfAllPlayer, playingTime,
					offendNumberOfCompetitor));
			playerHigh.setBlockShotEfficient(CalculationOfPlayerPerform.calBlockShotEfficient(blockShotNumber, timeOfAllPlayer, playingTime,
					shootNumOfCompetitor - threePointShootOfCompetitor));
			// /////////////////////////////////////////////////////////////////////////////
			playerHigh.setFaultEfficient(CalculationOfPlayerPerform.calFaultEfficient(faultNumber, totalShotNumber - threePointShotNumber,
					freePointShotNumber));
			// /////////////////////////////////////////////////////////////////////////////
			playerHigh.setFrequency(CalculationOfPlayerPerform.calFrequency(totalShotNumber, freePointShotNumber, faultNumber, timeOfAllPlayer,
					playingTime, shootOfAllPlayer, freePointShotOfAllPlayer, faultOfAllPlayer));
			CACHE.PLAYER_NORMAL.put(playerName, playerNormal);
			CACHE.PLAYER_HIGH.put(playerName, playerHigh);
		}
	}

	public static void initPlayerTodayCache() {

	}
}
