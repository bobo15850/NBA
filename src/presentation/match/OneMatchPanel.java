package presentation.match;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import javax.swing.JTable;
import javax.swing.SwingConstants;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyScrollPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class OneMatchPanel extends MyPanel implements MouseListener{
	private MyLabel point;
	private MyButton firstTeamMemberInfoButton;
	private MyButton secondTeamMemberInfoButton;
	private MyButton teamMatchInfoButton;
	private MyLabel firstTeamLogo;
	private MyLabel secondTeamLogo;
	private ContentPanel contentPanel;
	private JScrollPane matchInfo;
	private MyTable matchInfoTable;
	private MyTableModel matchInfoTableModel;
	private int Label_height=(int)(NUMBER.px*40);
	private int Label_width=(int)(NUMBER.px*333);
	private String quarter[]={
		"球队","1","2","3","4","总分"	
	};
	//此处应加判断，如果有加时赛，字符数组加上加时
	//CardLayout里共有三个Panel，分别是：
	
//	主队球员数据panel
//	客队球员数据panel
//	两队该场比赛信息数据对比panel(新增,未完成)；
	
	
	public OneMatchPanel() {
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.initTable();
		this.setTableStyle();
		this.addListener();
	}

	private void addListener() {
		firstTeamMemberInfoButton.addMouseListener(this);
		secondTeamMemberInfoButton.addMouseListener(this);
		teamMatchInfoButton.addMouseListener(this);
	}

	private void createObjects() {
		firstTeamMemberInfoButton=new MyButton("主场球员数据");
		secondTeamMemberInfoButton=new MyButton("客场球员数据");
		teamMatchInfoButton=new MyButton("球队对比");
		point=new MyLabel();
		firstTeamLogo=new MyLabel();
		secondTeamLogo=new MyLabel();
		matchInfoTableModel=new MyTableModel(quarter);
		matchInfoTable=new MyTable(matchInfoTableModel);
		matchInfo=new MyScrollPanel();
		matchInfo.getViewport().add(matchInfoTable);
		contentPanel=new ContentPanel();
	}

	private void setComponentsLocation() {
		teamMatchInfoButton.setBounds((int)(NUMBER.px*865), (int)(NUMBER.px*250),Label_width, Label_height);
		firstTeamMemberInfoButton.setBounds((int)(NUMBER.px*200), (int)(NUMBER.px*250),Label_width, Label_height);
		secondTeamMemberInfoButton.setBounds((int)(NUMBER.px*532), (int)(NUMBER.px*250),Label_width, Label_height);
		firstTeamLogo.setBounds((int)(NUMBER.px*450), (int)(NUMBER.px*10),  (int)(NUMBER.px*100),  (int)(NUMBER.px*80));
		secondTeamLogo.setBounds((int)(NUMBER.px*850), (int)(NUMBER.px*10),  (int)(NUMBER.px*100),  (int)(NUMBER.px*80));
		point.setBounds((int)(NUMBER.px*550), (int)(NUMBER.px*10),  (int)(NUMBER.px*300),  (int)(NUMBER.px*100));
		matchInfo.setBounds((int)(NUMBER.px*200), (int)(NUMBER.px*100),  (int)(NUMBER.px*1000),  (int)(NUMBER.px*150));
		contentPanel.setBounds((int)(NUMBER.px*200), (int)(NUMBER.px*290),  (int)(NUMBER.px*1000),  (int)(NUMBER.px*600));
		this.add(firstTeamLogo);
		this.add(secondTeamLogo);
		this.add(point);
		this.add(matchInfo);
		this.add(contentPanel);
		this.add(firstTeamMemberInfoButton);
		this.add(secondTeamMemberInfoButton);
		this.add(teamMatchInfoButton);
	}

	private void setComponentsStyle() {
		point.setHorizontalAlignment(SwingConstants.CENTER);
		point.setFont(MyFont.LARGEST_BOLD);
		point.setForeground(MyColor.MIDDLE_COLOR);
		firstTeamMemberInfoButton.setContentAreaFilled(true);
		firstTeamMemberInfoButton.setBackground(MyColor.DEEP_COLOR);
		firstTeamMemberInfoButton.setForeground(MyColor.MY_WHITE);
		firstTeamMemberInfoButton.setFont(MyFont.SMALL_BOLD);
		secondTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		secondTeamMemberInfoButton.setForeground(MyColor.MY_WHITE);
		secondTeamMemberInfoButton.setFont(MyFont.SMALL_BOLD);
		secondTeamMemberInfoButton.setContentAreaFilled(true);
		teamMatchInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		teamMatchInfoButton.setForeground(MyColor.MY_WHITE);
		teamMatchInfoButton.setFont(MyFont.SMALL_BOLD);
		teamMatchInfoButton.setContentAreaFilled(true);
	}

	private void initTable() {
		firstTeamLogo.setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE +  "ATL.png"));
		secondTeamLogo.setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE +  "ATL.png"));
		point.setText("114 vs 155");
	}

	private void setTableStyle() {
		matchInfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	
	}
	class FirstTeamMemberInfoPanel extends MyPanel{
		private MyTable firstTeamInfoTable;
		private JScrollPane firstTeamPlayerInfo;
		private MyTableModel firstTeamInfoTableModel;
		private String performance[] = { "所属球队", "参赛场数", "在场时间", "效率值", "得分", "投篮命中率", "篮板", "助攻", "抢断", "盖帽", "两双次数", "三双次数", "失误", "犯规", "三分命中率",
		"罚球命中率" };
		private static final long serialVersionUID = 1L;
		public FirstTeamMemberInfoPanel(){
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.initTable();
			this.setTableStyle();
		}
		private void createObjects() {
			firstTeamInfoTableModel=new MyTableModel(performance);
			firstTeamInfoTable=new MyTable(firstTeamInfoTableModel);
			firstTeamPlayerInfo=new MyScrollPanel();
			firstTeamPlayerInfo.getViewport().add(firstTeamInfoTable);
		}
		private void setComponentsLocation() {
			firstTeamPlayerInfo.setBounds(0 , 0 ,  (int)(NUMBER.px*1000),  (int)(NUMBER.px*550));
			this.add(firstTeamPlayerInfo);
			
		}
		private void setComponentsStyle() {
			
		}
		private void initTable() {
			
		}
		private void setTableStyle() {
			
		}
		
	}
	class SecondTeamMemberInfoPanel extends MyPanel{
		private String performance[] = { "所属球队", "参赛场数", "在场时间", "效率值", "得分", "投篮命中率", "篮板", "助攻", "抢断", "盖帽", "两双次数", "三双次数", "失误", "犯规", "三分命中率",
		"罚球命中率" };
		private JScrollPane secondTeamPlayerInfo;
		private MyTable secondTeamInfoTable;
		private MyTableModel secondTeamInfoTableModel;
		private static final long serialVersionUID = 1L;
		public SecondTeamMemberInfoPanel(){
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.initTable();
			this.setTableStyle();
		}
		private void createObjects() {
			secondTeamInfoTableModel=new MyTableModel(performance);
			secondTeamInfoTable=new MyTable(secondTeamInfoTableModel);
			secondTeamPlayerInfo=new MyScrollPanel();
			secondTeamPlayerInfo.getViewport().add(secondTeamInfoTable);
		}
		private void setComponentsLocation() {
			secondTeamPlayerInfo.setBounds(0 , 0 ,  (int)(NUMBER.px*1000),  (int)(NUMBER.px*550));
			this.add(secondTeamPlayerInfo);
		}
		private void setComponentsStyle() {
			
		}
		private void initTable() {
			
		}
		private void setTableStyle() {
			
		}
		
	}
	class TeamInfoComparePanel extends MyPanel{

		private static final long serialVersionUID = 1L;
		
	}
	class ContentPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;
		private FirstTeamMemberInfoPanel firstTeamMemberInfoPanel;
		private SecondTeamMemberInfoPanel secondTeamMemberInfoPanel;
		private TeamInfoComparePanel teamInfoComparePanel;
		ContentPanel() {
			card = new CardLayout();
			this.setOpaque(false);
			this.setLayout(card);
			//
			firstTeamMemberInfoPanel = new FirstTeamMemberInfoPanel();
			secondTeamMemberInfoPanel = new SecondTeamMemberInfoPanel();
			teamInfoComparePanel=new TeamInfoComparePanel();
			//
			this.add(firstTeamMemberInfoPanel, "firstTeamMemberInfoPanel");
			this.add(secondTeamMemberInfoPanel, "secondTeamMemberInfoPanel");
			this.add(teamInfoComparePanel,"teamInfoComparePanel");
		}
	}
	public static void main(String args[]) {
		JFrame j = new JFrame();
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.setBackground(MyColor.BACKGROUNDCOLOR);
		j.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH,
				NUMBER.FRAME_HEIGHT);
		OneMatchPanel contentPanel = new OneMatchPanel();
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(firstTeamMemberInfoButton)) {
			contentPanel.card.show(contentPanel, "firstTeamMemberInfoPanel");
			firstTeamMemberInfoButton.setBackground(MyColor.DEEP_COLOR);
			secondTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			teamMatchInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(secondTeamMemberInfoButton)) {
			contentPanel.card.show(contentPanel, "secondTeamMemberInfoPanel");
			firstTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			secondTeamMemberInfoButton.setBackground(MyColor.DEEP_COLOR);
			teamMatchInfoButton.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(teamMatchInfoButton)) {
			contentPanel.card.show(contentPanel, "teamInfoComparePanel");
			firstTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			secondTeamMemberInfoButton.setBackground(MyColor.MIDDLE_COLOR);
			teamMatchInfoButton.setBackground(MyColor.DEEP_COLOR);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(firstTeamMemberInfoButton)) {
			firstTeamMemberInfoButton.setBorderPainted(true);
		}
		else if (e.getSource().equals(secondTeamMemberInfoButton)) {
			secondTeamMemberInfoButton.setBorderPainted(true);
		}
		else if (e.getSource().equals(teamMatchInfoButton)) {
			teamMatchInfoButton.setBorderPainted(true);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(firstTeamMemberInfoButton)) {
			firstTeamMemberInfoButton.setBorderPainted(false);
		}
		else if (e.getSource().equals(secondTeamMemberInfoButton)) {
			secondTeamMemberInfoButton.setBorderPainted(false);
		}
		else if (e.getSource().equals(teamMatchInfoButton)) {
			teamMatchInfoButton.setBorderPainted(false);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
