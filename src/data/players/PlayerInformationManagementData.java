package data.players;

import po.NamesOfAllPlayerPo;
import po.OnePlayerPerformanceOfOneSeasonPo;
import common.mydatastructure.Season;
import common.mydatastructure.player.BaseInformationOfPlayer;
import dataservice.players.PlayerInformationManagementDataService;

public class PlayerInformationManagementData implements PlayerInformationManagementDataService {

	public OnePlayerPerformanceOfOneSeasonPo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		return new OnePlayerPerformanceOfOneSeasonPo(nameOfPlayer, season);
	}

	public BaseInformationOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer) {
		return new BaseInformationOfPlayer(nameOfPlayer);
	}

	public NamesOfAllPlayerPo getNamesOfAllPlayer() {
		return new NamesOfAllPlayerPo();
	}
}
