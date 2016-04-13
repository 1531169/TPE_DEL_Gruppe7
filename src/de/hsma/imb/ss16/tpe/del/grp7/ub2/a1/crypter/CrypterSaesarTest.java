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
		char expecteds = 'A';
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		char actuals = cr.entschluesseln('D');
		Assert.assertEquals(expecteds, actuals);
	}
	@Test
	public void testTextVerschuesseln(){
		String expecteds = "D EFGHIJKLMNOPQRSTUVWXYZABC";
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		String text = "A BCDEFGHIJKLMNOPQRSTUVWXYZ";
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
		System.out.println(actuals);
//		Assert.assertEquals(expecteds, actuals);
	}
		
/*
		Key myKey = new Key("C");
		CrypterCaesar cr = new CrypterCaesar(myKey);
		String text1 = "ABCDEFGHIJKLMNOPQRZTUVWXYZ";
		String text2 = "";
		for (int i = 0; i < text1.length(); i++) {
			text2 += cr.verschluesseln(text1.charAt(i));
		}
		System.out.println(text2);
		text1 = "";
		for (int i = 0; i < text2.length(); i++) {
			text1 += cr.entschluesseln(text2.charAt(i));
		}
		System.out.println(text1);

	*/
}
