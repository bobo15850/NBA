package dataservice.matches;

import java.util.ArrayList;

import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;

public interface MatchInfoDataService {

	public ArrayList<GeneralInfoOfOneMatch> getLatestMatches();

	public ArrayList<GeneralInfoOfOneMatch> getTodayMatches(MyDate nowDate);

	public ArrayList<String> getPlayerNameOfOneMatch(String teamName, MyDate date);

	public MyDate getLatestDate();

	public GeneralInfoOfOneMatch getGeneralMatch(String teamName, MyDate date);
}
