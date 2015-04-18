package businesslogicservice.hotsport;

import java.util.ArrayList;

import test.data.TeamHotInfo;

public interface TeamHotBlService {
	public ArrayList<TeamHotInfo> getTeamHot(int number, String field);// 数据王球队
}
