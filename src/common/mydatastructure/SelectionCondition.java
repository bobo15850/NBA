package common.mydatastructure;

import common.enums.Conference;
import common.enums.Division;
import common.enums.PerformanceOfPlayer;
import common.enums.PlayerPosition;

/*
 * 该类为筛选条件
 */
public class SelectionCondition {
	private PlayerPosition position;
	private Conference conference;
	private Division division;
	private PerformanceOfPlayer performance;

	public SelectionCondition(PlayerPosition position, Conference conference, Division division,
			PerformanceOfPlayer performance) {
		this.position = position;
		this.conference = conference;
		this.division = division;
		this.performance = performance;
	}// 约定conference和division只能有一个,其他的一个为null

	public PlayerPosition getPosition() {
		return position;
	}

	public Conference getConference() {
		return conference;
	}

	public Division getDivision() {
		return division;
	}

	public PerformanceOfPlayer getPerformance() {
		return performance;
	}

}
