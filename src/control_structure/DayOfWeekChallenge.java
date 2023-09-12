package control_structure;

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

public class DayOfWeekChallenge {
	
	public static String getDayWeekByLanguage(LocalDate date, Locale locale) {
		return StringUtils.capitalize(
			date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale));
	}
	
	public static void main(String[] args) {
		
		Locale localeBR = new Locale.Builder().setLanguage("pt").setRegion("BR")
			.build();
		Locale localeUS = new Locale("en", "US");
		
		LocalDate date = LocalDate.of(2023, Month.SEPTEMBER, 9);
		
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		
		System.out.println(dayOfWeek.getValue());
		System.out.println(dayOfWeek.ordinal());
		System.out.println(dayOfWeek.name());
		System.out.println(dayOfWeek.getDisplayName(TextStyle.FULL, localeBR));
		System.out.println(getDayWeekByLanguage(date, localeBR));
		
		LocalDate now = LocalDate.now();
		
		System.out.println(new StringBuilder()
			.append(getDayWeekByLanguage(now, localeBR)).append(SPACE)
			.append("(").append(now.getDayOfWeek().getValue()).append(")"));
		
		System.out.println(
			String.format("%s (%d)", getDayWeekByLanguage(now, localeUS),
				now.getDayOfWeek().getValue()));
	}
	
}
