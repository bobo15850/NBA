package databaseutility;

public class OperationOfGeneralInfoDB extends DB {
	private static OperationOfGeneralInfoDB dbOfGeneralInfo = null;
	private static String DBName = "generalinfo";

	private OperationOfGeneralInfoDB() {
		super(DBName);
	}

	public static OperationOfGeneralInfoDB getGeneralInfo() {
		if (dbOfGeneralInfo == null) {
			dbOfGeneralInfo = new OperationOfGeneralInfoDB();
		}
		return dbOfGeneralInfo;
	}// 单件模式，数据库只有一个连接
}
