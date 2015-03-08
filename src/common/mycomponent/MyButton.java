package common.mycomponent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {
	/*
	 * 自定义的MyButton组件
	 */
	private static final long serialVersionUID = 1L;

	public MyButton(ImageIcon background) {
		super(background);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
	}
}