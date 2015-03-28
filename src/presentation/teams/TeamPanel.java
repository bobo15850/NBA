package presentation.teams;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.DetailPanel;
import vo.GeneralInfoOfTeamVo;
import vo.OneTeamPerformOfOneSeasonVo;
import businesslogic.teams.TeamInfoBl;
import businesslogicservice.teams.TeamInfoBlService;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyScrollPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mycomponent.MyTextField;
import common.mydatastructure.Season;
import common.statics.MyColor;
import common.statics.NUMBER;
import common.statics.PathOfFile;
import common.statics.ResultMessage;
import common.statics.StringToEnum;
import common.statics.images.Images;

public class TeamPanel extends MyPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeamInfoBlService teamInfoBl;
	private TeamPerformShowPanel performShowPanel;
	private TeamGeneralInfoPanel generalInfoPanel;
	public static ArrayList<OneTeamPerformOfOneSeasonVo> currentTeamVoList;

	public TeamPanel() {
		teamInfoBl = new TeamInfoBl();
		performShowPanel = new TeamPerformShowPanel();
		generalInfoPanel = new TeamGeneralInfoPanel();
		this.setLayout(null);
		performShowPanel.setBounds(NUMBER.DETAIL_PANEL_WIDTH, 0, NUMBER.DATA_PANEL_WIDTH, NUMBER.DATA_PANEL_HEIGHT);
		generalInfoPanel.setBounds(0, 0, NUMBER.DETAIL_PANEL_WIDTH, NUMBER.DETAIL_PANEL_HEIGHT);
		this.add(performShowPanel);
		this.add(generalInfoPanel);
		this.setVisible(true);
	}

	public class TeamPerformShowPanel extends MyPanel implements MouseListener {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final int buttonWidth = (int) (NUMBER.px * 160);
		private final int buttonHeight = (int) (NUMBER.px * 40);
		private final int inter = (int) (NUMBER.px * 30);
		private final int inputWidth = (int) (NUMBER.px * 200);
		private Season season = new Season("2013-2014");
		private MyButton seasonChoose, teamSearch;
		private MyTextField teamNameInput;
		private MyLabel teamNameInputLabel;
		String performance[] = { "比赛场数", "胜率", "场均得分数", "总得分数", "场均投篮命中数", "总投篮命中数", "场均总投篮出手数", "总投篮出手数", "投篮命中率", "场均三分命中数", "总三分命中数", "场均三分出手数",
				"总三分出手数", "三分命中率", "场均罚球命中数", "总罚球命中数", "场均罚球出手数", "总罚球出手数", "罚球命中率", "场均进攻篮板数", "总进攻篮板数", "场均防守篮板数", "总防守篮板", "场均总篮板", "总篮板",
				"场均助攻", "总助攻", "场均抢断", "总抢断数", "场均盖帽", "总盖帽数", "场均失误数", "总失误数", "场均犯规数", "总犯规数", "场均进攻回合", "总进攻回合数", "进攻效率", "防守效率", "篮板效率", "抢断率",
				"助攻率" };
		String rangeAndName[] = { "排名", "球队名称" };
		private MyScrollPanel scrollPane;
		private MyTable performanceTable, rangeAndNameTable;// 表格
		private MyTableModel performanceModel, rangeAndNameModel;// 表格的内容
		private ArrayList<OneTeamPerformOfOneSeasonVo> allTeamPerformVoList;
		private boolean ascend = false;// 设置当前默认为升序

		public TeamPerformShowPanel() {
			this.createObjects();
			this.setComponentsLocation();
			this.addListener();
			this.initTable();
			this.setTableStyle();
		}

		private void createObjects() {
			seasonChoose = new MyButton(Images.SEASON_CHOOSE_BUTTON, buttonWidth, buttonHeight);
			teamSearch = new MyButton(Images.SEARCH_BUTTON, (int) (NUMBER.px * 22), (int) (NUMBER.px * 22));
			teamNameInput = new MyTextField();
			teamNameInputLabel = new MyLabel(Images.NAME_INPUT);
			//
			performanceModel = new MyTableModel(performance);
			performanceTable = new MyTable(performanceModel);
			rangeAndNameModel = new MyTableModel(rangeAndName);
			rangeAndNameTable = new MyTable(rangeAndNameModel);
			//
			allTeamPerformVoList = teamInfoBl.getOneSeasonPerformOfAllTeam(season);
			currentTeamVoList = allTeamPerformVoList;
		}

		private void setComponentsLocation() {
			seasonChoose.setLocation((int) (NUMBER.px * 30), (int) (NUMBER.px * 36));
			teamSearch.setLocation((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4 + NUMBER.px * 170), (int) (NUMBER.px * 36));
			teamNameInputLabel.setBounds((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4), (int) (NUMBER.px * 42), inputWidth * 3 / 2,
					buttonHeight * 4 / 5);
			teamNameInput.setBounds(10, 0, inputWidth * 3 / 2, buttonHeight * 4 / 5);
			teamNameInput.setForeground(MyColor.MY_WHITE);
			this.add(seasonChoose);
			this.add(teamSearch);
			teamNameInputLabel.add(teamNameInput);
			this.add(teamNameInputLabel);
		}

		private void setTableStyle() {
			performanceTable.setAllTableColumnWidth(160);
			rangeAndNameTable.setTableColumnWidth(1, 150);
			performanceTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					checkSelection(false);
				}
			});
			rangeAndNameTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					checkSelection(true);
				}
			});

			JViewport viewport = new JViewport();
			viewport.setOpaque(false);
			viewport.setView(rangeAndNameTable);
			viewport.setPreferredSize(rangeAndNameTable.getPreferredSize());
			//
			scrollPane = new MyScrollPanel(performanceTable);
			scrollPane.setBounds((int) (NUMBER.px * 30), (int) (NUMBER.px * 101), (int) (NUMBER.px * 950), (int) (NUMBER.px * 570));
			scrollPane.setRowHeaderView(viewport);
			scrollPane.setCorner(MyScrollPanel.UPPER_LEFT_CORNER, rangeAndNameTable.getTableHeader());
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setOpaque(false);
			scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			this.add(scrollPane);
		}

		private void initTable() {
			for (int i = 0; i < allTeamPerformVoList.size(); i++) {
				String performRow[] = allTeamPerformVoList.get(i).toStringArray();
				String infoRow[] = { String.valueOf(i + 1), allTeamPerformVoList.get(i).getTeamName() };
				performanceModel.addRow(performRow);
				rangeAndNameModel.addRow(infoRow);
			}
		}

		private void addListener() {
			performanceTable.addMouseListener(this);
			rangeAndNameTable.addMouseListener(this);
			performanceTable.getTableHeader().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					if (event.getSource() == performanceTable.getTableHeader()) {
						int column = performanceTable.columnAtPoint(event.getPoint());
						sort(performanceTable, column);
					}
				}
			});
			rangeAndNameTable.getTableHeader().addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent event) {
					if (event.getSource() == rangeAndNameTable.getTableHeader()) {
						int column = rangeAndNameTable.columnAtPoint(event.getPoint());
						sort(rangeAndNameTable, column);
					}
				}
			});
		}

		private void sort(MyTable table, int column) {
			if (ascend) {
				teamInfoBl.ascendingSort(currentTeamVoList, StringToEnum.toPerformanceOfTeam(table.getColumnName(column)));
			} else {
				teamInfoBl.descendingSort(currentTeamVoList, StringToEnum.toPerformanceOfTeam(table.getColumnName(column)));
			}
			performanceModel.removeAllRows();
			rangeAndNameModel.removeAllRows();
			for (int j = 0; j < currentTeamVoList.size(); j++) {
				String row1[] = currentTeamVoList.get(j).toStringArray();
				String row2[] = { String.valueOf(j + 1), currentTeamVoList.get(j).getTeamName() };
				performanceModel.addRow(row1);
				rangeAndNameModel.addRow(row2);
			}
			performanceTable.updateUI();
			rangeAndNameTable.updateUI();
			ascend = !ascend;
		}

		private void checkSelection(boolean isFixedTable) {
			int fixedSelectedIndex = rangeAndNameTable.getSelectedRow();
			int selectedIndex = performanceTable.getSelectedRow();
			if (fixedSelectedIndex != selectedIndex) {
				if (isFixedTable) {
					performanceTable.setRowSelectionInterval(fixedSelectedIndex, fixedSelectedIndex);
				} else {
					rangeAndNameTable.setRowSelectionInterval(selectedIndex, selectedIndex);
				}
			}
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(performanceTable)) {
				if (performanceTable.getSelectedRow() >= 0 && performanceTable.getSelectedRow() < performanceTable.getRowCount()) {
					int row = performanceTable.getSelectedRow();
					String teamName = (String) rangeAndNameTable.getValueAt(row, 1);
					generalInfoPanel.updateInfo(teamName);
				}
			} else if (e.getSource().equals(rangeAndNameTable)) {
				if (performanceTable.getSelectedRow() >= 0 && performanceTable.getSelectedRow() < performanceTable.getRowCount()) {
					int row = performanceTable.getSelectedRow();
					String teamName = (String) rangeAndNameTable.getValueAt(row, 1);
					generalInfoPanel.updateInfo(teamName);
				}
			} else if (e.getSource().equals(seasonChoose)) {

			} else if (e.getSource().equals(teamSearch)) {

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
	}

	public class TeamGeneralInfoPanel extends DetailPanel {

		private static final long serialVersionUID = 1L;
		private MyLabel logoLabel, nameLabel, nameForShortLabel, placeLabel, zoneLabel, partitionZoneLabel, homeCourtLabel, setUpTimeLabel,
				nameShowLabel, nameForShortShowLabel, placeShowLabel, zoneShowLabel, partitionZoneShowLabel, homeCourtShowLabel, setUpTimeShowLabel;

		public TeamGeneralInfoPanel() {
			super();
			this.createObjects();
			this.setComponentsLocation();
		}

		public void updateInfo(String teamNameForShort) {
			String notClear = "不清楚";
			GeneralInfoOfTeamVo generalInfoOfTeamVo = teamInfoBl.getGeneralInfoOfOneTeam(teamNameForShort);
			logoLabel.setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + teamNameForShort + ".png"));
			if (generalInfoOfTeamVo.equals(ResultMessage.NOTEXIST_GENERAL_TEAM_VO)) {
				nameShowLabel.setTextAndStyle(notClear);
				nameForShortShowLabel.setTextAndStyle(notClear);
				placeShowLabel.setTextAndStyle(notClear);
				zoneShowLabel.setTextAndStyle(notClear);
				partitionZoneShowLabel.setTextAndStyle(notClear);
				homeCourtShowLabel.setTextAndStyle(notClear);
				setUpTimeShowLabel.setTextAndStyle(notClear);
			} else {
				nameShowLabel.setTextAndStyle(generalInfoOfTeamVo.getTeamName());
				nameForShortShowLabel.setTextAndStyle(generalInfoOfTeamVo.getTeamNameForShort());
				placeShowLabel.setTextAndStyle(generalInfoOfTeamVo.getLocation());
				zoneShowLabel.setTextAndStyle(String.valueOf(generalInfoOfTeamVo.getConference()));
				partitionZoneShowLabel.setTextAndStyle(String.valueOf(generalInfoOfTeamVo.getDivision()));
				homeCourtShowLabel.setTextAndStyle(generalInfoOfTeamVo.getHomeField());
				setUpTimeShowLabel.setTextAndStyle(String.valueOf(generalInfoOfTeamVo.getEstablishYear()));
			}
		}

		private void createObjects() {
			logoLabel = new MyLabel();
			nameLabel = new MyLabel("球队全名：");
			nameForShortLabel = new MyLabel("缩写：");
			placeLabel = new MyLabel("所在地：");
			zoneLabel = new MyLabel("赛区：");
			partitionZoneLabel = new MyLabel("分区：");
			homeCourtLabel = new MyLabel("主场：");
			setUpTimeLabel = new MyLabel("建立时间：");
			nameShowLabel = new MyLabel();
			nameForShortShowLabel = new MyLabel();
			placeShowLabel = new MyLabel();
			zoneShowLabel = new MyLabel();
			partitionZoneShowLabel = new MyLabel();
			homeCourtShowLabel = new MyLabel();
			setUpTimeShowLabel = new MyLabel();
		}

		private void setComponentsLocation() {
			logoLabel.setBounds((int) (NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 200) / 2, (int) (NUMBER.px * 36), (int) (NUMBER.px * 220),
					(int) (NUMBER.px * 220));
			//
			nameLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 270), labelWidth,
					labelHeight);
			nameForShortLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 320),
					labelWidth, labelHeight);
			placeLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 370), labelWidth,
					labelHeight);
			zoneLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 420), labelWidth,
					labelHeight);
			partitionZoneLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 470),
					labelWidth, labelHeight);
			homeCourtLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 520), labelWidth,
					labelHeight);
			setUpTimeLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 570), labelWidth,
					labelHeight);
			//
			nameShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 160) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 270), labelWidth,
					labelHeight);
			nameForShortShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 320),
					labelWidth, labelHeight);
			placeShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 180) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 370), labelWidth,
					labelHeight);
			zoneShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 420), labelWidth,
					labelHeight);
			partitionZoneShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 470),
					labelWidth, labelHeight);
			homeCourtShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 520),
					labelWidth, labelHeight);
			setUpTimeShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 160) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 570),
					labelWidth, labelHeight);
			this.add(logoLabel);
			this.add(nameLabel);
			this.add(nameForShortLabel);
			this.add(placeLabel);
			this.add(zoneLabel);
			this.add(partitionZoneLabel);
			this.add(homeCourtLabel);
			this.add(setUpTimeLabel);
			this.add(nameShowLabel);
			this.add(nameForShortShowLabel);
			this.add(placeShowLabel);
			this.add(zoneShowLabel);
			this.add(partitionZoneShowLabel);
			this.add(homeCourtShowLabel);
			this.add(setUpTimeShowLabel);
		}
	}
}
