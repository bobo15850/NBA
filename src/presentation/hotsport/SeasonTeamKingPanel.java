package presentation.hotsport;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import test.data.TeamHotInfo;
import businesslogic.hotsport.TeamHotBl;
import businesslogicservice.hotsport.TeamHotBlService;

import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.statics.Field;
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
	private final int labelWidth = (int) (NUMBER.px * 200);
	private final int labelHeight = (int) (NUMBER.px * 100);
	private final int buttonWidth = (int) (NUMBER.px * 160);
	private final int buttonHeight = (int) (NUMBER.px * 40);
	private MyLabel[] number = new MyLabel[5];// 序号
	private MyLabel[] logo = new MyLabel[5];// 队标
	private MyLabel[] team = new MyLabel[5];// 球队名称
	private MyLabel[] value = new MyLabel[5];// 属性值
	private MyLabel[] league = new MyLabel[5];// 联盟
	private String[] content = new String[] { "排名", "队标", "队名", "属性值", "联盟" };
	private MyLabel[] contentLable = new MyLabel[5];
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
			logo[i] = new MyLabel("队标");
			team[i] = new MyLabel("球队名");
			value[i] = new MyLabel("具体值");
			league[i] = new MyLabel("联盟");
			contentLable[i] = new MyLabel(content[i]);
		}
		for (int i = 0; i < 8; i++) {
			fieldButton[i] = new MyButton(fieldString[i]);
		}
	}

	private void setComponentsLocation() {
		for (int i = 0; i < 8; i++) {
			fieldButton[i].setBounds((int) (buttonWidth * (i + 0.5)), 0, buttonWidth, buttonHeight);
			this.add(fieldButton[i]);
		}
		for (int i = 0; i < 5; i++) {
			contentLable[i].setBounds(labelWidth * (i + 1), buttonHeight * 2, labelWidth, (int) (labelHeight * 0.5));
			this.add(contentLable[i]);
			number[i].setBounds(labelWidth, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			logo[i].setBounds(labelWidth * 2, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			team[i].setBounds(labelWidth * 3, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			value[i].setBounds(labelWidth * 4, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			league[i].setBounds(labelWidth * 5, labelHeight * i + buttonHeight * 2, labelWidth, labelHeight);
			this.add(number[i]);
			this.add(logo[i]);
			this.add(team[i]);
			this.add(value[i]);
			this.add(league[i]);
		}
	}

	private void setComponentsStyle() {

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
			if (e.getSource().equals(fieldButton[i])) {
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

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
