package businesslogic.teams;

import java.util.ArrayList;

import test.data.TeamHighInfo;
import common.mydatastructure.GeneralInfoOfTeam;
import common.mydatastructure.MyDate;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;
import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;
import businesslogic.CACHE;
import businesslogicservice.teams.OneTeamInfoBlService;

public class OneTeamInfoBl implements OneTeamInfoBlService {
	private TeamInfoDataService teamInfoData = TeamInfoData.getInstance();

	public String[] getPlayerNameOfTeam(String teamName) {
		return this.teamInfoData.getNameOfAllPlayer(teamName);
	}

	public TeamNormalInfo_Expand getTeamNormalInfo_tot(String teamName) {
		if (CACHE.TEAM_NORMAL.containsKey(teamName)) {
			return CACHE.TEAM_NORMAL.get(teamName);
		}
		else {
			return null;
		}
	}

	public TeamNormalInfo_Expand getTeamNormalInfo_avg(String teamName) {
		if (CACHE.TEAM_NORMAL.containsKey(teamName)) {
			return CACHE.TEAM_NORMAL.get(teamName).getTeamNormal_avg();
		}
		else {
			return null;
		}
	}

	public TeamHighInfo getOneTeamHighInfo(String teamName) {
		if (CACHE.TEAM_HIGH.containsKey(teamName)) {
			return CACHE.TEAM_HIGH.get(teamName);
		}
		else {
			return null;
		}
	}

	public ArrayList<TeamPerformOfOneMatch> getTeamPerform(String teamName) {
		ArrayList<TeamPerformOfOneMatch[]> teamPerform = this.teamInfoData.getOneTeamPerformOfOneSeason(teamName);
		ArrayList<TeamPerformOfOneMatch> resultList = new ArrayList<TeamPerformOfOneMatch>(128);
		for (int i = 0; i < teamPerform.size(); i++) {
			resultList.add(teamPerform.get(i)[0]);
		}
		return resultList;
	}

	public GeneralInfoOfTeam getTeamGeneralInfo(String teamName) {
		return this.teamInfoData.getGeneralInfoOfTeam(teamName);
	}

	public TeamPerformOfOneMatch getOneMatchTeamPerform(String teamName, MyDate date) {
		return teamInfoData.getOneMatchTeamPerform( teamName, date);
	}
}
