package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;

import common.mydatastructure.Date;
import common.statics.PathOfFile;
import common.statics.StringToEnum;

public class OneMatch {
	private String firstTeam;
	private String secondTeam;
	private Date date;
	private int firstTeamSocre;
	private int secondTeamScore;
	private boolean isDataCorrect;
	private ArrayList<PlayerPerformanceOfOneMatchPo> listOfFirstTeamPlayerPerformance;
	private ArrayList<PlayerPerformanceOfOneMatchPo> listOfSecondTeamPlayerPerformance;
	private TeamPerformanceOfOneMatchPo firstTeamPerformance;
	private TeamPerformanceOfOneMatchPo secondTeamPerformance;

	public OneMatch(String pathOfFile) {
		listOfFirstTeamPlayerPerformance = new ArrayList<PlayerPerformanceOfOneMatchPo>(15);
		listOfSecondTeamPlayerPerformance = new ArrayList<PlayerPerformanceOfOneMatchPo>(15);
		try {
			BufferedReader matchReader = new BufferedReader(new FileReader(PathOfFile.MATCH_INFO + pathOfFile));
			String temp;
			String mainInfo = matchReader.readLine();
			this.getMainInfoOfMatch(mainInfo);// 得到比赛的主要信息，包括得分时间
			String scoresOfEachPart = matchReader.readLine();// 得到每节比分
			String firstTeam = matchReader.readLine().trim();
			this.firstTeam = firstTeam;// 初始化第一个队名
			for (int j = 0; j < 6; j++) {
				temp = matchReader.readLine();
				listOfFirstTeamPlayerPerformance.add(new PlayerPerformanceOfOneMatchPo(temp));
			}
			while ((temp = matchReader.readLine()).length() != 3) {
				listOfFirstTeamPlayerPerformance.add(new PlayerPerformanceOfOneMatchPo(temp));
			}
			String secondTeam = temp.trim();
			this.secondTeam = secondTeam;// 初始化第二个队名
			while ((temp = matchReader.readLine()) != null) {
				listOfSecondTeamPlayerPerformance.add(new PlayerPerformanceOfOneMatchPo(temp));
			}
			matchReader.close();
			this.firstTeamPerformance = new TeamPerformanceOfOneMatchPo(this.firstTeam, this.secondTeam, this.date, this.listOfFirstTeamPlayerPerformance);
			this.secondTeamPerformance = new TeamPerformanceOfOneMatchPo(this.secondTeam, this.firstTeam, this.date, this.listOfSecondTeamPlayerPerformance);
			this.isDataCorrect = this.isDataCorrect();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getMainInfoOfMatch(String formatString) {

	}// 根据第一行文本得到比赛主要信息

	private boolean isDataCorrect() {
		return false;
	}// 判断是否为脏数据

	private void writeOneMatchOfOnePlayer(String detailInfo) {
		String[] eachInfoOfOneMatch;
		eachInfoOfOneMatch = detailInfo.split(";");
		String nameOfPlayer = eachInfoOfOneMatch[0];
		try {
			BufferedWriter matchWriter = new BufferedWriter(new FileWriter(PathOfFile.PLAYER_INFO + nameOfPlayer, true));
			matchWriter.write(detailInfo + "\n");
			matchWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 将球员比赛数据写到球员信息文件中

	public void writeDetailInfoOfPlayerAndTeamToTxt() {
		if (isDataCorrect) {
			for (int i = 0; i < listOfFirstTeamPlayerPerformance.size(); i++) {
				this.writeOneMatchOfOnePlayer(listOfFirstTeamPlayerPerformance.get(i).getFormatData());
			}
			for (int i = 0; i < listOfSecondTeamPlayerPerformance.size(); i++) {
				this.writeOneMatchOfOnePlayer(listOfSecondTeamPlayerPerformance.get(i).getFormatData());
			}
			try {
				BufferedWriter firstTeamPerformanceWriter = new BufferedWriter(new FileWriter(PathOfFile.TEAM_INFO + firstTeam.toString(), true));
				firstTeamPerformanceWriter.write(this.firstTeamPerformance.getFormatString());
				firstTeamPerformanceWriter.close();
				BufferedWriter secondTeamPerformanceWriter = new BufferedWriter(new FileWriter(PathOfFile.TEAM_INFO + secondTeam.toString(), true));
				secondTeamPerformanceWriter.write(this.secondTeamPerformance.getFormatString());
				secondTeamPerformanceWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 先判断该比赛信息是否为脏数据，若不为脏数据则处理后写入对应文本文件
	}

	public void writeDetailInfoOfPlayerAndTeamToDB() {

	}// 写入数据库
}
