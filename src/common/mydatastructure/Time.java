package common.mydatastructure;

public class Time {
	public static int number = 0;

	public static double stringToDouble(String str) {
		String[] part = str.split(":");
		try {
			double result = Double.parseDouble(part[0]) + Double.parseDouble(part[1]);
			return result;
		} catch (NumberFormatException e) {
			System.out.println(str);
			number++;
			return 0.0;
		}
	}
}
