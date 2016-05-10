package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.security.InvalidParameterException;

import org.junit.Assert;
import org.junit.Test;

public class MembershipListTest extends Assert {
	
	MembershipList list1 = new MembershipList();
	MembershipList list2 = new MembershipList();
	MembershipList list3 = new MembershipList();
	static Member m1 = new Member(1, "Donkeng", "Ferly", 2); 
	static Member m2 = new Member(2, "Brückner", "Tobias", 4);
	static Member m3 = new Member(3, "Reinhard", "Cedric", 2);
		
	static Member m4 = new Member(4, "Vater", "Dein", 3);
	static Member m5 = new Member(5, "Mutter", "Deine", 6);
	
	@Test (expected = InvalidParameterException.class)
	public void putMemberIDAlreadyExistsTest() {
		list1.put(new Member(3, "nicht neu", "Ich bin", 345678));
	}
	
	@Test
	public void putMemberWasntMappedTest() {
		Object expected = null;
		Object actual = list1.put(m1);
		// null because there wasn't anything mapped before
		assertEquals(expected, actual);
	}
	
	@Test
	public void putMemberAgainTest() {
		Object expected = m1;
		list1.put(m1);
		Object actual = list1.put(m1);
		assertEquals(expected, actual);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void putMemberAgainWithDiffIDTest() {
		list1.put(m1);
		list1.put(2, m1);
	}
	
	@Test
	public void putAllTest() {
		list1.put(m1);
		list1.put(m2);
		list1.put(m3);
		list1.put(m4);
		list2.put(m2);
		list2.put(m4);
		list2.putAll(list1);
		assertTrue(list2.size() == list1.size());
	}
	
	@Test (expected = InvalidParameterException.class)
	public void putParamNullTest() {
		list1.put(null);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void putDiffIDTest() {
		list1.put(1, new Member(23, "", "", 3));
	}
	
	@Test
	public void replaceTest() {
		list1.put(m1);
		assertFalse(list1.replace(1, m1, m2));
	}
}
