package po;

import java.util.Iterator;

public class NamesOfAllPlayerPo implements Iterator<String> {
	private String[] nameOfAllPlayer;
	private int pointer;
	private int numberOfPlayer;

	public NamesOfAllPlayerPo() {
		// ////////////////初始化读取所有的球员姓名
	}

	public String first() {
		this.pointer = 0;
		return nameOfAllPlayer[0];
	}

	public boolean hasNext() {
		return this.pointer < this.numberOfPlayer - 1;
	}

	public String next() {
		this.pointer++;
		return nameOfAllPlayer[pointer];
	}

	public void remove() {
		for (int i = pointer; i < numberOfPlayer - 1; i++) {
			nameOfAllPlayer[i] = nameOfAllPlayer[i + 1];
		}
		numberOfPlayer--;
		pointer--;
	}

}
