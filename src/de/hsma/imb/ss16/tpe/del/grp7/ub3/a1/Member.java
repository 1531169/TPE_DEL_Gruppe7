package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.security.InvalidParameterException;

/**
 * This class represents a club member and his personal data.
 * There is also the opportunity to compare members as this
 * class implements the Comparable Interface.
 * 
 * @author Gruppe 7
 *
 */
public class Member implements Comparable<Member>{
	
	private int memberID;
	private String surname;
	private String firstname;
	private int memberYears;
	
	/**
	 * Constructor for class member
	 * 
	 * @param memberID  represents a members ID
	 * @param surname  represents a members surname
	 * @param givenName  represents a members given name
	 * @param memberYears  represents  a members years of membership
	 * @throws InvalidParameterException  
	 * 		will be thrown if given ID is minor than 0
	 */
	public Member(int memberID, String surname, String givenName, int memberYears) throws InvalidParameterException {
		
		if(memberID < 0){
			throw new InvalidParameterException();
		}
		this.memberID = memberID;
		this.surname = surname;
		this.firstname = givenName;
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
	 * Getter-method for givenName
	 * 
	 * @return return attribute givenName
	 */
	public String getGivenName() {
		return firstname;
	}
	
	/**
	 * Setter-method for givenName
	 * 
	 * @param new value for attribute givenName
	 */
	public void setGivenName(String givenName) {
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
		return memberID;
	}
		
	public int compareTo(Member m) {
		
		if(this.getMemberID() == m.getMemberID()) {
			return 0;
		}
		
		else if(this.getMemberID() > m.getMemberID()) {
			return -1;
		}
		
		else {
			return 1;
		}		
	}
	
	@Override
	public String toString() {
		return memberID + "\t" + firstname + "\t\t" + surname
				+ "\t" + memberYears;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + memberID;
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
		if (memberID != other.memberID)
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
