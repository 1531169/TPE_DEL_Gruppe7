package de.hsma.imb.ss16.tpe.del.grp7.ub3.a1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MembershipList extends HashMap<Integer, Member> 
	implements Map<Integer, Member>, Iterable<Member> {
	
	public Member put(Member member) {
		return this.put(member.getMemberID(), member);
	}
	
	@Override
	public String toString() {
		int maxIDLength = values().stream()
				.mapToInt(Member::getMemberID).max().orElse(1);
		
		Stream<String> sGivennames = values().stream()
				.map(Member::getGivenName);
		int maxGivenname = sGivennames.mapToInt(String::length)
				.max().orElse(1);
		
		Stream<String> sSurnames = values().stream()
				.map(Member::getSurname);
		int maxSurname = sSurnames.mapToInt(String::length)
				.max().orElse(1);
		int maxMembership = values().stream().mapToInt(Member::getMemberYears)
				.max().orElse(1);
		
		// TODO: für alle spalten erstellen
		return String.format("%-"+maxIDLength+"s", "xxxxx");
	}

	@Override
	public Iterator<Member> iterator() {
		return values().iterator();
	}
}
