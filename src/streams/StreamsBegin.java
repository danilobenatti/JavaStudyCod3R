package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsBegin {
	
	public static void main(String[] args) {
		
		Consumer<Object> print = System.out::print;
		
		Stream<String> langsBackEnd = Stream.of("Java ", "C# ", "JS ", "PHP\n");
		langsBackEnd.forEach(print);
		
		String[] langsFrontEnd = { "HTML ", "CSS ", "TypeScript ", "JS\n" };
		Stream.of(langsFrontEnd).forEach(print);
		Arrays.stream(langsFrontEnd).forEach(print);
		Arrays.stream(langsFrontEnd, 1, 3).forEach(print);
		
		List<String> othersLangs = Arrays.asList("Assembly ", "Basic", "C ",
				"C++ ", "Cobol", "Fortran\n");
		othersLangs.stream().forEach(print);
		othersLangs.parallelStream().forEach(print);
		
	}
	
}
