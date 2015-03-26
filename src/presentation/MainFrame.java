package presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.players.PlayerAllShowPanel;
import presentation.players.PlayerDetailPanel;
import presentation.teams.TeamAllShowPanel;
import presentation.teams.TeamDetailPanel;
import common.mycomponent.MyButton;
import common.mycomponent.MyFrame;
import common.statics.NUMBER;

public class MainFrame extends MyFrame{
	
	private static final long serialVersionUID = 1L;
//	private JLabel backgroundLabel;
	private navigationPanel navigationPanel;
	private PlayerDetailPanel playerDetailPanel;
	private PlayerAllShowPanel playerAllShowPanel;
//	private TeamAllShowPanel teamAllShowPanel;
//	private TeamDetailPanel teamDetailPanel;
	
	public MainFrame(){
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.repaint();
		this.setVisible(true);
	}
	
	private void createObjects() {
//		BG = new aLabel(new ImageIcon("images/test.png").getImage());
//		backgroundLabel = new JLabel(new ImageIcon("image/mainbg.png"));
		
		navigationPanel =new navigationPanel();
		playerDetailPanel=new PlayerDetailPanel();
		playerAllShowPanel=new PlayerAllShowPanel(this);
//		teamAllShowPanel =new TeamAllShowPanel();
//		teamDetailPanel =new TeamDetailPanel();
	}

	private void setComponentsLocation() {
		this.setBounds((NUMBER.SCREEN_WIDTH-NUMBER.FRAME_WIDTH)/2,(NUMBER.SCREEN_HEIGHT-NUMBER.FRAME_HEIGHT)/2-20, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT);
//		BG.setBounds(0, 0, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT);
//		this.getLayeredPane().add(BG, new Integer(Integer.MIN_VALUE));
		this.setBackground(new Color(204,204,204));
		JPanel tempPanel = (JPanel) this.getContentPane();
		tempPanel.setOpaque(false);//To make the top layer of the Frame unvisible
		
		playerAllShowPanel.setBounds(NUMBER.DETAIL_PANEL_WIDTH, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH-NUMBER.DETAIL_PANEL_WIDTH, NUMBER.FRAME_HEIGHT-NUMBER.NAVIGATION_PANEL_HEIGHT);
		navigationPanel.setBounds(0, 0, NUMBER.NAVIGATION_PANEL_WIDTH,NUMBER.NAVIGATION_PANEL_HEIGHT);
		playerDetailPanel.setBounds(0,NUMBER.NAVIGATION_PANEL_HEIGHT,NUMBER.DETAIL_PANEL_WIDTH,NUMBER.DETAIL_PANEL_HEIGHT);
//		teamAllShowPanel.setBounds(NUMBER.DETAIL_PANEL_WIDTH, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH-NUMBER.DETAIL_PANEL_WIDTH, NUMBER.FRAME_HEIGHT-NUMBER.NAVIGATION_PANEL_HEIGHT);
//		teamDetailPanel.setBounds(0,NUMBER.NAVIGATION_PANEL_HEIGHT,NUMBER.DETAIL_PANEL_WIDTH,NUMBER.DETAIL_PANEL_HEIGHT);
		this.add(navigationPanel);
		this.add(playerDetailPanel);
		this.add(playerAllShowPanel);
//		this.add(teamAllShowPanel);
//		this.add(teamDetailPanel);
	}
	private void setComponentsStyle() {
		
	}
	
	public class navigationPanel extends JPanel{

		private static final long serialVersionUID = 1L;
		JLabel currntPanelLabel;
		JButton quitSystem,playerPanelButton,teamPanelButton;
		public navigationPanel(){
			this.setLayout(null);
			this.setBackground(new Color(102,102,102));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.setVisible(true);	
			
		}
		
		private void createObjects() {
			currntPanelLabel=new JLabel("球员数据");
			quitSystem=new MyButton("退出系统");
			playerPanelButton=new MyButton("球员数据");
			teamPanelButton=new MyButton("球队数据");
		}
		
		private void setComponentsLocation() {
			currntPanelLabel.setBounds((int)(NUMBER.DETAIL_PANEL_WIDTH-NUMBER.px*200)/2,(NUMBER.NAVIGATION_PANEL_HEIGHT-(int)(NUMBER.px*100))/2, (int)(NUMBER.px*200), (int)(NUMBER.px*100));//TODO 
			teamPanelButton.setBounds((int)(NUMBER.px*340),(int)(NUMBER.px*29),(int)(NUMBER.px*160), (int)(NUMBER.px*40));
			playerPanelButton.setBounds( (int)(NUMBER.px*520),(int)(NUMBER.px*29),(int)(NUMBER.px*160), (int)(NUMBER.px*40));
			quitSystem.setBounds( (int)(NUMBER.px*700),(int)(NUMBER.px*29),(int)(NUMBER.px*160), (int)(NUMBER.px*40));
			this.add(currntPanelLabel);
			this.add(teamPanelButton);
			this.add(playerPanelButton);
			this.add(quitSystem);
		}
		private void setComponentsStyle() {
			currntPanelLabel.setFont(new Font("微软雅黑",Font.BOLD,35));
			currntPanelLabel.setForeground(Color.white);
		}
		 protected void paintComponent(Graphics g) {
			    super.paintComponent(g);
			    g.setColor(Color.white);
			    g.drawLine((int)(NUMBER.px*510),(int)(NUMBER.px*35), (int)(NUMBER.px*510), (int)(NUMBER.px*65));//TODO 线位置改
			    g.drawLine((int)(NUMBER.px*690),(int)(NUMBER.px*35), (int)(NUMBER.px*690), (int)(NUMBER.px*65));//TODO 线位置改
			  }
	}
}
