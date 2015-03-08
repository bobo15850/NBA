package common.mycomponent;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import start.Main;

public class MyPanel extends JPanel implements MouseListener {
	/*
	 * 自定义的MyFrame组件
	 */
	private static final long serialVersionUID = 1L;

	private Image backgroundImage;// MyPanel的背景图片
	private MyButton closeButton, minimizeButton;// 关闭和最小化按钮

	public MyPanel(ImageIcon background) {
		this.backgroundImage = background.getImage();
		this.createObjects();
		this.setComponentsLocarion();
		this.addListener();
	}

	private void createObjects() {
		closeButton = new MyButton(null);
		minimizeButton = new MyButton(null);
	}

	private void setComponentsLocarion() {
		this.setLayout(null);
		// minimizeButton.setBounds(711, 29, 33, 8);
		// closeButton.setBounds(760, 8, 33, 30);
		this.add(minimizeButton);
		this.add(closeButton);

	}

	private void addListener() {
		closeButton.addMouseListener(this);
		minimizeButton.addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == minimizeButton) {
			Main.mainFrame.setExtendedState(Frame.ICONIFIED);
		} else if (e.getSource() == closeButton) {
			System.exit(0);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}