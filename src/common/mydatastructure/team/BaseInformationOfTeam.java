package common.mydatastructure.team;

import common.enums.Conference;
import common.enums.Division;
import common.enums.TeamName;

/*
 * 该类定义球队的自然信息
 */
public class BaseInformationOfTeam {
	private TeamName name;
	private String location;
	private Conference conference;
	private Division division;
	private String homeField;
	private int establishYear;

	public BaseInformationOfTeam() {

	}

	public TeamName getTeamName() {
		return this.name;
	}

	public String getLocation() {
		return this.location;
	}

	public Conference getConference() {
		return this.conference;
	}

	public Division getDivision() {
		return this.division;
	}

	public String getHomeField() {
		return this.homeField;
	}

	public int getEstablishYear() {
		return this.establishYear;
	}
}
