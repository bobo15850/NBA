package businesslogic.matches;

import java.util.ArrayList;

import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerPerformOfOneMatch;
import data.matches.MatchInfoData;
import data.players.PlayerInfoData;
import dataservice.matches.MatchInfoDataService;
import dataservice.players.PlayerInfoDataService;
import businesslogicservice.matches.OneMatchInfoBlService;

public class OneMatchInfoBl implements OneMatchInfoBlService {
	MatchInfoDataService matchInfoData = MatchInfoData.getInstance();
	PlayerInfoDataService playerInfoData = PlayerInfoData.getInstance();

	public ArrayList<PlayerPerformOfOneMatch> getPlayersPerformOfOneMatch(final String teamName, final MyDate date) {
		ArrayList<String> playerName = matchInfoData.getPlayerNameOfOneMatch(teamName, date);
		if (playerName != null) {
			ArrayList<PlayerPerformOfOneMatch> playerPerform = new ArrayList<PlayerPerformOfOneMatch>(16);
			for (int i = 0; i < playerName.size(); i++) {
				PlayerPerformOfOneMatch temp = this.playerInfoData.getOnePlayerOneMatchPerform(playerName.get(i), date);
				if (temp != null) {
					playerPerform.add(temp);
				}
			}
			return playerPerform;
		}
		return null;
	}
}
