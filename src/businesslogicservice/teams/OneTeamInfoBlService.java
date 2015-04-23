package businesslogicservice.teams;

import java.util.ArrayList;

import test.data.TeamHighInfo;
import common.mydatastructure.GeneralInfoOfTeam;
import common.mydatastructure.MyDate;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;

public interface OneTeamInfoBlService {
	public String[] getPlayerNameOfTeam(String teamName);// 根据球队名称得到球队所有球员姓名

	public TeamNormalInfo_Expand getTeamNormalInfo_tot(String teamName);// 根据球队名称得到球队普通数据

	public TeamNormalInfo_Expand getTeamNormalInfo_avg(String teamName);

	public TeamHighInfo getOneTeamHighInfo(String teamName);// 根据球队名称得到球队高级数据

	public ArrayList<TeamPerformOfOneMatch> getTeamPerform(String teamName);// 根据球队名称得到所有比赛的比赛数据

	public GeneralInfoOfTeam getTeamGeneralInfo(String teamName);// 根据球队名称得到球队基本信息

	public TeamPerformOfOneMatch getOneMatchTeamPerform(String teamName, MyDate date);// 根据队名和日期查找比赛数据
}
