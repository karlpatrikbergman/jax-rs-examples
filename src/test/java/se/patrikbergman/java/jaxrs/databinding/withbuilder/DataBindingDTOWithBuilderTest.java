package se.patrikbergman.java.jaxrs.databinding.withbuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class DataBindingDTOWithBuilderTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test // From Java pojo to JSON
	public void marshall() throws IOException {
		final User user = new User.Builder()
				.firstName("Patrik")
				.lastName("Bergman")
				.gender(User.Gender.MALE)
				.isVerified(true)
				.phoneNumber(1234567891)
				.build();

		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void unmarshall() throws IOException {
		String jsonString = new ResourceString("withbuilder/user.json").toString();
		assertNotNull(jsonString);
		final User user = mapper.readValue(jsonString, User.class);
		assertNotNull(user);
		System.out.println(user);
	}
}
