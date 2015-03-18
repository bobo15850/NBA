package businesslogic.teams;

import java.text.NumberFormat;
import java.util.ArrayList;

/*
 * 用以计算xx率
 */
public class CalculationOfTeamPerform {
	/**
	 * 计算平均数
	 * @param num 
	 * @param time 
	 * @return
	 */
	public static double average(double num,int time){
		
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(num/time));
	}
	/**
	 * 计算胜率
	 * @param winNum 胜利场数
	 * @param loseNum 失败场数
	 * @return 
	 */
	public static double calWinRate(int winNum,int loseNum){
		double result=0;
		result=winNum/(winNum+loseNum);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
	/**
	 * 计算进攻回合
	 * @param shoot 投篮数
	 * @param foul 球队罚球数
	 * @param offensiveRebound 本队进攻篮板
	 * @param defensiveReboundOfCompetitor 对手防守篮板
	 * @param miss 投失球
	 * @param turnover 失误数
	 * @return
	 */
	public static double calOffensiveNum(int shoot,int foul,int offensiveRebound,int defensiveReboundOfCompetitor,int miss,int turnover){
		double result=0;
		result=shoot+0.4*foul-1.07*(offensiveRebound/(offensiveRebound+defensiveReboundOfCompetitor)*miss)+1.07*turnover;
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
	/**
	 * 计算进攻效率
	 * @param score 得分
	 * @param shoot 投篮数
	 * @param foul 球队罚球数
	 * @param offensiveRebound 本队进攻篮板
	 * @param defensiveReboundOfCompetitor 对手防守篮板
	 * @param miss 投失球
	 * @param turnover 失误数
	 * @return
	 */
	public static double calOffensiveEfficiency(double score,int shoot,int foul,int offensiveRebound,int defensiveReboundOfCompetitor,int miss,int turnover){
		double result=0;
		result=score*100/calOffensiveNum(shoot,foul,offensiveRebound,defensiveReboundOfCompetitor,miss,turnover);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
	/**
	 * 计算防守效率
	 * @param scoreOfCompetitor 对手得分
	 * @param shootOfCompetitor 对手投篮数
	 * @param foulOfCompetitor  对手罚球数
	 * @param offensiveReboundOfCompetitor 对手进攻篮板
	 * @param defensiveRebound  我方防守篮板
	 * @param missOfCompetitor  对手投失球
	 * @param turnoverOfCompetitor 对手失误数
	 * @return
	 */
	public static double calDefensiveEfficiency(double scoreOfCompetitor,int shootOfCompetitor,int foulOfCompetitor,int offensiveReboundOfCompetitor,int defensiveRebound,int missOfCompetitor,int turnoverOfCompetitor){
		double result=0;
		result=scoreOfCompetitor*100/calOffensiveNum(shootOfCompetitor,foulOfCompetitor,offensiveReboundOfCompetitor,defensiveRebound,missOfCompetitor,turnoverOfCompetitor);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
	/**
	 * 计算进攻篮板效率
	 * @param reboundBefore 前场篮板数量(进攻)
	 * @param reboundBehindOfCompetitor 对方后场篮板数量（防守）
	 * @return
	 */
	public static double calOffensiveReboundEfficiency(int reboundBefore,int reboundBehindOfCompetitor){
		double result=0;
		result=reboundBefore/(reboundBefore+reboundBehindOfCompetitor);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
	/**
	 * 计算防守篮板效率
	 * @param reboundBehind 后场篮板数量
	 * @param reboundBeforeOfCompetitor 对手前场篮板数量
	 * @return
	 */
	public static double calDefensiveReboundEfficiency(int reboundBehind,int reboundBeforeOfCompetitor){
		double result=0;
		result=reboundBehind/(reboundBehind+reboundBeforeOfCompetitor);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
	/**
	 * 计算抢断效率
	 * @param steal 抢断数量
	 * @param shootOfCompetitor 对手投篮数
	 * @param foulOfCompetitor  对手罚球数
	 * @param offensiveReboundOfCompetitor 对手进攻篮板
	 * @param defensiveRebound  我方防守篮板
	 * @param missOfCompetitor  对手投失球
	 * @param turnoverOfCompetitor 对手失误数
	 * @return
	 */
	public static double calStealEfficiency(int steal,int shootOfCompetitor,int foulOfCompetitor,int offensiveReboundOfCompetitor,int defensiveRebound,int missOfCompetitor,int turnoverOfCompetitor){
		double result=0;
		result=steal*100/calOffensiveNum(shootOfCompetitor,foulOfCompetitor,offensiveReboundOfCompetitor,defensiveRebound,missOfCompetitor,turnoverOfCompetitor);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));
	}
	/**
	 * 计算助攻率
	 * @param assist 球队助攻数量
	 * @param shoot 投篮数
	 * @param foul 球队罚球数
	 * @param offensiveRebound 本队进攻篮板
	 * @param defensiveReboundOfCompetitor 对手防守篮板
	 * @param miss 投失球
	 * @param turnover 失误数
	 * @return
	 */
	public static double calAssistRate(int assist,int shoot,int foul,int offensiveRebound,int defensiveReboundOfCompetitor,int miss,int turnover){
		double result=0;
		result=assist*100/calOffensiveNum(shoot,foul,offensiveRebound,defensiveReboundOfCompetitor,miss,turnover);
		NumberFormat nf=NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(2);
		return Double.parseDouble(nf.format(result));

	}
}
