package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class REST_LoginRequestTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test // From Java pojo to JSON
	public void marshall() throws IOException {
		final REST_Password restPassword = new REST_Password("Testar99");
		final REST_LoginRequest restLoginRequest = new REST_LoginRequest("Test-user", restPassword, null);
		final String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(restLoginRequest);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void unmarshall() throws IOException {
		final String jsonString = new ResourceString("creator/login-request.json").toString();
		assertNotNull(jsonString);

		final REST_LoginRequest restLoginRequest = mapper.readValue(jsonString, REST_LoginRequest.class);
		assertNotNull(restLoginRequest);
		System.out.println(restLoginRequest);
	}
}
