package common.mydatastructure;

public class PlayerPerformOfOneMatch {
	private String name;// 球员姓名
	private String teamName;// 效力球队
	private MyDate date;// 比赛时间
	private int start;// 是否首发
	private double minute;// 上场时间
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
	private int blockShot;// 盖帽数
	private int fault;// 失误数
	private int foul;// 犯规数
	private int point;// 得分数

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}// 设置效力球队

	public void setMinute(double playingTime) {
		this.minute = playingTime;
	}// 设置上场时间

	public void setTotalHit(int totalHit) {
		this.totalHit = totalHit;
	}// 设置总命中数

	public void setTotalShot(int totalShot) {
		this.totalShot = totalShot;
	}// 设置总出手数

	public void setThreeHit(int threeHit) {
		this.threeHit = threeHit;
	}// 设置总三分命中数

	public void setThreeShot(int threeShot) {
		this.threeShot = threeShot;
	}// 设置总三分出手数

	public void setFreeHit(int freeHit) {
		this.freeHit = freeHit;
	}// 设置总罚球命中数

	public void setFreeShot(int freeShot) {
		this.freeShot = freeShot;
	}// 设置总罚球出手数

	public void setOffendRebound(int offendRebound) {
		this.offendRebound = offendRebound;
	}// 设置总进攻篮板数

	public void setDefendRebound(int defendRebound) {
		this.defendRebound = defendRebound;
	}// 设置总防守篮板数

	public void setRebound(int rebound) {
		this.rebound = rebound;
	}// 设置总篮板数

	public void setAssist(int assist) {
		this.assist = assist;
	}// 设置助攻数

	public void setSteal(int steal) {
		this.steal = steal;
	}// 设置抢断数

	public void setBlockShot(int blockShot) {
		this.blockShot = blockShot;
	}// 设置盖帽数

	public void setFault(int fault) {
		this.fault = fault;
	}// 设置失误数

	public void setFoul(int foul) {
		this.foul = foul;
	}// 设置犯规数

	public void setPoint(int point) {
		this.point = point;
	}// 设置得分数

	public String getTeamName() {
		return this.teamName;
	}// 得到效力球队

	public double getMinute() {
		return this.minute;
	}// 得到上场时间

	public int getTotalHit() {
		return this.totalHit;
	}// 得到总命中数

	public int getTotalShoot() {
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

	public int getBlockShot() {
		return this.blockShot;
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

	public String getName() {
		return name;
	}

	public void setName(String nameOfPlayer) {
		this.name = nameOfPlayer;
	}

	public MyDate getDate() {
		return date;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}

	public String toString() {
		return "姓名：" + this.getName() + "---比赛时间：" + this.getDate().getFormatString() + "---效力球队：" + this.getTeamName() + "---上场时间："
				+ this.getMinute() + "---总命中数：" + this.getTotalHit() + "---总出手数：" + this.getTotalShoot() + "---三分命中数：" + this.getThreeHit()
				+ "---三分出手数：" + this.getThreeShot() + "---罚球命中数：" + this.getFreeHit() + "---罚球出手数：" + this.getFreeShot() + "---进攻篮板数："
				+ this.getOffendRebound() + "---防守篮板数：" + this.getDefendRebound() + "---总篮板数：" + this.getRebound() + "---助攻数：" + this.getAssist()
				+ "---抢断数：" + this.getSteal() + "---盖帽数：" + this.getBlockShot() + "---失误数：" + this.getFault() + "---犯规数：" + this.getFoul()
				+ "---得分数：" + this.getPoint();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public String[] toStringArray() {
		return new String[] { teamName,// 效力球队
				date.getFormatString(),// 比赛时间
				String.valueOf(minute),// 上场时间
				String.valueOf(point), // 得分数
				String.valueOf(rebound),// 总篮板
				String.valueOf(assist),// 助攻
				String.valueOf(steal),// 抢断数
				String.valueOf(blockShot),// 盖帽数
				String.valueOf(fault),// 失误数
				String.valueOf(foul),// 犯规数
				String.valueOf(totalHit),// 总命中数
				String.valueOf(totalShot),// 总出手数
				String.valueOf(offendRebound),// 进攻篮板
				String.valueOf(defendRebound),// 防守篮板
				String.valueOf(threeHit),// 三分命中数
				String.valueOf(threeShot),// 三分出手数
				String.valueOf(freeHit),// 罚球命中数
				String.valueOf(freeShot),// 罚球出手数
		};

	}
}