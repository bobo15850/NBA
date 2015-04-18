package businesslogic.driver;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;

import common.mydatastructure.SortCell;

public class PlayerInfoBl_Driver {
	PlayerInfoBlService playerInfoBl = new PlayerInfoBl();

	private void testGetPlayerHigh() {
		ArrayList<PlayerHighInfo> resultList = playerInfoBl.getPlayerHigh(50, new SortCell[] { new SortCell("GmSc.desc"),
				new SortCell("realShot.desc") });
		for (int i = 0; i < 50; i++) {
			System.out.println(resultList.get(i).toString());
		}
	}

	public static void main(String arg[]) {
		PlayerInfoBl_Driver driver = new PlayerInfoBl_Driver();
		driver.testGetPlayerHigh();
	}
}
