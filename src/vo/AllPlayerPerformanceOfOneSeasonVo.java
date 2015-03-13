package vo;

import java.util.ArrayList;
import java.util.Iterator;

import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;

public class AllPlayerPerformanceOfOneSeasonVo implements Iterator<OnePlayerPerformanceOfOneSeasonVo> {
	private Season season;
	private ArrayList<OnePlayerPerformanceOfOneSeasonVo> listOfOnePlayerPerformanceOfOneSeason;
	private int numberOfPlayer;
	private int pointer;

	public AllPlayerPerformanceOfOneSeasonVo(Season season, ArrayList<OnePlayerPerformanceOfOneSeasonVo> listOfOnePlayerPerformanceOfOneSeason) {
		this.season = season;
		this.pointer = 0;
		this.listOfOnePlayerPerformanceOfOneSeason = listOfOnePlayerPerformanceOfOneSeason;
		this.numberOfPlayer = listOfOnePlayerPerformanceOfOneSeason.size();
	}

	public Season getSeason() {
		return this.season;
	}

	public int getNumberOfPlayer() {
		return this.numberOfPlayer;
	}

	public OnePlayerPerformanceOfOneSeasonVo first() {
		pointer = 0;
		return this.listOfOnePlayerPerformanceOfOneSeason.get(0);
	}

	public boolean hasNext() {
		return this.pointer < (numberOfPlayer - 1);
	}

	public OnePlayerPerformanceOfOneSeasonVo next() {
		this.pointer++;
		OnePlayerPerformanceOfOneSeasonVo temp = listOfOnePlayerPerformanceOfOneSeason.get(pointer);
		return temp;
	}

	public void remove() {
		this.listOfOnePlayerPerformanceOfOneSeason.remove(pointer);
		pointer--;
		numberOfPlayer--;
	}

	// 根据某一项将所有球员某一赛季成绩升序排序
	public void ascendingSort(PerformanceOfPlayer dataKind) {
		
	}

	// 根据某一项将所有球员某一赛季成绩降序排序
	public void descendingSort(PerformanceOfPlayer dataKind) {
		
	}

}
