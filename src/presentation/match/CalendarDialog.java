package presentation.match;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import common.statics.MyColor;

public class CalendarDialog extends JPanel {
	private static final long serialVersionUID = 1L;

	private int width = 220; // 日期控件的宽度
	private int height = 220; // 日期控件的高度
	static CalendarDialog date;
	private GridBagLayout gridBagLayout1 = new GridBagLayout();
	private JTextField dateField = new JTextField();
//	JButton btnChoose = new JButton("▼");
	DateChooserButton btnChoose = new DateChooserButton("▼"); // ▼是指：▼下拉箭头的unicode码
	private String parten;
	@SuppressWarnings("unused")
	private Container owner;
	private int length = 80;
	private Point startPoint;
	javax.swing.JDialog dateFrame;

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public CalendarDialog(Container owner, int length) {
		this.owner = owner;
		this.parten = "yyyy-MM-dd";
		this.length = length;
		try {
			init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 根据一个所有者和一个日期的显示格式构造一个DateChooser对象。
	 */
	public CalendarDialog(Container owner, String partten, int length) {
		this.owner = owner;
		this.parten = partten;
		this.length = length;
		try {
			init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 根据一个所有者和一个日期的显示格式构造一个DateChooser对象。
	 */
	public CalendarDialog(Container owner, String partten) {
		this.owner = owner;
		this.parten = partten;
		try {
			init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * 以缺省的partten构建DateChooser对象 日期选择框的所有者必须是Frame或者是JFrame对象。
	 */
	public CalendarDialog(Container owner) {
		this.owner = owner;
		this.parten = "yyyy-MM-dd";
		try {
			init();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 系统初始化
	 * 
	 * @throws Exception
	 */
	private void init() throws Exception {
		dateField.setToolTipText("单击右边的按钮即可选择日期");
		btnChoose.setToolTipText("单击即可选择日期");
//		this.setLayout(gridBagLayout1);
		this.setLayout(null);
		this.setOpaque(true);
		this.setVisible(true);
		this.setBackground(MyColor.MY_RED);
//		calendarDialog.setBackground(MyColor.MY_RED);
	
		dateField.setEditable(false);
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarDialog.this.btnChoose_actionPerformed(e);
			}
		});
		
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(parten);
		this.setText(simpleDateFormat.format(date));
//		this.add(dateField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
//				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
//						0, 0, 5, 0), this.length, 0));
//		this.add(btnChoose, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
//				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
//						0, 0, 5, 0), 0, 0));
		dateField.setBounds(0, 0, this.getWidth()*4/5, this.getHeight());
		dateField.setVisible(true);
		this.add(dateField);
		btnChoose.setBounds(dateField.getWidth(), 0, this.getWidth()/5, this.getHeight());
		btnChoose.setVisible(true);
		this.add(btnChoose);
		this.repaint();
	}

	public void setToolTipText(String text) {
		dateField.setToolTipText(text);
		btnChoose.setToolTipText(text);

	}

	/**
	 * 下拉按钮的事件处理
	 * 
	 * @param e
	 *            ActionEvent
	 */
	public void btnChoose_actionPerformed(ActionEvent e) {
		 dateFrame = new javax.swing.JDialog();
		 dateFrame.setModal(false);//设置为非模式对话框
		 dateFrame.setUndecorated(true);
			  dateFrame.setModalExclusionType(JDialog.ModalExclusionType.APPLICATION_EXCLUDE);//设置模式
	    dateFrame.setLocationRelativeTo(dateField);
		int x = dateFrame.getLocation().x - (dateField.getWidth() / 2);
		int y = dateFrame.getLocation().y + (dateField.getHeight() / 2);
		dateFrame.setLocation(new Point(x, y));
		dateFrame.setSize(width, height);

		dateFrame.addWindowListener(new WindowAdapter() {
			// 在任意的非日期选择区单击，则日期选择组件将变为非活动状态，自动释放资源。
			public void windowDeactivated(WindowEvent e) {
//				dateFrame.setModal(false);
				javax.swing.JDialog f = (javax.swing.JDialog) e.getSource();
				//JparentDialog.setModal(true);
				f.dispose();
			}
		});
		DatePanel datePanel = new DatePanel(dateFrame, parten);
		dateFrame.getContentPane().setLayout(new BorderLayout());
		dateFrame.getContentPane().add(datePanel);
		dateFrame.setVisible(true);
	}

	/**
	 * 得到日期控件中的值
	 * 
	 * @return String
	 */
	public String getText() {
		return this.dateField.getText();
	}

	/**
	 * 设置文本域的值
	 * 
	 * @param text
	 *            String
	 */
	public void setText(String text) {
		this.dateField.setText(text);
	}

	/**
	 * 该方法非常有用，是外部直接访问的TextField对象。
	 * 
	 * @return JTextField
	 */
	public JTextField getDateField() {
		return dateField;
	}

	/**
	 * 内部类，日期选择控件的主体，封装了所有日期选择的内容，主要是一个Panel
	 */
	class DatePanel extends JPanel implements MouseListener, ChangeListener {
		private static final long serialVersionUID = 1L;

		int startYear = 1970; // 默认【最小】显示年份
		int lastYear = 2100; // 默认【最大】显示年份

		Color backGroundColor = Color.gray; // 底色
		// 月历表格配色----------------//
		Color palletTableColor = Color.white; // 日历表底色
		Color weekFontColor = Color.blue; // 星期文字色
		Color dateFontColor = Color.black; // 日期文字色
		Color weekendFontColor = Color.red; // 周末文字色
		Color moveButtonColor = Color.BLUE; // 鼠标移动的日历底色
		Color todayBtnColor = Color.pink; // 今天的日历底色
		// 控制条配色------------------//
		Color controlLineColor = Color.pink; // 控制条底色
		Color controlTextColor = Color.white; // 控制条标签文字色

		JSpinner yearSpin;
		JSpinner monthSpin;
		JSpinner hourSpin;
		JButton[][] daysButton = new JButton[6][7];

		javax.swing.JDialog f;

		JPanel dayPanel = new JPanel(); // 日期panel
		JPanel yearPanel = new JPanel();

		Calendar calendar = Calendar.getInstance();
		String pattern;

		/**
		 * 日期选择控件放在了非模态对话框中
		 */
		public DatePanel(javax.swing.JDialog target, String pattern) {
			super();

			this.f = target;
			this.pattern = pattern;

			setLayout(new BorderLayout());
			setBorder(new LineBorder(backGroundColor, 2));
			setBackground(backGroundColor);
			initButton(); // 初始化放置日期的按钮。
			createYearAndMonthPanal(); //
			this.flushWeekAndDayPanal(calendar); // 之前必须先保证放置日期的按钮已经初始化。
			this.setLayout(new BorderLayout());
			this.add(yearPanel, BorderLayout.NORTH);
			this.add(dayPanel, BorderLayout.CENTER);
		}

		/**
		 * 日期选择控件的按钮初始化
		 */
		private void initButton() {
			int actionCommandId = 1;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {
					JButton numberButton = new JButton();
					numberButton.setBorder(BorderFactory.createEmptyBorder());
					numberButton.setHorizontalAlignment(SwingConstants.CENTER);
					numberButton.setActionCommand(String
							.valueOf(actionCommandId));

					numberButton.addMouseListener(this);

					numberButton.setBackground(palletTableColor);
					numberButton.setForeground(dateFontColor);
					numberButton.setText(String.valueOf(actionCommandId));
					numberButton.setPreferredSize(new Dimension(25, 25));
					daysButton[i][j] = numberButton;
					actionCommandId++;
				}
			}
		}

		private Date getNowDate() {
			return Calendar.getInstance().getTime();
		}

		private Calendar getNowCalendar() {
			Calendar result = Calendar.getInstance();
			return result;
		}

		private Date getSelectDate() {
			return calendar.getTime();
		}

		/**
		 * 创建年月日的面板
		 */
		private void createYearAndMonthPanal() {
			Calendar c = getNowCalendar();
			int currentYear = c.get(Calendar.YEAR);
			int currentMonth = c.get(Calendar.MONTH) + 1;
			int currentHour = c.get(Calendar.DAY_OF_MONTH);
			yearSpin = new JSpinner(new javax.swing.SpinnerNumberModel(
					currentYear, startYear, lastYear, 1));
			monthSpin = new JSpinner(new javax.swing.SpinnerNumberModel(
					currentMonth, 1, 12, 1));
			hourSpin = new JSpinner(new javax.swing.SpinnerNumberModel(
					currentHour, 0, 31, 1));

			yearPanel.setLayout(new java.awt.FlowLayout());
			yearPanel.setBackground(controlLineColor);

			yearSpin.setPreferredSize(new Dimension(60, 23));
			yearSpin.setName("Year");
			yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
			yearSpin.addChangeListener(this);
			yearPanel.add(yearSpin);

			JLabel yearLabel = new JLabel("年");
			yearLabel.setForeground(controlTextColor);
			yearPanel.add(yearLabel);

			monthSpin.setPreferredSize(new Dimension(40, 23));
			monthSpin.setName("Month");
			monthSpin.addChangeListener(this);
			yearPanel.add(monthSpin);

			JLabel monthLabel = new JLabel("月");
			monthLabel.setForeground(controlTextColor);
			yearPanel.add(monthLabel);

			hourSpin.setPreferredSize(new Dimension(40, 23));
			hourSpin.setName("Day");
			hourSpin.addChangeListener(this);
			yearPanel.add(hourSpin);

			JLabel hourLabel = new JLabel("日");
			hourLabel.setForeground(controlTextColor);
			yearPanel.add(hourLabel);
		}

		/**
		 * 根据日期刷新显示面板
		 */
		private void flushWeekAndDayPanal(Calendar c) {
			c.set(Calendar.DAY_OF_MONTH, 1);
			c.setFirstDayOfWeek(0);
			int firstdayofWeek = c.get(Calendar.DAY_OF_WEEK);
			int lastdayofWeek = c.getActualMaximum(Calendar.DAY_OF_MONTH);
			String colname[] = { "日", "一", "二", "三", "四", "五", "六" };
			int today = getNowCalendar().get(Calendar.DAY_OF_MONTH);
			// 设置固定字体，以免调用环境改变影响界面美观
			dayPanel.setFont(new java.awt.Font("宋体", java.awt.Font.PLAIN, 12));
			dayPanel.setLayout(new GridBagLayout());
			dayPanel.setBackground(Color.white);

			JLabel cell;

			for (int i = 0; i < 7; i++) {
				cell = new JLabel(colname[i]);
				cell.setHorizontalAlignment(JLabel.CENTER);
				cell.setPreferredSize(new Dimension(25, 25));
				if (i == 0 || i == 6) {
					cell.setForeground(weekendFontColor);
				} else {
					cell.setForeground(weekFontColor);
				}
				dayPanel.add(cell, new GridBagConstraints(i, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
			}

			int actionCommandId = 1;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 7; j++) {

					JButton numberButton = daysButton[i][j];
					actionCommandId = Integer.parseInt(numberButton
							.getActionCommand());
					if (actionCommandId == today) {
						numberButton.setBackground(todayBtnColor);
					}
					if ((actionCommandId + firstdayofWeek - 2) % 7 == 6
							|| (actionCommandId + firstdayofWeek - 2) % 7 == 0) {
						numberButton.setForeground(weekendFontColor);
					} else {
						numberButton.setForeground(dateFontColor);
					}

					if (actionCommandId <= lastdayofWeek) {
						int y = 0;
						if ((firstdayofWeek - 1) <= (j + firstdayofWeek - 1) % 7) {
							y = i + 1;
						} else {
							y = i + 2;
						}
						dayPanel.add(numberButton, new GridBagConstraints((j
								+ firstdayofWeek - 1) % 7, y, 1, 1, 0.0, 0.0,
								GridBagConstraints.CENTER,
								GridBagConstraints.NONE,
								new Insets(0, 0, 0, 0), 0, 0));
					}
				}
			}
		}

		private int getSelectedYear() {
			return ((Integer) yearSpin.getValue()).intValue();
		}

		private int getSelectedMonth() {
			return ((Integer) monthSpin.getValue()).intValue();
		}

		private int getSelectedHour() {
			return ((Integer) hourSpin.getValue()).intValue();
		}

		/**
		 * 年月小时的事件处理
		 * @param e  ChangeEvent
		 */
		public void stateChanged(ChangeEvent e) {
			JSpinner source = (JSpinner) e.getSource();
			if (source.getName().equals("Day")) {
				calendar.set(Calendar.DAY_OF_MONTH, getSelectedHour());
				return;
			}
			if (source.getName().equals("Year")) {
				calendar.set(Calendar.YEAR, getSelectedYear());
				dayPanel.removeAll();
				this.flushWeekAndDayPanal(calendar);
				dayPanel.revalidate();
				dayPanel.updateUI();
				return;
			}
			if (source.getName().equals("Month")) {
				calendar.set(Calendar.MONTH, getSelectedMonth() - 1);
				dayPanel.removeAll();
				this.flushWeekAndDayPanal(calendar);
				dayPanel.revalidate();
				dayPanel.updateUI();
				return;
			}
		}
		/**
		 * 日期按钮的鼠标事件处理
		 * @param e MouseEvent
		 */
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
				JButton source = (JButton) e.getSource();
				String value = source.getText();
				int day = Integer.parseInt(value);
				calendar.set(Calendar.DAY_OF_MONTH, day);
				Date selectDate = this.getSelectDate();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						pattern);
				CalendarDialog.this
						.setText(simpleDateFormat.format(selectDate));

//				int year = calendar.get(Calendar.YEAR);
//				int month = calendar.get(Calendar.MONTH) + 1;
				// System.out.println(year + "年" + month + "月" + day + "日");
				f.dispose();
			}
		}

		public void mousePressed(MouseEvent e) {
			// 空实现接口中的方法，不能删除
		}

		public void mouseReleased(MouseEvent e) {
			// 空实现接口中的方法，不能删除
		}

		/**
		 * 鼠标移动到日历中的事件 
		 * @param e MouseEvent
		 */
		public void mouseEntered(MouseEvent e) {
			JButton jbutton = (JButton) e.getSource();
			jbutton.setBackground(moveButtonColor);

		}

		/**
		 * 鼠标移出日历中的事件
		 * 
		 * @param e
		 *            MouseEvent
		 */
		public void mouseExited(MouseEvent e) {
			JButton jbutton = (JButton) e.getSource();
			int comm = Integer.parseInt(jbutton.getActionCommand());
			int today = getNowCalendar().get(Calendar.DAY_OF_MONTH);
			if (comm == today) {
				jbutton.setBackground(todayBtnColor);
			} else {
				jbutton.setBackground(palletTableColor);
			}
		}
	}

	/**
	 * 内部类，改变按钮的边框不可编辑区，使外观更加协调。
	 */
	class DateChooserButton extends JButton {
		private static final long serialVersionUID = 1L;

		public DateChooserButton(String text) {
			super(text);
			setPreferredSize(new Dimension(30, 21));
		}

		public Insets getInsets() {
//			return new Insets(0, 0, 0, 0);
			return new Insets(4, 2, 0, 2);
		}

	}

	public static void main(String[] args) {

		JFrame frame2 = new JFrame();
		 frame2.getContentPane().setLayout(null);
		JPanel jp = new JPanel();
		jp.setSize(200, 100);
		JPanel jp1 = new JPanel();
		jp1.setSize(200, 100);
		CalendarDialog date = new CalendarDialog(jp);
		jp.add(date);
		jp1.add(jp);
		frame2.getContentPane().add(jp1);
		frame2.setSize(500, 400);
		frame2.setTitle("实例");
		frame2.setVisible(true);

	}
}