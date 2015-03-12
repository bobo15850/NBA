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
		this.startYear = Integer.parseInt(temp[0]);
		this.finishYear = Integer.parseInt(temp[1]);
	}

	public String getFormatStyleOfSeason() {
		return String.valueOf(this.startYear % 100) + "-" + String.valueOf(this.finishYear % 100);
	}// 得到标准形式的赛季表示格式
}
