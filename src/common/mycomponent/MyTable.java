package common.mycomponent;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class MyTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTable(MyTableModel model) {
		super(model);
		JTableHeader header = this.getTableHeader();
		header.setBackground(MyColor.DEEP_COLOR);// 设置表头颜色
		header.setForeground(MyColor.MY_WHITE);// 设置表头字体颜色
		header.setReorderingAllowed(false);
		header.setResizingAllowed(false);
		header.setFont(MyFont.SMALL_PLAIN);

		//
		this.setRowHeight((int) (55 * NUMBER.px));// 设置行高
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 设置只允许一次选择一行
		this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);// 横向滚动
		this.setFont(MyFont.SMALLEST_PLAIN);// 设置内容字体
		//
		DefaultTableCellRenderer render = new DefaultTableCellRenderer() {
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				setHorizontalAlignment(JLabel.CENTER);// 居中显示
				super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				setForeground(MyColor.MY_WHITE);
				if (row % 2 == 0) {
					setBackground(MyColor.DEEP_COLOR);// 偶数行
				}
				else {
					setBackground(MyColor.MIDDLE_COLOR);// 奇数行
				}

				if (isSelected) {
					setOpaque(true);// 将渲染器设为不透明!!!
					setBackground(MyColor.MY_ORIANGE);
				}
				return this;
			}
		};
		this.setDefaultRenderer(Object.class, render);
	}

	public void setTableColumnWidth(int number, int width) {
		this.getColumnModel().getColumn(number).setPreferredWidth((int) (width * NUMBER.px));
	}

	public void setAllTableColumnWidth(int width) {
		for (int i = 0; i < this.getColumnCount(); i++) {
			this.setTableColumnWidth(i, width);
		}
	}
}
