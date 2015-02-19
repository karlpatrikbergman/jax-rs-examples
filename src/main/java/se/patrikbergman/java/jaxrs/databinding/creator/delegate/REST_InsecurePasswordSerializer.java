package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

class REST_InsecurePasswordSerializer extends JsonSerializer<REST_InsecurePassword> {

	@Override
	public void serialize(REST_InsecurePassword password, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(password.getValue());
	}
}
