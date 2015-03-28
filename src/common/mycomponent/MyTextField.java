package common.mycomponent;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import common.statics.MyColor;
import common.statics.MyFont;

public class MyTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	public MyTextField() {
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		this.setForeground(MyColor.MY_WHITE);
		this.setFont(MyFont.SMALLEST_PLAIN);
	}
}