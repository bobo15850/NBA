package businesslogic.teams;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CalculationOfTeamPerformTest extends TestCase {
	CalculationOfTeamPerform cal=new CalculationOfTeamPerform();
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testAverage() {
		assertEquals(cal.average(52, 7),7.43);
	}

	@Test
	public void testCalWinRate() {
		assertEquals(cal.calWinRate(23, 18),0.56);
	}

	@Test
	public void testCalOffensiveNum() {
		assertEquals(CalculationOfTeamPerform.calOffensiveNum(108, 21, 40, 31, 50, 29),117.29);
	}

	@Test
	public void testCalOffensiveEfficiency() {
		assertEquals(cal.calOffensiveEfficiency(100, 108, 21, 40, 31, 50, 29),85.26);
	}

	@Test
	public void testCalDefensiveEfficiency() {
		assertEquals(cal.calDefensiveEfficiency(100, 108, 21, 40, 31, 50, 29),85.26);
	}

	@Test
	public void testCalOffensiveReboundEfficiency() {
		assertEquals(cal.calOffensiveReboundEfficiency(54, 32),0.63);
	}

	@Test
	public void testCalDefensiveReboundEfficiency() {
		assertEquals(cal.calOffensiveReboundEfficiency(54, 32),0.63);
	}

	@Test
	public void testCalStealEfficiency() {
		assertEquals(cal.calStealEfficiency(100, 108, 21, 40, 31, 50, 29),85.26);
	}

	@Test
	public void testCalAssistRate() {
		assertEquals(cal.calAssistRate(100, 108, 21, 40, 31, 50, 29),85.26);
	}

}
