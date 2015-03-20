package businesslogic.players;

import java.text.NumberFormat;

/*
 * 用以计算xx率
 */
public class CalculationOfPlayerPerform {
	/**
	 * 计算命中率
	 * 
	 * @param hitNum
	 *            命中数
	 * @param shootNum
	 *            出手数
	 * @return 保留两位有效数字
	 */
	public static double calHitRate(double hitNum, double shootNum) {
		if (shootNum == 0) {
			return 0;
		} else {
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setMaximumFractionDigits(2);
			return Double.parseDouble(nf.format(hitNum / shootNum));
		}
	}// ////////////////////////////添加除数为零的情况

	/**
	 * 计算效率
	 * 
	 * @param score
	 *            得分
	 * @param rebound
	 *            篮板
	 * @param assist
	 *            助攻
	 * @param steal
	 *            抢断
	 * @param block
	 *            盖帽
	 * @param shoot
	 *            出手次数
	 * @param hit
	 *            命中次数
	 * @param freePointShoot
	 *            罚球次数
	 * @param freePointHit
	 *            罚球命中次数
	 * @param turnover
	 *            失误次数
	 * @return 保留两位有效数字 效率
	 */
	public static double calCommonEfficiency(double score, double rebound, double assist, double steal, double block,
			int shoot, int hit, int freePointShoot, int freePointHit, int turnover) {
		double result = 0;
		result = (score + rebound + assist + steal + block) - (shoot + hit) - (freePointShoot - freePointHit)
				- turnover;
		System.out.println(result);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}

	/**
	 * 计算近五场的提升率
	 * 
	 * @param beforeScore
	 *            五场前的平均得分
	 * @param afterScore
	 *            五场后的平均得分
	 * @return double 提升率 保留两位有效数字
	 */
	public static double calImproveRateInFiveMatch(double beforeScore, double afterScore) {
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format((afterScore - beforeScore) / beforeScore));

	}

	/**
	 * 计算GmSc效率值
	 * 
	 * @param score
	 *            得分
	 * @param hit
	 *            投篮命中数
	 * @param shoot
	 *            投篮出手数
	 * @param freePointShoot
	 *            罚球出手数
	 * @param freePointHit
	 *            罚球命中数
	 * @param reboundBefore
	 *            前场篮板数
	 * @param reboundAfter
	 *            后场篮板数
	 * @param steal
	 *            抢断数
	 * @param assist
	 *            助攻数
	 * @param block
	 *            盖帽数
	 * @param foul
	 *            犯规数
	 * @param turnover
	 *            失误数
	 * @return double GmSc效率值
	 */
	public static double calGmScEfficiency(double score, int hit, int shoot, int freePointShoot, int freePointHit,
			int reboundBefore, int reboundAfter, int steal, int assist, int block, int foul, int turnover) {
		double result = 0;
		result = score + 0.4 * hit - 0.7 * shoot - 0.4 * (freePointShoot - freePointHit) + 0.7 * reboundBefore + 0.3
				* reboundAfter + steal + 0.7 * assist + 0.7 * block - 0.4 * foul - turnover;
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}

	/**
	 * 计算真实投篮命中率
	 * 
	 * @param score
	 *            得分
	 * @param shoot
	 *            投篮出手数
	 * @param freePointShoot
	 *            罚球出手数
	 * @return 真实投篮命中率 保留两位有效数字
	 */
	public static double calRealHitRate(double score, int shoot, int freePointShoot) {
		double result = 0;
		result = score / (2 * (shoot + 0.44 * freePointShoot));
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));
	}

	/**
	 * 计算投篮效率
	 * 
	 * @param hit
	 *            投篮命中数
	 * @param threePointHit
	 *            三分命中数
	 * @param shoot
	 *            投篮出手数
	 * @return 投篮效率
	 */
	public static double calShootEfficiency(int hit, int threePointHit, int shoot) {
		if (shoot == 0) {
			return 0;
		} else {
			double result = 0;
			result = (hit + 0.5 * threePointHit) / shoot;
			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setMaximumFractionDigits(2);
			return Double.parseDouble(nf.format(result));
		}
	}// ////////////////////////////添加除数为零的情况

	/**
	 * 计算篮板率或进攻篮板率或防守篮板率
	 * 
	 * @param rebound
	 *            球员篮板数/进攻篮板数/防守篮板数
	 * @param timeOfAllPlayer
	 *            球队所有球员上场时间
	 * @param timeOfOnePlayer
	 *            球员上场时间
	 * @param totalReboundOfTeam
	 *            球队总篮板
	 * @param totalReboundOfCompetitor
	 *            对手总篮板
	 * @return double
	 */
	public static double calReboundRate(int rebound, double timeOfAllPlayer, double timeOfOnePlayer,
			int totalReboundOfTeam, int totalReboundOfCompetitor) {
		double result = 0;
		result = rebound * (timeOfAllPlayer / 5) / timeOfOnePlayer / (totalReboundOfTeam + totalReboundOfCompetitor);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}

	/**
	 * 计算助攻率
	 * 
	 * @param assist
	 *            球员助攻数
	 * @param timeOfOnePlayer
	 *            球员上场时间
	 * @param timeOfAllPlayer
	 *            球队所有球员上场时间
	 * @param hitOfAllPlayer
	 *            球队总进球数
	 * @param hitOfOnePlayer
	 *            球员进球数
	 * @return 助攻率
	 */
	public static double calAssistRate(int assist, double timeOfOnePlayer, double timeOfAllPlayer, int hitOfAllPlayer,
			int hitOfOnePlayer) {
		double result = 0;
		result = assist / (timeOfOnePlayer / (timeOfAllPlayer / 5) * hitOfAllPlayer - hitOfOnePlayer);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}

	/**
	 * 计算抢断率
	 * 
	 * @param steal
	 *            球员抢断数
	 * @param timeOfAllPlayer
	 *            球队所有球员上场时间
	 * @param timeOfOnePlayer
	 *            球员上场时间
	 * @param offensiveNumOfCompetitor
	 *            对手进攻次数
	 * @return 抢断率
	 */
	public static double calStealRate(int steal, double timeOfAllPlayer, double timeOfOnePlayer,
			int offensiveNumOfCompetitor) {
		double result = 0;
		result = steal * (timeOfAllPlayer / 5) / timeOfOnePlayer / offensiveNumOfCompetitor;
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}

	/**
	 * 计算盖帽率
	 * 
	 * @param block
	 *            球员盖帽数
	 * @param timeOfAllPlayer
	 *            球队所有球员上场时间
	 * @param timeOfOnePlayer
	 *            球员上场时间
	 * @param TwoPointNumOfCompetitor
	 *            对手两分球出手次数
	 * @return 盖帽率
	 */
	public static double calBlockRate(int block, double timeOfAllPlayer, double timeOfOnePlayer,
			double TwoPointNumOfCompetitor) {
		double result = 0;
		result = block * (timeOfAllPlayer / 5) / timeOfOnePlayer / TwoPointNumOfCompetitor;
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}

	/**
	 * 计算失误率
	 * 
	 * @param turnover
	 *            球员失误数
	 * @param twoPointNumOfOnePlayer
	 *            球员两分球出手次数
	 * @param freePoint
	 *            球员罚球次数
	 * @return 失误率
	 */
	public static double calTurnoverRate(int turnover, int twoPointNumOfOnePlayer, int freePoint) {
		double result = 0;
		result = turnover / (twoPointNumOfOnePlayer + 0.44 * freePoint + turnover);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}

	/**
	 * 计算使用率
	 * 
	 * @param shoot
	 *            球员出手次数
	 * @param freePoint
	 *            球员罚球次数
	 * @param turnover
	 *            球员失误次数
	 * @param timeOfAllPlayer
	 *            球队所有球员上场时间
	 * @param timeOfOnePlayer
	 *            球员上场时间
	 * @param shootNumOfAllPlayer
	 *            球队所有球员出手次数
	 * @param freePointNumOfAllPlayer
	 *            球队所有球员罚球次数
	 * @param turnoverOfAllPlayer
	 *            球队所有球员失误次数
	 * @return 使用率
	 */
	public static double calUseRate(int shoot, int freePoint, int turnover, double timeOfAllPlayer,
			double timeOfOnePlayer, int shootNumOfAllPlayer, int freePointNumOfAllPlayer, int turnoverOfAllPlayer) {
		double result = 0;
		result = (shoot + 0.44 * freePoint + turnover) * (timeOfAllPlayer / 5) / timeOfOnePlayer
				/ (shootNumOfAllPlayer + 0.44 * freePointNumOfAllPlayer + freePointNumOfAllPlayer);
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
}
