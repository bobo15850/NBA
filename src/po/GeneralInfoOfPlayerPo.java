package po;

import common.enums.PlayerPosition;
import common.mydatastructure.MyDate;
import common.mydatastructure.Height;
import common.mydatastructure.Weight;

/*
 * 该类是球员的基本自然信息的数据po
 */
public class GeneralInfoOfPlayerPo {
	private String playerName;// 姓名
	private String playerNumber;// 球员号码
	private PlayerPosition position;// 位置
	private Height height;// 身高
	private Weight weight;// 体重
	private MyDate birthday;// 生日
	private int age;// 年龄
	private int trainingYear;// 球龄
	private String school;// 毕业学校

	public void setName(String playerName) {
		this.playerName = playerName;
	}// 设置球员的姓名

	public void setNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}// 设置球员号码

	public void setPosition(PlayerPosition position) {
		this.position = position;
	}// 设置球员的位置

	public void setHeight(Height height) {
		this.height = height;
	}// 设置球员的身高

	public void setWeight(Weight weight) {
		this.weight = weight;
	}// 设置球员的体重

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}// 设置球员的生日

	public void setAge(int age) {
		this.age = age;
	}// 设置球员年龄

	public void setTrainingYear(int trainingYear) {
		this.trainingYear = trainingYear;
	}// 设置球员的球龄

	public void setShool(String school) {
		this.school = school;
	}// 设置球员的毕业学校

	/*
	 * 以上是设置属性的方法；以下下是得到属性的方法
	 */

	public String getName() {
		return this.playerName;
	}// 得到球员的姓名

	public String getNumber() {
		return this.playerNumber;
	}// 得到球员号码

	public PlayerPosition getPosition() {
		return this.position;
	}// 得到球员的位置

	public Height getHeight() {
		return this.height;
	}// 得到球员的身高

	public Weight getWeight() {
		return this.weight;
	}// 得到球员的体重

	public MyDate getBirthday() {
		return this.birthday;
	}// 得到球员的生日

	public int getAge() {
		return this.age;
	}// 得到球员年龄

	public int getTrainingYear() {
		return this.trainingYear;
	}// 得到球员的球龄

	public String getShool() {
		return this.school;
	}// 得到球员的毕业学校

	public String toDBString() {
		String resultString = "(`playerName`, `playerNumber`, `position`," + " `height`, `weight`, `birthday`,"
				+ " `age`, `trainingYear`, `school`) " + " VALUES ('" + this.getName() + "','" + this.getNumber() + "','"
				+ this.getPosition().toString() + "','" + this.getHeight().getFeetAndInchAsStringOfHeight() + "','"
				+ String.valueOf(this.getWeight().getPoundOfWeight()) + "','" + this.getBirthday().getFormatString() + "','" + this.getAge() + "','"
				+ this.getTrainingYear() + "','" + this.getShool() + "')";
		return resultString;
	}
}
