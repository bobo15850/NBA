package businesslogic.players;

import java.util.ArrayList;

import vo.OnePlayerPerformanceOfOneSeasonVo;

public class OnePlayerPerformanceOfAllSeason {
	private String nameOfPlayer;
	private ArrayList<OnePlayerPerformanceOfOneSeasonVo> listOfPlayerPerformanceOfOneseason;
	private int numebrOfSeason;

	public OnePlayerPerformanceOfAllSeason(String nameOfPlayer) {
		this.nameOfPlayer = nameOfPlayer;
		this.listOfPlayerPerformanceOfOneseason = new ArrayList<OnePlayerPerformanceOfOneSeasonVo>(32);
		this.init();
	}

	private void init() {

	}
}
