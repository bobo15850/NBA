package common.mydatastructure;

import test.data.TeamNormalInfo;

public class TeamNormalInfo_Expand extends TeamNormalInfo {
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

}
