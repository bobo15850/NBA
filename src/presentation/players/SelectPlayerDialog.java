package presentation.players;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTable;

import vo.OnePlayerPerformOfOneSeasonVo;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;
import common.enums.Conference;
import common.enums.Division;
import common.enums.PerformanceOfPlayer;
import common.enums.PlayerPosition;
import common.mycomponent.MyTableModel;
import common.mydatastructure.Season;
import common.mydatastructure.SelectionCondition;
import common.statics.NUMBER;

public class SelectPlayerDialog extends JDialog implements MouseListener {
	private static final long serialVersionUID = 1L;
	private JComboBox<PlayerPosition> playerPosition;
	private JComboBox<Conference> playerConference;
	private JComboBox<Division> playerDivision;
	private JComboBox<PerformanceOfPlayer> playerSort;
	private JButton sure, cancle;
	private PlayerInfoBlService playerBl;
	private ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList;
	private ArrayList<OnePlayerPerformOfOneSeasonVo> selectPlayerList;
	private MyTableModel selectTableModel;
	private MyTableModel selectNameAndNumTableModel;
	private JTable selectTable;
	private JTable selectNameTable;
	private Season season;

	public SelectPlayerDialog(Season season, ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList,
			MyTableModel allTableModel, MyTableModel nameAndNumTableModel, JTable allTable, JTable nameTable) {
		this.selectTableModel = allTableModel;
		this.selectTable = allTable;
		this.selectNameTable = nameTable;
		this.selectNameAndNumTableModel = nameAndNumTableModel;
		this.allPlayerList = allPlayerList;
		this.season = season;
		this.setLayout(null);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
		this.setVisible(true);
	}

	private void createObjects() {
		PlayerPosition playerPositionStr[] = { null, PlayerPosition.C, PlayerPosition.C_F, PlayerPosition.C_G,
				PlayerPosition.F, PlayerPosition.F_C, PlayerPosition.F_G, PlayerPosition.G, PlayerPosition.G_C,
				PlayerPosition.G_F };
		Conference playerConferenceStr[] = { null, Conference.EASTERN, Conference.WESTERN };
		Division playerDivisionStr[] = { null, Division.Atlantic, Division.Central, Division.Northwest,
				Division.Pacific, Division.Southeast, Division.Southwest };
		PerformanceOfPlayer playerSortStr[] = PerformanceOfPlayer.values();
		playerBl = new PlayerInfoBl();
		playerPosition = new JComboBox<PlayerPosition>(playerPositionStr);
		playerDivision = new JComboBox<Division>(playerDivisionStr);
		playerConference = new JComboBox<Conference>(playerConferenceStr);
		playerSort = new JComboBox<PerformanceOfPlayer>(playerSortStr);
		sure = new JButton("确认");
		cancle = new JButton("取消");
	}

	private void setComponentsLocation() {
		playerPosition.setBounds((int) (NUMBER.px * 150), (int) (NUMBER.px * 50), (int) (NUMBER.px * 200),
				(int) (NUMBER.px * 40));
		playerConference.setBounds((int) (NUMBER.px * 150), (int) (NUMBER.px * 150), (int) (NUMBER.px * 200),
				(int) (NUMBER.px * 40));
		playerDivision.setBounds((int) (NUMBER.px * 150), (int) (NUMBER.px * 250), (int) (NUMBER.px * 200),
				(int) (NUMBER.px * 40));
		playerSort.setBounds((int) (NUMBER.px * 150), (int) (NUMBER.px * 350), (int) (NUMBER.px * 200),
				(int) (NUMBER.px * 40));
		sure.setBounds((int) (NUMBER.px * 150), (int) (NUMBER.px * 450), (int) (NUMBER.px * 200),
				(int) (NUMBER.px * 40));
		this.add(playerPosition);
		this.add(playerSort);
		this.add(playerDivision);
		this.add(playerConference);
		this.add(sure);
		this.add(cancle);
	}

	private void setComponentsStyle() {

	}

	private void addListener() {
		sure.addMouseListener(this);
		sure.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(sure)) {
			SelectionCondition condition = new SelectionCondition((PlayerPosition) playerPosition.getSelectedItem(),
					(Conference) playerConference.getSelectedItem(), (Division) playerDivision.getSelectedItem(),
					(PerformanceOfPlayer) playerSort.getSelectedItem());
			selectPlayerList = playerBl.selsctPlayer(allPlayerList, condition, season);
			selectTableModel.removeAllRows();
			selectNameAndNumTableModel.removeAllRows();
			for (int i = 0; i < selectPlayerList.size(); i++) {
				String row1[] = selectPlayerList.get(i).toStringArray();
				String row2[] = { String.valueOf(i + 1), selectPlayerList.get(i).getNameOfPlayer() };
				selectTableModel.addRow(row1);
				selectNameAndNumTableModel.addRow(row2);
			}
			selectTable.updateUI();
			selectNameTable.updateUI();
			this.dispose();
		} else if (e.getSource().equals(cancle)) {
			this.dispose();
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
