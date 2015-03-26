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
	private MyLabel birthLabel;
	private MyLabel birthShowLabel;
	private MyLabel schoolLabel;
	private MyLabel schoolShowLabel;
	private MyLabel expLabel;
	private MyLabel expShowLabel;

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
		birthLabel=new MyLabel("生日：");
		schoolLabel=new MyLabel("学校：");
		expLabel=new MyLabel("经验：");
		nameShowLabel = new MyLabel("D-Wade");
		teamShowLabel = new MyLabel("MIA");
		numShowLabel = new MyLabel("3");
		positionShowLabel = new MyLabel("SG");
		ageShowLabel = new MyLabel("32");
		heightShowLabel = new MyLabel("6'6");
		weightShowLabel = new MyLabel("200 bl");
		birthShowLabel=new MyLabel("JAN-14-1980");
		schoolShowLabel=new MyLabel("MIA shool");
		expShowLabel=new MyLabel("10");
		
	}

	private void setComponentsLocation() {
		portraitLabel.setBounds((int) (NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 200) / 2, (int) (NUMBER.px * 36),
				(int) (NUMBER.px * 220), (int) (NUMBER.px * 220));// TODO 修改边框位置
		nameLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 270), labelWidth, labelHeight);
		teamLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 310), labelWidth, labelHeight);
		numLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 350), labelWidth, labelHeight);
		positionLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 390), labelWidth, labelHeight);
		ageLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 430), labelWidth, labelHeight);
		heightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 470), labelWidth, labelHeight);
		weightLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 510), labelWidth, labelHeight);
		birthLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 550), labelWidth, labelHeight);
		schoolLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 590), labelWidth, labelHeight);
		expLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 630), labelWidth, labelHeight);
		nameShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 270), showlabelWidth, labelHeight);
		teamShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 310), showlabelWidth, labelHeight);
		numShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 350), showlabelWidth, labelHeight);
		positionShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 390), showlabelWidth, labelHeight);
		ageShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 430), showlabelWidth, labelHeight);
		heightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px *470), showlabelWidth, labelHeight);
		weightShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 510), showlabelWidth, labelHeight);
		birthShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 550), showlabelWidth, labelHeight);
		schoolShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 590), showlabelWidth, labelHeight);
		expShowLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 630), showlabelWidth, labelHeight);
		this.add(portraitLabel);
		this.add(nameLabel);
		this.add(teamLabel);
		this.add(numLabel);
		this.add(positionLabel);
		this.add(ageLabel);
		this.add(heightLabel);
		this.add(weightLabel);
		this.add(expLabel);
		this.add(schoolLabel);
		this.add(birthLabel);
		this.add(nameShowLabel);
		this.add(teamShowLabel);
		this.add(numShowLabel);
		this.add(positionShowLabel);
		this.add(ageShowLabel);
		this.add(heightShowLabel);
		this.add(weightShowLabel);
		this.add(birthShowLabel);
		this.add(expShowLabel);
		this.add(schoolShowLabel);
	}

	private void setComponentsStyle() {
		portraitLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}

	private void addListener() {
		
	}

}
