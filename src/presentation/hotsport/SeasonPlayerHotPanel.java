package presentation.hotsport;

import java.awt.event.MouseListener;

import javax.swing.JFrame;

import businesslogicservice.hotsport.TeamHotBlService;

import common.statics.MyColor;
import common.statics.NUMBER;
//import vo.GeneralInfoOfPlayerVo;

public class SeasonPlayerHotPanel extends SeasonHotSportPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeamHotBlService teamHotBl;

	public static void main(String args[]) {
		JFrame j = new JFrame();
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.setBackground(MyColor.LIGHT_COLOR);
		j.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT);
		NavigationPanel navigationPanel = new NavigationPanel();
		navigationPanel.setBounds(0, 0, NUMBER.NAVIGATION_PANEL_WIDTH, NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(navigationPanel);
		SeasonPlayerHotPanel contentPanel = new SeasonPlayerHotPanel();
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);

	}

}
