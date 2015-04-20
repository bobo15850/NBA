package common.mydatastructure;

public class GeneralInfoOfTeam {
	private String teamNameForShort;// 队名缩写
	private String teamName;// 球队名称
	private String location;// 球队所在地
	private String conference;// 赛区
	private String division;// 分区
	private String homeField;// 球队主场
	private int establishYear;// 建立时间

	public String getTeamNameForShort() {
		return teamNameForShort;
	}

	public void setTeamNameForShort(String teamNameForShort) {
		this.teamNameForShort = teamNameForShort;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getHomeField() {
		return homeField;
	}

	public void setHomeField(String homeField) {
		this.homeField = homeField;
	}

	public int getEstablishYear() {
		return establishYear;
	}

	public void setEstablishYear(int establishYear) {
		this.establishYear = establishYear;
	}
}
