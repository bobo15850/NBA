package po;

import javax.swing.ImageIcon;

import common.enums.Conference;
import common.enums.Division;
import common.statics.PathOfFile;

/*
 * 该类定义球队的自然信息
 */
public class GeneralInfoOfTeamPo {
	private String teamName;// 球队名称
	private ImageIcon teamIcon;//
	private String location;
	private Conference conference;
	private Division division;
	private String homeField;
	private int establishYear;

	public GeneralInfoOfTeamPo(String teamName) {
		this.teamName = teamName;
		this.teamIcon = new ImageIcon(PathOfFile.TEAM_IMAGE + teamName + ".svg");
	}

	public void setTeamName(String TeamName) {
		this.teamName = TeamName;
	}// 设置队名

	public void setTeamIcon(ImageIcon teamIcon) {
		this.teamIcon = teamIcon;
	}// 设置球队图标

	public void setLocation(String location) {
		this.location = location;
	}// 设置球队地址

	public void setConference(Conference conference) {
		this.conference = conference;
	}// 设置球队所属联盟

	public void setDivision(Division division) {
		this.division = division;
	}// 设置球队所属赛区

	public void setHomeField(String homeField) {
		this.homeField = homeField;
	}// 设置球队主场

	public void setEstablishYear(int establishYear) {
		this.establishYear = establishYear;
	}// 设置建立时间

	public String getTeamName() {
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
