package businesslogic.driver;

import java.util.ArrayList;

import common.mydatastructure.SortCell;

import businesslogic.teams.TeamInfoBl;
import businesslogicservice.teams.TeamInfoBlService;
import test.data.TeamHighInfo;

public class TeamInfoBl_Driver {
	TeamInfoBlService teamInfoBl = new TeamInfoBl();

	private void testGetTeamHigh() {
		SortCell[] sortCells = new SortCell[] { new SortCell("winRate.desc"), new SortCell("offendEfficient.desc") };
		ArrayList<TeamHighInfo> teamHighList = this.teamInfoBl.getTeamHigh(30, sortCells);
		for (int i = 0; i < teamHighList.size(); i++) {
			System.out.println(teamHighList.get(i).toString());
		}
	}

	public static void main(String args[]) {
		TeamInfoBl_Driver driver = new TeamInfoBl_Driver();
		driver.testGetTeamHigh();
	}
}
