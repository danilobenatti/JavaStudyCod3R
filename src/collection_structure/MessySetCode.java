package collection_structure;

import java.util.HashSet;
import java.util.Set;

public class MessySetCode {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		HashSet set = new HashSet(); // Avoid this approach.
		set.add(1.2); // double -> Double
		set.add(true); // boolean -> Boolean
		set.add("Test"); // String
		set.add(1); // int -> Integer
		set.add('X'); // char -> Character
		
		String message = "Size of 'set': %d%n";
		System.out.printf(message, set.size());
		
		set.add("Test");
		set.add('x');
		
		System.out.printf(message, set.size());
		
		System.out.println("Remove 'test'? " + set.remove("test"));
		System.out.println("Remove 'Test'? " + set.remove("Test"));
		System.out.println("If contains 'x' then remove 'x'? "
			+ (set.contains('x') && set.remove('x')));
		System.out.println("Contains 'x'? " + set.contains('x'));
		System.out.println("Contains 1.2(float)? " + set.contains(1.2f));
		System.out.println("Contains 1.2(double)? " + set.contains(1.2));
		System.out.printf(message, set.size());
		
		Set numbers = new HashSet();
		numbers.add(1.1);
		numbers.add(1.2);
		numbers.add(1.3);
		
		System.out.println(numbers);
		System.out.println(set);
		
		System.out.println(set.addAll(numbers));
		System.out.println(set);
		System.out.println(set.retainAll(numbers)); // common values, intersection
		System.out.println(set);
		
		set.clear();
		System.out.println(set);
	}
	
}
