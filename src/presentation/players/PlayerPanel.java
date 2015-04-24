package presentation.players;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.SonFrame;
import start.Main;
import businesslogic.players.OnePlayerInfoBl;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;
import common.mycomponent.MyButton;
import common.mycomponent.MyComboBox;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyScrollPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mydatastructure.CombineSelectionCell;
import common.mydatastructure.Filter;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.SortCell;
import common.statics.Age;
import common.statics.Command;
import common.statics.Field;
import common.statics.League;
import common.statics.Method;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;
import common.statics.Position;

public class PlayerPanel extends MyPanel {
	private SelectionPanel selectionPanel;
	private JScrollPane playerShowPane;
	private MyTable playerShowTable, rangeAndNameTable;
	private MyTableModel playerTableModel, rangeAndNameTableModel;
	private static final long serialVersionUID = 1L;
	private String PerformanceList[] = { "球队", "场数", "时间", "效率", "得分", "命中率", "篮板", "助攻", "抢断", "盖帽", "两双", "三双", "失误", "犯规", "三分命中率", "罚球命中率" };
	private String rangeAndNamePerformance[] = { "排名", "头像", "姓名" };
	private PlayerInfoBlService playerInfoBl = new PlayerInfoBl();

	public PlayerPanel() {
		this.createObjects();
		this.setComponentsLocation();
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

			public void mouseClicked(MouseEvent e) {
				if (rangeAndNameTable.getSelectedRow() >= 0 && rangeAndNameTable.getSelectedRow() < rangeAndNameTable.getRowCount()) {
					int row = rangeAndNameTable.getSelectedRow();
					String teamName = (String) rangeAndNameTable.getValueAt(row, 2);
					new SonFrame(teamName, SonFrame.playerCard);
				}
			}
		});
	}

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
			Object infoRow[] = {
					String.valueOf(i + 1),
					Method.changeSize(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + voList.get(i).getName() + ".png"), (int) (60 * NUMBER.px),
							(int) (55 * NUMBER.px)), voList.get(i).getName() };
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
		selectionPanel = new SelectionPanel();
		playerShowPane = new JScrollPane();
		playerShowPane.getViewport().add(playerShowTable);
	}

	private void setComponentsLocation() {
		selectionPanel.setLocation((int) (NUMBER.px * 50), (int) (NUMBER.px * 20));
		playerShowPane.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 100), (int) (NUMBER.FRAME_WIDTH - 100), (int) (NUMBER.px * 600));
		this.add(selectionPanel);
		this.add(playerShowPane);
	}

	private void setTableStyle() {
		rangeAndNameTable.setTableColumnWidth(1, (int) (NUMBER.px * 60));
		rangeAndNameTable.setTableColumnWidth(2, (int) (NUMBER.px * 120));
		playerShowPane.getViewport().setOpaque(false);
		playerShowPane.setOpaque(false);
		playerShowPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		playerShowTable.setAllTableColumnWidth((int) (NUMBER.px * 50));
		playerShowTable.setTableColumnWidth(5, (int) (NUMBER.px * 65));
		for (int i = 14; i < 16; i++) {
			playerShowTable.setTableColumnWidth(i, (int) (NUMBER.px * 85));
		}
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
		private JButton advancedSelect, searchButton, findButton;
		private JTextField playerInput;
		private MyComboBox<String> positionChoose, leagueChoose, selectCellChoose, totOrAvgChoose, ageChoose;
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
			findButton = new JButton("查找球员");
			advancedSelect = new JButton("高级搜索");
			searchButton = new JButton("搜索");
			playerInput = new JTextField();
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
			positionChoose.setLocation(0, (int) (NUMBER.px * 42));
			leagueChoose.setLocation((int) (NUMBER.px * 190), (int) (NUMBER.px * 42));
			ageChoose.setLocation((int) (NUMBER.px * 380), (int) (NUMBER.px * 42));
			selectCellChoose.setLocation((int) (NUMBER.px * 570), (int) (NUMBER.px * 42));
			totOrAvgChoose.setLocation((int) (NUMBER.px * 760), (int) (NUMBER.px * 42));
			searchButton.setBounds((int) (NUMBER.px * 1000), (int) (NUMBER.px * 42), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
			advancedSelect.setBounds((int) (NUMBER.px * 850), 0, (int) (NUMBER.px * 150), (int) (NUMBER.px * 35));
			findButton.setBounds((int) (NUMBER.px * 600), 0, (int) (NUMBER.px * 180), (int) (NUMBER.px * 35));
			playerInput.setBounds((int) (NUMBER.px * 100), 0, (int) (NUMBER.px * 400), (int) (NUMBER.px * 35));
			this.add(positionChoose);
			this.add(leagueChoose);
			this.add(ageChoose);
			this.add(advancedSelect);
			this.add(selectCellChoose);
			this.add(searchButton);
			this.add(findButton);
			this.add(playerInput);
			this.add(totOrAvgChoose);
		}

		private void setComponentsStyle() {
			this.setButton(advancedSelect);
			this.setButton(searchButton);
			this.setButton(findButton);
			playerInput.setOpaque(false);
			playerInput.setForeground(MyColor.MY_WHITE);
			playerInput.setFont(MyFont.SMALL_BOLD);

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
				new AdvancedSelectionJdialog();
			}
			else if (e.getSource().equals(findButton)) {
				String playerName = playerInput.getText();
				if (playerName.equals("") || playerName == null) {
					JOptionPane.showMessageDialog(Main.mainFrame, "请输入要查找的球员");// 弹出提示
				}
				else {
					PlayerNormalInfo_Expand playerNormal = new OnePlayerInfoBl().getPlayerNormalInfo_avg(playerName);
					if (playerNormal == null) {
						JOptionPane.showMessageDialog(Main.mainFrame, "不存在该球员");// 弹出提示
					}
					else {
						new SonFrame(playerName, SonFrame.playerCard);
					}
				}
			}
		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(searchButton)) {
				searchButton.setBackground(MyColor.DEEP_COLOR);
			}
			else if (e.getSource().equals(advancedSelect)) {
				advancedSelect.setBackground(MyColor.DEEP_COLOR);
			}
			else if (e.getSource().equals(findButton)) {
				findButton.setBackground(MyColor.DEEP_COLOR);
			}

		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(searchButton)) {
				searchButton.setBackground(MyColor.MIDDLE_COLOR);
			}
			else if (e.getSource().equals(advancedSelect)) {
				advancedSelect.setBackground(MyColor.MIDDLE_COLOR);
			}
			else if (e.getSource().equals(findButton)) {
				findButton.setBackground(MyColor.MIDDLE_COLOR);
			}
		}

		public void mousePressed(MouseEvent e) {

		}

		public void mouseReleased(MouseEvent e) {

		}
	}

	protected class AdvancedSelectionJdialog extends JDialog implements MouseListener {
		private MyScrollPanel hasChooseJscrollPane;
		private MyLabel advancedSelectionLabel;
		private MyTable hasChooseTable;
		private MyTableModel hasChooseTableModel;
		private MyButton addItemButton, deletButton;
		private MyButton sureButton, cancelButton;
		private JTextField valueInput;
		private MyComboBox<String> selectionChoose;
		private String selectionItemList[] = { "得分", "篮板", "助攻", "抢断", "盖帽", "总命中率", "三分命中率", "罚球命中率" };
		private String header[] = { "筛选依据", "大于数值" };
		private static final long serialVersionUID = 1L;
		private AdvancedSelectionJdialog advancedSelectionJdialog = this;
		private PlayerInfoBlService playerInfoBl;

		public AdvancedSelectionJdialog() {
			super(Main.mainFrame, true);
			this.setLayout(null);
			this.setUndecorated(true);
			this.setSize((int) (NUMBER.px * 800), (int) (NUMBER.px * 600));
			this.setLocation((NUMBER.SCREEN_WIDTH - this.getWidth()) / 2, (NUMBER.SCREEN_HEIGHT - this.getHeight()) / 2);
			this.createObjects();
			this.setComponentsLocation();
			this.addListener();
			this.setComponentsStyle();
			this.setVisible(true);
		}

		private void createObjects() {
			hasChooseTableModel = new MyTableModel(header);
			hasChooseTable = new MyTable(hasChooseTableModel);
			hasChooseJscrollPane = new MyScrollPanel(hasChooseTable);
			addItemButton = new MyButton("添加筛选项");
			deletButton = new MyButton("移除筛选项");
			sureButton = new MyButton("确认");
			cancelButton = new MyButton("取消");
			advancedSelectionLabel = new MyLabel("高级筛选");
			valueInput = new JTextField("在此输入数值");
			selectionChoose = new MyComboBox<>(selectionItemList);
			playerInfoBl = new PlayerInfoBl();
		}

		private void setComponentsLocation() {
			advancedSelectionLabel.setBounds((int) (NUMBER.px * 0), (int) (NUMBER.px * 0), this.getWidth(), (int) (NUMBER.px * 50));
			selectionChoose.setBounds((int) (NUMBER.px * 20), (int) (NUMBER.px * 70), (int) (NUMBER.px * 200), (int) (NUMBER.px * 40));
			valueInput.setBounds((int) (NUMBER.px * 240), (int) (NUMBER.px * 70), (int) (NUMBER.px * 200), (int) (NUMBER.px * 40));
			cancelButton.setBounds(this.getWidth() / 2, (int) (NUMBER.px * 551), this.getWidth() / 2, (int) (NUMBER.px * 50));
			sureButton.setBounds(0, (int) (NUMBER.px * 551), this.getWidth() / 2, (int) (NUMBER.px * 50));
			deletButton.setBounds((int) (NUMBER.px * 630), (int) (NUMBER.px * 70), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
			addItemButton.setBounds((int) (NUMBER.px * 460), (int) (NUMBER.px * 70), (int) (NUMBER.px * 150), (int) (NUMBER.px * 40));
			hasChooseJscrollPane.setBounds((int) (NUMBER.px * 20), (int) (NUMBER.px * 130), (int) (NUMBER.px * 760), (int) (NUMBER.px * 400));

			this.add(advancedSelectionLabel);
			this.add(selectionChoose);
			this.add(valueInput);
			this.add(cancelButton);
			this.add(sureButton);
			this.add(deletButton);
			this.add(addItemButton);
			this.add(hasChooseJscrollPane);
		}

		private void addListener() {
			addItemButton.addMouseListener(this);
			deletButton.addMouseListener(this);
			sureButton.addMouseListener(this);
			cancelButton.addMouseListener(this);
			valueInput.addMouseListener(this);
		}

		private void setComponentsStyle() {
			advancedSelectionLabel.setHorizontalAlignment(SwingConstants.CENTER);
			advancedSelectionLabel.setOpaque(true);
			advancedSelectionLabel.setBackground(MyColor.MIDDLE_COLOR);
			advancedSelectionLabel.setForeground(MyColor.MY_WHITE);
			advancedSelectionLabel.setFont(MyFont.MIDDLE_BOLD);
			valueInput.setOpaque(false);
			valueInput.setFont(MyFont.SMALLEST_BOLD);
			addItemButton.setBackground(MyColor.MIDDLE_COLOR);
			deletButton.setBackground(MyColor.MIDDLE_COLOR);
			sureButton.setBackground(MyColor.MIDDLE_COLOR);
			cancelButton.setBackground(MyColor.MIDDLE_COLOR);
			addItemButton.setContentAreaFilled(true);
			deletButton.setContentAreaFilled(true);
			sureButton.setContentAreaFilled(true);
			cancelButton.setContentAreaFilled(true);
			hasChooseTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(cancelButton)) {
				advancedSelectionJdialog.dispose();
			}
			else if (e.getSource().equals(sureButton)) {

				if (hasChooseTableModel.getRowCount() == 0) {
					JOptionPane.showMessageDialog(advancedSelectionJdialog, "请添加筛选项");// 弹出提示，请添加筛选项
				}
				else {
					CombineSelectionCell combineSelectionCells[] = new CombineSelectionCell[hasChooseTable.getRowCount()];
					for (int i = 0; i < hasChooseTable.getRowCount(); i++) {
						combineSelectionCells[i] = new CombineSelectionCell();
						combineSelectionCells[i].setField(changeToSortField((String) hasChooseTableModel.getValueAt(i, 0)));
						combineSelectionCells[i].setNumber(Double.parseDouble((String) hasChooseTableModel.getValueAt(i, 1)));
					}
					clearTable();
					fillTable(playerInfoBl.getPlayerNormal_avg(combineSelectionCells));
					advancedSelectionJdialog.dispose();
				}
			}
			else if (e.getSource().equals(addItemButton)) {
				try {
					Double.parseDouble(valueInput.getText());
					String str[] = { (String) selectionChoose.getSelectedItem(), valueInput.getText() };
					hasChooseTableModel.addRow(str);
					hasChooseTable.updateUI();
				} catch (NumberFormatException a) {
					JOptionPane.showMessageDialog(advancedSelectionJdialog, "输入必须为数");
				}

			}
			else if (e.getSource().equals(deletButton)) {
				int index = hasChooseTable.getSelectedRow();
				if (index >= 0) {
					hasChooseTableModel.removeRow(index);
					hasChooseTable.updateUI();
				}
				else {
					JOptionPane.showMessageDialog(advancedSelectionJdialog, "请选中移除行");
				}

			}
			else if (e.getSource().equals(valueInput)) {
				valueInput.setText("");
				valueInput.setForeground(MyColor.DEEP_COLOR);
			}
		}

		private String changeToSortField(String valueAt) {
			String[] sortField = { Field.point, Field.rebound, Field.assist, Field.steal, Field.blockShot, Field.shot, Field.three, Field.penalty };
			for (int i = 0; i < selectionItemList.length; i++) {
				if (valueAt.equals(selectionItemList[i])) {
					return sortField[i];
				}
			}
			return null;
		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(cancelButton)) {
				cancelButton.setBackground(MyColor.DEEP_COLOR);
			}
			else if (e.getSource().equals(sureButton)) {
				sureButton.setBackground(MyColor.DEEP_COLOR);
			}
			else if (e.getSource().equals(addItemButton)) {
				addItemButton.setBackground(MyColor.DEEP_COLOR);
			}
			else if (e.getSource().equals(deletButton)) {
				deletButton.setBackground(MyColor.DEEP_COLOR);
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(cancelButton)) {
				cancelButton.setBackground(MyColor.MIDDLE_COLOR);
			}
			else if (e.getSource().equals(sureButton)) {
				sureButton.setBackground(MyColor.MIDDLE_COLOR);
			}
			else if (e.getSource().equals(addItemButton)) {
				addItemButton.setBackground(MyColor.MIDDLE_COLOR);
			}
			else if (e.getSource().equals(deletButton)) {
				deletButton.setBackground(MyColor.MIDDLE_COLOR);
			}
		}

		public void mousePressed(MouseEvent arg0) {

		}

		public void mouseReleased(MouseEvent arg0) {

		}

	}
}
