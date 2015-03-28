package presentation;

import javax.swing.JPanel;

import common.statics.NUMBER;

public class DetailPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int labelWidth = (int) (NUMBER.px * 120);
	protected int showlabelWidth = (int) (NUMBER.px * 150);
	protected int labelHeight = (int) (NUMBER.px * 40);

	public DetailPanel() {
		this.setLayout(null);
		this.setOpaque(false);
		this.setVisible(true);
	}
}
