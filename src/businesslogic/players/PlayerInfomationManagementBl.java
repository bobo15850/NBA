package businesslogic.players;

import po.OnePlayerPerformanceOfOneSeasonPo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import common.enums.KindOfPlayerData;
import common.mydatastructure.Season;
import common.mydatastructure.player.BaseInformationOfPlayer;
import common.statics.ResultMessage;
import data.players.PlayerInformationManagementData;
import dataservice.players.PlayerInformationManagementDataService;
import businesslogicservice.players.PlayerInfomationManagementBlService;

public class PlayerInfomationManagementBl implements PlayerInfomationManagementBlService {
	private PlayerInformationManagementDataService playerInfoManagementData;

	public PlayerInfomationManagementBl() {
		this.playerInfoManagementData = new PlayerInformationManagementData();
	}

	public AllPlayerPerformanceOfOneSeason getAllPlayerPerformanceOfOneSeason(Season season) {
		return new AllPlayerPerformanceOfOneSeason(season);
	}

	public OnePlayerPerformanceOfAllSeason getOnePlayerInformationOfAllSeason(String nameOfPlayer) {
		return new OnePlayerPerformanceOfAllSeason(nameOfPlayer);
	}

	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		OnePlayerPerformanceOfOneSeasonPo po = this.playerInfoManagementData.getOnePlayerPerformanceOfOneSeason(nameOfPlayer, season);
		return new OnePlayerPerformanceOfOneSeasonVo(po);
	}

	public ResultMessage ascendingSort(AllPlayerPerformanceOfOneSeason data, KindOfPlayerData dataKind) {
		return null;
	}

	public ResultMessage descendingSort(AllPlayerPerformanceOfOneSeason data, KindOfPlayerData dataKind) {
		return null;
	}

	public BaseInformationOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer) {
		return this.playerInfoManagementData.getBaseInformationOfOnePlayer(nameOfPlayer);
	}

}
