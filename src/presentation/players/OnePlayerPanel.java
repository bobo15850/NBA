package presentation.players;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import presentation.teams.OneTeamPanel;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mycomponent.MyPanel;
import common.mycomponent.MyTextArea;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.PathOfFile;

public class OnePlayerPanel extends MyPanel implements MouseListener{
	
	private GeneralInfoPanel generalInfoPanel;
	private MyButton normalInfo;
	private MyButton highInfo;
	private MyButton matches;
	private ContentPanel contentPanel;
	private int label_height=(int)(NUMBER.px*50);
	private int label_width=(int)(NUMBER.px*400);
	private static final long serialVersionUID = 1L;

	public OnePlayerPanel(String playerName) {
		this.createObjects();
		this.setComponentsLocation();
		this.setCompStyle();
		this.addListener();
		this.setVisible(true);
	}

	private void createObjects() {
		generalInfoPanel=new GeneralInfoPanel();
		contentPanel=new ContentPanel();
		highInfo=new MyButton("高级数据");
		matches=new MyButton("近期比赛");
		normalInfo=new MyButton("普通数据");
	}

	private void setComponentsLocation() {
		generalInfoPanel.setLocation(0,0);
		contentPanel.setLocation(0,(int)(NUMBER.px*280));
		
		normalInfo.setBounds((int)(NUMBER.px*50),(int)(NUMBER.px*230),label_width,label_height);
		highInfo.setBounds((int)(NUMBER.px*50)+label_width,(int)(NUMBER.px*230),label_width,label_height);
		matches.setBounds((int)(NUMBER.px*50)+2*label_width,(int)(NUMBER.px*230),label_width,label_height);
		
		this.add(generalInfoPanel);
		this.add(contentPanel);
		this.add(highInfo);
		this.add(matches);
		this.add(normalInfo);
	}
	private void setCompStyle(){
		highInfo.setContentAreaFilled(true);
		highInfo.setBackground(MyColor.MIDDLE_COLOR);
		highInfo.setForeground(MyColor.MY_WHITE);
		highInfo.setFont(MyFont.SMALL_BOLD);
		matches.setBackground(MyColor.MIDDLE_COLOR);
		matches.setForeground(MyColor.MY_WHITE);
		matches.setFont(MyFont.SMALL_BOLD);
		matches.setContentAreaFilled(true);
		normalInfo.setBackground(MyColor.DEEP_COLOR);
		normalInfo.setForeground(MyColor.MY_WHITE);
		normalInfo.setFont(MyFont.SMALL_BOLD);
		normalInfo.setContentAreaFilled(true);
	}
	private void addListener() {
		normalInfo.addMouseListener(this);
		highInfo.addMouseListener(this);
		matches.addMouseListener(this);
	}

	class GeneralInfoPanel extends MyPanel{
		private static final long serialVersionUID = 1L;
		private MyLabel portrait;
		private JTextArea playerNameText;
		private JTextArea normalInfoText;
		private JTextArea mainMatchInfoText;
		private MyLabel teamLogo;
		public GeneralInfoPanel(){
			this.setSize(NUMBER.FRAME_WIDTH,(int)(NUMBER.px*230));
			this.createObjects();
			this.setComponentsLocation();
			this.setComponentsStyle();
			this.setContents();
			this.addListener();
		}
		private void addListener() {
			
		}
		private void createObjects() {
			portrait=new MyLabel();
			playerNameText=new MyTextArea();
			normalInfoText=new MyTextArea();
			mainMatchInfoText=new MyTextArea();
			teamLogo=new MyLabel();
		}
		private void setComponentsLocation() {
			teamLogo.setBounds((int)(NUMBER.px*1000),(int)(NUMBER.px*10) , (int)(NUMBER.px*150), (int)(NUMBER.px*100));
			portrait.setBounds((int)(NUMBER.px*70),(int)(NUMBER.px*10) , (int)(NUMBER.px*260), (int)(NUMBER.px*220));
			playerNameText.setBounds((int)(NUMBER.px*400),(int)(NUMBER.px*10) , (int)(NUMBER.px*140), (int)(NUMBER.px*100));
			normalInfoText.setBounds((int)(NUMBER.px*700),(int)(NUMBER.px*10) , (int)(NUMBER.px*400), (int)(NUMBER.px*240));
			mainMatchInfoText.setBounds((int)(NUMBER.px*400),(int)(NUMBER.px*150) ,(int)(NUMBER.px*400), (int)(NUMBER.px*60));
			this.add(portrait);
			this.add(playerNameText);
			this.add(normalInfoText);
			this.add(mainMatchInfoText);
			this.add(teamLogo);
		}
		private void setComponentsStyle() {
			playerNameText.setFont(MyFont.MIDDLE_BOLD);
			mainMatchInfoText.setFont(MyFont.SMALL_PLAIN);
			normalInfoText.setFont(MyFont.SMALL_PLAIN);
		}
		private void setContents() {
			portrait.setMyIcon(new ImageIcon(PathOfFile.PLAYER_PORTRAIT_IMAGE + "Kobe Bryant" + ".png"));
			playerNameText.setText("Kobe\nBryant");
			mainMatchInfoText.setText("得分    篮板    助攻\n101.5  51.2  27.1");
			normalInfoText.setText("号码：\n位置：\n身高：\n体重：\n生日：\n年龄：\n经验：\n毕业院校：");
			teamLogo.setMyIcon(new ImageIcon(PathOfFile.TEAM_LOGO_IMAGE + "LAL" + ".png"));
		}
	}

	class PlayerNormalInfoPanel extends MyPanel{
		private static final long serialVersionUID = 1L;

	}

	class PlayerHighInfoPanel extends MyPanel{

		private static final long serialVersionUID = 1L;

	}

	class AllMatchInfoPanel extends JPanel{
		
		private static final long serialVersionUID = 1L;

	}
	class ContentPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private CardLayout card;
		private AllMatchInfoPanel matchPanel;
		private PlayerNormalInfoPanel normalInfoPanel;
		private PlayerHighInfoPanel highInfoPanel;

		ContentPanel() {
			card = new CardLayout();
			this.setOpaque(false);
			this.setLayout(card);
			//
			matchPanel = new AllMatchInfoPanel();
			normalInfoPanel = new PlayerNormalInfoPanel();
			highInfoPanel = new PlayerHighInfoPanel();
			//
			this.add(matchPanel, "matchPanel");
			this.add(normalInfoPanel, "normalInfoPanel");
			this.add(highInfoPanel, "highInfoPanel");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(normalInfo)) {
			contentPanel.card.show(contentPanel, "normalInfoPanel");
			normalInfo.setBackground(MyColor.DEEP_COLOR);
			highInfo.setBackground(MyColor.MIDDLE_COLOR);
			matches.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(highInfo)) {
			contentPanel.card.show(contentPanel, "highInfoPanel");
			normalInfo.setBackground(MyColor.MIDDLE_COLOR);
			highInfo.setBackground(MyColor.DEEP_COLOR);
			matches.setBackground(MyColor.MIDDLE_COLOR);
		}
		else if (e.getSource().equals(matches)) {
			contentPanel.card.show(contentPanel, "matchPanel");
			normalInfo.setBackground(MyColor.MIDDLE_COLOR);
			highInfo.setBackground(MyColor.MIDDLE_COLOR);
			matches.setBackground(MyColor.DEEP_COLOR);
		}
	}
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(normalInfo)) {
			normalInfo.setBorderPainted(true);
		}
		else if (e.getSource().equals(highInfo)) {
			highInfo.setBorderPainted(true);
		}
		else if (e.getSource().equals(matches)) {
			matches.setBorderPainted(true);
		}
	}

	
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(normalInfo)) {
			normalInfo.setBorderPainted(false);
		}
		else if (e.getSource().equals(highInfo)) {
			highInfo.setBorderPainted(false);
		}
		else if (e.getSource().equals(matches)) {
			matches.setBorderPainted(false);
		}
	}

	
	public void mousePressed(MouseEvent e) {
		
	}

	
	public void mouseReleased(MouseEvent e) {
	
	}
	public static void main(String args[]) {
		JFrame j = new JFrame();
		j.setUndecorated(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLayout(null);
		j.setBackground(MyColor.BACKGROUNDCOLOR);
		j.setBounds((NUMBER.SCREEN_WIDTH - NUMBER.FRAME_WIDTH) / 2, (NUMBER.SCREEN_HEIGHT - NUMBER.FRAME_HEIGHT) / 2 - 20, NUMBER.FRAME_WIDTH,
				NUMBER.FRAME_HEIGHT);
		OnePlayerPanel contentPanel = new OnePlayerPanel("");
		contentPanel.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT, NUMBER.FRAME_WIDTH, NUMBER.FRAME_HEIGHT - NUMBER.NAVIGATION_PANEL_HEIGHT);
		j.add(contentPanel);
		j.setVisible(true);
	}
}
