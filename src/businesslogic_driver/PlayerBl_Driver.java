package businesslogic_driver;

import java.util.ArrayList;

import vo.OnePlayerPerformOfOneSeasonVo;
import common.mydatastructure.Season;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;

public class PlayerBl_Driver {
	PlayerInfoBlService playerInfoBl = new PlayerInfoBl();

	public void testGetOneSeasonPerformOfAllPlayer() {
		Season season = new Season("2013-2014");
		ArrayList<OnePlayerPerformOfOneSeasonVo> volist = playerInfoBl.getOneSeasonPerformOfAllPlayer(season);
		for (int i = 0; i < volist.size(); i++) {
			System.out.println(i);
			System.out.println(volist.get(i).getNameOfPlayer());
		}
	}

	public static void main(String arg[]) {
		PlayerBl_Driver pbd = new PlayerBl_Driver();
		pbd.testGetOneSeasonPerformOfAllPlayer();
	}
}
