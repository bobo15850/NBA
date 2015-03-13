package data.players;

import po.GeneralInfoOfPlayerPo;
import po.NamesOfAllPlayerPo;
import po.OnePlayerPerformanceOfOneSeasonPo;
import common.mydatastructure.Season;
import dataservice.players.PlayerInfoDataService;

public class PlayerInfoData implements PlayerInfoDataService {

	public OnePlayerPerformanceOfOneSeasonPo getOnePlayerPerformanceOfOneSeasonPo(String nameOfPlayer, Season season) {
		return new OnePlayerPerformanceOfOneSeasonPo(nameOfPlayer, season);
	}// 查找某一球员某一赛季的比赛信息

	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer) {
		return new GeneralInfoOfPlayerPo(nameOfPlayer);
	}// 查找某一球员的基本自然信息

	public NamesOfAllPlayerPo getNamesOfAllPlayer() {
		return new NamesOfAllPlayerPo();
	}// 查找所有球员姓名
}
