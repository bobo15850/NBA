package businesslogic.matches;

import java.util.ArrayList;

import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;
import data.matches.MatchInfoData;
import dataservice.matches.MatchInfoDataService;
import businesslogicservice.matches.MatchInfoBlService;

public class MatchInfoBl implements MatchInfoBlService {
	MatchInfoDataService matchInfoData = MatchInfoData.getInstance();

	public ArrayList<GeneralInfoOfOneMatch> getLatestMatches() {
		return matchInfoData.getLatestMatches();
	}

	public ArrayList<GeneralInfoOfOneMatch> getTodayMatches(final MyDate nowDate) {
		return matchInfoData.getTodayMatches(nowDate);
	}

	public MyDate getLatestDate() {
		return matchInfoData.getLatestDate();
	}

	public GeneralInfoOfOneMatch getGeneralMatch(final String teamName,final MyDate date) {
		return matchInfoData.getGeneralMatch(teamName, date);
	}
}
