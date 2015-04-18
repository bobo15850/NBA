package databaseutility;

import java.util.ArrayList;

import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.MyTime;

public abstract class DataCorrection {
	public static void correctTotalPlayingTime(
			TeamPerformanceOfOneMatchPo teamPerformance) {
		for (int i = 0; i < 5; i++) {
			MyTime std = new MyTime(String.valueOf(241 + 25 * i) + ":00");
			if (teamPerformance.getPlayingTime().compareTo(std) < 0) {
				teamPerformance.setPlayingTime(new MyTime(String
						.valueOf(24 + 25 * i) + ":00"));
			}
		}
	}

	// ///////////////////////////////////////////////////////////////////////////////////////////////
	public static void correctPlayerScoreNumber(
			ArrayList<PlayerPerformanceOfOneMatchPo> listOfFirstTeamPlayerPerformance,
			int firstTeamSocre) {
		int flag = 0;
		for (int i = 0; i < listOfFirstTeamPlayerPerformance.size(); i++) {
			if (listOfFirstTeamPlayerPerformance.get(i).getScoreNumber() == 9999) {
				flag = i;
				System.out.println(flag);
			}
		}
	}
}
