package presentation.players;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;
import common.mycomponent.MyComboBox;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mydatastructure.Filter;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.SortCell;
import common.statics.Age;
import common.statics.Command;
import common.statics.Field;
import common.statics.League;
import common.statics.MyColor;
import common.statics.NUMBER;
import common.statics.Position;

public class PlayerPanel extends MyPanel {
	private SelectionPanel selectionPanel;
	private JScrollPane playerShowPane;
	private MyTable playerShowTable, rangeAndNameTable;
	private MyTableModel playerTableModel, rangeAndNameTableModel;
	private static final long serialVersionUID = 1L;
	private String PerformanceList[] = { "所属球队", "参赛场数", "在场时间", "效率值", "得分", "投篮命中率", "篮板", "助攻", "抢断", "盖帽", "两双次数", "三双次数", "失误", "犯规", "三分命中率",
			"罚球命中率" };
	private String rangeAndNamePerformance[] = { "排名", "头像", "姓名" };
	private PlayerInfoBlService playerInfoBl = new PlayerInfoBl();

	public PlayerPanel() {
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.initTable();
		this.setTableStyle();
		this.setTableRender();
	}

	private void setTableRender() {}

	private void initTable() {
		Filter filter = new Filter();
		filter.setAge(Age.All);
		filter.setLeague(League.All);
		filter.setPosition(Position.All);
		SortCell[] sortcells = new SortCell[1];
		sortcells[0] = new SortCell(Field.point + Command.dot + Command.descend);
		ArrayList<PlayerNormalInfo_Expand> playerNormalList = this.playerInfoBl.getPlayerNormal_avg(NUMBER.DEFAULT_NUMBER, filter, sortcells);
		this.fillTable(playerNormalList);
	}

	private void fillTable(ArrayList<PlayerNormalInfo_Expand> voList) {
		for (int i = 0; i < voList.size(); i++) {
			String performRow[] = voList.get(i).toStringArray();
			String infoRow[] = { String.valueOf(i + 1), "头像", voList.get(i).getName() };
			playerTableModel.addRow(performRow);
			rangeAndNameTableModel.addRow(infoRow);
		}
		playerShowTable.updateUI();
		rangeAndNameTable.updateUI();
	}

	private void clearTable() {
		playerTableModel.removeAllRows();
		rangeAndNameTableModel.removeAllRows();
	}

	private void createObjects() {
		playerTableModel = new MyTableModel(PerformanceList);
		rangeAndNameTableModel = new MyTableModel(rangeAndNamePerformance);
		playerShowTable = new MyTable(playerTableModel);
		rangeAndNameTable = new MyTable(rangeAndNameTableModel);
		selectionPanel = new SelectionPanel();
		playerShowPane = new JScrollPane();
		playerShowPane.getViewport().add(playerShowTable);
	}

	private void setComponentsLocation() {
		selectionPanel.setLocation((int) (NUMBER.px * 50), (int) (NUMBER.px * 20));
		playerShowPane.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 100), (int) (NUMBER.FRAME_WIDTH - 100), (int) (NUMBER.px * 580));
		this.add(selectionPanel);
		this.add(playerShowPane);
	}

	private void setComponentsStyle() {
	}

	private void setTableStyle() {
		playerShowPane.getViewport().setOpaque(false);
		playerShowPane.setOpaque(false);
		playerShowPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		playerShowTable.setAllTableColumnWidth((int) (NUMBER.px * 150));
		rangeAndNameTable.setTableColumnWidth(1, (int) (NUMBER.px * 150));
		rangeAndNameTable.setTableColumnWidth(2, (int) (NUMBER.px *200));
		playerShowTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
		playerShowPane.setRowHeaderView(viewport);
		playerShowPane.getRowHeader().setOpaque(false);
		playerShowPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rangeAndNameTable.getTableHeader());
	}

	private void checkSelection(boolean isFixedTable) {
		int fixedSelectedIndex = rangeAndNameTable.getSelectedRow();
		int selectedIndex = playerShowTable.getSelectedRow();
		if (fixedSelectedIndex != selectedIndex) {
			if (isFixedTable) {
				playerShowTable.setRowSelectionInterval(fixedSelectedIndex, fixedSelectedIndex);
			}
			else {
				rangeAndNameTable.setRowSelectionInterval(selectedIndex, selectedIndex);
			}
		}
	}

	class SelectionPanel extends MyPanel implements MouseListener {
		private static final long serialVersionUID = 1L;
		JButton advancedSelect, searchButton;
		MyComboBox<String> positionChoose, leagueChoose, selectCellChoose, totOrAvgChoose, ageChoose;
		private String[] ageArray = { Age.All, Age.L_E_22, Age.M_22_L_E_25, Age.M_25_L_E_30, Age.M_30 };
		private String[] leagueArray = { League.All, League.East, League.West };
		private String[] positionArray = { Position.All, Position.G, Position.F, Position.C };
		private String[] sortField = { Field.point, Field.rebound, Field.assist, Field.steal, Field.blockShot, Field.foul, Field.fault, Field.minute,
				Field.shot, Field.three, Field.penalty, Field.offendRound, Field.defendRebound, Field.numOfGame };

		public SelectionPanel() {
			this.setSize((int) (NUMBER.FRAME_WIDTH - 100), (int) (NUMBER.px * 80));
			this.setBackground(MyColor.LIGHT_COLOR);
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
		}

		private void createObjects() {
			advancedSelect = new JButton("高级搜索");
			searchButton = new JButton("搜索");
			String[] totOrAvg = { "场均数据", "总数据" };
			String[] ageList = { "全部年龄", "小于等于22岁", "大于22岁小于等于25岁", "大于25岁小于等于30", "大于等于30岁" };
			String[] conferenceList = { "全联盟", "东部", "西部" };
			String[] positionList = { "全部位置", "后卫", "前锋", "中锋" };
			String[] selectCellList = { "得分", "篮板", "助攻", "抢断", "盖帽", "犯规", "失误", "分钟", "投篮命中率", "三分命中率", "罚球命中率", "进攻篮板", "防守篮板", "比赛场数" };
			ageChoose = new MyComboBox<>(ageList);
			positionChoose = new MyComboBox<String>(positionList);
			leagueChoose = new MyComboBox<String>(conferenceList);
			selectCellChoose = new MyComboBox<String>(selectCellList);
			totOrAvgChoose = new MyComboBox<>(totOrAvg);
		}

		private void setComponentsLocation() {
			positionChoose.setLocation(0, (int) (NUMBER.px * 20));
			leagueChoose.setLocation((int) (NUMBER.px * 190), (int) (NUMBER.px * 20));
			ageChoose.setLocation((int) (NUMBER.px * 380), (int) (NUMBER.px * 20));
			selectCellChoose.setLocation((int) (NUMBER.px * 570), (int) (NUMBER.px * 20));
			totOrAvgChoose.setLocation((int) (NUMBER.px * 760), (int) (NUMBER.px * 20));
			searchButton.setBounds((int) (NUMBER.px * 1000), (int) (NUMBER.px * 20), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
			advancedSelect.setBounds((int) (NUMBER.px * 1180), (int) (NUMBER.px * 20), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
			this.add(positionChoose);
			this.add(leagueChoose);
			this.add(ageChoose);
			this.add(advancedSelect);
			this.add(selectCellChoose);
			this.add(searchButton);
			this.add(totOrAvgChoose);
		}

		private void setComponentsStyle() {
			advancedSelect.setFocusable(false);
			advancedSelect.setBorderPainted(false);
			advancedSelect.setForeground(MyColor.LIGHT_COLOR);
			advancedSelect.setBackground(MyColor.MIDDLE_COLOR);
			searchButton.setFocusable(false);
			searchButton.setBorderPainted(false);
			searchButton.setForeground(MyColor.LIGHT_COLOR);
			searchButton.setBackground(MyColor.MIDDLE_COLOR);
			searchButton.addMouseListener(this);
			advancedSelect.addMouseListener(this);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(searchButton)) {
				int age = ageChoose.getSelectedIndex();
				int totOrAvg = totOrAvgChoose.getSelectedIndex();
				int league = leagueChoose.getSelectedIndex();
				int position = positionChoose.getSelectedIndex();
				int sortCell = selectCellChoose.getSelectedIndex();
				Filter filter = new Filter();
				filter.setAge(ageArray[age]);
				filter.setLeague(leagueArray[league]);
				filter.setPosition(positionArray[position]);
				SortCell sort = new SortCell(sortField[sortCell] + Command.dot + Command.descend);
				if (totOrAvg == 0) {
					ArrayList<PlayerNormalInfo_Expand> playerNormalList = playerInfoBl.getPlayerNormal_avg(NUMBER.DEFAULT_NUMBER, filter,
							new SortCell[] { sort });
					clearTable();
					fillTable(playerNormalList);
				}
				else if (totOrAvg == 1) {
					ArrayList<PlayerNormalInfo_Expand> playerNormalList = playerInfoBl.getPlayerNormal_tot(NUMBER.DEFAULT_NUMBER, filter,
							new SortCell[] { sort });
					clearTable();
					fillTable(playerNormalList);
				}
			}
			else if (e.getSource().equals(advancedSelect)) {

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
}
