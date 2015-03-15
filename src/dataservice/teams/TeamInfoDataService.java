package dataservice.teams;

import java.util.ArrayList;

import po.GeneralInfoOfTeamPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.Season;

public interface TeamInfoDataService {
	// 查找某一球队在某一赛季的具体信息
	public ArrayList<TeamPerformanceOfOneMatchPo> getOneTeamPerformOfOneSeason(String teamName, Season season);

	// 根据球队名称查找某一球队具体自然信息
	public GeneralInfoOfTeamPo getBaseInformationOfOneTeam(String teamName);

	// 查找出所有的球队的名称
	public ArrayList<String> getNamesOfAllTeam();

}
