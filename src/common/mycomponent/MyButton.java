package common.mycomponent;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import common.statics.MyColor;
import common.statics.MyFont;

public class MyButton extends JButton {
	/*
	 * 自定义的MyButton组件
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;

	public MyButton(ImageIcon background, int width, int height) {
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.width = width;
		this.height = height;
		this.setSize(width, height);
		this.setMyIcon(background);
	}

	public MyButton(String string) {
		super(string);
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setForeground(MyColor.MY_WHITE);
		this.setFont(MyFont.SMALL_BOLD);
		this.setBackground(MyColor.DEEP_COLOR);
	}

	public void setMyIcon(ImageIcon icon) {
		ImageIcon Icon = icon;
		Image image = Icon.getImage();
		Image temp = image.getScaledInstance(width, height, Image.SCALE_REPLICATE);
		Icon.setImage(temp);
		this.setIcon(Icon);
	}
}