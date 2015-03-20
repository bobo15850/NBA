package businesslogic_driver;

import java.util.ArrayList;

import vo.GeneralInfoOfPlayerVo;
import vo.OnePlayerPerformOfOneSeasonVo;
import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;

public class PlayerBl_Driver {
	PlayerInfoBlService playerInfoBl = new PlayerInfoBl();

	public void testGetOneSeasonPerformOfAllPlayer() {
		Season season = new Season("2013-2014");
		ArrayList<OnePlayerPerformOfOneSeasonVo> volist = playerInfoBl.getOneSeasonPerformOfAllPlayer(season);
		for (int i = 0; i < volist.size(); i++) {
			OnePlayerPerformOfOneSeasonVo temp = volist.get(i);

			String[] content = temp.toStringArray();
			for (int j = 0; j < content.length; j++) {
				System.out.print(content[j]);
				System.out.print(";");
			}
			System.out.println();
			System.out.println(i);
		}
	}

	public void testGetOnePlayerPerformOfOneSeason() {
		String nameOfPlayer = "Kevin Durant";
		Season season = new Season("2013-2014");
		OnePlayerPerformOfOneSeasonVo temp = playerInfoBl.getOnePlayerPerformOfOneSeason(nameOfPlayer, season);
		String[] content = temp.toStringArray();
		for (int j = 0; j < content.length; j++) {
			System.out.print(content[j]);
			System.out.print(";  ");
		}
		System.out.println();
	}

	public void testGetBaseInformationOfOnePlayer() {
		String nameOfPlayer = "Kevin Durant";
		GeneralInfoOfPlayerVo vo = this.playerInfoBl.getGeneralInfoOfOnePlayer(nameOfPlayer);
		String[] content = vo.toStringArray();
		for (int i = 0; i < content.length; i++) {
			System.out.print(content[i]);
			System.out.print(";   ");
		}
	}

	public void testAscendingSort() {
		Season season = new Season("2013-2014");
		ArrayList<OnePlayerPerformOfOneSeasonVo> volist = playerInfoBl.getOneSeasonPerformOfAllPlayer(season);
		this.playerInfoBl.ascendingSort(volist, PerformanceOfPlayer.AverageScoreNumber);
		for (int i = 0; i < volist.size(); i++) {
			OnePlayerPerformOfOneSeasonVo temp = volist.get(i);

			String[] content = temp.toStringArray();
			for (int j = 0; j < content.length; j++) {
				System.out.print(content[j]);
				System.out.print(";");
			}
			System.out.println();
			System.out.println(i);
		}
	}

	public void testDescendingSort() {
		Season season = new Season("2013-2014");
		ArrayList<OnePlayerPerformOfOneSeasonVo> volist = playerInfoBl.getOneSeasonPerformOfAllPlayer(season);
		this.playerInfoBl.descendingSort(volist, PerformanceOfPlayer.AverageScoreNumber);
		for (int i = 0; i < volist.size(); i++) {
			OnePlayerPerformOfOneSeasonVo temp = volist.get(i);

			String[] content = temp.toStringArray();
			for (int j = 0; j < content.length; j++) {
				System.out.print(content[j]);
				System.out.print(";");
			}
			System.out.println();
			System.out.println(i);
		}
	}

	public static void main(String arg[]) {
		PlayerBl_Driver pbd = new PlayerBl_Driver();
		// pbd.testGetOneSeasonPerformOfAllPlayer();
		// pbd.testGetOnePlayerPerformOfOneSeason();
		// pbd.testGetBaseInformationOfOnePlayer();
		// pbd.testAscendingSort();
		pbd.testDescendingSort();
	}
}
