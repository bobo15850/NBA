package common.mydatastructure;

import businesslogic.teams.CalculationOfTeamPerform;
import test.data.TeamNormalInfo;

public class TeamNormalInfo_Expand extends TeamNormalInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double totalHit = 0;// 总命中数
	private double totalShot = 0;// 总出手数
	private double threeHit = 0;// 三分命中数
	private double threeShot = 0;// 三分出手数
	private double freeHit = 0;// 罚球命中数
	private double freeShot = 0;// 罚球出手数
	private int numOfWin = 0;// 胜利场数
	private double minute = 0;// 比赛时间

	public TeamNormalInfo_Expand getTeamNormal_avg() {
		TeamNormalInfo_Expand teamNormal_avg = new TeamNormalInfo_Expand();

		int numOfGame = getNumOfGame();
		System.out.println(numOfGame);
		teamNormal_avg.setNumOfGame(numOfGame);
		teamNormal_avg.setPenalty(getPenalty());
		teamNormal_avg.setShot(getShot());
		teamNormal_avg.setTeamName(getTeamName());
		teamNormal_avg.setThree(getThree());
		teamNormal_avg.setNumOfWin(getNumOfWin());
		teamNormal_avg.setAssist(CalculationOfTeamPerform.cutTail(getAssist() / numOfGame));
		teamNormal_avg.setBlockShot(CalculationOfTeamPerform.cutTail(getBlockShot() / numOfGame));
		teamNormal_avg.setDefendRebound(CalculationOfTeamPerform.cutTail(getDefendRebound() / numOfGame));
		teamNormal_avg.setFault(CalculationOfTeamPerform.cutTail(getFault() / numOfGame));
		teamNormal_avg.setFoul(CalculationOfTeamPerform.cutTail(getFoul() / numOfGame));
		teamNormal_avg.setFreeHit(CalculationOfTeamPerform.cutTail(getFreeHit() / numOfGame));
		teamNormal_avg.setFreeShot(CalculationOfTeamPerform.cutTail(getFreeShot() / numOfGame));
		teamNormal_avg.setOffendRebound(CalculationOfTeamPerform.cutTail(getOffendRebound() / numOfGame));
		teamNormal_avg.setPoint(CalculationOfTeamPerform.cutTail(getPoint() / numOfGame));
		teamNormal_avg.setRebound(CalculationOfTeamPerform.cutTail(getRebound() / numOfGame));
		teamNormal_avg.setSteal(CalculationOfTeamPerform.cutTail(getSteal() / numOfGame));
		teamNormal_avg.setThreeHit(CalculationOfTeamPerform.cutTail(getThreeHit() / numOfGame));
		teamNormal_avg.setThreeShot(CalculationOfTeamPerform.cutTail(getThreeShot() / numOfGame));
		teamNormal_avg.setTotalHit(CalculationOfTeamPerform.cutTail(getTotalHit() / numOfGame));
		teamNormal_avg.setTotalShot(CalculationOfTeamPerform.cutTail(getTotalShot() / numOfGame));
		return teamNormal_avg;

	}

	public double getTotalHit() {
		return totalHit;
	}

	public void setTotalHit(double totalHit) {
		this.totalHit = totalHit;
	}

	public double getTotalShot() {
		return totalShot;
	}

	public void setTotalShot(double totalShot) {
		this.totalShot = totalShot;
	}

	public double getThreeHit() {
		return threeHit;
	}

	public void setThreeHit(double threeHit) {
		this.threeHit = threeHit;
	}

	public double getThreeShot() {
		return threeShot;
	}

	public void setThreeShot(double threeShot) {
		this.threeShot = threeShot;
	}

	public double getFreeHit() {
		return freeHit;
	}

	public void setFreeHit(double freeHit) {
		this.freeHit = freeHit;
	}

	public double getFreeShot() {
		return freeShot;
	}

	public void setFreeShot(double freehot) {
		this.freeShot = freehot;
	}

	public int getNumOfWin() {
		return numOfWin;
	}

	public void setNumOfWin(int numOfWin) {
		this.numOfWin = numOfWin;
	}

	public double getMinute() {
		return minute;
	}

	public void setMinute(double minute) {
		this.minute = minute;
	}

	public String[] toStringArray() {
		return new String[] { String.valueOf(this.getPoint()), String.valueOf(this.getRebound()), String.valueOf(this.getAssist()),
				String.valueOf(this.getSteal()), String.valueOf(this.getBlockShot()), String.valueOf(this.getFoul()),
				String.valueOf(this.getFault()), String.valueOf(this.getShot()), String.valueOf(this.getThree()), String.valueOf(this.getPenalty()),
				String.valueOf(this.getOffendRebound()), String.valueOf(this.getDefendRebound()) };

	}
}
