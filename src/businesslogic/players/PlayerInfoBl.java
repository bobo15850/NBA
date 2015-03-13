package businesslogic.players;

import java.util.ArrayList;

import po.NamesOfAllPlayerPo;
import po.OnePlayerPerformanceOfOneSeasonPo;
import vo.AllPlayerPerformanceOfOneSeasonVo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import businesslogicservice.players.PlayerInfoBlService;
import common.mydatastructure.Season;
import common.mydatastructure.player.GeneralInfoOfPlayer;
import data.players.PlayerInformationManagementData;
import dataservice.players.PlayerInformationManagementDataService;

/*
 * 该类为球员信息管理的业务逻辑类运用相应的data层接口为界面层提供接口，
 */
public class PlayerInfoBl implements PlayerInfoBlService {
	private PlayerInformationManagementDataService playerInfoManagementData;

	public PlayerInfoBl() {
		this.playerInfoManagementData = new PlayerInformationManagementData();
	}

	public AllPlayerPerformanceOfOneSeasonVo getAllPlayerPerformanceOfOneSeason(Season season) {
		NamesOfAllPlayerPo namesOfPlayer = playerInfoManagementData.getNamesOfAllPlayer();
		ArrayList<OnePlayerPerformanceOfOneSeasonVo> listOfOnePlayerPerformanceOfOneSeason=new ArrayList<OnePlayerPerformanceOfOneSeasonVo>();
		listOfOnePlayerPerformanceOfOneSeason.add(new OnePlayerPerformanceOfOneSeasonVo(playerInfoManagementData.getOnePlayerPerformanceOfOneSeason(namesOfPlayer.first(), season)));
		while (namesOfPlayer.hasNext()) {
			listOfOnePlayerPerformanceOfOneSeason.add(new OnePlayerPerformanceOfOneSeasonVo(playerInfoManagementData.getOnePlayerPerformanceOfOneSeason(namesOfPlayer.next(), season)));
		}
		return new AllPlayerPerformanceOfOneSeasonVo(season, listOfOnePlayerPerformanceOfOneSeason);
	}// 获取某一个赛季所有球员的比赛信息

	public OnePlayerPerformanceOfAllSeason getOnePlayerInformationOfAllSeason(String nameOfPlayer) {
		return new OnePlayerPerformanceOfAllSeason(nameOfPlayer);
	}// 根据某一球员姓名查找其所有赛季比赛信息

	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		OnePlayerPerformanceOfOneSeasonPo po = this.playerInfoManagementData.getOnePlayerPerformanceOfOneSeason(nameOfPlayer, season);
		return new OnePlayerPerformanceOfOneSeasonVo(po);
	}// 查找某一球员在某一赛季的比赛信息

	public GeneralInfoOfPlayer getBaseInformationOfOnePlayer(String nameOfPlayer) {
		return this.playerInfoManagementData.getBaseInformationOfOnePlayer(nameOfPlayer);
	}// 根据球员姓名查找某一球员具体基本自然信息

}
