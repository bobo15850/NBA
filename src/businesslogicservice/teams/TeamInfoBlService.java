package businesslogicservice.teams;

import test.data.TeamHighInfo;
import test.data.TeamHotInfo;
import test.data.TeamNormalInfo;

import common.mydatastructure.SortCell;

public interface TeamInfoBlService {
	public TeamHotInfo[] getTeamHot(int number, String field);

	public TeamHighInfo[] getTeamHigh(int number, SortCell[] sortcell);

	public TeamNormalInfo[] getTeamNormal_avg(int number, SortCell[] sortcell);

	public TeamNormalInfo[] getTeamNormal_tot(int number, SortCell[] sortcell);

}
