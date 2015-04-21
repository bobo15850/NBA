package presentation.hotsport;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class SeasonHotSportPanel extends HotSportPanel implements MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ShowInfoPanel showInfoPanel;
	
	public SeasonHotSportPanel() {
		showInfoPanel = new ShowInfoPanel();
		showInfoPanel.setBounds((int) (NUMBER.px * 30 + inter * 2), (int) (NUMBER.px * 36) * 3, NUMBER.NAVIGATION_PANEL_WIDTH - 2 * (int) (NUMBER.px * 30 + inter * 2), (int) (NUMBER.px * 36) * 16);
		this.add(showInfoPanel);
		
	}

	class ShowInfoPanel extends JPanel implements MouseListener {
		/**
		 * 
		 */
		protected static final long serialVersionUID = 1L;
		protected MyButton gameAverageScore, gameAverageRebounds, gameAverageAssist, gameAverageBlock, gameAverageSteal, threePointRate, shootingRate, freeThrowRate;// 按钮
		protected MyLabel firstLabel, secondLabel, thirdLabel, fourthLabel, fifthLabel;
		protected MyLabel firstPortraitLabel, secondPortraitLabel, thirdPortraitLabel, fourthPortraitLabel, fifthPortraitLabel;
		protected MyLabel firstNameLabel, secondNameLabel, thirdNameLabel, fourthNameLabel, fifthNameLabel;
		protected MyLabel firstPositionLabel, secondPositionLabel, thirdPositionLabel, fourthPositionLabel, fifthPositionLabel;
		protected MyLabel firstScoreLabel, secondScoreLabel, thirdScoreLabel, fourthScoreLabel, fifthScoreLabel;
		protected MyLabel firstTeamLabel, secondTeamLabel, thirdTeamLabel, fourthTeamLabel, fifthTeamLabel;

		protected final int columnZero = buttonWidth * 3 / 2 + (int) (NUMBER.px * 80);
		protected final int columnOne = buttonWidth * 4;
		protected final int columnTwo = buttonWidth * 4 + (int) (NUMBER.px * 30);
		protected final int columnThree = buttonWidth * 4 + (int) (NUMBER.px * 30) + buttonWidth * 3 / 4;
		protected final int columnFour = buttonWidth * 7 + (int) (NUMBER.px * 30) + buttonWidth * 1 / 4;
		protected final int columnFive = buttonWidth * 3 / 2 + (int) (NUMBER.px * 50) + buttonWidth * 3 / 2;

		protected final int rowOne = buttonHeight + (int) (NUMBER.px * 36);
		protected final int rowTwo = buttonHeight + (int) (NUMBER.px * 36) * 4;
		protected final int rowThree = buttonHeight + (int) (NUMBER.px * 36) * 7;
		protected final int rowFour = buttonHeight + (int) (NUMBER.px * 36) * 10;
		
		protected final int numberWidth= (int) (NUMBER.px * 36);
		protected final int portraitLabelWidth=buttonWidth * 3 / 4;
		protected final int nameLabelWidth=buttonWidth;
		protected final int positionLabelWidth=buttonWidth;
		protected final int scoreLabelWidth=buttonWidth;
		protected final int teamLabelWidth= buttonWidth;
		protected final int labelHeight=(int) (NUMBER.px * 36) * 4;
		protected final int scoreHeight=buttonHeight / 5;

		protected final Font nameLabelFont = new Font("微软雅黑", Font.PLAIN, 18);

		public ShowInfoPanel() {
			this.setLayout(null);
			this.setBackground(new Color(213, 212, 212));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.addListener();
			this.setVisible(true);
		}

		protected void setComponentsStyle() {
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

		protected void addListener() {
			gameAverageScore.addMouseListener(this);
			gameAverageRebounds.addMouseListener(this);
			gameAverageAssist.addMouseListener(this);
			gameAverageBlock.addMouseListener(this);
			gameAverageSteal.addMouseListener(this);
			threePointRate.addMouseListener(this);
			shootingRate.addMouseListener(this);
			freeThrowRate.addMouseListener(this);
		}

		protected void setComponentsLocation() {
			gameAverageScore.setLocation(0, 0);
			gameAverageRebounds.setLocation(buttonWidth, 0);
			gameAverageAssist.setLocation(buttonWidth * 2, 0);
			gameAverageBlock.setLocation(buttonWidth * 3, 0);
			gameAverageSteal.setLocation(buttonWidth * 4, 0);
			threePointRate.setLocation(buttonWidth * 5, 0);
			shootingRate.setLocation(buttonWidth * 6, 0);
			freeThrowRate.setLocation(buttonWidth * 7, 0);

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

			this.add(gameAverageScore);
			this.add(gameAverageRebounds);
			this.add(gameAverageAssist);
			this.add(gameAverageBlock);
			this.add(gameAverageSteal);
			this.add(threePointRate);
			this.add(shootingRate);
			this.add(freeThrowRate);

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

		protected void createObjects() {
			gameAverageScore = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageScore.png"),buttonWidth,buttonHeight);
			gameAverageRebounds = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageRebounds.png"),buttonWidth,buttonHeight);
			gameAverageAssist = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageAssist.png"),buttonWidth,buttonHeight);
			gameAverageBlock = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageBlock.png"),buttonWidth,buttonHeight);
			gameAverageSteal = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageSteal.png"),buttonWidth,buttonHeight);
			threePointRate = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "threePointRate.png"),buttonWidth,buttonHeight);
			shootingRate = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "shootingRate.png"),buttonWidth,buttonHeight);
			freeThrowRate = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "freeThrowRate.png"),buttonWidth,buttonHeight);

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
			if (e.getSource().equals(gameAverageScore)) {

			} else if (e.getSource().equals(gameAverageRebounds)) {

			} else if (e.getSource().equals(gameAverageAssist)) {

			} else if (e.getSource().equals(gameAverageBlock)) {

			} else if (e.getSource().equals(gameAverageSteal)) {

			} else if (e.getSource().equals(threePointRate)) {

			} else if (e.getSource().equals(shootingRate)) {

			} else if (e.getSource().equals(freeThrowRate)) {

			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageScore_enter.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageRebounds_enter.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageAssist_enter.png"));
			} else if (e.getSource().equals(gameAverageBlock)) {
				gameAverageBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageBlock_enter.png"));
			} else if (e.getSource().equals(gameAverageSteal)) {
				gameAverageSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageSteal_enter.png"));
			} else if (e.getSource().equals(threePointRate)) {
				threePointRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "threePointRate_enter.png"));
			} else if (e.getSource().equals(shootingRate)) {
				shootingRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "shootingRate_enter.png"));
			} else if (e.getSource().equals(freeThrowRate)) {
				freeThrowRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "freeThrowRate_enter.png"));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageScore.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageRebounds.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageAssist.png"));
			} else if (e.getSource().equals(gameAverageBlock)) {
				gameAverageBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageBlock.png"));
			} else if (e.getSource().equals(gameAverageSteal)) {
				gameAverageSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageSteal.png"));
			} else if (e.getSource().equals(threePointRate)) {
				threePointRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "threePointRate.png"));
			} else if (e.getSource().equals(shootingRate)) {
				shootingRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "shootingRate.png"));
			} else if (e.getSource().equals(freeThrowRate)) {
				freeThrowRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "freeThrowRate.png"));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageScore_click.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageRebounds_click.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageAssist_click.png"));
			} else if (e.getSource().equals(gameAverageBlock)) {
				gameAverageBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageBlock_click.png"));
			} else if (e.getSource().equals(gameAverageSteal)) {
				gameAverageSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageSteal_click.png"));
			} else if (e.getSource().equals(threePointRate)) {
				threePointRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "threePointRate_click.png"));
			} else if (e.getSource().equals(shootingRate)) {
				shootingRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "shootingRate_click.png"));
			} else if (e.getSource().equals(freeThrowRate)) {
				freeThrowRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "freeThrowRate_click.png"));
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageScore.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageRebounds.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageAssist.png"));
			} else if (e.getSource().equals(gameAverageBlock)) {
				gameAverageBlock.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageBlock.png"));
			} else if (e.getSource().equals(gameAverageSteal)) {
				gameAverageSteal.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "gameAverageSteal.png"));
			} else if (e.getSource().equals(threePointRate)) {
				threePointRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "threePointRate.png"));
			} else if (e.getSource().equals(shootingRate)) {
				shootingRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "shootingRate.png"));
			} else if (e.getSource().equals(freeThrowRate)) {
				freeThrowRate.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "freeThrowRate.png"));
			}
		}
	}

}

class NavigationPanel extends JPanel {
	/**
	 * 导航栏
	 */
	private static final long serialVersionUID = 1L;
	private JLabel currentPanelLabel;
	private JButton quitSystem, playerPanelButton, teamPanelButton;

	public NavigationPanel() {
		this.setLayout(null);
		this.setBackground(MyColor.MIDDLE_COLOR);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.setVisible(true);

	}

	public void addCurrentInfo(String string) {
		currentPanelLabel.setText(string);
	}

	private void createObjects() {
		currentPanelLabel = new JLabel("球员数据");
		quitSystem = new MyButton("退出系统");
		playerPanelButton = new MyButton("球员数据");
		teamPanelButton = new MyButton("球队数据");
	}

	private void setComponentsLocation() {
		currentPanelLabel.setBounds((int) (NUMBER.FRAME_WIDTH / 9 * 2 - NUMBER.px * 200) / 2, (NUMBER.NAVIGATION_PANEL_HEIGHT - (int) (NUMBER.px * 100)) / 2, (int) (NUMBER.px * 200), (int) (NUMBER.px * 100));
		teamPanelButton.setBounds((int) (NUMBER.px * 340), (int) (NUMBER.px * 29), (int) (NUMBER.px * 160), (int) (NUMBER.px * 40));
		playerPanelButton.setBounds((int) (NUMBER.px * 520), (int) (NUMBER.px * 29), (int) (NUMBER.px * 160), (int) (NUMBER.px * 40));
		quitSystem.setBounds((int) (NUMBER.px * 700), (int) (NUMBER.px * 29), (int) (NUMBER.px * 160), (int) (NUMBER.px * 40));
		this.add(currentPanelLabel);
		this.add(teamPanelButton);
		this.add(playerPanelButton);
		this.add(quitSystem);
	}

	private void setComponentsStyle() {
		currentPanelLabel.setFont(MyFont.LARGEST_BOLD);
		currentPanelLabel.setForeground(MyColor.MY_WHITE);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(MyColor.MY_WHITE);
		g.drawLine((int) (NUMBER.px * 510), (int) (NUMBER.px * 35), (int) (NUMBER.px * 510), (int) (NUMBER.px * 65));
		g.drawLine((int) (NUMBER.px * 690), (int) (NUMBER.px * 35), (int) (NUMBER.px * 690), (int) (NUMBER.px * 65));
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
