package presentation.hotsport;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import test.data.PlayerHotInfo;
import businesslogic.hotsport.PlayerHotBl;
import businesslogicservice.hotsport.PlayerHotBlSrevice;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTextArea;
import common.statics.Field;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class MostImprovedPlayerPanel extends MyPanel implements MouseListener {

	//
	private String[] fieldString = new String[] { Field.point, Field.rebound, Field.assist, Field.steal, Field.blockShot };
	private final int labelHeight = (int) (NUMBER.px * 100);
	private final int buttonWidth = (int) (NUMBER.px * 260);
	private final int buttonHeight = (int) (NUMBER.px * 50);
	private MyButton[] fieldButton = new MyButton[5];// 属性按钮
	private MyLabel[] number = new MyLabel[5];// 排名
	private MyLabel[] Portrait = new MyLabel[5];// 头像
	private MyTextArea[] nameAndPosition = new MyTextArea[5];// 姓名和位置
	private MyLabel[] upgrade = new MyLabel[5];// 近五场提升率
	private MyLabel[] value = new MyLabel[5];// 属性值
	private MyLabel[] team = new MyLabel[5];// 球队
	private PlayerHotBlSrevice playerHotBl = new PlayerHotBl();
	private ArrayList<PlayerHotInfo> playerHotList = new ArrayList<PlayerHotInfo>(5);

	private static final long serialVersionUID = 1L;

	public MostImprovedPlayerPanel() {
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
			fieldButton[i] = new MyButton(fieldString[i]);
			number[i] = new MyLabel(String.valueOf(i + 1));
			upgrade[i] = new MyLabel();
			Portrait[i] = new MyLabel();
			nameAndPosition[i] = new MyTextArea();
			value[i] = new MyLabel();
			team[i] = new MyLabel();
		}
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i].setBounds((int) (buttonWidth * i+NUMBER.px*60), 0, buttonWidth, buttonHeight);
			this.add(fieldButton[i]);
		}
		Portrait[0].setBounds((int)(NUMBER.px*50), buttonHeight * 2, (int)(NUMBER.px*250),(int)(NUMBER.px*400) );
		number[0].setBounds((int)(NUMBER.px*300), labelHeight  + buttonHeight * 2,  (int)(NUMBER.px*100), (int)(NUMBER.px*100));
		nameAndPosition[0].setBounds((int)(NUMBER.px*400), labelHeight  + buttonHeight * 3, (int)(NUMBER.px*300), (int)(NUMBER.px*80));
		value[0].setBounds((int)(NUMBER.px*400), labelHeight  + buttonHeight * 3+ (int)(NUMBER.px*80), (int)(NUMBER.px*200), (int)(NUMBER.px*40));
		team[0].setBounds((int)(NUMBER.px*550),buttonHeight * 2 , (int)(NUMBER.px*80),(int)(NUMBER.px*80));
		upgrade[0].setBounds((int)(NUMBER.px*400), labelHeight  + buttonHeight * 3+2*(int)(NUMBER.px*80), (int)(NUMBER.px*200), (int)(NUMBER.px*80));
		for (int i = 1; i < 5; i++) {
			number[i].setBounds((int)(NUMBER.px*700),labelHeight * (i-1) + buttonHeight * 2,labelHeight, labelHeight);
			Portrait[i].setBounds((int)(NUMBER.px*830), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*15), (int)(NUMBER.px*70), (int)(NUMBER.px*70));
			nameAndPosition[i].setBounds((int)(NUMBER.px*920), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*40), (int)(NUMBER.px*120), (int)(NUMBER.px*60));
			value[i].setBounds((int)(NUMBER.px*1260), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*15), (int)(NUMBER.px*80), (int)(NUMBER.px*80));
			team[i].setBounds((int)(NUMBER.px*1160), labelHeight *(i-1) + buttonHeight * 2+(int)(NUMBER.px*20), (int)(NUMBER.px*60), (int)(NUMBER.px*60));
			upgrade[i].setBounds((int)(NUMBER.px*1070), labelHeight * (i-1) + buttonHeight * 2+(int)(NUMBER.px*15), (int)(NUMBER.px*60), (int)(NUMBER.px*80));
		}
		for (int i = 0; i < 5; i++) {
			this.add(number[i]);
			this.add(Portrait[i]);
			this.add(nameAndPosition[i]);
			this.add(value[i]);
			this.add(team[i]);
			this.add(upgrade[i]);
		}
	}

	private void setComponentsStyle() {
		number[0].setForeground(MyColor.MIDDLE_COLOR);
		number[0].setFont(new Font("微软雅黑",Font.BOLD,(int)(NUMBER.px*70)));
		nameAndPosition[0].setFont(MyFont.MIDDLE_PLAIN);
		value[0].setFont(MyFont.MIDDLE_PLAIN);
		upgrade[0].setFont(MyFont.MIDDLE_PLAIN);
		for (int i = 1; i < 5; i++) {
			number[i].setBackground(MyColor.MY_BULE);
			number[i].setOpaque(true);
			number[i].setHorizontalAlignment(SwingConstants.CENTER);
			value[i].setFont(MyFont.SMALL_BOLD);
			value[i].setForeground(MyColor.MIDDLE_COLOR);
			nameAndPosition[i].setFont(MyFont.SMALLEST_PLAIN);
		}
		for (int i = 0; i < 5; i++) {
			fieldButton[i].setContentAreaFilled(true);
			fieldButton[i].setBackground(MyColor.MIDDLE_COLOR);
		}
	}

	private void addListener() {
		for (int i = 0; i < 5; i++) {
			fieldButton[i].addMouseListener(this);
		}
	}

	private void init() {
		playerHotList = this.playerHotBl.getPlayerHot(5, fieldString[0]);
		this.setContent();
	}

	private void setContent() {
		for (int i = 0; i < 5; i++) {
			PlayerHotInfo temp = this.playerHotList.get(i);
			if(i==0){
				Portrait[i].setMyIcon(new ImageIcon(PathOfFile.PLAYER_ACTION_IMAGE + temp.getName() + ".png"));
			}
			else{
			Portrait[i].setMyIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + temp.getName() + ".png"));
			}
			nameAndPosition[i].setText(temp.getName()+"\n"+temp.getPosition());
			upgrade[i].setTextAndStyle(String.valueOf(temp.getUpgradeRate()));
			value[i].setTextAndStyle(String.valueOf(temp.getValue()));
			team[i].setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + temp.getTeamName() + ".png"));
		}
	}

	public void mouseClicked(MouseEvent e) {
		for (int i = 0; i < 5; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				this.playerHotList = this.playerHotBl.getPlayerHot(5, fieldString[i]);
				break;
			}
		}
		this.setContent();

	}

	public void mouseEntered(MouseEvent e) {
		for (int i = 0; i < 5; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				fieldButton[i].setBackground(MyColor.DEEP_COLOR);
				break;
			}
		}
	

	}

	public void mouseExited(MouseEvent e) {
		for (int i = 0; i < 5; i++) {
			if (e.getSource().equals(fieldButton[i])) {
				fieldButton[i].setBackground(MyColor.MIDDLE_COLOR);
				break;
			}
		}
	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
