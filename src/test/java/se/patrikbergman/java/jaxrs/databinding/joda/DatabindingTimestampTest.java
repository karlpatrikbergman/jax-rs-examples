package se.patrikbergman.java.jaxrs.databinding.joda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class DatabindingTimestampTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test
	public void marshall() throws IOException {
		UserWithTimestamp.Name name = new UserWithTimestamp.Name("Sheila", "Escovedo");
		String jsonString = mapper.writeValueAsString(name);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test
	public void marshallImmutableUser() throws IOException {
		UserWithTimestamp.Name name = new UserWithTimestamp.Name("Sheila", "Escovedo");
		UserWithTimestamp user = new UserWithTimestamp(UserWithTimestamp.Gender.FEMALE, name, true, "somevalue".getBytes(), LocalDateTime.now());
		String jsonString = mapper.writeValueAsString(user);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}
}
