package businesslogic;

import java.util.Map;
import java.util.TreeMap;

import test.data.PlayerHighInfo;
import test.data.TeamHighInfo;
import businesslogic.players.PlayerInfoInit;
import businesslogic.teams.TeamInfoInit;

import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamNormalInfo_Expand;

public class CACHE {
	public static Map<String, PlayerNormalInfo_Expand> PLAYER_NORMAL = new TreeMap<String, PlayerNormalInfo_Expand>();
	public static Map<String, PlayerHighInfo> PLAYER_HIGH = new TreeMap<String, PlayerHighInfo>();
	//
	public static Map<String, TeamNormalInfo_Expand> TEAM_NORMAL = new TreeMap<String, TeamNormalInfo_Expand>();
	public static Map<String, TeamHighInfo> TEAM_HIGH = new TreeMap<String, TeamHighInfo>();
	//
	public static Map<String, PlayerPerformOfOneMatch> PLAYER_TODAY = new TreeMap<String, PlayerPerformOfOneMatch>();
	//
	static {
		PlayerInfoInit.initPlayerCache();
		PlayerInfoInit.initPlayerTodayCache();
		TeamInfoInit.initTeamCache();
	}
}
