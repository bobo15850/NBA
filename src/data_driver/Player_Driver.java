package data_driver;

import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.Season;
import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

public class Player_Driver {
	PlayerInfoDataService plData = new PlayerInfoData();

	public void testGeneralInfoPo() {
		GeneralInfoOfPlayerPo playerPo = plData.getBaseInformationOfOnePlayer("Al Harrington");
		System.out.println(playerPo.toDBString());
	}

	public void testAllNames() {
		ArrayList<String> names = plData.getNamesOfAllPlayer();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
			System.out.println(i);
		}
	}

	public void testOnePlayerPerformOfOneSeason() {
		Season season = new Season("2013-2014");
		String playerName = "Al Harrington";
		ArrayList<PlayerPerformanceOfOneMatchPo> playerPerformPoList = this.plData.getOnePlayerPerformOfOneSeasonPo(
				playerName, season);
		for (int i = 0; i < playerPerformPoList.size(); i++) {
			System.out.println(playerPerformPoList.get(i).toDBString());
		}
	}

	public void testOneTeamPerformOfOneSeason() {
		String playerName = "Al Harrington";
		Season season = new Season("2013-2014");
		ArrayList<TeamPerformanceOfOneMatchPo[]> teamPerformPoList = this.plData.getOneTeamPerformOfOneSeason(
				playerName, season);
		for (int i = 0; i < teamPerformPoList.size(); i++) {
			System.out.println(i);
			System.out.println(teamPerformPoList.get(i)[0].toDBString());
			System.out.println(teamPerformPoList.get(i)[1].toDBString());
		}
	}
}
