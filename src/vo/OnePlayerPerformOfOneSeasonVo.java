package vo;

public class OnePlayerPerformOfOneSeasonVo {
	private String nameOfPlayer;// 球员姓名
	private String nameOfTeam;// 球队名称
	private int numberOfMatch;// 比赛场数
	private int numberOfFirst;// 先发场数
	//
	private int totalReboundNumber;// 总篮板
	private int assistNumber;// 总助攻
	private double playingTime;// 总上场时间
	private int stealNumber;// 总抢断数
	private int blockNumber;// 总 盖帽数
	private int turnoverNumber;// 总失误数
	private int foulNumber;// 总犯规数
	private int scoreNumber;// 总得分数
	private int offensiveReboundNumber;// 进攻篮板数
	private int defensiveReboundNumber;// 防守篮板数
	private int scoreReboundAssistRate;// 得分篮板助攻比
	//
	private double averageTotalReboundNumber;// 场均篮板
	private double averageAssistNumber;// 场均助攻
	private double averagePlayingTime;// 场均上场时间
	private double averageStealNumber;// 场均抢断数
	private double averageBlockNumber;// 场均盖帽数
	private double averageTurnoverNumber;// 场均失误数
	private double averageFoulNumber;// 场均犯规数
	private double averageScoreNumber;// 场均得分数
	private double averageOffensiveReboundNumber;// 场均进攻篮板数
	private double averageDefensiveReboundNumber;// 场均防守篮板数
	private double averagescoreReboundAssistRate;// 场均得分篮板助攻比
	//
	private double totalHitRate;// 投篮命中率
	private double threePointHitRate;// 三分命中率
	private double freePointHitRate;// 罚球命中率
	private double commonEfficiency;// 效率
	private double GmScEfficiency;// GmSc效率
	private double realHitRate;// 真实命中率
	private double shootEfficiency;// 投篮效率
	private double reboundEfficiency;// 篮板效率
	private double offensiveReboundRate;// 进攻篮板率
	private double defensiveReboundRate;// 防守篮板率
	private double assistRate;// 助攻率
	private double stealRate;// 抢断率
	private double blockRate;// 盖帽率
	private double turnoverRate;// 失误率
	private double useRate;// 使用率
	//
	private int doubleDouble;// 两双
	private int tripleDouble;// 三双

	public String getNameOfPlayer() {
		return nameOfPlayer;
	}

	public void setNameOfPlayer(String nameOfPlayer) {
		this.nameOfPlayer = nameOfPlayer;
	}

	public String getNameOfTeam() {
		return nameOfTeam;
	}

	public void setNameOfTeam(String nameOfTeam) {
		this.nameOfTeam = nameOfTeam;
	}

	public int getNumberOfMatch() {
		return numberOfMatch;
	}

	public void setNumberOfMatch(int numberOfMatch) {
		this.numberOfMatch = numberOfMatch;
	}

	public int getNumberOfFirst() {
		return numberOfFirst;
	}

	public void setNumberOfFirst(int numberOfFirst) {
		this.numberOfFirst = numberOfFirst;
	}

	public double getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(double playingTime) {
		this.playingTime = playingTime;
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

	public double getCommonEfficiency() {
		return commonEfficiency;
	}

	public void setCommonEfficiency(double commonEfficiency) {
		this.commonEfficiency = commonEfficiency;
	}

	public double getGmScEfficiency() {
		return GmScEfficiency;
	}

	public void setGmScEfficiency(double gmScEfficiency) {
		GmScEfficiency = gmScEfficiency;
	}

	public double getRealHitRate() {
		return realHitRate;
	}

	public void setRealHitRate(double realHitRate) {
		this.realHitRate = realHitRate;
	}

	public double getReboundEfficiency() {
		return reboundEfficiency;
	}

	public void setReboundEfficiency(double reboundEfficiency) {
		this.reboundEfficiency = reboundEfficiency;
	}

	public double getOffensiveReboundRate() {
		return offensiveReboundRate;
	}

	public void setOffensiveReboundRate(double offensiveReboundRate) {
		this.offensiveReboundRate = offensiveReboundRate;
	}

	public double getDefensiveReboundRate() {
		return defensiveReboundRate;
	}

	public void setDefensiveReboundRate(double defensiveReboundRate) {
		this.defensiveReboundRate = defensiveReboundRate;
	}

	public double getAssistRate() {
		return assistRate;
	}

	public void setAssistRate(double assistRate) {
		this.assistRate = assistRate;
	}

	public double getStealRate() {
		return stealRate;
	}

	public void setStealRate(double stealRate) {
		this.stealRate = stealRate;
	}

	public double getBlockRate() {
		return blockRate;
	}

	public void setBlockRate(double blockRate) {
		this.blockRate = blockRate;
	}

	public double getTurnoverRate() {
		return turnoverRate;
	}

	public void setTurnoverRate(double turnoverRate) {
		this.turnoverRate = turnoverRate;
	}

	public double getUseRate() {
		return useRate;
	}

	public void setUseRate(double useRate) {
		this.useRate = useRate;
	}

	public double getShootEfficiency() {
		return shootEfficiency;
	}

	public void setShootEfficiency(double shootEfficiency) {
		this.shootEfficiency = shootEfficiency;
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

	public double getAveragePlayingTime() {
		return averagePlayingTime;
	}

	public void setAveragePlayingTime(double averagePlayingTime) {
		this.averagePlayingTime = averagePlayingTime;
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

	public int getDoubleDouble() {
		return doubleDouble;
	}

	public void setDoubleDouble(int doubleDouble) {
		this.doubleDouble = doubleDouble;
	}

	public int getTripleDouble() {
		return tripleDouble;
	}

	public void setTripleDouble(int tripleDouble) {
		this.tripleDouble = tripleDouble;
	}

	public int getScoreReboundAssistRate() {
		return scoreReboundAssistRate;
	}

	public void setScoreReboundAssistRate(int scoreReboundAssistRate) {
		this.scoreReboundAssistRate = scoreReboundAssistRate;
	}

	public String[] toStringArray() {
		return new String[] { nameOfTeam,// 所属球队
				String.valueOf(numberOfMatch),// 比赛场数
				String.valueOf(numberOfFirst),// 先发场数
				String.valueOf(averagePlayingTime),// 场均上场时间
				String.valueOf(playingTime),// 总上场时间
				String.valueOf(commonEfficiency),// 效率
				String.valueOf(GmScEfficiency),// GmSc效率
				String.valueOf(averageScoreNumber),// 场均得分数
				String.valueOf(scoreNumber),// 总得分数
				String.valueOf(averageTotalReboundNumber),// 场均篮板
				String.valueOf(totalReboundNumber),// 总篮板
				String.valueOf(averageAssistNumber),// 场均助攻
				String.valueOf(assistNumber),// 总助攻
				String.valueOf(averageStealNumber),// 场均抢断数
				String.valueOf(stealNumber),// 总抢断数
				String.valueOf(averageBlockNumber),// 场均盖帽数
				String.valueOf(blockNumber),// 总盖帽数
				String.valueOf(doubleDouble),// 两双个数
				String.valueOf(tripleDouble),// 三双个数
				String.valueOf(averageOffensiveReboundNumber),// 场均进攻篮板数
				String.valueOf(offensiveReboundNumber),// 进攻篮板数
				String.valueOf(averageDefensiveReboundNumber),// 场均防守篮板数
				String.valueOf(defensiveReboundNumber),// 防守篮板数
				String.valueOf(averageTurnoverNumber),// 场均失误数
				String.valueOf(turnoverNumber),// 总失误数
				String.valueOf(averageFoulNumber),// 场均犯规数
				String.valueOf(foulNumber),// 总犯规数
				String.valueOf(totalHitRate),// 投篮命中率
				String.valueOf(threePointHitRate),// 三分命中率
				String.valueOf(freePointHitRate),// 罚球命中率
				String.valueOf(useRate),// 使用率
				String.valueOf(realHitRate),// 真实命中率
				String.valueOf(shootEfficiency),// 投篮效率
				String.valueOf(assistRate),// 助攻率
				String.valueOf(reboundEfficiency),// 篮板效率
				String.valueOf(stealRate),// 抢断率
				String.valueOf(blockRate),// 盖帽率
				String.valueOf(offensiveReboundRate),// 进攻篮板率
				String.valueOf(defensiveReboundRate),// 防守篮板率
				String.valueOf(turnoverRate),// 失误率
		};
	}

	public double getAveragescoreReboundAssistRate() {
		return averagescoreReboundAssistRate;
	}

	public void setAveragescoreReboundAssistRate(double averagescoreReboundAssistRate) {
		this.averagescoreReboundAssistRate = averagescoreReboundAssistRate;
	}
}
