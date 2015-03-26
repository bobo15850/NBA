package businesslogic_driver;

import java.util.ArrayList;

import common.enums.PerformanceOfTeam;
import common.mydatastructure.Season;
import vo.GeneralInfoOfTeamVo;
import vo.OneTeamPerformOfOneSeasonVo;
import businesslogic.teams.TeamInfoBl;
import businesslogicservice.teams.TeamInfoBlService;

public class TeamBl_Driver {
	TeamInfoBlService teamInfoBl = new TeamInfoBl();

	public void testGetOneTeamPerformOfOneSeason() {
		String teamName = "CLE";
		Season season = new Season("2013-2014");
		OneTeamPerformOfOneSeasonVo vo = this.teamInfoBl.getOneTeamPerformOfOneSeason(teamName, season);
		String[] content = vo.toStringArray();
		for (int i = 0; i < content.length; i++) {
			System.out.print(content[i]);
			System.out.print(";   ");
		}
	}

	public void testGetOneSeasonPerformOfAllTeam() {
		Season season = new Season("2013-2014");
		ArrayList<OneTeamPerformOfOneSeasonVo> voList = this.teamInfoBl.getOneSeasonPerformOfAllTeam(season);
		for (int i = 0; i < voList.size(); i++) {
			String[] content = voList.get(i).toStringArray();
			for (int j = 0; j < content.length; j++) {
				System.out.print(content[j]);
				System.out.print(";   ");
			}
			System.out.println();
			System.out.println(i);
		}
	}

	public void testGetGeneralInfoOfOneTeam() {
		String teamName = "CLE";
		GeneralInfoOfTeamVo vo = this.teamInfoBl.getGeneralInfoOfOneTeam(teamName);
		String[] content = vo.toStringArray();
		for (int i = 0; i < content.length; i++) {
			System.out.print(content[i]);
			System.out.print(";   ");
		}
	}

	public void testAscendingSort() {
		Season season = new Season("2013-2014");
		ArrayList<OneTeamPerformOfOneSeasonVo> voList = this.teamInfoBl.getOneSeasonPerformOfAllTeam(season);
		this.teamInfoBl.ascendingSort(voList, PerformanceOfTeam.winRate);
		for (int i = 0; i < voList.size(); i++) {
			String[] content = voList.get(i).toStringArray();
			for (int j = 0; j < content.length; j++) {
				System.out.print(content[j]);
				System.out.print(";   ");
			}
			System.out.println();
			System.out.println(i);
		}
	}

	public void testDescendingSort() {
		Season season = new Season("2013-2014");
		ArrayList<OneTeamPerformOfOneSeasonVo> voList = this.teamInfoBl.getOneSeasonPerformOfAllTeam(season);
		this.teamInfoBl.descendingSort(voList, PerformanceOfTeam.scoreNumber);
		for (int i = 0; i < voList.size(); i++) {
			String[] content = voList.get(i).toStringArray();
			for (int j = 0; j < content.length; j++) {
				System.out.print(content[j]);
				System.out.print(";   ");
			}
			System.out.println();
			System.out.println(i);
		}
	}

	public static void main(String arg[]) {
		new TeamBl_Driver().testDescendingSort();;
	}
}
