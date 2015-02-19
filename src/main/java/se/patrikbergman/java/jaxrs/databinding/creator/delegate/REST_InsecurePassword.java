package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = REST_InsecurePasswordSerializer.class)
public class REST_InsecurePassword extends REST_Password {

	public REST_InsecurePassword(String value) {
		super(value);
	}

	@Override
	public String toString() {
		return getValue();
	}

}
