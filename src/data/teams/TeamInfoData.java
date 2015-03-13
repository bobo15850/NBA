package data.teams;

import po.OneTeamPerformanceOfOneSeasonPo;
import common.enums.TeamName;
import common.mydatastructure.Season;
import common.mydatastructure.team.GeneralInfoOfTeam;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoData implements TeamInfoDataService {

	public OneTeamPerformanceOfOneSeasonPo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season) {
		return new OneTeamPerformanceOfOneSeasonPo(teamName, season);
	}

	public GeneralInfoOfTeam getBaseInformationOfOneTeam(TeamName teamName) {
		return new GeneralInfoOfTeam(teamName);
	}

}
