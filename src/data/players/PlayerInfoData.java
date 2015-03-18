package data.players;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import po.GeneralInfoOfPlayerPo;
import po.PlayerPerformanceOfOneMatchPo;
import po.TeamPerformanceOfOneMatchPo;
import common.mydatastructure.Date;
import common.mydatastructure.Height;
import common.mydatastructure.Season;
import common.mydatastructure.Weight;
import common.statics.ResultMessage;
import common.statics.StringToEnum;
import data.teams.TeamInfoData;
import databaseutility.OperationOfGeneralInfoDB;
import databaseutility.OperationOfPlayersDB;
import dataservice.players.PlayerInfoDataService;
import dataservice.teams.TeamInfoDataService;

public class PlayerInfoData implements PlayerInfoDataService {

	private OperationOfGeneralInfoDB generalInfoDB;
	private OperationOfPlayersDB playerDB;

	public PlayerInfoData() {
		generalInfoDB = OperationOfGeneralInfoDB.getGeneralInfo();
		playerDB = OperationOfPlayersDB.getPlayerDB();
	}

	public ArrayList<PlayerPerformanceOfOneMatchPo> getOnePlayerPerformOfOneSeasonPo(String nameOfPlayer, Season season) {
		ArrayList<PlayerPerformanceOfOneMatchPo> poList = new ArrayList<PlayerPerformanceOfOneMatchPo>(128);
		String sql = "where season = '" + season.getFormatStyleOfSeason() + "'";
		ResultSet rs = this.playerDB.find(nameOfPlayer, sql);
		try {
			if (!rs.next()) {
				return null;
			} else {
				rs.first();
				poList.add(this.createPlayerPerformPo(rs));
				while (rs.next()) {
					poList.add(this.createPlayerPerformPo(rs));
				}
				return poList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}// 查找某一球员某一赛季的比赛信息

	private PlayerPerformanceOfOneMatchPo createPlayerPerformPo(ResultSet rs) throws SQLException {
		PlayerPerformanceOfOneMatchPo resultPo = new PlayerPerformanceOfOneMatchPo();
		resultPo.setNameOfPlayer(rs.getString("playerName"));
		resultPo.setDate(new Date(rs.getString("date")));
		resultPo.setSeason(new Season(rs.getString("season")));
		resultPo.setTeamName(rs.getString("teamNameForShort"));
		resultPo.setIsFirst(StringToEnum.ToBoolean(rs.getString("isFirst")));
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
	}// 根据一个集合创建一个po

	public GeneralInfoOfPlayerPo getBaseInformationOfOnePlayer(String nameOfPlayer) {
		GeneralInfoOfPlayerPo generalInfoOfPlayer = new GeneralInfoOfPlayerPo();
		String sql = " where " + "`playerName` = '" + nameOfPlayer + "'";
		ResultSet resultSet = this.generalInfoDB.find("generalinfoofplayer", sql);
		try {
			if (!resultSet.next()) {
				return ResultMessage.NOTEXIST_GENERAL_PLAYER_PO;
			} else {
				resultSet.first();
				return this.createPlayerGeneralInfoPo(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return generalInfoOfPlayer;
	}// 查找某一球员的基本自然信息

	private GeneralInfoOfPlayerPo createPlayerGeneralInfoPo(ResultSet rs) throws SQLException {
		GeneralInfoOfPlayerPo resultPo = new GeneralInfoOfPlayerPo();
		resultPo.setName(rs.getString("playerName"));
		resultPo.setNumber(rs.getString("playerNumber"));
		resultPo.setPosition(StringToEnum.toPosition(rs.getString("position")));
		resultPo.setHeight(new Height(rs.getString("height")));
		resultPo.setWeight(new Weight(rs.getInt("weight")));
		resultPo.setBirthday(new Date(rs.getString("birthday")));
		resultPo.setAge(rs.getInt("age"));
		resultPo.setTrainingYear(rs.getInt("trainingYear"));
		resultPo.setShool(rs.getString("school"));
		return resultPo;
	}// 根据一个集合创建一个球员自然信息的集合

	public ArrayList<String> getNamesOfAllPlayer() {
		return this.playerDB.findAllTableName();
	}// 查找所有球员姓名即为球员比赛信息表的名称

	public ArrayList<TeamPerformanceOfOneMatchPo[]> getOneTeamPerformOfOneSeason(String playerName, Season season) {
		TeamInfoDataService teamPerformData = new TeamInfoData();
		String sql = "where season='" + season.getFormatStyleOfSeason() + "'";
		ResultSet rs = this.playerDB.find(playerName, sql);
		try {
			rs.first();
			String teamNameForShort = rs.getString("teamNameForShort");
			return teamPerformData.getOneTeamPerformOfOneSeason(teamNameForShort, season);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
