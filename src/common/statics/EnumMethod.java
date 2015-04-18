package common.statics;

import common.enums.Conference;
import common.enums.Division;
import common.enums.PerformanceOfPlayer;
import common.enums.PerformanceOfTeam;
import common.enums.PlayerPosition;

public class EnumMethod {
	public static Conference toConference(String str) {
		if (str.equals("E") || str.equals("EASTERN")) {
			return Conference.EASTERN;
		} else if (str.equals("W") || str.equals("WESTERN")) {
			return Conference.WESTERN;
		} else {
			return null;
		}
	}

	public static Division toDivision(String str) {
		if (str.equals("Southeast")) {
			return Division.Southeast;
		} else if (str.equals("Atlantic")) {
			return Division.Atlantic;
		} else if (str.equals("Central")) {
			return Division.Central;
		} else if (str.equals("Northwest")) {
			return Division.Northwest;
		} else if (str.equals("Pacific")) {
			return Division.Pacific;
		} else if (str.equals("Southwest")) {
			return Division.Southwest;
		} else {
			return null;
		}
	}

	public static PlayerPosition toPosition(String str) {
		if (str.equals("C")) {
			return PlayerPosition.C;
		} else if (str.equals("G")) {
			return PlayerPosition.G;
		} else if (str.equals("F")) {
			return PlayerPosition.F;
		} else if (str.equals("C-G") || str.equals("C_G")) {
			return PlayerPosition.C_G;
		} else if (str.equals("C-F") || str.equals("C_F")) {
			return PlayerPosition.C_F;
		} else if (str.equals("G-C") || str.equals("G_C")) {
			return PlayerPosition.G_C;
		} else if (str.equals("G-F") || str.equals("G_F")) {
			return PlayerPosition.G_F;
		} else if (str.equals("F-C") || str.equals("F_C")) {
			return PlayerPosition.F_C;
		} else if (str.equals("F-G") || str.equals("F_G	")) {
			return PlayerPosition.F_G;
		} else {
			return null;
		}
	}

	public static int toMonthInt(String month) {
		if (month.equals("JAN")) {
			return 1;
		} else if (month.equals("FEB")) {
			return 2;
		} else if (month.equals("MAR")) {
			return 3;
		} else if (month.equals("APR")) {
			return 4;
		} else if (month.equals("MAY")) {
			return 5;
		} else if (month.equals("JUN")) {
			return 6;
		} else if (month.equals("JUL")) {
			return 7;
		} else if (month.equals("AUG")) {
			return 8;
		} else if (month.equals("SEP")) {
			return 9;
		} else if (month.equals("QCT")) {
			return 10;
		} else if (month.equals("NOV")) {
			return 11;
		} else if (month.equals("DEC")) {
			return 12;
		} else {
			return 0;
		}
	}

	public static boolean ToBoolean(String str) {
		if (str.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPlayerPositionEqual(PlayerPosition standPosition, PlayerPosition selectedPosition) {
		if (standPosition == PlayerPosition.C) {
			if (selectedPosition == PlayerPosition.C || selectedPosition == PlayerPosition.C_F || selectedPosition == PlayerPosition.F_C) {
				return true;
			} else {
				return false;
			}
		} else if (standPosition == PlayerPosition.G) {
			if (selectedPosition == PlayerPosition.G || selectedPosition == PlayerPosition.G_F || selectedPosition == PlayerPosition.F_G) {
				return true;
			} else {
				return false;
			}
		} else if (standPosition == PlayerPosition.F) {
			if (selectedPosition == PlayerPosition.F || selectedPosition == PlayerPosition.C_F || selectedPosition == PlayerPosition.F_C
					|| selectedPosition == PlayerPosition.F_G || selectedPosition == PlayerPosition.G_F) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static PerformanceOfPlayer toPerformanceOfPlayer(String str) {
		switch (str) {
		case "姓名":
			return PerformanceOfPlayer.PlayerName;
		case "场均得分":
			return PerformanceOfPlayer.AverageScoreNumber;
		case "总得分":
			return PerformanceOfPlayer.ScoreNumber;
		case "场均助攻":
			return PerformanceOfPlayer.AverageAssistNumber;
		case "总助攻":
			return PerformanceOfPlayer.TotalAssistNumber;
		case "所属球队":
			return PerformanceOfPlayer.TeamName;
		case "总篮板":
			return PerformanceOfPlayer.TotalRebondNumber;
		case "场均篮板":
			return PerformanceOfPlayer.AverageTotalReboundNumber;
		case "总抢断":
			return PerformanceOfPlayer.TotalStealNumber;
		case "场均抢断":
			return PerformanceOfPlayer.AverageStealNumber;
		case "总盖帽":
			return PerformanceOfPlayer.TotalBlockNumber;
		case "场均盖帽":
			return PerformanceOfPlayer.AverageBlockNumber;
		case "总失误":
			return PerformanceOfPlayer.TotalTurnoverNumber;
		case "场均失误":
			return PerformanceOfPlayer.AverageTurnoverNumber;
		case "总犯规":
			return PerformanceOfPlayer.TotalFoulNumber;
		case "场均犯规":
			return PerformanceOfPlayer.AverageFoulNumber;
		case "投篮命中率":
			return PerformanceOfPlayer.TotalHitRate;
		case "三分命中率":
			return PerformanceOfPlayer.ThreePointHitRate;
		case "罚球命中率":
			return PerformanceOfPlayer.FreePointHitRate;
		case "参赛场数":
			return PerformanceOfPlayer.MatchNumber;
		case "先发场数":
			return PerformanceOfPlayer.FirstNumber;
		case "总在场时间":
			return PerformanceOfPlayer.TotalPlayingTime;
		case "场均在场时间":
			return PerformanceOfPlayer.AveragePlayingTime;
		case "效率值":
			return PerformanceOfPlayer.CommonEfficiency;
		case "Gmsc效率值":
			return PerformanceOfPlayer.GmScEfficiency;
		case "使用率":
			return PerformanceOfPlayer.UseRate;
		case "真实命中率":
			return PerformanceOfPlayer.RealHitRate;
		case "投篮效率":
			return PerformanceOfPlayer.ShootEfficiency;
		case "助攻率":
			return PerformanceOfPlayer.AssistRate;
		case "进攻篮板":
			return PerformanceOfPlayer.AverageOffensiveReboundNumber;
		case "防守篮板":
			return PerformanceOfPlayer.AverageDefensiveReboundNumber;
		case "篮板率":
			return PerformanceOfPlayer.ReboundEfficiency;
		case "进攻篮板率":
			return PerformanceOfPlayer.OffensiveReboundRate;
		case "防守篮板率":
			return PerformanceOfPlayer.DefensiveReboundRate;
		case "盖帽率":
			return PerformanceOfPlayer.BlockRate;
		case "抢断率":
			return PerformanceOfPlayer.StealRate;
		case "失误率":
			return PerformanceOfPlayer.TurnoverRate;
		case "两双次数":
			return PerformanceOfPlayer.DoubleDouble;
		case "三双次数":
			return PerformanceOfPlayer.TripleDouble;
		}
		return PerformanceOfPlayer.PlayerName;
	}

	public static PerformanceOfTeam toPerformanceOfTeam(String str) {
		switch (str) {
		case "球队名称":
			return PerformanceOfTeam.teamNameForShort;
		case "比赛场数":
			return PerformanceOfTeam.numberOfMatch;
		case "胜率":
			return PerformanceOfTeam.winRate;
		case "场均得分数":
			return PerformanceOfTeam.averageScoreNumber;
		case "总得分数":
			return PerformanceOfTeam.scoreNumber;
		case "场均投篮命中数":
			return PerformanceOfTeam.averageTotalHitNumber;
		case "总投篮命中数":
			return PerformanceOfTeam.totalHitNumber;
		case "场均总投篮出手数":
			return PerformanceOfTeam.averageTotalShootNumber;
		case "总投篮出手数":
			return PerformanceOfTeam.totalShootNumber;
		case "投篮命中率":
			return PerformanceOfTeam.totalHitRate;
		case "场均三分命中数":
			return PerformanceOfTeam.averageFreePointHitNumber;
		case "总三分命中数":
			return PerformanceOfTeam.threePointHitNumber;
		case "场均三分出手数":
			return PerformanceOfTeam.averageThreePointShootNumber;
		case "总三分出手数":
			return PerformanceOfTeam.threePointShootNumber;
		case "三分命中率":
			return PerformanceOfTeam.threePointHitRate;
		case "场均罚球命中数":
			return PerformanceOfTeam.averageFreePointHitNumber;
		case "总罚球命中数":
			return PerformanceOfTeam.freePointHitNumber;
		case "场均罚球出手数":
			return PerformanceOfTeam.averageFreePointShootNumber;
		case "总罚球出手数":
			return PerformanceOfTeam.freePointShootNumber;
		case "罚球命中率":
			return PerformanceOfTeam.freePointHitRate;
		case "场均进攻篮板数":
			return PerformanceOfTeam.averageOffensiveReboundNumber;
		case "总进攻篮板数":
			return PerformanceOfTeam.offensiveReboundNumber;
		case "场均防守篮板数":
			return PerformanceOfTeam.averageDefensiveReboundNumber;
		case "总防守篮板":
			return PerformanceOfTeam.defensiveReboundNumber;
		case "场均总篮板":
			return PerformanceOfTeam.averageTotalReboundNumber;
		case "总篮板":
			return PerformanceOfTeam.totalReboundNumber;
		case "场均助攻":
			return PerformanceOfTeam.averageAssistNumber;
		case "总助攻":
			return PerformanceOfTeam.assistNumber;
		case "场均抢断":
			return PerformanceOfTeam.averageStealNumber;
		case "总抢断数":
			return PerformanceOfTeam.stealNumber;
		case "场均盖帽":
			return PerformanceOfTeam.averageBlockNumber;
		case "总盖帽数":
			return PerformanceOfTeam.blockNumber;
		case "场均失误数":
			return PerformanceOfTeam.averageTurnoverNumber;
		case "总失误数":
			return PerformanceOfTeam.turnoverNumber;
		case "场均犯规数":
			return PerformanceOfTeam.averageFoulNumber;
		case "总犯规数":
			return PerformanceOfTeam.foulNumber;
		case "场均进攻回合":
			return PerformanceOfTeam.averageOffensiveNumber;
		case "总进攻回合数":
			return PerformanceOfTeam.offensiveNumber;
		case "进攻效率":
			return PerformanceOfTeam.offensiveEfficiency;
		case "防守效率":
			return PerformanceOfTeam.defensiveEfficiency;
		case "篮板效率":
			return PerformanceOfTeam.reboundEfficiency;
		case "抢断率":
			return PerformanceOfTeam.stealEfficiency;
		case "助攻率":
			return PerformanceOfTeam.assistEfficiency;
		}
		return PerformanceOfTeam.teamNameForShort;
	}
}
