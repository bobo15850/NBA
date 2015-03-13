package businesslogic.teams;

import java.util.ArrayList;

import po.OneTeamPerformanceOfOneSeasonPo;
import vo.OneTeamPerformanceOfOneSeasonVo;
import businesslogicservice.teams.TeamInfoBlService;
import common.enums.TeamName;
import common.mydatastructure.Season;
import common.mydatastructure.team.GeneralInfoOfTeam;
import data.teams.TeamInformationManagementData;
import dataservice.teams.TeamInformationManagementDataService;

public class TeamInfoBl implements TeamInfoBlService {
	TeamInformationManagementDataService teamInformationManagementData;

	public TeamInfoBl() {
		teamInformationManagementData = new TeamInformationManagementData();
	}

	public AllTeamPerformanceOfOneSeason getAllTeamPerformanceOfOneSeason(Season season) {
		ArrayList<OneTeamPerformanceOfOneSeasonVo> listOfOneTeamPerformanceOfOneSeason = new ArrayList<OneTeamPerformanceOfOneSeasonVo>();
		TeamName[] namesOfAllTeam = TeamName.values();
		for (int i = 0; i < namesOfAllTeam.length; i++) {
			listOfOneTeamPerformanceOfOneSeason.add(new OneTeamPerformanceOfOneSeasonVo(teamInformationManagementData.getOneTeamPerformanceOfOneSeason(namesOfAllTeam[i], season)));
		}
		return new AllTeamPerformanceOfOneSeason(season, listOfOneTeamPerformanceOfOneSeason);
	}// 获取某一个赛季所有球队的比赛信息

	public OneTeamPerformanceOfAllSeason getOneTeamInformationOfAllSeason(TeamName teamName) {
		return new OneTeamPerformanceOfAllSeason(teamName);
	}// 根据某一球队名称查找其所有赛季比赛信息

	public OneTeamPerformanceOfOneSeasonVo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season) {
		OneTeamPerformanceOfOneSeasonPo po = this.teamInformationManagementData.getOneTeamPerformanceOfOneSeason(teamName, season);
		return new OneTeamPerformanceOfOneSeasonVo(po);
	}// 查找某一球队在某一赛季的比赛信息

	public GeneralInfoOfTeam getBaseInformationOfOneTeam(TeamName teamName) {
		return this.teamInformationManagementData.getBaseInformationOfOneTeam(teamName);
	}// 根据球员姓名查找某一球队具体基本自然信息

}
