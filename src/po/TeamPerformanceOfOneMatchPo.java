package po;

import java.util.ArrayList;

import common.mydatastructure.MyDate;
import common.mydatastructure.Season;
import common.mydatastructure.MyTime;

public class TeamPerformanceOfOneMatchPo {
	private String TeamNameForShort;// 球队名称
	private MyDate date;// 比赛时间
	private Season season;// 赛季
	private String opponentTeamNameForShort;// 对手名称
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
	private MyTime playingTime=new MyTime();// 球员上场时间之和

	public TeamPerformanceOfOneMatchPo(String teamName, String opponentTeamName, MyDate date, Season season,
			ArrayList<PlayerPerformanceOfOneMatchPo> listOfPlayerPerformanceOfOneMatch) {
		this.TeamNameForShort = teamName;
		this.opponentTeamNameForShort = opponentTeamName;
		this.date = date;
		this.season = season;
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
			this.playingTime.plus(temp.getPlayingTime());
		}

	}

	public TeamPerformanceOfOneMatchPo() {
		// 无参构造函数
	}

	public void setTeamNameForShort(String teamName) {
		this.TeamNameForShort = teamName;
	}// 设置球队名称

	public void setOpponentTeamName(String opponentTeamNameForShort) {
		this.opponentTeamNameForShort = opponentTeamNameForShort;
	}// 设置对手名称

	public void setDate(MyDate date) {
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

	public String getTeamNameForShort() {
		return this.TeamNameForShort;
	}// 得到球队名称

	public String getOpponentTeamNameForShort() {
		return this.opponentTeamNameForShort;
	}// 得到对手名称

	public MyDate getDate() {
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

	public String toDBString() {
		String resultString = "(`teamNameForShort`, `date`, `season`, `opponentTeamName`, `playingTime`,"
				+ "`totalHitNumber`, `totalShootNumber`, `threePointHitNumber`, "
				+ "`threePointShootNumber`, `freePointHitNumber`, `freePointShootNumber`,"
				+ " `offensiveReboundNumber`, `defensiveReboundNumber`, `totalReboundNumber`," + " `assistNumber`, `stealNumber`, `blockNumber`,"
				+ " `turnoverNumber`, `foulNumber`, `scoreNumber`)" + " VALUES ('"
				+ this.getTeamNameForShort()
				+ "','"
				+ this.getDate().getFormatString()
				+ "','"
				+ this.getSeason().getFormatStyleOfSeason()
				+ "','"
				+ this.getOpponentTeamNameForShort()
				+ "','"
				+ this.getPlayingTime().getTimeFormatString()
				+ "','"
				+ this.getTotalHitNumber()
				+ "','"
				+ this.getTotalShootNumber()
				+ "','"
				+ this.getThreePointHitNumber()
				+ "','"
				+ this.getThreePointShootNumber()
				+ "','"
				+ this.getFreePointHitNumber()
				+ "','"
				+ this.getFreePointShootNumber()
				+ "','"
				+ this.getOffensiveReboundNumber()
				+ "','"
				+ this.getDefensiveReboundNumber()
				+ "','"
				+ this.getTotalReboundNumber()
				+ "','"
				+ this.getAssistNumber()
				+ "','"
				+ this.getStealNumber()
				+ "','"
				+ this.getBlockNumber()
				+ "','"
				+ this.getTurnoverNumber()
				+ "','"
				+ this.getFoulNumber()
				+ "','"
				+ this.getScoreNumber() + "')";
		return resultString;
	}

	public MyTime getPlayingTime() {
		return playingTime;
	}

	public void setPlayingTime(MyTime playingTime) {
		this.playingTime = playingTime;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
}
