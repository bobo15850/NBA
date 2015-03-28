package common.mydatastructure;

public class Time {
	public static int number = 0;

	public static double stringToDouble(String str) {
		String[] part = str.split(":");
		try {
			double result = Double.parseDouble(part[0]) + Double.parseDouble(part[1]) / 60;
			return result;
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}
}
