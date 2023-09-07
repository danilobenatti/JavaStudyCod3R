package beginners_level;

import java.math.BigDecimal;

public class PrimitiveVsObject {
	
	public static void main(String[] args) {
		
		String str = new String("Text");
		System.out.println(str.toUpperCase());
		
		int a = 123;
		System.out.println(a);
		
		// Wrappers
		Byte b = 100;
		Short s = 10;
		Integer i = Integer.parseInt("1000");
		Long l = 100000L;
		Float f = 100000.5F;
		Double d = 100E205;
		Boolean e = true;
		Character c = '\u0040';
		
		System.out.println(b.byteValue());
		System.out.println(s.shortValue());
		System.out.println(i.intValue());
		System.out.println(l.longValue());
		System.out.println(f.floatValue());
		System.out.println(d.doubleValue());
		System.out.println(e.booleanValue());
		System.out.println(Boolean.parseBoolean("TRUE"));
		System.out.println(c.charValue() + "gmail");
		System.out.println(getUnicodeCharacterOfChar(c));
		System.out.println(BigDecimal.valueOf(d).toEngineeringString());
	}
	
	public static String getUnicodeCharacterOfChar(char ch) {
		return String.format("\\u%04x", (int) ch);
	}
	
}
