package vo;

public class OneTeamPerformOfOneSeasonVo {
	private String teamNameForShort;// 球队名称缩写
	private int numberOfMatch;// 比赛场数
	//
	private int totalHitNumber;// 总命中数
	private int totalShootNumber;// 总出手数
	private int threePointHitNumber;// 三分命中数
	private int threePointShootNumber;// 三分出手数
	private int freePointHitNumber;// 罚球命中数
	private int freePointShootNumber;// 罚球出手数
	private int offensiveReboundNumber;// 进攻篮板数
	private int defensiveReboundNumber;// 防守篮板
	private int totalReboundNumber;// 总篮板
	private int assistNumber;// 总助攻
	private int stealNumber;// 抢断数
	private int blockNumber;// 盖帽数
	private int turnoverNumber;// 失误数
	private int foulNumber;// 犯规数
	private int scoreNumber;// 得分数
	private double offensiveNumber;// 进攻回合数
	//
	private double averageTotalHitNumber;// 场均命中数
	private double averageTotalShootNumber;// 场均总出手数
	private double averageThreePointHitNumber;// 场均三分命中数
	private double averageThreePointShootNumber;// 场均三分出手数
	private double averageFreePointHitNumber;// 场均罚球命中数
	private double averageFreePointShootNumber;// 场均罚球出手数
	private double averageOffensiveReboundNumber;// 场均进攻篮板数
	private double averageDefensiveReboundNumber;// 场均防守篮板
	private double averageTotalReboundNumber;// 场均总篮板
	private double averageAssistNumber;// 场均助攻数
	private double averageStealNumber;// 场均抢断数
	private double averageBlockNumber;// 场均盖帽数
	private double averageTurnoverNumber;// 场均失误数
	private double averageFoulNumber;// 场均犯规数
	private double averageScoreNumber;// 场均得分数
	private double averageOffensiveNumber;// 场均进攻回合数
	//
	private double totalHitRate;// 投篮命中率
	private double threePointHitRate;// 三分命中率
	private double freePointHitRate;// 罚球命中率
	private double winRate;// 胜率
	private double offensiveEfficiency;// 进攻效率
	private double defensiveEfficiency;// 防守效率
	private double reboundEfficiency;// 篮板效率
	private double stealEfficiency;// 抢断率
	private double assistEfficiency;// 助攻率

	public String getTeamName() {
		return teamNameForShort;
	}

	public void setTeamName(String teamName) {
		this.teamNameForShort = teamName;
	}

	public int getNumberOfMatch() {
		return numberOfMatch;
	}

	public void setNumberOfMatch(int numberOfMatch) {
		this.numberOfMatch = numberOfMatch;
	}

	public int getTotalHitNumber() {
		return totalHitNumber;
	}

	public void setTotalHitNumber(int totalHitNumber) {
		this.totalHitNumber = totalHitNumber;
	}

	public int getTotalShootNumber() {
		return totalShootNumber;
	}

	public void setTotalShootNumber(int totalShootNumber) {
		this.totalShootNumber = totalShootNumber;
	}

	public int getThreePointHitNumber() {
		return threePointHitNumber;
	}

	public void setThreePointHitNumber(int threePointHitNumber) {
		this.threePointHitNumber = threePointHitNumber;
	}

	public int getThreePointShootNumber() {
		return threePointShootNumber;
	}

	public void setThreePointShootNumber(int threePointShootNumber) {
		this.threePointShootNumber = threePointShootNumber;
	}

	public int getFreePointHitNumber() {
		return freePointHitNumber;
	}

	public void setFreePointHitNumber(int freePointHitNumber) {
		this.freePointHitNumber = freePointHitNumber;
	}

	public int getFreePointShootNumber() {
		return freePointShootNumber;
	}

	public void setFreePointShootNumber(int freePointShootNumber) {
		this.freePointShootNumber = freePointShootNumber;
	}

	public int getOffensiveReboundNumber() {
		return offensiveReboundNumber;
	}

	public void setOffensiveReboundNumber(int offensiveReboundNumber) {
		this.offensiveReboundNumber = offensiveReboundNumber;
	}

	public int getDefensiveReboundNumber() {
		return defensiveReboundNumber;
	}

	public void setDefensiveReboundNumber(int defensiveReboundNumber) {
		this.defensiveReboundNumber = defensiveReboundNumber;
	}

	public int getTotalReboundNumber() {
		return totalReboundNumber;
	}

	public void setTotalReboundNumber(int totalReboundNumber) {
		this.totalReboundNumber = totalReboundNumber;
	}

	public int getAssistNumber() {
		return assistNumber;
	}

	public void setAssistNumber(int assistNumber) {
		this.assistNumber = assistNumber;
	}

	public int getStealNumber() {
		return stealNumber;
	}

	public void setStealNumber(int stealNumber) {
		this.stealNumber = stealNumber;
	}

	public int getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}

	public int getTurnoverNumber() {
		return turnoverNumber;
	}

	public void setTurnoverNumber(int turnoverNumber) {
		this.turnoverNumber = turnoverNumber;
	}

	public int getFoulNumber() {
		return foulNumber;
	}

	public void setFoulNumber(int foulNumber) {
		this.foulNumber = foulNumber;
	}

	public int getScoreNumber() {
		return scoreNumber;
	}

	public void setScoreNumber(int scoreNumber) {
		this.scoreNumber = scoreNumber;
	}

	public double getOffensiveNumber() {
		return offensiveNumber;
	}

	public void setOffensiveNumber(double offensiveNumber2) {
		this.offensiveNumber = offensiveNumber2;
	}

	public double getAverageTotalHitNumber() {
		return averageTotalHitNumber;
	}

	public void setAverageTotalHitNumber(double averageTotalHitNumber) {
		this.averageTotalHitNumber = averageTotalHitNumber;
	}

	public double getAverageTotalShootNumber() {
		return averageTotalShootNumber;
	}

	public void setAverageTotalShootNumber(double averageTotalShootNumber) {
		this.averageTotalShootNumber = averageTotalShootNumber;
	}

	public double getAverageThreePointHitNumber() {
		return averageThreePointHitNumber;
	}

	public void setAverageThreePointHitNumber(double averageThreePointHitNumber) {
		this.averageThreePointHitNumber = averageThreePointHitNumber;
	}

	public double getAverageThreePointShootNumber() {
		return averageThreePointShootNumber;
	}

	public void setAverageThreePointShootNumber(double averageThreePointShootNumber) {
		this.averageThreePointShootNumber = averageThreePointShootNumber;
	}

	public double getAverageFreePointHitNumber() {
		return averageFreePointHitNumber;
	}

	public void setAverageFreePointHitNumber(double averageFreePointHitNumber) {
		this.averageFreePointHitNumber = averageFreePointHitNumber;
	}

	public double getAverageFreePointShootNumber() {
		return averageFreePointShootNumber;
	}

	public void setAverageFreePointShootNumber(double averageFreePointShootNumber) {
		this.averageFreePointShootNumber = averageFreePointShootNumber;
	}

	public double getAverageOffensiveReboundNumber() {
		return averageOffensiveReboundNumber;
	}

	public void setAverageOffensiveReboundNumber(double averageOffensiveReboundNumber) {
		this.averageOffensiveReboundNumber = averageOffensiveReboundNumber;
	}

	public double getAverageDefensiveReboundNumber() {
		return averageDefensiveReboundNumber;
	}

	public void setAverageDefensiveReboundNumber(double averageDefensiveReboundNumber) {
		this.averageDefensiveReboundNumber = averageDefensiveReboundNumber;
	}

	public double getAverageTotalReboundNumber() {
		return averageTotalReboundNumber;
	}

	public void setAverageTotalReboundNumber(double averageTotalReboundNumber) {
		this.averageTotalReboundNumber = averageTotalReboundNumber;
	}

	public double getAverageAssistNumber() {
		return averageAssistNumber;
	}

	public void setAverageAssistNumber(double averageAssistNumber) {
		this.averageAssistNumber = averageAssistNumber;
	}

	public double getAverageStealNumber() {
		return averageStealNumber;
	}

	public void setAverageStealNumber(double averageStealNumber) {
		this.averageStealNumber = averageStealNumber;
	}

	public double getAverageBlockNumber() {
		return averageBlockNumber;
	}

	public void setAverageBlockNumber(double averageBlockNumber) {
		this.averageBlockNumber = averageBlockNumber;
	}

	public double getAverageTurnoverNumber() {
		return averageTurnoverNumber;
	}

	public void setAverageTurnoverNumber(double averageTurnoverNumber) {
		this.averageTurnoverNumber = averageTurnoverNumber;
	}

	public double getAverageFoulNumber() {
		return averageFoulNumber;
	}

	public void setAverageFoulNumber(double averageFoulNumber) {
		this.averageFoulNumber = averageFoulNumber;
	}

	public double getAverageScoreNumber() {
		return averageScoreNumber;
	}

	public void setAverageScoreNumber(double averageScoreNumber) {
		this.averageScoreNumber = averageScoreNumber;
	}

	public double getAverageOffensiveNumber() {
		return averageOffensiveNumber;
	}

	public void setAverageOffensiveNumber(double averageOffensiveNumber) {
		this.averageOffensiveNumber = averageOffensiveNumber;
	}

	public double getTotalHitRate() {
		return totalHitRate;
	}

	public void setTotalHitRate(double totalHitRate) {
		this.totalHitRate = totalHitRate;
	}

	public double getThreePointHitRate() {
		return threePointHitRate;
	}

	public void setThreePointHitRate(double threePointHitRate) {
		this.threePointHitRate = threePointHitRate;
	}

	public double getFreePointHitRate() {
		return freePointHitRate;
	}

	public void setFreePointHitRate(double freePointHitRate) {
		this.freePointHitRate = freePointHitRate;
	}

	public double getWinRate() {
		return winRate;
	}

	public void setWinRate(double winRate) {
		this.winRate = winRate;
	}

	public double getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public void setOffensiveEfficiency(double offensiveEfficiency) {
		this.offensiveEfficiency = offensiveEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public void setDefensiveEfficiency(double defensiveEfficiency) {
		this.defensiveEfficiency = defensiveEfficiency;
	}

	public double getReboundEfficiency() {
		return reboundEfficiency;
	}

	public void setReboundEfficiency(double reboundEfficiency) {
		this.reboundEfficiency = reboundEfficiency;
	}

	public double getStealEfficiency() {
		return stealEfficiency;
	}

	public void setStealEfficiency(double stealEfficiency) {
		this.stealEfficiency = stealEfficiency;
	}

	public double getAssistEfficiency() {
		return assistEfficiency;
	}

	public void setAssistEfficiency(double assistEfficiency) {
		this.assistEfficiency = assistEfficiency;
	}

	public String[] toStringArray() {
		return new String[] { String.valueOf(numberOfMatch),// 比赛场数
				String.valueOf(winRate),// 胜率
				String.valueOf(averageScoreNumber),// 场均得分数
				String.valueOf(scoreNumber),// 得分数
				String.valueOf(averageTotalHitNumber),// 场均命中数
				String.valueOf(totalHitNumber),// 总命中数
				String.valueOf(averageTotalShootNumber),// 场均总出手数
				String.valueOf(totalShootNumber),// 总出手数
				String.valueOf(totalHitRate),// 投篮命中率
				String.valueOf(averageThreePointHitNumber),// 场均三分命中数
				String.valueOf(threePointHitNumber),// 三分命中数
				String.valueOf(averageThreePointShootNumber),// 场均三分出手数
				String.valueOf(threePointShootNumber),// 三分出手数
				String.valueOf(threePointHitRate),// 三分命中率
				String.valueOf(averageFreePointHitNumber),// 场均罚球命中数
				String.valueOf(freePointHitNumber),// 罚球命中数
				String.valueOf(averageFreePointShootNumber),// 场均罚球出手数
				String.valueOf(freePointShootNumber),// 罚球出手数
				String.valueOf(freePointHitRate),// 罚球命中率
				String.valueOf(averageOffensiveReboundNumber),// 场均进攻篮板数
				String.valueOf(offensiveReboundNumber),// 进攻篮板数
				String.valueOf(averageDefensiveReboundNumber),// 场均防守篮板
				String.valueOf(defensiveReboundNumber),// 防守篮板
				String.valueOf(averageTotalReboundNumber),// 场均总篮板
				String.valueOf(totalReboundNumber),// 总篮板
				String.valueOf(averageAssistNumber),// 场均助攻数
				String.valueOf(assistNumber),// 总助攻
				String.valueOf(averageStealNumber),// 场均抢断数
				String.valueOf(stealNumber),// 抢断数
				String.valueOf(averageBlockNumber),// 场均盖帽数
				String.valueOf(blockNumber),// 盖帽数
				String.valueOf(averageTurnoverNumber),// 场均失误数
				String.valueOf(turnoverNumber),// 失误数
				String.valueOf(averageFoulNumber),// 场均犯规数
				String.valueOf(foulNumber),// 犯规数
				String.valueOf(averageOffensiveNumber),// 场均进攻回合数///////////////
				String.valueOf(offensiveNumber),// 进攻回合数
				String.valueOf(offensiveEfficiency),// 进攻效率
				String.valueOf(defensiveEfficiency),// 防守效率
				String.valueOf(reboundEfficiency),// 篮板效率
				String.valueOf(stealEfficiency),// 抢断率
				String.valueOf(assistEfficiency),// 助攻率
		};
	}
}
