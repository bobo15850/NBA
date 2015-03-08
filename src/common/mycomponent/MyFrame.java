package common.mycomponent;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	/*
	 * 自定义的MyFrame组件
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame() {
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
	}
}
