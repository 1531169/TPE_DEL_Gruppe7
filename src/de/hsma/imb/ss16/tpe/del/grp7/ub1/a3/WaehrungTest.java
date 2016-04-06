package de.hsma.imb.ss16.tpe.del.grp7.ub1.a3;

import org.junit.*;

public class WaehrungTest {
	
	@Test
	public void testUmrechnenToDollar() {
		long expected = 25;
		long actual = Waehrungen.RUBEL.umrechnen(1000, Waehrungen.DOLLAR);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testUmrechnenToOtherWaehrung() {
		long expected = 1207;
		long actual = Waehrungen.EURO.umrechnen(1000, Waehrungen.FRANKEN);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testUmrechnenSameWaehrung() {
		long expected = 1000;
		long actual = Waehrungen.YEN.umrechnen(1000, Waehrungen.YEN);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testToString() {
		String expected = "Euro [€] 1 € = 1,2690 $";
		String actual = Waehrungen.EURO.toString();
		Assert.assertEquals(expected, actual);
	}

}
