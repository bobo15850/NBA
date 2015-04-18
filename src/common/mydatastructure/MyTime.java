package common.mydatastructure;

import businesslogic.players.CalculationOfPlayerPerform;

public class MyTime implements Comparable<MyTime> {
	private int minute;
	private int second;
	private boolean isCorrectRead;

	public MyTime() {
		this.minute = 0;
		this.second = 0;
		this.isCorrectRead = true;
	}

	public MyTime(MyTime time) {
		this.minute = time.minute;
		this.second = time.second;
		this.isCorrectRead = time.isCorrectRead;
	}// 拷贝构造函数

	public MyTime(String str) {
		try {
			String part[] = str.split(":");
			this.minute = Integer.parseInt(part[0]);
			this.second = Integer.parseInt(part[1]);
			this.isCorrectRead = true;
		} catch (Exception e) {
			this.isCorrectRead = false;
			this.minute = 0;
			this.second = 0;
		}
	}// 根据字符串初始化

	public void plus(MyTime time) {
		if (this.isCorrectRead) {
			if (time.isCorrectRead) {
				int totalSeconds = this.second + time.second;
				this.second = totalSeconds % 60;
				this.minute = this.minute + time.minute + totalSeconds / 60;
			}
		}
	}// 时间相加

	public void minus(MyTime time) {
		if (this.isCorrectRead) {
			if (time.isCorrectRead) {
				if (this.compareTo(time) >= 0) {
					if (this.second < time.second) {
						this.second += 60;
						this.minute -= 1;
					}
					this.second -= time.second;
					this.minute -= time.minute;
				}
				else {
					int tempMinute = time.minute;
					int tempSecond = time.second;
					if (time.second < this.second) {
						tempSecond = time.second + 60;
						tempMinute = time.minute - 1;
					}
					this.second = tempSecond - this.second;
					this.minute = tempMinute - this.minute;
				}
			}
		}
	}// 时间相减，只计算两者的时间差

	public void divide(int num) {
		if (num != 0) {
			if (this.isCorrectRead) {
				this.second = this.second + (this.minute % num) * 60;
				this.minute /= num;
				this.second /= num;
			}
		}
	}// 时间等分

	public boolean isCorrectRead() {
		return this.isCorrectRead;
	}// 判断是否正确初始化

	public String getTimeFormatString() {
		if (this.isCorrectRead) {
			String minuteString = String.valueOf(this.minute);
			String secondString = String.valueOf(this.second);
			if (this.second < 10) {
				secondString = "0" + secondString;
			}
			return minuteString + ":" + secondString;
		}
		else {
			return null;
		}
	}// 得到xx:xx的形式

	public double getTimeAsMinute() {
		double result = (double) this.minute + (double) this.second / 60.0;
		return CalculationOfPlayerPerform.cutToTwo(result);
	}// 得到以分钟为单位的时间表示形式

	public int getTimeAsSecond() {
		return this.minute * 60 + this.second;
	}// 得到以秒为单位的时间表示形式

	public void setTime(MyTime time) {
		this.second = time.second;
		this.minute = time.minute;
		this.isCorrectRead = time.isCorrectRead;
	}// 设置时间

	public int compareTo(MyTime time) {
		if (this.minute > time.minute) {
			return 1;
		}
		else if (this.minute == time.minute) {
			if (this.second > time.second) {
				return 1;
			}
			else if (this.minute == time.minute) {
				return 0;
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}// 两个时间比较

	public double divide(MyTime time) {
		if (this.isCorrectRead && time.isCorrectRead) {
			double firstNum = this.minute * 60 + this.second;
			double secondNum = time.minute * 60 + time.second;
			return firstNum / secondNum;
		}
		return 0;
	}// 时间相除
}
