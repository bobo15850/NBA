package vo;

import po.GeneralInfoOfPlayerPo;

import common.enums.PlayerPosition;
import common.mydatastructure.MyDate;
import common.mydatastructure.Height;
import common.mydatastructure.Weight;

public class GeneralInfoOfPlayerVo {

	private String playerName = null;// 姓名
	private String playerNumber = null;// 球员号码
	private PlayerPosition position = null;// 位置
	private Height height = null;// 身高
	private Weight weight = null;// 体重
	private MyDate birthday = null;// 生日
	private int age = 0;
	private int trainingYear = 0;// 球龄
	private String school = null;// 毕业学校

	public GeneralInfoOfPlayerVo() {
		// 无参构造函数
	}

	public GeneralInfoOfPlayerVo(GeneralInfoOfPlayerPo po) {
		this.playerName = po.getName();
		this.playerNumber = po.getNumber();
		this.position = po.getPosition();
		this.height = po.getHeight();
		this.weight = po.getWeight();
		this.birthday = po.getBirthday();
		this.trainingYear = po.getTrainingYear();
		this.age = po.getAge();
		this.trainingYear = po.getTrainingYear();
		this.school = po.getShool();
	}// 以po为参数的构造方法

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

	public String[] toStringArray() {
		return new String[] { playerName,// 姓名
				playerNumber,// 球员号码
				position.toString(),// 位置
				height.getFeetAndInchAsStringOfHeight(),// 身高
				String.valueOf(weight.getPoundOfWeight()),// 体重
				birthday.getFormatString(),// 生日
				String.valueOf(age), String.valueOf(trainingYear),// 球龄
				school,// 毕业学校
		};
	}
}
