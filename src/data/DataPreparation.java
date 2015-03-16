package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import common.statics.NUMBER;
import common.statics.PathOfFile;

public class DataPreparation {
	public DataPreparation() {
		this.handleFileOfTeams();
		// this.handleFileOfPlayers();
		// this.handleFileOfMatches();
	}// 初始化数据库系统

	private void handleFileOfTeams() {
		try {
			BufferedReader teamReader = new BufferedReader(new FileReader(PathOfFile.TEAM_INFO
					+ "teams"));
			teamReader.readLine();
			String formatdetail;
			for (int i = 0; i < NUMBER.NUMBER_OF_TEAM; i++) {
				formatdetail = teamReader.readLine();
				System.out.println(formatdetail);
				this.createAndWriteFileOfTeam(formatdetail);
			}
			teamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 读取球队基本信息并写入数据库

	private void handleFileOfPlayers() {

	}// 读取球员基本信息并写入数据库

	private void handleFileOfMatches() {
		File matchFile = new File(PathOfFile.MATCH_INFO);
		String matchName[] = matchFile.list();
		for (int i = 0; i < matchName.length; i++) {
			OneMatch match = new OneMatch(matchName[i]);
			match.writeDetailInfoOfPlayerAndTeamToDB();
		}
	}// 读取每场比赛信息，并分析后写入数据库

	private void createAndWriteFileOfTeam(String formatdetail) {
		
	}
}
