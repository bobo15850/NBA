package common.mydatastructure;

public class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public MyDate(String formatString) {
		String part[] = formatString.split("-");
		this.year = Integer.parseInt(part[0]);
		this.month = Integer.parseInt(part[1]);
		this.day = Integer.parseInt(part[2]);
	}

	public int getYear() {
		return this.year;
	}

	public int getMonth() {
		return this.month;
	}

	public int getDay() {
		return this.day;
	}

	public String getFormatString() {
		return this.year + "-" + this.month + "-" + this.day;
	}
}
