package data.players;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamPerformOfOneMatch;
import common.statics.League;
import common.statics.NUMBER;
import common.statics.Position;
import databaseutility.MEM;
import dataservice.players.PlayerInfoDataService;

public class PlayerInfoData implements PlayerInfoDataService {
	private static PlayerInfoData playerInfoData = null;

	private PlayerInfoData() {
	}

	public static PlayerInfoData getInstance() {
		if (playerInfoData == null) {
			playerInfoData = new PlayerInfoData();
		}
		return playerInfoData;
	}

	public ArrayList<PlayerPerformOfOneMatch> getOnePlayerPerformOfOneSeasonPo(String nameOfPlayer) {
		ArrayList<PlayerPerformOfOneMatch> resultList = new ArrayList<PlayerPerformOfOneMatch>(128);
		TreeMap<MyDate, PlayerPerformOfOneMatch> onePlayerPerform = MEM.PLAYERS_PERFORM.get(nameOfPlayer);
		Set<MyDate> dateSet = onePlayerPerform.keySet();
		for (MyDate date : dateSet) {
			resultList.add(onePlayerPerform.get(date));
		}
		return resultList;
	}

	public ArrayList<String> getNamesOfAllPlayer() {
		Set<String> playerNameSet = MEM.PLAYERS_PERFORM.keySet();
		ArrayList<String> resultList = new ArrayList<String>(512);
		for (String name : playerNameSet) {
			resultList.add(name);
		}
		return resultList;
	}

	public GeneralInfoOfPlayer getGeneralInfoOfOnePlayer(String nameOfPlayer) {
		GeneralInfoOfPlayer resultPo;
		if (MEM.PLAYER_GENERALINFO.containsKey(nameOfPlayer)) {
			resultPo = MEM.PLAYER_GENERALINFO.get(nameOfPlayer);
		}
		else {
			String unknown = "暂无数据";
			resultPo = new GeneralInfoOfPlayer();
			resultPo.setName(nameOfPlayer);
			resultPo.setAge(NUMBER.UNKNOWN_AGE);
			resultPo.setPosition(Position.UNKUOWN_POSITION);
			resultPo.setBirthday(unknown);
			resultPo.setHeight(unknown);
			resultPo.setWeight(unknown);
			resultPo.setPlayerNumber(unknown);
			resultPo.setSchool(unknown);
			resultPo.setTrainingYear(-1);
		}
		return resultPo;
	}

	public ArrayList<TeamPerformOfOneMatch[]> getOneTeamPerformOfOneSeason(String playerName) {
		ArrayList<TeamPerformOfOneMatch[]> resultList = new ArrayList<TeamPerformOfOneMatch[]>();
		TreeMap<MyDate, PlayerPerformOfOneMatch> onePlayerOfOneSeason = MEM.PLAYERS_PERFORM.get(playerName);
		Set<MyDate> dateSet = onePlayerOfOneSeason.keySet();
		PlayerPerformOfOneMatch temp;
		TeamPerformOfOneMatch selfTeamPo;
		TeamPerformOfOneMatch opponentTeamPo;
		for (MyDate date : dateSet) {
			temp = onePlayerOfOneSeason.get(date);
			String teamNameForShort = temp.getTeamName();
			selfTeamPo = MEM.TEAM_PERFORM.get(teamNameForShort).get(date);
			String opponentTeamNameForShort = selfTeamPo.getOpponentTeamName();
			opponentTeamPo = MEM.TEAM_PERFORM.get(opponentTeamNameForShort).get(date);
			resultList.add(new TeamPerformOfOneMatch[] { selfTeamPo, opponentTeamPo });
		}
		return resultList;
	}

	public String getLeague(String playerName) {
		PlayerPerformOfOneMatch lastMatch = MEM.PLAYERS_PERFORM.get(playerName).lastEntry().getValue();
		String team = lastMatch.getTeamName();
		String league = League.UNKNOWN_LEAGUE;
		if (MEM.TEAM_LEAGUE.containsKey(team)) {
			league = MEM.TEAM_LEAGUE.get(team);
		}
		return league;
	}

	public PlayerPerformOfOneMatch getOnePlayerOneMatchPerform(String playerName, MyDate date) {
		if (MEM.PLAYERS_PERFORM.containsKey(playerName)) {
			if (MEM.PLAYERS_PERFORM.get(playerName).containsKey(date)) {
				return MEM.PLAYERS_PERFORM.get(playerName).get(date);
			}
		}
		return null;
	}
}
