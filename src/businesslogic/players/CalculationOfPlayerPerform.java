package businesslogic.players;

import java.math.BigDecimal;

import common.mydatastructure.MyTime;

/*
 * 用以计算xx率
 */
public class CalculationOfPlayerPerform {

	public static double calHitRate(int hitNum, int shootNum) {
		if (shootNum == 0) {
			return 0;
		} else {
			double result = 0;
			result = (double) hitNum / (double) shootNum;
			return cutToTwo(result);
		}
	}// 计算命中率

	public static double calCommonEfficiency(double score, double rebound, double assist, double steal, double block, int shoot, int hit,
			int freePointShoot, int freePointHit, int turnover, int numberOfMatch) {
		if (numberOfMatch == 0) {
			return 0;
		} else {
			double result = (score + rebound + assist + steal + block) - (shoot - hit) - (freePointShoot - freePointHit) - turnover;
			result = result / numberOfMatch;
			return cutToTwo(result);
		}
	}// 计算效率

	public static double calImproveRateInFiveMatch(double beforeScore, double afterScore) {
		double result = (afterScore - beforeScore) / beforeScore;
		return cutToTwo(result);
	}// 计算提升率

	public static double calGmScEfficiency(double score, int hit, int shoot, int freePointShoot, int freePointHit, int reboundBefore,
			int reboundAfter, int steal, int assist, int block, int foul, int turnover, int numberOfMatch) {
		if (numberOfMatch == 0) {
			return 0;
		} else {
			double result = score + 0.4 * hit - 0.7 * shoot - 0.4 * (freePointShoot - freePointHit) + 0.7 * reboundBefore + 0.3 * reboundAfter
					+ steal + 0.7 * assist + 0.7 * block - 0.4 * foul - turnover;
			result = result / numberOfMatch;
			return cutToTwo(result);
		}
	}// 计算GMSC效率

	public static double calRealHitRate(double score, int shoot, int freePointShoot) {
		if (shoot == 0 && freePointShoot == 0) {
			return 0;
		} else {
			double result = 0;
			result = score / (double) (2 * (shoot + 0.44 * freePointShoot));
			return cutToTwo(result);
		}
	}// 计算真实命中率

	public static double calShootEfficiency(int hit, int threePointHit, int shoot) {
		if (shoot == 0) {
			return 0;
		} else {
			double result = 0;
			result = ((double) (hit + 0.5 * threePointHit)) / (double) shoot;
			return cutToTwo(result);
		}
	}// 计算投篮效率

	public static double calReboundRate(int rebound, MyTime timeOfAllPlayer, MyTime playingTime, int totalReboundOfTeam,
			int totalReboundOfCompetitor) {
		int total = totalReboundOfTeam + totalReboundOfCompetitor;
		if (!playingTime .isCorrectRead() || total == 0) {
			return 0;
		} else {
			double result = timeOfAllPlayer.divide(playingTime)/ 5 * rebound / total;
			return cutToFour(result);
		}
	}// 计算篮板率

	public static double calAssistRate(int assist, MyTime playingTime, MyTime timeOfAllPlayer, int hitOfAllPlayer, int hitOfOnePlayer) {
		if (!playingTime.isCorrectRead() || !timeOfAllPlayer.isCorrectRead()) {
			return 0;
		} else {
			double result = assist / (playingTime .divide(timeOfAllPlayer)*5 * hitOfAllPlayer - hitOfOnePlayer);
			return cutToFour(result);
		}
	}// 计算助攻率

	public static double calStealRate(int steal, MyTime timeOfAllPlayer, MyTime playingTime, int offensiveNumOfCompetitor) {
		if (!playingTime.isCorrectRead() || offensiveNumOfCompetitor == 0) {
			return 0;
		} else {
			double result = steal * timeOfAllPlayer.divide(playingTime)/ 5 / offensiveNumOfCompetitor;
			return cutToFour(result);
		}
	}// 计算抢断率

	public static double calBlockRate(int block, MyTime timeOfAllPlayer, MyTime playingTime, double twoPointShootNumOfCompetitor) {
		if (!playingTime.isCorrectRead()|| twoPointShootNumOfCompetitor == 0) {
			return 0;
		} else {
			double result = block * timeOfAllPlayer.divide(playingTime)/ 5/ twoPointShootNumOfCompetitor;
			return cutToFour(result);
		}
	}// 计算该盖帽率

	public static double calTurnoverRate(int turnoverNum, int twoPointShootNum, int freePointShootNum) {
		if (turnoverNum == 0 && twoPointShootNum == 0 && freePointShootNum == 0) {
			return 0;
		} else {
			double result = 0;
			result = (double) turnoverNum / (double) (twoPointShootNum + 0.44 * freePointShootNum + turnoverNum);
			return cutToFour(result);
		}
	}// 计算失误率

	public static double calUseRate(int shootNum, int freePointShootNum, int turnoverNum, MyTime timeOfAllPlayer, MyTime playingTime,
			int shootNumOfAllPlayer, int freePointShootNumOfAllPlayer, int turnoverNumOfAllPlayer) {
		double temp = shootNumOfAllPlayer + 0.44 * freePointShootNumOfAllPlayer + freePointShootNumOfAllPlayer;
		if (temp == 0 || !timeOfAllPlayer .isCorrectRead() ||! playingTime.isCorrectRead()) {
			return 0;
		} else {
			double result = (shootNum + 0.44 * freePointShootNum + turnoverNum) * timeOfAllPlayer.divide(playingTime)/ 5 / temp;
			return cutToFour(result);
		}
	}// 计算使用率

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
