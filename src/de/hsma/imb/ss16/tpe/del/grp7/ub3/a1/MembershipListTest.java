package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MembershipListTest {

	@Test
	public void test() {
		Member m = new Member(1, "Donkeng", "Ferly", 0); 
		MembershipList list = new MembershipList();
		list.put(m);
		list.put(new Member(200, "Brückner", "Tobias", 4));
		list.put(new Member(400, "Reinhard", "Cedric", 2));
		System.out.print(list.toString());
		MembershipList list2 = new MembershipList();
		// würde deswegen exception werfen!
		
		list2.putIfAbsent(1, m);
		list2.put(new Member(201, "Brückner", "Tobias", 4));
		list2.put(new Member(401, "Reinhard2", "Cedric", 2));
		System.out.print(list2.toString());
		
		list.putAll(list2);
		System.out.println(list.toString());
	}
}
