package businesslogicservice.hotsport;

import java.util.ArrayList;

import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;

public interface PlayerHotBlSrevice {
	public ArrayList<PlayerHotInfo> getPlayerHot(int number, String field);// 得到进步最快球员数组

	public ArrayList<PlayerKingInfo> getPlayerKingOfSeason(String field);// 得到赛季数据王数组

	public ArrayList<PlayerKingInfo> getPlayerKingOfDaily(String field);// 得到当日数据王数组
}
