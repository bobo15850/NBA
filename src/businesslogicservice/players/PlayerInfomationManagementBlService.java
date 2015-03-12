package businesslogicservice.players;

import vo.OnePlayerPerformanceOfOneSeasonVo;
import common.ResultMessage;
import common.enums.KindOfPlayerData;
import common.mydatastructure.Season;
import common.mydatastructure.player.baseinformation.BaseInformationOfPlayer;
import common.mydatastructure.player.matchinformation.AllPlayerPerformanceOfOneSeason;
import common.mydatastructure.player.matchinformation.OnePlayerPerformanceOfAllSeason;

public interface PlayerInfomationManagementBlService {
	// 获取某一个赛季所有球员的比赛信息
	public AllPlayerPerformanceOfOneSeason getAllPlayerPerformanceOfOneSeason(Season season);

	// 根据某一球员具体信息查找其所有赛季比赛信息
	public OnePlayerPerformanceOfAllSeason getOnePlayerInformationOfAllSeason(String nameOfPlayer);

	// 查找某一球员在某一赛季的比赛信息
	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season);

	// 根据某一项将所有球员某一赛季成绩升序排序
	public ResultMessage ascendingSort(AllPlayerPerformanceOfOneSeason data, KindOfPlayerData dataKind);

	// 根据某一项将所有球员某一赛季成绩降序排序
	public ResultMessage descendingSort(AllPlayerPerformanceOfOneSeason data, KindOfPlayerData dataKind);

	// 根据球员姓名查找某一球员具体基本自然信息
	public BaseInformationOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer);
}