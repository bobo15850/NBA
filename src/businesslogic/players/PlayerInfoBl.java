package businesslogic.players;

import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.NamesOfAllPlayerPo;
import po.OnePlayerPerformanceOfOneSeasonPo;
import vo.AllPlayerPerformanceOfOneSeasonVo;
import vo.OnePlayerPerformanceOfAllSeasonVo;
import vo.OnePlayerPerformanceOfOneSeasonVo;
import businesslogicservice.players.PlayerInfoBlService;
import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;
import data.players.PlayerInfoData;
import dataservice.players.PlayerInfoDataService;

/*
 * 该类为球员信息管理的业务逻辑类运用相应的data层接口为界面层提供接口，
 */
public class PlayerInfoBl implements PlayerInfoBlService {
	private PlayerInfoDataService playerInfoData;

	public PlayerInfoBl() {
		this.playerInfoData = new PlayerInfoData();
	}

	public AllPlayerPerformanceOfOneSeasonVo getAllPlayerPerformanceOfOneSeason(Season season) {
		NamesOfAllPlayerPo namesOfPlayer = playerInfoData.getNamesOfAllPlayer();
		ArrayList<OnePlayerPerformanceOfOneSeasonVo> listOfOnePlayerPerformanceOfOneSeason = new ArrayList<OnePlayerPerformanceOfOneSeasonVo>();
		listOfOnePlayerPerformanceOfOneSeason.add(new OnePlayerPerformanceOfOneSeasonVo(playerInfoData.getOnePlayerPerformanceOfOneSeasonPo(namesOfPlayer.first(), season)));
		while (namesOfPlayer.hasNext()) {
			listOfOnePlayerPerformanceOfOneSeason.add(new OnePlayerPerformanceOfOneSeasonVo(playerInfoData.getOnePlayerPerformanceOfOneSeasonPo(namesOfPlayer.next(), season)));
		}
		return new AllPlayerPerformanceOfOneSeasonVo(season, listOfOnePlayerPerformanceOfOneSeason);
	}// 获取某一个赛季所有球员的比赛信息

	public OnePlayerPerformanceOfAllSeasonVo getOnePlayerInformationOfAllSeason(String nameOfPlayer) {
		return new OnePlayerPerformanceOfAllSeasonVo(nameOfPlayer);
	}// 根据某一球员姓名查找其所有赛季比赛信息

	public OnePlayerPerformanceOfOneSeasonVo getOnePlayerPerformanceOfOneSeason(String nameOfPlayer, Season season) {
		OnePlayerPerformanceOfOneSeasonPo po = this.playerInfoData.getOnePlayerPerformanceOfOneSeasonPo(nameOfPlayer, season);
		return new OnePlayerPerformanceOfOneSeasonVo(po);
	}// 查找某一球员在某一赛季的比赛信息

	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer) {
		return this.playerInfoData.getBaseInformationOfOnePlayer(nameOfPlayer);
	}// 根据球员姓名查找某一球员具体基本自然信息

	public void ascendingSort(AllPlayerPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind) {
		vo.ascendingSort(dataKind);
	}// 根据某一项将所有球员某一赛季成绩升序排序

	public void descendingSort(AllPlayerPerformanceOfOneSeasonVo vo, PerformanceOfPlayer dataKind) {
		vo.ascendingSort(dataKind);
	}// 根据某一项将所有球员某一赛季成绩降序排序

}
