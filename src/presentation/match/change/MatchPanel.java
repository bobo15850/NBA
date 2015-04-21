package presentation.match.change;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import businesslogic.matches.MatchInfoBl;
import businesslogicservice.matches.MatchInfoBlService;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.statics.MyColor;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class MatchPanel extends MyPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int inter = (int) (NUMBER.px * 100);
	private final int matchPanelHeight = (int) (NUMBER.px * 75);
	private final int matchPanelWidth = (int) (NUMBER.px * 400);
	private MatchInfoBlService matchInfoBl = new MatchInfoBl();
	private ArrayList<GeneralInfoOfOneMatch> oneDayMatch = new ArrayList<GeneralInfoOfOneMatch>();
	private MatchGeneralPanel[] MatchGeneral;
	private TimeInputPanel dateChoosePanel;
	private MyLabel nowDate, searchLable;
	private MyButton searchButton, refresh;

	public MatchPanel() {
		createObjects();
		setComponentPosition();
		setComponentStyle();
		addListener();
		this.init();
		this.setVisible(true);
	}

	private void createObjects() {
		nowDate = new MyLabel();
		searchLable = new MyLabel("请选择日期");
		searchButton = new MyButton("搜索");
		refresh = new MyButton("刷新");
		dateChoosePanel = new TimeInputPanel();
	}

	private void setComponentPosition() {
		nowDate.setBounds(inter, 0, (int) NUMBER.px * 200, (int) NUMBER.px * 60);
		searchLable.setBounds((int) NUMBER.px * 200 + inter, 0, (int) NUMBER.px * 150, (int) NUMBER.px * 60);
		dateChoosePanel.setBounds((int) NUMBER.px * 380 + inter, (int) (10 * NUMBER.px), (int) NUMBER.px * 200, (int) NUMBER.px * 60);
		searchButton.setBounds((int) NUMBER.px * 600 + inter, 0, (int) NUMBER.px * 100, (int) NUMBER.px * 60);
		refresh.setBounds((int) NUMBER.px * 1000 + inter, 0, (int) NUMBER.px * 100, (int) NUMBER.px * 60);
		this.add(nowDate);
		this.add(searchLable);
		this.add(dateChoosePanel);
		this.add(searchButton);
		this.add(refresh);
	}

	private void setComponentStyle() {
		this.setBackground(MyColor.DEEP_COLOR);

	}

	private void setContent() {
		if (oneDayMatch == null) {
			System.out.println("当日没有比赛");
		}
		else {
			int numOfMatch = oneDayMatch.size();
			MatchGeneral = new MatchGeneralPanel[numOfMatch];
			for (int i = 0; i < numOfMatch; i++) {
				MatchGeneral[i] = new MatchGeneralPanel(oneDayMatch.get(i));
				this.add(MatchGeneral[i]);
			}
			if (numOfMatch <= 4) {
				for (int j = 0; j < numOfMatch; j++) {
					MatchGeneral[j].setBounds(inter * 4, (matchPanelHeight + inter) * j + inter, matchPanelWidth, matchPanelHeight);
				}
			}
			else if (numOfMatch <= 8) {
				for (int j = 0; j < numOfMatch; j++) {
					MatchGeneral[j].setBounds(inter * 4, matchPanelHeight * j + inter, matchPanelWidth, matchPanelHeight);
				}
			}
			else {
				for (int j = 0; j < 8; j++) {
					MatchGeneral[j].setBounds(inter * 2, matchPanelHeight * j + inter, matchPanelWidth, matchPanelHeight);
				}
				for (int j = 8; j < numOfMatch; j++) {
					MatchGeneral[j].setBounds(inter * 4 + matchPanelWidth, matchPanelHeight * (j - 8) + inter, matchPanelWidth, matchPanelHeight);
				}
			}
			nowDate.setTextAndStyle("当前日期为：" + oneDayMatch.get(0).getDate().getFormatString());
		}

		this.repaint();
	}

	private void init() {
		oneDayMatch = this.matchInfoBl.getLatestMatches();
		this.setContent();
	}

	private void addListener() {

	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	class MatchGeneralPanel extends MyPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MatchGeneralPanel(GeneralInfoOfOneMatch oneMatch) {
			this.setLayout(null);
			String firstTeamName = oneMatch.getFirstTeamName();
			String secondTeamName = oneMatch.getSecondTeamName();
			int firstTeamScore = oneMatch.getFirstTeamScore();
			int secondTeamScore = oneMatch.getSecondTeamScore();
			ImageIcon firstImage = new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + firstTeamName + ".png");
			ImageIcon secondImage = new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + secondTeamName + ".png");
			String score = "<html>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + String.valueOf(firstTeamScore) + " VS "
					+ String.valueOf(+secondTeamScore) + "<br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + firstTeamName
					+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + secondTeamName + "</html>";
			MyLabel firstTeam = new MyLabel();
			MyLabel secondTeam = new MyLabel();
			MyLabel scoreLabel = new MyLabel(score);
			firstTeam.setBounds(0, (int) (NUMBER.px * 5), matchPanelWidth / 4, matchPanelHeight - (int) (NUMBER.px * 5));
			scoreLabel.setBounds(matchPanelWidth / 4, 0, matchPanelWidth / 2, matchPanelHeight - (int) (NUMBER.px * 5));
			secondTeam.setBounds(matchPanelWidth / 4 * 3, (int) (NUMBER.px * 5), matchPanelWidth / 4, matchPanelHeight - (int) (NUMBER.px * 5));
			firstTeam.setMyIcon(firstImage);
			secondTeam.setMyIcon(secondImage);
			this.add(firstTeam);
			this.add(scoreLabel);
			this.add(secondTeam);
			this.setVisible(true);
		}
	}

	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.setBackground(MyColor.LIGHT_COLOR);
		j.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH,
				NUMBER.FRAME_HEIGHT);
		MatchPanel contentPanel = new MatchPanel();
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);
	}
}
