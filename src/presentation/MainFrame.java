package presentation;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.hotsport.HotSportPanel;
import presentation.match.MatchPanel;
import presentation.players.PlayerPanel;
import presentation.teams.TeamPanel;
import common.mycomponent.MyButton;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame = this;
	private NavigationPanel navigationPanel;// 导航栏
	private ContentPanel contentPanel;// 内容栏

	public MainFrame() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(MyColor.BACKGROUNDCOLOR);
		this.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH,
				NUMBER.FRAME_HEIGHT);
		navigationPanel = new NavigationPanel();
		navigationPanel.setBounds(0, 0, NUMBER.NAVIGATION_PANEL_WIDTH, NUMBER.NAVIGATION_PANEL_HEIGHT);
		this.add(navigationPanel);
		contentPanel = new ContentPanel();
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, (NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT));
		this.add(contentPanel);
		this.setVisible(true);
	}

	class ContentPanel extends JPanel {
		/**
		 * 展示类
		 */
		private static final long serialVersionUID = 1L;
		private CardLayout card;// 卡片布局管理器
		private PlayerPanel playerPanel;// 球员界面
		private TeamPanel teamPanel;// 球队界面
		private MatchPanel matchPanel;// 比赛界面
		private HotSportPanel hotSportPanel;// 热点界面

		ContentPanel() {
			card = new CardLayout();
			this.setOpaque(false);
			this.setLayout(card);
			//
			playerPanel = new PlayerPanel();
			teamPanel = new TeamPanel();
			matchPanel = new MatchPanel();
			hotSportPanel = new HotSportPanel();

			this.add(playerPanel, "playerPanel");
			this.add(teamPanel, "teamPanel");
			this.add(matchPanel, "matchPanel");
			this.add(hotSportPanel, "hotSportPanel");
			this.setVisible(true);
		}

		public void showPlayerPanel() {
			this.card.show(contentPanel, "playerPanel");
			navigationPanel.addCurrentInfo("球员数据");
		}

		public void showTeamPanel() {
			this.card.show(contentPanel, "teamPanel");
			navigationPanel.addCurrentInfo("球队数据");
		}

		public void showMatchPanel() {
			this.card.show(contentPanel, "matchPanel");
			navigationPanel.addCurrentInfo("比赛数据");
		}

		public void showHotPanel() {
			this.card.show(contentPanel, "hotSportPanel");
			navigationPanel.addCurrentInfo("热点查询");
		}
	}

	class NavigationPanel extends JPanel implements MouseListener {
		/**
		 * 导航栏
		 */
		private static final long serialVersionUID = 1L;
		private JLabel currentPanelLabel;
		private JButton quitSystem, playerPanelButton, teamPanelButton, matchPanelButton, hotSportPanelButton;

		public NavigationPanel() {
			this.setLayout(null);
			this.setBackground(MyColor.MIDDLE_COLOR);
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.addListener();
			this.setVisible(true);

		}

		public void addCurrentInfo(String string) {
			currentPanelLabel.setText(string);
		}

		private void createObjects() {
			currentPanelLabel = new JLabel("球员数据");
			quitSystem = new MyButton("退出系统");
			playerPanelButton = new MyButton("球员数据");
			teamPanelButton = new MyButton("球队数据");
			matchPanelButton = new MyButton("比赛信息");
			hotSportPanelButton = new MyButton("热点查询");

		}

		private void setComponentsLocation() {
			currentPanelLabel.setBounds((int) (NUMBER.px * 50), (NUMBER.NAVIGATION_PANEL_HEIGHT - (int) (NUMBER.px * 100)) / 2,
					(int) (NUMBER.px * 200), (int) (NUMBER.px * 100));
			playerPanelButton.setBounds((int) (NUMBER.px * 340), (int) (NUMBER.px * 17), (int) (NUMBER.px * 160), (int) (NUMBER.px * 50));
			teamPanelButton.setBounds((int) (NUMBER.px * 520), (int) (NUMBER.px * 17), (int) (NUMBER.px * 160), (int) (NUMBER.px * 50));
			matchPanelButton.setBounds((int) (NUMBER.px * 700), (int) (NUMBER.px * 17), (int) (NUMBER.px * 160), (int) (NUMBER.px * 50));
			hotSportPanelButton.setBounds((int) (NUMBER.px * 880), (int) (NUMBER.px * 17), (int) (NUMBER.px * 160), (int) (NUMBER.px * 50));
			quitSystem.setBounds((int) (NUMBER.px * 1060), (int) (NUMBER.px * 17), (int) (NUMBER.px * 160), (int) (NUMBER.px * 50));
			this.add(currentPanelLabel);
			this.add(teamPanelButton);
			this.add(playerPanelButton);
			this.add(matchPanelButton);
			this.add(hotSportPanelButton);
			this.add(quitSystem);
		}

		private void setComponentsStyle() {
			currentPanelLabel.setFont(MyFont.LARGEST_BOLD);
			currentPanelLabel.setForeground(MyColor.MY_WHITE);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(MyColor.MY_WHITE);
			g.drawLine((int) (NUMBER.px * 510), (int) (NUMBER.px * 20), (int) (NUMBER.px * 510), (int) (NUMBER.px * 65));
			g.drawLine((int) (NUMBER.px * 690), (int) (NUMBER.px * 20), (int) (NUMBER.px * 690), (int) (NUMBER.px * 65));
			g.drawLine((int) (NUMBER.px * 870), (int) (NUMBER.px * 20), (int) (NUMBER.px * 870), (int) (NUMBER.px * 65));
			g.drawLine((int) (NUMBER.px * 1050), (int) (NUMBER.px * 20), (int) (NUMBER.px * 1050), (int) (NUMBER.px * 65));
		}

		private void addListener() {
			this.playerPanelButton.addMouseListener(this);
			this.teamPanelButton.addMouseListener(this);
			this.matchPanelButton.addMouseListener(this);
			this.hotSportPanelButton.addMouseListener(this);
			this.quitSystem.addMouseListener(this);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(quitSystem)) {
				frame.dispose();
				System.exit(0);
			}
			else if (e.getSource().equals(playerPanelButton)) {
				contentPanel.showPlayerPanel();
			}
			else if (e.getSource().equals(teamPanelButton)) {
				contentPanel.showTeamPanel();
			}
			else if (e.getSource().equals(matchPanelButton)) {
				contentPanel.showMatchPanel();
			}
			else if (e.getSource().equals(hotSportPanelButton)) {
				contentPanel.showHotPanel();
			}
		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(quitSystem)) {
				quitSystem.setContentAreaFilled(true);
			}
			else if (e.getSource().equals(playerPanelButton)) {
				playerPanelButton.setContentAreaFilled(true);
			}
			else if (e.getSource().equals(teamPanelButton)) {
				teamPanelButton.setContentAreaFilled(true);
			}
			else if (e.getSource().equals(matchPanelButton)) {
				matchPanelButton.setContentAreaFilled(true);
			}
			else if (e.getSource().equals(hotSportPanelButton)) {
				hotSportPanelButton.setContentAreaFilled(true);
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(quitSystem)) {
				quitSystem.setContentAreaFilled(false);
			}
			else if (e.getSource().equals(playerPanelButton)) {
				playerPanelButton.setContentAreaFilled(false);
			}
			else if (e.getSource().equals(teamPanelButton)) {
				teamPanelButton.setContentAreaFilled(false);
			}
			else if (e.getSource().equals(matchPanelButton)) {
				matchPanelButton.setContentAreaFilled(false);
			}
			else if (e.getSource().equals(hotSportPanelButton)) {
				hotSportPanelButton.setContentAreaFilled(false);
			}
		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}
	}
}
