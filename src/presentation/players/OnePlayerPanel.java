package presentation.players;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import presentation.SonFrame;
import presentation.match.OneMatchPanel;
import presentation.teams.OneTeamPanel;
import test.data.PlayerHighInfo;
import businesslogic.matches.MatchInfoBl;
import businesslogic.players.OnePlayerInfoBl;
import businesslogicservice.players.OnePlayerInfoBlService;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyScrollPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mycomponent.MyTextArea;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.mydatastructure.GeneralInfoOfPlayer;
import common.mydatastructure.MyDate;
import common.mydatastructure.PlayerNormalInfo_Expand;
import common.mydatastructure.PlayerPerformOfOneMatch;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class OnePlayerPanel extends MyPanel implements MouseListener {
	private MyPanel thisPanel = this;
	private String playerName;
	private MyButton[] button = new MyButton[] { new MyButton("普通数据"), new MyButton("高级数据"), new MyButton("近期比赛") };
	private MyPanel[] panel;
	private GeneralInfoPanel generalInfoPanel;
	private MyButton teamLogo;
	private ContentPanel contentPanel;
	private int buttonHeight = (int) (NUMBER.px * 50);
	private int buttonWidth = (int) (NUMBER.px * 400);
	private static final long serialVersionUID = 1L;
	private OnePlayerInfoBlService onePlayerInfoBl = new OnePlayerInfoBl();
	private GeneralInfoOfPlayer PlayerGeneralInfo;
	private PlayerNormalInfo_Expand playerNormal_avg;
	private PlayerHighInfo playerHigh;
	private ArrayList<PlayerPerformOfOneMatch> playerOneMatchInfoList;
	private int flag = 0;

	public OnePlayerPanel(String playerName) {
		this.playerName = playerName;
		PlayerGeneralInfo = onePlayerInfoBl.getPlayerGeneralInfo(playerName);
		playerNormal_avg = onePlayerInfoBl.getPlayerNormalInfo_avg(playerName);
		playerHigh = onePlayerInfoBl.getPlayerHighInfo(playerName);
		playerOneMatchInfoList = onePlayerInfoBl.getPlayerPerform(playerName);
		panel = new MyPanel[] { new PlayerNormalInfoPanel(), new PlayerHighInfoPanel(), new AllMatchInfoPanel() };
		this.createObjects();
		this.setComponentsLocation();
		this.setCompStyle();
		this.addListener();
		this.setVisible(true);
	}

	private void createObjects() {
		generalInfoPanel = new GeneralInfoPanel();
		contentPanel = new ContentPanel();
		teamLogo = new MyButton(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + playerNormal_avg.getTeamName() + ".png"), (int) (NUMBER.px * 150),
				(int) (NUMBER.px * 100));
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 3; i++) {
			button[i].setBounds((int) (NUMBER.px * 50) + buttonWidth * i, (int) (NUMBER.px * 230), buttonWidth, buttonHeight);
			button[i].setBackground(MyColor.MIDDLE_COLOR);
			button[i].setForeground(MyColor.MY_WHITE);
			button[i].setFont(MyFont.SMALL_BOLD);
			button[i].setContentAreaFilled(true);
			button[i].addMouseListener(this);
			this.add(button[i]);
		}
		teamLogo.setBounds((int) (NUMBER.px * 1000), (int) (NUMBER.px * 50), (int) (NUMBER.px * 150), (int) (NUMBER.px * 100));
		generalInfoPanel.setBounds(0, 0, (int) (NUMBER.px * 1000), (int) (NUMBER.px * 230));
		contentPanel.setBounds(0, (int) (NUMBER.px * 280), NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - (int) -(NUMBER.px * 280));
		this.add(generalInfoPanel);
		this.add(contentPanel);
		this.add(teamLogo);
	}

	private void setCompStyle() {
		button[flag].setBackground(MyColor.MY_ORIANGE);
	}

	private void addListener() {
		teamLogo.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource().equals(button[i])) {
				contentPanel.showMyPanel(i);
				button[flag].setBackground(MyColor.MIDDLE_COLOR);
				button[i].setBackground(MyColor.MY_ORIANGE);
				flag = i;
			}
		}
		if (e.getSource().equals(teamLogo)) {
			OneTeamPanel teamPanel = new OneTeamPanel(playerNormal_avg.getTeamName());
			SonFrame.changePanel(this, teamPanel);
		}
	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource().equals(button[i])) {
				button[i].setBackground(MyColor.DEEP_COLOR);
			}
		}
		if (e.getSource().equals(teamLogo)) {
			teamLogo.setLocation(teamLogo.getX() - NUMBER.STEP, teamLogo.getY() - NUMBER.STEP);
		}
	}

	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < 3; i++) {
			if (e.getSource().equals(button[i])) {
				if (flag == i) {
					button[i].setBackground(MyColor.MY_ORIANGE);
				}
				else {
					button[i].setBackground(MyColor.MIDDLE_COLOR);
				}
			}
		}
		if (e.getSource().equals(teamLogo)) {
			teamLogo.setLocation(teamLogo.getX() + (int) (NUMBER.px * 3), teamLogo.getY() + (int) (NUMBER.px * 3));
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	class GeneralInfoPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		private MyLabel portrait;
		private JTextArea playerNameText;
		private JTextArea normalInfoText;
		private JTextArea mainMatchInfoText;

		public GeneralInfoPanel() {
			this.setSize(NUMBER.FRAME_WIDTH, (int) (NUMBER.px * 230));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.setContents();
		}

		private void createObjects() {
			portrait = new MyLabel();
			playerNameText = new MyTextArea();
			normalInfoText = new MyTextArea();
			mainMatchInfoText = new MyTextArea();
		}

		private void setComponentsLocation() {
			portrait.setBounds((int) (NUMBER.px * 70), (int) (NUMBER.px * 10), (int) (NUMBER.px * 260), (int) (NUMBER.px * 220));
			playerNameText.setBounds((int) (NUMBER.px * 400), (int) (NUMBER.px * 10), (int) (NUMBER.px * 140), (int) (NUMBER.px * 200));
			normalInfoText.setBounds((int) (NUMBER.px * 700), (int) (NUMBER.px * 10), (int) (NUMBER.px * 400), (int) (NUMBER.px * 240));
			mainMatchInfoText.setBounds((int) (NUMBER.px * 400), (int) (NUMBER.px * 150), (int) (NUMBER.px * 400), (int) (NUMBER.px * 60));
			this.add(portrait);
			this.add(playerNameText);
			this.add(normalInfoText);
			this.add(mainMatchInfoText);
		}

		private void setComponentsStyle() {
			playerNameText.setFont(MyFont.MIDDLE_BOLD);
			mainMatchInfoText.setFont(MyFont.SMALL_PLAIN);
			normalInfoText.setFont(MyFont.SMALL_PLAIN);
		}

		private void setContents() {
			portrait.setMyIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + playerName + ".png"));
			playerNameText.setText(playerName);
			mainMatchInfoText.setText("得分    篮板    助攻\n" + playerNormal_avg.getPoint() + "  " + playerNormal_avg.getRebound() + "  "
					+ playerNormal_avg.getAssist());
			normalInfoText.setText("号码：" + PlayerGeneralInfo.getPlayerNumber() + "\n位置：" + PlayerGeneralInfo.getPosition() + "\n身高："
					+ PlayerGeneralInfo.getHeight() + "\n体重：" + PlayerGeneralInfo.getWeight() + "\n生日：" + PlayerGeneralInfo.getBirthday() + "\n年龄："
					+ PlayerGeneralInfo.getAge() + "\n球龄：" + PlayerGeneralInfo.getTrainingYear() + "\n毕业院校：" + PlayerGeneralInfo.getSchool());
		}
	}

	class ContentPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;

		ContentPanel() {
			card = new CardLayout();
			this.setLayout(card);
			for (int i = 0; i < 3; i++) {
				this.add(panel[i], String.valueOf(i));
			}
			this.setVisible(true);
		}

		public void showMyPanel(int i) {
			this.card.show(contentPanel, String.valueOf(i));
		}
	}

	class PlayerNormalInfoPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		private final int labelHeight = (int) (NUMBER.px * 60);
		private final int labelWidth = (int) (NUMBER.px * 115);
		private final int gap = (int) (NUMBER.px * 8);
		private MyLabel fieldLabel[] = new MyLabel[25];
		private MyLabel value[] = new MyLabel[25];
		private String[] fieldString = { "所属球队:", "参赛场数:", "首发次数:", "在场时间:", "效率值:", "得分:", "投篮命中率:", "篮板:", "助攻:", "抢断:", "盖帽:", "两双次数:", "三双次数:",
				"失误:", "犯规:", "三分命中率:", "罚球命中率:", "进攻篮板数:", "防守篮板:", "场均出手数:", "场均命中数:", "场均三分出手数:", "场均三分命中数:", "场均罚球出手数:", "场均罚球命中数:" };

		private String[] valueString = { playerNormal_avg.getTeamName(), String.valueOf(playerNormal_avg.getNumOfGame()),
				String.valueOf(playerNormal_avg.getStart()), String.valueOf(playerNormal_avg.getMinute()),
				String.valueOf(playerNormal_avg.getEfficiency()), String.valueOf(playerNormal_avg.getPoint()),
				String.valueOf(playerNormal_avg.getShot()), String.valueOf(playerNormal_avg.getRebound()),
				String.valueOf(playerNormal_avg.getAssist()), String.valueOf(playerNormal_avg.getSteal()),
				String.valueOf(playerNormal_avg.getBlockShot()), String.valueOf(playerNormal_avg.getDoubleTwo()),
				String.valueOf(playerNormal_avg.getTripleTwo()), String.valueOf(playerNormal_avg.getFault()),
				String.valueOf(playerNormal_avg.getFoul()), String.valueOf(playerNormal_avg.getThree()),
				String.valueOf(playerNormal_avg.getPenalty()), String.valueOf(playerNormal_avg.getOffend()),
				String.valueOf(playerNormal_avg.getDefend()), String.valueOf(playerNormal_avg.getTotalShot()),
				String.valueOf(playerNormal_avg.getTotalHit()), String.valueOf(playerNormal_avg.getThreeShot()),
				String.valueOf(playerNormal_avg.getThreeHit()), String.valueOf(playerNormal_avg.getFreehot()),
				String.valueOf(playerNormal_avg.getFreeHit()) };

		public PlayerNormalInfoPanel() {
			for (int i = 0; i < 25; i++) {
				fieldLabel[i] = new MyLabel(fieldString[i]);
				value[i] = new MyLabel(valueString[i]);
			}
			for (int i = 0; i < 25; i++) {
				fieldLabel[i].setBounds((labelWidth + gap) * (i % 5) * 2 + labelWidth / 2, (i / 5 + 1) * labelHeight, labelWidth, labelHeight);
				this.add(fieldLabel[i]);
				value[i].setBounds(fieldLabel[i].getX() + labelWidth, fieldLabel[i].getY(), labelWidth, labelHeight);
				this.add(value[i]);
			}
			this.setVisible(true);
		}
	}

	class PlayerHighInfoPanel extends MyPanel {

		private static final long serialVersionUID = 1L;
		private final int labelHeight = (int) (NUMBER.px * 60);
		private final int labelWidth = (int) (NUMBER.px * 120);
		private final int gap = (int) (NUMBER.px * 100);
		private MyLabel fieldLabel[] = new MyLabel[15];
		private MyLabel value[] = new MyLabel[15];
		private String[] fieldString = { "所属球队:", "所属联盟", "使用率", "GmSc效率值", "投篮效率:", "真实命中率:", "篮板率:", "助攻率:", "抢断率:", "盖帽率:", "两双次数:", "三双次数:",
				"失误率:", "进攻篮板率:", "防守篮板率:", };

		private String[] valueString = { playerHigh.getTeamName(), String.valueOf(playerHigh.getLeague()), String.valueOf(playerHigh.getFrequency()),
				String.valueOf(playerHigh.getGmSc()), String.valueOf(playerHigh.getShotEfficient()), String.valueOf(playerHigh.getRealShot()),
				String.valueOf(playerHigh.getReboundEfficient()), String.valueOf(playerHigh.getAssistEfficient()),
				String.valueOf(playerHigh.getStealEfficient()), String.valueOf(playerHigh.getBlockShotEfficient()),
				String.valueOf(playerNormal_avg.getDoubleTwo()), String.valueOf(playerNormal_avg.getTripleTwo()),
				String.valueOf(playerHigh.getFaultEfficient()), String.valueOf(playerHigh.getOffendReboundEfficient()),
				String.valueOf(playerHigh.getDefendReboundEfficient()) };

		public PlayerHighInfoPanel() {
			for (int i = 0; i < 15; i++) {
				fieldLabel[i] = new MyLabel(fieldString[i]);
				value[i] = new MyLabel(valueString[i]);
			}
			for (int i = 0; i < 15; i++) {
				fieldLabel[i].setBounds((labelWidth + gap) * (i % 3) * 2 + labelWidth, (i / 3 + 1) * labelHeight, labelWidth, labelHeight);
				this.add(fieldLabel[i]);
				value[i].setBounds(fieldLabel[i].getX() + labelWidth, fieldLabel[i].getY(), labelWidth, labelHeight);
				this.add(value[i]);
			}
			this.setVisible(true);
		}
	}

	class AllMatchInfoPanel extends MyPanel {
		private static final long serialVersionUID = 1L;
		private String[] title = { "球队", "日期", "时间", "得分", "篮板", "助攻", "抢断", "盖帽", "失误", "犯规", "命中", "出手", "三分命中", "三分出手", "罚球命中", "罚球出手", "前板", "后板" };
		private MyTableModel model = new MyTableModel(title);
		private MyTable table = new MyTable(model);
		private MyScrollPanel scrollPanel = new MyScrollPanel(table);

		public AllMatchInfoPanel() {
			table.setTableColumnWidth(1, (int) (NUMBER.px * 90));
			table.setTableColumnWidth(12, (int) (NUMBER.px * 80));
			table.setTableColumnWidth(13, (int) (NUMBER.px * 80));
			table.setTableColumnWidth(14, (int) (NUMBER.px * 80));
			table.setTableColumnWidth(15, (int) (NUMBER.px * 80));
			if (playerOneMatchInfoList != null) {
				for (int i = playerOneMatchInfoList.size() - 1; i >= 0; i--) {
					model.addRow(playerOneMatchInfoList.get(i).toStringArray());
				}
			}
			scrollPanel.setBounds((int) (NUMBER.px * 50), (int) (NUMBER.px * 10), (int) (NUMBER.px * 1320), (int) (NUMBER.px * 400));
			this.add(scrollPanel);
			table.addMouseListener(new MouseListener() {

				public void mouseReleased(MouseEvent e) {
				}

				public void mousePressed(MouseEvent e) {
				}

				public void mouseExited(MouseEvent e) {
				}

				public void mouseEntered(MouseEvent e) {
				}

				public void mouseClicked(MouseEvent e) {
					if (table.getSelectedRow() >= 0 && table.getSelectedRow() < table.getRowCount()) {
						int row = table.getSelectedRow();
						String teamName = (String) table.getValueAt(row, 0);
						String dateString = (String) table.getValueAt(row, 1);
						MyDate date = new MyDate(dateString);
						GeneralInfoOfOneMatch generalMatch = new MatchInfoBl().getGeneralMatch(teamName, date);
						OneMatchPanel matchPanel = new OneMatchPanel(generalMatch);
						SonFrame.changePanel(thisPanel, matchPanel);
					}
				}
			});
			this.setVisible(true);
		}
	}
}
