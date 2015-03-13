package businesslogic.teams;

import java.util.ArrayList;
import java.util.Iterator;

import vo.OneTeamPerformanceOfOneSeasonVo;

import common.mydatastructure.Season;

public class AllTeamPerformanceOfOneSeason implements Iterator<OneTeamPerformanceOfOneSeasonVo> {
	private Season season;
	private ArrayList<OneTeamPerformanceOfOneSeasonVo> listOfOneTeamPerformanceOfOneSeason;
	private int numberOfTeam;
	private int pointer;

	public AllTeamPerformanceOfOneSeason(Season season, ArrayList<OneTeamPerformanceOfOneSeasonVo> listOfOneTeamPerformanceOfOneSeason) {
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
}
