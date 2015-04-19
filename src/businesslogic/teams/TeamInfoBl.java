package businesslogic.teams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import test.data.TeamHighInfo;
import businesslogic.CACHE;
import businesslogic.MySort;
import businesslogicservice.teams.TeamInfoBlService;
import common.mydatastructure.SortCell;
import common.mydatastructure.TeamNormalInfo_Expand;

public class TeamInfoBl implements TeamInfoBlService {

	@SuppressWarnings("unchecked")
	public ArrayList<TeamHighInfo> getTeamHigh(int number, SortCell[] sortCells) {
		ArrayList<TeamHighInfo> teamHighList = new ArrayList<TeamHighInfo>();
		for (Entry<String, TeamHighInfo> temp : CACHE.TEAM_HIGH.entrySet()) {
			TeamHighInfo tempHighInfo = temp.getValue();
			teamHighList.add(tempHighInfo);
		}
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		for (int i = 0; i < sortCells.length; i++) {
			sortFields.add(MySort.getBeanComparator(sortCells[i]));
		}
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(teamHighList, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > teamHighList.size()) {
			number = teamHighList.size();
		}
		ArrayList<TeamHighInfo> resultList = new ArrayList<TeamHighInfo>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(teamHighList.get(i));
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TeamNormalInfo_Expand> getTeamNormal_avg(int number, SortCell[] sortCells) {
		ArrayList<TeamNormalInfo_Expand> teamNormalList = new ArrayList<TeamNormalInfo_Expand>();
		for (Entry<String, TeamNormalInfo_Expand> temp : CACHE.TEAM_NORMAL.entrySet()) {
			TeamNormalInfo_Expand tempNormalInfo = temp.getValue().getTeamNormal_avg();
			teamNormalList.add(tempNormalInfo);
		}
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		for (int i = 0; i < sortCells.length; i++) {
			sortFields.add(MySort.getBeanComparator(sortCells[i]));
		}
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(teamNormalList, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > teamNormalList.size()) {
			number = teamNormalList.size();
		}
		ArrayList<TeamNormalInfo_Expand> resultList = new ArrayList<TeamNormalInfo_Expand>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(teamNormalList.get(i));
		}
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<TeamNormalInfo_Expand> getTeamNormal_tot(int number, SortCell[] sortCells) {
		ArrayList<TeamNormalInfo_Expand> teamNormalList = new ArrayList<TeamNormalInfo_Expand>();
		for (Entry<String, TeamNormalInfo_Expand> temp : CACHE.TEAM_NORMAL.entrySet()) {
			TeamNormalInfo_Expand tempNormalInfo = temp.getValue();
			teamNormalList.add(tempNormalInfo);
		}
		ArrayList<BeanComparator> sortFields = new ArrayList<BeanComparator>();// 声明要排序的对象的属性，并指明所使用的排序规则，如果不指明，则用默认排序
		for (int i = 0; i < sortCells.length; i++) {
			sortFields.add(MySort.getBeanComparator(sortCells[i]));
		}
		ComparatorChain comChain = new ComparatorChain(sortFields);// 创建一个排序链
		Collections.sort(teamNormalList, comChain);// 开始真正的排序，按照先主，后副的规则
		if (number > teamNormalList.size()) {
			number = teamNormalList.size();
		}
		ArrayList<TeamNormalInfo_Expand> resultList = new ArrayList<TeamNormalInfo_Expand>(number);
		for (int i = 0; i < number; i++) {
			resultList.add(teamNormalList.get(i));
		}
		return resultList;
	}
}
