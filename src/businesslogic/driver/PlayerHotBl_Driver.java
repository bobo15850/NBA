package businesslogic.driver;

import java.util.ArrayList;

import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import businesslogic.hotsport.PlayerHotBl;
import businesslogicservice.hotsport.PlayerHotBlSrevice;

public class PlayerHotBl_Driver {
	PlayerHotBlSrevice playerHot = new PlayerHotBl();

	private void testGetPlayerHot() {
		ArrayList<PlayerHotInfo> playerHotList = this.playerHot.getPlayerHot(5, "point");
		for (int i = 0; i < playerHotList.size(); i++) {
			System.out.println(playerHotList.get(i).toString());
		}
	}

	private void testGetPlayerKingOfSeason() {
		ArrayList<PlayerKingInfo> playerKingList = this.playerHot.getPlayerKingOfSeason(5, "point");
		for (int i = 0; i < playerKingList.size(); i++) {
			System.out.println(playerKingList.get(i).toString());
		}
	}

	private void testGetPlayerKingOfDaily() {
		ArrayList<PlayerKingInfo> playerKingList = this.playerHot.getPlayerKingOfDaily(5, "rebound");
		for (int i = 0; i < playerKingList.size(); i++) {
			System.out.println(playerKingList.get(i).toString());
		}
	}

	public static void main(String arg[]) {
		PlayerHotBl_Driver driver = new PlayerHotBl_Driver();
		driver.testGetPlayerHot();
		driver.testGetPlayerKingOfSeason();
		driver.testGetPlayerKingOfDaily();
	}

}
