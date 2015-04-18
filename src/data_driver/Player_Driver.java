package data_driver;

import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

public class Player_Driver {
	PlayerInfoDataService plData = PlayerInfoData.getInstance();

	public void testGeneralInfoPo() {
		GeneralInfoOfPlayerPo playerPo = plData.getGeneralInfoOfOnePlayer("Al Harrington");
		System.out.println(playerPo);
	}

	public void testAllNames() {
		ArrayList<String> names = plData.getNamesOfAllPlayer();
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
			System.out.println(i);
		}
	}

	public void testOnePlayerPerformOfOneSeason() {
		String playerName = "Al Harrington";
		ArrayList<PlayerPerformanceOfOneMatchPo> playerPerformPoList = this.plData.getOnePlayerPerformOfOneSeasonPo(playerName);
		for (int i = 0; i < playerPerformPoList.size(); i++) {
			System.out.println(playerPerformPoList.get(i));
		}
	}

	public void testOneTeamPerformOfOneSeason() {
		String playerName = "Al Harrington";
		ArrayList<TeamPerformanceOfOneMatchPo[]> teamPerformPoList = this.plData.getOneTeamPerformOfOneSeason(playerName);
		for (int i = 0; i < teamPerformPoList.size(); i++) {
			System.out.println(i);
			System.out.println(teamPerformPoList.get(i)[0]);
			System.out.println(teamPerformPoList.get(i)[1]);
		}
	}

	public void testGeneralTeamPo() {
		String playerName = "Al Harrington";
		String league = this.plData.getLeague(playerName);
		System.out.println(league);
	}

	public static void main(String arg[]) {
		Player_Driver pd = new Player_Driver();
		pd.testGeneralInfoPo();
		 pd.testAllNames();
		 pd.testOnePlayerPerformOfOneSeason();
		 pd.testOneTeamPerformOfOneSeason();
		 pd.testGeneralTeamPo();
	}
}
