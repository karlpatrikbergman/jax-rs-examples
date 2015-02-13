package se.patrikbergman.java.jaxrs.databinding.creator.delegate;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class REST_Password {

	private final String value;

	/**
	 * Expects a String value to create java pojo. Take a look at password.json in corresponding test, json should be
	 * only:
	 *
	 * "some-password-here"
	 *
	 * and NOT:
	 *
	 * {
	 *     "value" : "some-password-here"
	 * }
	 *
	 * This also have impact on bigger json structures containing REST_Password
	 *
	 */
	@JsonCreator
	public REST_Password(String value) {
		this.value = value;
	}

	// Get the password value.
	public String getValue() {
		return value;
	}

	// Does not return the internal string value. Prevent unintentional logging of password
	@JsonValue
	@Override
	public String toString() {
		return "SECRET";
	}

}
