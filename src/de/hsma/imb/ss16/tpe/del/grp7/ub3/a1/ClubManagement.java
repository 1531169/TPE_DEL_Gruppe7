package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

/**
 * This class represents a test environment for the club 
 * software to demonstrate its use
 * 
 * @author Gruppe 7
 *
 */
public class ClubManagement {

	public static void main(String []args) {
		
		test1();
		
	}
	
	/**
	 * In this method there are some example actions 
	 * to demonstrate the use of the club software
	 */
	public static void test1() {
		
		MembershipList list1 = new MembershipList();		
		
		list1.put(new Member(2, "Mustermann", "Heinz", 16));
		list1.put(new Member(6, "Koch", "Anette", 15));
		list1.put(new Member(5, "Simpson", "Bart", 9));
		list1.put(new Member(3, "Simpson", "Lisa", 5));
		
		System.out.println("Länge der Vereinsliste: " + list1.size());
		
		System.out.println(list1);
		
		Member.removeId(2);
		list1.remove(2);
		
		MembershipList list2 = new MembershipList();
		
		list2.putAll(list1);
		list2.put(new Member(2, "Simpson", "Lisa", 5));
		
		System.out.println("\nMitglied mit der ID 2 in der ersten Liste: " + list1.get(2));
		System.out.println("Mitglied mit der ID 2 in der zweiten Liste: " + list2.get(2));
		
		list2.get(5).setFirstname("Günter");
		System.out.println(list2.get(5));

		list2.remove(5);
			
		System.out.println("\nErste Liste: ");
		
		System.out.println(list1);
		
		System.out.println("\nZweite Liste: ");
		
		System.out.println(list2);

		list1.clear();
		list2.clear();
		
		System.out.println("\nLänge der ersten Liste: " + list1.size());
		System.out.println("Länge der zweiten Liste: " + list2.size());
	}
}
