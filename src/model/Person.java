package model;

import static java.time.format.DateTimeFormatter.ofLocalizedDate;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder(builderMethodName = "personBuilder")
public class Person {
	
	@Include
	private long id;
	
	private String name;
	
	private char gender;
	
	private float weight;
	
	private float height;
	
	private LocalDate bornDate;
	
	private LocalDate deathDate;
	
	public boolean isAlive() {
		return this.deathDate == null;
	}
	
	public Integer getAge() {
		if (deathDate == null) {
			return LocalDate.now().minusYears(bornDate.getYear()).getYear();
		} else if (!isAlive() && deathDate.compareTo(bornDate) > 0) {
			// 'deathDate' occurs after 'bornDate'
			return deathDate.minusYears(bornDate.getYear()).getYear();
		} else {
			return INTEGER_ZERO;
		}
	}
	
	public String getAgeWithSymbol() {
		String age = getAge().toString();
		return isAlive() ? age.concat(String.valueOf('\u2605'))
			: age.concat(String.valueOf('\u2020'));
	}
	
	public void killPersonNow() {
		if (this.bornDate != null && this.deathDate == null
			&& LocalDate.now().compareTo(this.bornDate) >= 0) {
			this.deathDate = LocalDate.now(ZoneId.systemDefault());
		}
	}
	
	public void killPersonAtDate(LocalDate date) {
		if (this.bornDate != null && this.deathDate == null
			&& date.compareTo(this.bornDate) >= 0) {
			this.deathDate = date;
		}
	}
	
	public void killPersonAtDate(Date date) {
		LocalDate killDate = date.toInstant().atZone(ZoneId.systemDefault())
			.toLocalDate();
		if (this.bornDate != null && this.deathDate == null
			&& killDate.compareTo(this.bornDate) >= 0) {
			this.deathDate = killDate;
		}
	}
	
	public void killPersonAtDate(Date date, ZoneId zoneid) {
		LocalDate killDate = date.toInstant().atZone(zoneid).toLocalDate();
		if (this.bornDate != null && this.deathDate == null
			&& killDate.compareTo(this.bornDate) >= 0) {
			this.deathDate = killDate;
		}
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = ofLocalizedDate(FormatStyle.SHORT)
			.localizedBy(Locale.getDefault());
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", height=");
		builder.append(height);
		builder.append(", bornDate=");
		builder.append(bornDate != null ? bornDate.format(dtf) : null);
		builder.append(", deathDate=");
		builder.append(deathDate != null ? deathDate.format(dtf) : null);
		builder.append("]");
		return builder.toString();
	}
}