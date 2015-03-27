package common.mycomponent;

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
}
