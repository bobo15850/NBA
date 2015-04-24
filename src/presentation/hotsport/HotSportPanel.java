package presentation.hotsport;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import businesslogic.matches.MatchInfoBl;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mydatastructure.MyDate;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class HotSportPanel extends MyPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	public static MyLabel showNew = new MyLabel();// 提示更新
	public static MyLabel date = new MyLabel();// 提示日期
	private final int inter = (int) (NUMBER.px * 30);
	private final int buttonWidth = (int) (NUMBER.px * 200);
	private final int buttonHeight = (int) (NUMBER.px * 50);
	private MyButton[] button = new MyButton[] { new MyButton("今日数据王"), new MyButton("赛季数据王"), new MyButton("进步最快球员"), new MyButton("赛季球队数据王") };
	private MyPanel panel[] = new MyPanel[] { new DailyPlayerKingPanel(), new SeasonPlayerKingPanel(), new MostImprovedPlayerPanel(),
			new SeasonTeamKingPanel() };
	private ContentPanel contentPanel = new ContentPanel();
	private int flag = 0;

	public HotSportPanel() {
		this.setComponentStyle();
		this.setComponentsLocation();
		this.addListener();
		MyDate date = new MatchInfoBl().getLatestDate();
		HotSportPanel.refreshDate(date.getFormatString());
		this.setVisible(true);
	}

	public static void showNew() {
		showNew.setTextAndStyle("有更新");
		showNew.setFont(MyFont.SMALL_BOLD);
	}

	public static void showRefreshed() {
		showNew.setTextAndStyle("");
	}

	public static void refreshDate(String dateString) {
		date.setTextAndStyle(dateString);
		date.setFont(MyFont.SMALL_BOLD);
	}

	private void addListener() {
		for (int i = 0; i < 4; i++) {
			button[i].addMouseListener(this);
		}
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 4; i++) {
			button[i].setBounds((int) (inter * (i + 2) + buttonWidth * (i + 1)), inter, buttonWidth, buttonHeight);
			this.add(button[i]);
		}
		contentPanel.setBounds(0, (int) (NUMBER.px * 36) + inter + buttonHeight, NUMBER.FRAME_WIDTH - 2 * inter, NUMBER.FRAME_HEIGHT
				- NUMBER.NAVIGATION_PANEL_HEIGHT - buttonHeight * 2 - inter);
		showNew.setBounds((int) (NUMBER.px * 1300), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		date.setBounds((int) (NUMBER.px * 100), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		this.add(contentPanel);
		this.add(showNew);
		this.add(date);
	}

	private void setComponentStyle() {
		for (int i = 0; i < 4; i++) {
			button[i].setContentAreaFilled(true);
			button[i].setBackground(MyColor.MIDDLE_COLOR);
		}
		button[0].setBackground(MyColor.MY_ORIANGE);

	}

	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 4; i++) {
			if (e.getSource().equals(button[i])) {
				contentPanel.showMyPanel(i);
				button[flag].setBackground(MyColor.MIDDLE_COLOR);
				button[i].setBackground(MyColor.MY_ORIANGE);
				flag = i;
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 4; i++) {
			if (e.getSource().equals(button[i])) {
				button[i].setBackground(MyColor.DEEP_COLOR);
			}
		}
	}

	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < 4; i++) {
			if (e.getSource().equals(button[i])) {
				if (flag == i) {
					button[i].setBackground(MyColor.MY_ORIANGE);
				}
				else {
					button[i].setBackground(MyColor.MIDDLE_COLOR);
				}

			}
		}

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	class ContentPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;

		ContentPanel() {
			card = new CardLayout();
			this.setLayout(card);
			for (int i = 0; i < 4; i++) {
				this.add(panel[i], String.valueOf(i));
			}
		}

		public void showMyPanel(int i) {
			this.card.show(contentPanel, String.valueOf(i));
		}
	}
}
