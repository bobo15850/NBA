package dataservice.players;

import po.OnePlayerPerformanceOfOneSeasonPo;
import common.mydatastructure.Season;
import common.mydatastructure.player.baseinformation.BaseInformationOfPlayer;

public interface PlayerInfomationManagementDataService {
	// 查找某一球员在某一赛季的比赛信息
	public OnePlayerPerformanceOfOneSeasonPo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season);

	// 根据球员姓名查找某一球员具体基本自然信息
	public BaseInformationOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer);
}
