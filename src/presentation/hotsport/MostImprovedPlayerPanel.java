package presentation.hotsport;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import test.data.PlayerHotInfo;
import businesslogic.hotsport.PlayerHotBl;
import businesslogicservice.hotsport.PlayerHotBlSrevice;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.statics.Field;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class MostImprovedPlayerPanel extends MyPanel implements MouseListener {

	//
	private String[] fieldString = new String[] { Field.point, Field.rebound, Field.assist, Field.steal, Field.blockShot };
	private String[] content = new String[] { "排名", "头像", "姓名", "近五场提升率", "位置", "具体值", "球队" };
	private MyLabel[] contentLable = new MyLabel[7];
	private final int labelWidth = (int) (NUMBER.px * 180);
	private final int labelHeight = (int) (NUMBER.px * 100);
	private final int buttonWidth = (int) (NUMBER.px * 200);
	private final int buttonHeight = (int) (NUMBER.px * 40);
	private MyButton[] fieldButton = new MyButton[5];// 属性按钮
	private MyLabel[] number = new MyLabel[5];// 排名
	private MyLabel[] Portrait = new MyLabel[5];// 头像
	private MyLabel[] name = new MyLabel[5];// 姓名
	private MyLabel[] upgrade = new MyLabel[5];// 近五场提升率
	private MyLabel[] position = new MyLabel[5];// 位置
	private MyLabel[] value = new MyLabel[5];// 属性值
	private MyLabel[] team = new MyLabel[5];// 球队
	private PlayerHotBlSrevice playerHotBl = new PlayerHotBl();
	private ArrayList<PlayerHotInfo> playerHotList = new ArrayList<PlayerHotInfo>(5);

	private static final long serialVersionUID = 1L;

	public MostImprovedPlayerPanel() {
		this.setLayout(null);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
		this.setVisible(true);
		this.init();
	}

	private void createObjects() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i] = new MyButton(fieldString[i]);
			number[i] = new MyLabel(String.valueOf(i + 1));
			upgrade[i] = new MyLabel();
			Portrait[i] = new MyLabel("头像");
			name[i] = new MyLabel("姓名");
			position[i] = new MyLabel("位置");
			value[i] = new MyLabel("具体值");
			team[i] = new MyLabel("球队");
		}
		for (int i = 0; i < 7; i++) {
			contentLable[i] = new MyLabel(content[i]);
		}
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 7; i++) {
			contentLable[i].setBounds(labelWidth * (i + 1), buttonHeight * 2, labelWidth, (int) (labelHeight * 0.5));
			this.add(contentLable[i]);
		}
		for (int i = 0; i < 5; i++) {
			fieldButton[i].setBounds((int) (buttonWidth * (i + 0.5)), 0, buttonWidth, buttonHeight);
			number[i].setBounds(labelWidth, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			Portrait[i].setBounds(labelWidth * 2, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			name[i].setBounds(labelWidth * 3, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			upgrade[i].setBounds(labelWidth * 4, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			position[i].setBounds(labelWidth * 5, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			value[i].setBounds(labelWidth * 6, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			team[i].setBounds(labelWidth * 7, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			this.add(fieldButton[i]);
			this.add(number[i]);
			this.add(Portrait[i]);
			this.add(name[i]);
			this.add(upgrade[i]);
			this.add(position[i]);
			this.add(value[i]);
			this.add(team[i]);
		}
	}

	private void setComponentsStyle() {

	}

	private void addListener() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i].addMouseListener(this);
		}
	}

	private void init() {
		playerHotList = this.playerHotBl.getPlayerHot(5, fieldString[0]);
		this.setContent();
	}

	private void setContent() {
		for (int i = 0; i < 5; i++) {
			PlayerHotInfo temp = this.playerHotList.get(i);
			Portrait[i].setMyIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + temp.getName() + ".png"));
			name[i].setTextAndStyle(temp.getName());
			upgrade[i].setTextAndStyle(String.valueOf(temp.getUpgradeRate()));
			position[i].setTextAndStyle(temp.getPosition());
			value[i].setTextAndStyle(String.valueOf(temp.getValue()));
			team[i].setTextAndStyle(temp.getTeamName());
		}
	}

	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 5; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				this.playerHotList = this.playerHotBl.getPlayerHot(5, fieldString[i]);
				break;
			}
		}
		this.setContent();

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
