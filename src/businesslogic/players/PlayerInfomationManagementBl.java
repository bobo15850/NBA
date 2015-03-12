package businesslogic.players;

import vo.OnePlayerPerformanceOfOneSeasonVo;

import common.ResultMessage;
import common.enums.KindOfPlayerData;
import common.mydatastructure.Season;
import common.mydatastructure.player.baseinformation.BaseInformationOfPlayer;
import common.mydatastructure.player.matchinformation.AllPlayerPerformanceOfOneSeason;
import common.mydatastructure.player.matchinformation.OnePlayerPerformanceOfAllSeason;

import businesslogicservice.players.PlayerInfomationManagementBlService;

public class PlayerInfomationManagementBl implements PlayerInfomationManagementBlService {

	@Override
	public AllPlayerPerformanceOfOneSeason getAllPlayerPerformanceOfOneSeason(Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnePlayerPerformanceOfAllSeason getOnePlayerInformationOfAllSeason(String nameOfPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage ascendingSort(AllPlayerPerformanceOfOneSeason data, KindOfPlayerData dataKind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage descendingSort(AllPlayerPerformanceOfOneSeason data, KindOfPlayerData dataKind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseInformationOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

}
