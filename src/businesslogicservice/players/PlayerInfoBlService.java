package businesslogicservice.players;

import java.util.ArrayList;

import test.data.PlayerHighInfo;
import common.mydatastructure.CombineSelectionCell;
import common.mydatastructure.Filter;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.SortCell;

public interface PlayerInfoBlService {

	public ArrayList<PlayerHighInfo> getPlayerHigh(int number, SortCell[] sortcells);// 得到球员高阶数据

	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_avg(int number, Filter filter, SortCell[] sortcells);// 得到球员平均普通数据

	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_tot(int number, Filter filter, SortCell[] sortcells);// 得到球员总和普通数据

	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_avg(CombineSelectionCell[] combineSelectionCells);// 组合筛选
}
