package presentation.hotsport;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogicservice.hotsport.TeamHotBlService;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;
import common.statics.images.Images;

public class TodayPlayerHotPanel extends HotSportPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeamHotBlService teamHotBl;
	private ShowInfoPanel showInfoPanel;
	
	private int width= ((int)NUMBER.NAVIGATION_PANEL_WIDTH - 2 * (int) (NUMBER.px * 30 + inter * 2))/5;
	private int height=(int) (NUMBER.px * 40);
	
	public TodayPlayerHotPanel() {
		showInfoPanel = new ShowInfoPanel();
		showInfoPanel.setBounds((int) (NUMBER.px * 30 + inter * 2), (int) (NUMBER.px * 36) * 3, NUMBER.NAVIGATION_PANEL_WIDTH - 2 * (int) (NUMBER.px * 30 + inter * 2), (int) (NUMBER.px * 36) * 16);
		this.add(showInfoPanel);
	}

	public static void main(String args[]) {
		JFrame j = new JFrame();
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.setBackground(MyColor.LIGHT_COLOR);
		j.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT);
		NavigationPanel navigationPanel = new NavigationPanel();
		navigationPanel.setBounds(0, 0, NUMBER.NAVIGATION_PANEL_WIDTH, NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(navigationPanel);
		TodayPlayerHotPanel contentPanel = new TodayPlayerHotPanel();
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);

	}

	class ShowInfoPanel extends JPanel implements MouseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MyButton gameScore, gameRebounds, gameAssist, gameBlock, gameSteal;// 按钮
		private MyLabel firstLabel, secondLabel, thirdLabel, fourthLabel, fifthLabel;
		private MyLabel firstPortraitLabel, secondPortraitLabel, thirdPortraitLabel, fourthPortraitLabel, fifthPortraitLabel;
		private MyLabel firstNameLabel, secondNameLabel, thirdNameLabel, fourthNameLabel, fifthNameLabel;
		private MyLabel firstPositionLabel, secondPositionLabel, thirdPositionLabel, fourthPositionLabel, fifthPositionLabel;
		private MyLabel firstScoreLabel, secondScoreLabel, thirdScoreLabel, fourthScoreLabel, fifthScoreLabel;
		private MyLabel firstTeamLabel, secondTeamLabel, thirdTeamLabel, fourthTeamLabel, fifthTeamLabel;
		
		private final int columnZero = buttonWidth * 3 / 2 + (int) (NUMBER.px * 80);
		private final int columnOne = buttonWidth * 4;
		private final int columnTwo = buttonWidth * 4 + (int) (NUMBER.px * 30);
		private final int columnThree = buttonWidth * 4 + (int) (NUMBER.px * 30) + buttonWidth * 3 / 4;
		private final int columnFour = buttonWidth * 7 + (int) (NUMBER.px * 30) + buttonWidth * 1 / 4;
		private final int columnFive = buttonWidth * 3 / 2 + (int) (NUMBER.px * 50) + buttonWidth * 3 / 2;

		private final int rowOne = buttonHeight + (int) (NUMBER.px * 36);
		private final int rowTwo = buttonHeight + (int) (NUMBER.px * 36) * 4;
		private final int rowThree = buttonHeight + (int) (NUMBER.px * 36) * 7;
		private final int rowFour = buttonHeight + (int) (NUMBER.px * 36) * 10;
		
		private final int numberWidth= (int) (NUMBER.px * 36);
		private final int portraitLabelWidth=buttonWidth * 3 / 4;
		private final int nameLabelWidth=buttonWidth;
		private final int positionLabelWidth=buttonWidth;
		private final int scoreLabelWidth=buttonWidth;
		private final int teamLabelWidth= buttonWidth;
		private final int labelHeight=(int) (NUMBER.px * 36) * 4;
		private final int scoreHeight=buttonHeight / 5;

		private final Font nameLabelFont = new Font("微软雅黑", Font.PLAIN, 18);

		public ShowInfoPanel() {
			this.setLayout(null);
			this.setBackground(new Color(213, 212, 212));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.addListener();
			this.setVisible(true);
		}

		private void setComponentsStyle() {
			firstLabel.setFont(new Font("微软雅黑", Font.BOLD, 50));
			firstNameLabel.setFont(MyFont.MIDDLE_PLAIN);
			firstPositionLabel.setFont(MyFont.SMALL_PLAIN);
			firstScoreLabel.setFont(new Font("微软雅黑", Font.BOLD, 40));

			secondLabel.setFont(MyFont.MIDDLE_BOLD);
			secondNameLabel.setFont(nameLabelFont);
			secondPositionLabel.setFont(nameLabelFont);
			secondScoreLabel.setFont(MyFont.MIDDLE_BOLD);

			thirdLabel.setFont(MyFont.MIDDLE_BOLD);
			thirdNameLabel.setFont(nameLabelFont);
			thirdPositionLabel.setFont(nameLabelFont);
			thirdScoreLabel.setFont(MyFont.MIDDLE_BOLD);

			fourthLabel.setFont(MyFont.MIDDLE_BOLD);
			fourthNameLabel.setFont(nameLabelFont);
			fourthPositionLabel.setFont(nameLabelFont);
			fourthScoreLabel.setFont(MyFont.MIDDLE_BOLD);

			fifthLabel.setFont(MyFont.MIDDLE_BOLD);
			fifthNameLabel.setFont(nameLabelFont);
			fifthPositionLabel.setFont(nameLabelFont);
			fifthScoreLabel.setFont(MyFont.MIDDLE_BOLD);

		}

		private void addListener() {
			gameScore.addMouseListener(this);
			gameRebounds.addMouseListener(this);
			gameAssist.addMouseListener(this);
			gameBlock.addMouseListener(this);
			gameSteal.addMouseListener(this);
		}
			
		private void setComponentsLocation() {
			gameScore.setLocation(0, 0);
			gameRebounds.setLocation(width, 0);
			gameAssist.setLocation(width * 2, 0);
			gameBlock.setLocation(width * 3, 0);
			gameSteal.setLocation(width * 4, 0);

			firstLabel.setBounds(buttonWidth * 3 / 2, buttonHeight * 3, (int) (NUMBER.px * 50), (int) (NUMBER.px * 300));
			firstPortraitLabel.setBounds(0, buttonHeight, buttonWidth * 2, (int) (NUMBER.px * 300));
			firstNameLabel.setBounds(columnZero, buttonHeight + (int) (NUMBER.px * 120), buttonWidth * 2, (int) (NUMBER.px * 100));
			firstPositionLabel.setBounds(columnZero, buttonHeight + (int) (NUMBER.px * 220), buttonWidth * 2, (int) (NUMBER.px * 50));
			firstScoreLabel.setBounds(columnZero, buttonHeight + (int) (NUMBER.px * 300), buttonWidth * 2, (int) (NUMBER.px * 100));
			firstTeamLabel.setBounds(columnFive, buttonHeight, buttonWidth, (int) (NUMBER.px * 150));

			secondLabel.setBounds(columnOne, rowOne,numberWidth, labelHeight);
			secondPortraitLabel.setBounds(columnTwo, rowOne, buttonWidth * 3 / 4, labelHeight);
			secondNameLabel.setBounds(columnThree, buttonHeight / 2 + (int) (NUMBER.px * 36), nameLabelWidth, labelHeight);
			secondPositionLabel.setBounds(columnThree, buttonHeight * 3 / 2 + (int) (NUMBER.px * 36), positionLabelWidth, labelHeight);
			secondScoreLabel.setBounds(columnFour, rowOne-scoreHeight, scoreLabelWidth, labelHeight);
			secondTeamLabel.setBounds(columnFive, rowOne, teamLabelWidth, labelHeight);

			thirdLabel.setBounds(columnOne, rowTwo, numberWidth, labelHeight);
			thirdPortraitLabel.setBounds(columnTwo, rowTwo, buttonWidth * 3 / 4, labelHeight);
			thirdNameLabel.setBounds(columnThree, buttonHeight / 2 + (int) (NUMBER.px * 36) * 4, nameLabelWidth, labelHeight);
			thirdPositionLabel.setBounds(columnThree, buttonHeight * 3 / 2 + (int) (NUMBER.px * 36) * 4, positionLabelWidth, labelHeight);
			thirdScoreLabel.setBounds(columnFour, rowTwo-scoreHeight, scoreLabelWidth,labelHeight);
			thirdTeamLabel.setBounds(columnFive, rowTwo, teamLabelWidth, labelHeight);

			fourthLabel.setBounds(columnOne, rowThree,numberWidth, labelHeight);
			fourthPortraitLabel.setBounds(columnTwo, rowThree, buttonWidth * 3 / 4, labelHeight);
			fourthNameLabel.setBounds(columnThree, buttonHeight / 2 + (int) (NUMBER.px * 36) * 7, nameLabelWidth, labelHeight);
			fourthPositionLabel.setBounds(columnThree, buttonHeight * 3 / 2 + (int) (NUMBER.px * 36) * 7, positionLabelWidth, labelHeight);
			fourthScoreLabel.setBounds(columnFour, rowThree-scoreHeight, scoreLabelWidth, labelHeight);
			fourthTeamLabel.setBounds(columnFive, rowThree, teamLabelWidth, labelHeight);

			fifthLabel.setBounds(columnOne, rowFour,numberWidth,labelHeight);
			fifthPortraitLabel.setBounds(columnTwo, rowFour, buttonWidth * 3 / 4, labelHeight);
			fifthNameLabel.setBounds(columnThree, buttonHeight / 2 + (int) (NUMBER.px * 36) * 10, nameLabelWidth, labelHeight);
			fifthPositionLabel.setBounds(columnThree, buttonHeight * 3 / 2 + (int) (NUMBER.px * 36) * 10, buttonWidth, labelHeight);
			fifthScoreLabel.setBounds(columnFour, rowFour-scoreHeight, scoreLabelWidth, labelHeight);
			fifthTeamLabel.setBounds(columnFive, rowFour, teamLabelWidth, labelHeight);

			this.add(gameScore);
			this.add(gameRebounds);
			this.add(gameAssist);
			this.add(gameBlock);
			this.add(gameSteal);

			this.add(firstLabel);
			this.add(firstPortraitLabel);
			this.add(firstNameLabel);
			this.add(firstPositionLabel);
			this.add(firstScoreLabel);
			this.add(firstTeamLabel);

			this.add(secondLabel);
			this.add(secondPortraitLabel);
			this.add(secondNameLabel);
			this.add(secondPositionLabel);
			this.add(secondScoreLabel);
			this.add(secondTeamLabel);

			this.add(thirdLabel);
			this.add(thirdPortraitLabel);
			this.add(thirdNameLabel);
			this.add(thirdPositionLabel);
			this.add(thirdScoreLabel);
			this.add(thirdTeamLabel);

			this.add(fourthLabel);
			this.add(fourthPortraitLabel);
			this.add(fourthNameLabel);
			this.add(fourthPositionLabel);
			this.add(fourthScoreLabel);
			this.add(fourthTeamLabel);

			this.add(fifthLabel);
			this.add(fifthPortraitLabel);
			this.add(fifthNameLabel);
			this.add(fifthPositionLabel);
			this.add(fifthScoreLabel);
			this.add(fifthTeamLabel);

		}

		private void createObjects() {
			gameScore = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameScore.png"),width,height);
			gameRebounds = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameRebounds.png"),width,height);
			gameAssist = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameAssist.png"),width,height);
			gameBlock = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameBlock.png"),width,height);
			gameSteal = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameSteal.png"),width,height);

			firstPortraitLabel = new MyLabel();
			firstNameLabel = new MyLabel();
			firstNameLabel.setText("拉塞尔威斯布鲁克");
			firstPositionLabel = new MyLabel();
			firstPositionLabel.setText("0 后卫 / 奥克拉荷马城 雷霆");
			firstScoreLabel = new MyLabel();
			firstScoreLabel.setText("37");
			firstTeamLabel = new MyLabel();
			firstLabel = new MyLabel();
			firstLabel.setText("1");

			secondPortraitLabel = new MyLabel();
			secondNameLabel = new MyLabel();
			secondNameLabel.setText("迈克尔-比斯利");
			secondPositionLabel = new MyLabel();
			secondPositionLabel.setText("30 前锋 / 热火");
			secondScoreLabel = new MyLabel();
			secondScoreLabel.setText("34");
			secondTeamLabel = new MyLabel();
			secondLabel = new MyLabel("2");

			thirdPortraitLabel = new MyLabel();
			thirdNameLabel = new MyLabel();
			thirdPositionLabel = new MyLabel();
			thirdScoreLabel = new MyLabel();
			thirdTeamLabel = new MyLabel();
			thirdLabel = new MyLabel("3");

			fourthPortraitLabel = new MyLabel();
			fourthNameLabel = new MyLabel();
			fourthPositionLabel = new MyLabel();
			fourthScoreLabel = new MyLabel();
			fourthTeamLabel = new MyLabel();
			fourthLabel = new MyLabel("4");

			fifthPortraitLabel = new MyLabel();
			fifthNameLabel = new MyLabel();
			fifthPositionLabel = new MyLabel();
			fifthScoreLabel = new MyLabel();
			fifthTeamLabel = new MyLabel();
			fifthLabel = new MyLabel("5");

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(gameScore)) {

			} else if (e.getSource().equals(gameRebounds)) {

			} else if (e.getSource().equals(gameAssist)) {

			} else if (e.getSource().equals(gameBlock)) {

			} else if (e.getSource().equals(gameSteal)) {

			} 

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(gameScore)) {
				gameScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameScore_enter.png"));
			} else if (e.getSource().equals(gameRebounds)) {
				gameRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameRebounds_enter.png"));
			} else if (e.getSource().equals(gameAssist)) {
				gameAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAssist_enter.png"));
			} else if (e.getSource().equals(gameBlock)) {
				gameBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameBlock_enter.png"));
			} else if (e.getSource().equals(gameSteal)) {
				gameSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameSteal_enter.png"));
			} 
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(gameScore)) {
				gameScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameScore.png"));
			} else if (e.getSource().equals(gameRebounds)) {
				gameRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameRebounds.png"));
			} else if (e.getSource().equals(gameAssist)) {
				gameAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAssist.png"));
			} else if (e.getSource().equals(gameBlock)) {
				gameBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameBlock.png"));
			} else if (e.getSource().equals(gameSteal)) {
				gameSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameSteal.png"));
			} 
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource().equals(gameScore)) {
				gameScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameScore_click.png"));
			} else if (e.getSource().equals(gameRebounds)) {
				gameRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameRebounds_click.png"));
			} else if (e.getSource().equals(gameAssist)) {
				gameAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAssist_click.png"));
			} else if (e.getSource().equals(gameBlock)) {
				gameBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameBlock_click.png"));
			} else if (e.getSource().equals(gameSteal)) {
				gameSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameSteal_click.png"));
			} 
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getSource().equals(gameScore)) {
				gameScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameScore.png"));
			} else if (e.getSource().equals(gameRebounds)) {
				gameRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameRebounds.png"));
			} else if (e.getSource().equals(gameAssist)) {
				gameAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAssist.png"));
			} else if (e.getSource().equals(gameBlock)) {
				gameBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameBlock.png"));
			} else if (e.getSource().equals(gameSteal)) {
				gameSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameSteal.png"));
			} 
		}
	}

}
