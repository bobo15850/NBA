package businesslogic.teams;

import java.util.ArrayList;

import po.GeneralInfoOfTeamPo;
import vo.GeneralInfoOfTeamVo;
import vo.OneTeamPerformOfOneSeasonVo;
import businesslogicservice.teams.TeamInfoBlService;
import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;
import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoBl implements TeamInfoBlService {
	private TeamInfoDataService teamInfoData;

	public TeamInfoBl() {
		teamInfoData = new TeamInfoData();
	}

	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneSeasonPerformOfAllTeam(Season season) {
		ArrayList<OneTeamPerformOfOneSeasonVo> resultVo = new ArrayList<OneTeamPerformOfOneSeasonVo>(32);
		ArrayList<String> nameOfAllTeam = this.teamInfoData.getNamesOfAllTeam();
		OneTeamPerformOfOneSeasonVo tempOfOneTeamVo;
		String tempName;
		for (int i = 0; i < nameOfAllTeam.size(); i++) {
			tempName = nameOfAllTeam.get(i);
			tempOfOneTeamVo = this.getOneTeamPerformOfOneSeason(tempName, season);
			resultVo.add(tempOfOneTeamVo);
		}
		return resultVo;
	}// 获取某一个赛季所有球队的比赛信息

	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneTeamPerformOfAllSeason(String teamName) {
		return null;
	}// 根据某一球队名称查找其所有赛季比赛信息

	public OneTeamPerformOfOneSeasonVo getOneTeamPerformOfOneSeason(String teamName, Season season) {
		return null;
	}// 查找某一球队在某一赛季的比赛信息

	public GeneralInfoOfTeamVo getBaseInformationOfOneTeam(String teamName) {
		GeneralInfoOfTeamPo po = this.teamInfoData.getBaseInformationOfOneTeam(teamName);
		GeneralInfoOfTeamVo vo = new GeneralInfoOfTeamVo(po);
		return vo;
	}// 根据球员姓名查找某一球队具体基本自然信息

	public void ascendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {

	}// 根据某一项将所有球队某一赛季成绩升序排序

	public void descendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {

	}// 根据某一项将所有球队某一赛季成绩降序排序
}
