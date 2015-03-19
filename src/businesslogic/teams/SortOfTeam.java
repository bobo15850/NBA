package businesslogic.teams;

import java.util.ArrayList;

import businesslogic.players.SortOfPlayer.PlayerPerformance;
import vo.OnePlayerPerformOfOneSeasonVo;
import vo.OneTeamPerformOfOneSeasonVo;

public class SortOfTeam {
	public static void sortAscending(ArrayList<OneTeamPerformOfOneSeasonVo> voList, TeamPerformance perform, int left,
			int right) {
		if (left < right) {
			int i = left, j = right;
			OneTeamPerformOfOneSeasonVo tempVo = voList.get(left);
			while (i < j) {
				while (i < j && perform.getPerformance(voList.get(j)) >= perform.getPerformance(tempVo))
					j--;
				if (i < j)
					voList.set(i++, voList.get(j));
				while (i < j && perform.getPerformance(voList.get(i)) < perform.getPerformance(tempVo))
					i++;
				if (i < j)
					voList.set(j--, voList.get(i));
			}
			voList.set(j, tempVo);
			sortAscending(voList, perform, left, i - 1);
			sortAscending(voList, perform, i + 1, right);
		}
	}

	public static void sortDescending(ArrayList<OneTeamPerformOfOneSeasonVo> voList, TeamPerformance perform, int left,
			int right) {
		if (left < right) {
			int i = left, j = right;
			OneTeamPerformOfOneSeasonVo tempVo = voList.get(left);
			while (i < j) {
				while (i < j && perform.getPerformance(voList.get(j)) < perform.getPerformance(tempVo))
					j--;
				if (i < j)
					voList.set(i++, voList.get(j));
				while (i < j && perform.getPerformance(voList.get(i)) >= perform.getPerformance(tempVo))
					i++;
				if (i < j)
					voList.set(j--, voList.get(i));
			}
			voList.set(j, tempVo);
			sortDescending(voList, perform, left, i - 1);
			sortDescending(voList, perform, i + 1, right);
		}
	}

	public interface TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team);
	}

	// /////////////////
	static class MatchNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getNumberOfMatch();
		}
	}// 比赛场数

	static class TotalHitNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getTotalHitNumber();
		}
	}// 总命中数

	static class TotalShootNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getTotalShootNumber();
		}
	}// 总出手数

	static class ThreePointHitNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getThreePointHitNumber();
		}
	}// 三分命中数

	static class ThreePointShootNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getThreePointShootNumber();
		}
	}// 三分出手数

	static class FreePointHitNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getFreePointHitNumber();
		}
	}// 罚球命中数

	static class FreePointShootNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getFreePointShootNumber();
		}
	}// 罚球出手数

	static class OffensiveRebondNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getOffensiveReboundNumber();
		}
	}// 前场篮板

	static class DeffensiveRebondNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getOffensiveReboundNumber();
		}
	}// 后场篮板

	static class TotalRebondNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getTotalReboundNumber();
		}
	}// 总篮板

	static class TotalAssistNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAssistNumber();
		}
	}// 总助攻数

	static class TotalStealNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getStealNumber();
		}
	}// 总抢断数

	static class TotalBlockNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getBlockNumber();
		}
	}// 总盖帽数

	static class TotalTurnoverNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getTurnoverNumber();
		}
	}// 总失误数

	static class TotalFoulNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getFoulNumber();
		}
	}// 总犯规数

	static class ScoreNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getScoreNumber();
		}
	}// 得分

	static class OffensiveNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getOffensiveNumber();
		}
	}// 进攻回合数

	
	
	
	
	
	
	
	
	static class AverageTotalReboundNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageTotalReboundNumber();
		}
	}// 场均篮板数

	static class AverageAssistNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageAssistNumber();
		}
	}// 场均助攻数

	static class AverageStealNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageStealNumber();
		}
	}// 场均抢断数

	static class AverageBlockNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageBlockNumber();
		}
	}// 场均盖帽数

	static class AverageTurnoverNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageTurnoverNumber();
		}
	}// 场均失误率

	static class AverageFoulNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageFoulNumber();
		}
	}// 场均犯规

	static class AverageScoreNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageScoreNumber();
		}
	}// 场均得分

	static class AverageOffensiveReboundNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageOffensiveReboundNumber();
		}
	}// 场均进攻篮板

	static class AverageDefensiveReboundNumber implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getAverageDefensiveReboundNumber();
		}
	}// 场均防守篮板

	static class TotalHitRate implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getTotalHitRate();
		}
	}// 命中率

	static class ThreePointHitRate implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getThreePointHitRate();
		}
	}// 三分球命中率

	static class FreePointHitRate implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getFreePointHitRate();
		}
	}// 罚球命中率

	static class ReboundEfficiency implements TeamPerformance {
		public double getPerformance(OneTeamPerformOfOneSeasonVo team) {
			return team.getReboundEfficiency();
		}
	}// 篮板效率

}
