package common.mydatastructure;

public class Weight {
	private final double POUND_TO_KILOGRAM = 0.453592;
	private int pound;// 体重的磅数

	public Weight(int pound) {
		this.pound = pound;
	}

	public int getPoundOfWeight() {
		return this.pound;
	}// 体重磅数

	public double getKilogramOfWeight() {
		return this.pound * this.POUND_TO_KILOGRAM;
	}// 体重千克数
}
