package databaseutility;

import java.util.TreeMap;

import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;

import common.mydatastructure.MyDate;

public class OneMatch_init extends OneMatch {

	public OneMatch_init(String nameOfFile) {
		super(nameOfFile);
	}

	public void writeDetailInfoOfPlayerAndTeamToMEN() {
		System.out.println(nameOfFile);
		if (isDataCorrect) {
			PlayerPerformanceOfOneMatchPo playerPo;
			for (int i = 0; i < listOfFirstTeamPlayerPerformance.size(); i++) {
				playerPo = listOfFirstTeamPlayerPerformance.get(i);
				writeDetailInfoOfPlayerPerform(playerPo);
			}
			for (int i = 0; i < listOfSecondTeamPlayerPerformance.size(); i++) {
				playerPo = listOfSecondTeamPlayerPerformance.get(i);
				writeDetailInfoOfPlayerPerform(playerPo);
			}
			writeDetailInfoOfTeamPerform(firstTeamPerformance);
			writeDetailInfoOfTeamPerform(secondTeamPerformance);
		}
	}

	private void writeDetailInfoOfTeamPerform(TeamPerformanceOfOneMatchPo teamPo) {
		String teamNameForShort = teamPo.getTeamNameForShort();
		TreeMap<MyDate, TeamPerformanceOfOneMatchPo> oneTeamPerform;
		if (MEM.TEAM_PERFORM.containsKey(teamNameForShort)) {
			oneTeamPerform = MEM.TEAM_PERFORM.get(teamNameForShort);
			oneTeamPerform.put(date, teamPo);
		}
		else {
			oneTeamPerform = new TreeMap<MyDate, TeamPerformanceOfOneMatchPo>();
			oneTeamPerform.put(date, teamPo);
			MEM.TEAM_PERFORM.put(teamNameForShort, oneTeamPerform);
		}
	}

	private void writeDetailInfoOfPlayerPerform(PlayerPerformanceOfOneMatchPo playerPo) {
		String playerName = playerPo.getNameOfPlayer();
		TreeMap<MyDate, PlayerPerformanceOfOneMatchPo> onePlayerPerform;
		if (MEM.PLAYERS_PERFORM.containsKey(playerName)) {
			onePlayerPerform = MEM.PLAYERS_PERFORM.get(playerName);
			onePlayerPerform.put(date, playerPo);
		}
		else {
			onePlayerPerform = new TreeMap<MyDate, PlayerPerformanceOfOneMatchPo>();
			onePlayerPerform.put(date, playerPo);
			MEM.PLAYERS_PERFORM.put(playerName, onePlayerPerform);
		}
	}
}
