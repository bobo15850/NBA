package presentation.match;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import presentation.SonFrame;
import businesslogic.matches.MatchInfoBl;
import businesslogicservice.matches.MatchInfoBlService;

import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class MatchPanel extends MyPanel implements MouseListener {
	/**
	 * 
	 */
	private MyDate showDay;
	private static final long serialVersionUID = 1L;
	private final int inter = (int) (NUMBER.px * 100);
	private final int matchPanelHeight = (int) (NUMBER.px * 75);
	private final int matchPanelWidth = (int) (NUMBER.px * 400);
	private MatchInfoBlService matchInfoBl = new MatchInfoBl();
	private ArrayList<GeneralInfoOfOneMatch> oneDayMatch = new ArrayList<GeneralInfoOfOneMatch>();
	private MatchGeneralPanel[] MatchGeneral;
	private TimeInputPanel dateChoosePanel;
	private MyLabel nowDate, searchLable;
	private JButton searchButton, refresh, preDayButton, nextDayButton;

	public MatchPanel() {
		createObjects();
		setComponentPosition();
		addListener();
		this.init();
		this.setVisible(true);
	}

	private void setButton(JButton button) {
		button.setFocusable(false);
		button.setBorderPainted(false);
		button.setFont(MyFont.SMALLEST_BOLD);
		button.setForeground(MyColor.MY_WHITE);
		button.setBackground(MyColor.MIDDLE_COLOR);
	}

	private void createObjects() {
		nowDate = new MyLabel();
		searchLable = new MyLabel("请选择日期:");
		searchButton = new JButton("搜索");
		preDayButton = new JButton("<html>前<br>一<br>天</html>");
		nextDayButton = new JButton("<html>后<br>一<br>天</html>");
		refresh = new JButton("刷新");
		dateChoosePanel = new TimeInputPanel();
	}

	private void setComponentPosition() {
		nowDate.setBounds(inter, 0, (int) (NUMBER.px * 200), (int) (NUMBER.px * 60));
		searchLable.setBounds((int) (NUMBER.px * 300 + inter), 0, (int) (NUMBER.px * 150), (int) (NUMBER.px * 60));

		dateChoosePanel.setBounds((int) (NUMBER.px * 420 + inter), (int) (10 * NUMBER.px), (int) (NUMBER.px * 300), (int) (NUMBER.px * 60));
		searchButton.setBounds((int) (NUMBER.px * 730 + inter), (int) (NUMBER.px * 13), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
		refresh.setBounds((int) (NUMBER.px * 1000 + inter), (int) (NUMBER.px * 13), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
		preDayButton.setBounds(inter / 3, inter * 3, (int) (NUMBER.px * 40), (int) (NUMBER.px * 150));
		nextDayButton.setBounds((int) (NUMBER.px * 1300), inter * 3, (int) (NUMBER.px * 40), (int) (NUMBER.px * 150));
		this.setButton(searchButton);
		this.setButton(refresh);
		this.setButton(preDayButton);
		this.setButton(nextDayButton);
		this.searchLable.setFont(MyFont.SMALL_BOLD);
		this.add(nowDate);
		this.add(searchLable);
		this.add(dateChoosePanel);
		this.add(searchButton);
		this.add(refresh);
		this.add(preDayButton);
		this.add(nextDayButton);
	}

	private void init() {
		oneDayMatch = this.matchInfoBl.getLatestMatches();
		showDay = this.matchInfoBl.getLatestDate();
		this.setContent();
	}

	private void setContent() {
		if (this.oneDayMatch == null) {
			if (MatchGeneral != null) {
				for (int i = 0; i < MatchGeneral.length; i++) {
					this.remove(MatchGeneral[i]);
				}
			}
			this.nowDate.setTextAndStyle(showDay.getFormatString() + " 没有比赛");
			nowDate.setFont(MyFont.SMALL_BOLD);
			this.repaint();
		}
		else {
			if (MatchGeneral != null) {
				for (int i = 0; i < MatchGeneral.length; i++) {
					this.remove(MatchGeneral[i]);
				}
			}
			int numOfMatch = oneDayMatch.size();
			MatchGeneral = new MatchGeneralPanel[numOfMatch];
			for (int i = 0; i < numOfMatch; i++) {
				MatchGeneral[i] = new MatchGeneralPanel(oneDayMatch.get(i));
				this.add(MatchGeneral[i]);
			}
			if (numOfMatch <= 4) {
				for (int j = 0; j < numOfMatch; j++) {
					MatchGeneral[j].setBounds(inter * 5, (matchPanelHeight + inter) * j + inter, matchPanelWidth, matchPanelHeight);
				}
			}
			else if (numOfMatch <= 8) {
				for (int j = 0; j < numOfMatch; j++) {
					MatchGeneral[j].setBounds(inter * 5, matchPanelHeight * j + inter, matchPanelWidth, matchPanelHeight);
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
			nowDate.setTextAndStyle("当前日期：" + showDay.getFormatString());
			nowDate.setFont(MyFont.SMALL_BOLD);
			this.repaint();
		}
		if (MatchGeneral != null) {
			for (int i = 0; i < MatchGeneral.length; i++) {
				MatchGeneral[i].addMouseListener(this);
			}
		}
	}

	private void addListener() {
		searchButton.addMouseListener(this);
		refresh.addMouseListener(this);
		preDayButton.addMouseListener(this);
		nextDayButton.addMouseListener(this);

	}

	private void searchButtonListener() {
		MyDate dateSearch = this.dateChoosePanel.getDate();
		showDay = dateSearch;
		this.oneDayMatch = this.matchInfoBl.getTodayMatches(dateSearch);
		this.setContent();
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(refresh)) {
			this.init();
		}
		else if (e.getSource().equals(searchButton)) {
			this.searchButtonListener();
		}
		else if (e.getSource().equals(preDayButton)) {
			this.showDay = showDay.toPreDate();
			this.oneDayMatch = this.matchInfoBl.getTodayMatches(showDay);
			this.setContent();
		}
		else if (e.getSource().equals(nextDayButton)) {
			this.showDay = showDay.toNextDate();
			this.oneDayMatch = this.matchInfoBl.getTodayMatches(showDay);
			this.setContent();
		}
		else {
			for (int i = 0; i < oneDayMatch.size(); i++) {
				if (e.getSource().equals(MatchGeneral[i])) {
					new SonFrame(MatchGeneral[i].getGeneralInfoOfMatch(), SonFrame.matchCard);
					break;
				}
			}
		}

	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(searchButton)) {
			searchButton.setBackground(MyColor.DEEP_COLOR);
		}
		else if (e.getSource().equals(refresh)) {
			refresh.setBackground(MyColor.DEEP_COLOR);
		}
		else if (e.getSource().equals(preDayButton)) {
			preDayButton.setBackground(MyColor.DEEP_COLOR);
		}
		else if (e.getSource().equals(nextDayButton)) {
			nextDayButton.setBackground(MyColor.DEEP_COLOR);
		}
		else {
			for (int i = 0; i < oneDayMatch.size(); i++) {
				if (e.getSource().equals(MatchGeneral[i])) {
					MatchGeneral[i].setLocation(MatchGeneral[i].getX() - NUMBER.STEP, MatchGeneral[i].getY() - NUMBER.STEP);
					break;
				}
			}
		}

	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(searchButton)) {
			searchButton.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(refresh)) {
			refresh.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(preDayButton)) {
			preDayButton.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(nextDayButton)) {
			nextDayButton.setBackground(MyColor.MIDDLE_COLOR);
		}
		else {
			for (int i = 0; i < oneDayMatch.size(); i++) {
				if (e.getSource().equals(MatchGeneral[i])) {
					MatchGeneral[i].setLocation(MatchGeneral[i].getX() + NUMBER.STEP, MatchGeneral[i].getY() + NUMBER.STEP);
					break;
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	class MatchGeneralPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		private GeneralInfoOfOneMatch oneMatch;

		public MatchGeneralPanel(GeneralInfoOfOneMatch oneMatch) {
			this.oneMatch = oneMatch;
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
			scoreLabel.setFont(MyFont.SMALL_BOLD);
			firstTeam.setMyIcon(firstImage);
			secondTeam.setMyIcon(secondImage);
			this.add(firstTeam);
			this.add(scoreLabel);
			this.add(secondTeam);
			this.setVisible(true);
		}

		public GeneralInfoOfOneMatch getGeneralInfoOfMatch() {
			return this.oneMatch;
		}
	}
}
