package presentation.hotsport;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import presentation.SonFrame;
import businesslogic.matches.MatchInfoBl;
import common.mycomponent.MyButton;
import common.mydatastructure.MyDate;
import common.statics.Field;
import common.statics.MyColor;
import common.statics.NUMBER;

public class DailyPlayerKingPanel extends PlayerKingPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] fieldString = new String[] { Field.point, Field.rebound, Field.assist, Field.steal, Field.blockShot };
	private MyButton[] fieldButton = new MyButton[5];// 属性按钮
	protected final int buttonWidth = (int) (NUMBER.px * 260);

	public DailyPlayerKingPanel() {
		this.setLayout(null);
		this.createObjects();
		this.setComponentsLocation();
		this.addListener();
		this.init();
		this.setComponentsStyle();
		this.setVisible(true);
	}

	private void init() {
		super.playerKing = this.playerHotBl.getPlayerKingOfDaily(5, fieldString[0]);
		super.setContent();
	}

	private void addListener() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i].addMouseListener(this);
			Portrait[i].addMouseListener(this);
			team[i].addMouseListener(this);
		}
	}

	private void setComponentsStyle() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i].setContentAreaFilled(true);
			fieldButton[i].setBackground(MyColor.MIDDLE_COLOR);
		}
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i].setBounds((int) (buttonWidth * i + NUMBER.px * 60), 0, buttonWidth, buttonHeight);
			this.add(fieldButton[i]);
		}
	}

	private void createObjects() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i] = new MyButton(fieldString[i]);
		}
	}

	public void mouseClicked(MouseEvent e) {

		for (int i = 0; i < 5; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				for (int j = 0; j < 5; j++) {
					fieldButton[j].setBackground(MyColor.MIDDLE_COLOR);
				}
				fieldButton[i].setBackground(MyColor.MY_ORIANGE);
				super.playerKing = super.playerHotBl.getPlayerKingOfDaily(5, fieldString[i]);
				this.setContent();
				HotSportPanel.showRefreshed();
				MyDate date = new MatchInfoBl().getLatestDate();
				HotSportPanel.refreshDate(date.getFormatString());
				break;
			}
			if (e.getSource().equals(Portrait[i])) {
				String playerName = this.playerKing.get(i).getName();
				new SonFrame(playerName, SonFrame.playerCard);
				break;
			}
			if (e.getSource().equals(team[i])) {
				String teamName = this.playerKing.get(i).getTeamName();
				new SonFrame(teamName, SonFrame.teamCard);
				break;
			}
		}

	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 5; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				fieldButton[i].setBorderPainted(true);
				break;
			}
		}
	}

	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < 5; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				fieldButton[i].setBorderPainted(false);
				break;
			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}
