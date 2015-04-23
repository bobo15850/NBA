package databaseutility;

import test.data.PlayerHighInfo;
import test.data.TeamHighInfo;
import businesslogic.CACHE;
import businesslogic.players.CalculationOfPlayerPerform;
import businesslogic.teams.CalculationOfTeamPerform;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;
import common.statics.NUMBER;
import common.statics.Position;

public class OneMatch_add extends OneMatch_init {
	private boolean isPlayerNormalRefresh = false;
	private boolean isTeamNormalRefresh = false;

	public OneMatch_add(String matchName) {
		super(matchName);
	}

	public void writePlayerPerformToday() {
		CACHE.PLAYER_TODAY.clear();
		for (int i = 0; i < super.listOfFirstTeamPlayerPerformance.size(); i++) {
			PlayerPerformOfOneMatch player = super.listOfFirstTeamPlayerPerformance.get(i);
			CACHE.PLAYER_TODAY.put(player.getName(), player);
		}
		for (int i = 0; i < super.listOfSecondTeamPlayerPerformance.size(); i++) {
			PlayerPerformOfOneMatch player = super.listOfSecondTeamPlayerPerformance.get(i);
			CACHE.PLAYER_TODAY.put(player.getName(), player);
		}
	}// 更新CACHE中的今日球员数据

	public void writeTeamNormalInfoToCACHE() {
		this.writeOneTeamNormalInfoToCACHE(firstTeamPerformance);
		this.writeOneTeamNormalInfoToCACHE(secondTeamPerformance);
		isTeamNormalRefresh = true;
	}// 更新cache中的球队普通信息

	private void writeOneTeamNormalInfoToCACHE(TeamPerformOfOneMatch teamPerform) {
		String teamName = teamPerform.getTeamName();
		if (!CACHE.TEAM_NORMAL.containsKey(teamName)) {
			TeamNormalInfo_Expand teamInfo = new TeamNormalInfo_Expand();
			teamInfo.setTeamName(teamName);
			CACHE.TEAM_NORMAL.put(teamName, teamInfo);
		}
		TeamNormalInfo_Expand teamNormal = CACHE.TEAM_NORMAL.get(teamName);
		teamNormal.setTeamName(teamName);
		teamNormal.setNumOfWin(teamNormal.getNumOfWin() + teamPerform.getWin());
		teamNormal.setAssist(teamNormal.getAssist() + teamPerform.getAssist());
		teamNormal.setBlockShot(teamNormal.getBlockShot() + teamPerform.getBlock());
		teamNormal.setDefendRebound(teamNormal.getDefendRebound() + teamPerform.getDefendRebound());
		teamNormal.setFault(teamNormal.getFault() + teamPerform.getFault());
		teamNormal.setFoul(teamNormal.getFoul() + teamPerform.getFoul());
		teamNormal.setFreeHit(teamNormal.getFreeHit() + teamPerform.getFreeHit());
		teamNormal.setFreeShot(teamNormal.getFreeShot() + teamPerform.getFreeShot());
		teamNormal.setNumOfGame(teamNormal.getNumOfGame() + 1);
		teamNormal.setOffendRebound(teamNormal.getOffendRebound() + teamPerform.getOffendRebound());
		teamNormal.setPoint(teamNormal.getPoint() + teamPerform.getPoint());
		teamNormal.setRebound(teamNormal.getRebound() + teamPerform.getRebound());
		teamNormal.setSteal(teamNormal.getSteal() + teamPerform.getSteal());
		teamNormal.setThreeHit(teamNormal.getThreeHit() + teamPerform.getThreeHit());
		teamNormal.setThreeShot(teamNormal.getThreeShot() + teamPerform.getThreeShot());
		teamNormal.setTotalHit(teamNormal.getTotalHit() + teamPerform.getTotalHit());
		teamNormal.setTotalShot(teamNormal.getTotalShot() + teamPerform.getTotalShot());
		teamNormal.setPenalty(CalculationOfPlayerPerform.calHitRate(teamNormal.getFreeHit(), teamNormal.getFreeShot()));
		teamNormal.setShot(CalculationOfPlayerPerform.calHitRate(teamNormal.getTotalHit(), teamNormal.getTotalShot()));
		teamNormal.setThree(CalculationOfPlayerPerform.calHitRate(teamNormal.getThreeHit(), teamNormal.getThreeShot()));
		this.isTeamNormalRefresh = true;
	}

	public void writePlayerNormalInfoToCACHE() {
		for (int i = 0; i < listOfFirstTeamPlayerPerformance.size(); i++) {
			PlayerPerformOfOneMatch playerPerform = listOfFirstTeamPlayerPerformance.get(i);
			if (playerPerform != null) {
				this.writeOnePlayerNormalInfoToCACHE(playerPerform);
			}

		}
		for (int i = 0; i < listOfSecondTeamPlayerPerformance.size(); i++) {
			PlayerPerformOfOneMatch playerPerform = listOfSecondTeamPlayerPerformance.get(i);
			if (playerPerform != null) {
				this.writeOnePlayerNormalInfoToCACHE(playerPerform);
			}
		}
		this.isPlayerNormalRefresh = true;
	}// 更新cache中的球员普通信息

	private void writeOnePlayerNormalInfoToCACHE(PlayerPerformOfOneMatch playerPerform) {

		String playerName = playerPerform.getName();
		int doubleOfOneMatch = 0;
		int doubleTwo = 0;
		int tripleTwo = 0;
		if (playerPerform.getPoint() >= 9.9) {
			doubleOfOneMatch++;
		}
		if (playerPerform.getRebound() >= 9.9) {
			doubleOfOneMatch++;
		}
		if (playerPerform.getAssist() >= 9.9) {
			doubleOfOneMatch++;
		}
		if (playerPerform.getBlockShot() >= 9.9) {
			doubleOfOneMatch++;
		}
		if (playerPerform.getSteal() >= 9.9) {
			doubleOfOneMatch++;
		}
		if (doubleOfOneMatch >= 2) {
			doubleTwo = 1;
		}
		else if (doubleOfOneMatch >= 3) {
			tripleTwo = 1;
		}
		if (!CACHE.PLAYER_NORMAL.containsKey(playerName)) {
			PlayerNormalInfo_Expand playerInfo = new PlayerNormalInfo_Expand();
			if (MEM.PLAYER_GENERALINFO.containsKey(playerName)) {
				playerInfo.setAge(MEM.PLAYER_GENERALINFO.get(playerName).getAge());
			}
			else {
				playerInfo.setAge(NUMBER.UNKNOWN_AGE);
			}
			playerInfo.setName(playerName);
			CACHE.PLAYER_NORMAL.put(playerName, playerInfo);
		}

		PlayerNormalInfo_Expand playerNormal = CACHE.PLAYER_NORMAL.get(playerName);
		playerNormal.setTeamName(playerPerform.getTeamName());
		playerNormal.setAssist(playerNormal.getAssist() + playerPerform.getAssist());
		playerNormal.setBlockShot(playerNormal.getBlockShot() + playerPerform.getBlockShot());
		playerNormal.setDefend(playerNormal.getDefend() + playerPerform.getDefendRebound());
		playerNormal.setFault(playerNormal.getFault() + playerPerform.getFault());
		playerNormal.setFoul(playerNormal.getFoul() + playerPerform.getFoul());
		playerNormal.setFreeHit(playerNormal.getFreeHit() + playerPerform.getFreeHit());
		playerNormal.setFreeShot(playerNormal.getFreehot() + playerPerform.getFreeShot());
		playerNormal.setMinute(playerNormal.getMinute() + playerPerform.getMinute());
		playerNormal.setNumOfGame(playerNormal.getNumOfGame() + 1);
		playerNormal.setOffend(playerNormal.getOffend() + playerPerform.getOffendRebound());
		playerNormal.setPoint(playerNormal.getPoint() + playerPerform.getPoint());
		playerNormal.setRebound(playerNormal.getRebound() + playerPerform.getRebound());
		playerNormal.setStart(playerNormal.getStart() + playerPerform.getStart());
		playerNormal.setSteal(playerNormal.getSteal() + playerPerform.getSteal());
		playerNormal.setThreeHit(playerNormal.getThreeHit() + playerPerform.getThreeHit());
		playerNormal.setThreeShot(playerNormal.getThreeShot() + playerPerform.getThreeShot());
		playerNormal.setTotalHit(playerNormal.getTotalHit() + playerPerform.getTotalHit());
		playerNormal.setTotalShot(playerNormal.getTotalShot() + playerPerform.getTotalShoot());
		playerNormal.setTripleTwo(playerNormal.getTripleTwo() + tripleTwo);
		playerNormal.setDoubleTwo(playerNormal.getDoubleTwo() + doubleTwo);
		playerNormal.setPenalty(CalculationOfTeamPerform.calHitRate(playerNormal.getFreeHit(), playerNormal.getFreehot()));
		playerNormal.setShot(CalculationOfTeamPerform.calHitRate(playerNormal.getTotalHit(), playerNormal.getTotalShot()));
		playerNormal.setThree(CalculationOfTeamPerform.calHitRate(playerNormal.getThreeHit(), playerNormal.getThreeShot()));
		playerNormal.setEfficiency(CalculationOfPlayerPerform.calEfficiency(playerNormal.getPoint(), playerNormal.getRebound(),
				playerNormal.getAssist(), playerNormal.getSteal(), playerNormal.getBlockShot(), playerNormal.getThreeShot(),
				playerNormal.getTotalHit(), playerNormal.getFreehot(), playerNormal.getFreeHit(), playerNormal.getFault(),
				playerNormal.getNumOfGame()));
	}

	public void writeTeamHighInfoToCACHE() {
		if (isTeamNormalRefresh) {
			if (!CACHE.TEAM_HIGH.containsKey(firstTeam)) {
				TeamHighInfo firstTeamHighInfo = new TeamHighInfo();
				firstTeamHighInfo.setTeamName(firstTeam);
				CACHE.TEAM_HIGH.put(firstTeam, firstTeamHighInfo);
			}
			if (!CACHE.TEAM_HIGH.containsKey(secondTeam)) {
				TeamHighInfo secondTeamHighInfo = new TeamHighInfo();
				secondTeamHighInfo.setTeamName(secondTeam);
				CACHE.TEAM_HIGH.put(secondTeam, secondTeamHighInfo);
			}
			TeamHighInfo firstTeamHigh = CACHE.TEAM_HIGH.get(firstTeam);
			TeamHighInfo secondTeamHigh = CACHE.TEAM_HIGH.get(secondTeam);
			TeamNormalInfo_Expand firstTeamNormal = CACHE.TEAM_NORMAL.get(firstTeam);
			TeamNormalInfo_Expand secondTeamNormal = CACHE.TEAM_NORMAL.get(secondTeam);
			//
			firstTeamHigh.setWinRate(CalculationOfTeamPerform.calWinRate(firstTeamNormal.getNumOfWin(), firstTeamNormal.getNumOfGame()));
			firstTeamHigh.setAssistEfficient(CalculationOfTeamPerform.calAssistRate(firstTeamNormal.getAssist(), firstTeamNormal.getTotalShot(),
					firstTeamNormal.getFoul(), firstTeamNormal.getOffendRebound(), secondTeamNormal.getDefendRebound(),
					firstTeamNormal.getTotalShot() - firstTeamNormal.getTotalHit(), firstTeamNormal.getFault()));
			//
			firstTeamHigh
					.setDefendEfficient(CalculationOfTeamPerform.calDefensiveEfficiency(secondTeamNormal.getPoint(), secondTeamNormal.getTotalShot(),
							secondTeamNormal.getFoul(), secondTeamNormal.getOffendRebound(), firstTeamNormal.getDefendRebound(),
							secondTeamNormal.getTotalShot() - secondTeamNormal.getTotalHit(), secondTeamNormal.getFault()));
			//
			firstTeamHigh.setDefendReboundEfficient(CalculationOfTeamPerform.calDefensiveReboundEfficiency(firstTeamNormal.getDefendRebound(),
					secondTeamNormal.getOffendRebound()));
			//
			firstTeamHigh.setOffendEfficient(CalculationOfTeamPerform.calOffensiveEfficiency(firstTeamNormal.getPoint(),
					firstTeamNormal.getTotalShot(), firstTeamNormal.getFoul(), firstTeamNormal.getOffendRebound(),
					secondTeamNormal.getDefendRebound(), firstTeamNormal.getTotalShot() - firstTeamNormal.getTotalHit(), firstTeamNormal.getFault()));
			//
			firstTeamHigh.setOffendReboundEfficient(CalculationOfTeamPerform.calOffensiveReboundEfficiency(firstTeamNormal.getOffendRebound(),
					secondTeamNormal.getDefendRebound()));
			//
			firstTeamHigh.setOffendRound(CalculationOfTeamPerform.calOffensiveNum(firstTeamNormal.getTotalShot(), firstTeamNormal.getFoul(),
					firstTeamNormal.getOffendRebound(), secondTeamNormal.getDefendRebound(),
					firstTeamNormal.getTotalShot() - firstTeamNormal.getTotalHit(), firstTeamNormal.getFault()));
			//
			firstTeamHigh.setStealEfficient(CalculationOfTeamPerform.calStealEfficiency(firstTeamNormal.getSteal(), secondTeamNormal.getTotalShot(),
					secondTeamNormal.getFoul(), secondTeamNormal.getOffendRebound(), firstTeamNormal.getDefendRebound(),
					secondTeamNormal.getTotalShot() - secondTeamNormal.getTotalHit(), secondTeamNormal.getFault()));
			//
			/*
			 * 
			 */
			secondTeamHigh.setWinRate(CalculationOfTeamPerform.calWinRate(secondTeamNormal.getNumOfWin(), secondTeamNormal.getNumOfGame()));
			secondTeamHigh.setAssistEfficient(CalculationOfTeamPerform.calAssistRate(secondTeamNormal.getAssist(), secondTeamNormal.getTotalShot(),
					secondTeamNormal.getFoul(), secondTeamNormal.getOffendRebound(), firstTeamNormal.getDefendRebound(),
					secondTeamNormal.getTotalShot() - secondTeamNormal.getTotalHit(), secondTeamNormal.getFault()));
			//
			secondTeamHigh.setDefendEfficient(CalculationOfTeamPerform.calDefensiveEfficiency(firstTeamNormal.getPoint(),
					firstTeamNormal.getTotalShot(), firstTeamNormal.getFoul(), firstTeamNormal.getOffendRebound(),
					secondTeamNormal.getDefendRebound(), firstTeamNormal.getTotalShot() - firstTeamNormal.getTotalHit(), firstTeamNormal.getFault()));
			//
			secondTeamHigh.setDefendReboundEfficient(CalculationOfTeamPerform.calDefensiveReboundEfficiency(secondTeamNormal.getDefendRebound(),
					firstTeamNormal.getOffendRebound()));
			//
			secondTeamHigh
					.setOffendEfficient(CalculationOfTeamPerform.calOffensiveEfficiency(secondTeamNormal.getPoint(), secondTeamNormal.getTotalShot(),
							secondTeamNormal.getFoul(), secondTeamNormal.getOffendRebound(), firstTeamNormal.getDefendRebound(),
							secondTeamNormal.getTotalShot() - secondTeamNormal.getTotalHit(), secondTeamNormal.getFault()));
			//
			secondTeamHigh.setOffendReboundEfficient(CalculationOfTeamPerform.calOffensiveReboundEfficiency(secondTeamNormal.getOffendRebound(),
					firstTeamNormal.getDefendRebound()));
			//
			secondTeamHigh.setOffendRound(CalculationOfTeamPerform.calOffensiveNum(secondTeamNormal.getTotalShot(), secondTeamNormal.getFoul(),
					secondTeamNormal.getOffendRebound(), firstTeamNormal.getDefendRebound(),
					secondTeamNormal.getTotalShot() - secondTeamNormal.getTotalHit(), secondTeamNormal.getFault()));
			//
			secondTeamHigh.setStealEfficient(CalculationOfTeamPerform.calStealEfficiency(secondTeamNormal.getSteal(), firstTeamNormal.getTotalShot(),
					firstTeamNormal.getFoul(), firstTeamNormal.getOffendRebound(), secondTeamNormal.getDefendRebound(),
					firstTeamNormal.getTotalShot() - firstTeamNormal.getTotalHit(), firstTeamNormal.getFault()));

		}
	}// 更新cache中的球队高级信息

	public void writePlayerHighInfoToCACHE() {
		if (isPlayerNormalRefresh && isTeamNormalRefresh) {
			TeamNormalInfo_Expand firstTeamNormal = CACHE.TEAM_NORMAL.get(firstTeam);
			TeamNormalInfo_Expand secondTeamNormal = CACHE.TEAM_NORMAL.get(secondTeam);
			for (int i = 0; i < listOfFirstTeamPlayerPerformance.size(); i++) {
				if (listOfFirstTeamPlayerPerformance.get(i) != null) {
					PlayerNormalInfo_Expand playerNormal = CACHE.PLAYER_NORMAL.get(listOfFirstTeamPlayerPerformance.get(i).getName());
					this.writeOnePlayerHighInfoToCACHE(playerNormal, firstTeamNormal, secondTeamNormal);
				}

			}
			for (int i = 0; i < listOfSecondTeamPlayerPerformance.size(); i++) {
				if (listOfSecondTeamPlayerPerformance.get(i) != null) {
					PlayerNormalInfo_Expand playerNormal = CACHE.PLAYER_NORMAL.get(listOfSecondTeamPlayerPerformance.get(i).getName());
					this.writeOnePlayerHighInfoToCACHE(playerNormal, secondTeamNormal, firstTeamNormal);
				}

			}
		}
	}// 更新cache中的球员高级信息

	private void writeOnePlayerHighInfoToCACHE(PlayerNormalInfo_Expand playerNml, TeamNormalInfo_Expand selfTeamNml, TeamNormalInfo_Expand oppTeamNml) {
		if (!CACHE.PLAYER_HIGH.containsKey(playerNml.getName())) {
			PlayerHighInfo playerHigh = new PlayerHighInfo();
			playerHigh.setName(playerNml.getName());
			if (MEM.PLAYER_GENERALINFO.containsKey(playerNml.getName())) {
				playerHigh.setPosition(MEM.PLAYER_GENERALINFO.get(playerNml.getName()).getPosition());
			}
			else {
				playerHigh.setPosition(Position.UNKUOWN_POSITION);
			}
			CACHE.PLAYER_HIGH.put(playerHigh.getName(), playerHigh);
		}
		PlayerHighInfo playerH = CACHE.PLAYER_HIGH.get(playerNml.getName());
		playerH.setTeamName(playerNml.getTeamName());
		playerH.setLeague(MEM.TEAM_LEAGUE.get(playerNml.getTeamName()));
		/*
		 * 
		 */
		playerH.setGmSc(CalculationOfPlayerPerform.calGmSc(playerNml.getPoint(), playerNml.getTotalHit(), playerNml.getTotalShot(),
				playerNml.getFreehot(), playerNml.getFreeHit(), playerNml.getOffend(), playerNml.getDefend(), playerNml.getSteal(),
				playerNml.getAssist(), playerNml.getBlockShot(), playerNml.getFoul(), playerNml.getFault(), playerNml.getNumOfGame()));
		//
		playerH.setShotEfficient(CalculationOfPlayerPerform.calShotEfficiency(playerNml.getTotalHit(), playerNml.getThreeHit(),
				playerNml.getTotalShot()));
		//
		playerH.setRealShot(CalculationOfPlayerPerform.calRealShot(playerNml.getPoint(), playerNml.getTotalShot(), playerNml.getFreehot()));

		playerH.setOffendReboundEfficient(CalculationOfPlayerPerform.calReboundEfficient(playerNml.getOffend(), selfTeamNml.getMinute(),
				playerNml.getMinute(), selfTeamNml.getOffendRebound(), oppTeamNml.getDefendRebound()));
		//
		playerH.setDefendReboundEfficient(CalculationOfPlayerPerform.calReboundEfficient(playerNml.getDefend(), selfTeamNml.getMinute(),
				playerNml.getMinute(), selfTeamNml.getDefendRebound(), oppTeamNml.getOffendRebound()));
		//
		playerH.setReboundEfficient(CalculationOfPlayerPerform.calReboundEfficient(playerNml.getRebound(), selfTeamNml.getMinute(),
				playerNml.getMinute(), selfTeamNml.getRebound(), oppTeamNml.getRebound()));
		//
		playerH.setAssistEfficient(CalculationOfPlayerPerform.calAssistEfficient(playerNml.getAssist(), playerNml.getMinute(),
				selfTeamNml.getMinute(), selfTeamNml.getTotalHit(), playerNml.getTotalHit()));
		//
		playerH.setStealEfficient(CalculationOfPlayerPerform.calStealEfficient(playerNml.getSteal(), selfTeamNml.getMinute(), playerNml.getMinute(),
				oppTeamNml.getOffendRebound()));
		//
		playerH.setBlockShotEfficient(CalculationOfPlayerPerform.calBlockShotEfficient(playerNml.getBlockShot(), selfTeamNml.getMinute(),
				playerNml.getMinute(), oppTeamNml.getTotalShot() - oppTeamNml.getThreeShot()));
		//
		// ///////////////////////////////////////////////////////////////////////////
		playerH.setFaultEfficient(CalculationOfPlayerPerform.calFaultEfficient(playerNml.getFault(),
				playerNml.getTotalShot() - playerNml.getThreeShot(), playerNml.getFreehot()));
		//
		// ///////////////////////////////////////////////////////////////////////////
		playerH.setFrequency(CalculationOfPlayerPerform.calFrequency(playerNml.getTotalShot(), playerNml.getFreehot(), playerNml.getFoul(),
				selfTeamNml.getMinute(), playerNml.getMinute(), selfTeamNml.getTotalShot(), selfTeamNml.getFreeShot(), selfTeamNml.getFault()));
	}
}
