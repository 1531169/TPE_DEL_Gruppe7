package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MembershipList extends HashMap<Integer, Member> implements Map<Integer, Member>, Iterable<Member> {
	private enum Column {
		ID("ID"), 
		FIRSTNAME("Vorname"),
		SURNAME("Nachname"),
		MEMBERSHIP("Mitgliedjahre");
		
		private String name;
		private Column(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public int getNameLength() {
			return name.length();
		}
	}
	
	private static final int TAB_LENGTH = 4;
	private static final int DEFAULT_LENGTH = 1;
	private static final String MARGIN_LEFT = "  ";
	private static final String MARGIN_RIGHT = "  ";
	private static final String BREAK_SIGN = "\n";
	private static final String PRE_SIGN = "%-";
	private static final String POST_SIGN = "s";
	private static final String ROW_DELIMITER_SIGN = "-";
	
	private static final String EX_STRING_INVALID_COLNAME = "The given column does not exist.";
	private static final String EX_STRING_DIFFERENT_KEYS = "The given ID is different to the ID of the member.";
	private static final String EX_STRING_PARAM_IS_NULL = "One or more parameter are null.";
	
	private int lengthID;
	private int lengthFN;
	private int lengthSN;
	private int lengthMS;
	private int lengthSum;
	
	@Override
	public Member put(Integer id, Member member) {
		checkID(id, member);
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
		checkID(id, member);
		return super.putIfAbsent(id, member);
	}
	
	private void checkID(Integer id, Member member) {
		if(id == null || member == null) {
			throw new InvalidParameterException(EX_STRING_PARAM_IS_NULL);
		}
		if (id != member.getMemberID()) {
			throw new InvalidParameterException(EX_STRING_DIFFERENT_KEYS);
		}
	}

	public Member put(Member member) {
		return this.put(member.getMemberID(), member);
	}
	
	@Override
	public Member remove(Object id) {
		Member.removeId(id);
		return super.remove(id);
	}
	
	@Override
	public Member replace(Integer id, Member member) {
		checkID(id, member);
		return super.replace(id, member);
	}
	
	@Override
	public boolean replace(Integer key, Member oldValue, Member newValue) {
		// könnte überschreiben!!
		return super.replace(key, oldValue, newValue);
	}

	@Override
	public String toString() {
		refreshLengths();
		String delimiter = getDelimiter(lengthSum); 
		
		// add table head row
		String result = delimiter;
		result += getRow(Column.ID.getName(), Column.FIRSTNAME.getName(), 
				Column.SURNAME.getName(), Column.MEMBERSHIP.getName());
		result += delimiter;
		
		// bring every member in the right format
		for(Member m : values()) {
			result += getRow(((Integer)m.getMemberID()).toString(), m.getFirstname(), 
					m.getSurname(), ((Integer)m.getMemberYears()).toString());
		}
		result += delimiter;
		return result;
	}

	@Override
	public Iterator<Member> iterator() {
		return values().iterator();
	}
	
	private void refreshLengths() {
		// refresh local vars
		lengthID = getLengthFrom(Column.ID);
		lengthFN = getLengthFrom(Column.FIRSTNAME);
		lengthSN = getLengthFrom(Column.SURNAME);
		lengthMS = getLengthFrom(Column.MEMBERSHIP);
		// sum all lengths
		lengthSum = lengthID + lengthFN + lengthSN + lengthMS;
		lengthSum += MARGIN_LEFT.length() + MARGIN_RIGHT.length();
	}
	
	private String getRow(String cell1, String cell2, String cell3, String cell4) {
		String result = MARGIN_LEFT;
		result += String.format(PRE_SIGN + lengthID + POST_SIGN, cell1);
		result += String.format(PRE_SIGN + lengthFN + POST_SIGN, cell2);
		result += String.format(PRE_SIGN + lengthSN + POST_SIGN, cell3);
		result += String.format(PRE_SIGN + lengthMS + POST_SIGN, cell4);
		result += MARGIN_RIGHT + BREAK_SIGN;
		return result;
	}
	
	private String getDelimiter(int length) {
		String delimiter = "";
		for (int i = 0; i < length; i++) {
			delimiter += ROW_DELIMITER_SIGN;
		}
		return delimiter + BREAK_SIGN;
	}
	
	private int getLengthFrom(Column colname) {
		int length = 1;
		switch (colname) {
		case ID:
			// get max length of longest ID
			length = new Integer(getIDLength()).toString().length();
			break;
		case FIRSTNAME:
			// get max length of the longest firstname
			length = getFSLength();
			break;
		case SURNAME:
			// get max length of the longest surname
			length = getSNLength();
			break;
		case MEMBERSHIP:
			// get max length of the longest membership years
			length = new Integer(getMSLength()).toString().length();
			break;
		default:
			throw new InvalidParameterException(EX_STRING_INVALID_COLNAME);
		}
		
		if(length < colname.getNameLength()) {
			length = colname.getNameLength();
		}
		return length + TAB_LENGTH;
	}
	
	private int getIDLength() {
		return values().stream()
				.mapToInt(Member::getMemberID).max().orElse(DEFAULT_LENGTH);
	}
	
	private int getFSLength() {
		return values().stream().map(Member::getFirstname)
				.mapToInt(String::length).max().orElse(DEFAULT_LENGTH);
	}
	
	private int getSNLength() {
		return values().stream().map(Member::getSurname)
				.mapToInt(String::length).max().orElse(DEFAULT_LENGTH);
	}
	
	private int getMSLength() {
		return values().stream()
				.mapToInt(Member::getMemberYears).max().orElse(DEFAULT_LENGTH);
	}
}
