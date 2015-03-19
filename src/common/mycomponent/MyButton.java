package common.mycomponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton {
	/*
	 * 自定义的MyButton组件
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;//TODO
	public MyButton(ImageIcon background,int width,int height) {
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.width=width;
		this.height=height;
		this.setSize(width, height);
		this.setMyIcon(background);
		}
	public MyButton(String string) {
		super(string);
		this.setFocusable(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setForeground(Color.white);
		this.setFont(new Font("微软雅黑",Font.BOLD,20));
	}
	public void setMyIcon(ImageIcon icon)
	   {
		ImageIcon Icon=icon;
	    Image p=Icon.getImage();
		Image temp = p.getScaledInstance(width,  
				height,Image.SCALE_REPLICATE);  
	    Icon.setImage(temp);
	    this.setIcon(Icon);
	   }	
}