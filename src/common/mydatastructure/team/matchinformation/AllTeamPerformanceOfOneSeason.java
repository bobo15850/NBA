package common.mydatastructure.team.matchinformation;

import java.util.ArrayList;

import vo.OneTeamPerformanceOfOneSeasonVo;

import common.mydatastructure.Season;

public class AllTeamPerformanceOfOneSeason {
	private Season season;
	private ArrayList<OneTeamPerformanceOfOneSeasonVo> listOfOneTeamPerformanceOfOneSeason;
	private int numberOfTeam;

	public AllTeamPerformanceOfOneSeason(Season season) {
		this.season = season;
		this.listOfOneTeamPerformanceOfOneSeason = new ArrayList<OneTeamPerformanceOfOneSeasonVo>(64);
	}
}
