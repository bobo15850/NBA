package presentation;

import javax.swing.JFrame;

import presentation.match.OneMatchPanel;
import presentation.players.OnePlayerPanel;
import presentation.teams.OneTeamPanel;

import common.mycomponent.MyPanel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.statics.MyColor;
import common.statics.NUMBER;

public class SonFrame {
	public static JFrame cardFrame;
	public static String playerCard = "player";
	public static String teamCard = "team";
	public static String matchCard = "match";

	public static void main(String args[]) {
		new SonFrame("Kevin Durant", playerCard);
	}

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
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		cardFrame.add(contentPanel);
		cardFrame.setVisible(true);
	}
}
