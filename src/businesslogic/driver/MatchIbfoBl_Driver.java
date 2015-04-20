package businesslogic.driver;

import java.util.ArrayList;

import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;
import businesslogic.matches.MatchInfoBl;
import businesslogicservice.matches.MatchInfoBlService;

public class MatchIbfoBl_Driver {
	private MatchInfoBlService matchInfoBl = new MatchInfoBl();

	private void testGetLatestDate() {
		MyDate date = this.matchInfoBl.getLatestDate();
		System.out.println(date.getFormatString());
	}

	private void testGetLatestMatches() {
		ArrayList<GeneralInfoOfOneMatch> oneDayMatch = this.matchInfoBl.getLatestMatches();
		for (int i = 0; i < oneDayMatch.size(); i++) {
			System.out.println(oneDayMatch.get(i).toString());
		}
	}

	private void testGetTodayMatches() {
		MyDate date = new MyDate("13-11-10");
		ArrayList<GeneralInfoOfOneMatch> oneDayMatch = this.matchInfoBl.getTodayMatches(date);
		for (int i = 0; i < oneDayMatch.size(); i++) {
			System.out.println(oneDayMatch.get(i).toString());
		}
	}

	public static void main(String args[]) {
		MatchIbfoBl_Driver driver = new MatchIbfoBl_Driver();
		driver.testGetLatestDate();
		driver.testGetLatestMatches();
		driver.testGetTodayMatches();
	}

}
