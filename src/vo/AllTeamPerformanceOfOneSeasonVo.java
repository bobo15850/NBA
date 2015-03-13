package vo;

import java.util.ArrayList;
import java.util.Iterator;

import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;

public class AllTeamPerformanceOfOneSeasonVo implements Iterator<OneTeamPerformanceOfOneSeasonVo> {
	private Season season;
	private ArrayList<OneTeamPerformanceOfOneSeasonVo> listOfOneTeamPerformanceOfOneSeason;
	private int numberOfTeam;
	private int pointer;

	public AllTeamPerformanceOfOneSeasonVo(Season season, ArrayList<OneTeamPerformanceOfOneSeasonVo> listOfOneTeamPerformanceOfOneSeason) {
		this.season = season;
		this.pointer = 0;
		this.listOfOneTeamPerformanceOfOneSeason = listOfOneTeamPerformanceOfOneSeason;
		this.numberOfTeam = listOfOneTeamPerformanceOfOneSeason.size();
	}

	public Season getSeason() {
		return this.season;
	}

	public int getNumberOfTeam() {
		return this.numberOfTeam;
	}

	public OneTeamPerformanceOfOneSeasonVo first() {
		this.pointer = 0;
		return listOfOneTeamPerformanceOfOneSeason.get(0);

	}

	public boolean hasNext() {
		return this.pointer < (numberOfTeam - 1);
	}

	public OneTeamPerformanceOfOneSeasonVo next() {
		this.pointer++;
		OneTeamPerformanceOfOneSeasonVo temp = listOfOneTeamPerformanceOfOneSeason.get(pointer);
		return temp;
	}

	public void remove() {
		this.listOfOneTeamPerformanceOfOneSeason.remove(pointer);
		pointer--;
		numberOfTeam--;
	}

	public void ascendingSort(PerformanceOfPlayer dataKind) {
	}// 根据某一项将所有球队某一赛季成绩升序排序

	public void descendingSort(PerformanceOfPlayer dataKind) {
	}// 根据某一项将所有球队某一赛季成绩降序排序
}
