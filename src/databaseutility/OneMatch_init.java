package databaseutility;

import java.util.TreeMap;

import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamPerformOfOneMatch;

public class OneMatch_init extends OneMatch {

	public OneMatch_init(String nameOfFile) {
		super(nameOfFile);
	}

	public void writeDetailInfoOfPlayerAndTeamToMEN() {
		System.out.println(nameOfFile);
		if (isDataCorrect) {
			PlayerPerformOfOneMatch playerPo;
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

	private void writeDetailInfoOfTeamPerform(TeamPerformOfOneMatch teamPo) {
		String teamNameForShort = teamPo.getTeamNameForShort();
		TreeMap<MyDate, TeamPerformOfOneMatch> oneTeamPerform;
		if (MEM.TEAM_PERFORM.containsKey(teamNameForShort)) {
			oneTeamPerform = MEM.TEAM_PERFORM.get(teamNameForShort);
			oneTeamPerform.put(date, teamPo);
		}
		else {
			oneTeamPerform = new TreeMap<MyDate, TeamPerformOfOneMatch>();
			oneTeamPerform.put(date, teamPo);
			MEM.TEAM_PERFORM.put(teamNameForShort, oneTeamPerform);
		}
	}

	private void writeDetailInfoOfPlayerPerform(PlayerPerformOfOneMatch playerPo) {
		String playerName = playerPo.getNameOfPlayer();
		TreeMap<MyDate, PlayerPerformOfOneMatch> onePlayerPerform;
		if (MEM.PLAYERS_PERFORM.containsKey(playerName)) {
			onePlayerPerform = MEM.PLAYERS_PERFORM.get(playerName);
			onePlayerPerform.put(date, playerPo);
		}
		else {
			onePlayerPerform = new TreeMap<MyDate, PlayerPerformOfOneMatch>();
			onePlayerPerform.put(date, playerPo);
			MEM.PLAYERS_PERFORM.put(playerName, onePlayerPerform);
		}
	}
}
