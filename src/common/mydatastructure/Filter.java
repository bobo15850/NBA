package common.mydatastructure;

import common.statics.Age;
import common.statics.Command;
import common.statics.League;
import common.statics.Position;

public class Filter {
	public String position = Position.All;
	public String league = League.All;
	public String age = Age.All;

	public void setFilter(String formatString) {
		String part[] = formatString.split(",");
		String temp[];
		for (int i = 0; i < part.length; i++) {
			temp = part[i].split("\\" + Command.dot);
			if (temp[0].equals(Command.position)) {
				this.position = temp[1];
			}
			else if (temp[0].equals(Command.league)) {
				this.league = temp[1];
			}
			else if (temp[0].equals(Command.age)) {
				this.age = temp[1];
			}
		}
	}

	public String toString() {
		return "position." + this.position + "," + "league." + this.league + "," + "age." + this.age;
	}
}
