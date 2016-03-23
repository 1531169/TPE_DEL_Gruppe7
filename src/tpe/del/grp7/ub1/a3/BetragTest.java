package tpe.del.grp7.ub1.a3;

public class BetragTest {
	
	@org.junit.Test
	public void Test()
	{
		Betrag b = new Betrag(-23499L, Waehrungen.euro);
		System.out.println(b.toString());
	}
}
