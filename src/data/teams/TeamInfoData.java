package data.teams;

import po.GeneralInfoOfTeamPo;
import po.OneTeamPerformanceOfOneSeasonPo;
import common.enums.TeamName;
import common.mydatastructure.Season;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoData implements TeamInfoDataService {

	public OneTeamPerformanceOfOneSeasonPo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season) {
		return new OneTeamPerformanceOfOneSeasonPo(teamName, season);
	}

	public GeneralInfoOfTeamPo getBaseInformationOfOneTeam(TeamName teamName) {
		return new GeneralInfoOfTeamPo(teamName);
	}

}
