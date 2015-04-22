package common.mycomponent;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import common.statics.MyColor;

public class ImageRenderer extends JLabel implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		setHorizontalAlignment(JLabel.CENTER);
		setOpaque(true);
		
		if (row % 2 == 0) {
			setBackground(MyColor.DEEP_COLOR);// 偶数行
		} else {
			setBackground(MyColor.MIDDLE_COLOR);// 奇数行
		}

		if (isSelected) {
			setBackground(MyColor.MY_ORIANGE);
		}
		return this;
	}
	public ImageRenderer(ImageIcon icon,int width,int height){
		setMyIcon(icon, width, height);
	}
	private void setMyIcon(ImageIcon icon,int width,int height) {
		ImageIcon Icon = icon;
		Image image = Icon.getImage();
		Image temp = image.getScaledInstance(width, height, Image.SCALE_REPLICATE);
		Icon.setImage(temp);
		this.setIcon(Icon);
	}
	public void setIcon(String path){
		
	}

}
