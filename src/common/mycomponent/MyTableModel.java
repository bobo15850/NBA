package common.mycomponent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Vector<Object>> content = null;
	private String[] title_name;

	public MyTableModel(String[] title_name) {
		this.title_name = title_name;
		content = new Vector<Vector<Object>>();
	}

	public void addRow(Object[] str) {
		Vector<Object> v = new Vector<Object>(title_name.length);
		for (int i = 0; i < str.length; i++) {
			v.add(i, str[i]);
		}
		content.add(v);
	}

	public void removeRow(int row) {
		try {
			content.remove(row);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "未选择任何条目", "错误", JOptionPane.ERROR_MESSAGE);
		}

	}

	public void removeSelectedRows(int rows[]) {
		Arrays.sort(rows);
		for (int i = rows.length - 1; i >= 0; i--) {
			content.remove(rows[i]);
		}
	}

	public void removeRows(int row, int count) {
		for (int i = 0; i < count; i++) {
			if (content.size() > row) {
				content.remove(row);
			}
		}
	}

	public void removeAllRows() {
		for (int i = content.size() - 1; i >= 0; i--) {
			content.remove(i);
		}
	}

	public int getColumnCount() {
		return title_name.length;
	}

	public int getRowCount() {
		return content.size();
	}

	public Object getValueAt(int row, int col) {
		return ((Vector<Object>) content.get(row)).get(col);
	}

	public String getColumnName(int col) {
		return title_name[col];
	}

	public void setValueAt(String value, int row, int col) {
		(content.get(row)).remove(col);
		(content.get(row)).add(col, value);
		this.fireTableCellUpdated(row, col);
	}

	public ArrayList<Object[]> getAllValue() {
		int rownumber = this.getRowCount();
		int colnumber = this.getColumnCount();
		if (rownumber == 0) {
			return null;
		} else {
			ArrayList<Object[]> listvalue = new ArrayList<Object[]>();
			for (int i = 0; i < rownumber; i++) {
				Object[] rowvalue = new String[colnumber];
				for (int j = 0; j < colnumber; j++) {
					rowvalue[j] = this.getValueAt(i, j);
				}
				listvalue.add(rowvalue);
			}
			return listvalue;
		}
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
}
