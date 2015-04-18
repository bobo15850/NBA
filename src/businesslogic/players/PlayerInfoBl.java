package businesslogic.players;

import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import businesslogicservice.players.PlayerInfoBlService;

import common.mydatastructure.Filter;
import common.mydatastructure.SortCell;

public class PlayerInfoBl implements PlayerInfoBlService {

	@Override
	public PlayerHighInfo[] getPlayerHigh(int number, SortCell[] sortcells) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerNormalInfo[] getPlayerNormal_avg(int number, Filter filter, SortCell[] sortcells) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerNormalInfo[] getPlayerNormal_tot(int number, Filter filter, SortCell[] sortcells) {
		// TODO Auto-generated method stub
		return null;
	}

}
