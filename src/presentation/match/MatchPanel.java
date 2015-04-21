package presentation.match;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import businesslogic.matches.MatchInfoBl;
import businesslogicservice.matches.MatchInfoBlService;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.mydatastructure.GeneralInfoOfOneMatch;
import common.statics.MyColor;
import common.statics.NUMBER;

public class MatchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String TEAM_LOGO_PATH="NBA/images/teams/logo/";
	JPanel datePanel;
	JPanel matchPanel;
	JPanel matchInfoPanel;
	MyLabel dateLabel;
	CalendarDialog calendarDialog;
//	JPanel calendarDialog;
	JPanel dateSelectPanel;
	JPanel thisDatePanel;
	MyLabel thisDateLabel;
	MyLabel eachMatchLabel;
	MyButton switchToLastDay;
	MyButton switchToNextDay;
	static int percent=14;
	int numOfMatch;
	MatchInfoBlService matchInfoBl=new MatchInfoBl();
	ArrayList<GeneralInfoOfOneMatch> matchInfoList=new ArrayList<GeneralInfoOfOneMatch>();
	public  MatchPanel() {
		getLatestData();
		
		createObjects();
		setComponentPosition();
		setComponentStyle();
					
		
		datePanel.add(dateLabel);
		datePanel.add(dateSelectPanel);
		thisDatePanel.add(thisDateLabel);
		matchPanel.add(thisDatePanel);
		matchPanel.add(matchInfoPanel);
		
		this.add(datePanel);
		this.add(matchPanel);
//		matchPanel.add(switchToLastDay);
//		matchPanel.add(switchToNextDay);
		JLabel test=new JLabel("1");
		matchInfoPanel.add(test);
//		initMatchInfo();
	}

	
	
	
	private void createObjects(){
		datePanel=new JPanel();
		
		matchPanel=new JPanel();
		
		dateLabel=new MyLabel("日期");
		
		dateSelectPanel=new JPanel();	
		
		thisDatePanel=new JPanel();
		
		GeneralInfoOfOneMatch lastestMatch=matchInfoList.get(0);
		thisDateLabel=new MyLabel(getWeek(lastestMatch.getDate().getYear(),lastestMatch.getDate().getMonth(),lastestMatch.getDate().getDay()));
	
		matchInfoPanel=new JPanel();
		switchToLastDay=new MyButton("昨天");
		switchToNextDay=new MyButton("明天");
		
	}
		
	private void setComponentPosition(){
		this.setBounds(0, NUMBER.NAVIGATION_PANEL_HEIGHT,  NUMBER.FRAME_WIDTH, (NUMBER.FRAME_HEIGHT-NUMBER.NAVIGATION_PANEL_HEIGHT));
		
		datePanel.setBounds( NUMBER.FRAME_WIDTH/percent, 0,  
							NUMBER.FRAME_WIDTH*(percent-2)/percent, ( NUMBER.FRAME_HEIGHT-NUMBER.NAVIGATION_PANEL_HEIGHT) /percent);
		
		dateLabel.setBounds(datePanel.getWidth()/6,  datePanel.getHeight()/4,
							NUMBER.FRAME_WIDTH*(percent-2)/percent/8,  ( NUMBER.FRAME_HEIGHT-NUMBER.NAVIGATION_PANEL_HEIGHT) /percent/2);

		dateSelectPanel.setBounds(dateLabel.getX()+dateLabel.getWidth(), datePanel.getHeight()/4, 
				NUMBER.FRAME_WIDTH*(percent-2)/percent/7, (NUMBER.FRAME_HEIGHT-NUMBER.NAVIGATION_PANEL_HEIGHT) /percent/2);

		matchPanel.setBounds(datePanel.getX(), datePanel.getHeight(), datePanel.getWidth(),( this.getHeight()-datePanel.getHeight())*(percent-2)/percent);
		thisDatePanel.setBounds(0,0,matchPanel.getWidth(),matchPanel.getHeight()/percent);
		thisDateLabel.setBounds(0,0, thisDatePanel.getWidth(), thisDatePanel.getHeight());
		
		matchInfoPanel.setBounds(0, thisDatePanel.getHeight(), thisDatePanel.getWidth(), (matchPanel.getHeight()-thisDatePanel.getHeight()));
//		switchToLastDay.setBounds(0, thisDateLabel.getHeight(), this.getWidth()/percent, this.getHeight());

//		switchToNextDay.setBounds(this.getWidth()*(percent-1)/percent, thisDateLabel.getHeight(), this.getWidth()/percent, this.getHeight());

	}
	
	private void setComponentStyle(){
		this.setBackground(MyColor.MIDDLE_COLOR);
		this.setLayout(null);
		this.setOpaque(true);
		this.setVisible(true);
		
		datePanel.setBackground(MyColor.MIDDLE_COLOR);
		datePanel.setLayout(null);
		datePanel.setOpaque(true);
		datePanel.setVisible(true);
		
		dateLabel.setBackground(MyColor.MY_ORIANGE);
		dateLabel.setForeground(MyColor.MY_WHITE);
		dateLabel.setOpaque(false);	
		
		dateSelectPanel.setLayout(null);
		dateSelectPanel.setOpaque(true);
		dateSelectPanel.setVisible(true);
		
		matchPanel.setBackground(MyColor.DEEP_COLOR);
		matchPanel.setLayout(null);
		matchPanel.setOpaque(true);
		matchPanel.setVisible(true);
		
		thisDatePanel.setBackground(MyColor.MIDDLE_COLOR);
		thisDatePanel.setLayout(null);
		thisDatePanel.setOpaque(true);
		thisDatePanel.setVisible(true);
		
		thisDateLabel.setBackground(MyColor.MIDDLE_COLOR);
		thisDateLabel.setForeground(MyColor.MY_WHITE);
		thisDateLabel.setOpaque(true);	
		thisDateLabel.setVisible(true);
		
		matchInfoPanel.setLayout(new GridLayout(5,3,5,3));
//		matchInfoPanel.setLayout(null);
		matchInfoPanel.setBackground(MyColor.DEEP_COLOR);
		matchInfoPanel.setOpaque(true);
		matchInfoPanel.setVisible(true);
	/*	
		switchToLastDay.setVisible(true);
		switchToLastDay.setBackground(MyColor.LIGHT_COLOR);
		switchToLastDay.setOpaque(true);
		
		switchToNextDay.setVisible(true);
		switchToNextDay.setBackground(MyColor.LIGHT_COLOR);
		switchToNextDay.setOpaque(true);
		*/
	}
	
	private void addListener(){
		
	}
	
	void initMatchInfo(){
		numOfMatch=matchInfoList.size();
		
		for(int i=0;i<numOfMatch;i++){
			String firstTeamName=matchInfoList.get(i).getFirstTeamName();
			String secondTeamName=matchInfoList.get(i).getSecondTeamName();
			int firstTeamScore=matchInfoList.get(i).getFirstTeamScore();
			int secondTeamScore=matchInfoList.get(i).getSecondTeamScore();
			
			ImageIcon firstImage=new ImageIcon(TEAM_LOGO_PATH+firstTeamName+".png");
			ImageIcon secondImage=new ImageIcon(TEAM_LOGO_PATH+secondTeamName+".png");
			String score=String.valueOf(firstTeamScore)+" VS "+String.valueOf(secondTeamScore);
			
			eachMatchLabel=new MyLabel();
			eachMatchLabel.setLayout(new GridLayout(1,3));
			eachMatchLabel.setVisible(true);
			eachMatchLabel.setBackground(MyColor.MY_ORIANGE);
//			eachMatchLabel.setBounds(0,50*(i+1),this.getWidth()-switchToLastDay.getWidth()*2, 80);
			
			JLabel	firstTeam=new JLabel(firstTeamName,firstImage,SwingConstants.CENTER);
			JLabel	secondTeam=new JLabel(secondTeamName,secondImage,SwingConstants.CENTER);
			JLabel	scoreLabel=new	JLabel("<html><body><p>"+score+"</p><br><br><p>已结束</p></body></html>");
			
			firstTeam.setVisible(true);
			secondTeam.setVisible(true);
			secondTeam.setVisible(true);
			
			eachMatchLabel.add(firstTeam);
			eachMatchLabel.add(scoreLabel);
			eachMatchLabel.add(secondTeam);
			
			matchInfoPanel.add(eachMatchLabel);
		}
	}
	
	public String getWeek(int year,int month,int day){
		String weekstr="";
		
		Calendar cal=Calendar.getInstance();
		int thisYear=cal.get(Calendar.YEAR);
		int thisMonth=cal.get(Calendar.MONTH)+1;
		int thisDay=cal.get(Calendar.DATE);
		
		if(year==thisYear&&month==thisMonth&&day==thisDay){
			weekstr="今日   ";
		}else if(year==thisYear&&month==thisMonth&&day==thisDay-1){
			weekstr="昨日   ";
		}else{
			weekstr=String.valueOf(month)+"月"+String.valueOf(day)+"日"+" ";
		}
		
		
		if(month==1)	month=13;
		if(month==2)	month=14;
		int week=(day+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7+1;
		
		switch(week){
		case 1:weekstr+="星期一";break;
		case 2:weekstr+="星期二";break;
		case 3:weekstr+="星期三";break;
		case 4:weekstr+="星期四";break;
		case 5:weekstr+="星期五";break;
		case 6:weekstr+="星期六";break;
		case 7:weekstr+="星期日";break;
		
		}
		return weekstr;
	}
	
	
	void getLatestData(){
		matchInfoList=matchInfoBl.getLatestMatches();
		
	}
	
	
}
