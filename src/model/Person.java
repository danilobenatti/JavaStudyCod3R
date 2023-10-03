package model;

import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

import java.time.LocalDate;
import java.time.ZoneId;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
	
	public void killPerson() {
		ZoneId zoneid = ZoneId.systemDefault();
		if (deathDate == null) {
			this.deathDate = LocalDate.now(zoneid);
		}
	}
}