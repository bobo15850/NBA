package businesslogicservice.players;

import vo.AllPlayerPerformanceOfOneSeasonVo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import businesslogic.players.OnePlayerPerformanceOfAllSeason;
import common.enums.PerformanceOfTeam;
import common.mydatastructure.Season;
import common.mydatastructure.player.GeneralInfoOfPlayer;

public interface PlayerInfoBlService {
	// 获取某一个赛季所有球员的比赛信息
	public AllPlayerPerformanceOfOneSeasonVo getAllPlayerPerformanceOfOneSeason(Season season);

	// 根据某一球员姓名查找其所有赛季比赛信息
	public OnePlayerPerformanceOfAllSeason getOnePlayerInformationOfAllSeason(String nameOfPlayer);

	// 查找某一球员在某一赛季的比赛信息
	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season);

	// 根据球员姓名查找某一球员具体基本自然信息
	public GeneralInfoOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer);

}
