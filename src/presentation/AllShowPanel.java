package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import vo.OnePlayerPerformOfOneSeasonVo;
import vo.OneTeamPerformOfOneSeasonVo;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;
import common.mycomponent.MyTableModel;
import common.mydatastructure.Season;
import common.statics.NUMBER;

public class AllShowPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int buttonWidth = (int) (NUMBER.px * 160);
	protected int buttonHeight = (int) (NUMBER.px * 40);
	protected int inter = (int) (NUMBER.px * 30);
	protected int inputWidth = (int) (NUMBER.px * 200);
	protected JScrollPane tableScrollPane;
	protected JTable allTable;
	protected JTable nameAndNumTable;
	protected MyTableModel allTableModel;
	protected MyTableModel nameTableModel;
	protected boolean isPlayer=true;
	private PlayerInfoBlService playerInfoBl;
	protected ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList;
	private ArrayList<OneTeamPerformOfOneSeasonVo> allTeamList;
	public AllShowPanel(boolean isPlayer) {
		this.isPlayer=isPlayer;
		this.setLayout(null);
		this.setOpaque(false);
		this.repaint();
		this.setVisible(true);
	}

	protected void initTable(String headList[],String nameAndNum[]) {
		initScrollPane(headList,nameAndNum);
		initTableHeader();
		setRenderer();
	}
	private void initScrollPane(String headList[],String nameAndNum[]) {
		allTableModel = new MyTableModel(headList);
		nameTableModel=new MyTableModel(nameAndNum);
		setContent();
		allTable = new JTable(allTableModel);
		allTable.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent arg0) {
                        checkSelection(false);
                    }
                });
		allTable.setRowHeight((int)(38*NUMBER.px));// 设置行高
		allTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 横向滚动
		allTable.getTableHeader().setReorderingAllowed(false);// Can't move
		allTable.getTableHeader().setResizingAllowed(false); 
		allTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		for (int i = 0; i <= 7; i++) {
			allTable.getColumnModel().getColumn(i).setPreferredWidth((int)(100*NUMBER.px));
		}// 设置列宽
		for (int i = 8; i < allTable.getColumnCount(); i++) {
			allTable.getColumnModel().getColumn(i).setPreferredWidth(0);
			allTable.getColumnModel().getColumn(i).setMaxWidth(0);
			allTable.getColumnModel().getColumn(i).setMinWidth(0);
			allTable.getTableHeader().getColumnModel().getColumn(i).setMaxWidth(0);
			allTable.getTableHeader().getColumnModel().getColumn(i).setMinWidth(0); // 隐藏数据
		}
		
		nameAndNumTable=new JTable(nameTableModel);
		nameAndNumTable.getColumnModel().getColumn(1).setPreferredWidth((int)(120*NUMBER.px));;
		nameAndNumTable.getSelectionModel().addListSelectionListener(
                new ListSelectionListener() {
                    public void valueChanged(ListSelectionEvent arg0) {
                        checkSelection(true);
                    }
                });
		nameAndNumTable.setRowHeight((int)(38*NUMBER.px));// 设置行高
		nameAndNumTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nameAndNumTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 横向滚动
		nameAndNumTable.getTableHeader().setReorderingAllowed(false);// Can't move
		nameAndNumTable.getTableHeader().setResizingAllowed(false); 
		nameAndNumTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		nameAndNumTable.setOpaque(false);
		
		JViewport viewport = new JViewport();
		viewport.setOpaque(false);
	    viewport.setView(nameAndNumTable);
	    viewport.setPreferredSize(nameAndNumTable.getPreferredSize());
	    tableScrollPane = new JScrollPane(allTable);
		tableScrollPane.setBounds((int) (NUMBER.px * 30), (int) (NUMBER.px * 101), (int) (NUMBER.px * 950),
				(int) (NUMBER.px * 570));
//		allTable.setBounds(0, 0, (int) (NUMBER.px * 950), (int) (NUMBER.px * 570));
		
		tableScrollPane.setRowHeaderView(viewport);
		tableScrollPane.setCorner(JScrollPane.UPPER_LEFT_CORNER, nameAndNumTable
                .getTableHeader());
		
		this.add(tableScrollPane);
		// playerTable.setShowVerticalLines(false);//VerticalLines are remove
		// playerTable.setShowGrid(false);//all lines are remove
		
		tableScrollPane.getViewport().setOpaque(false);
		tableScrollPane.setOpaque(false);
		tableScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));// lines remove
		
	}
	private void initTableHeader() {

		// 设置头部
		// 头部无法透明!!!
		JTableHeader header = allTable.getTableHeader();
		header.setBackground(new Color(51, 51, 51));// 设置表头颜色
		header.setForeground(new Color(255, 255, 255));// 设置表头字体颜色
		header.setFont(new Font("微软雅黑", Font.BOLD, 16));
		
		JTableHeader nameAndNumHeader = nameAndNumTable.getTableHeader();
		nameAndNumHeader.setBackground(new Color(51, 51, 51));// 设置表头颜色
		nameAndNumHeader.setForeground(new Color(255, 255, 255));// 设置表头字体颜色
		nameAndNumHeader.setFont(new Font("微软雅黑", Font.BOLD, 16));
	}
	private void setRenderer() {
		DefaultTableCellRenderer render = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				setHorizontalAlignment(JLabel.CENTER);// 居中显示
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setForeground(Color.WHITE);
				if (row % 2 == 0) {
					setBackground(new Color(51, 51, 51));// 偶数行
				} else {
					setBackground(new Color(102, 102, 102));// 奇数行
				}

				if (isSelected) {
					setOpaque(true);// 将渲染器设为不透明!!!
					setBackground(new Color(241, 145, 73));
					// setForeground(new Color(219,125,99));
				}
				return this;
			}
		};
		allTable.setDefaultRenderer(Object.class, render);
		nameAndNumTable.setDefaultRenderer(Object.class, render);

	}

	private void setContent() {
		if(isPlayer){
		playerInfoBl=new PlayerInfoBl();
		allPlayerList=playerInfoBl.getOneSeasonPerformOfAllPlayer(new Season(2013, 2014));
		for (int i = 0; i < allPlayerList.size(); i++) {
			String row1[] = allPlayerList.get(i).toAverStringArray();
			String row2[] = {String.valueOf(i + 1),allPlayerList.get(i).getNameOfPlayer()}; 
			allTableModel.addRow(row1);
			nameTableModel.addRow(row2);
		}
		
		}else{
			System.out.print("Fuck");
		}
	}

	

	
	 private void checkSelection(boolean isFixedTable) {
	        int fixedSelectedIndex = nameAndNumTable.getSelectedRow();
	        int selectedIndex = allTable.getSelectedRow();
	        if (fixedSelectedIndex != selectedIndex) {
	            if (isFixedTable) {
	                allTable.setRowSelectionInterval(fixedSelectedIndex,
	                        fixedSelectedIndex);
	            } else {
	                nameAndNumTable
	                        .setRowSelectionInterval(selectedIndex, selectedIndex);
	            }
	        }
	 
	    }
}
