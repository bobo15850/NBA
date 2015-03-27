package presentation.players;

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
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mycomponent.MyTextField;
import common.mydatastructure.Season;
import common.statics.NUMBER;
import common.statics.PathOfFile;
import common.statics.ResultMessage;
import common.statics.images.Images;

public class PlayerPanel extends MyPanel {

	private static final long serialVersionUID = 1L;
	private PlayerInfoBlService playerInfoBl;
	private PlayerPerformShowPanel performShowPanel;
	private PlayerGeneralInfoPanel generalInfoPanel;

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
		private MyButton playerSelection, playerSort, seasonChoose, playerSearch;// 按钮
		private MyTextField playerNameInput;// 搜索输入框
		private MyLabel playerNameInputLabel;// 搜索提示标签
		private String performance[] = { "所属球队", "参赛场数", "先发场数", "场均在场时间", "总在场时间", "效率值", "Gmsc效率值", "场均得分", "总得分",
				"场均篮板", "总篮板", "场均助攻", "总助攻", "场均抢断", "总抢断", "场均盖帽", "总盖帽", "两双次数", "三双次数", "场均进攻篮板", "总进攻篮板",
				"场均防守篮板", "总防守篮板", "场均失误", "总失误", "场均犯规", "总犯规", "投篮命中率", "三分命中率", "罚球命中率", "使用率", "真实命中率", "投篮效率",
				"助攻率", "篮板率", "盖帽率", "抢断率", "进攻篮板率", "防守篮板率", "失误率" };
		private String rangeAndName[] = { "排名", "姓名" };
		private JScrollPane scrollPane;
		private MyTable performanceTable, rangeAndNameTable;// 表格
		private MyTableModel performanceModel, rangeAndNameModel;// 表格的内容
		private ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerPerformVoList;

		public PlayerPerformShowPanel() {
			this.createObjects();
			this.setComponentsLocation();
			this.addListener();
			this.initTable();
			this.setTableStyle();
		}

		private void createObjects() {
			playerSelection = new MyButton(Images.PLAYER_SCREENING, buttonWidth, buttonHeight);
			playerSort = new MyButton(Images.SORT_PLAYER, buttonWidth, buttonHeight);
			seasonChoose = new MyButton(Images.CHOOSE, buttonWidth, buttonHeight);
			playerSearch = new MyButton(Images.SEARCH, (int) (NUMBER.px * 22), (int) (NUMBER.px * 22));
			playerNameInput = new MyTextField();
			playerNameInputLabel = new MyLabel(Images.NAME_INPUT);
			//
			performanceModel = new MyTableModel(performance);
			performanceTable = new MyTable(performanceModel);
			rangeAndNameModel = new MyTableModel(rangeAndName);
			rangeAndNameTable = new MyTable(rangeAndNameModel);
			//
			allPlayerPerformVoList = playerInfoBl.getOneSeasonPerformOfAllPlayer(season);
		}

		private void setComponentsLocation() {
			seasonChoose.setLocation((int) (NUMBER.px * 30), (int) (NUMBER.px * 36));
			playerSort.setLocation((int) (NUMBER.px * 30 + inter * 2 + buttonWidth * 2), (int) (NUMBER.px * 36));
			playerSelection.setLocation((int) (NUMBER.px * 30 + inter * 3 + buttonWidth * 3), (int) (NUMBER.px * 36));
			playerSearch.setLocation((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4 + NUMBER.px * 170),
					(int) (NUMBER.px * 36));
			playerNameInputLabel.setBounds((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4),
					(int) (NUMBER.px * 36), inputWidth, buttonHeight);
			playerNameInput.setBounds(10, 0, (int) (NUMBER.px * 150), buttonHeight);
			this.add(seasonChoose);
			this.add(playerSelection);
			this.add(playerSearch);
			this.add(playerSort);
			this.playerNameInputLabel.add(playerNameInput);
			this.add(playerNameInputLabel);
		}

		protected void setTableStyle() {
			performanceTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					checkSelection(false);
				}
			});
			rangeAndNameTable.getColumnModel().getColumn(1).setPreferredWidth((int) (120 * NUMBER.px));
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
			scrollPane = new JScrollPane(performanceTable);
			scrollPane.setBounds((int) (NUMBER.px * 30), (int) (NUMBER.px * 101), (int) (NUMBER.px * 950),
					(int) (NUMBER.px * 570));
			scrollPane.setRowHeaderView(viewport);
			scrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, rangeAndNameTable.getTableHeader());
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setOpaque(false);
			scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			this.add(scrollPane);
		}

		private void initTable() {
			for (int i = 0; i < allPlayerPerformVoList.size(); i++) {
				String performRow[] = allPlayerPerformVoList.get(i).toStringArray();
				String infoRow[] = { String.valueOf(i + 1), allPlayerPerformVoList.get(i).getNameOfPlayer() };
				performanceModel.addRow(performRow);
				rangeAndNameModel.addRow(infoRow);
			}
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

		private void addListener() {
			performanceTable.addMouseListener(this);
			rangeAndNameTable.addMouseListener(this);
			playerSelection.addMouseListener(this);
			seasonChoose.addMouseListener(this);
			playerSearch.addMouseListener(this);
			playerSort.addMouseListener(this);
		}

		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(performanceTable)) {
				if (performanceTable.getSelectedRow() >= 0
						&& performanceTable.getSelectedRow() < performanceTable.getRowCount()) {
					int row = performanceTable.getSelectedRow();
					String playerName = (String) rangeAndNameTable.getValueAt(row, 1);
					generalInfoPanel.updateInfo(playerName);
				}
			} else if (e.getSource().equals(rangeAndNameTable)) {
				if (rangeAndNameTable.getSelectedRow() >= 0
						&& rangeAndNameTable.getSelectedRow() < rangeAndNameTable.getRowCount()) {
					int row = rangeAndNameTable.getSelectedRow();
					String playerName = (String) rangeAndNameTable.getValueAt(row, 1);
					generalInfoPanel.updateInfo(playerName);
				}
			} else if (e.getSource().equals(playerSelection)) {
				SelectPlayerDialog selectPlayerDialog = new SelectPlayerDialog(season, allPlayerPerformVoList,
						performanceModel, rangeAndNameModel, performanceTable, rangeAndNameTable);
				selectPlayerDialog.setBounds((int) (NUMBER.px * 450), (int) (NUMBER.px * 200), (int) (NUMBER.px * 600),
						(int) (NUMBER.px * 600));
				selectPlayerDialog.setModal(false);
			} else if (e.getSource().equals(seasonChoose)) {

			} else if (e.getSource().equals(playerSearch)) {

			} else if (e.getSource().equals(playerSort)) {

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

	class PlayerGeneralInfoPanel extends DetailPanel {

		private static final long serialVersionUID = 1L;
		private MyLabel portraitLabel, nameLabel, numLabel, positionLabel, ageLabel, heightLabel, weightLabel,
				birthLabel, schoolLabel, expLabel, nameShowLabel, numShowLabel, positionShowLabel, ageShowLabel,
				heightShowLabel, weightShowLabel, birthShowLabel, schoolShowLabel, expShowLabel;

		public PlayerGeneralInfoPanel() {
			this.createObjects();
			this.setComponentsLocation();
		}

		public void updateInfo(String playerName) {
			GeneralInfoOfPlayerVo generalInfoOfPlayerVo = playerInfoBl.getGeneralInfoOfOnePlayer(playerName);
			this.nameShowLabel.setText(playerName);
			this.portraitLabel.setIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + playerName + ".png"));
			if (generalInfoOfPlayerVo.equals(ResultMessage.NOTEXIST_GENERAL_PLAYER_VO)) {
				String notClear = "不清楚";
				this.numShowLabel.setText(notClear);
				this.positionShowLabel.setText(notClear);
				this.ageShowLabel.setText(notClear);
				this.heightShowLabel.setText(notClear);
				this.weightShowLabel.setText(notClear);
				this.birthShowLabel.setText(notClear);
				this.schoolShowLabel.setText(notClear);
				this.expShowLabel.setText(notClear);
				this.repaint();
			} else {
				this.numShowLabel.setText(generalInfoOfPlayerVo.getNumber());
				this.positionShowLabel.setText(String.valueOf(generalInfoOfPlayerVo.getPosition()));
				this.ageShowLabel.setText(String.valueOf(generalInfoOfPlayerVo.getAge()));
				this.heightShowLabel.setText(generalInfoOfPlayerVo.getHeight().getFeetAndInchAsStringOfHeight());
				this.weightShowLabel.setText(String.valueOf(generalInfoOfPlayerVo.getWeight().getPoundOfWeight()));
				this.birthShowLabel.setText(generalInfoOfPlayerVo.getBirthday().getFormatString());
				this.schoolShowLabel.setText(generalInfoOfPlayerVo.getShool());
				this.expShowLabel.setText(String.valueOf(generalInfoOfPlayerVo.getTrainingYear()));
				this.repaint();
			}
		}

		private void createObjects() {
			portraitLabel = new MyLabel();
			nameLabel = new MyLabel("姓名：");
			numLabel = new MyLabel("号码：");
			positionLabel = new MyLabel("位置：");
			ageLabel = new MyLabel("年龄：");
			heightLabel = new MyLabel("身高：");
			weightLabel = new MyLabel("体重：");
			birthLabel = new MyLabel("生日：");
			schoolLabel = new MyLabel("学校：");
			expLabel = new MyLabel("经验：");
			nameShowLabel = new MyLabel();
			numShowLabel = new MyLabel();
			positionShowLabel = new MyLabel();
			ageShowLabel = new MyLabel();
			heightShowLabel = new MyLabel();
			weightShowLabel = new MyLabel();
			birthShowLabel = new MyLabel();
			schoolShowLabel = new MyLabel();
			expShowLabel = new MyLabel();
		}

		private void setComponentsLocation() {
			portraitLabel.setBounds((int) (NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 200) / 2, (int) (NUMBER.px * 76),
					(int) (NUMBER.px * 220), (int) (NUMBER.px * 220));
			nameLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 310), labelWidth, labelHeight);
			numLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 350), labelWidth, labelHeight);
			positionLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 390), labelWidth, labelHeight);
			ageLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 430), labelWidth, labelHeight);
			heightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 470), labelWidth, labelHeight);
			weightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 510), labelWidth, labelHeight);
			birthLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 550), labelWidth, labelHeight);
			schoolLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 590), labelWidth, labelHeight);
			expLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
					(int) (NUMBER.px * 630), labelWidth, labelHeight);
			nameShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 310), showlabelWidth, labelHeight);
			numShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 350), showlabelWidth, labelHeight);
			positionShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 390), showlabelWidth, labelHeight);
			ageShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 430), showlabelWidth, labelHeight);
			heightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 470), showlabelWidth, labelHeight);
			weightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 510), showlabelWidth, labelHeight);
			birthShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 550), showlabelWidth, labelHeight);
			schoolShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 590), showlabelWidth, labelHeight);
			expShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
					(int) (NUMBER.px * 630), showlabelWidth, labelHeight);
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
