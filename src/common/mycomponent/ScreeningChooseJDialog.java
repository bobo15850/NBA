package common.mycomponent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.text.Position;

import vo.OnePlayerPerformOfOneSeasonVo;
import businesslogic.players.PlayerInfoBl;
import businesslogic.players.SortOfPlayer.PlayerPerformance;
import businesslogicservice.players.PlayerInfoBlService;
import common.enums.Conference;
import common.enums.Division;
import common.enums.PerformanceOfPlayer;
import common.enums.PlayerPosition;
import common.mydatastructure.Season;
import common.mydatastructure.SelectionCondition;
import common.statics.NUMBER;

public class ScreeningChooseJDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	ImageIcon images;
	JComboBox<PlayerPosition> playerPosition;
	JComboBox<Conference> playerConference;
	JComboBox<Division> playerDivision;
	JComboBox<PerformanceOfPlayer> playerSort;
	private JButton makeSure;
	private PlayerInfoBlService playerBl;
	private ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList;
	private ArrayList<OnePlayerPerformOfOneSeasonVo> selectPlayerList;
	private MyTableModel selectTableModel;
	private JDialog j=this;
	private MyTableModel selectNameAndNumTableModel;
	private JTable selectTable;
	private JTable selectNameTable;
	public ScreeningChooseJDialog(ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList,MyTableModel allTableModel,MyTableModel nameAndNumTableModel,JTable allTable,JTable nameTable){
		this.selectTableModel=allTableModel;
		this.selectTable=allTable;
		this.selectNameTable=nameTable;
		this.selectNameAndNumTableModel=nameAndNumTableModel;
		this.allPlayerList=allPlayerList;
		this.setLayout(null);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
		this.setVisible(true);
	}

	private void createObjects() {
		PlayerPosition playerPositionStr[]={null,PlayerPosition.C,PlayerPosition.C_F,PlayerPosition.C_G,PlayerPosition.F,PlayerPosition.F_C,PlayerPosition.F_G,PlayerPosition.G,PlayerPosition.G_C,PlayerPosition.G_F};
		Conference playerConferenceStr[]={null,Conference.EASTERN,Conference.WESTERN};
		Division playerDivisionStr[]={null,Division.Atlantic,Division.Central,Division.Northwest,Division.Pacific,Division.Southeast,Division.Southwest};
		PerformanceOfPlayer playerSortStr[]=PerformanceOfPlayer.values();
		playerBl=new PlayerInfoBl();
		playerPosition=new JComboBox<PlayerPosition>(playerPositionStr);
		playerDivision=new JComboBox<Division>(playerDivisionStr);
		playerConference=new JComboBox<Conference>(playerConferenceStr);
		playerSort=new JComboBox<PerformanceOfPlayer>(playerSortStr);
		
		makeSure=new JButton("确认");
	}
    private void setComponentsLocation() {
    	playerPosition.setBounds((int)(NUMBER.px*150),(int)(NUMBER.px*50),(int)(NUMBER.px*200),(int)(NUMBER.px*40));
    	playerConference.setBounds((int)(NUMBER.px*150),(int)(NUMBER.px*150),(int)(NUMBER.px*200),(int)(NUMBER.px*40));
    	playerDivision.setBounds((int)(NUMBER.px*150),(int)(NUMBER.px*250),(int)(NUMBER.px*200),(int)(NUMBER.px*40));
    	playerSort.setBounds((int)(NUMBER.px*150),(int)(NUMBER.px*350),(int)(NUMBER.px*200),(int)(NUMBER.px*40));
    	makeSure.setBounds((int)(NUMBER.px*150),(int)(NUMBER.px*450),(int)(NUMBER.px*200),(int)(NUMBER.px*40));
		this.add(playerPosition);
		this.add(playerSort);
		this.add(playerDivision);
		this.add(playerConference);
		this.add(makeSure);
	}
	private void setComponentsStyle() {
		
	}
	private void addListener() {
		makeSure.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent arg0) {
				selectPlayerList=playerBl.selsctPlayer(allPlayerList, new SelectionCondition((PlayerPosition)playerPosition.getSelectedItem(), (Conference)playerConference.getSelectedItem(), (Division)playerDivision.getSelectedItem(), (PerformanceOfPlayer)playerSort.getSelectedItem()), new Season("13-14"));
				selectTableModel.removeAllRows();
				selectNameAndNumTableModel.removeAllRows();
				for (int i = 0; i < selectPlayerList.size(); i++) {
					String row1[] = selectPlayerList.get(i).toAverStringArray();
					String row2[] = {String.valueOf(i + 1),selectPlayerList.get(i).getNameOfPlayer()}; 
					selectTableModel.addRow(row1);
					selectNameAndNumTableModel.addRow(row2);
				}
				selectTable.updateUI();
				selectNameTable.updateUI();
				j.dispose();
			}

			public void mouseEntered(MouseEvent arg0) {
				
			}

			
			public void mouseExited(MouseEvent arg0) {
				
			}

			public void mousePressed(MouseEvent arg0) {
				
			}

			public void mouseReleased(MouseEvent arg0) {
				
			}
			
		});
	}
//	protected void paintComponent(Graphics g)
//	   {
//	    super.paintComponent(g);
//	    int x = this.getWidth();
//	    int y = this.getHeight();
//	    
//	    g.drawImage(images.getImage(), 0, 0, x, y, null);
//	   }
}
