package businesslogic.teams;

import java.util.ArrayList;

import po.GeneralInfoOfTeamPo;
import po.TeamPerformanceOfOneMatchPo;
import vo.GeneralInfoOfTeamVo;
import vo.OneTeamPerformOfOneSeasonVo;
import businesslogic.players.CalculationOfPlayerPerform;
import businesslogicservice.teams.TeamInfoBlService;
import common.enums.PerformanceOfPlayer;
import common.mydatastructure.Season;
import data.teams.TeamInfoData;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoBl implements TeamInfoBlService {
	private TeamInfoDataService teamInfoData;

	public TeamInfoBl() {
		teamInfoData = new TeamInfoData();
	}
	
	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneSeasonPerformOfAllTeam(Season season) {
		ArrayList<OneTeamPerformOfOneSeasonVo> resultVo = new ArrayList<OneTeamPerformOfOneSeasonVo>(32);
		ArrayList<String> nameOfAllTeam = this.teamInfoData.getNamesOfAllTeam();
		OneTeamPerformOfOneSeasonVo tempOfOneTeamVo;
		String tempName;
		for (int i = 0; i < nameOfAllTeam.size(); i++) {
			tempName = nameOfAllTeam.get(i);
			tempOfOneTeamVo = this.getOneTeamPerformOfOneSeason(tempName, season);
			resultVo.add(tempOfOneTeamVo);
		}
		return resultVo;
	}// 获取某一个赛季所有球队的比赛信息

	public ArrayList<OneTeamPerformOfOneSeasonVo> getOneTeamPerformOfAllSeason(String teamName) {
		return null;
	}// 根据某一球队名称查找其所有赛季比赛信息

	
	public OneTeamPerformOfOneSeasonVo getOneTeamPerformOfOneSeason(String teamName, Season season) {
		ArrayList<TeamPerformanceOfOneMatchPo[]> poList= this.teamInfoData.getOneTeamPerformOfOneSeason(teamName, season);
		
		if(poList==null){
			return null;
		}else{
			OneTeamPerformOfOneSeasonVo resultVo=new OneTeamPerformOfOneSeasonVo();
			String teamNameStr=null;
			int numberOfMatch=0;// 比赛场数
			//胜利场数
			int winNumber=0;
			int totalHitNumber=0;// 总命中数
			int totalShootNumber=0;// 总出手数
			int threePointHitNumber=0;// 三分命中数
			int threePointShootNumber=0;// 三分出手数
			int freePointHitNumber=0;// 罚球命中数
			int freePointShootNumber=0;// 罚球出手数
			int offensiveReboundNumber=0;// 进攻篮板数
			int defensiveReboundNumber=0;// 防守篮板数
			//对手的防守篮板数
			int defensiveReboundOfCompetitor=0;
			int totalReboundNumber=0;// 总篮板
			int assistNumber=0;// 总助攻
			int stealNumber=0;// 抢断数
			int blockNumber=0;// 盖帽数
			int turnoverNumber=0;// 失误数
			int foulNumber=0;// 犯规数
			int scoreNumber=0;// 得分数
			//对手得分
			int scoreOfCompetitor=0; 
			//对手总出手数
			int shootOfCompetitor=0; 
			//对手犯规数
			int foulOfCompetitor=0;
			//对手进攻篮板数
			int offensiveReboundOfCompetitor=0;
			//对手总命中数
			int hitOfCompetitor=0;
			//对手失误数
			int turnoverOfCompetitor=0;
			
			for(int i=0;i<poList.size();i++){
				numberOfMatch++;
				TeamPerformanceOfOneMatchPo ourSide=poList.get(i)[0];
				TeamPerformanceOfOneMatchPo competitor=poList.get(i)[1];
				if(ourSide.getScoreNumber()>competitor.getScoreNumber()){
					winNumber++;
				}
				totalHitNumber+=ourSide.getTotalHitNumber();
				totalShootNumber+=ourSide.getTotalShootNumber();
				threePointHitNumber+=ourSide.getThreePointHitNumber();
				threePointShootNumber+=ourSide.getThreePointShootNumber();
				freePointHitNumber+=ourSide.getFreePointHitNumber();
				freePointShootNumber+=ourSide.getFreePointShootNumber();
				offensiveReboundNumber+=ourSide.getOffensiveReboundNumber();
				defensiveReboundNumber+=ourSide.getDefensiveReboundNumber();
				defensiveReboundOfCompetitor+=competitor.getDefensiveReboundNumber();
				totalReboundNumber+=ourSide.getTotalReboundNumber();
				assistNumber+=ourSide.getAssistNumber();
				stealNumber+=ourSide.getStealNumber();
				blockNumber+=ourSide.getBlockNumber();
				turnoverNumber+=ourSide.getTurnoverNumber();
				foulNumber+=ourSide.getFoulNumber();
				scoreNumber+=ourSide.getScoreNumber();
				scoreOfCompetitor+=competitor.getScoreNumber();
				shootOfCompetitor+=competitor.getTotalShootNumber();
				foulOfCompetitor+=competitor.getFoulNumber();
				offensiveReboundOfCompetitor+=competitor.getOffensiveReboundNumber();
				hitOfCompetitor+=competitor.getTotalHitNumber();
				turnoverOfCompetitor+=competitor.getTurnoverNumber();

			}
			//球队名称
			resultVo.setTeamName(poList.get(0)[0].getTeamName());
			//比赛场数
			resultVo.setNumberOfMatch(numberOfMatch);
			//投篮命中数
			resultVo.setTotalHitNumber(totalHitNumber);
			//投篮出手数
			resultVo.setTotalShootNumber(totalShootNumber);
			//三分命中数
			resultVo.setThreePointHitNumber(threePointHitNumber);
			//三分出手数
			resultVo.setThreePointShootNumber(threePointShootNumber);
			//罚球命中数
			resultVo.setFreePointHitNumber(freePointHitNumber);
			//罚球出手数
			resultVo.setFreePointShootNumber(freePointShootNumber);
			//进攻篮板数
			resultVo.setOffensiveReboundNumber(offensiveReboundNumber);
			//防守篮板数
			resultVo.setDefensiveReboundNumber(defensiveReboundNumber);
			//篮板数
			resultVo.setTotalReboundNumber(totalReboundNumber);
			//助攻数
			resultVo.setAssistNumber(assistNumber);
			//抢断数
			resultVo.setStealNumber(stealNumber);
			//盖帽数
			resultVo.setBlockNumber(blockNumber);
			//失误数
			resultVo.setTurnoverNumber(turnoverNumber);
			//犯规数
			resultVo.setFoulNumber(foulNumber);
			//比赛得分
			resultVo.setScoreNumber(scoreNumber);
			//场均命中数
			resultVo.setAverageTotalHitNumber(CalculationOfTeamPerform.average(totalHitNumber,numberOfMatch));
			//场均总出手数
			resultVo.setAverageTotalShootNumber(CalculationOfTeamPerform.average(totalShootNumber, numberOfMatch));
			//场均三分命中数
			resultVo.setAverageThreePointHitNumber(CalculationOfTeamPerform.average(threePointHitNumber, numberOfMatch));
			//场均三分出手数
			resultVo.setAverageThreePointShootNumber(CalculationOfTeamPerform.average(threePointShootNumber, numberOfMatch));
			//场均罚球命中数
			resultVo.setAverageFreePointHitNumber(CalculationOfTeamPerform.average(freePointHitNumber, numberOfMatch));
			//场均罚球出手数
			resultVo.setAverageFreePointShootNumber(CalculationOfTeamPerform.average(freePointShootNumber, numberOfMatch));
			//场均进攻篮板数
			resultVo.setAverageOffensiveReboundNumber(CalculationOfTeamPerform.average(offensiveReboundNumber, numberOfMatch));
			//场均防守篮板数
			resultVo.setAverageDefensiveReboundNumber(CalculationOfTeamPerform.average(defensiveReboundNumber, numberOfMatch));
			//场均总篮板
			resultVo.setAverageTotalReboundNumber(CalculationOfTeamPerform.average(totalReboundNumber, numberOfMatch));
			//场均助攻数
			resultVo.setAverageAssistNumber(CalculationOfTeamPerform.average(assistNumber, numberOfMatch));
			//场均抢断数
			resultVo.setAverageStealNumber(CalculationOfTeamPerform.average(stealNumber, numberOfMatch));
			//场均盖帽数
			resultVo.setAverageBlockNumber(CalculationOfTeamPerform.average(blockNumber, numberOfMatch));
			//场均失误数
			resultVo.setAverageTurnoverNumber(CalculationOfTeamPerform.average(turnoverNumber, numberOfMatch));
			//场均犯规数
			resultVo.setAverageFoulNumber(CalculationOfTeamPerform.average(foulNumber, numberOfMatch));
			//场均得分数
			resultVo.setAverageScoreNumber(CalculationOfTeamPerform.average(scoreNumber, numberOfMatch));
			//场均进攻回合
			resultVo.setAverageOffensiveNumber(CalculationOfTeamPerform.calOffensiveNum(totalShootNumber, freePointShootNumber, offensiveReboundNumber, defensiveReboundOfCompetitor, totalShootNumber-totalHitNumber, turnoverNumber));
			//投篮命中率
			resultVo.setTotalHitRate(CalculationOfPlayerPerform.calHitRate(totalHitNumber, totalShootNumber));
			//三分命中率
			resultVo.setThreePointHitRate(CalculationOfPlayerPerform.calHitRate(threePointHitNumber, threePointShootNumber));
			//罚球命中率
			resultVo.setFreePointHitRate(CalculationOfPlayerPerform.calHitRate(freePointHitNumber, freePointShootNumber));
			//胜率
			resultVo.setWinRate(CalculationOfTeamPerform.calWinRate(winNumber, numberOfMatch-winNumber));
			//进攻效率
			resultVo.setOffensiveEfficiency(CalculationOfTeamPerform.calOffensiveEfficiency(scoreNumber, totalShootNumber, freePointShootNumber, offensiveReboundNumber, defensiveReboundOfCompetitor, totalShootNumber-totalHitNumber, turnoverNumber));
			//防守效率
			resultVo.setDefensiveEfficiency(CalculationOfTeamPerform.calDefensiveEfficiency(scoreOfCompetitor, shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor, defensiveReboundNumber, shootOfCompetitor-hitOfCompetitor, turnoverOfCompetitor));
			//篮板效率
		//	resultVo.setReboundEfficiency(CalculationOfTeamPerform.);
			//抢断率
			resultVo.setStealEfficiency(CalculationOfTeamPerform.calStealEfficiency(stealNumber, shootOfCompetitor, foulOfCompetitor, offensiveReboundOfCompetitor, defensiveReboundNumber, shootOfCompetitor-hitOfCompetitor, turnoverOfCompetitor));
			//助攻率
			resultVo.setAssistEfficiency(CalculationOfTeamPerform.calAssistRate(assistNumber, totalShootNumber, freePointShootNumber, offensiveReboundNumber, defensiveReboundOfCompetitor,totalShootNumber-totalHitNumber, turnoverNumber));
			
			return resultVo;
		}
	}// 查找某一球队在某一赛季的比赛信息

	public GeneralInfoOfTeamVo getBaseInformationOfOneTeam(String teamName) {
		GeneralInfoOfTeamPo po = this.teamInfoData.getBaseInformationOfOneTeam(teamName);
		GeneralInfoOfTeamVo vo = new GeneralInfoOfTeamVo(po);
		return vo;
	}// 根据球队姓名查找某一球队具体基本自然信息

	public void ascendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {

	}// 根据某一项将所有球队某一赛季成绩升序排序

	public void descendingSort(ArrayList<OneTeamPerformOfOneSeasonVo> voList, PerformanceOfPlayer dataKind) {

	}// 根据某一项将所有球队某一赛季成绩降序排序
}
