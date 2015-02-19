package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class REST_InsecurePasswordTest {
	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test
	public void marshall() throws IOException {
		REST_Password restPassword =  new REST_InsecurePassword("Testar99");
		final String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(restPassword);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void unmarshall() throws IOException {
		final String jsonString = new ResourceString("creator/password.json").toString();
		assertNotNull(jsonString);

		final REST_InsecurePassword restPassword = mapper.readValue(jsonString, REST_InsecurePassword.class);
		assertNotNull(restPassword);
		System.out.println(restPassword);
	}
}
