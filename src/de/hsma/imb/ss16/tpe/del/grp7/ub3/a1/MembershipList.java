package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MembershipList extends HashMap<Integer, Member> implements Map<Integer, Member>, Iterable<Member> {
	private static final int TAB_LENGTH = 4;
	private static final int MARGIN_SUM = 4;
	private static final String MARGIN_LEFT = "  ";
	private static final String MARGIN_RIGHT = "  ";
	private static final String BREAK_SIGN = "\n";
	private static final String PRE_SIGN = "%-";
	private static final String POST_SIGN = "s";
	private static final String ROW_DELIMITER_SIGN = "-";
	
	private static final String COL_NAME_ID = "ID";
	private static final String COL_NAME_FIRSTNAME = "Vorname";
	private static final String COL_NAME_SURNAME = "Nachname";
	private static final String COL_NAME_MEMBERSHIP = "Mitgliedsjahre";
	
	private int lengthID;
	private int lengthFN;
	private int lengthSN;
	private int lengthMS;
	private int lengthSum;

	public Member put(Member member) {
		return this.put(member.getMemberID(), member);
	}

	@Override
	public String toString() {
		refreshLengths();
		String delimiter = getDelimiter(lengthSum); 
		
		// add table head row
		String result = delimiter + BREAK_SIGN;
		result += getRow(COL_NAME_ID, COL_NAME_FIRSTNAME, COL_NAME_SURNAME, 
				COL_NAME_MEMBERSHIP);
		result += delimiter + BREAK_SIGN;
		
		// bring every member in the right format
		for(Member m : values()) {
			result += getRow(((Integer)m.getMemberID()).toString(), m.getFirstname(), 
					m.getSurname(), ((Integer)m.getMemberYears()).toString());
		}
		result += delimiter + BREAK_SIGN;
		return result;
	}

	@Override
	public Iterator<Member> iterator() {
		return values().iterator();
	}
	
	private void refreshLengths() {
		lengthID = getMaxIDLength();
		lengthFN = getMaxFirstnameLength();
		lengthSN = getMaxSurnameLength();
		lengthMS = getMaxMembershipLength();
		lengthSum = lengthID + lengthFN + lengthSN + lengthMS + MARGIN_SUM;
	}
	
	private String getRow(String v1, String v2, String v3, String v4) {
		String result = MARGIN_LEFT;
		result += String.format(PRE_SIGN + lengthID + POST_SIGN, v1);
		result += String.format(PRE_SIGN + lengthFN + POST_SIGN, v2);
		result += String.format(PRE_SIGN + lengthSN + POST_SIGN, v3);
		result += String.format(PRE_SIGN + lengthMS + POST_SIGN, v4);
		result += MARGIN_RIGHT + BREAK_SIGN;
		return result;
	}
	
	private String getDelimiter(int length) {
		String delimiter = "";
		for (int i = 0; i < length; i++) {
			delimiter += ROW_DELIMITER_SIGN;
		}
		return delimiter;
	}
	
	private int getMaxIDLength() {
		// get max length of longest ID
		int maxID = values().stream()
				.mapToInt(Member::getMemberID).max().orElse(1);
		int lengthID = new Integer(maxID).toString().length();
		if(lengthID < COL_NAME_ID.length()) {
			lengthID = COL_NAME_ID.length();
		}
		return lengthID + TAB_LENGTH;
	}
	
	private int getMaxFirstnameLength() {
		// get max length of the longest givenname
		int lengthGN = values().stream().map(Member::getFirstname)
				.mapToInt(String::length).max().orElse(1);
		if(lengthGN < COL_NAME_FIRSTNAME.length()) {
			lengthGN = COL_NAME_FIRSTNAME.length();
		}
		return lengthGN + TAB_LENGTH;
	}
	
	private int getMaxSurnameLength() {
		// get max length of the longest surname
		int lengthSN = values().stream().map(Member::getSurname)
				.mapToInt(String::length).max().orElse(1);
		if(lengthSN < COL_NAME_SURNAME.length()) {
			lengthSN = COL_NAME_SURNAME.length();
		}
		return lengthSN + TAB_LENGTH;
	}
	
	private int getMaxMembershipLength() {
		// get max length of the longest membership years
		int maxMembership = values().stream()
				.mapToInt(Member::getMemberYears).max().orElse(1);
		int lengthMS = new Integer(maxMembership).toString().length();
		if(lengthMS < COL_NAME_MEMBERSHIP.length()) {
			lengthMS = COL_NAME_MEMBERSHIP.length();
		}
		return lengthMS;
	}
}
