package vo;

import java.util.ArrayList;

import common.enums.TeamName;
import common.mydatastructure.Season;
import po.OneTeamPerformanceOfOneSeasonPo;
import po.TeamPerformanceOfOneMatchPo;

public class OneTeamPerformanceOfOneSeasonVo {
	private TeamName teamName;// 球队名称
	private Season season;// 赛季
	private ArrayList<TeamPerformanceOfOneMatchPo> listOfPerformanceOfOneMatch;// 球队赛季里每场比赛
	

	public OneTeamPerformanceOfOneSeasonVo(OneTeamPerformanceOfOneSeasonPo po) {
		this.teamName = po.getTeamName();
		this.season = po.getSeason();
		this.listOfPerformanceOfOneMatch = po.getListOfPerformanceOfOneMatch();

	}

	// /////////////////一下是一系列的getxxx方法
	// TODO
}
