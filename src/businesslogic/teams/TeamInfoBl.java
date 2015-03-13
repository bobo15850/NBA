package businesslogic.teams;

import java.util.ArrayList;

import po.GeneralInfoOfTeamPo;
import po.OneTeamPerformanceOfOneSeasonPo;
import vo.AllTeamPerformanceOfOneSeasonVo;
import vo.OneTeamPerformanceOfAllSeasonVo;
import vo.OneTeamPerformanceOfOneSeasonVo;
import businesslogicservice.teams.TeamInfoBlService;
import common.enums.PerformanceOfPlayer;
import common.enums.TeamName;
import common.mydatastructure.Season;
import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoBl implements TeamInfoBlService {
	TeamInfoDataService teamInformationManagementData;

	public TeamInfoBl() {
		teamInformationManagementData = new TeamInfoData();
	}

	public AllTeamPerformanceOfOneSeasonVo getAllTeamPerformanceOfOneSeason(Season season) {
		ArrayList<OneTeamPerformanceOfOneSeasonVo> listOfOneTeamPerformanceOfOneSeason = new ArrayList<OneTeamPerformanceOfOneSeasonVo>();
		TeamName[] namesOfAllTeam = TeamName.values();
		for (int i = 0; i < namesOfAllTeam.length; i++) {
			listOfOneTeamPerformanceOfOneSeason.add(new OneTeamPerformanceOfOneSeasonVo(teamInformationManagementData.getOneTeamPerformanceOfOneSeason(namesOfAllTeam[i], season)));
		}
		return new AllTeamPerformanceOfOneSeasonVo(season, listOfOneTeamPerformanceOfOneSeason);
	}// 获取某一个赛季所有球队的比赛信息

	public OneTeamPerformanceOfAllSeasonVo getOneTeamInformationOfAllSeason(TeamName teamName) {
		return new OneTeamPerformanceOfAllSeasonVo(teamName);
	}// 根据某一球队名称查找其所有赛季比赛信息

	public OneTeamPerformanceOfOneSeasonVo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season) {
		OneTeamPerformanceOfOneSeasonPo po = this.teamInformationManagementData.getOneTeamPerformanceOfOneSeason(teamName, season);
		return new OneTeamPerformanceOfOneSeasonVo(po);
	}// 查找某一球队在某一赛季的比赛信息

	public GeneralInfoOfTeamPo getBaseInformationOfOneTeam(TeamName teamName) {
		return this.teamInformationManagementData.getBaseInformationOfOneTeam(teamName);
	}// 根据球员姓名查找某一球队具体基本自然信息

	public void ascendingSort(AllTeamPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind) {
		vo.ascendingSort(dataKind);
	}// 根据某一项将所有球队某一赛季成绩升序排序

	public void descendingSort(AllTeamPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind) {
		vo.descendingSort(dataKind);
	}// 根据某一项将所有球队某一赛季成绩降序排序

}
