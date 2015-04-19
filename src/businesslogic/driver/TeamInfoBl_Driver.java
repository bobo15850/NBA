package businesslogic.driver;

import java.util.ArrayList;

import common.mydatastructure.SortCell;
import common.mydatastructure.TeamNormalInfo_Expand;
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

	private void testGetTeamNormal_tot() {
		SortCell[] sortCells = new SortCell[] { new SortCell("point.desc"), new SortCell("rebound.desc") };
		ArrayList<TeamNormalInfo_Expand> teamNormal_tot = this.teamInfoBl.getTeamNormal_tot(30, sortCells);
		for (int i = 0; i < teamNormal_tot.size(); i++) {
			System.out.println(teamNormal_tot.get(i).toString());
		}
	}

	private void testGetTeamNormal_avg() {
		SortCell[] sortCells = new SortCell[] { new SortCell("point.desc"), new SortCell("rebound.desc") };
		ArrayList<TeamNormalInfo_Expand> teamNormal_avg = this.teamInfoBl.getTeamNormal_avg(30, sortCells);
		for (int i = 0; i < teamNormal_avg.size(); i++) {
			System.out.println(teamNormal_avg.get(i).toString());
		}
	}

	public static void main(String args[]) {
		TeamInfoBl_Driver driver = new TeamInfoBl_Driver();
		driver.testGetTeamHigh();
		driver.testGetTeamNormal_tot();
		driver.testGetTeamNormal_avg();
	}
}
