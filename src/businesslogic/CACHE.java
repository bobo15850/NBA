package businesslogic;

import java.util.Map;
import java.util.TreeMap;

import businesslogic.players.PlayerInfoInit;
import businesslogic.teams.TeamInfoInit;
import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import test.data.TeamHighInfo;
import test.data.TeamNormalInfo;

public class CACHE {
	public static Map<String, PlayerNormalInfo> PLAYER_NORMAL = new TreeMap<String, PlayerNormalInfo>();
	public static Map<String, PlayerHighInfo> PLAYER_HIGH = new TreeMap<String, PlayerHighInfo>();
	//
	public static Map<String, TeamNormalInfo> TEAM_NORMAL = new TreeMap<String, TeamNormalInfo>();
	public static Map<String, TeamHighInfo> TEAM_HIGH = new TreeMap<String, TeamHighInfo>();
	//
	public static Map<String, PlayerNormalInfo> PLAYER_TODAY = new TreeMap<String, PlayerNormalInfo>();
	public static Map<String, TeamNormalInfo> TEAM_TODAY = new TreeMap<String, TeamNormalInfo>();

	static {
		PlayerInfoInit.initPlayerCache();
		PlayerInfoInit.initPlayerTodayCache();
		TeamInfoInit.initTeamCache();
		TeamInfoInit.initTeamTodayCache();
	}
}
