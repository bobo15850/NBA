package presentation;

import javax.swing.JPanel;

import common.statics.NUMBER;


public class DetailPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int labelWidth=(int)(NUMBER.px*120);
	protected int showlabelWidth=(int)(NUMBER.px*120);
	protected int labelHeight=(int)(NUMBER.px*50);

	public DetailPanel(){
		this.setLayout(null);
		this.setOpaque(false);
		this.repaint();
		this.addListener();
		this.setVisible(true);
	}

	private void addListener() {
		// TODO Auto-generated method stub
		
	}
}
