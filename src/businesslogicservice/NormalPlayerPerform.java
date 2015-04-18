package businesslogicservice;

import test.data.PlayerNormalInfo;

public interface NormalPlayerPerform extends PlayerPerform {
	public double getPerformance(PlayerNormalInfo playerNormal);
}
