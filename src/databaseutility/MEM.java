package databaseutility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.MyDate;
import common.statics.League;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class MEM {
	public static Map<String, TreeMap<MyDate, PlayerPerformanceOfOneMatchPo>> PLAYERS_PERFORM = new HashMap<String, TreeMap<MyDate, PlayerPerformanceOfOneMatchPo>>();
	// 球员数据存储
	public static Map<String, GeneralInfoOfPlayerPo> PLAYER_GENERALINFO = new HashMap<String, GeneralInfoOfPlayerPo>();
	// 求援基本信息存储
	public static Map<String, TreeMap<MyDate, TeamPerformanceOfOneMatchPo>> TEAM_PERFORM = new HashMap<String, TreeMap<MyDate, TeamPerformanceOfOneMatchPo>>();
	// 球队数据存储
	public static Map<String, String> TEAM_LEAGUE = new HashMap<String, String>();
	// 球队基本信息存储
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
		GeneralInfoOfPlayerPo playerInfoPo = new GeneralInfoOfPlayerPo();
		playerInfoPo.setName(element[0]);
		playerInfoPo.setPosition(element[2]);
		playerInfoPo.setAge(toInt(element[6]));
		playerReader.close();
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
	}

	private static int toInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

}
