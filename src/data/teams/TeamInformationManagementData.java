package data.teams;

import po.OneTeamPerformanceOfOneSeasonPo;

import common.enums.TeamName;
import common.mydatastructure.Season;
import common.mydatastructure.team.baseinformation.BaseInformationOfTeam;

import dataservice.teams.TeamInformationManagementDataService;

public class TeamInformationManagementData implements TeamInformationManagementDataService {

	public OneTeamPerformanceOfOneSeasonPo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season) {
		return new OneTeamPerformanceOfOneSeasonPo(teamName, season);
	}

	public BaseInformationOfTeam getBaseInformationOfOneTeam(TeamName teamName) {
		return new BaseInformationOfTeam(teamName);
	}

}
