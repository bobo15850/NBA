package databaseutility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import common.mydatastructure.GeneralInfoOfOneMatch;
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

	@SuppressWarnings("null")
	public void writeGeneralMatchInfo() {
		int[] firstTeamQuarter = null;
		int[] secondTeamQuarter = null;
		ArrayList<String> firstTeamPlayer = new ArrayList<String>(16);
		ArrayList<String> secondTeamPlayer = new ArrayList<String>(16);
		String[] quarter = super.quarterPoint.split(";");
		for (int i = 0; i < quarter.length; i++) {
			String[] part = quarter[i].split("-");
			firstTeamQuarter[i] = super.toInt(part[0]);
			secondTeamQuarter[i] = super.toInt(part[1]);
		}
		for (int i = 0; i < super.listOfFirstTeamPlayerPerformance.size(); i++) {
			firstTeamPlayer.add(listOfFirstTeamPlayerPerformance.get(i).getNameOfPlayer());
		}
		for (int i = 0; i < super.listOfSecondTeamPlayerPerformance.size(); i++) {
			secondTeamPlayer.add(listOfSecondTeamPlayerPerformance.get(i).getNameOfPlayer());
		}
		GeneralInfoOfOneMatch oneMatch = new GeneralInfoOfOneMatch();
		oneMatch.setDate(date);
		oneMatch.setFirstTeamName(firstTeam);
		oneMatch.setFirstTeamScore(firstTeamSocre);
		oneMatch.setSecondTeamName(secondTeam);
		oneMatch.setSecondTeamScore(secondTeamScore);
		oneMatch.setFirstTeamQuarterScore(firstTeamQuarter);
		oneMatch.setSecondTeamQuarterScore(secondTeamQuarter);
		oneMatch.setFirstTeamPlayer(firstTeamPlayer);
		oneMatch.setSecondTeamPlayer(secondTeamPlayer);
		if (MEM.GENERAL_MATCH.containsKey(date)) {
			MEM.GENERAL_MATCH.get(date).add(oneMatch);
		}
		else {
			HashSet<GeneralInfoOfOneMatch> oneday = new HashSet<GeneralInfoOfOneMatch>(16);
			oneday.add(oneMatch);
			MEM.GENERAL_MATCH.put(date, oneday);

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
		if (MEM.PLAYER_IN_TEAM.containsKey(playerPo.getTeamNameForShort())) {
			if (!MEM.PLAYER_IN_TEAM.get(playerPo.getTeamNameForShort()).contains(playerName)) {
				MEM.PLAYER_IN_TEAM.get(playerPo.getTeamNameForShort()).add(playerName);
			}// 将球队的球员添加到球队的球员集合中
		}
		else {
			HashSet<String> oneTeam = new HashSet<String>(16);
			oneTeam.add(playerName);
			MEM.PLAYER_IN_TEAM.put(playerPo.getTeamNameForShort(), oneTeam);
		}

	}
}
