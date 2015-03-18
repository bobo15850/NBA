package data.teams;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.GeneralInfoOfTeamPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.Date;
import common.mydatastructure.Season;
import common.statics.ResultMessage;
import common.statics.StringToEnum;
import databaseutility.OperationOfGeneralInfoDB;
import databaseutility.OperationOfTeamsDB;
import dataservice.teams.TeamInfoDataService;

public class TeamInfoData implements TeamInfoDataService {
	private OperationOfTeamsDB teamPerformDB = OperationOfTeamsDB.getTeamDB();
	private OperationOfGeneralInfoDB generalInfoDB = OperationOfGeneralInfoDB.getGeneralInfo();

	public ArrayList<TeamPerformanceOfOneMatchPo[]> getOneTeamPerformOfOneSeason(String teamNameForShort, Season season) {
		ArrayList<TeamPerformanceOfOneMatchPo[]> listOfArrayPo = new ArrayList<TeamPerformanceOfOneMatchPo[]>(128);
		String sql = "where season='" + season.getFormatStyleOfSeason() + "'";
		ResultSet rs = this.teamPerformDB.find(teamNameForShort, sql);
		try {
			if (!rs.next()) {
				return null;
			} else {
				rs.first();
				TeamPerformanceOfOneMatchPo[] oneMatch = new TeamPerformanceOfOneMatchPo[2];
				oneMatch[0] = this.createTeamPerformPo(rs);
				listOfArrayPo.add(oneMatch);
				while (rs.next()) {
					TeamPerformanceOfOneMatchPo[] tempMatch = new TeamPerformanceOfOneMatchPo[2];
					tempMatch[0] = this.createTeamPerformPo(rs);
					listOfArrayPo.add(tempMatch);
				}
				for (int i = 0; i < listOfArrayPo.size(); i++) {
					String opponentTeam = listOfArrayPo.get(i)[0].getOpponentTeamNameForShort();
					String date = listOfArrayPo.get(i)[0].getDate().getFormatString();
					String seasonString = listOfArrayPo.get(i)[0].getSeason().getFormatStyleOfSeason();
					String sqlOfSecondTeam = "where season='" + seasonString + "' and date='" + date + "'";
					ResultSet rsOfSecondTeam = this.teamPerformDB.find(opponentTeam, sqlOfSecondTeam);
					rsOfSecondTeam.first();
					listOfArrayPo.get(i)[1] = this.createTeamPerformPo(rsOfSecondTeam);
				}
				return listOfArrayPo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private TeamPerformanceOfOneMatchPo createTeamPerformPo(ResultSet rs) throws SQLException {
		TeamPerformanceOfOneMatchPo resultPo = new TeamPerformanceOfOneMatchPo();
		resultPo.setTeamNameForShort(rs.getString("teamNameForShort"));
		resultPo.setDate(new Date(rs.getString("date")));
		resultPo.setSeason(new Season(rs.getString("season")));
		resultPo.setOpponentTeamName(rs.getString("opponentTeamName"));
		resultPo.setPlayingTime(rs.getDouble("playingTime"));
		resultPo.setTotalHitNumber(rs.getInt("totalHitNumber"));
		resultPo.setTotalShootNumber(rs.getInt("totalShootNumber"));
		resultPo.setThreePointHitNumber(rs.getInt("threePointHitNumber"));
		resultPo.setThreePointShootNumber(rs.getInt("threePointShootNumber"));
		resultPo.setFreePointHitNumber(rs.getInt("freePointHitNumber"));
		resultPo.setFreePointShootNumber(rs.getInt("freePointShootNumber"));
		resultPo.setOffensiveReboundNumber(rs.getInt("offensiveReboundNumber"));
		resultPo.setDefensiveReboundNumber(rs.getInt("defensiveReboundNumber"));
		resultPo.setTotalReboundNumber(rs.getInt("totalReboundNumber"));
		resultPo.setAssistNumber(rs.getInt("assistNumber"));
		resultPo.setStealNumber(rs.getInt("stealNumber"));
		resultPo.setBlockNumber(rs.getInt("blockNumber"));
		resultPo.setTurnoverNumber(rs.getInt("turnoverNumber"));
		resultPo.setFoulNumber(rs.getInt("foulNumber"));
		resultPo.setScoreNumber(rs.getInt("scoreNumber"));
		return resultPo;
	}

	public GeneralInfoOfTeamPo getBaseInformationOfOneTeam(String teamNameForShort) {
		GeneralInfoOfTeamPo generalInfoOfTeam = new GeneralInfoOfTeamPo();
		String sql = "where teamNameForShort = '" + teamNameForShort + "'";
		ResultSet rs = this.generalInfoDB.find("generalinfoofteam", sql);
		try {
			if (!rs.next()) {
				return ResultMessage.NOTEXIST_GENERAL_TEAM_PO;
			} else {
				rs.first();
				return this.createTeamGeneralInfoPo(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generalInfoOfTeam;
	}

	private GeneralInfoOfTeamPo createTeamGeneralInfoPo(ResultSet rs) throws SQLException {
		GeneralInfoOfTeamPo teamPo = new GeneralInfoOfTeamPo();
		teamPo.setTeamName(rs.getString("teamName"));
		teamPo.setTeamNameForShort(rs.getString("teamNameForShort"));
		teamPo.setLocation(rs.getString("location"));
		teamPo.setConference(StringToEnum.toConference(rs.getString("conference")));
		teamPo.setDivision(StringToEnum.toDivision(rs.getString("division")));
		teamPo.setHomeField(rs.getString("homeField"));
		teamPo.setEstablishYear(rs.getInt("establishYear"));
		return teamPo;
	}

	public ArrayList<String> getNamesForShortOfAllTeam() {
		return this.teamPerformDB.findAllTableName();
	}// 查找所有球队的名字

}
