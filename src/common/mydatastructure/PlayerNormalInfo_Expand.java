package common.mydatastructure;

import test.data.PlayerNormalInfo;

public class PlayerNormalInfo_Expand extends PlayerNormalInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalHit;// 总命中数
	private int totalShot;// 总出手数
	private int threeHit;// 三分命中数
	private int threeShot;// 三分出手数
	private int freeHit;// 罚球命中数
	private int freehot;// 罚球出手数
	private int doubleTwo;// 两双数
	private int tripleTwo;// 三双数

	public int getTotalHit() {
		return totalHit;
	}

	public void setTotalHit(int totalHit) {
		this.totalHit = totalHit;
	}

	public int getTotalShot() {
		return totalShot;
	}

	public void setTotalShot(int totalShot) {
		this.totalShot = totalShot;
	}

	public int getThreeHit() {
		return threeHit;
	}

	public void setThreeHit(int threeHit) {
		this.threeHit = threeHit;
	}

	public int getThreeShot() {
		return threeShot;
	}

	public void setThreeShot(int threeShot) {
		this.threeShot = threeShot;
	}

	public int getFreeHit() {
		return freeHit;
	}

	public void setFreeHit(int freeHit) {
		this.freeHit = freeHit;
	}

	public int getFreehot() {
		return freehot;
	}

	public void setFreeShot(int freehot) {
		this.freehot = freehot;
	}

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
}
