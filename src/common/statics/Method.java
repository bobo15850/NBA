package common.statics;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Method {
	public static ImageIcon changeSize(ImageIcon icon, int width, int height) {
		ImageIcon Icon = icon;
		Image image = Icon.getImage();
		Image temp = image.getScaledInstance(width, height, Image.SCALE_REPLICATE);
		Icon.setImage(temp);
		return Icon;
	}
}
