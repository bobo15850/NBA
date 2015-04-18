package businesslogicservice.players;

import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import common.mydatastructure.CombineSelectionCell;
import common.mydatastructure.Filter;
import common.mydatastructure.SortCell;

public interface PlayerInfoBlService {

	public PlayerHighInfo[] getPlayerHigh(int number, SortCell[] sortcells);// 得到球员高阶数据

	public PlayerNormalInfo[] getPlayerNormal_avg(int number, Filter filter, SortCell[] sortcells);// 得到球员平均普通数据

	public PlayerNormalInfo[] getPlayerNormal_tot(int number, Filter filter, SortCell[] sortcells);// 得到球员总和普通数据

	public PlayerNormalInfo[] getPlayerNormal_avg(CombineSelectionCell[] combineSelectionCells);// 组合筛选
}
