package common.statics;

import common.enums.Conference;
import common.enums.Division;
import common.enums.PlayerPosition;

public class StringToEnum {
	public static Conference toConference(String str) {
		if (str.equals("E") || str.equals("EASTERN")) {
			return Conference.EASTERN;
		} else if (str.equals("W") || str.equals("WESTERN")) {
			return Conference.WESTERN;
		} else {
			return null;
		}
	}

	public static Division toDivision(String str) {
		if (str.equals("Southeast")) {
			return Division.Southeast;
		} else if (str.equals("Atlantic")) {
			return Division.Atlantic;
		} else if (str.equals("Central")) {
			return Division.Central;
		} else if (str.equals("Northwest")) {
			return Division.Northwest;
		} else if (str.equals("Pacific")) {
			return Division.Pacific;
		} else if (str.equals("Southwest")) {
			return Division.Southwest;
		} else {
			return null;
		}
	}

	public static PlayerPosition toPosition(String str) {
		if (str.equals("C")) {
			return PlayerPosition.C;
		} else if (str.equals("G")) {
			return PlayerPosition.G;
		} else if (str.equals("F")) {
			return PlayerPosition.F;
		} else if (str.equals("C-G") || str.equals("C_G")) {
			return PlayerPosition.C_G;
		} else if (str.equals("C-F") || str.equals("C_F")) {
			return PlayerPosition.C_F;
		} else if (str.equals("G-C") || str.equals("G_C")) {
			return PlayerPosition.G_C;
		} else if (str.equals("G-F") || str.equals("G_F")) {
			return PlayerPosition.G_F;
		} else if (str.equals("F-C") || str.equals("F_C")) {
			return PlayerPosition.F_C;
		} else if (str.equals("F-G") || str.equals("F_G	")) {
			return PlayerPosition.F_G;
		} else {
			return null;
		}
	}

	public static int toMonthInt(String month) {
		if (month.equals("JAN")) {
			return 1;
		} else if (month.equals("FEB")) {
			return 2;
		} else if (month.equals("MAR")) {
			return 3;
		} else if (month.equals("APR")) {
			return 4;
		} else if (month.equals("MAY")) {
			return 5;
		} else if (month.equals("JUN")) {
			return 6;
		} else if (month.equals("JUL")) {
			return 7;
		} else if (month.equals("AUG")) {
			return 8;
		} else if (month.equals("SEP")) {
			return 9;
		} else if (month.equals("QCT")) {
			return 10;
		} else if (month.equals("NOV")) {
			return 11;
		} else if (month.equals("DEC")) {
			return 12;
		} else {
			return 0;
		}
	}
	
	public static boolean ToBoolean(String str){
		if(str.equals("true")){
			return true;
		}else {
			return false;
		}
	}
}
