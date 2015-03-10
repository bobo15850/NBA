package common.mydatastructure.player;

import common.enums.PlayerPosition;
import common.mydatastructure.Date;

/*
 * 该类是球员的基本自然信息类
 */
public class BaseInformationOfPlayer {
	private String name;// 姓名
	private PlayerPosition position;// 位置
	private Height height;// 身高
	private Weight weight;// 体重
	private Date birthday;// 生日
	private int trainingYear;// 球龄
	private String school;// 毕业学校

	public BaseInformationOfPlayer(String name, PlayerPosition position, Height height, Weight weight, Date birthday, int trainingYear, String school) {
		this.name = name;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.birthday = birthday;
		this.trainingYear = trainingYear;
		this.school = school;
	}

	public String getName() {
		return this.name;
	}// 得到球员的姓名

	public PlayerPosition getPosition() {
		return this.position;
	}// 得到球员的位置

	public Height getHeight() {
		return this.height;
	}// 得到球员的身高

	public Weight getWeight() {
		return this.weight;
	}// 得到球员的体重

	public Date getBirthday() {
		return this.birthday;
	}// 得到球员的生日

	public int getTrainingYear() {
		return this.trainingYear;
	}// 得到球员的球龄

	public String getShool() {
		return this.school;
	}// 得到球员的毕业学校
}
