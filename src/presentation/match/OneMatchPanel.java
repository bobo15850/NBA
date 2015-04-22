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
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyScrollPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class OneMatchPanel extends MyPanel implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyPanel thisPanel = this;
	private MyLabel point;
	private MyButton firstTeamMemberInfoButton;
	private MyButton secondTeamMemberInfoButton;
	private MyButton teamMatchInfoButton;
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

	public OneMatchPanel(GeneralInfoOfOneMatch generalOneMatch) {
		this.generalOneMatch = generalOneMatch;
		this.firstTeamPlayerPerform = oneMatchInfoBl.getPlayersPerformOfOneMatch(generalOneMatch.getFirstTeamName(), generalOneMatch.getDate());
		this.secondTeamPlayerPerform = oneMatchInfoBl.getPlayersPerformOfOneMatch(generalOneMatch.getSecondTeamName(), generalOneMatch.getDate());
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.initTable();
		this.setTableStyle();
		this.addListener();
	}

	private void addListener() {
		firstTeamMemberInfoButton.addMouseListener(this);
		secondTeamMemberInfoButton.addMouseListener(this);
		teamMatchInfoButton.addMouseListener(this);
		firstTeamLogo.addMouseListener(this);
		secondTeamLogo.addMouseListener(this);
	}

	private void createObjects() {
		firstTeamMemberInfoButton = new MyButton("主场球员数据");
		secondTeamMemberInfoButton = new MyButton("客场球员数据");
		teamMatchInfoButton = new MyButton("球队对比");
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
		firstTeamMemberInfoButton.setBounds((int) (NUMBER.px * 80), (int) (NUMBER.px * 250), Label_width, Label_height);
		secondTeamMemberInfoButton.setBounds((int) (NUMBER.px * 493), (int) (NUMBER.px * 250), Label_width, Label_height);
		teamMatchInfoButton.setBounds((int) (NUMBER.px * 906), (int) (NUMBER.px * 250), Label_width, Label_height);

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
		this.add(firstTeamMemberInfoButton);
		this.add(secondTeamMemberInfoButton);
		this.add(teamMatchInfoButton);
	}

	private void setComponentsStyle() {
		point.setHorizontalAlignment(SwingConstants.CENTER);
		point.setFont(MyFont.LARGEST_BOLD);
		point.setForeground(MyColor.MIDDLE_COLOR);
		firstTeamMemberInfoButton.setContentAreaFilled(true);
		firstTeamMemberInfoButton.setBackground(MyColor.DEEP_COLOR);
		firstTeamMemberInfoButton.setForeground(MyColor.MY_WHITE);
		firstTeamMemberInfoButton.setFont(MyFont.SMALL_BOLD);
		secondTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		secondTeamMemberInfoButton.setForeground(MyColor.MY_WHITE);
		secondTeamMemberInfoButton.setFont(MyFont.SMALL_BOLD);
		secondTeamMemberInfoButton.setContentAreaFilled(true);
		teamMatchInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		teamMatchInfoButton.setForeground(MyColor.MY_WHITE);
		teamMatchInfoButton.setFont(MyFont.SMALL_BOLD);
		teamMatchInfoButton.setContentAreaFilled(true);
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

		private static final long serialVersionUID = 1L;

	}

	class ContentPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;
		private TeamMemberInfoPanel firstTeamMemberInfoPanel;
		private TeamMemberInfoPanel secondTeamMemberInfoPanel;
		private TeamInfoComparePanel teamInfoComparePanel;

		ContentPanel() {
			card = new CardLayout();
			this.setOpaque(false);
			this.setLayout(card);
			//
			firstTeamMemberInfoPanel = new TeamMemberInfoPanel(firstTeamPlayerPerform);
			secondTeamMemberInfoPanel = new TeamMemberInfoPanel(secondTeamPlayerPerform);
			teamInfoComparePanel = new TeamInfoComparePanel();
			//
			this.add(firstTeamMemberInfoPanel, "firstTeamMemberInfoPanel");
			this.add(secondTeamMemberInfoPanel, "secondTeamMemberInfoPanel");
			this.add(teamInfoComparePanel, "teamInfoComparePanel");
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(firstTeamMemberInfoButton)) {
			contentPanel.card.show(contentPanel, "firstTeamMemberInfoPanel");
			firstTeamMemberInfoButton.setBackground(MyColor.DEEP_COLOR);
			secondTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			teamMatchInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(secondTeamMemberInfoButton)) {
			contentPanel.card.show(contentPanel, "secondTeamMemberInfoPanel");
			firstTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			secondTeamMemberInfoButton.setBackground(MyColor.DEEP_COLOR);
			teamMatchInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(teamMatchInfoButton)) {
			contentPanel.card.show(contentPanel, "teamInfoComparePanel");
			firstTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			secondTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			teamMatchInfoButton.setBackground(MyColor.DEEP_COLOR);
		}
		else if (e.getSource().equals(firstTeamLogo)) {
			OneTeamPanel teamPanel = new OneTeamPanel(generalOneMatch.getFirstTeamName());
			SonFrame.changePanel(thisPanel, teamPanel);
		}
		else if (e.getSource().equals(secondTeamLogo)) {
			OneTeamPanel teamPanel = new OneTeamPanel(generalOneMatch.getSecondTeamName());
			SonFrame.changePanel(thisPanel, teamPanel);
		}
	}

	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(firstTeamMemberInfoButton)) {
			firstTeamMemberInfoButton.setBorderPainted(true);
		}
		else if (e.getSource().equals(secondTeamMemberInfoButton)) {
			secondTeamMemberInfoButton.setBorderPainted(true);
		}
		else if (e.getSource().equals(teamMatchInfoButton)) {
			teamMatchInfoButton.setBorderPainted(true);
		}
	}

	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(firstTeamMemberInfoButton)) {
			firstTeamMemberInfoButton.setBorderPainted(false);
		}
		else if (e.getSource().equals(secondTeamMemberInfoButton)) {
			secondTeamMemberInfoButton.setBorderPainted(false);
		}
		else if (e.getSource().equals(teamMatchInfoButton)) {
			teamMatchInfoButton.setBorderPainted(false);
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
