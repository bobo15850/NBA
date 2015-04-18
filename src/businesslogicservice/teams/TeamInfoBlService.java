package businesslogicservice.teams;

import test.data.TeamHighInfo;
import test.data.TeamNormalInfo;

import common.mydatastructure.SortCell;

public interface TeamInfoBlService {

	public TeamHighInfo[] getTeamHigh(int number, SortCell[] sortcell);// 得到高级数据

	public TeamNormalInfo[] getTeamNormal_avg(int number, SortCell[] sortcell);// 得到平均普通数据

	public TeamNormalInfo[] getTeamNormal_tot(int number, SortCell[] sortcell);// 得到总和普通数据
}
