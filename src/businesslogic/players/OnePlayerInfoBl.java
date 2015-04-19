package businesslogic.players;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import businesslogic.CACHE;
import businesslogicservice.players.OnePlayerInfoBlService;
import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;
import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

public class OnePlayerInfoBl implements OnePlayerInfoBlService {
	PlayerInfoDataService playerInfoData = PlayerInfoData.getInstance();

	public GeneralInfoOfPlayer getPlayerGeneralInfo(String playerName) {
		return this.playerInfoData.getGeneralInfoOfOnePlayer(playerName);
	}

	public PlayerNormalInfo_Expand getPlayerNormalInfo_avg(String playerName) {
		if (CACHE.PLAYER_NORMAL.containsKey(playerName)) {
			return CACHE.PLAYER_NORMAL.get(playerName).getPlayerNormal_avg();
		}
		else {
			return null;
		}
	}

	public PlayerNormalInfo_Expand getPlayerNormalInfo_tot(String playerName) {
		if (CACHE.PLAYER_NORMAL.containsKey(playerName)) {
			return CACHE.PLAYER_NORMAL.get(playerName);
		}
		else {
			return null;
		}
	}

	public PlayerHighInfo getPlayerHighInfo(String playerName) {
		if (CACHE.PLAYER_HIGH.containsKey(playerName)) {
			return CACHE.PLAYER_HIGH.get(playerName);
		}
		else {
			return null;
		}
	}

	public ArrayList<PlayerPerformOfOneMatch> getPlayerPerform(String playerName) {
		return this.playerInfoData.getOnePlayerPerformOfOneSeasonPo(playerName);
	}
}
