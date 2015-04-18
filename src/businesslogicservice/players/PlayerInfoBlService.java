package businesslogicservice.players;

import java.util.ArrayList;

import vo.GeneralInfoOfPlayerVo;
import vo.OnePlayerPerformOfOneSeasonVo;

import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;
import common.mydatastructure.SelectionCondition;

public interface PlayerInfoBlService {
	// 获取某一个赛季所有球员的比赛信息
	public ArrayList<OnePlayerPerformOfOneSeasonVo> getOneSeasonPerformOfAllPlayer(Season season);

	// 根据某一球员姓名查找其所有赛季比赛信息
	public ArrayList<OnePlayerPerformOfOneSeasonVo> getOnePlayerPerformOfAllSeason(String nameOfPlayer);

	// 查找某一球员在某一赛季的比赛信息
	public OnePlayerPerformOfOneSeasonVo getOnePlayerPerformOfOneSeason(String nameOfPlayer, Season season);

	// 根据球员姓名查找某一球员具体基本自然信息
	public GeneralInfoOfPlayerVo getGeneralInfoOfOnePlayer(String nameOfPlayer);

	// 根据某一项将所有球员某一赛季成绩升序排序
	public void ascendingSort(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind);

	// 根据某一项将所有球员某一赛季成绩降序排序
	public void descendingSort(ArrayList<OnePlayerPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind);

	// 根据球员位置，球员联盟，排序依据进行筛选前50名球员
	public ArrayList<OnePlayerPerformOfOneSeasonVo> selsctPlayer(ArrayList<OnePlayerPerformOfOneSeasonVo> voList,
			SelectionCondition condition, Season season);

}
