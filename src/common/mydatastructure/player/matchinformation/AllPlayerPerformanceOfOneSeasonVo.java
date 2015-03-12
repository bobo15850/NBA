package common.mydatastructure.player.matchinformation;

import java.util.ArrayList;
import java.util.Iterator;

import vo.OnePlayerPerformanceOfOneSeasonVo;
import common.mydatastructure.Season;

public class AllPlayerPerformanceOfOneSeasonVo implements Iterator<OnePlayerPerformanceOfOneSeasonVo> {
	private Season season;
	private ArrayList<OnePlayerPerformanceOfOneSeasonVo> listOfOnePlayerPerformanceOfOneSeason;
	private int numberOfPlayer;
	private int pointer;

	public AllPlayerPerformanceOfOneSeasonVo(Season season) {
		this.season = season;
		this.pointer = 0;
		this.listOfOnePlayerPerformanceOfOneSeason = new ArrayList<OnePlayerPerformanceOfOneSeasonVo>(1024);
		this.init();
	}

	private void init() {

	}

	public boolean hasNext() {
		return this.pointer < numberOfPlayer;
	}

	public OnePlayerPerformanceOfOneSeasonVo next() {
		this.pointer++;
		return listOfOnePlayerPerformanceOfOneSeason.get(pointer);
	}

	public void remove() {
		this.listOfOnePlayerPerformanceOfOneSeason.remove(pointer - 1);
		numberOfPlayer--;
	}
}
