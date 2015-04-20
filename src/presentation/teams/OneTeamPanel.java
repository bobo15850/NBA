package presentation.teams;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mycomponent.MyTextArea;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;

public class OneTeamPanel extends MyPanel {

	private static final long serialVersionUID = 1L;
	private AllMatchInfoPanel matchPanel;
	private AllPlayerNormalInfoOfTeamPanel memberPanel;
	private GeneralInfoPanel generalInfoPanel;
	private JLabel teamMemberLabel;
	private JLabel machesLabel;
	private String PerformanceList[] = {"参赛场数", "先发场数", "在场时间","得分", "篮板", "助攻", 
			"抢断", "盖帽","进攻篮板", "防守篮板", "失误", "犯规", "投篮命中率", "三分命中率","罚球命中率"};
	//球队卡只展示普通数据，高级数据要点击球员卡看
	public OneTeamPanel(String teamName) {
		generalInfoPanel=new GeneralInfoPanel();
		matchPanel=new AllMatchInfoPanel();
		memberPanel=new AllPlayerNormalInfoOfTeamPanel();
		teamMemberLabel=new MyLabel("球队成员");
		machesLabel=new MyLabel("近期比赛");
		generalInfoPanel.setLocation(0,0);
		matchPanel.setLocation(0,(int)(NUMBER.px*280));
		memberPanel.setLocation(0,(int)(NUMBER.px*280));
		teamMemberLabel.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*230),(int)(NUMBER.px*660),(int)(NUMBER.px*50));
		machesLabel.setBounds((int)(NUMBER.px*710),(int)(NUMBER.px*230),(int)(NUMBER.px*670),(int)(NUMBER.px*50));
		this.add(generalInfoPanel);
		this.add(matchPanel);
//		this.add(memberPanel);
		this.add(teamMemberLabel);
		this.add(machesLabel);
		teamMemberLabel.setOpaque(true);
		machesLabel.setOpaque(true);
		teamMemberLabel.setBackground(MyColor.MIDDLE_COLOR);
		teamMemberLabel.setForeground(MyColor.MY_WHITE);
		teamMemberLabel.setFont(MyFont.SMALL_BOLD);
		teamMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		machesLabel.setBackground(MyColor.DEEP_COLOR);
		machesLabel.setForeground(MyColor.MY_WHITE);
		machesLabel.setFont(MyFont.SMALL_BOLD);
		machesLabel.setHorizontalAlignment(SwingConstants.CENTER);
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

	class AllPlayerNormalInfoOfTeamPanel extends MyPanel{
		private MyTable teamMemberTable;
		private MyTableModel teamMemberTableModel;
		private JScrollPane teamMemberShowPane;
		private static final long serialVersionUID = 1L;
		public AllPlayerNormalInfoOfTeamPanel(){
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
}
