package common.statics;

import po.GeneralInfoOfPlayerPo;
import po.GeneralInfoOfTeamPo;
import vo.GeneralInfoOfPlayerVo;
import vo.GeneralInfoOfTeamVo;

public class ResultMessage {
	public static final ResultMessage SUCCEED = new ResultMessage();
	public static final ResultMessage EXIST = new ResultMessage();
	public static final ResultMessage NOT_EXIST = new ResultMessage();
	public static final ResultMessage DB_FAULT = new ResultMessage();
	public static final GeneralInfoOfPlayerPo NOTEXIST_GENERAL_PLAYER_PO = new GeneralInfoOfPlayerPo();
	public static final GeneralInfoOfPlayerVo NOTEXIST_GENERAL_PLAYER_VO = new GeneralInfoOfPlayerVo();
	public static final GeneralInfoOfTeamPo NOTEXIST_GENERAL_TEAM_PO = new GeneralInfoOfTeamPo();
	public static final GeneralInfoOfTeamVo NOTEXIST_GENERAL_TEAM_VO = new GeneralInfoOfTeamVo();
}
