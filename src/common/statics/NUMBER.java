package common.statics;

import java.awt.Dimension;
import java.awt.Toolkit;

public class NUMBER {
	public static final int SCREEN_WIDTH = getScreenWidth();// 屏幕的宽度
	public static final int SCREEN_HEIGHT = getScreenHeight();// 屏幕的长度
	public static final int FRAME_HEIGHT = 0;// 窗口的高度
	public static final int FRAME_WIDTH = 0;// 窗口的宽度
	public static final int LINE_OF_PLAYER_BASE_INFO = 19;// 格式化文件中球员基本信息所占行数
	public static final int NUMBER_OF_TEAM = 30;// 球队个数
	public static final int START_MONTH_OF_SEASON = 10;// NBA赛季开始的月份
	public static final int NUMBER_OF_FIRST = 5;// 首发人数

	private static int getScreenWidth() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.width;
	}

	private static int getScreenHeight() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.height;
	}
}
