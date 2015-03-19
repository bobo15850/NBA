package common.mycomponent;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyImageLabel extends JLabel{

	private static final long serialVersionUID = 1L;
	private ImageIcon image;
	public MyImageLabel(ImageIcon image1){
    this.image = image1;
	this.setFont(new Font("微软雅黑",Font.BOLD,18));
	this.setForeground(Color.red);
	}
 protected void paintComponent(Graphics g)
   {
    super.paintComponent(g);
    int x = this.getWidth();
    int y = this.getHeight();
    
    g.drawImage(image.getImage(), 0, 0, x, y, null);
   }

}
