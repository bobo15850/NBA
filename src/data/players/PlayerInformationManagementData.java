package data.players;

import po.NamesOfAllPlayerPo;
import po.OnePlayerPerformanceOfOneSeasonPo;
import common.mydatastructure.Season;
import common.mydatastructure.player.GeneralInfoOfPlayer;
import dataservice.players.PlayerInformationManagementDataService;

public class PlayerInformationManagementData implements PlayerInformationManagementDataService {

	public OnePlayerPerformanceOfOneSeasonPo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		return new OnePlayerPerformanceOfOneSeasonPo(nameOfPlayer, season);
	}// 查找某一球员某一赛季的比赛信息

	public GeneralInfoOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer) {
		return new GeneralInfoOfPlayer(nameOfPlayer);
	}// 查找某一球员的基本自然信息

	public NamesOfAllPlayerPo getNamesOfAllPlayer() {
		return new NamesOfAllPlayerPo();
	}// 查找所有球员姓名
}
