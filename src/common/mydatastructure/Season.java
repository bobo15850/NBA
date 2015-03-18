package common.mydatastructure;

public class Season {
	private int startYear;
	private int finishYear;

	public Season(int startYear, int finishYear) {
		this.startYear = startYear;
		this.finishYear = finishYear;
	}

	// 以xxxx-xxxx的形式传入或xx-xx
	public Season(String format) {
		String[] temp = format.split("-");
		this.startYear = this.toFormatYear(temp[0]);
		this.finishYear = this.toFormatYear(temp[1]);
	}

	private int toFormatYear(String year) {
		int formatYear = Integer.parseInt(year);
		if (formatYear < 100) {
			if (formatYear > 50) {
				formatYear += 1900;
			} else {
				formatYear += 2000;
			}
		}
		return formatYear;
	}// 将年份转化为标准格式

	public String getFormatStyleOfSeason() {
		return String.valueOf(this.startYear) + "-" + String.valueOf(this.finishYear);
	}// 得到标准形式的赛季表示格式

	public int getStartYear() {
		return startYear;
	}

	public int getFinishYear() {
		return finishYear;
	}
}
