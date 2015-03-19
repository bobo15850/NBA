package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import common.mycomponent.MyTableModel;
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
	protected MyTableModel allTableModel;

	public AllShowPanel() {
		this.setLayout(null);
		this.setOpaque(false);
		this.repaint();
		this.addListener();
		this.setVisible(true);
	}

	protected void initTable(String headList[]) {
		initScrollPane(headList);
		initTableHeader();
		setContent();
		setRenderer();

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
		allTable.setRowHeight(35);// 设置行高

		tableScrollPane.getViewport().setOpaque(false);
		tableScrollPane.setOpaque(false);

	}

	private void setContent() {
		for (int i = 1; i <= 7; i++) {
			allTable.getColumnModel().getColumn(i).setPreferredWidth(120);
		}// 设置列宽
		for (int i = 8; i < allTable.getColumnCount(); i++) {
			allTable.getColumnModel().getColumn(i).setPreferredWidth(0);
			allTable.getColumnModel().getColumn(i).setMaxWidth(0);
			allTable.getColumnModel().getColumn(i).setMinWidth(0);
			allTable.getTableHeader().getColumnModel().getColumn(i).setMaxWidth(0);
			allTable.getTableHeader().getColumnModel().getColumn(i).setMinWidth(0); // 隐藏数据
		}
		allTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 横向滚动
		allTable.getTableHeader().setReorderingAllowed(false);// Can't move
		allTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		tableScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));// lines remove

	}

	private void initTableHeader() {

		// 设置头部
		// 头部无法透明!!!
		JTableHeader header = allTable.getTableHeader();
		header.setBackground(new Color(51, 51, 51));// 设置表头颜色
		header.setForeground(new Color(255, 255, 255));// 设置表头字体颜色
		header.setFont(new Font("微软雅黑", Font.BOLD, 16));
	}

	private void initScrollPane(String headList[]) {
		tableScrollPane = new JScrollPane();
		allTableModel = new MyTableModel(headList);
		for (int i = 0; i < 20; i++) {
			String row1[] = { String.valueOf(i + 1), "D-Wade", "31.5", "6.7", "5.5", "2.2", "2.1", "2.2", "aaa", "sax",
					"asx" };
			allTableModel.addRow(row1);
		}
		allTable = new JTable(allTableModel);
		tableScrollPane.setBounds((int) (NUMBER.px * 30), (int) (NUMBER.px * 101), (int) (NUMBER.px * 950),
				(int) (NUMBER.px * 570));
		allTable.setBounds(0, 0, (int) (NUMBER.px * 950), (int) (NUMBER.px * 570));
		tableScrollPane.getViewport().add(allTable);
		this.add(tableScrollPane);
		// playerTable.setShowVerticalLines(false);//VerticalLines are remove
		// playerTable.setShowGrid(false);//all lines are remove

	}

	private void addListener() {
		// TODO Auto-generated method stub

	}
}
