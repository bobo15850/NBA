package presentation.hotsport;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import test.data.PlayerKingInfo;
import businesslogic.hotsport.PlayerHotBl;
import businesslogicservice.hotsport.PlayerHotBlSrevice;

import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class PlayerKingPanel extends MyPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String[] content = new String[] { "排名", "头像", "姓名", "位置", "具体值", "球队" };
	protected MyLabel[] contentLable = new MyLabel[6];
	protected final int labelWidth = (int) (NUMBER.px * 200);
	protected final int labelHeight = (int) (NUMBER.px * 100);
	protected final int buttonHeight = (int) (NUMBER.px * 40);
	protected MyLabel[] number = new MyLabel[5];// 序号
	protected MyLabel[] Portrait = new MyLabel[5];// 头像
	protected MyLabel[] name = new MyLabel[5];// 姓名
	protected MyLabel[] position = new MyLabel[5];// 位置
	protected MyLabel[] value = new MyLabel[5];// 属性值
	protected MyLabel[] team = new MyLabel[5];// 球队
	protected PlayerHotBlSrevice playerHotBl = new PlayerHotBl();
	protected ArrayList<PlayerKingInfo> playerKing = new ArrayList<PlayerKingInfo>(5);

	public PlayerKingPanel() {
		this.setLayout(null);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.setVisible(true);
	}

	protected void setContent() {
		for (int i = 0; i < 5; i++) {
			PlayerKingInfo temp = this.playerKing.get(i);
			Portrait[i].setMyIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + temp.getName() + ".png"));
			name[i].setTextAndStyle(temp.getName());
			position[i].setTextAndStyle(temp.getPosition());
			value[i].setTextAndStyle(String.valueOf(temp.getValue()));
			team[i].setTextAndStyle(temp.getTeamName());
		}
	}

	private void setComponentsStyle() {

	}

	private void setComponentsLocation() {
		for (int i = 0; i < 6; i++) {
			contentLable[i].setBounds(labelWidth * (i + 1), buttonHeight * 2, labelWidth, (int) (labelHeight * 0.5));
			this.add(contentLable[i]);
		}
		for (int i = 0; i < 5; i++) {
			number[i].setBounds(labelWidth, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			Portrait[i].setBounds(labelWidth * 2, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			name[i].setBounds(labelWidth * 3, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			position[i].setBounds(labelWidth * 4, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			value[i].setBounds(labelWidth * 5, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			team[i].setBounds(labelWidth * 6, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			this.add(number[i]);
			this.add(Portrait[i]);
			this.add(name[i]);
			this.add(position[i]);
			this.add(value[i]);
			this.add(team[i]);
		}
	}

	private void createObjects() {
		for (int i = 0; i < 5; i++) {
			number[i] = new MyLabel(String.valueOf(i + 1));
			Portrait[i] = new MyLabel("头像");
			name[i] = new MyLabel("姓名");
			position[i] = new MyLabel("位置");
			value[i] = new MyLabel("具体值");
			team[i] = new MyLabel("球队");
		}
		for (int i = 0; i < 6; i++) {
			contentLable[i] = new MyLabel(content[i]);
		}
	}
}
