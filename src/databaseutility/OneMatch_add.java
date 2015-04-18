package databaseutility;

import businesslogic.CACHE;
import businesslogic.players.CalculationOfPlayerPerform;

import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;

public class OneMatch_add extends OneMatch_init {
	private boolean isPlayerNormalRefresh = false;
	private boolean isTeamNormalRefresh = false;

	public OneMatch_add(String matchName) {
		super(matchName);
	}

	public void writeTeamNormalInfoToCACHE() {
		if (CACHE.TEAM_NORMAL.containsKey(firstTeam)) {
			this.RefreshTeamNormalToCACHE(super.firstTeamPerformance);
		}
		else {
			this.addTeamNormalToCACHE(super.firstTeamPerformance);
		}
		if (CACHE.TEAM_NORMAL.containsKey(secondTeam)) {
			this.RefreshTeamNormalToCACHE(super.secondTeamPerformance);
		}
		else {
			this.addTeamNormalToCACHE(super.secondTeamPerformance);
		}
		isTeamNormalRefresh = true;
	}// 更新cache中的球队普通信息

	private void addTeamNormalToCACHE(TeamPerformOfOneMatch teamPerformPo) {
		TeamNormalInfo_Expand teamInfo = new TeamNormalInfo_Expand();
		String teamNameForShort = teamPerformPo.getTeamNameForShort();
		teamInfo.setTeamName(teamNameForShort);
		teamInfo.setNumOfGame(1);
		teamInfo.setPoint(teamPerformPo.getScoreNumber());
		teamInfo.setRebound(teamPerformPo.getTotalReboundNumber());
		teamInfo.setOffendRebound(teamPerformPo.getOffendReboundNumber());
		teamInfo.setDefendRebound(teamPerformPo.getDefendReboundNumber());
		teamInfo.setAssist(teamPerformPo.getAssistNumber());
		teamInfo.setSteal(teamPerformPo.getStealNumber());
		teamInfo.setBlockShot(teamPerformPo.getBlockNumber());
		teamInfo.setFault(teamPerformPo.getFaultNumber());
		teamInfo.setFoul(teamPerformPo.getFoulNumber());
		teamInfo.setShot(CalculationOfPlayerPerform.calHitRate(teamPerformPo.getTotalHitNumber(), teamPerformPo.getTotalShootNumber()));
		teamInfo.setThree(CalculationOfPlayerPerform.calHitRate(teamPerformPo.getThreePointHitNumber(), teamPerformPo.getThreePointShootNumber()));
		teamInfo.setPenalty(CalculationOfPlayerPerform.calHitRate(teamPerformPo.getFreePointHitNumber(), teamPerformPo.getFreePointShootNumber()));
		CACHE.TEAM_NORMAL.put(teamNameForShort, teamInfo);
	}

	private void RefreshTeamNormalToCACHE(TeamPerformOfOneMatch teamPerformPo) {
		// String teamNameForShort = teamPerformPo.getTeamNameForShort();
		// TeamNormalInfo_Expand teamInfo = CACHE.TEAM_NORMAL.get(teamNameForShort);

	}

	public void writePlayerNormalInfoToCACHE() {
		this.isPlayerNormalRefresh = true;
	}// 更新cache中的球员普通信息

	public void writeTeamHighInfoToCACHE() {
		if (isTeamNormalRefresh) {

		}
	}// 更新cache中的球队高级信息

	public void writePlayerHighInfoToCACHE() {
		if (isPlayerNormalRefresh && isTeamNormalRefresh) {

		}
	}// 更新cache中的球员高级信息

}
