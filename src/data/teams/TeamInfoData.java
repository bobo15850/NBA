package data.teams;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import po.GeneralInfoOfTeamPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.Season;
import common.statics.PathOfFile;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoData implements TeamInfoDataService {

	public ArrayList<TeamPerformanceOfOneMatchPo> getOneTeamPerformOfOneSeason(String teamName, Season season) {
		ArrayList<TeamPerformanceOfOneMatchPo> poList = new ArrayList<TeamPerformanceOfOneMatchPo>(128);
		return poList;
	}

	public GeneralInfoOfTeamPo getBaseInformationOfOneTeam(String teamName) {
		GeneralInfoOfTeamPo generalInfoOfTeam = new GeneralInfoOfTeamPo();
		generalInfoOfTeam.setTeamIcon(new ImageIcon(PathOfFile.TEAM_IMAGE + teamName + ".svg"));
		return generalInfoOfTeam;
	}

	public ArrayList<String> getNamesOfAllTeam() {
		return null;
	}

}
