package presentation.teams;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.SonFrame;
import start.Main;
import businesslogic.teams.OneTeamInfoBl;
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
import common.statics.Method;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class TeamPanel extends MyPanel {
	private static final long serialVersionUID = 1L;
	private SelectionPanel selectionPanel;// 筛选界面
	private JScrollPane teamShowPane;// 展示界面
	private MyTable teamShowTable, rangeAndNameTable;
	private MyTableModel teamShowTableModel, rangeAndNameTableModel;
	private String performanceList[] = { "得分", "篮板", "助攻", "抢断", "盖帽", "犯规", "失误", "投篮命中率", "三分命中率", "罚球命中率", "前板", "后板" };
	private String rangeAndName[] = { "排名", "队标", "队名" };
	private TeamInfoBlService teamInfoBl = new TeamInfoBl();

	public TeamPanel() {
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.initTable();
		this.setTableStyle();
		rangeAndNameTable.addMouseListener(new MouseListener() {

			public void mouseReleased(MouseEvent e) {

			}

			public void mousePressed(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseClicked(MouseEvent arg0) {
				if (rangeAndNameTable.getSelectedRow() >= 0 && rangeAndNameTable.getSelectedRow() < rangeAndNameTable.getRowCount()) {
					int row = rangeAndNameTable.getSelectedRow();
					String teamName = (String) rangeAndNameTable.getValueAt(row, 2);
					new SonFrame(teamName, SonFrame.teamCard);
				}
			}
		});
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
			Object infoRow[] = {
					String.valueOf(i + 1),
					Method.changeSize(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + voList.get(i).getTeamName() + ".png"), (int) (60 * NUMBER.px),
							(int) (55 * NUMBER.px)), voList.get(i).getTeamName() };
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
		for (int i = 0; i < 12; i++) {
			teamShowTable.setTableColumnWidth(i, (int) (NUMBER.px * 75));
		}
		for (int i = 7; i < 10; i++) {
			teamShowTable.setTableColumnWidth(i, (int) (NUMBER.px * 96));
		}
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
		selectionPanel.setLocation((int) (NUMBER.px * 50), (int) (NUMBER.px * 20));
		teamShowPane.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 100), (int) (NUMBER.FRAME_WIDTH - 100), (int) (NUMBER.px * 600));
		this.add(teamShowPane);
		this.add(selectionPanel);
	}

	private void createObjects() {
		selectionPanel = new SelectionPanel();
		teamShowTableModel = new MyTableModel(performanceList);
		rangeAndNameTableModel = new MyTableModel(rangeAndName);
		teamShowTable = new MyTable(teamShowTableModel);
		rangeAndNameTable = new MyTable(rangeAndNameTableModel) {
			private static final long serialVersionUID = 1L;

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column) {
				if (column == 1) {// 要这样定义table，要重写这个方法0，0的意思就是别的格子的类型都跟0,0的一样。
					return ImageIcon.class;
				}
				else {
					return getValueAt(0, 0).getClass();
				}
			}

		};
		teamShowPane = new JScrollPane();
		teamShowPane.getViewport().add(teamShowTable);
	}

	private void setComponentsStyle() {

	}

	class SelectionPanel extends MyPanel implements MouseListener {
		private static final long serialVersionUID = 1L;
		private JButton searchButton, findTeamButton;
		private JTextField teamInput;
		private MyComboBox<String> selectCellChoose, totOrAvgChoose;
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
			teamInput = new JTextField();
			searchButton = new JButton("搜索");
			findTeamButton = new JButton("查找球队");
			String[] totOrAvg = { "场均数据", "总数据" };
			String[] selectCellList = { "得分", "篮板", "助攻", "抢断", "盖帽", "犯规", "失误", "投篮命中率", "三分命中率", "罚球命中率", "进攻篮板", "防守篮板" };
			selectCellChoose = new MyComboBox<String>(selectCellList);
			totOrAvgChoose = new MyComboBox<>(totOrAvg);
		}

		private void setComponentsLocation() {
			findTeamButton.setBounds((int) (NUMBER.px * 800), 0, (int) (NUMBER.px * 150), (int) (NUMBER.px * 35));
			teamInput.setBounds((int) (NUMBER.px * 200), 0, (int) (NUMBER.px * 400), (int) (NUMBER.px * 35));
			selectCellChoose.setLocation((int) (NUMBER.px * 100), (int) (NUMBER.px * 42));
			totOrAvgChoose.setLocation((int) (NUMBER.px * 450), (int) (NUMBER.px * 42));
			searchButton.setBounds((int) (NUMBER.px * 900), (int) (NUMBER.px * 42), (int) (NUMBER.px * 180), (int) (NUMBER.px * 35));
			this.add(teamInput);
			this.add(findTeamButton);
			this.add(selectCellChoose);
			this.add(searchButton);
			this.add(totOrAvgChoose);
		}

		private void setComponentsStyle() {
			this.setButton(searchButton);
			this.setButton(findTeamButton);
			teamInput.setOpaque(false);
			teamInput.setForeground(MyColor.MY_WHITE);
			teamInput.setFont(MyFont.SMALL_BOLD);
		}

		private void setButton(JButton button) {
			button.setFocusable(false);
			button.setBorderPainted(false);
			button.setFont(MyFont.SMALLEST_BOLD);
			button.setForeground(MyColor.MY_WHITE);
			button.setBackground(MyColor.MIDDLE_COLOR);
			button.addMouseListener(this);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(searchButton)) {
				int totOrAvg = totOrAvgChoose.getSelectedIndex();
				int sortCell = selectCellChoose.getSelectedIndex();
				SortCell sort = new SortCell(sortField[sortCell] + Command.dot + Command.descend);
				if (totOrAvg == 0) {
					ArrayList<TeamNormalInfo_Expand> teamNormalList_avg = teamInfoBl.getTeamNormal_avg(30, new SortCell[] { sort });
					clearTable();
					fillTable(teamNormalList_avg);
				}
				else if (totOrAvg == 1) {
					ArrayList<TeamNormalInfo_Expand> teamNormalList_tot = teamInfoBl.getTeamNormal_tot(30, new SortCell[] { sort });
					clearTable();
					fillTable(teamNormalList_tot);
				}
			}
			else if (e.getSource().equals(findTeamButton)) {
				String teamNameInput = teamInput.getText();
				if (teamNameInput.equals("") || teamNameInput == null) {
					JOptionPane.showMessageDialog(Main.mainFrame, "请输入要查找的球队");// 弹出提示
				}
				else {
					TeamNormalInfo_Expand teamNormal = new OneTeamInfoBl().getTeamNormalInfo_avg(teamNameInput);
					if (teamNormal == null) {
						JOptionPane.showMessageDialog(Main.mainFrame, "不存在该球队");// 弹出提示
					}
					else {
						new SonFrame(teamNameInput, SonFrame.teamCard);
					}
				}
			}
		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(searchButton)) {
				searchButton.setBackground(MyColor.DEEP_COLOR);
			}
			else if (e.getSource().equals(findTeamButton)) {
				findTeamButton.setBackground(MyColor.DEEP_COLOR);
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(searchButton)) {
				searchButton.setBackground(MyColor.MIDDLE_COLOR);
			}
			else if (e.getSource().equals(findTeamButton)) {
				findTeamButton.setBackground(MyColor.MIDDLE_COLOR);
			}
		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}
	}
}
