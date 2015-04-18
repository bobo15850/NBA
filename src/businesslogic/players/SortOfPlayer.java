package businesslogic.players;

import java.util.ArrayList;
import vo.OnePlayerPerformOfOneSeasonVo;

/*
 * 该类是实现排序的类，利用接口实现反射机制
 */
public class SortOfPlayer {

	public static void sortAscending(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PlayerPerformance perform, int left, int right) {
		if (left < right) {
			int i = left, j = right;
			OnePlayerPerformOfOneSeasonVo tempVo = voList.get(left);
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

	public static void sortDescending(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PlayerPerformance perform, int left, int right) {
		if (left < right) {
			int i = left, j = right;
			OnePlayerPerformOfOneSeasonVo tempVo = voList.get(left);
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

	public interface PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player);
	}

	static class MatchNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getNumberOfMatch();
		}
	}// 比赛场数

	static class FirstNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getNumberOfFirst();
		}
	}// 先发次数

	static class TotalRebondNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getTotalReboundNumber();
		}
	}// 总篮板

	static class TotalAssistNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAssistNumber();
		}
	}// 总助攻数

	static class TotalPlayingTime implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getPlayingTime().getTimeAsSecond();
		}
	}// 总上场时间

	static class TotalStealNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getStealNumber();
		}
	}// 总抢断数

	static class TotalBlockNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getBlockNumber();
		}
	}// 总盖帽数

	static class TotalTurnoverNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getTurnoverNumber();
		}
	}// 总失误数

	static class TotalFoulNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getFoulNumber();
		}
	}// 总犯规数

	static class ScoreNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getScoreNumber();
		}
	}// 得分

	static class OffensiveRebondNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getOffensiveReboundNumber();
		}
	}// 前场篮板

	static class DeffensiveRebondNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getOffensiveReboundNumber();
		}
	}// 后场篮板

	static class AverageTotalReboundNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageTotalReboundNumber();
		}
	}// 场均篮板数

	static class AverageAssistNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageAssistNumber();
		}
	}// 场均助攻数

	static class AveragePlayingTime implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAveragePlayingTime().getTimeAsSecond();
		}
	}// 场均上场时间

	static class AverageStealNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageStealNumber();
		}
	}// 场均抢断数

	static class AverageBlockNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageBlockNumber();
		}
	}// 场均盖帽数

	static class AverageTurnoverNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageTurnoverNumber();
		}
	}// 场均失误率

	static class AverageFoulNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageFoulNumber();
		}
	}// 场均犯规

	static class AverageScoreNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageScoreNumber();
		}
	}// 场均得分

	static class AverageOffensiveReboundNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageOffensiveReboundNumber();
		}
	}// 场均进攻篮板

	static class AverageDefensiveReboundNumber implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAverageDefensiveReboundNumber();
		}
	}// 场均防守篮板

	static class TotalHitRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getTotalHitRate();
		}
	}// 命中率

	static class ThreePointHitRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getThreePointHitRate();
		}
	}// 三分球命中率

	static class FreePointHitRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getFreePointHitRate();
		}
	}// 罚球命中率

	static class CommonEfficiency implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getCommonEfficiency();
		}
	}// 球员效率

	static class GmScEfficiency implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getGmScEfficiency();
		}
	}// GmSc效率

	static class RealHitRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getRealHitRate();
		}
	}// 真实命中率

	static class ShootEfficiency implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getShootEfficiency();
		}
	}// 投篮效率

	static class ReboundEfficiency implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getReboundEfficiency();
		}
	}// 篮板效率

	static class OffensiveReboundRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getOffensiveReboundRate();
		}
	}// 进攻篮板率

	static class DefensiveReboundRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getDefensiveReboundRate();
		}
	}// 防守篮板率

	static class AssistRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAssistRate();
		}
	}// 助攻率

	static class StealRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getStealRate();
		}
	}// 抢断率

	static class BlockRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getBlockRate();
		}
	}// 盖帽率

	static class TurnoverRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getTurnoverRate();
		}
	}// 失误率

	static class UseRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getUseRate();
		}
	}// 使用率

	static class DoubleDouble implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getDoubleDouble();
		}
	}// 两双

	static class TripleDouble implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getTripleDouble();
		}
	}// 三双

	static class ScoreReboundAssistRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getScoreReboundAssistRate();
		}
	}// 得分篮板助攻比

	static class AverageScoreReboundAssistRate implements PlayerPerformance {
		public double getPerformance(OnePlayerPerformOfOneSeasonVo player) {
			return player.getAveragescoreReboundAssistRate();
		}
	}// 场均得分篮板助攻比
}
