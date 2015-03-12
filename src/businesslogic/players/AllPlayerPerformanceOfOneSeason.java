package businesslogic.players;

import java.util.ArrayList;
import java.util.Iterator;

import po.NamesOfAllPlayerPo;
import po.OnePlayerPerformanceOfOneSeasonPo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import common.mydatastructure.Season;
import data.players.PlayerInformationManagementData;
import dataservice.players.PlayerInformationManagementDataService;

public class AllPlayerPerformanceOfOneSeason implements Iterator<OnePlayerPerformanceOfOneSeasonVo> {
	private Season season;
	private ArrayList<OnePlayerPerformanceOfOneSeasonVo> listOfOnePlayerPerformanceOfOneSeason;
	private int numberOfPlayer;
	private int pointer;

	public AllPlayerPerformanceOfOneSeason(Season season) {
		this.season = season;
		this.pointer = 0;
		this.listOfOnePlayerPerformanceOfOneSeason = new ArrayList<OnePlayerPerformanceOfOneSeasonVo>(1024);
		this.init();
	}

	private void init() {
		PlayerInformationManagementDataService playerInfoManagementData = new PlayerInformationManagementData();
		NamesOfAllPlayerPo namesOfPlayer = playerInfoManagementData.getNamesOfAllPlayer();
		listOfOnePlayerPerformanceOfOneSeason.add(new OnePlayerPerformanceOfOneSeasonVo(new OnePlayerPerformanceOfOneSeasonPo(namesOfPlayer.first(), this.season)));
		while (namesOfPlayer.hasNext()) {
			listOfOnePlayerPerformanceOfOneSeason.add(new OnePlayerPerformanceOfOneSeasonVo(new OnePlayerPerformanceOfOneSeasonPo(namesOfPlayer.next(), this.season)));
		}
		this.numberOfPlayer = listOfOnePlayerPerformanceOfOneSeason.size();
	}

	public Season getSeason() {
		return this.season;
	}

	public int getNumberOfPlayer() {
		return this.numberOfPlayer;
	}

	public OnePlayerPerformanceOfOneSeasonVo first() {
		pointer = 0;
		return this.listOfOnePlayerPerformanceOfOneSeason.get(0);
	}

	public boolean hasNext() {
		return this.pointer < (numberOfPlayer - 1);
	}

	public OnePlayerPerformanceOfOneSeasonVo next() {
		this.pointer++;
		OnePlayerPerformanceOfOneSeasonVo temp = listOfOnePlayerPerformanceOfOneSeason.get(pointer);
		return temp;
	}

	public void remove() {
		this.listOfOnePlayerPerformanceOfOneSeason.remove(pointer);
		pointer--;
		numberOfPlayer--;
	}
}
