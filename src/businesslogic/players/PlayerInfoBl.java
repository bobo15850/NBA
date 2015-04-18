package businesslogic.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import test.data.PlayerHighInfo;
import test.data.PlayerNormalInfo;
import businesslogic.CACHE;
import businesslogic.MySort;
import businesslogicservice.players.PlayerInfoBlService;
import common.mydatastructure.CombineSelectionCell;
import common.mydatastructure.Filter;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.SortCell;

public class PlayerInfoBl implements PlayerInfoBlService {
	@SuppressWarnings("unchecked")
	public ArrayList<PlayerHighInfo> getPlayerHigh(int number, SortCell[] sortCells) {
		ArrayList<PlayerHighInfo> playerHighList = new ArrayList<PlayerHighInfo>(512);// 合格的球员链表
		for (Entry<String, PlayerHighInfo> temp : CACHE.PLAYER_HIGH.entrySet()) {
			PlayerHighInfo tempHighInfo = temp.getValue();
			PlayerNormalInfo tempNormalInfo = CACHE.PLAYER_NORMAL.get(tempHighInfo.getName());
			if (tempNormalInfo.getMinute() / tempNormalInfo.getNumOfGame() >= 15) {
				playerHighList.add(tempHighInfo);
			}
		}// 筛选出合格的球员，根据上场时间筛选，>=15分钟为合格
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		for (int i = 0; i < sortCells.length; i++) {
			sortFields.add(MySort.getBeanComparator(sortCells[i]));
		}
		ComparatorChain multiSort = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(playerHighList, multiSort);// 开始真正的排序，按照先主，后副的规则
		ArrayList<PlayerHighInfo> resultList = new ArrayList<PlayerHighInfo>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(playerHighList.get(i));
		}
		return resultList;
	}// 得到球员的高级数据

	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_avg(int number, Filter filter, SortCell[] sortcells) {

		return null;
	}

	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_tot(int number, Filter filter, SortCell[] sortcells) {

		return null;
	}

	public ArrayList<PlayerNormalInfo_Expand> getPlayerNormal_avg(CombineSelectionCell[] combineSelectionCells) {
		return null;
	}

}
