package data.teams;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.MyDate;
import databaseutility.MEM;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoData implements TeamInfoDataService {
	private static TeamInfoData teamInfoData = null;

	private TeamInfoData() {
	}

	public static TeamInfoData getInstance() {
		if (teamInfoData == null) {
			teamInfoData = new TeamInfoData();
		}
		return teamInfoData;
	}

	public ArrayList<TeamPerformanceOfOneMatchPo[]> getOneTeamPerformOfOneSeason(String teamName) {
		ArrayList<TeamPerformanceOfOneMatchPo[]> resultList = new ArrayList<TeamPerformanceOfOneMatchPo[]>(128);
		Map<MyDate, TeamPerformanceOfOneMatchPo> oneTeamPerform = MEM.TEAM_PERFORM.get(teamName);
		Set<MyDate> dateSet = oneTeamPerform.keySet();
		for (MyDate date : dateSet) {
			TeamPerformanceOfOneMatchPo selfTeamPo = oneTeamPerform.get(date);
			String opponentTeam = selfTeamPo.getOpponentTeamNameForShort();
			TeamPerformanceOfOneMatchPo opponentTeamPo = MEM.TEAM_PERFORM.get(opponentTeam).get(date);
			resultList.add(new TeamPerformanceOfOneMatchPo[] { selfTeamPo, opponentTeamPo });
		}
		return resultList;
	}

	public ArrayList<String> getNamesForShortOfAllTeam() {
		Set<String> teamNameSet = MEM.TEAM_PERFORM.keySet();
		ArrayList<String> resultList = new ArrayList<String>(32);
		for (String name : teamNameSet) {
			resultList.add(name);
		}
		return resultList;
	}

	public String getLeagueOfTeam(String teamNameForShort) {
		if (MEM.TEAM_LEAGUE.containsKey(teamNameForShort)) {
			return MEM.TEAM_LEAGUE.get(teamNameForShort);
		}
		else {
			return null;
		}
	}
}
