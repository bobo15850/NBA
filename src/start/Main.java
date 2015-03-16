package start;

import common.mycomponent.MyFrame;
import common.mydatastructure.Time;
import data.DataPreparation;

public class Main {
	public static MyFrame mainFrame;

	public static void main(String arg[]) {
		DataPreparation d = new DataPreparation();
		System.out.println(Time.number);
	}
}
