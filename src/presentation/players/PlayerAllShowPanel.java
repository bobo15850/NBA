package presentation.players;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.AllShowPanel;
import common.mycomponent.MyButton;
import common.mycomponent.MyImageLabel;
import common.statics.NUMBER;
import common.statics.images.Images;

public class PlayerAllShowPanel extends AllShowPanel {

	private static final long serialVersionUID = 1L;
	private JButton playerScreening, playerSort, seasonChoose, totalOrAverage, playerSearch;
	private JButton hide, unfold;
	private JTextField playerNameInput;
	private JLabel playerNameInputLabel;
	String headList[] = { "", "姓名", "得分", "篮板", "助攻", "抢断", "盖帽", "失误", "asaxsad", "sadasx", "sadascseee" };

	public PlayerAllShowPanel() {
		super();
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
		this.initTable(headList);

	}

	private void createObjects() {
		playerScreening = new MyButton(Images.PLAYER_SCREENING, buttonWidth, buttonHeight);
		playerSort = new MyButton(Images.SORT, buttonWidth, buttonHeight);
		seasonChoose = new MyButton(Images.CHOOSE, buttonWidth, buttonHeight);
		totalOrAverage = new MyButton(Images.TOTAL_OR_AVER, buttonWidth, buttonHeight);
		playerSearch = new MyButton(Images.SEARCH, (int) (NUMBER.px * 22), (int) (NUMBER.px * 22));
		playerNameInput = new JTextField();
		playerNameInputLabel = new MyImageLabel(Images.NAME_INPUT);

		// hide=new
		// MyButton(Images.HIDE,(int)(NUMBER.px*50),(int)(NUMBER.px*570));
		unfold = new MyButton(Images.UNFOLD, (int) (NUMBER.px * 50), (int) (NUMBER.px * 593));
	}

	private void setComponentsLocation() {
		seasonChoose.setLocation((int) (NUMBER.px * 30), (int) (NUMBER.px * 36));
		totalOrAverage.setLocation((int) (NUMBER.px * 30 + inter + buttonWidth), (int) (NUMBER.px * 36));
		playerScreening.setLocation((int) (NUMBER.px * 30 + inter * 2 + buttonWidth * 2), (int) (NUMBER.px * 36));
		playerSort.setLocation((int) (NUMBER.px * 30 + inter * 3 + buttonWidth * 3), (int) (NUMBER.px * 36));
		playerSearch.setLocation((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4 + NUMBER.px * 170),
				(int) (NUMBER.px * 36));
		playerNameInputLabel.setBounds((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4), (int) (NUMBER.px * 36),
				inputWidth, buttonHeight);
		playerNameInput.setBounds(10, 0, (int) (NUMBER.px * 150), buttonHeight);
		// hide.setBounds((int)(NUMBER.px*980),(int)(NUMBER.px*90),
		// (int)(NUMBER.px*50),(int)(NUMBER.px*570));//隐藏按钮
		unfold.setLocation((int) (NUMBER.px * 980), (int) (NUMBER.px * 90));// 展开按钮
		this.add(seasonChoose);
		this.add(playerScreening);
		// this.add(playerSearch);
		this.add(playerSort);
		this.add(totalOrAverage);
		playerNameInputLabel.add(playerNameInput);
		this.add(playerNameInputLabel);
		this.add(unfold);
	}

	private void setComponentsStyle() {
		playerNameInput.setOpaque(false);
		playerNameInput.setBorder(new EmptyBorder(0, 0, 0, 0));
		playerNameInput.setForeground(Color.white);
		playerNameInput.setFont(new Font("微软雅黑", Font.PLAIN, 15));
	}

	// TODO
	private void addListener() {
		unfold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 8; i < allTable.getColumnCount(); i++) {
					allTable.getColumnModel().getColumn(i).setPreferredWidth(120);
					allTable.getColumnModel().getColumn(i).setMaxWidth(120);
					allTable.getColumnModel().getColumn(i).setMinWidth(120);// 恢复隐藏数据
				}
				allTable.updateUI();
			}
		});// 测试通过，隐藏列
	}

}
