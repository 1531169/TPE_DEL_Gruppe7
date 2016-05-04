package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MembershipListTest {

	@Test
	public void test() {
		MembershipList list = new MembershipList();
		list.put(new Member(1, "Donkeng", "Ferly", 0));
		list.put(new Member(2, "Brückner", "Tobias", 4));
		list.put(new Member(4, "Reinhard", "Cedric", 2));
		
		System.out.println(list.toString());
	}

}
