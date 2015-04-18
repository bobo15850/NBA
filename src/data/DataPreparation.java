package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import po.GeneralInfoOfPlayerPo;
import po.GeneralInfoOfTeamPo;

import common.mydatastructure.MyDate;
import common.mydatastructure.Height;
import common.mydatastructure.Weight;
import common.statics.NUMBER;
import common.statics.PathOfFile;
import common.statics.EnumMethod;

import databaseutility.OperationOfGeneralInfoDB;

public class DataPreparation {
	OperationOfGeneralInfoDB dbOfGeneralInfo = OperationOfGeneralInfoDB.getGeneralInfo();

	public DataPreparation() {
		this.handleFileOfTeams();
		this.handleFileOfPlayers();
		this.handleFileOfMatches();
	}// 初始化数据库系统

	private void handleFileOfTeams() {
		try {
			String table = "generalinfoofteam";
			String tableFormat = "(teamNameForshort varchar(16) NOT NULL,teamName varchar(64) NOT NULL ,location varchar(64) NOT NULL,"
					+ "conference varchar(64) NOT NULL,division varchar(64) NOT NULL,homeField varchar(64) NOT NULL,establishYear int NOT NULL, PRIMARY KEY (teamNameForshort))";
			dbOfGeneralInfo.createTable(table, tableFormat);
			BufferedReader teamReader = new BufferedReader(new FileReader(PathOfFile.TEAM_INFO + "teams"));
			teamReader.readLine();
			String formatdetail;
			for (int i = 0; i < NUMBER.NUMBER_OF_TEAM; i++) {
				formatdetail = teamReader.readLine();
				this.writeTeamInfoToDB(formatdetail);
			}
			teamReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 读取球队基本信息并写入数据库表格

	private void handleFileOfPlayers() {
		String table = "generalinfoofplayer";
		String tableFormat = "(playerName varchar(64) NOT NULL ,playerNumber varchar(8) NOT NULL,position varchar(4) NOT NULL,"
				+ "height varchar(8) NOT NULL,weight int NOT NULL,birthday varchar(16) NOT NULL,age int NOT NULL,"
				+ "trainingYear int NOT NULL,school varchar(64) NOT NULL, PRIMARY KEY (playerName))";
		dbOfGeneralInfo.createTable(table, tableFormat);
		File playerFile = new File(PathOfFile.PLAYER_INFO);
		String playerName[] = playerFile.list();
		for (int i = 0; i < playerName.length; i++) {
			this.writePlayerInfoToDB(playerName[i]);
		}
	}// 读取球员基本信息并写入数据库

	private void handleFileOfMatches() {
		File matchFile = new File(PathOfFile.MATCH_INFO);
		String matchName[] = matchFile.list();
		for (int i = 0; i < matchName.length; i++) {
			OneMatch match = new OneMatch(matchName[i]);
			match.writeDetailInfoOfPlayerAndTeamToDB();
		}
	}// 读取每场比赛信息，并分析后写入数据库

	private void writePlayerInfoToDB(String playname) {
		try {
			String part[];
			String[] element = new String[9];
			BufferedReader playerReader = new BufferedReader(new FileReader(PathOfFile.PLAYER_INFO + playname));
			playerReader.readLine();
			for (int i = 0; i < 9; i++) {
				String temp = playerReader.readLine();
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
			playerInfoPo.setNumber(element[1]);
			playerInfoPo.setPosition(EnumMethod.toPosition(element[2]));
			playerInfoPo.setHeight(new Height(element[3]));
			playerInfoPo.setWeight(new Weight(toInt(element[4])));
			int month = EnumMethod.toMonthInt(element[5].substring(0, 3));
			String[] dates = element[5].split(",");
			int year = toInt(dates[1].trim());
			int day = toInt(dates[0].substring(4).trim());
			playerInfoPo.setBirthday(new MyDate(year, month, day));
			playerInfoPo.setAge(toInt(element[6]));
			playerInfoPo.setTrainingYear(toInt(element[7]));
			playerInfoPo.setShool(element[8]);
			dbOfGeneralInfo.add("generalinfoofplayer", playerInfoPo.toDBString());
			playerReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int toInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private void writeTeamInfoToDB(String formatdetail) {
		GeneralInfoOfTeamPo TeamInfoPo = new GeneralInfoOfTeamPo();
		String[] part = formatdetail.split("│");
		TeamInfoPo.setTeamName(part[0].trim().substring(1));
		TeamInfoPo.setTeamNameForShort(part[1].trim());
		TeamInfoPo.setLocation(part[2].trim());
		TeamInfoPo.setConference(EnumMethod.toConference(part[3].trim()));
		TeamInfoPo.setDivision(EnumMethod.toDivision(part[4].trim()));
		TeamInfoPo.setHomeField(part[5].trim());
		TeamInfoPo.setEstablishYear(toInt(part[6].trim().substring(0, 4)));
		OperationOfGeneralInfoDB dbOfGeaneralInfo = OperationOfGeneralInfoDB.getGeneralInfo();
		dbOfGeaneralInfo.add("generalinfoofteam", TeamInfoPo.toDBString());
	}// 将球队的基本信息写入数据库的一条记录

	public static void main(String arg[]) {
		new DataPreparation();
	}
}
