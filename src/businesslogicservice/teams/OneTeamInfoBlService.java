package businesslogicservice.teams;

import java.util.ArrayList;

import test.data.TeamHighInfo;

import common.mydatastructure.GeneralInfoOfTeam;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;

public interface OneTeamInfoBlService {
	public String[] getPlayerNameOfTeam(String teamName);// 根据球队名称得到球队所有球员姓名

	public TeamNormalInfo_Expand getOneTeamNormalInfo(String teamName);// 根据球队名称得到球队普通数据

	public TeamHighInfo getOneTeamHighInfo(String teamName);// 根据球队名称得到球队高级数据

	public ArrayList<TeamPerformOfOneMatch> getTeamPerform(String teamName);// 根据球队名称得到所有比赛的比赛数据

	public GeneralInfoOfTeam getTeamGeneralInfo(String teamName);// 根据球队名称得到球队基本信息
}
