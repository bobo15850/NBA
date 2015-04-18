package businesslogicservice.matches;

import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerPerformOfOneMatch;

public interface OneMatchInfoBlService {
	public PlayerPerformOfOneMatch[] getPlayersPerformOfOneMatch(String teamName, MyDate date);// 根据球队名称和时间得到该场比赛的所有球员比赛信息
}
