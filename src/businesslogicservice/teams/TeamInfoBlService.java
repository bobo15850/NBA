package businesslogicservice.teams;

import java.util.ArrayList;

import vo.GeneralInfoOfTeamVo;
import vo.OneTeamPerformOfOneSeasonVo;

import common.enums.PerformanceOfTeam;
import common.mydatastructure.Season;

public interface TeamInfoBlService {
	// 获取某一个赛季所有球队的比赛信息
	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneSeasonPerformOfAllTeam(Season season);

	// 根据某一球队名称查找其所有赛季比赛信息
	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneTeamPerformOfAllSeason(String teamName);

	// 查找某一球队在某一赛季的比赛信息
	public OneTeamPerformOfOneSeasonVo getOneTeamPerformOfOneSeason(String teamName, Season season);

	// 根据球队姓名查找某一球队具体基本自然信息
	public GeneralInfoOfTeamVo getGeneralInfoOfOneTeam(String teamName);

	// 根据某一项将所有球队某一赛季成绩升序排序
	public void ascendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfTeam dataKind);

	// 根据某一项将所有球队某一赛季成绩降序排序
	public void descendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfTeam dataKind);
}
