package businesslogic.driver;

import java.util.ArrayList;

import test.data.TeamHighInfo;
import businesslogic.teams.OneTeamInfoBl;
import businesslogicservice.teams.OneTeamInfoBlService;

import common.mydatastructure.GeneralInfoOfTeam;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;

public class OneTeamInfoBl_Driver {
	private OneTeamInfoBlService oneTeamInfoBl = new OneTeamInfoBl();
	String teamName = "OKC";

	private void testGetTeamGeneralInfo() {
		GeneralInfoOfTeam generalInfo = this.oneTeamInfoBl.getTeamGeneralInfo(teamName);
		System.out.println(generalInfo.toString());
	}

	private void testGetPlayerNameOfTeam() {
		String[] playerNameArray = oneTeamInfoBl.getPlayerNameOfTeam(teamName);
		for (int i = 0; i < playerNameArray.length; i++) {
			System.out.println(playerNameArray[i]);
		}
	}

	private void testGetTeamPerform() {
		ArrayList<TeamPerformOfOneMatch> teamPerform = this.oneTeamInfoBl.getTeamPerform(teamName);
		for (int i = 0; i < teamPerform.size(); i++) {
			System.out.println(teamPerform.get(i).toString());
		}
	}

	private void testGetOneTeamHighInfo() {
		TeamHighInfo playerHigh = this.oneTeamInfoBl.getOneTeamHighInfo(teamName);
		System.out.println(playerHigh.toString());
	}

	private void testGetTeamNormalInfo_avg() {
		TeamNormalInfo_Expand teamNormal_avg = this.oneTeamInfoBl.getTeamNormalInfo_avg(teamName);
		System.out.println(teamNormal_avg.toString());
	}

	private void testGetTeamNormalInfo_tot() {
		TeamNormalInfo_Expand teamNormal_tot = this.oneTeamInfoBl.getTeamNormalInfo_tot(teamName);
		System.out.println(teamNormal_tot.toString());
	}

	public static void main(String args[]) {
		OneTeamInfoBl_Driver driver = new OneTeamInfoBl_Driver();
		driver.testGetTeamGeneralInfo();
		driver.testGetPlayerNameOfTeam();
		driver.testGetTeamPerform();
		driver.testGetOneTeamHighInfo();
		driver.testGetTeamNormalInfo_avg();
		driver.testGetTeamNormalInfo_tot();
	}
}
