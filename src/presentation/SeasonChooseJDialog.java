package presentation;
//package common.mycomponent;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.Panel;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.util.ArrayList;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTable;
//import javax.swing.text.Position;
//
//import vo.OnePlayerPerformOfOneSeasonVo;
//import businesslogic.players.PlayerInfoBl;
//import businesslogic.players.SortOfPlayer.PlayerPerformance;
//import businesslogicservice.players.PlayerInfoBlService;
//import common.enums.PerformanceOfPlayer;
//import common.mydatastructure.Season;
//import common.mydatastructure.SelectionCondition;
//import common.statics.NUMBER;
//
//public class SeasonChooseJDialog extends JDialog{
//	private static final long serialVersionUID = 1L;
//	ImageIcon images;
//	JComboBox<Season> seasonChoose;
//	private JButton makeSure;
//	private PlayerInfoBlService playerBl;
//	private ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList;
//	private ArrayList<OnePlayerPerformOfOneSeasonVo> selectPlayerList;
//	private MyTableModel selectTableModel;
//	private JDialog j=this;
//	private MyTableModel selectNameAndNumTableModel;
//	private JTable selectTable;
//	private JTable selectNameTable;
//	public SeasonChooseJDialog(ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList,MyTableModel allTableModel,MyTableModel nameAndNumTableModel,JTable allTable,JTable nameTable){
//		this.selectTableModel=allTableModel;
//		this.selectTable=allTable;
//		this.selectNameTable=nameTable;
//		this.selectNameAndNumTableModel=nameAndNumTableModel;
//		this.allPlayerList=allPlayerList;
//		this.setLayout(null);
//		this.createObjects();
//		this.setComponentsLocation();
//		this.setComponentsStyle();
//		this.addListener();
//		this.setVisible(true);
//	}

//	private void createObjects() {
//		Season seasonStr[]
//		Conference playerConferenceStr[]={null,Conference.EASTERN,Conference.WESTERN};
//		Division playerDivisionStr[]={null,Division.Atlantic,Division.Central,Division.Northwest,Division.Pacific,Division.Southeast,Division.Southwest};
//		PerformanceOfPlayer playerSortStr[]=PerformanceOfPlayer.values();
//		playerBl=new PlayerInfoBl();
//		playerSort=new JComboBox<PerformanceOfPlayer>(playerSortStr);
//		
//		makeSure=new JButton("确认");
//	}
//    private void setComponentsLocation() {
//    	playerSort.setBounds((int)(NUMBER.px*150),(int)(NUMBER.px*350),(int)(NUMBER.px*200),(int)(NUMBER.px*40));
//    	makeSure.setBounds((int)(NUMBER.px*150),(int)(NUMBER.px*450),(int)(NUMBER.px*200),(int)(NUMBER.px*40));
//		this.add(playerSort);
//		this.add(makeSure);
//	}
//	private void setComponentsStyle() {
//		
//	}
//	private void addListener() {
//		makeSure.addMouseListener(new MouseListener(){
//
//			public void mouseClicked(MouseEvent arg0) {
//				selectPlayerList=playerBl.selsctPlayer(allPlayerList, new SelectionCondition(null,null,null,null), new Season("13-14"));
//				selectTableModel.removeAllRows();
//				selectNameAndNumTableModel.removeAllRows();
//				for (int i = 0; i < selectPlayerList.size(); i++) {
//					String row1[] = selectPlayerList.get(i).toAverStringArray();
//					String row2[] = {String.valueOf(i + 1),selectPlayerList.get(i).getNameOfPlayer()}; 
//					selectTableModel.addRow(row1);
//					selectNameAndNumTableModel.addRow(row2);
//				}
//				selectTable.updateUI();
//				selectNameTable.updateUI();
//				j.dispose();
//			}
//
//			public void mouseEntered(MouseEvent arg0) {
//				
//			}
//
//			
//			public void mouseExited(MouseEvent arg0) {
//				
//			}
//
//			public void mousePressed(MouseEvent arg0) {
//				
//			}
//
//			public void mouseReleased(MouseEvent arg0) {
//				
//			}
//			
//		});
//	}
////	protected void paintComponent(Graphics g)
////	   {
////	    super.paintComponent(g);
////	    int x = this.getWidth();
////	    int y = this.getHeight();
////	    
////	    g.drawImage(images.getImage(), 0, 0, x, y, null);
////	   }
//}
//
