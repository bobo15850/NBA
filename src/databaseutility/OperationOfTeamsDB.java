package databaseutility;

import common.statics.ResultMessage;

public class OperationOfTeamsDB extends DB {
	private String createTableString = "(teamNameForShort varchar(16) NOT NULL, " + "date varchar(16) NOT NULL ,season varchar(16) NOT NULL,"
			+ "opponentTeamName varchar(16) NOT NULL ,playingTime varchar(8) NOT NULL,"
			+ "totalHitNumber int NOT NULL ,totalShootNumber int NOT NULL , "
			+ " threePointHitNumber int NOT NULL  , threePointShootNumber int NOT NULL  , "
			+ " freePointHitNumber int NOT NULL  , freePointShootNumber int NOT NULL  ,"
			+ "  offensiveReboundNumber int NOT NULL  ,defensiveReboundNumber int NOT NULL  ,"
			+ "  totalReboundNumber int NOT NULL  ,	 assistNumber int NOT NULL  ," + "  stealNumber int NOT NULL  ,  blockNumber int NOT NULL  ,"
			+ "	turnoverNumber int NOT NULL  , foulNumber int NOT NULL  ," + "scoreNumber int NOT NULL  , PRIMARY KEY (date)) ";// 建表语句
	private static OperationOfTeamsDB dbOfTeams = null;
	private static String DBName = "teams";

	private OperationOfTeamsDB() {
		super(DBName);
	}

	public static OperationOfTeamsDB getTeamDB() {
		if (dbOfTeams == null) {
			dbOfTeams = new OperationOfTeamsDB();
		}
		return dbOfTeams;
	}// 单件模式，数据库只有一个连接

	public ResultMessage createTable(String table) {
		return super.createTable(table, createTableString);
	}// 新建一张表格
}
