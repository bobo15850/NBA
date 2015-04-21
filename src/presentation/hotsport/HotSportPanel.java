package presentation.hotsport;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.mycomponent.MyButton;
import common.mycomponent.MyPanel;
import common.statics.MyColor;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class HotSportPanel extends MyPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private final int inter = (int) (NUMBER.px * 30);
	private final int buttonWidth = (int) (NUMBER.px * 200);
	private final int buttonHeight = (int) (NUMBER.px * 50);
	private MyButton todayHotPlayer, seasonHotPlayer, seasonHotTeam, mostImprovedPlayer;// 按钮
	private ContentPanel contentPanel;// 内容panel

	HotSportPanel() {
		this.createObjects();
		this.setComponentsLocation();
		this.addListener();
		this.setVisible(true);
		this.repaint();
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
				- NUMBER.NAVIGATION_PANEL_HEIGHT - buttonHeight * 2 - inter);// ////////////////////////
		//
		this.add(todayHotPlayer);
		this.add(seasonHotPlayer);
		this.add(seasonHotTeam);
		this.add(mostImprovedPlayer);
		this.add(contentPanel);
	}

	private void createObjects() {
		todayHotPlayer = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer.png"), buttonWidth, buttonHeight);
		seasonHotPlayer = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer.png"), buttonWidth, buttonHeight);
		seasonHotTeam = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam.png"), buttonWidth, buttonHeight);
		mostImprovedPlayer = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer.png"), buttonWidth, buttonHeight);
		contentPanel = new ContentPanel();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			contentPanel.showDailyPlayerKingPanel();
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			contentPanel.showSeasonPlayerKingPanel();
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			contentPanel.showSeasonTeamKingPanel();
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			contentPanel.showMostImprovedPlayerPanel();
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer_enter.png"));
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer_enter.png"));
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam_enter.png"));
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer_enter.png"));
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer.png"));
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer.png"));
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam.png"));
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer.png"));
		}
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer_click.png"));
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer_click.png"));
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam_click.png"));
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer_click.png"));
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer.png"));
		}
		else if (e.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer.png"));
		}
		else if (e.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam.png"));
		}
		else if (e.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer.png"));
		}
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

	public static void main(String args[]) {
		JFrame j = new JFrame();
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.setBackground(MyColor.LIGHT_COLOR);
		j.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH,
				NUMBER.FRAME_HEIGHT);
		HotSportPanel contentPanel = new HotSportPanel();
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);
	}
}
