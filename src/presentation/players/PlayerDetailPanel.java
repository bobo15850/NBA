package presentation.players;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import presentation.DetailPanel;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.statics.NUMBER;
import common.statics.images.Images;

public class PlayerDetailPanel extends DetailPanel {

	private static final long serialVersionUID = 1L;
	private JLabel portraitLabel, nameLabel, teamLabel, numLabel, positionLabel, ageLabel, heightLabel, weightLabel,
			nameShowLabel, teamShowLabel, numShowLabel, positionShowLabel, ageShowLabel, heightShowLabel,
			weightShowLabel;
	private MyButton showAllInfo;

	public PlayerDetailPanel() {
		super();
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
	}

	private void createObjects() {
		portraitLabel = new JLabel();
		nameLabel = new MyLabel("姓名：");
		teamLabel = new MyLabel("球队：");
		numLabel = new MyLabel("号码：");
		positionLabel = new MyLabel("位置：");
		ageLabel = new MyLabel("年龄：");
		heightLabel = new MyLabel("身高：");
		weightLabel = new MyLabel("体重：");
		nameShowLabel = new MyLabel("D-Wade");
		teamShowLabel = new MyLabel("MIA");
		numShowLabel = new MyLabel("3");
		positionShowLabel = new MyLabel("SG");
		ageShowLabel = new MyLabel("32");
		heightShowLabel = new MyLabel("6'6");
		weightShowLabel = new MyLabel("200 bl");
		showAllInfo = new MyButton(Images.SHOW_ALL_INFO, (int) (NUMBER.px * 180), (int) (NUMBER.px * 45));
	}

	private void setComponentsLocation() {
		portraitLabel.setBounds((int) (NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 200) / 2, (int) (NUMBER.px * 36),
				(int) (NUMBER.px * 220), (int) (NUMBER.px * 220));// TODO 修改边框位置
		nameLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 270), labelWidth, labelHeight);
		teamLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 320), labelWidth, labelHeight);
		numLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 370), labelWidth, labelHeight);
		positionLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 420), labelWidth, labelHeight);
		ageLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 470), labelWidth, labelHeight);
		heightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 520), labelWidth, labelHeight);
		weightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 570), labelWidth, labelHeight);
		nameShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 270), showlabelWidth, labelHeight);
		teamShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 320), showlabelWidth, labelHeight);
		numShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 370), showlabelWidth, labelHeight);
		positionShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 420), showlabelWidth, labelHeight);
		ageShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 470), showlabelWidth, labelHeight);
		heightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 520), showlabelWidth, labelHeight);
		weightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 570), showlabelWidth, labelHeight);
		showAllInfo.setLocation((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 195) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 630));
		this.add(portraitLabel);
		this.add(nameLabel);
		this.add(teamLabel);
		this.add(numLabel);
		this.add(positionLabel);
		this.add(ageLabel);
		this.add(heightLabel);
		this.add(weightLabel);
		this.add(nameShowLabel);
		this.add(teamShowLabel);
		this.add(numShowLabel);
		this.add(positionShowLabel);
		this.add(ageShowLabel);
		this.add(heightShowLabel);
		this.add(weightShowLabel);
		this.add(showAllInfo);
	}

	private void setComponentsStyle() {
		portraitLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}

	private void addListener() {
		showAllInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAllInfo.setMyIcon(Images.SHOW_ALL_INFO_CLICK);
			}
		});

	}

}
