package dataservice.players;

import po.GeneralInfoOfPlayerPo;
import po.NamesOfAllPlayerPo;
import po.OnePlayerPerformanceOfOneSeasonPo;
import common.mydatastructure.Season;

public interface PlayerInfoDataService {
	// 查找某一球员在某一赛季的比赛信息
	public OnePlayerPerformanceOfOneSeasonPo getOnePlayerPerformanceOfOneSeasonPo(String nameOfPlayer, Season season);

	// 查找出所有的球员姓名
	public NamesOfAllPlayerPo getNamesOfAllPlayer();

	// 根据球员姓名查找某一球员具体基本自然信息
	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer);
	
}
