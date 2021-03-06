package se.patrikbergman.java.jaxrs.databinding.joda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class DatabindingTimestampTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
	}

	@Test // From Java pojo to JSON
	public void marshallUserWithTimestamp() throws IOException {
		UserWithTimestamp user = new UserWithTimestamp(UserWithTimestamp.Gender.FEMALE,
				new NameWithTimestamp("Sheila", "Escovedo", new LocalDateTime("2015-01-08T16:22:38")), true, "somevalue".getBytes(),
				new LocalDateTime("2015-01-08T16:22:38"));
		String jsonString = mapper.writeValueAsString(user);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void umarshallUserWithTimestamp() throws IOException {
		String jsonString = new ResourceString("joda/user-with-timestamp.json").toString();
		assertNotNull(jsonString);

		UserWithTimestamp user = mapper.readValue(jsonString, UserWithTimestamp.class);
		System.out.println(user);
	}
}
