package data.matches;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;

import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;
import databaseutility.MEM;
import dataservice.matches.MatchInfoDataService;

public class MatchInfoData implements MatchInfoDataService {
	private static MatchInfoData matchInfoData = null;

	private MatchInfoData() {

	}

	public static MatchInfoData getInstance() {
		if (matchInfoData == null) {
			matchInfoData = new MatchInfoData();
		}
		return matchInfoData;
	}

	public ArrayList<GeneralInfoOfOneMatch> getLatestMatches() {
		if (!MEM.GENERAL_MATCH.isEmpty()) {
			Entry<MyDate, HashSet<GeneralInfoOfOneMatch>> latestDay = MEM.GENERAL_MATCH.lastEntry();
			ArrayList<GeneralInfoOfOneMatch> matchArray = new ArrayList<GeneralInfoOfOneMatch>(16);
			for (GeneralInfoOfOneMatch oneMatch : latestDay.getValue()) {
				matchArray.add(oneMatch);
			}
			return matchArray;
		}
		return null;
	}

	public ArrayList<GeneralInfoOfOneMatch> getTodayMatches(MyDate nowDate) {
		if (MEM.GENERAL_MATCH.containsKey(nowDate)) {
			ArrayList<GeneralInfoOfOneMatch> matchArray = new ArrayList<GeneralInfoOfOneMatch>(16);
			HashSet<GeneralInfoOfOneMatch> todaySet = MEM.GENERAL_MATCH.get(nowDate);
			for (GeneralInfoOfOneMatch oneMatch : todaySet) {
				matchArray.add(oneMatch);
			}
			return matchArray;
		}
		return null;
	}

	public ArrayList<String> getPlayerNameOfOneMatch(String teamName, MyDate date) {
		if (MEM.GENERAL_MATCH.containsKey(date)) {
			HashSet<GeneralInfoOfOneMatch> oneDay = MEM.GENERAL_MATCH.get(date);
			for (GeneralInfoOfOneMatch temp : oneDay) {
				if (temp.getFirstTeamName().equals(teamName)) {
					return temp.getFirstTeamPlayer();
				}
				else if (temp.getSecondTeamName().equals(teamName)) {
					return temp.getSecondTeamPlayer();
				}
			}
		}
		return null;
	}

	public MyDate getLatestDate() {
		if (!MEM.GENERAL_MATCH.isEmpty()) {
			MyDate latestDay = MEM.GENERAL_MATCH.lastKey();
			return latestDay;
		}
		return null;
	}

	public GeneralInfoOfOneMatch getGeneralMatch(String teamName, MyDate date) {
		if (MEM.GENERAL_MATCH.containsKey(date)) {
			HashSet<GeneralInfoOfOneMatch> oneDayMatch = MEM.GENERAL_MATCH.get(date);
			for (GeneralInfoOfOneMatch temp : oneDayMatch) {
				if (temp.getFirstTeamName().equals(teamName) || temp.getSecondTeamName().equals(teamName)) {
					return temp;
				}
			}
		}
		return null;
	}
}
