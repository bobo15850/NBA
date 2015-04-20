package presentation.players;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.mycomponent.MyComboBox;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class PlayerPanel extends MyPanel {
	private SelectionPanel selectionPanel;
	private JScrollPane playerShowPane;
	private MyTable playerShowTable,rangeAndNameTable;
	private MyTableModel playerTableModel,rangeAndNameTableModel;
	private JLabel averageData;
	private JLabel totalData;
	private static final long serialVersionUID = 1L;
	private String PerformanceList[] = { "所属球队", "参赛场数", "先发场数", "在场时间", "效率值", "Gmsc效率值", "得分", "篮板", "助攻", 
				"抢断", "盖帽", "两双次数", "三双次数", "进攻篮板", "防守篮板", "失误", "犯规", "投篮命中率", "三分命中率","罚球命中率", "使用率", "真实命中率", "投篮效率", "助攻率", "篮板率", "抢断率", "盖帽率", "进攻篮板率", "防守篮板率", "失误率" };
	private String rangeAndNamePerformance[] = { "排名", "头像","姓名"};
	public PlayerPanel(){
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.setTableStyle();
	}
	private void createObjects() {
		averageData=new JLabel("场均数据");
		totalData=new JLabel("总数据");
		playerTableModel=new MyTableModel(PerformanceList);
		rangeAndNameTableModel=new MyTableModel(rangeAndNamePerformance);
		playerShowTable=new MyTable(playerTableModel);
		rangeAndNameTable=new MyTable(rangeAndNameTableModel);
		selectionPanel=new SelectionPanel();
		playerShowPane=new JScrollPane();
		playerShowPane.getViewport().add(playerShowTable);
	}
	private void setComponentsLocation() {
		averageData.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*100),(int)(NUMBER.px*658),(int)(NUMBER.px*40));
		totalData.setBounds((int)(NUMBER.px*706),(int)(NUMBER.px*100),(int)(NUMBER.px*660),(int)(NUMBER.px*40));
		selectionPanel.setLocation((int)(NUMBER.px*50),(int)(NUMBER.px*20));
		playerShowPane.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*140),(int)(NUMBER.FRAME_WIDTH-100),(int)(NUMBER.px*580));
		this.add(selectionPanel);
		this.add(averageData);
		this.add(totalData);
		this.add(playerShowPane);
	}
	private void setComponentsStyle() {
		totalData.setBackground(Color.gray);
		totalData.setOpaque(true);
		totalData.setHorizontalAlignment(SwingConstants.CENTER);
		totalData.setForeground(MyColor.MY_WHITE);
		totalData.setFont(MyFont.SMALL_BOLD);
		averageData.setBackground(MyColor.MIDDLE_COLOR);
		averageData.setOpaque(true);
		averageData.setHorizontalAlignment(SwingConstants.CENTER);
		averageData.setForeground(MyColor.MY_WHITE);	
		averageData.setFont(MyFont.SMALL_BOLD);
	}
	private void setTableStyle() {
		playerShowPane.getViewport().setOpaque(false);
		playerShowPane.setOpaque(false);
		playerShowPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		playerShowTable.setAllTableColumnWidth((int)(NUMBER.px*150));
		rangeAndNameTable.setTableColumnWidth(1, (int)(NUMBER.px*150));
		rangeAndNameTable.setTableColumnWidth(2, (int)(NUMBER.px*150));
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
			} else {
				rangeAndNameTable.setRowSelectionInterval(selectedIndex, selectedIndex);
			}
		}
	}
	class SelectionPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		JButton advancedSelect,submit;
		MyComboBox<String> positionChoose,conferenceChoose,selectCellChoose;
		public SelectionPanel(){
			this.setSize((int)(NUMBER.FRAME_WIDTH-100),(int)(NUMBER.px*80));
			this.setBackground(MyColor.LIGHT_COLOR);
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
		}
		private void createObjects() {
			advancedSelect=new JButton("高级搜索");
			submit=new JButton("提交");
			String[] conferenceList={"全联盟","东部","西部"};
			String[] positionList={"全部位置","后卫","前锋","中锋"};
			String[] selectCellList={"得分","篮板","助攻","抢断","盖帽","犯规","失误","分钟","投篮命中率","三分命中率","罚球命中率","进攻篮板","防守篮板","比赛场数"};
			positionChoose=new MyComboBox<String>(positionList);
			conferenceChoose=new MyComboBox<String>(conferenceList);
			selectCellChoose=new MyComboBox<String>(selectCellList);
		}
		private void setComponentsLocation(){
			positionChoose.setLocation(0,(int)(NUMBER.px*20));
			conferenceChoose.setLocation((int)(NUMBER.px*250),(int)(NUMBER.px*20));
			selectCellChoose.setLocation((int)(NUMBER.px*500),(int)(NUMBER.px*20));
			advancedSelect.setBounds((int)(NUMBER.px*815),(int)(NUMBER.px*20),(int)(NUMBER.px*180),(int)(NUMBER.px*40));
			submit.setBounds((int)(NUMBER.px*1055),(int)(NUMBER.px*20),(int)(NUMBER.px*180),(int)(NUMBER.px*40));
			this.add(positionChoose);
			this.add(conferenceChoose);
			this.add(advancedSelect);
			this.add(selectCellChoose);
			this.add(submit);
		}
		private void setComponentsStyle() {
			advancedSelect.setFocusable(false);
			advancedSelect.setBorderPainted(false);
			advancedSelect.setForeground(MyColor.LIGHT_COLOR);
			advancedSelect.setBackground(MyColor.MIDDLE_COLOR);
			submit.setFocusable(false);
			submit.setBorderPainted(false);
			submit.setForeground(MyColor.LIGHT_COLOR);
			submit.setBackground(MyColor.MIDDLE_COLOR);
		}
	}
}
