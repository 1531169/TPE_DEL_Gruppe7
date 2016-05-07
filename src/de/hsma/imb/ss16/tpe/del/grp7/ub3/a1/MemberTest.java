package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.Test;

public class MemberTest {

	@Test
	public void testGetMemberID() {
		Member myMember1 = new Member(1, "Musterman", "Man", 2);
		int expected = 1;
		int actuals = myMember1.getMemberID();
		Assert.assertEquals(expected, actuals);
	}

	@Test
	public void testGetSurname() {
		Member myMember1 = new Member(2, "Musterman", "Man", 2);
		String expected = "Musterman";
		String actuals = myMember1.getSurname();
		Assert.assertEquals(expected, actuals);
	}

	@Test
	public void testGetFirstname() {
		Member myMember1 = new Member(3, "Musterman", "Man", 2);
		String expected = "Man";
		String actuals = myMember1.getFirstname();
		Assert.assertEquals(expected, actuals);
	}

	@Test
	public void testGetMemberYears() {
		Member myMember1 = new Member(4, "Musterman", "Man", 2);
		int expected = 2;
		int actuals = myMember1.getMemberYears();
		Assert.assertEquals(expected, actuals);
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateMemberIDNegativ() {
		new Member(-1, "Musterman", "Man", 2);
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateSurnameNull() {
		new Member(5, null, "Man", 2);
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateFirstnameNull() {
		new Member(6, "Musterman", null, 2);
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateMemberYearsNegativ() {
		new Member(7, "Musterman", "Man", -2);
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateSurnameEmpty() {
		new Member(8, "", "Man", 2);
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateFirstnameEmpty() {
		new Member(9, "Musterman", "", 2);
	}

	@Test(expected = InvalidParameterException.class)
	public void testCreateSameID() {
		new Member(10, "Musterman", "Man1", 2);
		new Member(10, "Musterman", "Man2", 2);
	}
	
}
