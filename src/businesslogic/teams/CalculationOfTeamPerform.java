package businesslogic.teams;

import java.math.BigDecimal;

/*
 * 用以计算xx率
 */
public class CalculationOfTeamPerform {
	/**
	 * 计算平均数
	 * 
	 * @param num
	 * @param time
	 * @return
	 */
	public static double average(double num, int time) {
		if (time == 0) {
			return 0;
		} else {
			double result = num / time;
			return cutToTwo(result);
		}
	}

	/**
	 * 计算胜率
	 * 
	 * @param winNum
	 *            胜利场数
	 * @param loseNum
	 *            失败场数
	 * @return
	 */
	public static double calWinRate(int winNum, int loseNum) {
		double total = winNum + loseNum;
		if (total == 0) {
			return 0;
		} else {
			double result = (double)winNum / (double)total;
			return cutToTwo(result);
		}
	}

	/**
	 * 计算进攻回合
	 * 
	 * @param shoot
	 *            投篮数
	 * @param foul
	 *            球队罚球数
	 * @param offensiveRebound
	 *            本队进攻篮板
	 * @param defensiveReboundOfCompetitor
	 *            对手防守篮板
	 * @param miss
	 *            投失球
	 * @param turnover
	 *            失误数
	 * @return
	 */
	public static double calOffensiveNum(int shoot, int foul, int offensiveRebound, int defensiveReboundOfCompetitor,
			int miss, int turnover) {
		int totalNumber = offensiveRebound + defensiveReboundOfCompetitor;
		if (totalNumber == 0) {
			return 0;
		} else {
			double result = 0;
			result = shoot +0.4 * foul- (1.07 * ((double)offensiveRebound / (double)(offensiveRebound + defensiveReboundOfCompetitor) * miss))+( 1.07 * turnover);
			return cutToTwo(result);
		}
	}

	/**
	 * 计算进攻效率
	 * 
	 * @param score
	 *            得分
	 * @param shoot
	 *            投篮数
	 * @param foul
	 *            球队罚球数
	 * @param offensiveRebound
	 *            本队进攻篮板
	 * @param defensiveReboundOfCompetitor
	 *            对手防守篮板
	 * @param miss
	 *            投失球
	 * @param turnover
	 *            失误数
	 * @return
	 */
	public static double calOffensiveEfficiency(double score, int shoot, int foul, int offensiveRebound,
			int defensiveReboundOfCompetitor, int miss, int turnover) {
		double offensiveNum = calOffensiveNum(shoot, foul, offensiveRebound, defensiveReboundOfCompetitor, miss,
				turnover);
		if (offensiveNum == 0) {
			return 0;
		} else {
			double result = 0;
			result = (double)score * 100 / (double)offensiveNum;
			return cutToTwo(result);
		}
	}

	/**
	 * 计算防守效率
	 * 
	 * @param scoreOfCompetitor
	 *            对手得分
	 * @param shootOfCompetitor
	 *            对手投篮数
	 * @param foulOfCompetitor
	 *            对手罚球数
	 * @param offensiveReboundOfCompetitor
	 *            对手进攻篮板
	 * @param defensiveRebound
	 *            我方防守篮板
	 * @param missOfCompetitor
	 *            对手投失球
	 * @param turnoverOfCompetitor
	 *            对手失误数
	 * @return
	 */
	public static double calDefensiveEfficiency(double scoreOfCompetitor, int shootOfCompetitor, int foulOfCompetitor,
			int offensiveReboundOfCompetitor, int defensiveRebound, int missOfCompetitor, int turnoverOfCompetitor) {
		double offensiveNum = calOffensiveNum(shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor,
				defensiveRebound, missOfCompetitor, turnoverOfCompetitor);
		if (offensiveNum == 0) {
			return 0;
		} else {
			double result = (double)scoreOfCompetitor * 100 / (double)offensiveNum;
			return cutToTwo(result);
		}
	}

	/**
	 * 计算进攻篮板效率
	 * 
	 * @param reboundBefore
	 *            前场篮板数量(进攻)
	 * @param reboundBehindOfCompetitor
	 *            对方后场篮板数量（防守）
	 * @return
	 */
	public static double calOffensiveReboundEfficiency(int reboundBefore, int reboundBehindOfCompetitor) {
		int total = reboundBefore + reboundBehindOfCompetitor;
		if (total == 0) {
			return 0;
		} else {
			double result = (double)reboundBefore / (double)total;
			return cutToTwo(result);
		}
	}

	/**
	 * 计算防守篮板效率
	 * 
	 * @param reboundBehind
	 *            后场篮板数量
	 * @param reboundBeforeOfCompetitor
	 *            对手前场篮板数量
	 * @return
	 */
	public static double calDefensiveReboundEfficiency(int reboundBehind, int reboundBeforeOfCompetitor) {
		double total = reboundBehind + reboundBeforeOfCompetitor;
		if (total == 0) {
			return 0;
		} else {
			double result = (double)reboundBehind / (double)total;
			return cutToTwo(result);
		}
	}

	/**
	 * 计算抢断效率
	 * 
	 * @param steal
	 *            抢断数量
	 * @param shootOfCompetitor
	 *            对手投篮数
	 * @param foulOfCompetitor
	 *            对手罚球数
	 * @param offensiveReboundOfCompetitor
	 *            对手进攻篮板
	 * @param defensiveRebound
	 *            我方防守篮板
	 * @param missOfCompetitor
	 *            对手投失球
	 * @param turnoverOfCompetitor
	 *            对手失误数
	 * @return
	 */
	public static double calStealEfficiency(int steal, int shootOfCompetitor, int foulOfCompetitor,
			int offensiveReboundOfCompetitor, int defensiveRebound, int missOfCompetitor, int turnoverOfCompetitor) {
		double OffensiveNum = calOffensiveNum(shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor,
				defensiveRebound, missOfCompetitor, turnoverOfCompetitor);
		if (OffensiveNum == 0) {
			return 0;
		} else {
			double result = (double)steal * 100 / (double)OffensiveNum;
			return cutToTwo(result);
		}
	}

	/**
	 * 计算助攻率
	 * 
	 * @param assist
	 *            球队助攻数量
	 * @param shoot
	 *            投篮数
	 * @param foul
	 *            球队罚球数
	 * @param offensiveRebound
	 *            本队进攻篮板
	 * @param defensiveReboundOfCompetitor
	 *            对手防守篮板
	 * @param miss
	 *            投失球
	 * @param turnover
	 *            失误数
	 * @return
	 */
	public static double calAssistRate(int assist, int shoot, int foul, int offensiveRebound,
			int defensiveReboundOfCompetitor, int miss, int turnover) {
		double offensiveNum = calOffensiveNum(shoot, foul, offensiveRebound, defensiveReboundOfCompetitor, miss,
				turnover);
		if (offensiveNum == 0) {
			return 0;
		} else {
			double result = (double)assist * 100 / (double)offensiveNum;
			return cutToTwo(result);
		}
	}

	public static double cutToTwo(double number) {
		BigDecimal bigDecimal = new BigDecimal(number);
		double result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}// 保留两位小数
}
