package common.mydatastructure;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TeamPerformOfOneMatch {
	private String teamName;// 球队名称缩写
	private MyDate date;// 比赛时间
	private double minute = 0;// 球员上场时间之和
	private String opponentTeamName;// 对手名称
	private int win;// 是否赢球
	private int totalHit;// 总命中数
	private int totalShot;// 总出手数
	private int threeHit;// 三分命中数
	private int threeShot;// 三分出手数
	private int freeHit;// 罚球命中数
	private int freeShot;// 罚球出手数
	private int offendRebound;// 进攻篮板
	private int defendRebound;// 防守篮板
	private int rebound;// 总篮板
	private int assist;// 助攻
	private int steal;// 抢断数
	private int block;// 盖帽数
	private int fault;// 失误数
	private int foul;// 犯规数
	private int point;// 得分数

	public TeamPerformOfOneMatch(String teamName, String opponentTeamName, MyDate date, int win,
			ArrayList<PlayerPerformOfOneMatch> listOfPlayerPerformanceOfOneMatch) {
		this.teamName = teamName;
		this.opponentTeamName = opponentTeamName;
		this.date = date;
		this.win = win;
		PlayerPerformOfOneMatch temp;
		for (int i = 0; i < listOfPlayerPerformanceOfOneMatch.size(); i++) {
			temp = listOfPlayerPerformanceOfOneMatch.get(i);
			this.totalHit += temp.getTotalHit();
			this.totalShot += temp.getTotalShoot();
			this.threeHit += temp.getThreeHit();
			this.threeShot += temp.getThreeShot();
			this.freeHit += temp.getFreeHit();
			this.freeShot += temp.getFreeShot();
			this.offendRebound += temp.getOffendRebound();
			this.defendRebound += temp.getDefendRebound();
			this.rebound += temp.getRebound();
			this.assist += temp.getAssist();
			this.steal += temp.getSteal();
			this.block += temp.getBlockShot();
			this.fault += temp.getFault();
			this.foul += temp.getFoul();
			this.point += temp.getPoint();
			this.minute += temp.getMinute();
		}
		BigDecimal bigDecimal = new BigDecimal(minute);
		minute = bigDecimal.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public TeamPerformOfOneMatch() {
		// 无参构造函数
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}// 设置球队名称

	public void setOpponentTeamName(String opponentTeamNameForShort) {
		this.opponentTeamName = opponentTeamNameForShort;
	}// 设置对手名称

	public void setDate(MyDate date) {
		this.date = date;
	}// 设置比赛时间

	public void setTotalHit(int totalHitNumber) {
		this.totalHit = totalHitNumber;
	}// 设置总命中数

	public void setTotalShot(int totalShootNumber) {
		this.totalShot = totalShootNumber;
	}// 设置总出手数

	public void setThreeHit(int threePointHitNumber) {
		this.threeHit = threePointHitNumber;
	}// 设置总三分命中数

	public void setThreeShot(int threePointShootNumber) {
		this.threeShot = threePointShootNumber;
	}// 设置总三分出手数

	public void setFreeHit(int freePointHitNumber) {
		this.freeHit = freePointHitNumber;
	}// 设置总罚球命中数

	public void setFreeShot(int freePointShootNumber) {
		this.freeShot = freePointShootNumber;
	}// 设置总罚球出手数

	public void setOffendRebound(int offensiveReboundNumber) {
		this.offendRebound = offensiveReboundNumber;
	}// 设置总进攻篮板数

	public void setDefendRebound(int defensiveReboundNumber) {
		this.defendRebound = defensiveReboundNumber;
	}// 设置总防守篮板数

	public void setTotalRebound(int totalReboundNumber) {
		this.rebound = totalReboundNumber;
	}// 设置总篮板数

	public void setAssist(int assistNumber) {
		this.assist = assistNumber;
	}// 设置助攻数

	public void setSteal(int stealNumber) {
		this.steal = stealNumber;
	}// 设置抢断数

	public void setBlock(int blockNumber) {
		this.block = blockNumber;
	}// 设置盖帽数

	public void setFault(int turnoverNumber) {
		this.fault = turnoverNumber;
	}// 设置失误数

	public void setFoul(int foulNumber) {
		this.foul = foulNumber;
	}// 设置犯规数

	public void setPoint(int scoreNumber) {
		this.point = scoreNumber;
	}// 设置得分数

	public String getTeamName() {
		return this.teamName;
	}// 得到球队名称

	public String getOpponentTeamName() {
		return this.opponentTeamName;
	}// 得到对手名称

	public MyDate getDate() {
		return this.date;
	}// 得到比赛时间

	public int getTotalHit() {
		return this.totalHit;
	}// 得到总命中数

	public int getTotalShot() {
		return this.totalShot;
	}// 得到总出手数

	public int getThreeHit() {
		return this.threeHit;
	}// 得到总三分命中数

	public int getThreeShot() {
		return this.threeShot;
	}// 得到总三分出手数

	public int getFreeHit() {
		return this.freeHit;
	}// 得到总罚球命中数

	public int getFreeShot() {
		return this.freeShot;
	}// 得到总罚球出手数

	public int getOffendRebound() {
		return this.offendRebound;
	}// 得到总进攻篮板数

	public int getDefendRebound() {
		return this.defendRebound;
	}// 得到总防守篮板数

	public int getRebound() {
		return this.rebound;
	}// 得到总篮板数

	public int getAssist() {
		return this.assist;
	}// 得到助攻数

	public int getSteal() {
		return this.steal;
	}// 得到抢断数

	public int getBlock() {
		return this.block;
	}// 得到盖帽数

	public int getFault() {
		return this.fault;
	}// 得到失误数

	public int getFoul() {
		return this.foul;
	}// 得到犯规数

	public int getPoint() {
		return this.point;
	}// 得到得分数

	public double getMinute() {
		return minute;
	}

	public void setMinute(double playingTime) {
		this.minute = playingTime;
	}

	public String toString() {
		return "队名：" + this.getTeamName() + "---比赛日期：" + this.getDate().getFormatString() + "---对手：" + this.getOpponentTeamName() + "---比赛时间："
				+ this.getMinute() + "---总命中数：" + this.getTotalHit() + "---总出手数：" + this.getTotalShot() + "---三分总命中数：" + this.getThreeHit()
				+ "---三分总命中数：" + this.getThreeShot() + "---罚球总出手数：" + this.getFreeHit() + "---罚球总命中数：" + this.getFreeShot() + "---进攻篮板数："
				+ this.getOffendRebound() + "---防守篮板数：" + this.getDefendRebound() + "---总篮板数：" + this.getRebound() + "---助攻数：" + this.getAssist()
				+ "---抢断数：" + this.getSteal() + "---盖帽数：" + this.getBlock() + "---失误数：" + this.getFault() + "---犯规数：" + this.getFoul() + "---得分数："
				+ this.getPoint();
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public String[] toStringArray() {

		return new String[] { date.getFormatString(),// 比赛时间
				opponentTeamName,// 对手名称
				String.valueOf(point), // 得分数
				String.valueOf(rebound),// 总篮板
				String.valueOf(assist),// 助攻
				String.valueOf(steal),// 抢断数
				String.valueOf(block),// 盖帽数
				String.valueOf(fault),// 失误数
				String.valueOf(foul),// 犯规数
				String.valueOf(totalHit),// 总命中数
				String.valueOf(totalShot),// 总出手数
				String.valueOf(threeHit),// 三分命中数
				String.valueOf(threeShot),// 三分出手数
				String.valueOf(freeHit),// 罚球命中数
				String.valueOf(freeShot),// 罚球出手数
				String.valueOf(offendRebound),// 进攻篮板
				String.valueOf(defendRebound),// 防守篮板
		};
	}
}
