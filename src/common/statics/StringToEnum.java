package common.statics;

import common.enums.TeamName;

public class StringToEnum {
	public static TeamName toTeamName(String str) {
		switch (str) {
		case "ATL":
			return TeamName.ATL;
		case "BKN":
			return TeamName.BKN;
		case "BOS":
			return TeamName.BOS;
		case "CHA":
			return TeamName.CHA;
		case "CHI":
			return TeamName.CHI;
		case "CLE":
			return TeamName.CLE;
		case "DAL":
			return TeamName.DAL;
		case "DEN":
			return TeamName.DEN;
		case "DET":
			return TeamName.DET;
		case "GSW":
			return TeamName.GSW;
		case "HOU":
			return TeamName.HOU;
		case "IND":
			return TeamName.IND;
		case "LAC":
			return TeamName.LAC;
		case "LAL":
			return TeamName.LAL;
		case "MEN":
			return TeamName.MEN;
		case "MIA":
			return TeamName.MIA;
		case "MIL":
			return TeamName.MIL;
		case "MIN":
			return TeamName.MIN;
		case "NOP":
			return TeamName.NOP;
		case "OKC":
			return TeamName.OKC;
		case "ORL":
			return TeamName.ORL;
		case "PHI":
			return TeamName.PHI;
		case "PHX":
			return TeamName.PHX;
		case "POR":
			return TeamName.POR;
		case "SAC":
			return TeamName.SAC;
		case "SAS":
			return TeamName.SAS;
		case "TOR":
			return TeamName.TOR;
		case "UTA":
			return TeamName.UTA;
		case "WAS":
			return TeamName.WAS;
		default:
			return null;
		}
	}
}
