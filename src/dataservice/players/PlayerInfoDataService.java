package dataservice.players;

import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;

import common.mydatastructure.Season;

public interface PlayerInfoDataService {
	// 查找某一球员在某一赛季的比赛信息
	public ArrayList<PlayerPerformanceOfOneMatchPo> getOnePlayerPerformOfOneSeasonPo(String nameOfPlayer, Season season);

	// 查找出所有的球员姓名
	public ArrayList<String> getNamesOfAllPlayer();

	// 根据球员姓名查找某一球员具体基本自然信息
	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer);

}
