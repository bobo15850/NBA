package businesslogicservice.teams;

import po.GeneralInfoOfTeamPo;
import vo.AllTeamPerformanceOfOneSeasonVo;
import vo.OneTeamPerformanceOfAllSeasonVo;
import vo.OneTeamPerformanceOfOneSeasonVo;
import common.enums.PerformanceOfPlayer;
import common.enums.TeamName;
import common.mydatastructure.Season;

public interface TeamInfoBlService {
	// 获取某一个赛季所有球队的比赛信息
	public AllTeamPerformanceOfOneSeasonVo getAllTeamPerformanceOfOneSeason(Season season);

	// 根据某一球队名称查找其所有赛季比赛信息
	public OneTeamPerformanceOfAllSeasonVo getOneTeamInformationOfAllSeason(TeamName teamName);

	// 查找某一球队在某一赛季的比赛信息
	public OneTeamPerformanceOfOneSeasonVo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season);

	// 根据球员姓名查找某一球队具体基本自然信息
	public GeneralInfoOfTeamPo getBaseInformationOfOneTeam(TeamName teamName);

	// 根据某一项将所有球队某一赛季成绩升序排序
	public void ascendingSort(AllTeamPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind);

	// 根据某一项将所有球队某一赛季成绩降序排序
	public void descendingSort(AllTeamPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind);
}
