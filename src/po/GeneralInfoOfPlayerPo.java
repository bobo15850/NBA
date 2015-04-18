package po;

public class GeneralInfoOfPlayerPo {
	private String playerName;// 姓名
	private String position;// 位置
	private int age;// 年龄

	public void setName(String playerName) {
		this.playerName = playerName;
	}// 设置球员的姓名

	public String getName() {
		return this.playerName;
	}// 得到球员的姓名

	public void setPosition(String position) {
		this.position = position;
	}// 设置球员的位置

	public String getPosition() {
		return this.position;
	}// 得到球员的位置

	public void setAge(int age) {
		this.age = age;
	}// 设置球员年龄

	public int getAge() {
		return this.age;
	}// 得到球员年龄

	public String toString() {
		return "姓名：" + playerName + "---位置：" + position + "---年龄：" + age;
	}
}
