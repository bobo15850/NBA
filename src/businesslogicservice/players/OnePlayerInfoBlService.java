package businesslogicservice.players;

import java.util.ArrayList;

import test.data.PlayerHighInfo;

import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;

public interface OnePlayerInfoBlService {
	public GeneralInfoOfPlayer getPlayerGeneralInfo(String playerName);// 得到球员基本信息

	public PlayerNormalInfo_Expand getPlayerNormalInfo_avg(String playerName);// 根据球员名称得到场均普通比赛数据

	public PlayerNormalInfo_Expand getPlayerNormalInfo_tot(String playerName);// 根据球员名称得到总和普通比赛数据

	public PlayerHighInfo getPlayerHighInfo(String playerName);// 根据球员名称得到高级比赛数据

	public ArrayList<PlayerPerformOfOneMatch> getPlayerPerform(String playerName);// 根据球员名称得到所有比赛信息
}
