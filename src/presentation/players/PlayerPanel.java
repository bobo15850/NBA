package presentation.players;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import presentation.DetailPanel;
import vo.GeneralInfoOfPlayerVo;
import vo.OnePlayerPerformOfOneSeasonVo;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyScrollPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mycomponent.MyTextField;
import common.mydatastructure.Season;
import common.statics.NUMBER;
import common.statics.PathOfFile;
import common.statics.ResultMessage;
import common.statics.images.Images;
import common.statics.StringToEnum;

public class PlayerPanel extends MyPanel {

	private static final long serialVersionUID = 1L;
	private PlayerInfoBlService playerInfoBl;
	private PlayerPerformShowPanel performShowPanel;
	private PlayerGeneralInfoPanel generalInfoPanel;
	public static ArrayList<OnePlayerPerformOfOneSeasonVo> currentPlayerVoList;

	public PlayerPanel() {
		playerInfoBl = new PlayerInfoBl();
		performShowPanel = new PlayerPerformShowPanel();
		generalInfoPanel = new PlayerGeneralInfoPanel();
		this.setLayout(null);
		performShowPanel.setBounds(NUMBER.DETAIL_PANEL_WIDTH, 0, NUMBER.DATA_PANEL_WIDTH, NUMBER.DATA_PANEL_HEIGHT);
		generalInfoPanel.setBounds(0, 0, NUMBER.DETAIL_PANEL_WIDTH, NUMBER.DETAIL_PANEL_HEIGHT);
		this.add(performShowPanel);
		this.add(generalInfoPanel);
		this.setVisible(true);
	}

	class PlayerPerformShowPanel extends MyPanel implements MouseListener {

		private static final long serialVersionUID = 1L;

		private final int buttonWidth = (int) (NUMBER.px * 160);
		private final int buttonHeight = (int) (NUMBER.px * 40);
		private final int inter = (int) (NUMBER.px * 30);
		private final int inputWidth = (int) (NUMBER.px * 200);
		private Season season = new Season("2013-2014");
		private MyButton playerSelection, seasonChoose, showAll;// 按钮
		private MyTextField playerNameInput;// 搜索输入框
		private MyLabel playerNameInputLabel;// 搜索提示标签
		private String performance[] = { "所属球队", "参赛场数", "先发场数", "场均在场时间", "总在场时间", "效率值", "Gmsc效率值", "场均得分", "总得分", "场均篮板", "总篮板", "场均助攻", "总助攻",
				"场均抢断", "总抢断", "场均盖帽", "总盖帽", "两双次数", "三双次数", "场均进攻篮板", "总进攻篮板", "场均防守篮板", "总防守篮板", "场均失误", "总失误", "场均犯规", "总犯规", "投篮命中率", "三分命中率",
				"罚球命中率", "使用率", "真实命中率", "投篮效率", "助攻率", "篮板率", "抢断率", "盖帽率", "进攻篮板率", "防守篮板率", "失误率" };
		private String rangeAndName[] = { "排名", "姓名" };
		private MyScrollPanel scrollPane;
		private MyTable performanceTable, rangeAndNameTable;// 表格
		private MyTableModel performanceModel, rangeAndNameModel;// 表格的内容
		private ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerPerformVoList;
		private boolean ascend = false;// 设置当前默认为升序

		public PlayerPerformShowPanel() {
			this.createObjects();
			this.setComponentsLocation();
			this.addListener();
			this.initTable();
			this.setTableStyle();
		}

		private void createObjects() {
			playerSelection = new MyButton(Images.PLAYER_SELECTION_BUTTON, buttonWidth, buttonHeight);
			seasonChoose = new MyButton(Images.SEASON_CHOOSE_BUTTON, buttonWidth, buttonHeight);
			showAll = new MyButton(Images.SHOW_ALL_BUTTON, buttonWidth, buttonHeight);
			playerNameInput = new MyTextField();
			playerNameInputLabel = new MyLabel(Images.NAME_INPUT);
			//
			performanceModel = new MyTableModel(performance);
			performanceTable = new MyTable(performanceModel);
			rangeAndNameModel = new MyTableModel(rangeAndName);
			rangeAndNameTable = new MyTable(rangeAndNameModel);
			//
			allPlayerPerformVoList = playerInfoBl.getOneSeasonPerformOfAllPlayer(season);
			currentPlayerVoList = allPlayerPerformVoList;
		}

		private void setComponentsLocation() {
			seasonChoose.setLocation((int) (NUMBER.px * 30), (int) (NUMBER.px * 36));
			playerSelection.setLocation((int) (NUMBER.px * 30 + inter + buttonWidth), (int) (NUMBER.px * 36));
			showAll.setLocation((int) (NUMBER.px * 30 + inter * 2 + buttonWidth * 2), (int) (NUMBER.px * 36));
			playerNameInputLabel.setBounds((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4), (int) (NUMBER.px * 42), inputWidth * 3 / 2,
					buttonHeight * 4 / 5);
			playerNameInput.setBounds(10, 0, inputWidth * 3 / 2, buttonHeight * 4 / 5);
			this.add(seasonChoose);
			this.add(playerSelection);
			this.add(showAll);
			this.playerNameInputLabel.add(playerNameInput);
			this.add(playerNameInputLabel);
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
			scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rangeAndNameTable.getTableHeader());
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setOpaque(false);
			scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			this.add(scrollPane);
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

		private void initTable() {
			this.fillTable(allPlayerPerformVoList);
		}

		private void fillTable(ArrayList<OnePlayerPerformOfOneSeasonVo> voList) {
			for (int i = 0; i < voList.size(); i++) {
				String performRow[] = voList.get(i).toStringArray();
				String infoRow[] = { String.valueOf(i + 1), voList.get(i).getNameOfPlayer() };
				performanceModel.addRow(performRow);
				rangeAndNameModel.addRow(infoRow);
			}
			performanceTable.updateUI();
			rangeAndNameTable.updateUI();
		}

		private void clearTable() {
			performanceModel.removeAllRows();
			rangeAndNameModel.removeAllRows();
		}

		private void addListener() {
			performanceTable.addMouseListener(this);
			rangeAndNameTable.addMouseListener(this);
			playerSelection.addMouseListener(this);
			seasonChoose.addMouseListener(this);
			showAll.addMouseListener(this);
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
				playerInfoBl.ascendingSort(currentPlayerVoList, StringToEnum.toPerformanceOfPlayer(table.getColumnName(column)));
			} else {
				playerInfoBl.descendingSort(currentPlayerVoList, StringToEnum.toPerformanceOfPlayer(table.getColumnName(column)));
			}
			this.clearTable();
			this.fillTable(currentPlayerVoList);
			ascend = !ascend;
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(performanceTable)) {
				if (performanceTable.getSelectedRow() >= 0 && performanceTable.getSelectedRow() < performanceTable.getRowCount()) {
					int row = performanceTable.getSelectedRow();
					String playerName = (String) rangeAndNameTable.getValueAt(row, 1);
					generalInfoPanel.updateInfo(playerName);
				}
			} else if (e.getSource().equals(rangeAndNameTable)) {
				if (rangeAndNameTable.getSelectedRow() >= 0 && rangeAndNameTable.getSelectedRow() < rangeAndNameTable.getRowCount()) {
					int row = rangeAndNameTable.getSelectedRow();
					String playerName = (String) rangeAndNameTable.getValueAt(row, 1);
					generalInfoPanel.updateInfo(playerName);
				}
			} else if (e.getSource().equals(playerSelection)) {
				SelectPlayerDialog selectPlayerDialog = new SelectPlayerDialog(season, allPlayerPerformVoList, performanceModel, rangeAndNameModel,
						performanceTable, rangeAndNameTable);
				selectPlayerDialog.setBounds((NUMBER.SCREEN_WIDTH - (int) (NUMBER.px * 500)) / 2,
						(NUMBER.SCREEN_HEIGHT - (int) (NUMBER.px * 600)) / 2, (int) (NUMBER.px * 500), (int) (NUMBER.px * 600));
				selectPlayerDialog.setModal(false);
			} else if (e.getSource().equals(showAll)) {
				PlayerPanel.currentPlayerVoList = this.allPlayerPerformVoList;
				this.clearTable();
				this.fillTable(allPlayerPerformVoList);
			} else if (e.getSource().equals(seasonChoose)) {

			}
		}

		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(playerSelection)) {
				playerSelection.setMyIcon(Images.PLAYER_SELECTION_ENTER_BUTTON);
			} else if (e.getSource().equals(showAll)) {
				showAll.setMyIcon(Images.SHOW_ALL_ENTER_BUTTON);
			}
		}

		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(playerSelection)) {
				playerSelection.setMyIcon(Images.PLAYER_SELECTION_BUTTON);
			} else if (e.getSource().equals(showAll)) {
				showAll.setMyIcon(Images.SHOW_ALL_BUTTON);
			}
		}

		public void mousePressed(MouseEvent e) {
			if (e.getSource().equals(playerSelection)) {
				playerSelection.setMyIcon(Images.PLAYER_SELECTION_CLICK_BUTTON);
			} else if (e.getSource().equals(showAll)) {
				showAll.setMyIcon(Images.SHOW_ALL_CLICK_BUTTON);
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (e.getSource().equals(playerSelection)) {
				playerSelection.setMyIcon(Images.PLAYER_SELECTION_BUTTON);
			} else if (e.getSource().equals(showAll)) {
				showAll.setMyIcon(Images.SHOW_ALL_BUTTON);
			}
		}
	}

	class PlayerGeneralInfoPanel extends DetailPanel {

		private static final long serialVersionUID = 1L;
		private MyLabel portraitLabel, nameLabel, numLabel, positionLabel, ageLabel, heightLabel, weightLabel, birthLabel, schoolLabel, expLabel,
				nameShowLabel, numShowLabel, positionShowLabel, ageShowLabel, heightShowLabel, weightShowLabel, birthShowLabel, schoolShowLabel,
				expShowLabel;

		public PlayerGeneralInfoPanel() {
			this.createObjects();
			this.setComponentsLocation();
		}

		public void updateInfo(String playerName) {
			GeneralInfoOfPlayerVo generalInfoOfPlayerVo = playerInfoBl.getGeneralInfoOfOnePlayer(playerName);
			this.nameShowLabel.setTextAndStyle(playerName);
			this.portraitLabel.setIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + playerName + ".png"));
			String notClear = "不清楚";
			if (generalInfoOfPlayerVo.equals(ResultMessage.NOTEXIST_GENERAL_PLAYER_VO)) {
				this.numShowLabel.setTextAndStyle(notClear);
				this.positionShowLabel.setTextAndStyle(notClear);
				this.ageShowLabel.setTextAndStyle(notClear);
				this.heightShowLabel.setTextAndStyle(notClear);
				this.weightShowLabel.setTextAndStyle(notClear);
				this.birthShowLabel.setTextAndStyle(notClear);
				this.schoolShowLabel.setTextAndStyle(notClear);
				this.expShowLabel.setTextAndStyle(notClear);
				this.repaint();
			} else {
				this.numShowLabel.setTextAndStyle(generalInfoOfPlayerVo.getNumber());
				this.positionShowLabel.setTextAndStyle(String.valueOf(generalInfoOfPlayerVo.getPosition()));
				this.ageShowLabel.setTextAndStyle(String.valueOf(generalInfoOfPlayerVo.getAge()));
				this.heightShowLabel.setTextAndStyle(generalInfoOfPlayerVo.getHeight().getFeetAndInchAsStringOfHeight());
				this.weightShowLabel.setTextAndStyle(String.valueOf(generalInfoOfPlayerVo.getWeight().getPoundOfWeight()));
				this.birthShowLabel.setTextAndStyle(generalInfoOfPlayerVo.getBirthday().getFormatString());
				this.schoolShowLabel.setTextAndStyle(generalInfoOfPlayerVo.getShool());
				if (generalInfoOfPlayerVo.getTrainingYear() == -1) {
					this.expShowLabel.setTextAndStyle(notClear);
				} else {
					this.expShowLabel.setTextAndStyle(String.valueOf(generalInfoOfPlayerVo.getTrainingYear()));
				}

				this.repaint();
			}
		}

		private void createObjects() {
			portraitLabel = new MyLabel(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + "kobe bryant.png"));
			nameLabel = new MyLabel("姓名：");
			numLabel = new MyLabel("号码：");
			positionLabel = new MyLabel("位置：");
			ageLabel = new MyLabel("年龄：");
			heightLabel = new MyLabel("身高：");
			weightLabel = new MyLabel("体重：");
			birthLabel = new MyLabel("生日：");
			schoolLabel = new MyLabel("学校：");
			expLabel = new MyLabel("球龄：");
			nameShowLabel = new MyLabel("kobe bryant");
			numShowLabel = new MyLabel("24");
			positionShowLabel = new MyLabel("G");
			ageShowLabel = new MyLabel("35");
			heightShowLabel = new MyLabel("6-6");
			weightShowLabel = new MyLabel("205");
			birthShowLabel = new MyLabel("1978-8-23");
			schoolShowLabel = new MyLabel("Lower Merion HS PA");
			expShowLabel = new MyLabel("17");
		}

		private void setComponentsLocation() {
			portraitLabel.setBounds((int) (NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 200) / 2, (int) (NUMBER.px * 46), (int) (NUMBER.px * 220),
					(int) (NUMBER.px * 220));
			nameLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 280), labelWidth,
					labelHeight);
			numLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 320), labelWidth,
					labelHeight);
			positionLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 360), labelWidth,
					labelHeight);
			ageLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 400), labelWidth,
					labelHeight);
			heightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 440), labelWidth,
					labelHeight);
			weightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 480), labelWidth,
					labelHeight);
			birthLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 520), labelWidth,
					labelHeight);
			schoolLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 560), labelWidth,
					labelHeight);
			expLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20), (int) (NUMBER.px * 600), labelWidth,
					labelHeight);
			nameShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 280),
					showlabelWidth, labelHeight);
			numShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 320),
					showlabelWidth, labelHeight);
			positionShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 360),
					showlabelWidth, labelHeight);
			ageShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 400),
					showlabelWidth, labelHeight);
			heightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 440),
					showlabelWidth, labelHeight);
			weightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 480),
					showlabelWidth, labelHeight);
			birthShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 520),
					showlabelWidth, labelHeight);
			schoolShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 560),
					showlabelWidth, labelHeight);
			expShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90), (int) (NUMBER.px * 600),
					showlabelWidth, labelHeight);
			this.add(portraitLabel);
			this.add(nameLabel);
			this.add(numLabel);
			this.add(positionLabel);
			this.add(ageLabel);
			this.add(heightLabel);
			this.add(weightLabel);
			this.add(expLabel);
			this.add(schoolLabel);
			this.add(birthLabel);
			this.add(nameShowLabel);
			this.add(numShowLabel);
			this.add(positionShowLabel);
			this.add(ageShowLabel);
			this.add(heightShowLabel);
			this.add(weightShowLabel);
			this.add(birthShowLabel);
			this.add(expShowLabel);
			this.add(schoolShowLabel);
		}
	}
}
