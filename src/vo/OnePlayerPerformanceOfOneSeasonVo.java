package vo;

import java.util.ArrayList;

import po.OnePlayerPerformanceOfOneSeasonPo;
import common.mydatastructure.Season;
import common.mydatastructure.player.PlayerPerformanceOfOneMatch;

public class OnePlayerPerformanceOfOneSeasonVo {
	private String nameOfPlayer;
	private Season season;// 赛季信息
	private ArrayList<PlayerPerformanceOfOneMatch> listOfPerformanceOfOneMatch;// 每场比赛信息的链表
	private int numberOfMatch;// 比赛场数
	private int numberOfFirst;// 先发场数

	public OnePlayerPerformanceOfOneSeasonVo(OnePlayerPerformanceOfOneSeasonPo po) {
		this.nameOfPlayer = po.getNameOfPlayer();
		this.season = po.getSeason();
		this.listOfPerformanceOfOneMatch = po.getListOfPerformanceOfOneMatch();
	}
	// 以下是一系列getxxx方法
}
