package businesslogic.driver;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;

import common.mydatastructure.CombineSelectionCell;
import common.mydatastructure.Filter;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.SortCell;
import common.statics.Age;
import common.statics.Field;
import common.statics.League;
import common.statics.Position;

public class PlayerInfoBl_Driver {
	PlayerInfoBlService playerInfoBl = new PlayerInfoBl();

	private void testGetPlayerHigh() {
		ArrayList<PlayerHighInfo> resultList = playerInfoBl.getPlayerHigh(50, new SortCell[] { new SortCell("GmSc.desc"),
				new SortCell("realShot.desc") });
		for (int i = 0; i < 50; i++) {
			System.out.println(resultList.get(i).toString());
		}
	}

	private void testGetPlayerNormal_tot() {
		Filter filter = new Filter();
		filter.setAge(Age.All);
		filter.setLeague(League.All);
		filter.setPosition(Position.All);
		ArrayList<PlayerNormalInfo_Expand> playerNormal_tot = playerInfoBl.getPlayerNormal_tot(50, filter, new SortCell[] {
				new SortCell("point.desc"), new SortCell("doubleTwo.desc") });
		for (int i = 0; i < playerNormal_tot.size(); i++) {
			System.out.println(playerNormal_tot.get(i).toString());
		}
	}

	private void testGetPlayerNormal_avg() {
		Filter filter = new Filter();
		filter.setAge(Age.All);
		filter.setLeague(League.All);
		filter.setPosition(Position.All);
		ArrayList<PlayerNormalInfo_Expand> playerNormal_avg = playerInfoBl.getPlayerNormal_avg(50, filter, new SortCell[] {
				new SortCell("doubleTwo.desc"), new SortCell("point.desc") });
		for (int i = 0; i < playerNormal_avg.size(); i++) {
			System.out.println(playerNormal_avg.get(i).getName() + " " + playerNormal_avg.get(i).getDoubleTwo());
			System.out.println(playerNormal_avg.get(i).toString());
		}
	}

	private void testGetPlayerNormal_avg_highSelect() {
		CombineSelectionCell cell1 = new CombineSelectionCell();
		cell1.setField(Field.point);
		cell1.setNumber(20);
		CombineSelectionCell cell2 = new CombineSelectionCell();
		cell2.setField(Field.rebound);
		cell2.setNumber(5);
		CombineSelectionCell cell3 = new CombineSelectionCell();
		cell3.setField(Field.assist);
		cell3.setNumber(5);
		CombineSelectionCell[] comSelction = new CombineSelectionCell[] { cell1, cell2, cell3 };
		ArrayList<PlayerNormalInfo_Expand> playerNormal_avg = playerInfoBl.getPlayerNormal_avg(comSelction);
		for (int i = 0; i < playerNormal_avg.size(); i++) {
			System.out.println(playerNormal_avg.get(i).getName() + " " + playerNormal_avg.get(i).getPoint() + " "
					+ playerNormal_avg.get(i).getRebound() + " " + playerNormal_avg.get(i).getAssist());
			System.out.println(playerNormal_avg.get(i).toString());
		}
	}

	public static void main(String arg[]) {
		PlayerInfoBl_Driver driver = new PlayerInfoBl_Driver();
		driver.testGetPlayerHigh();
		driver.testGetPlayerNormal_tot();
		driver.testGetPlayerNormal_avg();
		driver.testGetPlayerNormal_avg_highSelect();
	}
}
