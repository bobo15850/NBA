package businesslogic.teams;

import java.math.BigDecimal;

/*
 * 用以计算xx率
 */
public class CalculationOfTeamPerform {
	public static double average(double num, int time) {
		if (time == 0) {
			return 0;
		}
		else {
			double result = num / time;
			return cutToTwo(result);
		}
	}// 计算平均数

	public static double calHitRate(int hitNum, int shootNum) {
		if (shootNum == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = (double) hitNum / (double) shootNum;
			return cutToTwo(result);
		}
	}// 计算命中率

	public static double calWinRate(int winNum, int totalNum) {
		if (totalNum == 0) {
			return 0;
		}
		else {
			double result = (double) winNum / (double) totalNum;
			return cutToTwo(result);
		}
	}// 计算胜率

	public static double calOffensiveNum(int shoot, int foul, int offensiveRebound, int defensiveReboundOfCompetitor, int miss, int turnover) {
		int totalNumber = offensiveRebound + defensiveReboundOfCompetitor;
		if (totalNumber == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = shoot + 0.4 * foul - (1.07 * ((double) offensiveRebound / (double) (offensiveRebound + defensiveReboundOfCompetitor) * miss))
					+ (1.07 * turnover);
			return cutToTwo(result);
		}
	}// 计算进攻回合数

	public static double calOffensiveEfficiency(double score, int shoot, int foul, int offensiveRebound, int defensiveReboundOfCompetitor, int miss,
			int turnover) {
		double offensiveNum = calOffensiveNum(shoot, foul, offensiveRebound, defensiveReboundOfCompetitor, miss, turnover);
		if (offensiveNum == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = (double) score * 100 / (double) offensiveNum;
			return cutToFour(result);
		}
	}// 计算进攻效率

	public static double calDefensiveEfficiency(double scoreOfCompetitor, int shootOfCompetitor, int foulOfCompetitor,
			int offensiveReboundOfCompetitor, int defensiveRebound, int missOfCompetitor, int turnoverOfCompetitor) {
		double offensiveNum = calOffensiveNum(shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor, defensiveRebound, missOfCompetitor,
				turnoverOfCompetitor);
		if (offensiveNum == 0) {
			return 0;
		}
		else {
			double result = (double) scoreOfCompetitor * 100 / (double) offensiveNum;
			return cutToFour(result);
		}
	}// 计算防守效率

	public static double calOffensiveReboundEfficiency(int reboundBefore, int reboundBehindOfCompetitor) {
		int total = reboundBefore + reboundBehindOfCompetitor;
		if (total == 0) {
			return 0;
		}
		else {
			double result = (double) reboundBefore / (double) total;
			return cutToFour(result);
		}
	}// 计算进攻篮板效率

	public static double calDefensiveReboundEfficiency(int reboundBehind, int reboundBeforeOfCompetitor) {
		double total = reboundBehind + reboundBeforeOfCompetitor;
		if (total == 0) {
			return 0;
		}
		else {
			double result = (double) reboundBehind / (double) total;
			return cutToFour(result);
		}
	}// 计算防守篮板效率

	public static double calStealEfficiency(int steal, int shootOfCompetitor, int foulOfCompetitor, int offensiveReboundOfCompetitor,
			int defensiveRebound, int missOfCompetitor, int turnoverOfCompetitor) {
		double OffensiveNum = calOffensiveNum(shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor, defensiveRebound, missOfCompetitor,
				turnoverOfCompetitor);
		if (OffensiveNum == 0) {
			return 0;
		}
		else {
			double result = (double) steal * 100 / (double) OffensiveNum;
			return cutToFour(result);
		}
	}// 计算抢断率

	public static double calAssistRate(int assist, int shoot, int foul, int offensiveRebound, int defensiveReboundOfCompetitor, int miss, int turnover) {
		double offensiveNum = calOffensiveNum(shoot, foul, offensiveRebound, defensiveReboundOfCompetitor, miss, turnover);
		if (offensiveNum == 0) {
			return 0;
		}
		else {
			double result = (double) assist * 100 / (double) offensiveNum;
			return cutToFour(result);
		}
	}// 计算助攻率

	public static double cutToTwo(double number) {
		BigDecimal bigDecimal = new BigDecimal(number);
		double result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}// 保留两位小数

	public static double cutToFour(double number) {
		BigDecimal bigDecimal = new BigDecimal(number);
		double result = bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}// 保留四位小数
}
