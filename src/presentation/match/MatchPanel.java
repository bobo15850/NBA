package presentation.match;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import presentation.SonFrame;
import businesslogic.matches.MatchInfoBl;
import businesslogicservice.matches.MatchInfoBlService;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.MyDate;
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
	private MyButton searchButton, refresh, preDayButton, nextDayButton;

	public MatchPanel() {
		createObjects();
		setComponentPosition();
		setComponentStyle();
		this.init();

		this.setVisible(true);
	}

	private void createObjects() {
		nowDate = new MyLabel();
		searchLable = new MyLabel("请选择日期");
		searchButton = new MyButton("搜索");
		preDayButton = new MyButton("<html>前<br>一<br>天</html>");
		nextDayButton = new MyButton("<html>后<br>一<br>天</html>");
		refresh = new MyButton("刷新");
		dateChoosePanel = new TimeInputPanel();
	}

	private void setComponentPosition() {
		nowDate.setBounds(inter, 0, (int) (NUMBER.px * 200), (int) (NUMBER.px * 60));
		searchLable.setBounds((int) (NUMBER.px * 200 + inter), 0, (int) (NUMBER.px * 150), (int) (NUMBER.px * 60));
		dateChoosePanel.setBounds((int) (NUMBER.px * 380 + inter), (int) (10 * NUMBER.px), (int) (NUMBER.px * 200), (int) (NUMBER.px * 60));
		searchButton.setBounds((int) (NUMBER.px * 600 + inter), 0, (int) (NUMBER.px * 100), (int) (NUMBER.px * 60));
		refresh.setBounds((int) (NUMBER.px * 1000 + inter), 0, (int) (NUMBER.px * 100), (int) (NUMBER.px * 60));
		preDayButton.setBounds(inter / 3, inter * 3, (int) (NUMBER.px * 60), (int) (NUMBER.px * 100));
		nextDayButton.setBounds((int) (NUMBER.px * 1300), inter * 3, (int) (NUMBER.px * 60), (int) (NUMBER.px * 100));
		this.add(nowDate);
		this.add(searchLable);
		this.add(dateChoosePanel);
		this.add(searchButton);
		this.add(refresh);
		this.add(preDayButton);
		this.add(nextDayButton);
	}

	private void setComponentStyle() {

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
			nowDate.setTextAndStyle("当前日期为：" + showDay.getFormatString());
			this.repaint();
		}
		addListener();
	}

	private void addListener() {
		searchButton.addMouseListener(this);
		refresh.addMouseListener(this);
		preDayButton.addMouseListener(this);
		nextDayButton.addMouseListener(this);
		if (MatchGeneral != null) {
			for (int i = 0; i < MatchGeneral.length; i++) {
				MatchGeneral[i].addMouseListener(this);
			}
		}
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
			System.out.println("进入监听");
			for (int i = 0; i < oneDayMatch.size(); i++) {
				if (e.getSource().equals(MatchGeneral[i])) {
					new SonFrame(MatchGeneral[i].getGeneralInfoOfMatch(), SonFrame.matchCard);
					break;
				}
			}
		}

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
