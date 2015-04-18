package businesslogic.players;

import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import businesslogicservice.players.PlayerInfoBlService;
import common.mydatastructure.CombineSelectionCell;
import common.mydatastructure.Filter;
import common.mydatastructure.SortCell;

public class PlayerInfoBl implements PlayerInfoBlService {

	public PlayerHighInfo[] getPlayerHigh(int number, SortCell[] sortcells) {
		PlayerHighInfo[] playerHighArray = new PlayerHighInfo[number];

		return null;
	}// 得到球员的高级数据

	public PlayerNormalInfo[] getPlayerNormal_avg(int number, Filter filter, SortCell[] sortcells) {

		return null;
	}

	public PlayerNormalInfo[] getPlayerNormal_tot(int number, Filter filter, SortCell[] sortcells) {

		return null;
	}

	@Override
	public PlayerNormalInfo[] getPlayerNormal_avg(CombineSelectionCell[] combineSelectionCells) {
		// TODO Auto-generated method stub
		return null;
	}

}
