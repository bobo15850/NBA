package common.mydatastructure;

public class MyDate implements Comparable<MyDate> {
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

	public int compareTo(MyDate o) {

		if (this.year == o.year) {
			if (this.month == o.month) {
				if (this.day == o.day) {
					return 0;
				}
				else if (this.day > o.day) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else if (this.month > o.month) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if (this.year > o.year) {
			return 1;
		}
		else {
			return -1;
		}
	}

	public MyDate toPreDate() {
		MyDate preDate = new MyDate(this.year, this.month, this.day);
		if (preDate.day > 1) {
			preDate.day--;
		}
		else {
			if (preDate.month == 5 || preDate.month == 7 || preDate.month == 10 || preDate.month == 12) {
				preDate.day = 30;
				preDate.month--;
			}
			else if (preDate.month == 2 || preDate.month == 4 || preDate.month == 6 || preDate.month == 8 || preDate.month == 9
					|| preDate.month == 11) {
				preDate.day = 31;
				preDate.month--;
			}
			else if (preDate.month == 1) {
				preDate.day = 31;
				preDate.month = 12;
				preDate.year--;
			}
			else if (preDate.month == 3) {
				preDate.day = 28;
				preDate.month--;
			}
		}
		return preDate;
	}

	public MyDate toNextDate() {
		MyDate nextDate = new MyDate(this.year, this.month, this.day);
		if (nextDate.day < 28 || nextDate.day == 29) {
			nextDate.day++;
		}
		else {
			if (nextDate.day == 28) {
				if (nextDate.month == 2) {
					nextDate.day = 1;
					nextDate.month = 3;
				}
				else {
					nextDate.day++;
				}
			}
			else if (nextDate.day == 30) {
				if (nextDate.month == 1 || nextDate.month == 3 || nextDate.month == 5 || nextDate.month == 7 || nextDate.month == 8
						|| nextDate.month == 10 || nextDate.month == 12) {
					nextDate.day++;
				}
				else if (nextDate.month == 4 || nextDate.month == 6 || nextDate.month == 9 || nextDate.month == 11) {
					nextDate.month++;
					nextDate.day = 1;
				}
			}
			else if (nextDate.day == 31) {
				if (nextDate.month == 12) {
					nextDate.year++;
					nextDate.month = 1;
					nextDate.day = 1;
				}
				else {
					nextDate.month++;
					nextDate.day = 1;
				}
			}
		}
		return nextDate;
	}
}
