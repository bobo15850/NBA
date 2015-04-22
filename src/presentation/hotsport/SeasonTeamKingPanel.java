package presentation.hotsport;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import test.data.TeamHotInfo;
import businesslogic.hotsport.TeamHotBl;
import businesslogicservice.hotsport.TeamHotBlService;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.statics.Field;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class SeasonTeamKingPanel extends MyPanel implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyButton[] fieldButton = new MyButton[8];// 属性按钮
	private String[] fieldString = new String[] { Field.point, Field.rebound, Field.assist, Field.steal, Field.blockShot, Field.shot, Field.three,
			Field.penalty };
	private final int labelHeight = (int) (NUMBER.px * 100);
	private final int buttonWidth = (int) (NUMBER.px * 165);
	private final int buttonHeight = (int) (NUMBER.px * 50);
	private MyLabel[] number = new MyLabel[5];// 序号
	private MyLabel[] logo = new MyLabel[5];// 队标
	private MyLabel[] team = new MyLabel[5];// 球队名称
	private MyLabel[] value = new MyLabel[5];// 属性值
	private MyLabel[] league = new MyLabel[5];// 联盟
	private TeamHotBlService teamHotBl = new TeamHotBl();
	private ArrayList<TeamHotInfo> teamHotInfo = new ArrayList<TeamHotInfo>(5);

	public SeasonTeamKingPanel() {
		this.setLayout(null);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
		this.setVisible(true);
		this.init();
	}

	private void createObjects() {
		for (int i = 0; i < 5; i++) {
			number[i] = new MyLabel(String.valueOf(i + 1));
			logo[i] = new MyLabel();
			team[i] = new MyLabel();
			value[i] = new MyLabel();
			league[i] = new MyLabel();
		}
		for (int i = 0; i < 8; i++) {
			fieldButton[i] = new MyButton(fieldString[i]);
		}
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 8; i++) {
			fieldButton[i].setBounds((int) (buttonWidth * i+NUMBER.px*60), 0, buttonWidth, buttonHeight);
			this.add(fieldButton[i]);
		}
		logo[0].setBounds((int)(NUMBER.px*50), buttonHeight * 2, (int)(NUMBER.px*300),(int)(NUMBER.px*300) );
		number[0].setBounds((int)(NUMBER.px*400), (int)(NUMBER.px*100),  (int)(NUMBER.px*100), (int)(NUMBER.px*100));
		team[0].setBounds((int)(NUMBER.px*400), labelHeight  + buttonHeight * 3, (int)(NUMBER.px*300), (int)(NUMBER.px*40));
		league[0].setBounds((int)(NUMBER.px*400), labelHeight  + buttonHeight * 3+ (int)(NUMBER.px*40), (int)(NUMBER.px*200), (int)(NUMBER.px*40));
		value[0].setBounds((int)(NUMBER.px*400), labelHeight  + buttonHeight * 3+2*(int)(NUMBER.px*40), (int)(NUMBER.px*200), (int)(NUMBER.px*40));
		
		for (int i = 1; i < 5; i++) {
			number[i].setBounds((int)(NUMBER.px*700),labelHeight * (i-1) + buttonHeight * 2,labelHeight, labelHeight);
			logo[i].setBounds((int)(NUMBER.px*830), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*15), (int)(NUMBER.px*70), (int)(NUMBER.px*70));
			team[i].setBounds((int)(NUMBER.px*950), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*15), (int)(NUMBER.px*120), (int)(NUMBER.px*80));
			league[i].setBounds((int)(NUMBER.px*1070), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*15), (int)(NUMBER.px*60), (int)(NUMBER.px*80));
			value[i].setBounds((int)(NUMBER.px*1160), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*15), (int)(NUMBER.px*180), (int)(NUMBER.px*80));
		}
		for (int i = 0; i < 5; i++) {
			this.add(number[i]);
			this.add(logo[i]);
			this.add(team[i]);
			this.add(league[i]);
			this.add(value[i]);
		}
	}

	private void setComponentsStyle() {
		number[0].setForeground(MyColor.MIDDLE_COLOR);
		number[0].setFont(new Font("微软雅黑",Font.BOLD,(int)(NUMBER.px*70)));
		team[0].setFont(MyFont.MIDDLE_PLAIN);
		league[0].setFont(MyFont.MIDDLE_PLAIN);
		value[0].setFont(MyFont.MIDDLE_PLAIN);

		for (int i = 1; i < 5; i++) {
			number[i].setBackground(MyColor.MY_BULE);
			number[i].setOpaque(true);
			number[i].setHorizontalAlignment(SwingConstants.CENTER);
			value[i].setFont(MyFont.SMALL_BOLD);
			value[i].setForeground(MyColor.MIDDLE_COLOR);
		}

		for (int i = 0; i < 8; i++) {
			fieldButton[i].setContentAreaFilled(true);
			fieldButton[i].setBackground(MyColor.MIDDLE_COLOR);
		}
	
	}

	private void addListener() {
		for (int i = 0; i < 8; i++) {
			fieldButton[i].addMouseListener(this);
		}

	}

	private void init() {
		this.teamHotInfo = this.teamHotBl.getTeamHot(5, fieldString[0]);
		this.setContent();
	}

	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 8; i++) {
			fieldButton[i].setBackground(MyColor.MIDDLE_COLOR);
		}
		for (int i = 0; i < 8; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				fieldButton[i].setBackground(MyColor.DEEP_COLOR);
				this.teamHotInfo = this.teamHotBl.getTeamHot(5, fieldString[i]);
				break;
			}
		}
		this.setContent();
	}

	private void setContent() {
		for (int i = 0; i < 5; i++) {
			TeamHotInfo temp = this.teamHotInfo.get(i);
			logo[i].setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + temp.getTeamName() + ".png"));
			team[i].setTextAndStyle(temp.getTeamName());
			value[i].setTextAndStyle(String.valueOf(temp.getValue()));
			league[i].setTextAndStyle(temp.getLeague());
		}
	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 8; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				fieldButton[i].setBorderPainted(true);
				break;
			}
		}
	}

	public void mouseExited(MouseEvent e) {
		
		for (int i = 0; i < 8; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				fieldButton[i].setBorderPainted(false);
				break;
			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
