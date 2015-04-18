package common.mydatastructure;

public class GeneralInfoOfOneMatch {
	private MyDate date;
	private String firstTeamName;
	private String secondTeamName;
	private int firstTeamScore;
	private int SecondTeamScore;
	private int[] firstTeamQuarterScore;
	private int[] secondTeamQuarterScore;

	public MyDate getDate() {
		return date;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}

	public String getFirstTeamName() {
		return firstTeamName;
	}

	public void setFirstTeamName(String firstTeamName) {
		this.firstTeamName = firstTeamName;
	}

	public String getSecondTeamName() {
		return secondTeamName;
	}

	public void setSecondTeamName(String secondTeamName) {
		this.secondTeamName = secondTeamName;
	}

	public int getFirstTeamScore() {
		return firstTeamScore;
	}

	public void setFirstTeamScore(int firstTeamScore) {
		this.firstTeamScore = firstTeamScore;
	}

	public int getSecondTeamScore() {
		return SecondTeamScore;
	}

	public void setSecondTeamScore(int secondTeamScore) {
		SecondTeamScore = secondTeamScore;
	}

	public int[] getFirstTeamQuarterScore() {
		return firstTeamQuarterScore;
	}

	public void setFirstTeamQuarterScore(int[] firstTeamQuarterScore) {
		this.firstTeamQuarterScore = firstTeamQuarterScore;
	}

	public int[] getSecondTeamQuarterScore() {
		return secondTeamQuarterScore;
	}

	public void setSecondTeamQuarterScore(int[] secondTeamQuarterScore) {
		this.secondTeamQuarterScore = secondTeamQuarterScore;
	}
}
