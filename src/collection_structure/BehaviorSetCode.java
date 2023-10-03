package collection_structure;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class BehaviorSetCode {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		set.add("Anna");
		set.add("Olaf");
		set.add("Elza");
		set.add("Esven");
		
		for (String str : set) {
			System.out.println(str);
		}
		
		SortedSet<String> sortedSet = new TreeSet<>();
		sortedSet.add("Anna");
		sortedSet.add("Olaf");
		sortedSet.add("Elza");
		sortedSet.add("Esven");
		
		for (String str : sortedSet) {
			System.out.println(str);
		}
		
		Set<Integer> dayWeek = new TreeSet<>();
		dayWeek.add(DayOfWeek.SUNDAY.getValue());
		dayWeek.add(DayOfWeek.THURSDAY.getValue());
		dayWeek.add(DayOfWeek.MONDAY.getValue());
		dayWeek.add(DayOfWeek.TUESDAY.getValue());
		dayWeek.add(DayOfWeek.WEDNESDAY.getValue());
		dayWeek.add(DayOfWeek.FRIDAY.getValue());
		dayWeek.add(DayOfWeek.SATURDAY.getValue());
		
		for (Integer integer : dayWeek) {
			System.out.println(DayOfWeek.of(integer)
				.getDisplayName(TextStyle.FULL, Locale.of("pt", "BR")));
		}
		
	}
	
}
