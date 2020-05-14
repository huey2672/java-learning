package com.huey.learning.java.common.clone.deepcopy.copyconstructor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person entity
 *
 * @author huey
 */
@Data
@AllArgsConstructor
public class Person {

	private String firstName;
	private String lastName;

	/**
	 * copy constructor
	 * 
	 * @param person
	 */
	public Person(Person person) {
		this(person.getFirstName(), person.getLastName());
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

}
