package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import org.junit.Assert;
import org.junit.Test;


public class MemberTest {
	Member myMember = new Member(1,"Musterman","Man", 2);
	
	String fname = "Man";
	int expectedMemberYears = 2;
	
	@Test
	public void testGetMemberID() {
		int expected = 1;
		int actuals = myMember.getMemberID();
		Assert.assertEquals(expected, actuals);
	}
	@Test
	public void testGetSurname() {
		String expected = "Musterman";
		String actuals = myMember.getSurname();
		Assert.assertEquals(expected, actuals);
	}
	@Test
	public void testGetFirstname() {
		String expected = "Man";
		String actuals = myMember.getFirstname();
		Assert.assertEquals(expected, actuals);
	}
	@Test
	public void testGetMemberYears() {
		int expected = 2;
		int actuals = myMember.getMemberYears();
		Assert.assertEquals(expected, actuals);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetMemberIDNegativ() {
		myMember = new Member(-1,"Musterman","Man", 2);
		int actuals = myMember.getMemberID();
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetSurnameNull() {
		String expected = "Musterman";
		String actuals = myMember.getSurname();
		Assert.assertEquals(expected, actuals);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetGivenNameNull() {
		String expected = "Man";
		String actuals = myMember.getFirstname();
		Assert.assertEquals(expected, actuals);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testGetMemberYearsNegativ() {
		int expected = 2;
		int actuals = myMember.getMemberYears();
		Assert.assertEquals(expected, actuals);
	}
}
