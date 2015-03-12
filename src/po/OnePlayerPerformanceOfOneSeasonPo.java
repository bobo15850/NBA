package po;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import common.mydatastructure.Season;
import common.mydatastructure.player.matchinformation.PlayerPerformanceOfOneMatch;
import common.statics.PathOfFile;
import common.statics.numbers.NUMBER;

public class OnePlayerPerformanceOfOneSeasonPo {
	private String nameOfPlayer;// 球员姓名
	private Season season;// 赛季信息
	private ArrayList<PlayerPerformanceOfOneMatch> listOfPerformanceOfOneMatch;// 每场比赛信息的链表

	public OnePlayerPerformanceOfOneSeasonPo(String nameOfPlayer, Season season) {
		this.nameOfPlayer = nameOfPlayer;
		this.season = season;
		this.listOfPerformanceOfOneMatch = new ArrayList<PlayerPerformanceOfOneMatch>(128);
		this.init();
	}

	private void init() {
		try {
			BufferedReader playerReader = new BufferedReader(new FileReader(PathOfFile.PLAYER_INFO + this.nameOfPlayer));
			String temp;
			for (int i = 0; i < NUMBER.LINE_OF_PLAYER_BASE_INFO; i++) {
				temp = playerReader.readLine();
			}
			while ((temp = playerReader.readLine()) != null) {
				PlayerPerformanceOfOneMatch oneMatch = new PlayerPerformanceOfOneMatch(temp);
				this.listOfPerformanceOfOneMatch.add(oneMatch);
			}
			playerReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getNameOfPlay() {
		return nameOfPlayer;
	}

	public Season getSeason() {
		return this.season;
	}

	public ArrayList<PlayerPerformanceOfOneMatch> getListOfPerformanceOfOneMatch() {
		return this.listOfPerformanceOfOneMatch;
	}
}
