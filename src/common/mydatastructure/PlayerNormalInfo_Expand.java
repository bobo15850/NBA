package common.mydatastructure;

import businesslogic.players.CalculationOfPlayerPerform;
import test.data.PlayerNormalInfo;

public class PlayerNormalInfo_Expand extends PlayerNormalInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double totalHit;// 总命中数
	private double totalShot;// 总出手数
	private double threeHit;// 三分命中数
	private double threeShot;// 三分出手数
	private double freeHit;// 罚球命中数
	private double freeShot;// 罚球出手数
	private int doubleTwo;// 两双数
	private int tripleTwo;// 三双数

	public int getDoubleTwo() {
		return doubleTwo;
	}

	public void setDoubleTwo(int doubleTwo) {
		this.doubleTwo = doubleTwo;
	}

	public int getTripleTwo() {
		return tripleTwo;
	}

	public void setTripleTwo(int tripleTwo) {
		this.tripleTwo = tripleTwo;
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

	public double getFreehot() {
		return freeShot;
	}

	public void setFreeShot(double freehot) {
		this.freeShot = freehot;
	}

	public PlayerNormalInfo_Expand getPlayerNormal_avg() {
		PlayerNormalInfo_Expand playerNormal_avg = new PlayerNormalInfo_Expand();
		double numOfGame = getNumOfGame();
		playerNormal_avg.setAge(getAge());
		playerNormal_avg.setAssist(CalculationOfPlayerPerform.cutTail(getAssist() / numOfGame));
		playerNormal_avg.setBlockShot(CalculationOfPlayerPerform.cutTail(getBlockShot() / numOfGame));
		playerNormal_avg.setDefend(CalculationOfPlayerPerform.cutTail(getDefend() / numOfGame));
		playerNormal_avg.setDoubleTwo(doubleTwo);
		playerNormal_avg.setEfficiency(getEfficiency());
		playerNormal_avg.setFault(CalculationOfPlayerPerform.cutTail(getFault() / numOfGame));
		playerNormal_avg.setFoul(CalculationOfPlayerPerform.cutTail(getFoul() / numOfGame));
		playerNormal_avg.setFreeHit(CalculationOfPlayerPerform.cutTail(freeHit / numOfGame));
		playerNormal_avg.setFreeShot(CalculationOfPlayerPerform.cutTail(freeShot / numOfGame));
		playerNormal_avg.setMinute(CalculationOfPlayerPerform.cutTail(getMinute() / numOfGame));
		playerNormal_avg.setName(getName());
		playerNormal_avg.setNumOfGame(getNumOfGame());
		playerNormal_avg.setOffend(CalculationOfPlayerPerform.cutTail(getOffend() / numOfGame));
		playerNormal_avg.setPenalty(getPenalty());
		playerNormal_avg.setPoint(CalculationOfPlayerPerform.cutTail(getPoint() / numOfGame));
		playerNormal_avg.setRebound(CalculationOfPlayerPerform.cutTail(getRebound() / numOfGame));
		playerNormal_avg.setShot(getShot());
		playerNormal_avg.setStart(getStart());
		playerNormal_avg.setSteal(CalculationOfPlayerPerform.cutTail(getSteal() / numOfGame));
		playerNormal_avg.setTeamName(getTeamName());
		playerNormal_avg.setThree(getThree());
		playerNormal_avg.setThreeHit(CalculationOfPlayerPerform.cutTail(threeHit / numOfGame));
		playerNormal_avg.setThreeShot(CalculationOfPlayerPerform.cutTail(threeShot / numOfGame));
		playerNormal_avg.setTotalHit(CalculationOfPlayerPerform.cutTail(totalHit / numOfGame));
		playerNormal_avg.setTotalShot(CalculationOfPlayerPerform.cutTail(totalShot / numOfGame));
		playerNormal_avg.setTripleTwo(tripleTwo);
		return playerNormal_avg;
	}

	public String[] toStringArray() {
		return new String[] { this.getTeamName(), String.valueOf(this.getNumOfGame()), String.valueOf(this.getMinute()),
				String.valueOf(this.getEfficiency()), String.valueOf(this.getPoint()), String.valueOf(this.getShot()),
				String.valueOf(this.getRebound()), String.valueOf(this.getAssist()), String.valueOf(this.getSteal()),
				String.valueOf(this.getBlockShot()), String.valueOf(this.doubleTwo), String.valueOf(this.tripleTwo), String.valueOf(this.getFault()),
				String.valueOf(this.getFoul()), String.valueOf(this.getThree()), String.valueOf(this.getPenalty()) };
	}
}
