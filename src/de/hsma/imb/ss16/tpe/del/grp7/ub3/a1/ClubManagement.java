package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.util.Iterator;

public class ClubManagement {

	public static void main(String []args) {
		
		test1();
		
	}
	
	public static void test1() {
		
		MembershipList list1 = new MembershipList();		
		
		list1.put(new Member(2, "Mustermann", "Heinz", 16));
		list1.put(new Member(6, "Koch", "Anette", 15));
		list1.put(new Member(5, "Simpson", "Bart", 9));
		list1.put(new Member(3, "Simpson", "Lisa", 5));
		
		System.out.println("Länge der Vereinsliste: " + list1.size());
		
		Iterator<Member> it1 = list1.iterator();
		while(it1.hasNext()){
			System.out.println(it1.next());
		}
		
		list1.remove(2);
		
		MembershipList list2 = new MembershipList();
		
		list2.putAll(list1);
		list2.put(new Member(2, "Simpson", "Lisa", 5));
		
		System.out.println("\nMitglied mit der ID 2 in der ersten Liste: " + list1.get(2));
		System.out.println("Mitglied mit der ID 2 in der zweiten Liste: " + list2.get(2));
		
		list2.get(5).setGivenName("Günter");
		System.out.println(list2.get(5));
		list2.remove(5);
		
		System.out.println("\nErste Liste: ");
		
		Iterator<Member> it2 = list1.iterator();
		while(it2.hasNext()){
			System.out.println(it2.next());
		}
		
		System.out.println("\nZweite Liste: ");
		
		Iterator<Member> it3 = list2.iterator();
		while(it3.hasNext()){
			System.out.println(it3.next());
		}

		list1.clear();
		list2.clear();
		
		System.out.println("\nLänge der ersten Liste: " + list1.size());
		System.out.println("Länge der zweiten Liste: " + list2.size());
	}
}
