package data.players;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import common.mydatastructure.Season;
import common.statics.PathOfFile;
import dataservice.players.PlayerInfoDataService;

public class PlayerInfoData implements PlayerInfoDataService {

	public ArrayList<PlayerPerformanceOfOneMatchPo> getOnePlayerPerformOfOneSeasonPo(String nameOfPlayer, Season season) {
		ArrayList<PlayerPerformanceOfOneMatchPo> poList = new ArrayList<PlayerPerformanceOfOneMatchPo>(128);
		return poList;
	}// 查找某一球员某一赛季的比赛信息

	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer) {
		GeneralInfoOfPlayerPo generalInfoOfPlayer = new GeneralInfoOfPlayerPo();
		generalInfoOfPlayer.setPortraitImageIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + nameOfPlayer + ".png"));
		generalInfoOfPlayer.setActionImageIcon(new ImageIcon(PathOfFile.PLAYER_ACTION_IMAGE + nameOfPlayer + ".png"));
		return generalInfoOfPlayer;
	}// 查找某一球员的基本自然信息

	public ArrayList<String> getNamesOfAllPlayer() {
		ArrayList<String> namesList = new ArrayList<String>(1024);
		return namesList;
	}// 查找所有球员姓名
}
