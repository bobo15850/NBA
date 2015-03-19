package presentation.teams;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.DetailPanel;
import common.mycomponent.MyButton;
import common.mycomponent.MyLabel;
import common.statics.NUMBER;
import common.statics.images.Images;

public class TeamDetailPanel extends DetailPanel {

	private static final long serialVersionUID = 1L;
	private JLabel logoLabel, nameLabel, nameAbrreviationLabel, placeLabel, zoneLabel, partitionZoneLabel,
			homeCourtLabel, setUpTimeLabel;
	private MyButton showAllInfo;

	public TeamDetailPanel() {
		super();
		this.createObjects();
		this.setComponentsLocation();
		this.setComponentsStyle();
		this.addListener();
	}

	private void createObjects() {
		logoLabel = new JLabel();
		nameLabel = new MyLabel("球队全名：");
		nameAbrreviationLabel = new MyLabel("缩写：");
		placeLabel = new MyLabel("所在地：");
		zoneLabel = new MyLabel("赛区：");
		partitionZoneLabel = new MyLabel("分区：");
		homeCourtLabel = new MyLabel("主场：");
		setUpTimeLabel = new MyLabel("建立时间：");
		showAllInfo = new MyButton(Images.SHOW_ALL_INFO, (int) (NUMBER.px * 200), (int) (NUMBER.px * 40));
	}

	private void setComponentsLocation() {
		logoLabel.setBounds((int) (NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 200) / 2, (int) (NUMBER.px * 36),
				(int) (NUMBER.px * 220), (int) (NUMBER.px * 220));// TODO 修改边框位置
		nameLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 270), labelWidth, labelHeight);
		nameAbrreviationLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 320), labelWidth, labelHeight);
		placeLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 370), labelWidth, labelHeight);
		zoneLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 420), labelWidth, labelHeight);
		partitionZoneLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 470), labelWidth, labelHeight);
		homeCourtLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 520), labelWidth, labelHeight);
		setUpTimeLabel.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 570), labelWidth, labelHeight);
		showAllInfo.setBounds((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 220) / 2 + NUMBER.px * 90),
				(int) (NUMBER.px * 270), showlabelWidth, labelHeight);
		showAllInfo.setLocation((int) ((NUMBER.DETAIL_PANEL_WIDTH - NUMBER.px * 155) / 2 + NUMBER.px * 20),
				(int) (NUMBER.px * 630));
		this.add(logoLabel);
		this.add(nameLabel);
		this.add(nameAbrreviationLabel);
		this.add(placeLabel);
		this.add(zoneLabel);
		this.add(partitionZoneLabel);
		this.add(homeCourtLabel);
		this.add(setUpTimeLabel);
		this.add(showAllInfo);
	}

	private void setComponentsStyle() {
		logoLabel.setBorder(BorderFactory.createLineBorder(Color.black, 2));
	}

	private void addListener() {
		showAllInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showAllInfo.setMyIcon(Images.SHOW_ALL_INFO_CLICK);
			}
		});

	}
}
