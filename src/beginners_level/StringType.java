package beginners_level;

import static java.text.NumberFormat.getCurrencyInstance;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class StringType {
	
	public static void main(String[] args) {
		
		String str = "Hello".concat(SPACE).concat("world") + "!";
		System.out.println(str);
		System.out.println(str.charAt(11));
		System.out.println(str.indexOf("!"));
		System.out.println(str.charAt(str.length() - 1));
		System.out.println(str.toLowerCase().startsWith("hell"));
		System.out.println(str.endsWith(String.valueOf('\u0021'))); // '!'
		System.out.println(str.equalsIgnoreCase("Hello World!"));
		
		var txt = "Values by locale";
		var num = 10.0;
		System.out.println(StringUtils.join(txt).concat(SPACE)
			.concat(String.format(Locale.getDefault(), "%.3f", num)));
		
		Locale localeBR = new Locale.Builder().setLanguage("pt").setRegion("BR")
			.build();
		
		NumberFormat cfBR = getCurrencyInstance(localeBR);
		NumberFormat cfUS = getCurrencyInstance(Locale.of("en", "US"));
		
		System.out.println(StringUtils.join(txt).concat(SPACE)
			.concat(String.format("%s", cfBR.format(num))));
		
		System.out.println(StringUtils.join(txt).concat(SPACE)
			.concat(String.format(Locale.US, "%.2f", num)));
		
		System.out.println(StringUtils.join(txt).concat(SPACE)
			.concat(String.format("%s", cfUS.format(num))));
	}
	
}
