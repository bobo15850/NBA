package databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import common.statics.ResultMessage;

public class OperationOfTeamsDB {
	private String createTableString = "(teamNameForShort varchar(255) NOT NULL, "
			+ "date varchar(255) NOT NULL ,season varchar(255) NOT NULL,"
			+ "opponentTeamName varchar(255) NOT NULL ,playingTime double NOT NULL,"
			+ "totalHitNumber int NOT NULL ,totalShootNumber int NOT NULL , "
			+ " threePointHitNumber int NOT NULL  , threePointShootNumber int NOT NULL  , "
			+ " freePointHitNumber int NOT NULL  , freePointShootNumber int NOT NULL  ,"
			+ "  offensiveReboundNumber int NOT NULL  ,defensiveReboundNumber int NOT NULL  ,"
			+ "  totalReboundNumber int NOT NULL  ,	 assistNumber int NOT NULL  ,"
			+ "  stealNumber int NOT NULL  ,  blockNumber int NOT NULL  ,"
			+ "	turnoverNumber int NOT NULL  , foulNumber int NOT NULL  ,"
			+ "scoreNumber int NOT NULL  , PRIMARY KEY (teamNameForShort, date)) ";// 建表语句
	private static OperationOfTeamsDB dbOfTeams = null;
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/teams";
	private String dbUser = "root";
	private String dbPass = "1234";
	private Connection connection;
	private Statement statement;

	private OperationOfTeamsDB() {
		this.connection = this.getConn();
		try {
			this.statement = (Statement) this.connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static OperationOfTeamsDB getTeamDB() {
		if (dbOfTeams == null) {
			dbOfTeams = new OperationOfTeamsDB();
		}
		return dbOfTeams;
	}// 单件模式，数据库只有一个连接

	private Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return conn;
	} // 连接数据库

	public ResultMessage createTable(String table) {
		try {
			this.statement.executeUpdate("CREATE TABLE `teams`.`" + table + "` " + this.createTableString);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 新建一张表格

	public ResultMessage isTableExist(String table) {
		ResultSet rs;
		try {
			rs = connection.getMetaData().getTables(null, null, table, null);
			if (rs.next()) {
				return ResultMessage.EXIST;
			} else {
				return ResultMessage.NOT_EXIST;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 判断表格是否存在

	public ResultMessage add(String table, String sql) {
		try {
			this.statement.executeUpdate("INSERT INTO `teams`.`" + table + "` " + sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 添加一条记录

	public ResultMessage updata(String table, String sql) {
		try {
			this.statement.executeUpdate("UPDATE `teams`.`" + table + "` " + sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 更新一条记录

	public ResultMessage delete(String table, String sql) {
		try {
			this.statement.executeUpdate("DELETE FROM `teams`.`" + table + "` " + sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 删除记录

	public ResultSet find(String table, String sql) {
		try {
			ResultSet result = this.statement.executeQuery("SELECT * FROM `teams`.`" + table + "` " + sql);
			return result;// 得到符合条件的集合
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			return null;// 数据库连接错误
		}// 根据表格名称和语句查找
	}

	public ResultSet find_all(String table) {
		try {
			ResultSet result = this.statement.executeQuery("SELECT * FROM `teams`.`" + table + "` ");
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			return null;
		}// 根据编号和表格名称查找
	}

	public ArrayList<String> findAllTableName() {
		try {
			ArrayList<String> nameList = new ArrayList<>(512);
			ResultSet rs = connection.getMetaData().getTables(null, null, null, new String[] { "TABLE" });
			if (!rs.next()) {
				return null;
			} else {
				rs.first();
				nameList.add(rs.getString("table_name"));
				while (rs.next()) {
					nameList.add(rs.getString("table_name"));
				}
				return nameList;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
}
