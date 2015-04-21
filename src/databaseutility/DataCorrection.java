package databaseutility;

import java.util.ArrayList;

import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamPerformOfOneMatch;

public abstract class DataCorrection {
	public static void correctTotalPlayingTime(TeamPerformOfOneMatch teamPerformance) {
		// for (int i = 0; i < 5; i++) {
		// MyTime std = new MyTime(String.valueOf(241 + 25 * i) + ":00");
		// if (teamPerformance.getMinute().compareTo(std) < 0) {
		// teamPerformance.setMinute(new MyTime(String.valueOf(24 + 25 * i) +
		// ":00"));
		// }
		// }
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	public static void correctPlayerScoreNumber(ArrayList<PlayerPerformOfOneMatch> listOfFirstTeamPlayerPerformance, int firstTeamSocre) {
		int flag = 0;
		for (int i = 0; i < listOfFirstTeamPlayerPerformance.size(); i++) {
			if (listOfFirstTeamPlayerPerformance.get(i).getPoint() == 9999) {
				flag = i;
				System.out.println(flag);
			}
		}
	}
}
