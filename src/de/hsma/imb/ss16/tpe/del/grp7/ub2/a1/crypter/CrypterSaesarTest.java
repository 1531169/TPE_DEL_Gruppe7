package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

import org.junit.Assert;
import org.junit.Test;

public class CrypterSaesarTest {

	@Test
	public void testVerschluesseln(){
		char expecteds = 'D';
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		char actuals = cr.verschluesseln('A');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testEntschluesslen(){
		char expecteds = 'W';
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		char actuals = cr.entschluesseln('Z');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testTextVerschuesseln(){
		String expecteds = "DEFGHIJKLMNOPQRSTUVWXYZABC";
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String actuals = "";
		for (int i = 0; i < text.length(); i++) {
			actuals += cr.verschluesseln(text.charAt(i));
		}
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testTextEntschuesseln(){
		String expecteds = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		String text = "DEFGHIJKLMNOPQRSTUVWXYZABC";
		String actuals = "";
		for (int i = 0; i < text.length(); i++) {
			actuals += cr.entschluesseln(text.charAt(i));
		}
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void notAllowedCharVerschluesseln(){
//		char expecteds = 'D';
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		char actuals = cr.verschluesseln('0');
//		Assert.assertEquals(expecteds, actuals);
	}
}
