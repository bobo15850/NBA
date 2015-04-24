package presentation;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import presentation.match.OneMatchPanel;
import presentation.players.OnePlayerPanel;
import presentation.teams.OneTeamPanel;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class SonFrame {
	public static JFrame cardFrame;
	public static String playerCard = "player";
	public static String teamCard = "team";
	public static String matchCard = "match";

	public SonFrame(Object o, String str) {
		cardFrame = new JFrame();
		cardFrame.setUndecorated(true);
		cardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cardFrame.setLayout(null);
		cardFrame.setBackground(MyColor.BACKGROUNDCOLOR);
		cardFrame.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20,
				NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT);
		MyPanel contentPanel = null;
		if (str.equals(playerCard)) {
			contentPanel = new OnePlayerPanel((String) o);
		}
		else if (str.endsWith(teamCard)) {
			contentPanel = new OneTeamPanel((String) o);
		}
		else if (str.endsWith(matchCard)) {
			contentPanel = new OneMatchPanel((GeneralInfoOfOneMatch) o);
		}
		headPanel headPanel = new headPanel();
		headPanel.setBounds(0, 0, NUMBER.FRAME_WIDTH, NUMBER.NAVIGATION_PANEL_HEIGHT);
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		cardFrame.getContentPane().add(contentPanel);
		cardFrame.getContentPane().add(headPanel);
		cardFrame.setVisible(true);
	}

	public static void changePanel(MyPanel before, MyPanel after) {
		SonFrame.cardFrame.getContentPane().remove(before);
		SonFrame.cardFrame.getContentPane().add(after);
		after.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		SonFrame.cardFrame.getContentPane().validate();
		SonFrame.cardFrame.getContentPane().repaint();
	}

	class headPanel extends MyPanel {

		private static final long serialVersionUID = 1L;
		private MyButton quitButton = new MyButton("退出");
		private MyLabel headLabel = new MyLabel("信息卡片");

		public headPanel() {
			headLabel.setFont(MyFont.LARGEST_BOLD);
			headLabel.setBounds((NUMBER.FRAME_WIDTH - (int) (NUMBER.px * 400)) / 2, 0, (int) (NUMBER.px * 400), NUMBER.NAVIGATION_PANEL_HEIGHT);
			this.add(headLabel);
			quitButton.setBackground(MyColor.MIDDLE_COLOR);
			quitButton.setForeground(MyColor.MY_WHITE);
			quitButton.setFont(MyFont.LARGE_PLAIN);
			quitButton.setBounds(NUMBER.FRAME_WIDTH / 8 * 7, 0, NUMBER.FRAME_WIDTH / 8 * 1, NUMBER.NAVIGATION_PANEL_HEIGHT);
			quitButton.addMouseListener(new MouseListener() {

				public void mouseReleased(MouseEvent arg0) {

				}

				public void mousePressed(MouseEvent arg0) {

				}

				public void mouseExited(MouseEvent arg0) {
					quitButton.setBackground(MyColor.MIDDLE_COLOR);
				}

				public void mouseEntered(MouseEvent arg0) {
					quitButton.setBackground(MyColor.DEEP_COLOR);
				}

				public void mouseClicked(MouseEvent arg0) {
					cardFrame.dispose();
				}
			});
			this.add(quitButton);
			this.setVisible(true);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(MyColor.DEEP_COLOR);
			g.drawLine(0, this.getHeight() - NUMBER.STEP, this.getWidth(), this.getHeight() - NUMBER.STEP);
			g.drawLine(0, this.getHeight() - 2 * NUMBER.STEP, this.getWidth(), this.getHeight() - 2 * NUMBER.STEP);
			g.drawLine(0, this.getHeight() - 3 * NUMBER.STEP, this.getWidth(), this.getHeight() - 3 * NUMBER.STEP);
		}
	}
}
