package presentation.hotsport;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import test.data.PlayerKingInfo;
import businesslogic.hotsport.PlayerHotBl;
import businesslogicservice.hotsport.PlayerHotBlSrevice;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class PlayerKingPanel extends MyPanel {
	private static final long serialVersionUID = 1L;
	protected MyLabel[] contentLable = new MyLabel[6];
	protected final int labelWidth = (int) (NUMBER.px * 200);
	protected final int labelHeight = (int) (NUMBER.px * 100);
	protected final int buttonHeight = (int) (NUMBER.px * 50);
	protected MyLabel[] number = new MyLabel[5];// 序号
	protected MyLabel[] Portrait = new MyLabel[5];// 头像
	protected MyLabel[] name = new MyLabel[5];// 姓名
	protected MyLabel[] position = new MyLabel[5];// 位置
	protected MyLabel[] value = new MyLabel[5];// 属性值
	protected MyLabel[] team = new MyLabel[5];// 球队
	protected MyLabel[][] allLabel = new MyLabel[][] { number, Portrait, name, position, value, team };
	protected PlayerHotBlSrevice playerHotBl = new PlayerHotBl();
	protected ArrayList<PlayerKingInfo> playerKing = new ArrayList<PlayerKingInfo>(5);

	public PlayerKingPanel() {
		this.setLayout(null);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.setVisible(true);
	}

	private void createObjects() {
		for (int k = 0; k < 5; k++) {
			allLabel[0][k] = new MyLabel(String.valueOf(k + 1));
		}
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				allLabel[i][j] = new MyLabel();
			}
		}
	}

	private void setComponentsLocation() {
		Portrait[0].setBounds((int) (NUMBER.px * 50), buttonHeight * 2, (int) (NUMBER.px * 250), (int) (NUMBER.px * 400));
		number[0].setBounds((int) (NUMBER.px * 300), labelHeight + buttonHeight * 2, (int) (NUMBER.px * 100), (int) (NUMBER.px * 100));
		name[0].setBounds((int) (NUMBER.px * 400), labelHeight + buttonHeight * 3, (int) (NUMBER.px * 300), (int) (NUMBER.px * 40));
		position[0].setBounds((int) (NUMBER.px * 400), labelHeight + buttonHeight * 4 + (int) (NUMBER.px * 40), (int) (NUMBER.px * 200),
				(int) (NUMBER.px * 40));
		value[0].setBounds((int) (NUMBER.px * 400), labelHeight + buttonHeight * 5 + 2 * (int) (NUMBER.px * 40), (int) (NUMBER.px * 200),
				(int) (NUMBER.px * 40));
		team[0].setBounds((int) (NUMBER.px * 550), buttonHeight * 2, (int) (NUMBER.px * 80), (int) (NUMBER.px * 80));
		for (int i = 1; i < 5; i++) {
			number[i].setBounds((int) (NUMBER.px * 700), labelHeight * (i - 1) + buttonHeight * 2, labelHeight, labelHeight);
			Portrait[i].setBounds((int) (NUMBER.px * 830), labelHeight * (i - 1) + buttonHeight * 2 + (int) (NUMBER.px * 15), (int) (NUMBER.px * 70),
					(int) (NUMBER.px * 70));
			name[i].setBounds((int) (NUMBER.px * 920), labelHeight * (i - 1) + buttonHeight * 2 + (int) (NUMBER.px * 15), (int) (NUMBER.px * 120),
					(int) (NUMBER.px * 80));
			position[i].setBounds((int) (NUMBER.px * 1070), labelHeight * (i - 1) + buttonHeight * 2 + (int) (NUMBER.px * 15),
					(int) (NUMBER.px * 60), (int) (NUMBER.px * 80));
			value[i].setBounds((int) (NUMBER.px * 1260), labelHeight * (i - 1) + buttonHeight * 2 + (int) (NUMBER.px * 15), (int) (NUMBER.px * 80),
					(int) (NUMBER.px * 80));
			team[i].setBounds((int) (NUMBER.px * 1160), labelHeight * (i - 1) + buttonHeight * 2 + (int) (NUMBER.px * 20), (int) (NUMBER.px * 60),
					(int) (NUMBER.px * 60));
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 5; j++) {
				this.add(allLabel[i][j]);
			}
		}
	}

	protected void setContent() {
		if (playerKing != null) {
			PlayerKingInfo tempIn = this.playerKing.get(0);
			Portrait[0].setMyIcon(new ImageIcon(PathOfFile.PLAYER_ACTION_IMAGE + tempIn.getName() + ".png"));
			name[0].setTextAndStyle(tempIn.getName());
			position[0].setTextAndStyle(tempIn.getPosition());
			value[0].setTextAndStyle("数据为：" + String.valueOf(tempIn.getValue()));
			name[0].setFont(MyFont.LARGE_PLAIN);
			position[0].setFont(MyFont.LARGE_PLAIN);
			value[0].setFont(MyFont.LARGE_PLAIN);
			team[0].setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + tempIn.getTeamName() + ".png"));
			for (int i = 1; i < playerKing.size(); i++) {
				PlayerKingInfo temp = this.playerKing.get(i);
				Portrait[i].setMyIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + temp.getName() + ".png"));
				name[i].setTextAndStyle(temp.getName());
				position[i].setTextAndStyle(temp.getPosition());
				value[i].setTextAndStyle(String.valueOf(temp.getValue()));
				team[i].setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + temp.getTeamName() + ".png"));
			}
		}
	}

	private void setComponentsStyle() {
		number[0].setForeground(MyColor.MIDDLE_COLOR);
		number[0].setFont(new Font("微软雅黑", Font.BOLD, (int) (NUMBER.px * 70)));
		for (int i = 1; i < 5; i++) {
			number[i].setFont(MyFont.LARGE_BOLD);
			number[i].setHorizontalAlignment(SwingConstants.CENTER);
			value[i].setFont(MyFont.SMALL_BOLD);
			value[i].setForeground(MyColor.MIDDLE_COLOR);
		}
	}

}
