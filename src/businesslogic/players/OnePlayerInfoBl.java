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

	public GeneralInfoOfPlayer getPlayerGeneralInfo(final String playerName) {
		return this.playerInfoData.getGeneralInfoOfOnePlayer(playerName);
	}

	public PlayerNormalInfo_Expand getPlayerNormalInfo_avg(final String playerName) {
		if (CACHE.PLAYER_NORMAL.containsKey(playerName)) {
			return CACHE.PLAYER_NORMAL.get(playerName).getPlayerNormal_avg();
		}
		else {
			return null;
		}
	}

	public PlayerNormalInfo_Expand getPlayerNormalInfo_tot(final String playerName) {
		if (CACHE.PLAYER_NORMAL.containsKey(playerName)) {
			return CACHE.PLAYER_NORMAL.get(playerName);
		}
		else {
			return null;
		}
	}

	public PlayerHighInfo getPlayerHighInfo(final String playerName) {
		if (CACHE.PLAYER_HIGH.containsKey(playerName)) {
			return CACHE.PLAYER_HIGH.get(playerName);
		}
		else {
			return null;
		}
	}

	public ArrayList<PlayerPerformOfOneMatch> getPlayerPerform(final String playerName) {
		return this.playerInfoData.getOnePlayerPerformOfOneSeasonPo(playerName);
	}
}
