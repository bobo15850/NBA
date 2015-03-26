package presentation.teams;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentation.AllShowPanel;
import common.mycomponent.MyButton;
import common.mycomponent.MyImageLabel;
import common.statics.NUMBER;
import common.statics.images.Images;

public class TeamAllShowPanel extends AllShowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton teamSort, teamChoose, totalOrAverage, teamSearch;
	private JButton hide, unfold;
	private JTextField teamNameInput;
	private JLabel teamNameInputLabel;
	String headList[] = {"得分", "篮板", "助攻", "抢断", "盖帽", "失误", "1", "2", "3", "4" };
	String nameAndNum[] = { "", "姓名"};
	public TeamAllShowPanel() {
		super(false);
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.initTable(headList, nameAndNum);
		this.addListener();
	}

	private void createObjects() {
		teamSort = new MyButton(Images.SORT, buttonWidth, buttonHeight);
		teamChoose = new MyButton(Images.CHOOSE, buttonWidth, buttonHeight);
		totalOrAverage = new MyButton(Images.TOTAL_OR_AVER, buttonWidth, buttonHeight);
		teamSearch = new MyButton(Images.SEARCH, (int) (NUMBER.px * 22), (int) (NUMBER.px * 22));
		teamNameInput = new JTextField();
		teamNameInputLabel = new MyImageLabel(Images.NAME_INPUT);
		
		// hide=new MyButton(Images.HIDE,(int)(NUMBER.px*50),(int)(NUMBER.px*570));
		unfold = new MyButton(Images.UNFOLD, (int) (NUMBER.px * 50), (int) (NUMBER.px * 593));
	}

	private void setComponentsLocation() {
		teamChoose.setLocation((int) (NUMBER.px * 30), (int) (NUMBER.px * 36));
		totalOrAverage.setLocation((int) (NUMBER.px * 30 + inter * 5 / 4 + buttonWidth * 5 / 4), (int) (NUMBER.px * 36));
		teamSort.setLocation((int) (NUMBER.px * 30 + inter * 5 / 2 + buttonWidth * 5 / 2), (int) (NUMBER.px * 36));
		teamSearch.setLocation((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4 + NUMBER.px * 170), (int) (NUMBER.px * 36));
		teamNameInputLabel.setBounds((int) (NUMBER.px * 30 + inter * 4 + buttonWidth * 4), (int) (NUMBER.px * 36), inputWidth, buttonHeight);
		teamNameInput.setBounds(10, 0, (int) (NUMBER.px * 150), buttonHeight);
		teamNameInput.setForeground(Color.white);
		// hide.setBounds((int)(NUMBER.px*980),(int)(NUMBER.px*90),
		// (int)(NUMBER.px*50),(int)(NUMBER.px*570));//隐藏按钮
		unfold.setLocation((int) (NUMBER.px * 980), (int) (NUMBER.px * 90));// 展开按钮
		this.add(teamChoose);
		this.add(teamSearch);
		this.add(teamSort);
		this.add(totalOrAverage);
		teamNameInputLabel.add(teamNameInput);
		this.add(teamNameInputLabel);
		this.add(unfold);
	}

	private void setComponentsStyle() {
		teamNameInput.setOpaque(false);
		teamNameInput.setBorder(new EmptyBorder(0, 0, 0, 0));
		
	}

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
