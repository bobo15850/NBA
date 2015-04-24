package presentation.teams;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import presentation.SonFrame;
import presentation.match.OneMatchPanel;
import presentation.players.OnePlayerPanel;
import test.data.TeamHighInfo;
import businesslogic.matches.MatchInfoBl;
import businesslogic.players.OnePlayerInfoBl;
import businesslogic.teams.OneTeamInfoBl;
import businesslogicservice.players.OnePlayerInfoBlService;
import businesslogicservice.teams.OneTeamInfoBlService;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mycomponent.MyTextArea;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.GeneralInfoOfTeam;
import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.mydatastructure.TeamPerformOfOneMatch;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class OneTeamPanel extends MyPanel implements MouseListener {
	private MyPanel thisPanel = this;
	private static final long serialVersionUID = 1L;
	private String teamName;
	private int buttonHeight = (int) (NUMBER.px * 50);
	private int buttonWidth = (int) (NUMBER.px * 450);
	private MyButton[] button = new MyButton[] { new MyButton("球队信息"), new MyButton("球队成员"), new MyButton("近期比赛") };
	private MyPanel[] panel;
	private GeneralInfoOfTeam teamGeneralInfo;
	private ArrayList<TeamPerformOfOneMatch> teamPerformList;
	private String[] playerOfTeamArray;
	private TeamHighInfo teamHigh;
	private TeamNormalInfo_Expand teamNormal_avg;
	private GeneralInfoPanel generalInfoPanel;
	private ContentPanel contentPanel;
	private int flag = 0;

	private OneTeamInfoBlService oneTeamInfoBl = new OneTeamInfoBl();

	// 球队卡只展示普通数据，高级数据要点击球员卡看
	public OneTeamPanel(String teamName) {
		this.teamName = teamName;
		teamGeneralInfo = oneTeamInfoBl.getTeamGeneralInfo(teamName);
		teamPerformList = oneTeamInfoBl.getTeamPerform(teamName);
		playerOfTeamArray = oneTeamInfoBl.getPlayerNameOfTeam(teamName);
		teamHigh = oneTeamInfoBl.getOneTeamHighInfo(teamName);
		teamNormal_avg = oneTeamInfoBl.getTeamNormalInfo_avg(teamName);
		panel = new MyPanel[] { new TeamInfoPanel(), new PlayerNormalInfoPanel(), new AllMatchInfoPanel() };
		this.createObjects();
		this.setComponentsLocation();
		this.setVisible(true);
	}

	private void createObjects() {
		generalInfoPanel = new GeneralInfoPanel();
		contentPanel = new ContentPanel();
	}

	private void setComponentsLocation() {
		generalInfoPanel.setLocation(0, 0);
		contentPanel.setBounds(0, (int) (NUMBER.px * 280), NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - (int) -(NUMBER.px * 280));
		this.add(generalInfoPanel);
		this.add(contentPanel);
		for (int i = 0; i < 3; i++) {
			button[i].setBounds((int) (NUMBER.px * 50) + buttonWidth * i, (int) (NUMBER.px * 230), buttonWidth, buttonHeight);
			button[i].setContentAreaFilled(true);
			button[i].setBackground(MyColor.MIDDLE_COLOR);
			button[i].setForeground(MyColor.MY_WHITE);
			button[i].setFont(MyFont.SMALL_BOLD);
			button[i].addMouseListener(this);
			this.add(button[i]);
		}
		button[flag].setBackground(MyColor.MY_ORIANGE);
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
	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource().equals(button[i])) {
				button[i].setBackground(MyColor.DEEP_COLOR);
			}
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
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	class ContentPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;

		ContentPanel() {
			card = new CardLayout();
			this.setOpaque(false);
			this.setLayout(card);
			for (int i = 0; i < 3; i++) {
				this.add(panel[i], String.valueOf(i));
			}
		}

		public void showMyPanel(int i) {
			this.card.show(contentPanel, String.valueOf(i));
		}
	}

	class GeneralInfoPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		private MyLabel logo;
		private JTextArea teamNameText;
		private JTextArea normalInfoText;
		private JTextArea mainMatchInfoText;

		public GeneralInfoPanel() {
			this.setSize(NUMBER.FRAME_WIDTH, (int) (NUMBER.px * 230));
			this.createObjects();
			this.setComponentsLocation();
			this.setContent();
		}

		private void createObjects() {
			logo = new MyLabel();
			teamNameText = new MyTextArea();
			normalInfoText = new MyTextArea();
			mainMatchInfoText = new MyTextArea();
		}

		private void setComponentsLocation() {
			logo.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 10), (int) (NUMBER.px * 220), (int) (NUMBER.px * 220));
			teamNameText.setBounds((int) (NUMBER.px * 450), (int) (NUMBER.px * 10), (int) (NUMBER.px * 140), (int) (NUMBER.px * 100));
			normalInfoText.setBounds((int) (NUMBER.px * 900), (int) (NUMBER.px * 40), (int) (NUMBER.px * 400), (int) (NUMBER.px * 180));
			mainMatchInfoText.setBounds((int) (NUMBER.px * 450), (int) (NUMBER.px * 150), (int) (NUMBER.px * 400), (int) (NUMBER.px * 60));
			this.add(logo);
			this.add(teamNameText);
			this.add(normalInfoText);
			this.add(mainMatchInfoText);
		}

		private void setContent() {
			logo.setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + teamName + ".png"));
			teamNameText.setText(teamName);
			teamNameText.setFont(MyFont.MIDDLE_BOLD);
			mainMatchInfoText.setText("得分    篮板    助攻\n" + teamNormal_avg.getPoint() + "  " + teamNormal_avg.getRebound() + "  "
					+ teamNormal_avg.getAssist());
			mainMatchInfoText.setFont(MyFont.SMALL_PLAIN);
			normalInfoText.setText("所在地：" + teamGeneralInfo.getLocation() + "\n所属联盟：" + teamGeneralInfo.getConference() + "\n所属分区："
					+ teamGeneralInfo.getDivision() + "\n主场：" + teamGeneralInfo.getHomeField() + "\n建队时间：" + teamGeneralInfo.getEstablishYear());
			normalInfoText.setFont(MyFont.SMALL_PLAIN);
		}
	}

	class TeamInfoPanel extends MyPanel {

		private static final long serialVersionUID = 1L;
		private final int labelHeight = (int) (NUMBER.px * 50);
		private final int labelWidth = (int) (NUMBER.px * 120);
		private final int gap = (int) (NUMBER.px * 10);
		private MyLabel fieldLabel[] = new MyLabel[28];
		private MyLabel value[] = new MyLabel[28];
		private String[] fieldString = { "参赛场数:", "胜利场数", "胜率", "得分:", "投篮命中率:", "篮板:", "助攻:", "抢断:", "盖帽:", "失误:", "犯规:", "三分命中率:", "罚球命中率:",
				"进攻篮板数:", "防守篮板:", "场均出手数:", "场均命中数:", "场均三分出手数:", "场均三分命中数:", "场均罚球出手数:", "场均罚球命中数:", "进攻回合数:", "进攻效率:", "防守效率:", "进攻篮板效率:",
				"防守篮板效率:", "助攻率:", "抢断率:" };
		private String[] fieldValue = { String.valueOf(teamNormal_avg.getNumOfGame()), String.valueOf(teamNormal_avg.getNumOfWin()),
				String.valueOf(teamHigh.getWinRate()), String.valueOf(teamNormal_avg.getPoint()), String.valueOf(teamNormal_avg.getShot()),
				String.valueOf(teamNormal_avg.getRebound()), String.valueOf(teamNormal_avg.getAssist()), String.valueOf(teamNormal_avg.getSteal()),
				String.valueOf(teamNormal_avg.getBlockShot()), String.valueOf(teamNormal_avg.getFault()), String.valueOf(teamNormal_avg.getFoul()),
				String.valueOf(teamNormal_avg.getThree()), String.valueOf(teamNormal_avg.getPenalty()),
				String.valueOf(teamNormal_avg.getOffendRebound()), String.valueOf(teamNormal_avg.getDefendRebound()),
				String.valueOf(teamNormal_avg.getTotalShot()), String.valueOf(teamNormal_avg.getTotalHit()),
				String.valueOf(teamNormal_avg.getThreeShot()), String.valueOf(teamNormal_avg.getThreeShot()),
				String.valueOf(teamNormal_avg.getFreeShot()), String.valueOf(teamNormal_avg.getFreeHit()), String.valueOf(teamHigh.getOffendRound()),
				String.valueOf(teamHigh.getOffendEfficient()), String.valueOf(teamHigh.getDefendEfficient()),
				String.valueOf(teamHigh.getOffendReboundEfficient()), String.valueOf(teamHigh.getDefendReboundEfficient()),
				String.valueOf(teamHigh.getAssistEfficient()), String.valueOf(teamHigh.getStealEfficient()) };

		public TeamInfoPanel() {
			for (int i = 0; i < 28; i++) {
				fieldLabel[i] = new MyLabel(fieldString[i]);
				value[i] = new MyLabel(fieldValue[i]);
			}
			for (int i = 0; i < 28; i++) {
				fieldLabel[i].setBounds((labelWidth + gap) * (i % 5) * 2 + labelWidth, (i / 5 + 1) * labelHeight, labelWidth, labelHeight);
				this.add(fieldLabel[i]);
				value[i].setBounds(fieldLabel[i].getX() + labelWidth, fieldLabel[i].getY(), labelWidth, labelHeight);
				this.add(value[i]);
			}
			this.setVisible(true);
		}
	}

	class PlayerNormalInfoPanel extends MyPanel {

		private String[] title = { "名称", "球队", "场数", "时间", "效率", "得分", "篮板", "助攻", "抢断", "盖帽", "两双", "三双", "失误", "犯规", "投篮命中率", "三分命中率", "罚球命中率" };
		private MyTableModel teamMemberTableModel = new MyTableModel(title);
		private MyTable teamMemberTable = new MyTable(teamMemberTableModel);

		private JScrollPane teamMemberScrollPane = new JScrollPane(teamMemberTable);
		private static final long serialVersionUID = 1L;

		public PlayerNormalInfoPanel() {
			teamMemberTable.setTableColumnWidth(0, (int) (NUMBER.px * 115));
			teamMemberTable.setTableColumnWidth(14, (int) (NUMBER.px * 98));
			teamMemberTable.setTableColumnWidth(15, (int) (NUMBER.px * 98));
			teamMemberTable.setTableColumnWidth(16, (int) (NUMBER.px * 98));
			OnePlayerInfoBlService oneplayerInfoBl = new OnePlayerInfoBl();
			if (playerOfTeamArray != null) {
				for (int i = 0; i < playerOfTeamArray.length; i++) {
					PlayerNormalInfo_Expand temp = oneplayerInfoBl.getPlayerNormalInfo_avg(playerOfTeamArray[i]);
					teamMemberTableModel.addRow(new String[] { temp.getName(), temp.getTeamName(), String.valueOf(temp.getNumOfGame()),
							String.valueOf(temp.getMinute()), String.valueOf(temp.getEfficiency()), String.valueOf(temp.getPoint()),
							String.valueOf(temp.getRebound()), String.valueOf(temp.getAssist()), String.valueOf(temp.getSteal()),
							String.valueOf(temp.getBlockShot()), String.valueOf(temp.getDoubleTwo()), String.valueOf(temp.getTripleTwo()),
							String.valueOf(temp.getFault()), String.valueOf(temp.getFoul()), String.valueOf(temp.getShot()),
							String.valueOf(temp.getThree()), String.valueOf(temp.getPenalty()) });
				}
			}
			teamMemberScrollPane.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 10), (int) (NUMBER.px * 1320), (int) (NUMBER.px * 400));
			this.add(teamMemberScrollPane);
			teamMemberTable.addMouseListener(new MouseListener() {

				public void mouseReleased(MouseEvent arg0) {

				}

				public void mousePressed(MouseEvent arg0) {

				}

				public void mouseExited(MouseEvent arg0) {

				}

				public void mouseEntered(MouseEvent arg0) {

				}

				public void mouseClicked(MouseEvent arg0) {
					if (teamMemberTable.getSelectedRow() >= 0 && teamMemberTable.getSelectedRow() < teamMemberTable.getRowCount()) {
						int row = teamMemberTable.getSelectedRow();
						String playerName = (String) teamMemberTable.getValueAt(row, 0);
						OnePlayerPanel playerPanel = new OnePlayerPanel(playerName);
						SonFrame.changePanel(thisPanel, playerPanel);
					}
				}
			});
		}
	}

	class AllMatchInfoPanel extends MyPanel {
		private String[] title = { "时间", "对手", "得分", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规", "命中", "出手", "三分命中", "三分出手", "罚球命中", "罚球出手", "前场篮板", "后场篮板" };
		private MyTableModel allMatchTableModel = new MyTableModel(title);
		private MyTable allMatchTable = new MyTable(allMatchTableModel);
		private JScrollPane teamMemberScrollPane = new JScrollPane(allMatchTable);
		private static final long serialVersionUID = 1L;

		public AllMatchInfoPanel() {
			allMatchTable.setTableColumnWidth(0, (int) (NUMBER.px * 85));
			for (int i = 11; i < 17; i++) {
				allMatchTable.setTableColumnWidth(i, (int) (NUMBER.px * 80));
			}
			if (teamPerformList != null) {
				for (int i = teamPerformList.size() - 1; i >= 0; i--) {
					allMatchTableModel.addRow(teamPerformList.get(i).toStringArray());
				}
			}
			teamMemberScrollPane.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 10), (int) (NUMBER.px * 1320), (int) (NUMBER.px * 400));
			this.add(teamMemberScrollPane);
			allMatchTable.addMouseListener(new MouseListener() {

				public void mouseReleased(MouseEvent e) {
				}

				public void mousePressed(MouseEvent e) {
				}

				public void mouseExited(MouseEvent e) {
				}

				public void mouseEntered(MouseEvent e) {
				}

				public void mouseClicked(MouseEvent e) {
					if (allMatchTable.getSelectedRow() >= 0 && allMatchTable.getSelectedRow() < allMatchTable.getRowCount()) {
						int row = allMatchTable.getSelectedRow();
						String teamName = (String) allMatchTable.getValueAt(row, 1);
						String dateString = (String) allMatchTable.getValueAt(row, 0);
						MyDate date = new MyDate(dateString);
						GeneralInfoOfOneMatch generalMatch = new MatchInfoBl().getGeneralMatch(teamName, date);
						OneMatchPanel matchPanel = new OneMatchPanel(generalMatch);
						SonFrame.changePanel(thisPanel, matchPanel);
					}
				}
			});
		}
	}
}
