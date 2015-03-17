package data.players;

import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.Season;
import databaseutility.OperationOfGeneralInfoDB;
import databaseutility.OperationOfPlayersDB;
import dataservice.players.PlayerInfoDataService;

public class PlayerInfoData implements PlayerInfoDataService {

	private OperationOfGeneralInfoDB generalInfoDB;
	private OperationOfPlayersDB playerDB;

	public PlayerInfoData() {
		generalInfoDB = OperationOfGeneralInfoDB.getGeneralInfo();
		playerDB = OperationOfPlayersDB.getPlayerDB();
	}

	public ArrayList<PlayerPerformanceOfOneMatchPo> getOnePlayerPerformOfOneSeasonPo(String nameOfPlayer, Season season) {
		ArrayList<PlayerPerformanceOfOneMatchPo> poList = new ArrayList<PlayerPerformanceOfOneMatchPo>(128);

		return poList;
	}// 查找某一球员某一赛季的比赛信息

	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer) {
		GeneralInfoOfPlayerPo generalInfoOfPlayer = new GeneralInfoOfPlayerPo();

		return generalInfoOfPlayer;
	}// 查找某一球员的基本自然信息

	public ArrayList<String> getNamesOfAllPlayer() {
		ArrayList<String> namesList = new ArrayList<String>(1024);
		return namesList;
	}// 查找所有球员姓名

	public ArrayList<TeamPerformanceOfOneMatchPo[]> getOneTeamPerformOfOneSeason(String playerName, Season season) {
		return null;
	}
}
