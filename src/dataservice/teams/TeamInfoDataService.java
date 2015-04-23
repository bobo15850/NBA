package dataservice.teams;

import java.util.ArrayList;

import common.mydatastructure.GeneralInfoOfTeam;
import common.mydatastructure.MyDate;
import common.mydatastructure.TeamPerformOfOneMatch;

public interface TeamInfoDataService {
	// 查找某一球队在某一赛季的具体信息比赛信息的数组中第一个为自己的信息，第二个为对方的信息
	public ArrayList<TeamPerformOfOneMatch[]> getOneTeamPerformOfOneSeason(String teamName);

	// 根据球队名称查找所属球队
	public String getLeagueOfTeam(String teamNameForShort);

	// 查找出所有的球队的名称
	public ArrayList<String> getNamesForShortOfAllTeam();

	public GeneralInfoOfTeam getGeneralInfoOfTeam(String teamName);

	public String[] getNameOfAllPlayer(String teamName);// 根据球队名称得到其所有球员名称

	public TeamPerformOfOneMatch getOneMatchTeamPerform(String teamName, MyDate date);
}
