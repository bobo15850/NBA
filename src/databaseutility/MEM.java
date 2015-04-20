package databaseutility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.GeneralInfoOfTeam;
import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamPerformOfOneMatch;
import common.statics.League;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class MEM {
	public static HashMap<String, TreeMap<MyDate, PlayerPerformOfOneMatch>> PLAYERS_PERFORM = new HashMap<String, TreeMap<MyDate, PlayerPerformOfOneMatch>>();
	// 球员数据存储
	public static HashMap<String, GeneralInfoOfPlayer> PLAYER_GENERALINFO = new HashMap<String, GeneralInfoOfPlayer>();
	// 求援基本信息存储
	public static HashMap<String, TreeMap<MyDate, TeamPerformOfOneMatch>> TEAM_PERFORM = new HashMap<String, TreeMap<MyDate, TeamPerformOfOneMatch>>();
	// 球队数据存储
	public static HashMap<String, String> TEAM_LEAGUE = new HashMap<String, String>();
	// 球队联盟信息存储
	public static HashMap<String, GeneralInfoOfTeam> TEAM_GENERALINFO = new HashMap<String, GeneralInfoOfTeam>();
	// 球队的基本信息存储

	public static HashMap<String, HashSet<String>> PLAYER_IN_TEAM = new HashMap<String, HashSet<String>>();// 每支球队里的队员集合

	public static TreeMap<MyDate, HashSet<GeneralInfoOfOneMatch>> GENERAL_MATCH = new TreeMap<MyDate, HashSet<GeneralInfoOfOneMatch>>();// 每天的比赛集合
	static {
		MEM.handleFileOfMatches();
		MEM.handleFileOfPlayers();
		MEM.handleFileOfTeams();
	}

	private static void handleFileOfMatches() {
		File matchFile = new File(PathOfFile.MATCH_INFO);
		String matchName[] = matchFile.list();
		for (int i = 0; i < matchName.length; i++) {
			OneMatch_init match = new OneMatch_init(matchName[i]);
			match.writeDetailInfoOfPlayerAndTeamToMEN();
			match.writeGeneralMatchInfo();
		}
	}// 读取每场比赛信息，并分析后写入数据库

	private static void handleFileOfPlayers() {
		File playerFile = new File(PathOfFile.PLAYER_INFO);
		String playerName[] = playerFile.list();
		for (int i = 0; i < playerName.length; i++) {
			try {
				writePlayerInfoToMEM(playerName[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void handleFileOfTeams() {
		try {
			BufferedReader teamReader = new BufferedReader(new FileReader(PathOfFile.TEAM_INFO + "teams"));
			teamReader.readLine();
			String formatdetail;
			for (int i = 0; i < NUMBER.NUMBER_OF_TEAM; i++) {
				formatdetail = teamReader.readLine();
				writeTeamInfoToMEM(formatdetail);
			}
			teamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void writePlayerInfoToMEM(String playerName) throws IOException {
		String part[];
		String[] element = new String[9];
		BufferedReader playerReader = new BufferedReader(new FileReader(PathOfFile.PLAYER_INFO + playerName));
		playerReader.readLine();
		String temp;
		for (int i = 0; i < 9; i++) {
			temp = playerReader.readLine();
			part = temp.split("│");
			element[i] = part[1].substring(0, part[1].length() - 2).trim();
			if (element[i].contains("'")) {
				element[i] = element[i].replace("'", " ");
			}
			if (element[i].contains("(")) {
				element[i] = element[i].replace("(", " ");
				element[i] = element[i].replace(")", " ");
			}
			playerReader.readLine();
		}
		playerReader.close();
		GeneralInfoOfPlayer playerInfoPo = new GeneralInfoOfPlayer();
		playerInfoPo.setName(element[0]);
		playerInfoPo.setPlayerNumber(element[1]);
		playerInfoPo.setPosition(element[2]);
		playerInfoPo.setHeight(element[3]);
		playerInfoPo.setWeight(element[4]);
		playerInfoPo.setBirthday(element[5]);
		playerInfoPo.setAge(toInt(element[6]));
		playerInfoPo.setTrainingYear(toInt(element[7]));
		playerInfoPo.setSchool(element[8]);
		MEM.PLAYER_GENERALINFO.put(playerName, playerInfoPo);
	}

	private static void writeTeamInfoToMEM(String formatdetail) {
		String[] part = formatdetail.split("│");
		String league = part[3].trim();
		if (league.equals("E")) {
			MEM.TEAM_LEAGUE.put(part[1].trim(), League.East);
		}
		else if (league.equals("W")) {
			MEM.TEAM_LEAGUE.put(part[1].trim(), League.West);
		}
		//
		GeneralInfoOfTeam generalTeamInfo = new GeneralInfoOfTeam();
		generalTeamInfo.setTeamName(part[0].trim().substring(1));
		generalTeamInfo.setTeamNameForShort(part[1].trim());
		generalTeamInfo.setLocation(part[2].trim());
		generalTeamInfo.setConference(part[3].trim());
		generalTeamInfo.setDivision(part[4].trim());
		generalTeamInfo.setHomeField(part[5].trim());
		generalTeamInfo.setEstablishYear(toInt(part[6].trim().substring(0, 4)));
		MEM.TEAM_GENERALINFO.put(generalTeamInfo.getTeamNameForShort(), generalTeamInfo);
	}

	private static int toInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
