package presentation.players;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import vo.OnePlayerPerformOfOneSeasonVo;
import businesslogic.players.PlayerInfoBl;
import businesslogicservice.players.PlayerInfoBlService;
import common.enums.Conference;
import common.enums.Division;
import common.enums.PerformanceOfPlayer;
import common.enums.PlayerPosition;
import common.mycomponent.MyButton;
import common.mycomponent.MyDialog;
import common.mycomponent.MyLabel;
import common.mycomponent.MyTable;
import common.mycomponent.MyTableModel;
import common.mydatastructure.Season;
import common.mydatastructure.SelectionCondition;
import common.statics.MyColor;
import common.statics.MyFont;
import common.statics.NUMBER;
import common.statics.images.Images;

public class SelectPlayerDialog extends MyDialog implements MouseListener {
	private static final long serialVersionUID = 1L;
	private final int buttonWidth = (int) (NUMBER.px * 100);
	private final int buttonHeight = (int) (NUMBER.px * 40);
	private final int width = (int) (NUMBER.px * 200);
	private final int height = (int) (NUMBER.px * 40);
	private JComboBox<PlayerPosition> playerPosition;
	private JComboBox<Conference> playerConference;
	private JComboBox<Division> playerDivision;
	private JComboBox<PerformanceOfPlayer> playerSort;
	private MyLabel playerPositionLabel, playerConferenceLabel, playerDivisionLabel, playerSortLabel, tipLabel;
	private MyButton sureButton, cancleButton;
	private PlayerInfoBlService playerBl;
	private ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList, selectPlayerList;
	private MyTableModel selectTableModel, selectNameAndNumTableModel;
	private MyTable selectTable, selectNameTable;
	private Season season;

	public SelectPlayerDialog(Season season, ArrayList<OnePlayerPerformOfOneSeasonVo> allPlayerList, MyTableModel allTableModel, MyTableModel nameAndNumTableModel, MyTable allTable, MyTable nameTable) {
		this.selectTableModel = allTableModel;
		this.selectTable = allTable;
		this.selectNameTable = nameTable;
		this.selectNameAndNumTableModel = nameAndNumTableModel;
		this.allPlayerList = allPlayerList;
		this.season = season;
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
		this.setVisible(true);
	}

	private void createObjects() {
		PlayerPosition playerPositionStr[] = { null, PlayerPosition.C, PlayerPosition.C_F, PlayerPosition.C_G, PlayerPosition.F, PlayerPosition.F_C, PlayerPosition.F_G, PlayerPosition.G, PlayerPosition.G_C, PlayerPosition.G_F };
		Conference playerConferenceStr[] = { null, Conference.EASTERN, Conference.WESTERN };
		Division playerDivisionStr[] = { null, Division.Atlantic, Division.Central, Division.Northwest, Division.Pacific, Division.Southeast, Division.Southwest };
		PerformanceOfPlayer playerSortStr[] = PerformanceOfPlayer.values();
		playerBl = new PlayerInfoBl();
		playerPosition = new JComboBox<PlayerPosition>(playerPositionStr);
		playerDivision = new JComboBox<Division>(playerDivisionStr);
		playerConference = new JComboBox<Conference>(playerConferenceStr);
		playerSort = new JComboBox<PerformanceOfPlayer>(playerSortStr);
		playerPositionLabel = new MyLabel("球员位置");
		playerConferenceLabel = new MyLabel("球员联盟");
		playerDivisionLabel = new MyLabel("球员分区");
		playerSortLabel = new MyLabel("筛选依据");
		tipLabel = new MyLabel();
		sureButton = new MyButton(Images.SURE_BUTTON, buttonWidth, buttonHeight);
		cancleButton = new MyButton(Images.CANCLE_BUTTON, buttonWidth, buttonHeight);
	}

	private void setComponentsLocation() {
		playerPosition.setBounds((int) (NUMBER.px * 300), (int) (NUMBER.px * 130), width, height);
		playerConference.setBounds((int) (NUMBER.px * 300), (int) (NUMBER.px * 230), width, height);
		playerDivision.setBounds((int) (NUMBER.px * 300), (int) (NUMBER.px * 330), width, height);
		playerSort.setBounds((int) (NUMBER.px * 300), (int) (NUMBER.px * 430), width, height);
		sureButton.setBounds((int) (NUMBER.px * 150), (int) (NUMBER.px * 530), buttonWidth, buttonHeight);
		cancleButton.setBounds((int) (NUMBER.px * 350), (int) (NUMBER.px * 530), buttonWidth, buttonHeight);
		playerPositionLabel.setBounds((int) (NUMBER.px * 130), (int) (NUMBER.px * 130), width, height);
		playerConferenceLabel.setBounds((int) (NUMBER.px * 130), (int) (NUMBER.px * 230), width, height);
		playerDivisionLabel.setBounds((int) (NUMBER.px * 130), (int) (NUMBER.px * 330), width, height);
		playerSortLabel.setBounds((int) (NUMBER.px * 130), (int) (NUMBER.px * 430), width, height);
		tipLabel.setBounds(0, 0, (int) (NUMBER.px * 600), (int) (NUMBER.px * 100));
		this.add(playerPosition);
		this.add(playerSort);
		this.add(playerDivision);
		this.add(playerConference);
		this.add(playerPositionLabel);
		this.add(playerConferenceLabel);
		this.add(playerDivisionLabel);
		this.add(playerSortLabel);
		this.add(tipLabel);
		this.add(sureButton);
		this.add(cancleButton);
	}

	private void setComponentsStyle() {
		playerPosition.setOpaque(false);
		playerSort.setOpaque(false);
		playerDivision.setOpaque(false);
		playerConference.setOpaque(false);
		this.setDialogTitleStyle();
	}
	private void setDialogTitleStyle(){
		tipLabel.setOpaque(true);
		tipLabel.setText("筛选球员");
		tipLabel.setHorizontalAlignment(MyLabel.CENTER);
		tipLabel.setBackground(MyColor.MIDDLE_COLOR);
		tipLabel.setFont(MyFont.LARGE_BOLD);
		tipLabel.setForeground(MyColor.MY_WHITE);
	}

	private void addListener() {
		sureButton.addMouseListener(this);
		sureButton.addMouseListener(this);
		cancleButton.addMouseListener(this);
		cancleButton.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(sureButton)) {
			SelectionCondition condition = new SelectionCondition((PlayerPosition) playerPosition.getSelectedItem(), (Conference) playerConference.getSelectedItem(), (Division) playerDivision.getSelectedItem(), (PerformanceOfPlayer) playerSort.getSelectedItem());
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
		} else if (e.getSource().equals(cancleButton)) {
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
