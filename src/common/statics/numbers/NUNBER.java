package common.statics.numbers;

import java.awt.Dimension;
import java.awt.Toolkit;

public class NUNBER {
	public static final int SCREEN_WIDTH = getScreenWidth();// 屏幕的宽度
	public static final int SCREEN_HEIGHT = getScreenHeight();// 屏幕的长度
	public static final int FRAME_HEIGHT = 0;// 窗口的高度
	public static final int FRAME_WIDTH = 0;// 窗口的宽度

	private static int getScreenWidth() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.width;
	}

	private static int getScreenHeight() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		return screenSize.height;
	}
}
