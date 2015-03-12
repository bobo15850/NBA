package common.mydatastructure.team;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;

import common.enums.Conference;
import common.enums.Division;
import common.enums.TeamName;
import common.statics.PathOfFile;

/*
 * 该类定义球队的自然信息
 */
public class BaseInformationOfTeam {
	private TeamName teamName;
	private ImageIcon teamIcon;
	private String location;
	private Conference conference;
	private Division division;
	private String homeField;
	private int establishYear;

	public BaseInformationOfTeam(TeamName teamName) {
		this.teamName = teamName;
		this.teamIcon = new ImageIcon(PathOfFile.TEAM_IMAGE + teamName + ".svg");
		this.init();
	}

	// //////////////////////////////////////////////////////该方法待编辑
	// TODO
	private void init() {
		try {
			BufferedReader bufferedreader = new BufferedReader(new FileReader(PathOfFile.TEAM_IMAGE + teamName));
			String temp;
			while ((temp = bufferedreader.readLine()) != null) {
				System.out.println(temp);
			}
			bufferedreader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// //////////////////////////////////////////////////////////////////

	public TeamName getTeamName() {
		return this.teamName;
	}// 得到队名

	public ImageIcon getTeamIcon() {
		return teamIcon;
	}// 得到球队图标

	public String getLocation() {
		return this.location;
	}// 得到球队地址

	public Conference getConference() {
		return this.conference;
	}// 得到球队所属联盟

	public Division getDivision() {
		return this.division;
	}// 得到球队所属赛区

	public String getHomeField() {
		return this.homeField;
	}// 得到球队主场

	public int getEstablishYear() {
		return this.establishYear;
	}// 得到建立时间
}
