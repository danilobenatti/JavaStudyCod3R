package collection_structure;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackCode {
	
	public static void main(String[] args) {
		
		Deque<String> deque = new ArrayDeque<>();
		
		deque.add("Happy Place");
		deque.add("Yellowface");
		deque.push("Love, Theoretically");
		deque.add("The Little Prince");
		
		for (String str : deque) {
			System.out.println(str);
		}
		
		System.out.println(deque.isEmpty());
		System.out.println(deque.size());
		System.out.println(deque.contains("Yellowface"));
		
		System.out.println(deque.peek());
		System.out.println(deque.element());
		
		System.out.println(deque.poll());
		System.out.println(deque.poll());
		System.out.println(deque.pop());
		System.out.println(deque.remove());
		System.out.println(deque.poll());
	}
	
}
