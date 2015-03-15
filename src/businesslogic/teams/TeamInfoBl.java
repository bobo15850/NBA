package businesslogic.teams;

import java.util.ArrayList;

import vo.GeneralInfoOfTeamVo;
import vo.OneTeamPerformanceOfOneSeasonVo;
import businesslogicservice.teams.TeamInfoBlService;

import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;

import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoBl implements TeamInfoBlService {
	private TeamInfoDataService teamInformationManagementData;

	public TeamInfoBl() {
		teamInformationManagementData = new TeamInfoData();
	}

	@Override
	public ArrayList<OneTeamPerformanceOfOneSeasonVo> getAllTeamPerformanceOfOneSeason(Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OneTeamPerformanceOfOneSeasonVo> getOneTeamInformationOfAllSeason(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OneTeamPerformanceOfOneSeasonVo getOneTeamPerformanceOfOneSeason(String teamName, Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralInfoOfTeamVo getBaseInformationOfOneTeam(String teamName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ascendingSort(ArrayList<OneTeamPerformanceOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {
		// TODO Auto-generated method stub

	}

	@Override
	public void descendingSort(ArrayList<OneTeamPerformanceOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {
		// TODO Auto-generated method stub

	}
}
