package businesslogicservice.hotsport;

import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;

public interface PlayerHotBlSrevice {
	public PlayerHotInfo[] getPlayerHot(int number, String field);// 得到进步最快球员数组

	public PlayerKingInfo[] getPlayerKingOfSeason(String field);// 得到赛季数据王数组

	public PlayerKingInfo[] getPlayerKingOfDaily(String field);// 得到当日数据王数组
}
