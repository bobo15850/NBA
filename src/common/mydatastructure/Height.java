package common.mydatastructure;

public class Height {
	private final double INCH_TO_CENTIMETER = 2.54;
	private final int FEET_TO_INCH = 12;
	private int feetOfHeight;// 英尺
	private int inchOfHeight;// 英寸

	public Height(int feetOfHeight, int inchOfHeight) {
		if (inchOfHeight >= FEET_TO_INCH) {
			this.feetOfHeight = inchOfHeight / FEET_TO_INCH + feetOfHeight;
			this.inchOfHeight = inchOfHeight % FEET_TO_INCH;
		} else {
			this.feetOfHeight = feetOfHeight;
			this.inchOfHeight = inchOfHeight;
		}
	}

	public Height(String formatString) {
		String[] part = formatString.split("-");
		this.feetOfHeight = Integer.parseInt(part[0]);
		this.inchOfHeight = Integer.parseInt(part[1]);
	}

	public int getFeetOfHeight() {
		return this.feetOfHeight;
	}// 英尺数

	public int getInchOfHeight() {
		return this.inchOfHeight;
	}// 英寸数

	public String getFeetAndInchAsStringOfHeight() {
		return this.feetOfHeight + "-" + this.inchOfHeight;
	}// 返回“英尺-英寸”形式的身高字符串

	public double getCentirMeterOfHeight() {
		return (this.FEET_TO_INCH * this.feetOfHeight + this.inchOfHeight) * this.INCH_TO_CENTIMETER;
	}// 返回身高的厘米值
}
