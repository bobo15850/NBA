package vo;

import po.GeneralInfoOfTeamPo;

import common.enums.Conference;
import common.enums.Division;

public class GeneralInfoOfTeamVo {

	private String teamName = null;// 球队名称
	private String teamNameForShort = null;// 队名缩写
	private String location = null;// 球队所在地
	private Conference conference = null;// 赛区
	private Division division = null;// 分区
	private String homeField = null;// 球队主场
	private int establishYear = 0;// 建立时间

	public GeneralInfoOfTeamVo() {
		// 无参构造函数
	}

	public GeneralInfoOfTeamVo(GeneralInfoOfTeamPo po) {
		this.teamName = po.getTeamName();
		this.teamNameForShort = po.getTeamNameForShort();
		this.location = po.getLocation();
		this.conference = po.getConference();
		this.division = po.getDivision();
		this.homeField = po.getHomeField();
		this.establishYear = po.getEstablishYear();
	}

	public void setTeamName(String TeamName) {
		this.teamName = TeamName;
	}// 设置队名

	public void setTeamNameForShort(String teamNameForShort) {
		this.teamNameForShort = teamNameForShort;
	}// 设置队名缩写

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

	public String getTeamNameForShort() {
		return teamNameForShort;
	}// 得到队名缩写

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

	public String[] toStringArray() {
		return new String[] { teamNameForShort, teamName, location, conference.toString(), division.toString(), homeField,
				String.valueOf(establishYear) };
	}
}
