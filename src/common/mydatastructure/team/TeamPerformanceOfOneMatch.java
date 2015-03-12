package common.mydatastructure.team;

import java.util.ArrayList;

import common.enums.TeamName;
import common.mydatastructure.Date;
import common.mydatastructure.player.PlayerPerformanceOfOneMatch;

public class TeamPerformanceOfOneMatch {
	private ArrayList<PlayerPerformanceOfOneMatch> listOfPlayerPerformance;
	private TeamName teamName;
	private Date date;
	private TeamName opponentTeamName;
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

	public TeamPerformanceOfOneMatch(TeamName teamName, Date date) {
		this.teamName = teamName;
		this.date = date;
		this.getDetailOfEachPlayer();
		this.init();
	}

	private void getDetailOfEachPlayer() {
		this.getPathOfMatchInformation();
		// 逐个得到每个球员每场比赛的信息
	}

	private void init() {
		PlayerPerformanceOfOneMatch temp;
		for (int i = 0; i < listOfPlayerPerformance.size(); i++) {
			temp = listOfPlayerPerformance.get(i);
			this.totalHitNumber += temp.getTotalHitNumber();
			this.totalShootNumber += temp.getTotalShootNumber();
			this.threePointHitNumber += temp.getThreePointHitNumber();// 三分命中数
			this.threePointShootNumber += temp.getThreePointShootNumber();// 三分出手数
			this.freePointHitNumber += temp.getFreePointHitNumber();// 罚球命中数
			this.freePointShootNumber += temp.getFreePointShootNumber();// 罚球出手数
			this.offensiveReboundNumber += temp.getOffensiveReboundNumber(); // 进攻篮板
			this.defensiveReboundNumber += temp.getDefensiveReboundNumber(); // 防守篮板
			this.totalReboundNumber += temp.getTotalReboundNumber(); // 总篮板
			this.assistNumber += temp.getAssistNumber(); // 助攻
			this.stealNumber += temp.getStealNumber(); // 抢断数
			this.blockNumber += temp.getBlockNumber(); // 盖帽数
			this.turnoverNumber += temp.getTurnoverNumber(); // 失误数
			this.foulNumber += temp.getFoulNumber(); // 犯规数
			this.scoreNumber += temp.getScoreNumber(); // 得分数
		}
	}

	private void getPathOfMatchInformation() {

	}

	public TeamName getTeamName() {
		return this.teamName;
	}// 得到球队名称

	public TeamName getOpponentTeamName() {
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
