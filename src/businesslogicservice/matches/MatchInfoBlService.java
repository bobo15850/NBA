package businesslogicservice.matches;

import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;

public interface MatchInfoBlService {
	public GeneralInfoOfOneMatch[] getLatestMatches();// 得到最近的一个比赛日的所有比赛

	public GeneralInfoOfOneMatch[] getPreviewMatches(MyDate nowDate);// 根据当前日期得到之前一个比赛日的所有比赛
}
