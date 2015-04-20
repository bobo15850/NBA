package businesslogic.driver;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;
import businesslogic.players.OnePlayerInfoBl;
import businesslogicservice.players.OnePlayerInfoBlService;

public class OnePlayerBl_Driver {
	private OnePlayerInfoBlService onePlayerInfoBl = new OnePlayerInfoBl();

	private void testGetPlayerGeneralInfo() {
		GeneralInfoOfPlayer generalInfo = this.onePlayerInfoBl.getPlayerGeneralInfo("Kevin Durant");
		System.out.println(generalInfo.toString());
	}

	private void testGetPlayerNormalInfo_avg() {
		PlayerNormalInfo_Expand playerNormal = this.onePlayerInfoBl.getPlayerNormalInfo_avg("Kevin Durant");
		if (playerNormal != null) {
			System.out.println(playerNormal.toString());
		}
	}

	private void testgetPlayerNormalInfo_tot() {
		PlayerNormalInfo_Expand playerNormal = this.onePlayerInfoBl.getPlayerNormalInfo_tot("Kevin Durant");
		if (playerNormal != null) {
			System.out.println(playerNormal.toString());
		}
	}

	private void testGetPlayerHighInfo() {
		PlayerHighInfo playerHigh = this.onePlayerInfoBl.getPlayerHighInfo("Kevin Durant");
		if (playerHigh != null) {
			System.out.println(playerHigh.toString());
		}
	}

	private void testGetPlayerPerform() {
		ArrayList<PlayerPerformOfOneMatch> onePlayerPerform = this.onePlayerInfoBl.getPlayerPerform("Kevin Durant");
		for (int i = 0; i < onePlayerPerform.size(); i++) {
			System.out.println(onePlayerPerform.get(i).toString());
		}
	}

	public static void main(String args[]) {
		OnePlayerBl_Driver driver = new OnePlayerBl_Driver();
		driver.testGetPlayerGeneralInfo();
		driver.testGetPlayerNormalInfo_avg();
		driver.testgetPlayerNormalInfo_tot();
		driver.testGetPlayerHighInfo();
		driver.testGetPlayerPerform();
	}
}
