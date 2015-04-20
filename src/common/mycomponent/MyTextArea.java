package common.mycomponent;

import javax.swing.JTextArea;

import common.statics.MyColor;

public class MyTextArea extends JTextArea{
	
	private static final long serialVersionUID = 1L;

	public MyTextArea(){
		this.setEditable(false);
		this.setOpaque(false);
		this.setForeground(MyColor.MIDDLE_COLOR);
	}
}
