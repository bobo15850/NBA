package common.mydatastructure;

import common.statics.Command;

public class SortCell {
	private String field = null;
	private String order = null;

	public SortCell(String str) {
		String[] part = str.split("\\" + Command.dot);
		try {
			field = part[0];
			order = part[1];
		} catch (IndexOutOfBoundsException i) {
			i.printStackTrace();
		}
	}

	public void setField(String field) {
		this.field = field;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getField() {
		return this.field;
	}

	public String getOrder() {
		return this.order;
	}

	public String toString() {
		return field + "." + order;
	}

}
