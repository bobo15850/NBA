package common.mydatastructure;

public class GeneralInfoOfPlayer {
	private String playerName;// 姓名
	private String position;// 位置
	private int age;// 年龄
	private String playerNumber;// 球员号码
	private String height;// 身高
	private String weight;// 体重
	private String birthday;// 生日
	private int trainingYear;// 球龄
	private String school;// 毕业学校

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
		return "姓名：" + playerName + "---位置：" + position + "---年龄：" + age + "---号码：" + playerNumber + "---身高：" + height + "---体重：" + weight + "---生日："
				+ birthday + "---球龄：" + trainingYear + "---毕业学校：" + school;
	}

	public String getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getTrainingYear() {
		return trainingYear;
	}

	public void setTrainingYear(int trainingYear) {
		this.trainingYear = trainingYear;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
