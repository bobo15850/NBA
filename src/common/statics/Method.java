package common.statics;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Method {

	public static int toMonthInt(String month) {
		if (month.equals("JAN")) {
			return 1;
		}
		else if (month.equals("FEB")) {
			return 2;
		}
		else if (month.equals("MAR")) {
			return 3;
		}
		else if (month.equals("APR")) {
			return 4;
		}
		else if (month.equals("MAY")) {
			return 5;
		}
		else if (month.equals("JUN")) {
			return 6;
		}
		else if (month.equals("JUL")) {
			return 7;
		}
		else if (month.equals("AUG")) {
			return 8;
		}
		else if (month.equals("SEP")) {
			return 9;
		}
		else if (month.equals("QCT")) {
			return 10;
		}
		else if (month.equals("NOV")) {
			return 11;
		}
		else if (month.equals("DEC")) {
			return 12;
		}
		else {
			return 0;
		}
	}

	public static boolean ToBoolean(String str) {
		if (str.equals("true")) {
			return true;
		}
		else {
			return false;
		}
	}

	public static boolean isPlayerPositionEqual(Position standPosition, Position selectedPosition) {
		if (standPosition.equals(Position.C)) {
			if (selectedPosition.equals(Position.C) || selectedPosition.equals(Position.C_F) || selectedPosition.equals(Position.F_C)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (standPosition.equals(Position.G)) {
			if (selectedPosition.equals(Position.G) || selectedPosition.equals(Position.G_F) || selectedPosition.equals(Position.F_G)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (standPosition.equals(Position.F)) {
			if (selectedPosition.equals(Position.F) || selectedPosition.equals(Position.C_F) || selectedPosition.equals(Position.F_C)
					|| selectedPosition.equals(Position.F_G) || selectedPosition.equals(Position.G_F)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	public static ImageIcon changeSize(ImageIcon icon, int width, int height) {
		ImageIcon Icon = icon;
		Image image = Icon.getImage();
		Image temp = image.getScaledInstance(width, height, Image.SCALE_REPLICATE);
		Icon.setImage(temp);
		return Icon;
	}

}
