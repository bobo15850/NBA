package common.mydatastructure;

import common.statics.Age;
import common.statics.Command;
import common.statics.League;
import common.statics.Position;

public class Filter {
	private String position = Position.All;
	private String league = League.All;
	private String age = Age.All;

	public void setFilter(String formatString) {
		String part[] = formatString.split(",");
		String temp[];
		for (int i = 0; i < part.length; i++) {
			temp = part[i].split("\\" + Command.dot);
			if (temp[0].equals(Command.position)) {
				this.position = temp[1];
			}
			else if (temp[0].equals(Command.league)) {
				this.setLeague(temp[1]);
			}
			else if (temp[0].equals(Command.age)) {
				this.setAge(temp[1]);
			}
		}
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String toString() {
		return "position." + this.position + "," + "league." + this.league + "," + "age." + this.age;
	}
}
