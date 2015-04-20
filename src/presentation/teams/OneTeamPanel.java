package presentation.teams;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import common.mycomponent.MyPanel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
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
		teamMemberLabel=new JLabel();
		machesLabel=new JLabel();
		generalInfoPanel.setLocation(0,0);
		matchPanel.setLocation(0,(int)(NUMBER.px*300));
		memberPanel.setLocation(0,(int)(NUMBER.px*300));
	}

	class GeneralInfoPanel extends MyPanel{
		private static final long serialVersionUID = 1L;
		private JLabel logo;
		private JTextArea teamNameText;
		private JTextArea normalInfoText;
		private JTextArea mainMatchInfoText;
		public GeneralInfoPanel(){
			this.setSize(NUMBER.FRAME_WIDTH,(int)(NUMBER.px*250));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.setTableStyle();
		}
		private void createObjects() {
			logo=new JLabel();
			teamNameText=new JTextArea();
			normalInfoText=new JTextArea();
			mainMatchInfoText=new JTextArea();
		}
		private void setComponentsLocation() {
			logo.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*10) , (int)(NUMBER.px*220), (int)(NUMBER.px*220));
			teamNameText.setBounds((int)(NUMBER.px*450),(int)(NUMBER.px*10) , (int)(NUMBER.px*140), (int)(NUMBER.px*100));
			normalInfoText.setBounds((int)(NUMBER.px*600),(int)(NUMBER.px*10) , (int)(NUMBER.px*300), (int)(NUMBER.px*220));
			mainMatchInfoText.setBounds((int)(NUMBER.px*450),(int)(NUMBER.px*150) ,(int)(NUMBER.px*400), (int)(NUMBER.px*100));
			this.add(logo);
			this.add(teamNameText);
			this.add(normalInfoText);
			this.add(mainMatchInfoText);
		}
		private void setComponentsStyle() {
			
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
			this.setSize(NUMBER.FRAME_WIDTH,NUMBER.FRAME_HEIGHT-(int)(NUMBER.px*300));
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
			teamMemberShowPane.setBounds(0,0,NUMBER.FRAME_WIDTH, (int)(NUMBER.px*500));
			this.add(teamMemberShowPane);
		}
		private void setComponentsStyle() {
		
		}
		private void setTableStyle() {
			
		}

	}

	class AllMatchInfoPanel extends MyPanel{
		private JScrollPane matchesShowPane;
		private static final long serialVersionUID = 1L;
		public AllMatchInfoPanel(){
			this.setSize(NUMBER.FRAME_WIDTH,NUMBER.FRAME_HEIGHT-(int)(NUMBER.px*300));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
		}
		private void createObjects() {
			matchesShowPane=new JScrollPane();
		}
		private void setComponentsLocation() {
			matchesShowPane.setBounds(0,0,NUMBER.FRAME_WIDTH, (int)(NUMBER.px*500));
			this.add(matchesShowPane);
		}
		private void setComponentsStyle() {
			
		}
	}

}
