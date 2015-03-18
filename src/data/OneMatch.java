package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.Date;
import common.mydatastructure.Season;
import common.mydatastructure.Time;
import common.statics.NUMBER;
import common.statics.PathOfFile;
import common.statics.ResultMessage;
import databaseutility.OperationOfPlayersDB;
import databaseutility.OperationOfTeamsDB;

public class OneMatch {
	private OperationOfTeamsDB dbOfTeam = OperationOfTeamsDB.getTeamDB();
	private OperationOfPlayersDB dbOfPlayer = OperationOfPlayersDB.getPlayerDB();
	private String nameOfFile;
	private String firstTeam;// 第一支球队
	private String secondTeam;// 第二支球队
	private Date date;// 比赛时间
	private Season season;// 赛季
	private int firstTeamSocre;// 第一支球队得分
	private int secondTeamScore;// 第二支球队得分
	private boolean isDataCorrect;// 判断数据是否为脏数据
	private ArrayList<PlayerPerformanceOfOneMatchPo> listOfFirstTeamPlayerPerformance;// 第一支球队每个队员各项成绩
	private ArrayList<PlayerPerformanceOfOneMatchPo> listOfSecondTeamPlayerPerformance;// 第二支球每个球员各项成绩
	private TeamPerformanceOfOneMatchPo firstTeamPerformance;// 第一支球队总成绩
	private TeamPerformanceOfOneMatchPo secondTeamPerformance;// 第二支球队总成绩

	public OneMatch(String nameOfFile) {
		this.nameOfFile = nameOfFile;
		this.listOfFirstTeamPlayerPerformance = new ArrayList<PlayerPerformanceOfOneMatchPo>(15);
		this.listOfSecondTeamPlayerPerformance = new ArrayList<PlayerPerformanceOfOneMatchPo>(15);
		try {
			BufferedReader matchReader = new BufferedReader(new FileReader(PathOfFile.MATCH_INFO + nameOfFile));
			String temp;
			String mainInfo = matchReader.readLine();
			this.getMainInfoOfMatch(mainInfo);// 得到比赛的主要信息，包括得分,时间
			String firstTeam = matchReader.readLine().trim();
			this.firstTeam = firstTeam;// 初始化第一个队名
			for (int j = 0; j < NUMBER.NUMBER_OF_FIRST; j++) {
				temp = matchReader.readLine();
				listOfFirstTeamPlayerPerformance.add(this.getFirstTeamFirstPlayerPo(temp));
			}
			while ((temp = matchReader.readLine()).length() != 3) {
				listOfFirstTeamPlayerPerformance.add(this.getFirstTeamReplacePlayerPo(temp));
			}
			String secondTeam = temp.trim();
			this.secondTeam = secondTeam;// 初始化第二个队名
			for (int i = 0; i < NUMBER.NUMBER_OF_FIRST; i++) {
				temp = matchReader.readLine();
				listOfSecondTeamPlayerPerformance.add(this.getSecondTeamFirstPlayerPo(temp));
			}
			while ((temp = matchReader.readLine()) != null) {
				listOfSecondTeamPlayerPerformance.add(this.getSecondTeamReplacePlayerPo(temp));
			}
			matchReader.close();
			this.firstTeamPerformance = new TeamPerformanceOfOneMatchPo(this.firstTeam, this.secondTeam, this.date,
					this.season, this.listOfFirstTeamPlayerPerformance);
			this.secondTeamPerformance = new TeamPerformanceOfOneMatchPo(this.secondTeam, this.firstTeam, this.date,
					this.season, this.listOfSecondTeamPlayerPerformance);
			this.isDataCorrect = this.isDataCorrect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getMainInfoOfMatch(String formatString) {
		String[] part = formatString.split(";");
		String monthString = part[0].substring(0, 2);
		String dayString = part[0].substring(3);
		int month = this.toInt(monthString);
		int day = this.toInt(dayString);
		int year;
		String[] teams = part[1].split("-");
		this.firstTeam = teams[0];
		this.secondTeam = teams[1];
		String[] scores = part[2].split("-");
		this.firstTeamSocre = this.toInt(scores[0]);
		this.secondTeamScore = this.toInt(scores[1]);
		String formatSeason = this.nameOfFile.substring(0, 5);
		this.season = new Season(formatSeason);
		if (month >= NUMBER.START_MONTH_OF_SEASON) {
			year = this.season.getStartYear();
		} else {
			year = this.season.getFinishYear();
		}
		this.date = new Date(year, month, day);
	}// 根据第一行文本得到比赛主要信息

	private PlayerPerformanceOfOneMatchPo getFirstTeamFirstPlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = new PlayerPerformanceOfOneMatchPo();
		String part[] = temp.split(";");
		resultPo.setTeamName(firstTeam);
		resultPo.setDate(date);
		resultPo.setSeason(season);
		resultPo.setIsFirst(true);
		resultPo.setNameOfPlayer(part[0]);
		resultPo.setPlayingTime(Time.stringToDouble(part[2]));
		resultPo.setTotalHitNumber(this.toInt(part[3]));
		resultPo.setTotalShootNumber(this.toInt(part[4]));
		resultPo.setThreePointHitNumber(this.toInt(part[5]));
		resultPo.setThreePointShootNumber(this.toInt(part[6]));
		resultPo.setFreePointHitNumber(this.toInt(part[7]));
		resultPo.setFreePointShootNumber(this.toInt(part[8]));
		resultPo.setOffensiveReboundNumber(this.toInt(part[9]));
		resultPo.setDefensiveReboundNumber(this.toInt(part[10]));
		resultPo.setTotalReboundNumber(this.toInt(part[11]));
		resultPo.setAssistNumber(this.toInt(part[12]));
		resultPo.setStealNumber(this.toInt(part[13]));
		resultPo.setBlockNumber(this.toInt(part[14]));
		resultPo.setFoulNumber(this.toInt(part[15]));
		resultPo.setTurnoverNumber(this.toInt(part[16]));
		resultPo.setScoreNumber(this.toInt(part[17]));
		return resultPo;
	}// 第一队首发

	private PlayerPerformanceOfOneMatchPo getFirstTeamReplacePlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = this.getFirstTeamFirstPlayerPo(temp);
		resultPo.setIsFirst(false);
		return resultPo;
	}// 第一队替补

	private PlayerPerformanceOfOneMatchPo getSecondTeamFirstPlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = this.getFirstTeamFirstPlayerPo(temp);
		resultPo.setTeamName(secondTeam);
		return resultPo;
	}// 第二队首发

	private PlayerPerformanceOfOneMatchPo getSecondTeamReplacePlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = this.getFirstTeamFirstPlayerPo(temp);
		resultPo.setTeamName(secondTeam);
		resultPo.setIsFirst(false);
		return resultPo;
	}// 第二队替补

	private int toInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private boolean isDataCorrect() {
		// ///////////////////////////////////////////////////待编辑
		return true;
	}// 判断是否为脏数据

	public void writeDetailInfoOfPlayerAndTeamToDB() {
		System.out.println(this.nameOfFile);
		if (this.isDataCorrect) {
			PlayerPerformanceOfOneMatchPo playerPo;
			for (int i = 0; i < 1; i++) {
				playerPo = listOfFirstTeamPlayerPerformance.get(i);
				this.writeDetailInfoOfPlayerPerform(playerPo);
			}
			for (int i = 0; i < listOfSecondTeamPlayerPerformance.size(); i++) {
				playerPo = listOfSecondTeamPlayerPerformance.get(i);
				this.writeDetailInfoOfPlayerPerform(playerPo);
			}
			this.writeDetailInfoOfTeamPerform();
		}
	}// 初始化比赛信息数据库

	private void writeDetailInfoOfTeamPerform() {
		System.out.println("writeDetailInfoOfTeamPerform");
		if (dbOfTeam.isTableExist(firstTeam).equals(ResultMessage.EXIST)) {
			dbOfTeam.add(firstTeam, firstTeamPerformance.toDBString());
		} else if (dbOfTeam.isTableExist(firstTeam).equals(ResultMessage.NOT_EXIST)) {
			dbOfTeam.createTable(firstTeam);
			dbOfTeam.add(firstTeam, firstTeamPerformance.toDBString());
		}
		if (dbOfTeam.isTableExist(secondTeam).equals(ResultMessage.EXIST)) {
			dbOfTeam.add(secondTeam, secondTeamPerformance.toDBString());
		} else if (dbOfTeam.isTableExist(secondTeam).equals(ResultMessage.NOT_EXIST)) {
			dbOfTeam.createTable(secondTeam);
			dbOfTeam.add(secondTeam, secondTeamPerformance.toDBString());
		}
	}// 写入一个球队一场比赛的数据到数据库

	private void writeDetailInfoOfPlayerPerform(PlayerPerformanceOfOneMatchPo playerPo) {
		System.out.println("writeDetailInfoOfPlayerPerform");
		String nameOfPlayer = playerPo.getNameOfPlayer();
		if (dbOfPlayer.isTableExist(nameOfPlayer).equals(ResultMessage.EXIST)) {
			dbOfPlayer.add(nameOfPlayer, playerPo.toDBString());
		} else if (dbOfPlayer.isTableExist(playerPo.getNameOfPlayer()).equals(ResultMessage.NOT_EXIST)) {
			dbOfPlayer.createTable(nameOfPlayer);
			dbOfPlayer.add(nameOfPlayer, playerPo.toDBString());
		}
	}// 写入一个球员一场比赛的数据到数据库
}
