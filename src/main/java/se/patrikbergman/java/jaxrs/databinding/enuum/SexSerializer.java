package se.patrikbergman.java.jaxrs.databinding.enuum;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

class SexSerializer extends JsonSerializer<Sex> {

	@Override
	public void serialize(Sex sex, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(sex.getName());
	}
}
