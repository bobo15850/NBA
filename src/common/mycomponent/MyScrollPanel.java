package common.mycomponent;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyScrollPanel extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyScrollPanel(JTable table) {
		super(table);
	}
}
