package presentation.teams;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import businesslogic.teams.TeamInfoBl;
import businesslogicservice.teams.TeamInfoBlService;
import common.mycomponent.MyComboBox;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mydatastructure.SortCell;
import common.mydatastructure.TeamNormalInfo_Expand;
import common.statics.Command;
import common.statics.Field;
import common.statics.MyColor;
import common.statics.NUMBER;

public class TeamPanel extends MyPanel {
	private static final long serialVersionUID = 1L;
	private SelectionPanel selectionPanel;// 筛选界面
	private JScrollPane teamShowPane;// 展示界面
	private MyTable teamShowTable, rangeAndNameTable;
	private MyTableModel teamShowTableModel, rangeAndNameTableModel;
	private String performanceList[] = { "得分", "篮板", "助攻", "抢断", "盖帽", "犯规", "失误", "投篮命中率", "三分命中率", "罚球命中率", "进攻篮板", "防守篮板" };
	private String rangeAndName[] = { "排名", "队标", "球队名称" };
	private TeamInfoBlService teamInfoBl = new TeamInfoBl();

	public TeamPanel() {
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.initTable();
		this.setTableStyle();
	}

	private void initTable() {
		SortCell[] sortcells = new SortCell[1];
		sortcells[0] = new SortCell(Field.point + Command.dot + Command.descend);
		ArrayList<TeamNormalInfo_Expand> playerNormalList = this.teamInfoBl.getTeamNormal_avg(NUMBER.DEFAULT_NUMBER, sortcells);
		this.fillTable(playerNormalList);
	}

	private void fillTable(ArrayList<TeamNormalInfo_Expand> voList) {
		for (int i = 0; i < voList.size(); i++) {
			String performRow[] = voList.get(i).toStringArray();
			String infoRow[] = { String.valueOf(i + 1), "队标", voList.get(i).getTeamName() };
			teamShowTableModel.addRow(performRow);
			rangeAndNameTableModel.addRow(infoRow);
		}
		teamShowTable.updateUI();
		rangeAndNameTable.updateUI();
	}

	private void clearTable() {
		teamShowTableModel.removeAllRows();
		rangeAndNameTableModel.removeAllRows();
	}

	private void setTableStyle() {
		teamShowPane.getViewport().setOpaque(false);
		teamShowPane.setOpaque(false);
		teamShowPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		teamShowTable.setAllTableColumnWidth((int) (NUMBER.px * 150));
		rangeAndNameTable.setTableColumnWidth(1, (int) (NUMBER.px * 150));
		teamShowTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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
		teamShowPane.setRowHeaderView(viewport);
		teamShowPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rangeAndNameTable.getTableHeader());

	}

	private void checkSelection(boolean isFixedTable) {
		int fixedSelectedIndex = rangeAndNameTable.getSelectedRow();
		int selectedIndex = teamShowTable.getSelectedRow();
		if (fixedSelectedIndex != selectedIndex) {
			if (isFixedTable) {
				teamShowTable.setRowSelectionInterval(fixedSelectedIndex, fixedSelectedIndex);
			}
			else {
				rangeAndNameTable.setRowSelectionInterval(selectedIndex, selectedIndex);
			}
		}
	}

	private void setComponentsLocation() {
		selectionPanel.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 0), (int) (NUMBER.FRAME_WIDTH - 100), (int) (NUMBER.px * 60));
		teamShowPane.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 70), (int) (NUMBER.FRAME_WIDTH - 100), (int) (NUMBER.px * 650));
		this.add(teamShowPane);
		this.add(selectionPanel);
	}

	private void createObjects() {
		selectionPanel = new SelectionPanel();
		teamShowTableModel = new MyTableModel(performanceList);
		rangeAndNameTableModel = new MyTableModel(rangeAndName);
		teamShowTable = new MyTable(teamShowTableModel);
		rangeAndNameTable = new MyTable(rangeAndNameTableModel);
		teamShowPane = new JScrollPane();
		teamShowPane.getViewport().add(teamShowTable);
	}

	private void setComponentsStyle() {

	}

	class SelectionPanel extends MyPanel implements MouseListener {
		private static final long serialVersionUID = 1L;
		JButton searchButton;
		MyComboBox<String> selectCellChoose, totOrAvgChoose;
		private String[] sortField = { Field.point, Field.rebound, Field.assist, Field.steal, Field.blockShot, Field.foul, Field.fault, Field.shot,
				Field.three, Field.penalty, Field.offendRound, Field.defendRebound };

		public SelectionPanel() {
			this.setSize((int) (NUMBER.FRAME_WIDTH - 100), (int) (NUMBER.px * 100));
			this.setBackground(MyColor.LIGHT_COLOR);
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.setVisible(true);
		}

		private void createObjects() {
			searchButton = new JButton("搜索");
			String[] totOrAvg = { "场均数据", "总数据" };
			String[] selectCellList = { "得分", "篮板", "助攻", "抢断", "盖帽", "犯规", "失误", "投篮命中率", "三分命中率", "罚球命中率", "进攻篮板", "防守篮板" };
			selectCellChoose = new MyComboBox<String>(selectCellList);
			totOrAvgChoose = new MyComboBox<>(totOrAvg);
		}

		private void setComponentsLocation() {
			selectCellChoose.setLocation((int) (NUMBER.px * 200), (int) (NUMBER.px * 20));
			totOrAvgChoose.setLocation((int) (NUMBER.px * 500), (int) (NUMBER.px * 20));
			searchButton.setBounds((int) (NUMBER.px * 800), (int) (NUMBER.px * 20), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
			this.add(selectCellChoose);
			this.add(searchButton);
			this.add(totOrAvgChoose);
		}

		private void setComponentsStyle() {
			searchButton.setFocusable(false);
			searchButton.setBorderPainted(false);
			searchButton.setForeground(MyColor.LIGHT_COLOR);
			searchButton.setBackground(MyColor.MIDDLE_COLOR);
			searchButton.addMouseListener(this);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(searchButton)) {
				int totOrAvg = totOrAvgChoose.getSelectedIndex();
				int sortCell = selectCellChoose.getSelectedIndex();
				SortCell sort = new SortCell(sortField[sortCell] + Command.dot + Command.descend);
				if (totOrAvg == 0) {
				}
				else if (totOrAvg == 1) {
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
	}
}
