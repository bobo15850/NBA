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
			return cutTail(result);
		}
	}// 计算平均数

	public static double calHitRate(double hitNum, double shootNum) {
		if (shootNum == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = hitNum / shootNum;
			return cutTail(result);
		}
	}// 计算命中率

	public static double calWinRate(int winNum, int totalNum) {
		if (totalNum == 0) {
			return 0;
		}
		else {
			double result = (double) winNum / (double) totalNum;
			return cutTail(result);
		}
	}// 计算胜率

	public static double calOffensiveNum(double shoot, double foul, double offensiveRebound, double defensiveReboundOfCompetitor, double miss,
			double turnover) {
		double totalNumber = offensiveRebound + defensiveReboundOfCompetitor;
		if (totalNumber == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = shoot + 0.4 * foul - (1.07 * ((double) offensiveRebound / (double) (offensiveRebound + defensiveReboundOfCompetitor) * miss))
					+ (1.07 * turnover);
			return cutTail(result);
		}
	}// 计算进攻回合数

	public static double calOffensiveEfficiency(double score, double shoot, double foul, double offensiveRebound,
			double defensiveReboundOfCompetitor, double miss, double turnover) {
		double offensiveNum = calOffensiveNum(shoot, foul, offensiveRebound, defensiveReboundOfCompetitor, miss, turnover);
		if (offensiveNum == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = (double) score * 100 / (double) offensiveNum;
			return cutTail(result);
		}
	}// 计算进攻效率

	public static double calDefensiveEfficiency(double scoreOfCompetitor, double shootOfCompetitor, double foulOfCompetitor,
			double offensiveReboundOfCompetitor, double defensiveRebound, double missOfCompetitor, double turnoverOfCompetitor) {
		double offensiveNum = calOffensiveNum(shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor, defensiveRebound, missOfCompetitor,
				turnoverOfCompetitor);
		if (offensiveNum == 0) {
			return 0;
		}
		else {
			double result = (double) scoreOfCompetitor * 100 / (double) offensiveNum;
			return cutTail(result);
		}
	}// 计算防守效率

	public static double calOffensiveReboundEfficiency(double reboundBefore, double reboundBehindOfCompetitor) {
		double total = reboundBefore + reboundBehindOfCompetitor;
		if (total == 0) {
			return 0;
		}
		else {
			double result = (double) reboundBefore / (double) total;
			return cutTail(result);
		}
	}// 计算进攻篮板效率

	public static double calDefensiveReboundEfficiency(double reboundBehind, double reboundBeforeOfCompetitor) {
		double total = reboundBehind + reboundBeforeOfCompetitor;
		if (total == 0) {
			return 0;
		}
		else {
			double result = (double) reboundBehind / (double) total;
			return cutTail(result);
		}
	}// 计算防守篮板效率

	public static double calStealEfficiency(double steal, double shootOfCompetitor, double foulOfCompetitor, double offensiveReboundOfCompetitor,
			double defensiveRebound, double missOfCompetitor, double turnoverOfCompetitor) {
		double OffensiveNum = calOffensiveNum(shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor, defensiveRebound, missOfCompetitor,
				turnoverOfCompetitor);
		if (OffensiveNum == 0) {
			return 0;
		}
		else {
			double result = (double) steal * 100 / (double) OffensiveNum;
			return cutTail(result);
		}
	}// 计算抢断率

	public static double calAssistRate(double assist, double shoot, double foul, double offensiveRebound, double defensiveReboundOfCompetitor,
			double miss, double turnover) {
		double offensiveNum = calOffensiveNum(shoot, foul, offensiveRebound, defensiveReboundOfCompetitor, miss, turnover);
		if (offensiveNum == 0) {
			return 0;
		}
		else {
			double result = (double) assist * 100 / (double) offensiveNum;
			return cutTail(result);
		}
	}// 计算助攻率

	public static double cutTail(double number) {
		BigDecimal bigDecimal = new BigDecimal(number);
		double result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}// 保留四位小数
}
