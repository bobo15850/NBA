package databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import common.statics.ResultMessage;

public class OperationOfPlayersDB {

	private static OperationOfPlayersDB dbOfPlayers = null;
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost:3306/players";
	private String dbUser = "root";
	private String dbPass = "1234";
	private Connection connection;
	private Statement statement;

	private OperationOfPlayersDB() {
		this.connection = this.getConn();
		try {
			this.statement = (Statement) this.connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static OperationOfPlayersDB getConnection() {
		if (dbOfPlayers == null) {
			dbOfPlayers = new OperationOfPlayersDB();
		}
		return dbOfPlayers;
	}// 单件模式，数据库只有一个连接

	private Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			JOptionPane
					.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (SQLException e) {
			JOptionPane
					.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return conn;
	} // 连接数据库

	public ResultMessage createTable(String table, String[] column) {
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("(").append(column[0]);
			for (int i = 1; i < column.length; i++) {
				sql.append(",").append(column[i]);
			}
			sql.append(")");
			this.statement.executeUpdate("CREATE TABLE " + table + " " + sql.toString());
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
	}

	public ResultMessage add(String table, String sql) {
		try {
			this.statement.executeUpdate("INSERT INTO " + table + " " + sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 添加一条记录

	public ResultMessage updata(String table, String sql) {
		try {
			this.statement.executeUpdate("UPDATE " + table + " " + sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 更新一条记录

	public ResultMessage delete(String table, String sql) {
		try {
			this.statement.executeUpdate("DELETE FROM " + table + " " + sql);
			return ResultMessage.SUCCEED;
		} catch (SQLException e) {
			e.printStackTrace();
			return ResultMessage.DB_FAULT;
		}
	}// 删除记录

	public ResultSet find(String table, String sql) {
		try {
			ResultSet result = this.statement.executeQuery("SELECT * FROM " + table + " " + sql);
			return result;// 得到符合条件的集合
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane
					.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			return null;// 数据库连接错误
		}// 根据表格名称和语句查找
	}

	public ResultSet find_all(String table) {
		try {
			ResultSet result = this.statement.executeQuery("SELECT * FROM " + table);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane
					.showMessageDialog(null, "数据库连接失败!请重新启动服务器", "错误", JOptionPane.ERROR_MESSAGE);
			return null;
		}// 根据编号和表格名称查找
	}

}
