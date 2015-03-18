package start;

import common.mycomponent.MyFrame;
import data.DataPreparation;
import data_driver.Player_Driver;
import data_driver.Team_Driver;

public class Main {
	public static MyFrame mainFrame;

	public static void main(String arg[]) {
		Player_Driver pd = new Player_Driver();
		pd.testGeneralInfoPo();
		pd.testAllNames();
		pd.testOnePlayerPerformOfOneSeason();
		pd.testOneTeamPerformOfOneSeason();
		Team_Driver td = new Team_Driver();
		td.testAllNames();
		td.testGeneralInfoPo();
		td.testOneTeamPerformOfOneSeason();
		// DataPreparation dataPre = new DataPreparation();
	}
}
