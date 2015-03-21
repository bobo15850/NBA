package businesslogic.players;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class CalculationOfPlayerPerformTest extends TestCase {
	CalculationOfPlayerPerform cal=new CalculationOfPlayerPerform();
	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void testCalHitRate() {
		assertEquals(CalculationOfPlayerPerform.calHitRate(3, 10),0.3);
	}

	@Test
	public void testCalCommonEfficiency() {
		assertEquals(CalculationOfPlayerPerform.calCommonEfficiency(50.0, 2.0, 3.0,3.0, 4.0,30, 40, 20, 10, 5, 5),-4.6);
	}

	@Test
	public void testCalImproveRateInFiveMatch() {
		assertEquals(cal.calImproveRateInFiveMatch(10, 3),-0.7);
	}

	@Test
	public void testCalGmScEfficiency() {
		assertEquals(CalculationOfPlayerPerform.calGmScEfficiency(150,30,13,43,20,10,15,13,9,17,19,20, 3),52.93);
	}

	@Test
	public void testCalRealHitRate() {
		assertEquals(cal.calRealHitRate(50, 17, 9),1.19);
	}

	@Test
	public void testCalShootEfficiency() {
		assertEquals(CalculationOfPlayerPerform.calShootEfficiency(18, 7, 31),0,69);
	}

	@Test
	public void testCalReboundRate() {
		assertEquals(CalculationOfPlayerPerform.calReboundRate(17, 63, 31, 91, 103),0.04);
	}

	@Test
	public void testCalAssistRate() {
		assertEquals(CalculationOfPlayerPerform.calAssistRate(9, 31, 63, 138, 41),0.03);
	}
	

	@Test
	public void testCalStealRate() {
		assertEquals(CalculationOfPlayerPerform.calStealRate(13, 63, 31, 90),0.06);
	}

	@Test
	public void testCalBlockRate() {
		assertEquals(CalculationOfPlayerPerform.calBlockRate(16, 63, 31, 74),0.09);
	}

	@Test
	public void testCalTurnoverRate() {
		assertEquals(CalculationOfPlayerPerform.calTurnoverRate(21, 18, 9),0.49);
	}

	@Test
	public void testCalUseRate() {
		assertEquals(CalculationOfPlayerPerform.calUseRate(38, 11, 9, 63, 31, 203, 48, 39),0.08);
	}

}
