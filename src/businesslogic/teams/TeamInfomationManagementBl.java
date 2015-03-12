package businesslogic.teams;

import po.OneTeamPerformanceOfOneSeasonPo;
import vo.OneTeamPerformanceOfOneSeasonVo;
import businesslogicservice.teams.TeamInformationManagementBlService;

import common.ResultMessage;
import common.enums.KindOfTeamData;
import common.enums.TeamName;
import common.mydatastructure.Season;
import common.mydatastructure.team.baseinformation.BaseInformationOfTeam;
import common.mydatastructure.team.matchinformation.AllTeamPerformanceOfOneSeason;
import common.mydatastructure.team.matchinformation.OneTeamPerformanceOfAllSeason;

public class TeamInfomationManagementBl implements TeamInformationManagementBlService {

	public AllTeamPerformanceOfOneSeason getAllTeamPerformanceOfOneSeason(Season season) {
		return new AllTeamPerformanceOfOneSeason(season);
	}

	public OneTeamPerformanceOfAllSeason getOneTeamInformationOfAllSeason(TeamName teamName) {
		return new OneTeamPerformanceOfAllSeason(teamName);
	}

	public OneTeamPerformanceOfOneSeasonVo getOneTeamPerformanceOfOneSeason(TeamName teamName, Season season) {
		OneTeamPerformanceOfOneSeasonPo po = new OneTeamPerformanceOfOneSeasonPo(teamName, season);
		return new OneTeamPerformanceOfOneSeasonVo(po);
	}

	// //////////////////////////////排序
	public ResultMessage ascendingSort(AllTeamPerformanceOfOneSeason data, KindOfTeamData dataKind) {
		return null;
	}

	// ///////////////////////////////排序
	public ResultMessage descendingSort(AllTeamPerformanceOfOneSeason data, KindOfTeamData dataKind) {

		return null;
	}

	@Override
	public BaseInformationOfTeam getBaseInformationOfOneTeam(TeamName teamName) {
		return new BaseInformationOfTeam(teamName);
	}

}
