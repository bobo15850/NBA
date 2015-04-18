package data_driver;

import java.util.ArrayList;

import po.TeamPerformanceOfOneMatchPo;
import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;

public class Team_Driver {
	TeamInfoDataService teamInfodata = TeamInfoData.getInstance();

	public void testGeneralInfoPo() {
		System.out.println(this.teamInfodata.getLeagueOfTeam("CLE"));
	}

	public void testAllNames() {
		ArrayList<String> names = teamInfodata.getNamesForShortOfAllTeam();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
			System.out.println(i);
		}
	}

	public void testOneTeamPerformOfOneSeason() {
		String teamName = "CLE";
		ArrayList<TeamPerformanceOfOneMatchPo[]> teamPerformPoList = this.teamInfodata.getOneTeamPerformOfOneSeason(teamName);
		for (int i = 0; i < 1; i++) {
			System.out.println(i);
			System.out.println(teamPerformPoList.get(i)[0]);
			System.out.println(teamPerformPoList.get(i)[1]);
		}
	}

	public static void main(String arg[]) {
		Team_Driver td = new Team_Driver();
		td.testGeneralInfoPo();
//		 td.testAllNames();
//		 td.testOneTeamPerformOfOneSeason();
	}
}
