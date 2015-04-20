package presentation.hotsport;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import common.mycomponent.MyButton;
import common.mycomponent.MyPanel;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class HotSportPanel extends MyPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final int inter = (int) (NUMBER.px * 30);
	protected final int buttonWidth = (int) (NUMBER.px * 160);
	protected final int buttonHeight = (int) (NUMBER.px * 40);

	protected MyButton todayHotPlayer, seasonHotPlayer, seasonHotTeam, mostImprovedPlayer;// 按钮
	
	HotSportPanel(){
		this.createObjects();
		this.setComponentsLocation();
		this.addListener();
		this.setVisible(true);
		this.repaint();
	}
	
	protected void addListener() {
		todayHotPlayer.addMouseListener(this);
		seasonHotPlayer.addMouseListener(this);
		seasonHotTeam.addMouseListener(this);
		mostImprovedPlayer.addMouseListener(this);

	}

	protected void setComponentsLocation() {
		todayHotPlayer.setLocation((int) (NUMBER.px * 30 + inter + buttonWidth), (int) (NUMBER.px * 36));
		mostImprovedPlayer.setLocation((int) (NUMBER.px * 30 + inter * 2 + buttonWidth * 2), (int) (NUMBER.px * 36));
		seasonHotPlayer.setLocation((int) (NUMBER.px * 30 + inter * 3 + buttonWidth * 3), (int) (NUMBER.px * 36));
		seasonHotTeam.setLocation((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4), (int) (NUMBER.px * 36));

		this.add(todayHotPlayer);
		this.add(seasonHotPlayer);
		this.add(seasonHotTeam);
		this.add(mostImprovedPlayer);

	}

	protected void createObjects() {
		todayHotPlayer = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer.png"), buttonWidth, buttonHeight);
		seasonHotPlayer = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer.png"), buttonWidth, buttonHeight);
		seasonHotTeam = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam.png"), buttonWidth, buttonHeight);
		mostImprovedPlayer = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer.png"), buttonWidth, buttonHeight);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource().equals(todayHotPlayer)) {

		} else if (arg0.getSource().equals(seasonHotPlayer)) {

		} else if (arg0.getSource().equals(seasonHotTeam)) {

		} else if (arg0.getSource().equals(mostImprovedPlayer)) {

		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (arg0.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer_enter.png"));
		} else if (arg0.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer_enter.png"));
		} else if (arg0.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam_enter.png"));
		} else if (arg0.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer_enter.png"));
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if (arg0.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer.png"));
		} else if (arg0.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer.png"));
		} else if (arg0.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam.png"));
		} else if (arg0.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer.png"));
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (arg0.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer_click.png"));
		} else if (arg0.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer_click.png"));
		} else if (arg0.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam_click.png"));
		} else if (arg0.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer_click.png"));
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (arg0.getSource().equals(todayHotPlayer)) {
			todayHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "todayHotPlayer.png"));
		} else if (arg0.getSource().equals(seasonHotPlayer)) {
			seasonHotPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotPlayer.png"));
		} else if (arg0.getSource().equals(seasonHotTeam)) {
			seasonHotTeam.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "seasonHotTeam.png"));
		} else if (arg0.getSource().equals(mostImprovedPlayer)) {
			mostImprovedPlayer.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "mostImprovedPlayer.png"));
		}

	}
}
