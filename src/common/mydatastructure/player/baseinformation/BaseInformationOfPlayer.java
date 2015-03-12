package common.mydatastructure.player.baseinformation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;

import common.enums.PlayerPosition;
import common.mydatastructure.Date;
import common.statics.PathOfFile;

/*
 * 该类是球员的基本自然信息类
 */
public class BaseInformationOfPlayer {
	private String name;// 姓名
	private String playerNumber;// 球员号码
	private ImageIcon portraitImageIcon;// 半身头像
	private ImageIcon actionImageIcon;// 全身像
	private PlayerPosition position;// 位置
	private Height height;// 身高
	private Weight weight;// 体重
	private Date birthday;// 生日
	private int trainingYear;// 球龄
	private String school;// 毕业学校

	public BaseInformationOfPlayer(String name) {
		this.name = name;
		this.portraitImageIcon = new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + name + ".png");
		this.actionImageIcon = new ImageIcon(PathOfFile.PLAYER_ACTION_IMAGE + name + ".png");
		this.init(name);
	}

	// //////////////////////////////////////////////////////该方法待编辑
	// TODO
	private void init(String name) {
		try {
			BufferedReader bufferedreader = new BufferedReader(new FileReader(PathOfFile.PLAYER_INFO + name));
			String temp;
			while ((temp = bufferedreader.readLine()) != null) {
				System.out.println(temp);
			}
			bufferedreader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// //////////////////////////////////////////////////////////////////

	public ImageIcon getPortraitImageIcon() {
		return this.portraitImageIcon;
	}// 得到球员头像

	public ImageIcon getActionImageIcon() {
		return this.actionImageIcon;
	}// 得到全身像

	public String getName() {
		return this.name;
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
