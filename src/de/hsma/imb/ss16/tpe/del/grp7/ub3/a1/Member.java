package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

public class Member {
	private int memberID;
	private String surname;
	private String firstname;
	private int memberYears;
	public Member(int memberID, String surname, String givenName, int memberYears) {
		if(memberID < 0){
			throw new InvalidMemberException();
		}
		this.memberID = memberID;
		this.surname = surname;
		this.firstname = givenName;
		this.memberYears = memberYears;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGivenName() {
		return firstname;
	}
	public void setGivenName(String givenName) {
		this.firstname = givenName;
	}
	public int getMemberYears() {
		return memberYears;
	}
	public void setMemberYears(int memberYears) {
		this.memberYears = memberYears;
	}
	public int getMemberID() {
		return memberID;
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
