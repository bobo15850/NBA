package presentation.match;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import presentation.SonFrame;
import presentation.players.OnePlayerPanel;
import presentation.teams.OneTeamPanel;
import businesslogic.matches.OneMatchInfoBl;
import businesslogicservice.matches.OneMatchInfoBlService;
import businesslogicservice.teams.OneTeamInfoBlService;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyScrollPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.mydatastructure.TeamPerformOfOneMatch;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class OneMatchPanel extends MyPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private MyPanel thisPanel = this;
	private MyLabel point;
	private MyLabel firstTeamLogo;
	private MyLabel secondTeamLogo;
	private ContentPanel contentPanel;
	private JScrollPane matchInfo;
	private MyTable matchInfoTable;
	private MyTableModel matchInfoTableModel;
	private int Label_height = (int) (NUMBER.px * 40);
	private int Label_width = (int) (NUMBER.px * 413);
	private String title[];

	private OneMatchInfoBlService oneMatchInfoBl = new OneMatchInfoBl();
	private GeneralInfoOfOneMatch generalOneMatch;
	private ArrayList<PlayerPerformOfOneMatch> firstTeamPlayerPerform;
	private ArrayList<PlayerPerformOfOneMatch> secondTeamPlayerPerform;

	private MyButton[] button = new MyButton[] { new MyButton("主队球员数据"), new MyButton("客队球员数据"), new MyButton("球队对比") };
	private MyPanel[] panel;
	private int flag = 0;

	public OneMatchPanel(GeneralInfoOfOneMatch generalOneMatch) {
		this.generalOneMatch = generalOneMatch;
		this.firstTeamPlayerPerform = oneMatchInfoBl.getPlayersPerformOfOneMatch(generalOneMatch.getFirstTeamName(), generalOneMatch.getDate());
		this.secondTeamPlayerPerform = oneMatchInfoBl.getPlayersPerformOfOneMatch(generalOneMatch.getSecondTeamName(), generalOneMatch.getDate());
		panel = new MyPanel[] { new TeamMemberInfoPanel(firstTeamPlayerPerform), new TeamMemberInfoPanel(secondTeamPlayerPerform),
				new TeamInfoComparePanel() };
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.initTable();
		this.setTableStyle();
		this.addListener();
	}

	private void addListener() {
		firstTeamLogo.addMouseListener(this);
		secondTeamLogo.addMouseListener(this);
	}

	private void createObjects() {
		point = new MyLabel();
		firstTeamLogo = new MyLabel();
		secondTeamLogo = new MyLabel();
		this.title = new String[generalOneMatch.getFirstTeamQuarterScore().length + 2];
		title[0] = "球队";
		title[title.length - 1] = "总分";
		for (int i = 1; i <= generalOneMatch.getFirstTeamQuarterScore().length; i++) {
			title[i] = String.valueOf(i);
		}
		matchInfoTableModel = new MyTableModel(title);
		matchInfoTable = new MyTable(matchInfoTableModel);
		matchInfo = new MyScrollPanel(matchInfoTable);
		contentPanel = new ContentPanel();
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 3; i++) {
			button[i].setBounds((int) (NUMBER.px * 80) + Label_width * i, (int) (NUMBER.px * 250), Label_width, Label_height);
			button[i].setBackground(MyColor.MIDDLE_COLOR);
			button[i].setForeground(MyColor.MY_WHITE);
			button[i].setFont(MyFont.SMALL_BOLD);
			button[i].setContentAreaFilled(true);
			button[i].addMouseListener(this);
			this.add(button[i]);
		}
		firstTeamLogo.setBounds((int) (NUMBER.px * 450), (int) (NUMBER.px * 10), (int) (NUMBER.px * 100), (int) (NUMBER.px * 80));
		secondTeamLogo.setBounds((int) (NUMBER.px * 850), (int) (NUMBER.px * 10), (int) (NUMBER.px * 100), (int) (NUMBER.px * 80));
		point.setBounds((int) (NUMBER.px * 550), (int) (NUMBER.px * 10), (int) (NUMBER.px * 300), (int) (NUMBER.px * 100));
		matchInfo.setBounds((int) (NUMBER.px * 80), (int) (NUMBER.px * 100), (int) (NUMBER.px * 1240), (int) (NUMBER.px * 150));
		contentPanel.setBounds((int) (NUMBER.px * 80), (int) (NUMBER.px * 290), (int) (NUMBER.px * 1240), (int) (NUMBER.px * 600));
		this.add(firstTeamLogo);
		this.add(secondTeamLogo);
		this.add(point);
		this.add(matchInfo);
		this.add(contentPanel);
	}

	private void setComponentsStyle() {
		point.setHorizontalAlignment(SwingConstants.CENTER);
		point.setFont(MyFont.LARGEST_BOLD);
		point.setForeground(MyColor.MIDDLE_COLOR);
		button[flag].setBackground(MyColor.MY_ORIANGE);
	}

	private void initTable() {
		firstTeamLogo.setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + this.generalOneMatch.getFirstTeamName() + ".png"));
		secondTeamLogo.setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + this.generalOneMatch.getSecondTeamName() + ".png"));
		point.setText(generalOneMatch.getFirstTeamScore() + "  vs  " + generalOneMatch.getSecondTeamScore());
		String[] firstContent = new String[title.length];
		firstContent[0] = generalOneMatch.getFirstTeamName();
		firstContent[title.length - 1] = String.valueOf(generalOneMatch.getFirstTeamScore());
		for (int i = 1; i <= generalOneMatch.getFirstTeamQuarterScore().length; i++) {
			firstContent[i] = String.valueOf(generalOneMatch.getFirstTeamQuarterScore()[i - 1]);
		}
		matchInfoTableModel.addRow(firstContent);
		//
		String[] secondContent = new String[title.length];
		secondContent[0] = generalOneMatch.getSecondTeamName();
		secondContent[title.length - 1] = String.valueOf(generalOneMatch.getSecondTeamScore());
		for (int i = 1; i <= generalOneMatch.getFirstTeamQuarterScore().length; i++) {
			secondContent[i] = String.valueOf(generalOneMatch.getSecondTeamQuarterScore()[i - 1]);
		}
		matchInfoTableModel.addRow(secondContent);
	}

	private void setTableStyle() {
		matchInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	}

	class TeamMemberInfoPanel extends MyPanel {
		private MyTable teamInfoTable;
		private JScrollPane teamPlayerInfo;
		private MyTableModel teamInfoTableModel;
		private String[] title = { "姓名", "日期", "时间", "得分", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规", "命中", "出手", "三分命中", "三分出手", "罚球命中", "罚球出手", "前板", "后板" };
		private static final long serialVersionUID = 1L;

		public TeamMemberInfoPanel(ArrayList<PlayerPerformOfOneMatch> playerPerformList) {
			teamInfoTableModel = new MyTableModel(title);
			teamInfoTable = new MyTable(teamInfoTableModel);
			teamPlayerInfo = new MyScrollPanel(teamInfoTable);
			teamInfoTable.setTableColumnWidth(0, (int) (NUMBER.px * 110));
			for (int i = 1; i <= 2; i++) {
				teamInfoTable.setTableColumnWidth(i, (int) (NUMBER.px * 60));
			}
			for (int i = 3; i <= 11; i++) {
				teamInfoTable.setTableColumnWidth(i, (int) (NUMBER.px * 45));
			}
			for (int i = 12; i <= 15; i++) {
				teamInfoTable.setTableColumnWidth(i, (int) (NUMBER.px * 72));
			}

			if (playerPerformList != null) {
				for (int i = 0; i < playerPerformList.size(); i++) {
					String[] content = playerPerformList.get(i).toStringArray();
					content[0] = playerPerformList.get(i).getName();
					teamInfoTableModel.addRow(content);
				}
			}
			teamPlayerInfo.setBounds(0, 0, (int) (NUMBER.px * 1240), (int) (NUMBER.px * 400));
			this.add(teamPlayerInfo);
			teamInfoTable.addMouseListener(new MouseListener() {

				public void mouseReleased(MouseEvent e) {
				}

				public void mousePressed(MouseEvent e) {
				}

				public void mouseExited(MouseEvent e) {
				}

				public void mouseEntered(MouseEvent e) {
				}

				public void mouseClicked(MouseEvent e) {
					if (teamInfoTable.getSelectedRow() >= 0 && teamInfoTable.getSelectedRow() < teamInfoTable.getRowCount()) {
						int row = teamInfoTable.getSelectedRow();
						String playerName = (String) teamInfoTable.getValueAt(row, 0);
						OnePlayerPanel playerPanel = new OnePlayerPanel(playerName);
						SonFrame.changePanel(thisPanel, playerPanel);
					}
				}
			});
			this.setVisible(true);
		}
	}

	class TeamInfoComparePanel extends MyPanel {
		private OneTeamInfoBlService OneTeamInfoBl = new businesslogic.teams.OneTeamInfoBl();
		private TeamPerformOfOneMatch firstTeamPerform = OneTeamInfoBl.getOneMatchTeamPerform(generalOneMatch.getFirstTeamName(),
				generalOneMatch.getDate());
		private TeamPerformOfOneMatch secondTeamPerform = OneTeamInfoBl.getOneMatchTeamPerform(generalOneMatch.getSecondTeamName(),
				generalOneMatch.getDate());
		private String performanceList[] = { "分数", "投篮", "三分球", "罚球", "助攻", "篮板", "抢断", "盖帽" };
		private String firstPerform[] = { String.valueOf(firstTeamPerform.getPoint()),
				String.valueOf(firstTeamPerform.getTotalHit()) + "/" + String.valueOf(firstTeamPerform.getTotalShot()),
				String.valueOf(firstTeamPerform.getThreeHit()) + "/" + String.valueOf(firstTeamPerform.getThreeShot()),
				String.valueOf(firstTeamPerform.getFreeHit()) + "/" + String.valueOf(firstTeamPerform.getFreeShot()),
				String.valueOf(firstTeamPerform.getAssist()), String.valueOf(firstTeamPerform.getRebound()),
				String.valueOf(firstTeamPerform.getSteal()), String.valueOf(firstTeamPerform.getBlock()) };

		private String secondPerform[] = { String.valueOf(secondTeamPerform.getPoint()),
				String.valueOf(secondTeamPerform.getTotalHit()) + "/" + String.valueOf(secondTeamPerform.getTotalShot()),
				String.valueOf(secondTeamPerform.getThreeHit()) + "/" + String.valueOf(secondTeamPerform.getThreeShot()),
				String.valueOf(secondTeamPerform.getFreeHit()) + "/" + String.valueOf(secondTeamPerform.getFreeShot()),
				String.valueOf(secondTeamPerform.getAssist()), String.valueOf(secondTeamPerform.getRebound()),
				String.valueOf(secondTeamPerform.getSteal()), String.valueOf(secondTeamPerform.getBlock()) };

		private MyLabel performLabel[] = new MyLabel[8];
		private MyLabel firstTeamInfo[] = new MyLabel[8];
		private MyLabel secondTeamInfo[] = new MyLabel[8];
		private static final long serialVersionUID = 1L;

		public TeamInfoComparePanel() {
			for (int i = 0; i < 8; i++) {
				performLabel[i] = new MyLabel(performanceList[i]);
				performLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
				performLabel[i].setOpaque(true);
				performLabel[i].setBackground(MyColor.LIGHT_BLUE);
				performLabel[i].setBounds((int) (NUMBER.px * 940) / 2, i * (int) (NUMBER.px * 45), (int) (NUMBER.px * 300), (int) (NUMBER.px * 45));

				firstTeamInfo[i] = new MyLabel(firstPerform[i] + "--------------------");
				firstTeamInfo[i].setBounds((int) (NUMBER.px * 940) / 2 - (int) (NUMBER.px * 300), i * (int) (NUMBER.px * 45),
						(int) (NUMBER.px * 300), (int) (NUMBER.px * 45));

				secondTeamInfo[i] = new MyLabel("--------------------" + secondPerform[i]);
				secondTeamInfo[i].setHorizontalAlignment(SwingConstants.RIGHT);
				secondTeamInfo[i].setBounds((int) (NUMBER.px * 940) / 2 + (int) (NUMBER.px * 300), i * (int) (NUMBER.px * 45),
						(int) (NUMBER.px * 300), (int) (NUMBER.px * 45));

				this.add(performLabel[i]);
				this.add(firstTeamInfo[i]);
				this.add(secondTeamInfo[i]);
			}

		}

	}

	class ContentPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;

		ContentPanel() {
			card = new CardLayout();
			this.setLayout(card);
			for (int i = 0; i < 3; i++) {
				this.add(panel[i], String.valueOf(i));
			}
		}

		public void showMyPanel(int i) {
			this.card.show(contentPanel, String.valueOf(i));
		}
	}

	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource().equals(button[i])) {
				contentPanel.showMyPanel(i);
				button[flag].setBackground(MyColor.MIDDLE_COLOR);
				button[i].setBackground(MyColor.MY_ORIANGE);
				flag = i;
			}
		}
		if (e.getSource().equals(firstTeamLogo)) {
			OneTeamPanel teamPanel = new OneTeamPanel(generalOneMatch.getFirstTeamName());
			SonFrame.changePanel(thisPanel, teamPanel);
		}
		else if (e.getSource().equals(secondTeamLogo)) {
			OneTeamPanel teamPanel = new OneTeamPanel(generalOneMatch.getSecondTeamName());
			SonFrame.changePanel(thisPanel, teamPanel);
		}
	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource().equals(button[i])) {
				button[i].setBackground(MyColor.DEEP_COLOR);
			}
		}
		if (e.getSource().equals(firstTeamLogo)) {
			firstTeamLogo.setLocation(firstTeamLogo.getX() - NUMBER.STEP, firstTeamLogo.getY() - NUMBER.STEP);
		}
		else if (e.getSource().equals(secondTeamLogo)) {
			secondTeamLogo.setLocation(secondTeamLogo.getX() - NUMBER.STEP, secondTeamLogo.getY() - NUMBER.STEP);
		}
	}

	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource().equals(button[i])) {
				if (flag == i) {
					button[i].setBackground(MyColor.MY_ORIANGE);
				}
				else {
					button[i].setBackground(MyColor.MIDDLE_COLOR);
				}
			}
		}
		if (e.getSource().equals(firstTeamLogo)) {
			firstTeamLogo.setLocation(firstTeamLogo.getX() + (int) (NUMBER.px * 3), firstTeamLogo.getY() + (int) (NUMBER.px * 3));
		}
		else if (e.getSource().equals(secondTeamLogo)) {
			secondTeamLogo.setLocation(secondTeamLogo.getX() + (int) (NUMBER.px * 3), secondTeamLogo.getY() + (int) (NUMBER.px * 3));
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
