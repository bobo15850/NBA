package businesslogicservice.teams;

import businesslogic.teams.AllTeamPerformanceOfOneSeason;
import businesslogic.teams.OneTeamPerformanceOfAllSeason;
import vo.OneTeamPerformanceOfOneSeasonVo;
import common.enums.KindOfTeamData;
import common.enums.TeamName;
import common.mydatastructure.Season;
import common.mydatastructure.team.BaseInformationOfTeam;
import common.statics.ResultMessage;

public interface TeamInformationManagementBlService {
	// 获取某一个赛季所有球队的比赛信息
	public AllTeamPerformanceOfOneSeason getAllTeamPerformanceOfOneSeason(Season season);

	// 根据某一球队名称查找其所有赛季比赛信息
	public OneTeamPerformanceOfAllSeason getOneTeamInformationOfAllSeason(TeamName teamName);

	// 查找某一球队在某一赛季的比赛信息
	public OneTeamPerformanceOfOneSeasonVo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season);

	// 根据某一项将所有球队某一赛季成绩升序排序
	public ResultMessage ascendingSort(AllTeamPerformanceOfOneSeason data, KindOfTeamData dataKind);

	// 根据某一项将所有球队某一赛季成绩降序排序
	public ResultMessage descendingSort(AllTeamPerformanceOfOneSeason data, KindOfTeamData dataKind);

	// 根据球员姓名查找某一球队具体基本自然信息
	public BaseInformationOfTeam getBaseInformationOfOneTeam(TeamName teamName);

}
