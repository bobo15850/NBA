package businesslogicservice.teams;

import vo.OneTeamPerformanceOfOneSeasonVo;
import businesslogic.teams.AllTeamPerformanceOfOneSeason;
import businesslogic.teams.OneTeamPerformanceOfAllSeason;

import common.enums.TeamName;
import common.mydatastructure.Season;
import common.mydatastructure.team.GeneralInfoOfTeam;

public interface TeamInfoBlService {
	// 获取某一个赛季所有球队的比赛信息
	public AllTeamPerformanceOfOneSeason getAllTeamPerformanceOfOneSeason(Season season);

	// 根据某一球队名称查找其所有赛季比赛信息
	public OneTeamPerformanceOfAllSeason getOneTeamInformationOfAllSeason(TeamName teamName);

	// 查找某一球队在某一赛季的比赛信息
	public OneTeamPerformanceOfOneSeasonVo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season);

	// 根据球员姓名查找某一球队具体基本自然信息
	public GeneralInfoOfTeam getBaseInformationOfOneTeam(TeamName teamName);
}
