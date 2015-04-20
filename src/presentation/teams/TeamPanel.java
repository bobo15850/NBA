package presentation.teams;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class TeamPanel extends MyPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane teamShowPane;
	private MyTable teamShowTable,rangeAndNameTable;
	private MyTableModel teamShowTableModel,rangeAndNameTableModel;
	private String performanceList[]={ "比赛场数", "胜率", "得分数", "投篮命中数", "投篮出手数","投篮命中率","三分命中数", "三分出手数",
			 "三分命中率", "罚球命中数", "罚球出手数", "罚球命中率", "进攻篮板数", "防守篮板数", "篮板数","助攻", "抢断", "盖帽","失误","犯规","进攻回合", "进攻效率", "防守效率", "篮板效率", "抢断率","助攻率" };
	private String rangeAndName[] = { "排名","队标","球队名称" };
	private JLabel averageData;
	private JLabel totalData;
	public TeamPanel(){
		this.createObjects();
		this.setComponentsLocation();
		this.setTableStyle();
		this.setComponentsStyle();
	}
	private void setTableStyle() {

		teamShowPane.getViewport().setOpaque(false);
		teamShowPane.setOpaque(false);
		teamShowPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		teamShowTable.setAllTableColumnWidth((int)(NUMBER.px*150));
		rangeAndNameTable.setTableColumnWidth(1, (int)(NUMBER.px*150));
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
			} else {
				rangeAndNameTable.setRowSelectionInterval(selectedIndex, selectedIndex);
			}
		}
	}
	private void setComponentsLocation() {
		averageData.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*20),(int)(NUMBER.px*658),(int)(NUMBER.px*50));
		totalData.setBounds((int)(NUMBER.px*706),(int)(NUMBER.px*20),(int)(NUMBER.px*660),(int)(NUMBER.px*50));
		teamShowPane.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*70),(int)(NUMBER.FRAME_WIDTH-100),(int)(NUMBER.px*650));
		this.add(averageData);
		this.add(totalData);
		this.add(teamShowPane);
	}
	private void createObjects() {
		teamShowTableModel=new MyTableModel(performanceList);
		rangeAndNameTableModel=new MyTableModel(rangeAndName); 
		teamShowTable=new MyTable(teamShowTableModel);
		rangeAndNameTable=new MyTable(rangeAndNameTableModel);
		averageData=new JLabel("场均数据");
		totalData=new JLabel("总数据");
		teamShowPane=new JScrollPane();
		teamShowPane.getViewport().add(teamShowTable);
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
}
