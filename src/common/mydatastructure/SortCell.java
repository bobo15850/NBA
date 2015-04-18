package common.mydatastructure;

import common.statics.Command;

public class SortCell {
	public String field = null;
	public String order = null;

	public SortCell(String str) {
		String[] part = str.split("\\" + Command.dot);
		try {
			field = part[0];
			order = part[1];
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
	}

	public String toString() {
		return field + "." + order;
	}

}
