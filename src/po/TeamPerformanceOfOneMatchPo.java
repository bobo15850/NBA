package po;

import java.util.ArrayList;

import common.mydatastructure.Date;

public class TeamPerformanceOfOneMatchPo {
	private String teamName;// 球队名称
	private Date date;// 比赛时间
	private String opponentTeamName;// 对手名称
	private int totalHitNumber;// 总命中数
	private int totalShootNumber;// 总出手数
	private int threePointHitNumber;// 三分命中数
	private int threePointShootNumber;// 三分出手数
	private int freePointHitNumber;// 罚球命中数
	private int freePointShootNumber;// 罚球出手数
	private int offensiveReboundNumber;// 进攻篮板
	private int defensiveReboundNumber;// 防守篮板
	private int totalReboundNumber;// 总篮板
	private int assistNumber;// 助攻
	private int stealNumber;// 抢断数
	private int blockNumber;// 盖帽数
	private int turnoverNumber;// 失误数
	private int foulNumber;// 犯规数
	private int scoreNumber;// 得分数

	public TeamPerformanceOfOneMatchPo(String teamName, String opponentTeamName, Date date, ArrayList<PlayerPerformanceOfOneMatchPo> listOfPlayerPerformanceOfOneMatch) {
		this.teamName = teamName;
		this.opponentTeamName = opponentTeamName;
		this.date = date;
		PlayerPerformanceOfOneMatchPo temp;
		for (int i = 0; i < listOfPlayerPerformanceOfOneMatch.size(); i++) {
			temp = listOfPlayerPerformanceOfOneMatch.get(i);
			this.totalHitNumber += temp.getTotalHitNumber();
			this.totalShootNumber += temp.getTotalShootNumber();
			this.threePointHitNumber += temp.getThreePointHitNumber();
			this.threePointShootNumber += temp.getThreePointShootNumber();
			this.freePointHitNumber += temp.getFreePointHitNumber();
			this.freePointShootNumber += temp.getFreePointShootNumber();
			this.offensiveReboundNumber += temp.getOffensiveReboundNumber();
			this.defensiveReboundNumber += temp.getDefensiveReboundNumber();
			this.totalReboundNumber += temp.getTotalReboundNumber();
			this.assistNumber += temp.getAssistNumber();
			this.stealNumber += temp.getStealNumber();
			this.blockNumber += temp.getBlockNumber();
			this.turnoverNumber += temp.getTurnoverNumber();
			this.foulNumber += temp.getFoulNumber();
			this.scoreNumber += temp.getScoreNumber();
		}
	}

	@SuppressWarnings("null")
	public String getFormatString() {
		StringBuffer result = null;
		String tag = ";";
		result.append(this.teamName).append(tag).append(this.date.getFormatString()).append(tag).append(this.opponentTeamName).append(tag).append(this.totalHitNumber).append(tag).append(this.totalShootNumber).append(tag).append(this.threePointHitNumber).append(tag).append(this.threePointShootNumber).append(tag).append(this.freePointHitNumber).append(tag).append(this.freePointShootNumber).append(tag).append(this.offensiveReboundNumber).append(tag).append(this.defensiveReboundNumber).append(tag).append(this.totalReboundNumber).append(tag).append(this.assistNumber).append(tag).append(this.stealNumber).append(tag).append(this.blockNumber).append(tag).append(this.turnoverNumber).append(tag).append(this.foulNumber).append(tag).append(this.scoreNumber).append(tag);
		return result.toString();
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}// 设置球队名称

	public void setOpponentTeamName(String opponentTeamName) {
		this.opponentTeamName = opponentTeamName;
	}// 设置对手名称

	public void setDate(Date date) {
		this.date = date;
	}// 设置比赛时间

	public void setTotalHitNumber(int totalHitNumber) {
		this.totalHitNumber = totalHitNumber;
	}// 设置总命中数

	public void setTotalShootNumber(int totalShootNumber) {
		this.totalShootNumber = totalShootNumber;
	}// 设置总出手数

	public void setThreePointHitNumber(int threePointHitNumber) {
		this.threePointHitNumber = threePointHitNumber;
	}// 设置总三分命中数

	public void setThreePointShootNumber(int threePointShootNumber) {
		this.threePointShootNumber = threePointShootNumber;
	}// 设置总三分出手数

	public void setFreePointHitNumber(int freePointHitNumber) {
		this.freePointHitNumber = freePointHitNumber;
	}// 设置总罚球命中数

	public void setFreePointShootNumber(int freePointShootNumber) {
		this.freePointShootNumber = freePointShootNumber;
	}// 设置总罚球出手数

	public void setOffensiveReboundNumber(int offensiveReboundNumber) {
		this.offensiveReboundNumber = offensiveReboundNumber;
	}// 设置总进攻篮板数

	public void setDefensiveReboundNumber(int defensiveReboundNumber) {
		this.defensiveReboundNumber = defensiveReboundNumber;
	}// 设置总防守篮板数

	public void setTotalReboundNumber(int totalReboundNumber) {
		this.totalReboundNumber = totalReboundNumber;
	}// 设置总篮板数

	public void setAssistNumber(int assistNumber) {
		this.assistNumber = assistNumber;
	}// 设置助攻数

	public void setStealNumber(int stealNumber) {
		this.stealNumber = stealNumber;
	}// 设置抢断数

	public void setBlockNumber(int blockNumber) {
		this.blockNumber = blockNumber;
	}// 设置盖帽数

	public void setTurnoverNumber(int turnoverNumber) {
		this.turnoverNumber = turnoverNumber;
	}// 设置失误数

	public void setFoulNumber(int foulNumber) {
		this.foulNumber = foulNumber;
	}// 设置犯规数

	public void setScoreNumber(int scoreNumber) {
		this.scoreNumber = scoreNumber;
	}// 设置得分数
		// //////////////////////////

	public String getTeamName() {
		return this.teamName;
	}// 得到球队名称

	public String getOpponentTeamName() {
		return this.opponentTeamName;
	}// 得到对手名称

	public Date getDate() {
		return this.date;
	}// 得到比赛时间

	public int getTotalHitNumber() {
		return this.totalHitNumber;
	}// 得到总命中数

	public int getTotalShootNumber() {
		return this.totalShootNumber;
	}// 得到总出手数

	public int getThreePointHitNumber() {
		return this.threePointHitNumber;
	}// 得到总三分命中数

	public int getThreePointShootNumber() {
		return this.threePointShootNumber;
	}// 得到总三分出手数

	public int getFreePointHitNumber() {
		return this.freePointHitNumber;
	}// 得到总罚球命中数

	public int getFreePointShootNumber() {
		return this.freePointShootNumber;
	}// 得到总罚球出手数

	public int getOffensiveReboundNumber() {
		return this.offensiveReboundNumber;
	}// 得到总进攻篮板数

	public int getDefensiveReboundNumber() {
		return this.defensiveReboundNumber;
	}// 得到总防守篮板数

	public int getTotalReboundNumber() {
		return this.totalReboundNumber;
	}// 得到总篮板数

	public int getAssistNumber() {
		return this.assistNumber;
	}// 得到助攻数

	public int getStealNumber() {
		return this.stealNumber;
	}// 得到抢断数

	public int getBlockNumber() {
		return this.blockNumber;
	}// 得到盖帽数

	public int getTurnoverNumber() {
		return this.turnoverNumber;
	}// 得到失误数

	public int getFoulNumber() {
		return this.foulNumber;
	}// 得到犯规数

	public int getScoreNumber() {
		return this.scoreNumber;
	}// 得到得分数
}
