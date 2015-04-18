package businesslogic.players;

import test.data.PlayerHighInfo;
import test.data.PlayerHotInfo;
import test.data.PlayerKingInfo;
import test.data.PlayerNormalInfo;

import common.mydatastructure.Filter;
import common.mydatastructure.SortCell;

import businesslogicservice.players.PlayerInfoBlService;

public class PlayerInfoBl implements PlayerInfoBlService{

	@Override
	public PlayerHotInfo[] getPlayerHot(int number, String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerKingInfo[] getPlayerKingOfSeason(String field) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerKingInfo[] getPlayerKingOfDaily(String field) {
		// TODO Auto-generated method stub
		return null;
	}

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
