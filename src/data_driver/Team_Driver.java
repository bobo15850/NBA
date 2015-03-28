package data_driver;

import java.util.ArrayList;

import po.GeneralInfoOfTeamPo;
import po.TeamPerformanceOfOneMatchPo;

import common.mydatastructure.Season;

import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;

public class Team_Driver {
	TeamInfoDataService teamInfodata = new TeamInfoData();

	public void testGeneralInfoPo() {
		GeneralInfoOfTeamPo playerPo = teamInfodata.getBaseInformationOfOneTeam("dal");
		System.out.println(playerPo.toDBString());
	}

	public void testAllNames() {
		ArrayList<String> names = teamInfodata.getNamesForShortOfAllTeam();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
			System.out.println(i);
		}
	}

	public void testOneTeamPerformOfOneSeason() {
		Season season = new Season("2013-2014");
		String teamName = "bos";
		ArrayList<TeamPerformanceOfOneMatchPo[]> teamPerformPoList = this.teamInfodata.getOneTeamPerformOfOneSeason(
				teamName, season);
		for (int i = 0; i < teamPerformPoList.size(); i++) {
			System.out.println(i);
			System.out.println(teamPerformPoList.get(i)[0].toDBString());
			System.out.println(teamPerformPoList.get(i)[1].toDBString());
		}
	}

	public static void main(String arg[]) {
		Team_Driver td = new Team_Driver();
		td.testGeneralInfoPo();
		td.testAllNames();
		td.testOneTeamPerformOfOneSeason();
	}
}
