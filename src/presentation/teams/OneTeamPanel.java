package presentation.teams;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mycomponent.MyTextArea;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class OneTeamPanel extends MyPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private AllMatchInfoPanel matchPanel;
	private PlayerNormalInfoPanel memberPanel;
	private GeneralInfoPanel generalInfoPanel;
	private MyButton teamMember;
	private MyButton matches;
	private ContentPanel contentPanel;
	private String PerformanceList[] = {"参赛场数", "先发场数", "在场时间","得分", "篮板", "助攻", 
			"抢断", "盖帽","进攻篮板", "防守篮板", "失误", "犯规", "投篮命中率", "三分命中率","罚球命中率"};
	//球队卡只展示普通数据，高级数据要点击球员卡看
	public OneTeamPanel(String teamName) {
		this.createObjects();
		this.setComponentsLocation();
		this.setCompStyle();
		this.addListener();
		this.setVisible(true);
	}

	private void createObjects() {
		generalInfoPanel=new GeneralInfoPanel();
		contentPanel=new ContentPanel();
		teamMember=new MyButton("球队成员");
		matches=new MyButton("近期比赛");
	}

	private void setComponentsLocation() {
		generalInfoPanel.setLocation(0,0);
		contentPanel.setLocation(0,(int)(NUMBER.px*280));
		teamMember.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*230),(int)(NUMBER.px*660),(int)(NUMBER.px*50));
		matches.setBounds((int)(NUMBER.px*710),(int)(NUMBER.px*230),(int)(NUMBER.px*670),(int)(NUMBER.px*50));
		this.add(generalInfoPanel);
		this.add(contentPanel);
		this.add(teamMember);
		this.add(matches);
	}

	private void setCompStyle() {
		teamMember.setContentAreaFilled(true);
		matches.setContentAreaFilled(true);
		teamMember.setBackground(MyColor.MIDDLE_COLOR);
		teamMember.setForeground(MyColor.MY_WHITE);
		teamMember.setFont(MyFont.SMALL_BOLD);
		matches.setBackground(MyColor.DEEP_COLOR);
		matches.setForeground(MyColor.MY_WHITE);
		matches.setFont(MyFont.SMALL_BOLD);
	}

	private void addListener() {
		matches.addMouseListener(this);
		teamMember.addMouseListener(this);
	}

	class GeneralInfoPanel extends MyPanel{
		private static final long serialVersionUID = 1L;
		private MyLabel logo;
		private JTextArea teamNameText;
		private JTextArea normalInfoText;
		private JTextArea mainMatchInfoText;
		public GeneralInfoPanel(){
			this.setSize(NUMBER.FRAME_WIDTH,(int)(NUMBER.px*230));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.setTableStyle();
		}
		private void createObjects() {
			logo=new MyLabel();
			teamNameText=new MyTextArea();
			normalInfoText=new MyTextArea();
			mainMatchInfoText=new MyTextArea();
		}
		private void setComponentsLocation() {
			logo.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*10) , (int)(NUMBER.px*220), (int)(NUMBER.px*220));
			teamNameText.setBounds((int)(NUMBER.px*450),(int)(NUMBER.px*10) , (int)(NUMBER.px*140), (int)(NUMBER.px*100));
			normalInfoText.setBounds((int)(NUMBER.px*900),(int)(NUMBER.px*40) , (int)(NUMBER.px*400), (int)(NUMBER.px*180));
			mainMatchInfoText.setBounds((int)(NUMBER.px*450),(int)(NUMBER.px*150) ,(int)(NUMBER.px*400), (int)(NUMBER.px*60));
			this.add(logo);
			this.add(teamNameText);
			this.add(normalInfoText);
			this.add(mainMatchInfoText);
		}
		private void setComponentsStyle() {
			logo.setMyIcon(new ImageIcon("images/teams/logo/MIA0.png"));
			teamNameText.setText("MIA\n迈阿密热火");
			teamNameText.setFont(MyFont.MIDDLE_BOLD);
			mainMatchInfoText.setText("得分    篮板    助攻\n101.5  51.2  27.1");
			mainMatchInfoText.setFont(MyFont.SMALL_PLAIN);
			normalInfoText.setText("所在地：\n所属联盟：\n所属分区：\n主场：\n建队时间：");
			normalInfoText.setFont(MyFont.SMALL_PLAIN);
		}
		private void setTableStyle() {
			
		}
	}

	class PlayerNormalInfoPanel extends MyPanel{
		private MyTable teamMemberTable;
		private MyTableModel teamMemberTableModel;
		private JScrollPane teamMemberShowPane;
		private static final long serialVersionUID = 1L;
		public PlayerNormalInfoPanel(){
			this.setSize(NUMBER.FRAME_WIDTH,(int)(NUMBER.px*400));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.setTableStyle();
		}
		private void createObjects() {
			teamMemberTableModel=new MyTableModel(PerformanceList);
			teamMemberTable=new MyTable(teamMemberTableModel);
			teamMemberShowPane=new JScrollPane();
			teamMemberShowPane.getViewport().add(teamMemberTable);
		}
		private void setComponentsLocation() {
			teamMemberShowPane.setBounds((int)(NUMBER.px*50),0,NUMBER.FRAME_WIDTH-(int)(NUMBER.px*100), (int)(NUMBER.px*500));
			this.add(teamMemberShowPane);
		}
		private void setComponentsStyle() {
		
		}
		private void setTableStyle() {
			
		}

	}

	class AllMatchInfoPanel extends MyPanel{
		private JScrollPane matchesShowPane;
		private MatchLabel matchLabel,matchLabel2;
		private static final long serialVersionUID = 1L;
		public AllMatchInfoPanel(){
			this.setSize(NUMBER.FRAME_WIDTH,(int)(NUMBER.px*400));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
		}
		private void createObjects() {
			matchLabel=new MatchLabel("","",0,0);
			matchLabel2=new MatchLabel("","",0,0);
			matchesShowPane=new JScrollPane();
			matchesShowPane.getViewport().setLayout(null);
		}
		private void setComponentsLocation() {
			matchesShowPane.setBounds((int)(NUMBER.px*50),0,NUMBER.FRAME_WIDTH-(int)(NUMBER.px*100), (int)(NUMBER.px*400));
			matchLabel.setLocation(0, 0);
			matchLabel2.setLocation(0, (int)(NUMBER.px*50));
			matchesShowPane.getViewport().add(matchLabel);
			matchesShowPane.getViewport().add(matchLabel2);
			this.add(matchesShowPane);
		}
		private void setComponentsStyle() {
			
		}
	}
	class MatchLabel extends JLabel{
		private MyLabel homeTeamLogo,secondTeamLogo;
		private JLabel matchPoint;
		private static final long serialVersionUID = 1L;
		public MatchLabel(String firstTeamName,String SecondTeamName,int firstTeamPoint,int secondTeamPoint){
			this.setOpaque(true);
			this.setBackground(MyColor.DEEP_COLOR);
			this.setSize(NUMBER.FRAME_WIDTH-(int)(NUMBER.px*100), (int)(NUMBER.px*70));
			homeTeamLogo=new MyLabel();
			secondTeamLogo=new MyLabel();
			matchPoint=new JLabel();
			homeTeamLogo.setBounds((int)(NUMBER.px*350),(int)(NUMBER.px*5),(int)(NUMBER.px*90),(int)(NUMBER.px*60));
			secondTeamLogo.setBounds((int)(NUMBER.px*900),(int)(NUMBER.px*5),(int)(NUMBER.px*90),(int)(NUMBER.px*60));
			matchPoint.setBounds((int)(NUMBER.px*510),(int)(NUMBER.px*5),(int)(NUMBER.px*300),(int)(NUMBER.px*60));
			this.add(homeTeamLogo);
			this.add(secondTeamLogo);
			this.add(matchPoint);
			homeTeamLogo.setIcon(new ImageIcon("images/teams/logo/ATL00.png"));
			secondTeamLogo.setIcon(new ImageIcon("images/teams/logo/ATL00.png"));
			matchPoint.setText("114  -  121");
			matchPoint.setFont(MyFont.LARGEST_BOLD);
			matchPoint.setHorizontalAlignment(SwingConstants.CENTER);
			matchPoint.setForeground(MyColor.MY_WHITE);
		}
	}
	class ContentPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;
		private AllMatchInfoPanel matchPanel;
		private PlayerNormalInfoPanel normalInfoPanel;

		ContentPanel() {
			card = new CardLayout();
			this.setOpaque(false);
			this.setLayout(card);
			//
			matchPanel = new AllMatchInfoPanel();
			normalInfoPanel = new PlayerNormalInfoPanel();
			//
			this.add(matchPanel, "matchPanel");
			this.add(normalInfoPanel, "normalInfoPanel");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(teamMember)) {
			contentPanel.card.show(contentPanel, "normalInfoPanel");
			teamMember.setBackground(MyColor.DEEP_COLOR);
			matches.setBackground(MyColor.MIDDLE_COLOR);
		}
		
		else if (e.getSource().equals(matches)) {
			contentPanel.card.show(contentPanel, "matchPanel");
			teamMember.setBackground(MyColor.MIDDLE_COLOR);
			matches.setBackground(MyColor.DEEP_COLOR);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(teamMember)) {
			teamMember.setBorderPainted(true);
		}
		
		else if (e.getSource().equals(matches)) {
			matches.setBorderPainted(true);
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(teamMember)) {
			teamMember.setBorderPainted(false);
		}
		else if (e.getSource().equals(matches)) {
			matches.setBorderPainted(false);
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
	public static void main(String args[]) {
		JFrame j = new JFrame();
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.setBackground(MyColor.BACKGROUNDCOLOR);
		j.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH,
				NUMBER.FRAME_HEIGHT);
		OneTeamPanel contentPanel = new OneTeamPanel("");
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);
	}
}
