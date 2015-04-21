package presentation.hotsport;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import businesslogicservice.hotsport.TeamHotBlService;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class MostImprovedPlayerPanel extends HotSportPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TeamHotBlService teamHotBl;
	private ShowInfoPanel showInfoPanel;

	private int width = ((int) NUMBER.NAVIGATION_PANEL_WIDTH - 2 * (int) (NUMBER.px * 30 + inter * 2)) / 3;
	private int height = (int) (NUMBER.px * 50);

	public MostImprovedPlayerPanel() {
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
		MostImprovedPlayerPanel contentPanel = new MostImprovedPlayerPanel();
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);

	}

	class ShowInfoPanel extends JPanel implements MouseListener {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MyButton gameAverageScore, gameAverageRebounds, gameAverageAssist;// 按钮
		private MyLabel firstLabel, secondLabel, thirdLabel, fourthLabel, fifthLabel;
		private MyLabel firstPortraitLabel, secondPortraitLabel, thirdPortraitLabel, fourthPortraitLabel, fifthPortraitLabel;
		private MyLabel firstNameLabel, secondNameLabel, thirdNameLabel, fourthNameLabel, fifthNameLabel;
		private MyLabel firstPositionLabel, secondPositionLabel, thirdPositionLabel, fourthPositionLabel, fifthPositionLabel;
		private MyLabel firstScoreLabel, secondScoreLabel, thirdScoreLabel, fourthScoreLabel, fifthScoreLabel;
		private MyLabel firstSprit, secondSprit, thirdSprit, fourthSprit, fifthSprit;
		private MyLabel firstUpgradeRateLabel, secondUpgradeRateLabel, thirdUpgradeRateLabel, fourthUpgradeRateLabel, fifthUpgradeRateLabel;
		private MyLabel firstRecentFiveLabel, secondRecentFiveLabel, thirdRecentFiveLabel, fourthRecentFiveLabel, fifthRecentFiveLabel;
		private MyLabel firstTeamLabel, secondTeamLabel, thirdTeamLabel, fourthTeamLabel, fifthTeamLabel;
		private MyLabel sortLabel, teamLabel, recentFiveAndRateLabel;

		private final int columnZero = (int) (NUMBER.px * 100) + width + buttonWidth / 2;
		private final int columnOne = (int) (NUMBER.px * 50) * 2;
		private final int columnTwo = (int) (NUMBER.px * 50) * 2 + width / 2;
		private final int columnThree = columnTwo + buttonWidth * 3 / 4;
		private final int columnFour = width * 3 / 2 + buttonHeight;
		private final int columnFive = columnFour + buttonWidth * 5 / 12;
		private final int columnSix = columnFour + buttonWidth / 2;
		private final int columnSeven = width * 5 / 2 + buttonHeight;

		private final int rowZero = buttonHeight + buttonHeight * 9 / 2;
		private final int rowOne = buttonHeight + buttonHeight * 23 / 4;
		private final int rowTwo = buttonHeight + buttonHeight * 29 / 4;
		private final int rowThree = buttonHeight + buttonHeight * 35 / 4;
		private final int rowFour = buttonHeight + buttonHeight * 41 / 4;
		private final int rowRecentFive=buttonHeight / 2;
		
		private final int numberWidth= width / 2;
		private final int portraitLabelWidth=buttonWidth * 3 / 4;
		private final int nameLabelWidth=buttonWidth;
		private final int positionLabelWidth=buttonWidth;
		private final int scoreLabelWidth=width * 3 / 4;
		private final int upgradeRateLabelWidth=width * 3 / 8;
		private final int teamLabelWidth= width / 2;
		private final int labelHeight=buttonWidth * 3 / 4;

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

			sortLabel.setFont(MyFont.SMALLEST_BOLD);
			teamLabel.setFont(MyFont.SMALLEST_BOLD);
			recentFiveAndRateLabel.setFont(MyFont.SMALLEST_BOLD);

			firstLabel.setFont(new Font("微软雅黑", Font.BOLD, 50));
			firstNameLabel.setFont(MyFont.MIDDLE_PLAIN);
			firstPositionLabel.setFont(MyFont.SMALL_PLAIN);
			firstRecentFiveLabel.setFont(MyFont.SMALLEST_BOLD);
			firstSprit.setFont(MyFont.MIDDLE_PLAIN);
			firstUpgradeRateLabel.setFont(MyFont.MIDDLE_PLAIN);
			firstScoreLabel.setFont(new Font("微软雅黑", Font.BOLD, 40));

			secondLabel.setFont(MyFont.MIDDLE_BOLD);
			secondNameLabel.setFont(MyFont.SMALLEST_PLAIN);
			secondPositionLabel.setFont(MyFont.SMALLEST_PLAIN);
			secondRecentFiveLabel.setFont(MyFont.SMALLEST_BOLD);
			secondSprit.setFont(MyFont.SMALL_PLAIN);
			secondUpgradeRateLabel.setFont(MyFont.SMALL_PLAIN);
			secondScoreLabel.setFont(MyFont.MIDDLE_BOLD);

			thirdLabel.setFont(MyFont.MIDDLE_BOLD);
			thirdNameLabel.setFont(MyFont.SMALLEST_PLAIN);
			thirdPositionLabel.setFont(MyFont.SMALLEST_PLAIN);
			thirdRecentFiveLabel.setFont(MyFont.SMALLEST_BOLD);
			thirdSprit.setFont(MyFont.SMALL_PLAIN);
			thirdUpgradeRateLabel.setFont(MyFont.MIDDLE_PLAIN);
			thirdScoreLabel.setFont(MyFont.MIDDLE_BOLD);

			fourthLabel.setFont(MyFont.MIDDLE_BOLD);
			fourthNameLabel.setFont(MyFont.SMALLEST_PLAIN);
			fourthPositionLabel.setFont(MyFont.SMALLEST_PLAIN);
			fourthRecentFiveLabel.setFont(MyFont.SMALLEST_BOLD);
			fourthSprit.setFont(MyFont.SMALL_PLAIN);
			fourthUpgradeRateLabel.setFont(MyFont.MIDDLE_PLAIN);
			fourthScoreLabel.setFont(MyFont.MIDDLE_BOLD);

			fifthLabel.setFont(MyFont.MIDDLE_BOLD);
			fifthNameLabel.setFont(MyFont.SMALLEST_PLAIN);
			fifthPositionLabel.setFont(MyFont.SMALLEST_PLAIN);
			fifthRecentFiveLabel.setFont(MyFont.SMALLEST_BOLD);
			fifthSprit.setFont(MyFont.SMALL_PLAIN);
			fifthUpgradeRateLabel.setFont(MyFont.MIDDLE_PLAIN);
			fifthScoreLabel.setFont(MyFont.MIDDLE_BOLD);

		}

		private void addListener() {
			gameAverageScore.addMouseListener(this);
			gameAverageRebounds.addMouseListener(this);
			gameAverageAssist.addMouseListener(this);
		}

		private void setComponentsLocation() {
			gameAverageScore.setLocation(0, 0);
			gameAverageRebounds.setLocation(width, 0);
			gameAverageAssist.setLocation(width * 2, 0);

			sortLabel.setBounds(columnOne, rowZero, width * 3 / 2, (int) (NUMBER.px * 36) * 2);
			teamLabel.setBounds(columnTwo, rowZero, width * 3 / 2, (int) (NUMBER.px * 36) * 2);
			recentFiveAndRateLabel.setBounds(columnFour, rowZero, width * 3 / 2, (int) (NUMBER.px * 36) * 2);

			firstLabel.setBounds((int) (NUMBER.px * 50), buttonHeight, (int) (NUMBER.px * 50), (int) (NUMBER.px * 36) * 6);
			firstPortraitLabel.setBounds((int) (NUMBER.px * 100), buttonHeight, width, (int) (NUMBER.px * 36) * 6);
			firstNameLabel.setBounds(columnZero, buttonHeight * 4 / 3, width * 3 / 4, (int) (NUMBER.px * 36) * 2);
			firstPositionLabel.setBounds(columnZero, buttonHeight * 5 / 2, width * 3 / 4, (int) (NUMBER.px * 36));
			firstRecentFiveLabel.setBounds(columnZero, buttonHeight * 7 / 2, width * 3 / 4, (int) (NUMBER.px * 36));
			firstSprit.setBounds((int) (NUMBER.px * 100) + width + buttonWidth * 11 / 12, buttonHeight * 22 / 5, width / 3, (int) (NUMBER.px * 36));
			firstUpgradeRateLabel.setBounds((int) (NUMBER.px * 100) + width + buttonWidth, buttonHeight * 4, width * 3 / 8, (int) (NUMBER.px * 36) * 2);
			firstScoreLabel.setBounds(columnZero, buttonHeight * 4, width * 3 / 8, (int) (NUMBER.px * 36) * 2);
			firstTeamLabel.setBounds((int) (NUMBER.px * 100) + width * 2 + buttonWidth / 2, buttonHeight * 4 / 3, width / 2, (int) (NUMBER.px * 36) * 3);
			// firstTeamLabel.setBackground(Color.black);

			secondLabel.setBounds(columnOne, buttonHeight + buttonHeight * 11 / 2, numberWidth, labelHeight);
			secondPortraitLabel.setBounds(columnTwo, rowOne, portraitLabelWidth, labelHeight);
			secondNameLabel.setBounds(columnThree, rowOne, nameLabelWidth, (int) labelHeight / 2);
			secondPositionLabel.setBounds(columnThree, rowOne + (int) (NUMBER.px * 36) * 3 / 4, positionLabelWidth, labelHeight / 2);
			secondScoreLabel.setBounds(columnFour, rowOne-rowRecentFive,scoreLabelWidth , labelHeight);
			secondSprit.setBounds(columnFive,rowOne-rowRecentFive, width / 12,labelHeight);
			secondUpgradeRateLabel.setBounds(columnSix, rowOne-rowRecentFive, upgradeRateLabelWidth, labelHeight);
			secondTeamLabel.setBounds(columnSeven, rowOne,teamLabelWidth, labelHeight);

			thirdLabel.setBounds(columnOne, buttonHeight + buttonHeight * 7,numberWidth, labelHeight);
			thirdPortraitLabel.setBounds(columnTwo, rowTwo, portraitLabelWidth, labelHeight);
			thirdNameLabel.setBounds(columnThree, rowTwo, nameLabelWidth, labelHeight / 2);
			thirdPositionLabel.setBounds(columnThree, rowTwo + (int) (NUMBER.px * 36) * 3 / 4, positionLabelWidth, labelHeight / 2);
			thirdScoreLabel.setBounds(columnFour, rowTwo-rowRecentFive, scoreLabelWidth,labelHeight);
			thirdSprit.setBounds(columnFive,rowTwo-rowRecentFive, width / 12, labelHeight);
			thirdUpgradeRateLabel.setBounds(columnSix,rowOne-rowRecentFive, upgradeRateLabelWidth, labelHeight);
			thirdTeamLabel.setBounds(columnSeven, rowTwo, teamLabelWidth, labelHeight);

			fourthLabel.setBounds(columnOne, buttonHeight + buttonHeight * 17 / 2, numberWidth, labelHeight);
			fourthPortraitLabel.setBounds(columnTwo, rowThree,portraitLabelWidth, labelHeight);
			fourthNameLabel.setBounds(columnThree, rowThree, nameLabelWidth, labelHeight / 2);
			fourthPositionLabel.setBounds(columnThree, rowThree + (int) (NUMBER.px * 36) * 3 / 4, positionLabelWidth, labelHeight/ 2);
			fourthScoreLabel.setBounds(columnFour, rowThree-rowRecentFive, scoreLabelWidth, labelHeight);
			fourthSprit.setBounds(columnFive, rowThree-rowRecentFive, width / 12, labelHeight);
			fourthUpgradeRateLabel.setBounds(columnSix, rowOne-rowRecentFive, upgradeRateLabelWidth, labelHeight);
			fourthTeamLabel.setBounds(columnSeven, rowThree, teamLabelWidth, labelHeight);

			fifthLabel.setBounds(columnOne, buttonHeight + buttonHeight * 10, numberWidth, labelHeight);
			fifthPortraitLabel.setBounds(columnTwo, rowFour,portraitLabelWidth, labelHeight);
			fifthNameLabel.setBounds(columnThree, rowFour, nameLabelWidth,labelHeight / 2);
			fifthPositionLabel.setBounds(columnThree, rowFour + (int) (NUMBER.px * 36) * 3 / 4, positionLabelWidth, labelHeight / 2);
			fifthScoreLabel.setBounds(columnFour, rowFour-rowRecentFive,scoreLabelWidth, labelHeight);
			fifthSprit.setBounds(columnFive, rowFour-rowRecentFive, width / 12, labelHeight);
			fifthUpgradeRateLabel.setBounds(columnSix, rowOne-rowRecentFive,upgradeRateLabelWidth , labelHeight);
			fifthTeamLabel.setBounds(columnSeven, rowFour, teamLabelWidth, labelHeight);

			this.add(gameAverageScore);
			this.add(gameAverageRebounds);
			this.add(gameAverageAssist);

			this.add(sortLabel);
			this.add(teamLabel);
			this.add(recentFiveAndRateLabel);

			this.add(firstLabel);
			this.add(firstPortraitLabel);
			this.add(firstNameLabel);
			this.add(firstPositionLabel);
			this.add(firstRecentFiveLabel);
			this.add(firstSprit);
			this.add(firstUpgradeRateLabel);
			this.add(firstScoreLabel);
			this.add(firstTeamLabel);

			this.add(secondLabel);
			this.add(secondPortraitLabel);
			this.add(secondNameLabel);
			this.add(secondPositionLabel);
			this.add(secondRecentFiveLabel);
			this.add(secondSprit);
			this.add(secondUpgradeRateLabel);
			this.add(secondScoreLabel);
			this.add(secondTeamLabel);

			this.add(thirdLabel);
			this.add(thirdPortraitLabel);
			this.add(thirdNameLabel);
			this.add(thirdPositionLabel);
			this.add(thirdRecentFiveLabel);
			this.add(thirdSprit);
			this.add(thirdUpgradeRateLabel);
			this.add(thirdScoreLabel);
			this.add(thirdTeamLabel);

			this.add(fourthLabel);
			this.add(fourthPortraitLabel);
			this.add(fourthNameLabel);
			this.add(fourthPositionLabel);
			this.add(fourthRecentFiveLabel);
			this.add(fourthSprit);
			this.add(fourthUpgradeRateLabel);
			this.add(fourthScoreLabel);
			this.add(fourthTeamLabel);

			this.add(fifthLabel);
			this.add(fifthPortraitLabel);
			this.add(fifthNameLabel);
			this.add(fifthPositionLabel);
			this.add(fifthRecentFiveLabel);
			this.add(fifthSprit);
			this.add(fifthUpgradeRateLabel);
			this.add(fifthScoreLabel);
			this.add(fifthTeamLabel);

		}

		private void createObjects() {
			gameAverageScore = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageScore.png"), width, height);
			gameAverageRebounds = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageRebounds.png"), width, height);
			gameAverageAssist = new MyButton(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageAssist.png"), width, height);

			sortLabel = new MyLabel();
			sortLabel.setText("排名");
			teamLabel = new MyLabel();
			teamLabel.setText("球队");
			recentFiveAndRateLabel = new MyLabel();
			recentFiveAndRateLabel.setText("最近5场 /提升率");

			firstPortraitLabel = new MyLabel();
			firstNameLabel = new MyLabel();
			firstNameLabel.setText("拉塞尔威斯布鲁克");
			firstPositionLabel = new MyLabel();
			firstPositionLabel.setText("0 后卫 / 奥克拉荷马城 雷霆");
			firstScoreLabel = new MyLabel();
			firstScoreLabel.setText("37");
			firstTeamLabel = new MyLabel();
			firstRecentFiveLabel = new MyLabel();
			firstRecentFiveLabel.setText("最近5场 / 提升率");
			firstSprit = new MyLabel();
			firstSprit.setText("/");
			firstUpgradeRateLabel = new MyLabel();
			firstUpgradeRateLabel.setText("147.19%");
			firstLabel = new MyLabel();
			firstLabel.setText("1");

			secondPortraitLabel = new MyLabel();
			secondNameLabel = new MyLabel();
			secondNameLabel.setText("迈克尔-比斯利");
			secondPositionLabel = new MyLabel();
			secondPositionLabel.setText("30 前锋 / 热火");
			secondScoreLabel = new MyLabel();
			secondScoreLabel.setText("34");
			secondRecentFiveLabel = new MyLabel();
			secondRecentFiveLabel.setText("最近5场 / 提升率");
			secondSprit = new MyLabel();
			secondSprit.setText("/");
			secondUpgradeRateLabel = new MyLabel();
			secondUpgradeRateLabel.setText("147.19%");
			secondTeamLabel = new MyLabel();
			secondLabel = new MyLabel("2");

			thirdPortraitLabel = new MyLabel();
			thirdNameLabel = new MyLabel();
			thirdNameLabel.setText("迈克尔-比斯利");
			thirdPositionLabel = new MyLabel();
			thirdScoreLabel = new MyLabel();
			thirdRecentFiveLabel = new MyLabel();
			thirdSprit = new MyLabel();
			thirdSprit.setText("/");
			thirdUpgradeRateLabel = new MyLabel();
			thirdTeamLabel = new MyLabel();
			thirdLabel = new MyLabel("3");

			fourthPortraitLabel = new MyLabel();
			fourthNameLabel = new MyLabel();
			fourthPositionLabel = new MyLabel();
			fourthScoreLabel = new MyLabel();
			fourthRecentFiveLabel = new MyLabel();
			fourthSprit = new MyLabel();
			fourthUpgradeRateLabel = new MyLabel();
			fourthTeamLabel = new MyLabel();
			fourthLabel = new MyLabel("4");

			fifthPortraitLabel = new MyLabel();
			fifthNameLabel = new MyLabel();
			fifthPositionLabel = new MyLabel();
			fifthScoreLabel = new MyLabel();
			fifthRecentFiveLabel = new MyLabel();
			fifthSprit = new MyLabel();
			fifthUpgradeRateLabel = new MyLabel();
			fifthTeamLabel = new MyLabel();
			fifthLabel = new MyLabel("5");

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {

			} else if (e.getSource().equals(gameAverageRebounds)) {

			} else if (e.getSource().equals(gameAverageAssist)) {

			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageScore_enter.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageRebounds_enter.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageAssist_enter.png"));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageScore.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageRebounds.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageAssist.png"));
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageScore_click.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageRebounds_click.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageAssist_click.png"));
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (e.getSource().equals(gameAverageScore)) {
				gameAverageScore.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageScore.png"));
			} else if (e.getSource().equals(gameAverageRebounds)) {
				gameAverageRebounds.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageRebounds.png"));
			} else if (e.getSource().equals(gameAverageAssist)) {
				gameAverageAssist.setMyIcon(new ImageIcon(PathOfFile.HOTSPORT + "bigGameAverageAssist.png"));
			}
		}
	}

}
