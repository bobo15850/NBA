package common.mycomponent;

import java.awt.Font;

import javax.swing.JTextField;

public class MyTextField extends JTextField{
	
	private static final long serialVersionUID = 1L;
	public MyTextField(){
	this.setFont(new Font("微软雅黑",Font.BOLD,20));
	this.setOpaque(false);
	this.setEditable(false);
}

}