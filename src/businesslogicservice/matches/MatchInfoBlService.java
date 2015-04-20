package businesslogicservice.matches;

import java.util.ArrayList;

import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;

public interface MatchInfoBlService {
	public MyDate getLatestDate();

	public ArrayList<GeneralInfoOfOneMatch> getLatestMatches();// 得到最近的一个比赛日的所有比赛

	public ArrayList<GeneralInfoOfOneMatch> getTodayMatches(MyDate nowDate);// 根据当前日期得到今天所有比赛、、如果没有比赛则null
}
