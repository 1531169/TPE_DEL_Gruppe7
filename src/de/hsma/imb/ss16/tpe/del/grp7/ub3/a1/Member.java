package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * This class represents a club member and his personal data. There is also the
 * opportunity to compare members as this class implements the Comparable
 * Interface.
 * 
 * @author Gruppe 7
 *
 */
public class Member implements Comparable<Member> {

	/**
	 *  Exception String which will be thrown if a ID was already used .
	 */
	private static final String EX_ID_CONFLIC_TEXT = "ID already used ";
	
	/**
	 *  Exception String which will be thrown if a ID or member years are negativ.
	 */
	private static final String EX_ID_OR_YEARS_NOT_ALLOWED_TEXT = "negativ ID or memberYears not allowed";
	
	/**
	 *  Exception String which will be thrown if surname or first name are null or empty .
	 */
	private static final String EX_NOT_ALLOWED_NAME_TEXT = "surname or firstname cannot be null or empty ";

	/**
	 *	list of already used ID as Integer.
	 */
	private static ArrayList<Integer> listId = new ArrayList<>();
	
	/**
	 * represents a members ID.
	 */
	private int memberId;
	
	/**
	 *  represents a members surname
	 */
	private String surname;
	
	/**
	 * represents a members given name
	 */
	private String firstname;
	
	/**
	 *  represents a members years of membership
	 */
	private int memberYears;

	/**
	 * Constructor for class member
	 * 
	 * @param ID
	 *            represents a members ID
	 * @param surname
	 *            represents a members surname
	 * @param firstname
	 *            represents a members given name
	 * @param memberYears
	 *            represents a members years of membership
	 * @throws InvalidParameterException
	 *             will be thrown if given ID is minor than 0
	 */
	public Member(int ID, String surname, String firstname, int memberYears) throws InvalidParameterException {

		if (ID < 0 || memberYears < 0) {
			throw new InvalidParameterException(EX_ID_OR_YEARS_NOT_ALLOWED_TEXT);
		}
		if (listId.contains(ID)) {
			throw new InvalidParameterException(EX_ID_CONFLIC_TEXT + ID);
		}
		if (surname == null || firstname == null) {
			throw new InvalidParameterException(EX_NOT_ALLOWED_NAME_TEXT);
		}
		if (surname == "" || firstname == "") {
			throw new InvalidParameterException();
		}
		listId.add(ID);
		this.memberId = ID;
		this.surname = surname;
		this.firstname = firstname;
		this.memberYears = memberYears;
	}

	/**
	 * Getter-method for surname
	 * 
	 * @return return attribute surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Setter-method for surname
	 * 
	 * @param new value for attribute surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * remove the ID of the intern list when a member is deleted of the HashMap.
	 * 
	 * @param memberId
	 */
	protected static void removeId(Integer memberId) {
		listId.remove(memberId);
	}

	/**
	 * Getter-method for givenName
	 * 
	 * @return return attribute givenName
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Setter-method for givenName
	 * 
	 * @param new value for attribute givenName
	 */
	public void setFirstname(String givenName) {
		this.firstname = givenName;
	}

	/**
	 * Getter-method for memberYears
	 * 
	 * @return return attribute memberYears
	 */
	public int getMemberYears() {
		return memberYears;
	}

	/**
	 * Setter-method for memberYears
	 * 
	 * @param new value for attribute memberYears
	 */
	public void setMemberYears(int memberYears) {
		this.memberYears = memberYears;
	}

	/**
	 * Getter-method for memberID
	 * 
	 * @return return attribute memberID
	 */
	public int getMemberID() {
		return memberId;
	}

	public static ArrayList<Integer> getListId() {
		return listId;
	}

	public int compareTo(Member m) {

		if (this.getMemberID() == m.getMemberID()) {
			return 0;
		}

		else if (this.getMemberID() > m.getMemberID()) {
			return -1;
		}

		else {
			return 1;
		}
	}

	/**
	 * this method compare first names
	 * 
	 * @param other is the Member to compare
	 * 
	 * @return true is they have same first name, else false.
	 */
	public boolean hasSameFirstname(Member other) {
		return this.getFirstname() == other.getFirstname();
	}

	/**
	 * this method compare surnames
	 * 
	 * @param other is the Member to compare
	 * 
	 * @return true is they have same surname, else false.
	 */
	public boolean hasSameSurname(Member other) {
		return this.getSurname() == other.getSurname();
	}
	/**
	 * this method compare Member years.
	 * 
	 * @param other is the member to compare
	 * 
	 * @return true is they have same member years, else false.
	 */
	public boolean hasSameMemBerYears(Member other) {
		return this.getMemberYears() == other.getMemberYears();
	}

	@Override
	public String toString() {
		return memberId + "\t" + firstname + "\t" + surname + "\t" + memberYears;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + memberId;
		result = prime * result + memberYears;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (memberId != other.memberId)
			return false;
		if (memberYears != other.memberYears)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
