package businesslogic.driver;

import java.util.ArrayList;

import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerPerformOfOneMatch;
import businesslogic.matches.OneMatchInfoBl;
import businesslogicservice.matches.OneMatchInfoBlService;

public class OneMatchInfoBl_Driver {
	private OneMatchInfoBlService oneMatchInfoBl = new OneMatchInfoBl();

	private void testGetPlayersPerformOfOneMatch() {
		String teamName = "SAS";
		MyDate date = new MyDate("13-11-10");
		ArrayList<PlayerPerformOfOneMatch> playerPerformList = this.oneMatchInfoBl.getPlayersPerformOfOneMatch(teamName, date);
		for (int i = 0; i < playerPerformList.size(); i++) {
			System.out.println(playerPerformList.get(i).toString());
		}
	}

	public static void main(String args[]) {
		OneMatchInfoBl_Driver driver = new OneMatchInfoBl_Driver();
		driver.testGetPlayersPerformOfOneMatch();

	}
}
