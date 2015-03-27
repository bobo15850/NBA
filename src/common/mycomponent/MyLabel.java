package common.mycomponent;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.statics.MyColor;
import common.statics.MyFont;

public class MyLabel extends JLabel {
	private static final long serialVersionUID = 1L;

	public MyLabel() {
	}

	public MyLabel(String str) {
		super(str);
		this.setFont(MyFont.LABEL_CHARACTER);
		this.setForeground(MyColor.LIGHT_COLOR);
	}

	public MyLabel(ImageIcon background) {
		this.setFont(MyFont.LABEL_CHARACTER);
		this.setForeground(MyColor.MY_RED);
		this.setIcon(background);
	}
	public void setMyIcon(ImageIcon icon)
	   {
		ImageIcon Icon=icon;
	    Image p=Icon.getImage();
		Image temp = p.getScaledInstance(this.getWidth(),  
				this.getHeight(),Image.SCALE_REPLICATE);  
	    Icon.setImage(temp);
	    this.setIcon(Icon);
	   }
}
