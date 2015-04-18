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

		// int a = Integer.parseInt(String.valueOf(this.year) +
		// String.valueOf(this.month) + String.valueOf(this.day));
		// int b = Integer.parseInt(String.valueOf(o.year) +
		// String.valueOf(o.month) + String.valueOf(o.day));
		// if (a > b) {
		// return -1;
		// }
		// else if (a < b) {
		// return 1;
		// }
		// else {
		// return 0;
		// }
		// 测试哪种方式更加高效

	}

	// public static void main(String arg[]) {
	// MyDate d1 = new MyDate(13, 2, 3);
	// MyDate d2 = new MyDate(13, 3, 5);
	// long starTime = System.currentTimeMillis();
	// for (int i = 0; i < 100000; i++) {
	// System.out.println(d1.compareTo(d2));
	// }
	// long finishTime = System.currentTimeMillis();
	// System.out.println(finishTime - starTime);
	// }
}
