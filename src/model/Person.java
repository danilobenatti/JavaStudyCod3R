package model;

import java.time.LocalDate;

import org.apache.commons.lang3.math.NumberUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
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
			return NumberUtils.INTEGER_ZERO;
		}
	}
	
	public String getAgeWithSymbol() {
		String age = getAge().toString();
		return isAlive() ? age.concat(String.valueOf('\u2605'))
			: age.concat(String.valueOf('\u2020'));
	}
}