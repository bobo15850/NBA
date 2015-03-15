package businesslogic.players;

import java.util.ArrayList;

import vo.GeneralInfoOfPlayerVo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import businesslogicservice.players.PlayerInfoBlService;

import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;

import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

/*
 * 该类为球员信息管理的业务逻辑类运用相应的data层接口为界面层提供接口，
 */
public class PlayerInfoBl implements PlayerInfoBlService {
	private PlayerInfoDataService playerInfoData;

	public PlayerInfoBl() {
		this.playerInfoData = new PlayerInfoData();
	}

	@Override
	public ArrayList<OnePlayerPerformanceOfOneSeasonVo> getAllPlayerPerformanceOfOneSeason(Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OnePlayerPerformanceOfOneSeasonVo> getOnePlayerInformationOfAllSeason(String nameOfPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeneralInfoOfPlayerVo getBaseInformationOfOnePlayer(String nameOfPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ascendingSort(ArrayList<OnePlayerPerformanceOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {
		// TODO Auto-generated method stub

	}

	@Override
	public void descendingSort(ArrayList<OnePlayerPerformanceOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {
		// TODO Auto-generated method stub

	}

}
