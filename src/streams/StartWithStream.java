package streams;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Person;

public class StartWithStream {
	
	static Logger logger = LogManager.getLogger();
	static ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
	static TimeZone timeZone = TimeZone.getTimeZone(zoneId);
	static Locale aLocale = Locale.of("pt", "BR");
	
	public static void main(String[] args) {
		
		Configurator.initialize(StartWithStream.class.getName(),
				"./src/util/log4j2.properties");
		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, aLocale);
		Instant instant = new GregorianCalendar(timeZone, aLocale).toInstant();
		
		logger.info(() -> String.format("%s%n", df.format(Date.from(instant))));
		
		Person p = new Person(1, "Peter Parker", 'M', 78.8F, 1.73F,
				LocalDate.now().minusYears(17), null);
		
		List<Object> list = Arrays.asList("Tue", 'M', 1, 1F, 1.0E1,
				Date.from(instant), p, p.getAgeWithSymbol());
		
		Iterator<Object> iterator = list.iterator();
		while (iterator.hasNext()) {
			logger.info(iterator::next);
		}
		
		for (Object object : list) {
			logger.info(() -> msg(object));
		}
		
		Stream<Object> stream = list.stream();
		stream.forEach(o -> logger.info(msg(o)));
		
		list.stream().forEach(o -> logger.info(msg(o)));
		
		list.iterator().forEachRemaining(o -> logger.info(msg(o)));
		
	}
	
	static String msg(Object obj) {
		return new StringBuilder().append(obj).append(" - ")
				.append(obj.getClass().getSimpleName()).append("\n").toString();
	}
}
