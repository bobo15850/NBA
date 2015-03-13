package businesslogicservice.players;

import po.GeneralInfoOfPlayerPo;
import vo.AllPlayerPerformanceOfOneSeasonVo;
import vo.OnePlayerPerformanceOfAllSeasonVo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;

public interface PlayerInfoBlService {
	// 获取某一个赛季所有球员的比赛信息
	public AllPlayerPerformanceOfOneSeasonVo getAllPlayerPerformanceOfOneSeason(Season season);

	// 根据某一球员姓名查找其所有赛季比赛信息
	public OnePlayerPerformanceOfAllSeasonVo getOnePlayerInformationOfAllSeason(String nameOfPlayer);

	// 查找某一球员在某一赛季的比赛信息
	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season);

	// 根据球员姓名查找某一球员具体基本自然信息
	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer);

	// 根据某一项将所有球员某一赛季成绩升序排序
	public void ascendingSort(AllPlayerPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind);

	// 根据某一项将所有球员某一赛季成绩降序排序
	public void descendingSort(AllPlayerPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind);
}
