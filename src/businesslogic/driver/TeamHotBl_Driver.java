package businesslogic.driver;

import java.util.ArrayList;

import businesslogic.hotsport.TeamHotBl;
import businesslogicservice.hotsport.TeamHotBlService;
import test.data.TeamHotInfo;

public class TeamHotBl_Driver {
	private TeamHotBlService teamHotBl = new TeamHotBl();

	private void testGetTeamHot() {
		ArrayList<TeamHotInfo> teamHotList = teamHotBl.getTeamHot(5, "point");
		for (int i = 0; i < teamHotList.size(); i++) {
			System.out.println(teamHotList.get(i).toString());
		}
	}

	public static void main(String args[]) {
		TeamHotBl_Driver driver = new TeamHotBl_Driver();
		driver.testGetTeamHot();
	}
}
