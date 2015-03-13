package dataservice.players;

import po.OnePlayerPerformanceOfOneSeasonPo;
import common.mydatastructure.Season;
import common.mydatastructure.player.GeneralInfoOfPlayer;
import common.mydatastructure.player.NamesOfAllPlayer;

public interface PlayerInfoDataService {
	// 查找某一球员在某一赛季的比赛信息
	public OnePlayerPerformanceOfOneSeasonPo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season);

	// 查找出所有的球员姓名
	public NamesOfAllPlayer getNamesOfAllPlayer();

	// 根据球员姓名查找某一球员具体基本自然信息
	public GeneralInfoOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer);
	
	
	
}
