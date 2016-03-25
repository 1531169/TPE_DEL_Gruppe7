package tpe.del.grp7.ub1.a3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * 
 * @author Loic Donkeng
 *
 */

public class KontoTest extends Waehrungen {

	@Test
	public void test() {
		
		Konto ferly = new Konto("ferly loic", dollar );
		Konto cedric = new Konto("Redric R.", euro);
		Konto tobias = new Konto("Tobias Brückner",franken);

		for(int i = 0; i < 5000; i+=100){
			ferly.buche(new Betrag(i ,dollar));
			ferly.buche(new Betrag(-i ,euro));
			cedric.buche(new Betrag(i ,euro));
			cedric.buche(new Betrag(-i ,franken));
			tobias.buche(new Betrag(i ,franken));
			tobias.buche(new Betrag(-i ,dollar));
		}
		System.out.println(ferly.toString());
		System.out.println(cedric.toString());
		System.out.println(tobias.toString());
//		assertNotEquals(ferly,new Konto("ferly loic", dollar ));
	}
	

}
