package dataservice.teams;

import common.enums.TeamName;
import common.mydatastructure.Season;
import common.mydatastructure.team.baseinformation.BaseInformationOfTeam;
import po.OneTeamPerformanceOfOneSeasonPo;

public interface TeamInformationManagementDataService {
	// 查找某一球队在某一赛季的具体信息
	public OneTeamPerformanceOfOneSeasonPo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season);

	// 根据球队名称查找某一球队具体自然信息
	public BaseInformationOfTeam getBaseInformationOfOneTeam(TeamName teamName);
}
