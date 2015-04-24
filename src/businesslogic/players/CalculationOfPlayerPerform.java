package businesslogic.players;

import java.math.BigDecimal;

/*
 * 用以计算xx率
 */
public class CalculationOfPlayerPerform {

	public static double calHitRate(final double hitNum, final double shootNum) {
		if (shootNum == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = hitNum / shootNum;
			return cutTail(result);
		}
	}// 计算命中率

	public static double calEfficiency(final double score, final double rebound, final double assist, final double steal, final double block,
			final double shoot, double hit, final double freePointShoot, final double freePointHit, final double turnover, final double numberOfMatch) {
		if (numberOfMatch == 0) {
			return 0;
		}
		else {
			double result = (score + rebound + assist + steal + block) - (shoot - hit) - (freePointShoot - freePointHit) - turnover;
			result = result / numberOfMatch;
			return cutTail(result);
		}
	}// 计算效率

	public static double calImproveRateInFiveMatch(double beforeScore, double afterScore) {
		double result = (afterScore - beforeScore) / beforeScore;
		return cutTail(result);
	}// 计算提升率

	public static double calGmSc(double score, double d, double e, double f, double g, double h, double i, double j, double k, double l, double m,
			double n, int numberOfMatch) {
		if (numberOfMatch == 0) {
			return 0;
		}
		else {
			double result = score + 0.4 * d - 0.7 * e - 0.4 * (f - g) + 0.7 * h + 0.3 * i + j + 0.7 * k + 0.7 * l - 0.4 * m - n;
			result = result / numberOfMatch;
			return cutTail(result);
		}
	}// 计算GMSC效率

	public static double calRealShot(double score, double shoot, double freePointShoot) {
		if (shoot == 0 && freePointShoot == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = score / (double) (2 * (shoot + 0.44 * freePointShoot));
			return cutTail(result);
		}
	}// 计算真实命中率

	public static double calShotEfficiency(double hit, double threePointHit, double shoot) {
		if (shoot == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = ((double) (hit + 0.5 * threePointHit)) / (double) shoot;
			return cutTail(result);
		}
	}// 计算投篮效率

	public static double calReboundEfficient(double rebound, double timeOfAllPlayer, double playingTime, double totalReboundOfTeam,
			double totalReboundOfCompetitor) {
		double total = totalReboundOfTeam + totalReboundOfCompetitor;
		if (playingTime == 0 || total == 0) {
			return 0;
		}
		else {
			double result = (timeOfAllPlayer / playingTime) / 5 * rebound / total;
			return cutTail(result);
		}
	}// 计算篮板率

	public static double calAssistEfficient(double assist, double playingTime, double timeOfAllPlayer, double hitOfAllPlayer, double hitOfOnePlayer) {
		if (playingTime == 0 || timeOfAllPlayer == 0) {
			return 0;
		}
		else {
			double result = assist / ((playingTime / timeOfAllPlayer) * 5 * hitOfAllPlayer - hitOfOnePlayer);
			return cutTail(result);
		}
	}// 计算助攻率

	public static double calStealEfficient(double steal, double timeOfAllPlayer, double playingTime, double offensiveNumOfCompetitor) {
		if (playingTime == 0 || offensiveNumOfCompetitor == 0) {
			return 0;
		}
		else {
			double result = steal * (timeOfAllPlayer / playingTime) / 5 / offensiveNumOfCompetitor;
			return cutTail(result);
		}
	}// 计算抢断率

	public static double calBlockShotEfficient(double block, double timeOfAllPlayer, double playingTime, double twoPointShootNumOfCompetitor) {
		if (playingTime == 0 || twoPointShootNumOfCompetitor == 0) {
			return 0;
		}
		else {
			double result = block * (timeOfAllPlayer / playingTime) / 5 / twoPointShootNumOfCompetitor;
			return cutTail(result);
		}
	}// 计算该盖帽率

	public static double calFaultEfficient(double faultNum, double twoPointShootNum, double freePointShootNum) {
		if (faultNum == 0 && twoPointShootNum == 0 && freePointShootNum == 0) {
			return 0;
		}
		else {
			double result = 0;
			result = (double) faultNum / (double) (twoPointShootNum + 0.44 * freePointShootNum + faultNum);
			return cutTail(result);
		}
	}// 计算失误率

	public static double calFrequency(double shootNum, double freePointShootNum, double faultNum, double timeOfAllPlayer, double playingTime,
			double shootNumOfAllPlayer, double freePointShootNumOfAllPlayer, double faultNumOfAllPlayer) {
		double temp = shootNumOfAllPlayer + 0.44 * freePointShootNumOfAllPlayer + faultNumOfAllPlayer;
		if (temp == 0 || timeOfAllPlayer == 0 || playingTime == 0) {
			return 0;
		}
		else {
			double result = (shootNum + 0.44 * freePointShootNum + faultNum) * (timeOfAllPlayer / playingTime) / 5 / temp;
			return cutTail(result);
		}
	}// 计算使用率

	public static double cutTail(double number) {
		BigDecimal bigDecimal = new BigDecimal(number);
		double result = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return result;
	}// 保留四位小数
}
