package common.mycomponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	public MyLabel(String str) {
		super(str);
		this.setFont(new Font("微软雅黑", Font.BOLD, 18));
		this.setForeground(new Color(51, 51, 51));
		// this.setSize((int)(NUMBER.px*100), (int)(NUMBER.px*50));
	}

}
