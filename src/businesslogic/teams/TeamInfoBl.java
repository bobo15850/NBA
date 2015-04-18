package businesslogic.teams;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;

import common.mydatastructure.SortCell;

import businesslogicservice.teams.TeamInfoBlService;

public class TeamInfoBl implements TeamInfoBlService{

	@Override
	public TeamHotInfo[] getTeamHot(int number, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamHighInfo[] getTeamHigh(int number, SortCell[] sortcell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamNormalInfo[] getTeamNormal_avg(int number, SortCell[] sortcell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamNormalInfo[] getTeamNormal_tot(int number, SortCell[] sortcell) {
		// TODO Auto-generated method stub
		return null;
	}

}
