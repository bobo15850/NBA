package databaseutility;

import common.statics.ResultMessage;

public class OperationOfPlayersDB extends DB {
	private String createTableString = "(playerName varchar(64) NOT NULL ,date varchar(16) NOT NULL ,"
			+ "season varchar(16) NOT NULL,teamNameForShort varchar(8) NOT NULL ,isFirst varchar(8) NOT NULL ,"
			+ "playingTime varchar(8) NOT NULL ,totalHitNumber int NOT NULL ," + "totalShootNumber int NOT NULL ,threePointHitNumber int NOT NULL ,"
			+ "threePointShootNumber int NOT NULL ,freePointHitNumber int NOT NULL ,"
			+ "freePointShootNumber int NOT NULL ,offensiveReboundNumber int NOT NULL ,"
			+ "defensiveReboundNumber int NOT NULL ,totalReboundNumber int NOT NULL ," + "assistNumber int NOT NULL ,stealNumber int NOT NULL ,"
			+ "blockNumber int NOT NULL ,turnoverNumber int NOT NULL ," + "foulNumber int NOT NULL , scoreNumber int NOT NULL,PRIMARY KEY (date))";
	private static OperationOfPlayersDB dbOfPlayers = null;
	private static String DBName = "players";

	private OperationOfPlayersDB() {
		super(DBName);
	}

	public static OperationOfPlayersDB getPlayerDB() {
		if (dbOfPlayers == null) {
			dbOfPlayers = new OperationOfPlayersDB();
		}
		return dbOfPlayers;
	}// 单件模式，数据库只有一个连接

	public ResultMessage createTable(String table) {
		return super.createTable(table, createTableString);
	}// 新建一张表格

}
