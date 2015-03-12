package businesslogic.players;

import po.OnePlayerPerformanceOfOneSeasonPo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import common.ResultMessage;
import common.enums.KindOfPlayerData;
import common.mydatastructure.Season;
import common.mydatastructure.player.baseinformation.BaseInformationOfPlayer;
import common.mydatastructure.player.matchinformation.AllPlayerPerformanceOfOneSeasonVo;
import common.mydatastructure.player.matchinformation.OnePlayerPerformanceOfAllSeasonVo;
import data.players.PlayerInfomationManagementData;
import dataservice.players.PlayerInfomationManagementDataService;
import businesslogicservice.players.PlayerInfomationManagementBlService;

public class PlayerInfomationManagementBl implements PlayerInfomationManagementBlService {
	private PlayerInfomationManagementDataService playerInfoManagementData;

	public PlayerInfomationManagementBl() {
		this.playerInfoManagementData = new PlayerInfomationManagementData();
	}

	public AllPlayerPerformanceOfOneSeasonVo getAllPlayerPerformanceOfOneSeason(Season season) {
		return new AllPlayerPerformanceOfOneSeasonVo(season);
	}

	public OnePlayerPerformanceOfAllSeasonVo getOnePlayerInformationOfAllSeason(String nameOfPlayer) {
		return new OnePlayerPerformanceOfAllSeasonVo(nameOfPlayer);
	}

	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		OnePlayerPerformanceOfOneSeasonPo po = this.playerInfoManagementData.getOnePlayerPerformanceOfOneSeason(nameOfPlayer, season);
		return new OnePlayerPerformanceOfOneSeasonVo(po);
	}

	public ResultMessage ascendingSort(AllPlayerPerformanceOfOneSeasonVo data, KindOfPlayerData dataKind) {
		return null;
	}

	public ResultMessage descendingSort(AllPlayerPerformanceOfOneSeasonVo data, KindOfPlayerData dataKind) {
		return null;
	}

	public BaseInformationOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer) {
		return this.playerInfoManagementData.getBaseInformationOfOnePlayer(nameOfPlayer);
	}

}
