package se.patrikbergman.java.jaxrs.databinding.enuum;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SexDeserializer extends JsonDeserializer<Sex> {

	@Override
	public Sex deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {
		return Sex.fromName(parser.getValueAsString());
	}
}
