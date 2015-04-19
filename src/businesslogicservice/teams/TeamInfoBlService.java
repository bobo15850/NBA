package businesslogicservice.teams;

import java.util.ArrayList;

import test.data.TeamHighInfo;

import common.mydatastructure.SortCell;
import common.mydatastructure.TeamNormalInfo_Expand;

public interface TeamInfoBlService {

	public ArrayList<TeamHighInfo> getTeamHigh(int number, SortCell[] sortcell);// 得到高级数据

	public ArrayList<TeamNormalInfo_Expand> getTeamNormal_avg(int number, SortCell[] sortcell);// 得到平均普通数据

	public ArrayList<TeamNormalInfo_Expand> getTeamNormal_tot(int number, SortCell[] sortcell);// 得到总和普通数据
}
