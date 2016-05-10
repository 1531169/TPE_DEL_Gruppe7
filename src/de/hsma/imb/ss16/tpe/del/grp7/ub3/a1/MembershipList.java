package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("serial")
public class MembershipList extends HashMap<Integer, Member> 
	implements Map<Integer, Member>, Iterable<Member> {
	
	/**
	 * Defines the distance to the left.
	 */
	private static final String MARGIN_LEFT = "  ";
	/**
	 * Defines the code to make a new line in a String.
	 */
	private static final String BREAK_SIGN = "\n";
	/**
	 * Defines the prepart of the code to set a length
	 * in the String.format-Method.
	 */
	private static final String PRE_SIGN = "%-";
	/**
	 * Defines the postpart of the code to set a length
	 * in the String.format-Method.
	 */
	private static final String POST_SIGN = "s";
	/**
	 * Defines the sign to which is used for the seperator lines.
	 */
	private static final String ROW_DELIMITER_SIGN = "-";
	
	/**
	 * Name of the column id.
	 */
	private static final String ID_COLNAME = "ID";
	/**
	 * Width of the column id.
	 */
	private static final int ID_MAX_LENGTH = 16;
	/**
	 * Name of the column firstname.
	 */
	private static final String FIRSTNAME_COLNAME = "Vorname";
	/**
	 * Width of the column firstname.
	 */
	private static final int FIRSTNAME_MAX_LENGTH = 32;
	/**
	 * Name of the column surname.
	 */
	private static final String SURNAME_COLNAME = "Nachname";
	/**
	 * Width of the column surname.
	 */
	private static final int SURNAME_MAX_LENGTH = 32;
	/**
	 * Name of the column memberyears.
	 */
	private static final String MEMBERSHIP_COLNAME = "Mitgliedsjahre";
	/**
	 * Width of the column membership.
	 */
	private static final int MEMBERSHIP_MAX_LENGTH = 16;
	
	/**
	 * Exception String which will be thrown if a ID was different to the ID of an Object.
	 */
	private static final String EX_STRING_DIFFERENT_KEYS = "The given ID is different to the ID of the member.";
	/**
	 * Exception String which will be thrown if any object is null.
	 */
	private static final String EX_STRING_PARAM_IS_NULL = "One or more parameter are null.";
	
	/**
	 * Adds a Member to the MembershipList if the member does 
	 * not already exist.
	 * 
	 * @param member
	 *            Member to add
	 * @return the previous value associated with key, or null if there was no
	 *         mapping for key. (A null return can also indicate that the map
	 *         previously associated null with key, if the implementation
	 *         supports null values.)
	 */
	public Member put(Member member) {
		if(member == null) {
			throw new InvalidParameterException(EX_STRING_PARAM_IS_NULL);
		}
		return this.put(member.getMemberID(), member);
	}
	
	@Override
	public Member put(Integer id, Member member) {
		checkMemberAndID(id, member);
		return super.put(id, member);
	}
	
	@Override
	public void putAll(Map<? extends Integer, ? extends Member> m) {
		m.forEach((id, member) -> {
			this.put(id, member);
		});
	}
	
	@Override
	public Member putIfAbsent(Integer id, Member member) {
		checkMemberAndID(id, member);
		return super.putIfAbsent(id, member);
	}
	
	/**
	 * Checks whether the id or the member is not null and throws depending on
	 * that an exception. Also it will throws an exception if the id and the id
	 * from the member is different to each other.
	 * 
	 * @param id
	 *            ID of the member
	 * @param member
	 *            member object
	 */
	private void checkMemberAndID(Integer id, Member member) {
		if(id == null || member == null) {
			throw new InvalidParameterException(EX_STRING_PARAM_IS_NULL);
		}
		if (id != member.getMemberID()) {
			throw new InvalidParameterException(EX_STRING_DIFFERENT_KEYS);
		}
	}
	
	@Override
	public Member remove(Object id) {
		Member.removeId((Integer)id);
		return super.remove(id);
	}
	
	@Override
	public Member replace(Integer id, Member member) {
		checkMemberAndID(id, member);
		return super.replace(id, member);
	}
	
	@Override
	public boolean replace(Integer key, Member oldValue, Member newValue) {
		// könnte überschreiben!!
		return super.replace(key, oldValue, newValue);
	}
	
	@Override
	public void clear() {
		// removes all used ID's in the Member class 
		values().forEach(m -> Member.removeId(m.getMemberID()));
		super.clear();
	}

	@Override
	public String toString() {
		// gets seperator row
		String delimiter = getDelimiter(); 
		
		// add seperator row
		String result = delimiter;
		// add table head row
		result += getRow(ID_COLNAME, FIRSTNAME_COLNAME, 
				SURNAME_COLNAME, MEMBERSHIP_COLNAME);
		// add seperator row
		result += delimiter;
		
		// bring every member in the right format
		for(Member m : values()) {
			result += getRow(((Integer)m.getMemberID()).toString(), 
					m.getFirstname(), m.getSurname(), 
					((Integer)m.getMemberYears()).toString());
		}
		// add seperator row
		result += delimiter;
		return result;
	}

	@Override
	public Iterator<Member> iterator() {
		return values().iterator();
	}
	
	/**
	 * Depending on the values in the hashmap, it creates a row of the values of
	 * a member.
	 * 
	 * @param cell1
	 *            value of the first cell
	 * @param cell2
	 *            value of the second cell
	 * @param cell3
	 *            value of the third cell
	 * @param cell4
	 *            value of the fourth cell
	 * @return complete row as String
	 */
	private String getRow(String cell1, String cell2, 
			String cell3, String cell4) {
		String result = MARGIN_LEFT;
		result += String.format(PRE_SIGN + ID_MAX_LENGTH 
			+ POST_SIGN, cell1);
		result += String.format(PRE_SIGN + FIRSTNAME_MAX_LENGTH 
			+ POST_SIGN, cell2);
		result += String.format(PRE_SIGN + SURNAME_MAX_LENGTH 
			+ POST_SIGN, cell3);
		result += String.format(PRE_SIGN + MEMBERSHIP_MAX_LENGTH 
			+ POST_SIGN, cell4);
		result += BREAK_SIGN;
		return result;
	}
	
	/**
	 * Creates a row seperator in form of the defines sign in the class. It
	 * takes the complete width of the table and creates the seperator String
	 * with a break sign("\n") at the end.
	 * 
	 * @param length
	 *            length of table
	 * @return seperator String
	 */
	private String getDelimiter() {
		int length = MARGIN_LEFT.length() + ID_MAX_LENGTH + FIRSTNAME_MAX_LENGTH
				+ SURNAME_MAX_LENGTH + MEMBERSHIP_MAX_LENGTH;
		String delimiter = "";
		for (int i = 0; i < length; i++) {
			delimiter += ROW_DELIMITER_SIGN;
		}
		return delimiter + BREAK_SIGN;
	}	
}
