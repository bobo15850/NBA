package presentation.hotsport;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import businesslogic.matches.MatchInfoBl;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mydatastructure.MyDate;
import common.statics.MyColor;
import common.statics.NUMBER;

public class HotSportPanel extends MyPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	public static MyLabel showNew = new MyLabel();
	public static MyLabel date = new MyLabel();
	private final int inter = (int) (NUMBER.px * 30);
	private final int buttonWidth = (int) (NUMBER.px * 200);
	private final int buttonHeight = (int) (NUMBER.px * 50);
	private MyButton todayHotPlayer, seasonHotPlayer, seasonHotTeam, mostImprovedPlayer;// 按钮
	private ContentPanel contentPanel;// 内容panel

	public HotSportPanel() {
		this.createObjects();
		this.setComponentsLocation();
		this.addListener();
		MyDate date = new MatchInfoBl().getLatestDate();
		HotSportPanel.refreshDate(date.getFormatString());
		this.setVisible(true);
		this.repaint();
	}

	public static void showNew() {
		showNew.setTextAndStyle("有更新");
	}

	public static void showRefreshed() {
		showNew.setTextAndStyle("");
	}

	public static void refreshDate(String dateString) {
		date.setTextAndStyle(dateString);
	}

	private void addListener() {
		todayHotPlayer.addMouseListener(this);
		seasonHotPlayer.addMouseListener(this);
		seasonHotTeam.addMouseListener(this);
		mostImprovedPlayer.addMouseListener(this);
	}

	private void setComponentsLocation() {
		todayHotPlayer.setBounds((int) (NUMBER.px * 30 + inter + buttonWidth), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		mostImprovedPlayer.setBounds((int) (NUMBER.px * 30 + inter * 2 + buttonWidth * 2), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		seasonHotPlayer.setBounds((int) (NUMBER.px * 30 + inter * 3 + buttonWidth * 3), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		seasonHotTeam.setBounds((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		contentPanel.setBounds(0, (int) (NUMBER.px * 36) + inter + buttonHeight, NUMBER.FRAME_WIDTH - 2 * inter, NUMBER.FRAME_HEIGHT
				- NUMBER.NAVIGATION_PANEL_HEIGHT - buttonHeight * 2 - inter);
		showNew.setBounds((int) (NUMBER.px * 1300), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		date.setBounds((int) (NUMBER.px * 100), (int) (NUMBER.px * 36), buttonWidth, buttonHeight);
		this.add(todayHotPlayer);
		this.add(seasonHotPlayer);
		this.add(seasonHotTeam);
		this.add(mostImprovedPlayer);
		this.add(contentPanel);
		this.add(showNew);
		this.add(date);
	}

	private void createObjects() {
		todayHotPlayer = new MyButton("今日数据王");
		seasonHotPlayer = new MyButton("赛季数据王");
		seasonHotTeam = new MyButton("赛季球队数据王");
		mostImprovedPlayer = new MyButton("进步最快球员");
		this.setButton(todayHotPlayer);
		this.setButton(seasonHotPlayer);
		this.setButton(seasonHotTeam);
		this.setButton(mostImprovedPlayer);
		contentPanel = new ContentPanel();
	}

	private void setButton(JButton button) {
		button.setContentAreaFilled(true);
		button.setBackground(MyColor.MIDDLE_COLOR);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			contentPanel.showDailyPlayerKingPanel();
			todayHotPlayer.setBackground(MyColor.MY_ORIANGE);
			seasonHotPlayer.setBackground(MyColor.MIDDLE_COLOR);
			seasonHotTeam.setBackground(MyColor.MIDDLE_COLOR);
			mostImprovedPlayer.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			contentPanel.showSeasonPlayerKingPanel();
			todayHotPlayer.setBackground(MyColor.MIDDLE_COLOR);
			seasonHotPlayer.setBackground(MyColor.MY_ORIANGE);
			seasonHotTeam.setBackground(MyColor.MIDDLE_COLOR);
			mostImprovedPlayer.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			contentPanel.showSeasonTeamKingPanel();
			todayHotPlayer.setBackground(MyColor.MIDDLE_COLOR);
			seasonHotPlayer.setBackground(MyColor.MIDDLE_COLOR);
			seasonHotTeam.setBackground(MyColor.MY_ORIANGE);
			mostImprovedPlayer.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			contentPanel.showMostImprovedPlayerPanel();
			todayHotPlayer.setBackground(MyColor.MIDDLE_COLOR);
			seasonHotPlayer.setBackground(MyColor.MIDDLE_COLOR);
			seasonHotTeam.setBackground(MyColor.MIDDLE_COLOR);
			mostImprovedPlayer.setBackground(MyColor.MY_ORIANGE);

		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setBorderPainted(true);
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setBorderPainted(true);
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setBorderPainted(true);
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setBorderPainted(true);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setBorderPainted(false);
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setBorderPainted(false);
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setBorderPainted(false);
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setBorderPainted(false);
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	class ContentPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;
		private DailyPlayerKingPanel dailyPlayerKingPanel;
		private SeasonPlayerKingPanel seasonPlayerKingPanel;
		private MostImprovedPlayerPanel mostImprovedPlayerPanel;
		private SeasonTeamKingPanel seasonTeamKingPanel;

		ContentPanel() {
			card = new CardLayout();
			this.setOpaque(false);
			this.setLayout(card);
			//
			dailyPlayerKingPanel = new DailyPlayerKingPanel();
			seasonPlayerKingPanel = new SeasonPlayerKingPanel();
			mostImprovedPlayerPanel = new MostImprovedPlayerPanel();
			seasonTeamKingPanel = new SeasonTeamKingPanel();
			//
			this.add(dailyPlayerKingPanel, "dailyPlayerKingPanel");
			this.add(seasonPlayerKingPanel, "seasonPlayerKingPanel");
			this.add(mostImprovedPlayerPanel, "mostImprovedPlayerPanel");
			this.add(seasonTeamKingPanel, "seasonTeamKingPanel");
		}

		public void showDailyPlayerKingPanel() {
			this.card.show(contentPanel, "dailyPlayerKingPanel");
		}

		public void showSeasonPlayerKingPanel() {
			this.card.show(contentPanel, "seasonPlayerKingPanel");
		}

		public void showMostImprovedPlayerPanel() {
			this.card.show(contentPanel, "mostImprovedPlayerPanel");
		}

		public void showSeasonTeamKingPanel() {
			this.card.show(contentPanel, "seasonTeamKingPanel");
		}
	}
}
