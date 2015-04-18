package databaseutility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.MyDate;
import common.mydatastructure.MyTime;
import common.statics.NUMBER;
import common.statics.PathOfFile;

class OneMatch {
	protected String nameOfFile;
	protected String firstTeam;// 第一支球队
	protected String secondTeam;// 第二支球队
	protected MyDate date;// 比赛时间
	protected int firstTeamSocre;// 第一支球队得分
	protected int secondTeamScore;// 第二支球队得分
	protected boolean isDataCorrect;// 判断数据是否为脏数据
	protected ArrayList<PlayerPerformanceOfOneMatchPo> listOfFirstTeamPlayerPerformance;// 第一支球队每个队员各项成绩
	protected ArrayList<PlayerPerformanceOfOneMatchPo> listOfSecondTeamPlayerPerformance;// 第二支球每个球员各项成绩
	protected TeamPerformanceOfOneMatchPo firstTeamPerformance;// 第一支球队总成绩
	protected TeamPerformanceOfOneMatchPo secondTeamPerformance;// 第二支球队总成绩

	public OneMatch(String nameOfFile) {
		this.nameOfFile = nameOfFile;
		this.listOfFirstTeamPlayerPerformance = new ArrayList<PlayerPerformanceOfOneMatchPo>(15);
		this.listOfSecondTeamPlayerPerformance = new ArrayList<PlayerPerformanceOfOneMatchPo>(15);
		try {
			BufferedReader matchReader = new BufferedReader(new FileReader(PathOfFile.MATCH_INFO + nameOfFile));
			String temp;
			String mainInfo = matchReader.readLine();
			matchReader.readLine();
			this.getMainInfoOfMatch(mainInfo);// 得到比赛的主要信息，包括得分,时间
			this.firstTeam = matchReader.readLine().trim();// 初始化第一个队名

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
			this.firstTeamPerformance = new TeamPerformanceOfOneMatchPo(this.firstTeam, this.secondTeam, this.date, isFirstWin(),
					this.listOfFirstTeamPlayerPerformance);
			this.secondTeamPerformance = new TeamPerformanceOfOneMatchPo(this.secondTeam, this.firstTeam, this.date, 1 - isFirstWin(),
					this.listOfSecondTeamPlayerPerformance);
			this.isDataCorrect = this.isDataCorrect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int isFirstWin() {
		if (this.firstTeamSocre > this.secondTeamScore) {
			return 1;
		}
		else {
			return 0;
		}
	}

	private void getMainInfoOfMatch(String formatString) {
		String[] part = formatString.split(";");
		String monthString = part[0].substring(0, 2);
		String dayString = part[0].substring(3);
		int month = this.toInt(monthString);
		int day = this.toInt(dayString);
		int year;
		String[] scores = part[2].split("-");
		this.firstTeamSocre = this.toInt(scores[0]);
		this.secondTeamScore = this.toInt(scores[1]);
		String startYear = nameOfFile.substring(0, 2);
		String finishYear = nameOfFile.substring(3, 5);
		if (month >= NUMBER.START_MONTH_OF_SEASON) {
			year = toInt(startYear);
		}
		else {
			year = toInt(finishYear);
		}
		this.date = new MyDate(year, month, day);
	}// 根据第一行文本得到比赛主要信息

	private PlayerPerformanceOfOneMatchPo getFirstTeamFirstPlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = new PlayerPerformanceOfOneMatchPo();
		String part[] = temp.split(";");
		resultPo.setTeamNameForShort(firstTeam);
		resultPo.setDate(date);
		resultPo.setStart(1);
		resultPo.setNameOfPlayer(part[0]);
		resultPo.setPlayingTime(new MyTime(part[2]));
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
		resultPo.setFaultNumber(this.toInt(part[15]));
		resultPo.setFoulNumber(this.toInt(part[16]));
		resultPo.setScoreNumber(this.toInt(part[17]));
		return resultPo;
	}// 第一队首发

	private PlayerPerformanceOfOneMatchPo getFirstTeamReplacePlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = this.getFirstTeamFirstPlayerPo(temp);
		resultPo.setStart(0);
		return resultPo;
	}// 第一队替补

	private PlayerPerformanceOfOneMatchPo getSecondTeamFirstPlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = this.getFirstTeamFirstPlayerPo(temp);
		resultPo.setTeamNameForShort(secondTeam);
		return resultPo;
	}// 第二队首发

	private PlayerPerformanceOfOneMatchPo getSecondTeamReplacePlayerPo(String temp) {
		PlayerPerformanceOfOneMatchPo resultPo = this.getFirstTeamFirstPlayerPo(temp);
		resultPo.setTeamNameForShort(secondTeam);
		resultPo.setStart(0);
		return resultPo;
	}// 第二队替补

	private int toInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	protected boolean isDataCorrect() {
		// DataCorrection.correctTotalPlayingTime(firstTeamPerformance);
		// DataCorrection.correctTotalPlayingTime(secondTeamPerformance);
		// DataCorrection.correctPlayerScoreNumber(listOfFirstTeamPlayerPerformance,
		// firstTeamSocre);
		// DataCorrection.correctPlayerScoreNumber(listOfSecondTeamPlayerPerformance,
		// secondTeamScore);
		return true;
	}// 判断是否为脏数据s
}