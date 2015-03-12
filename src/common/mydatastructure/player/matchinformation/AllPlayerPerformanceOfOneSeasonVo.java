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
