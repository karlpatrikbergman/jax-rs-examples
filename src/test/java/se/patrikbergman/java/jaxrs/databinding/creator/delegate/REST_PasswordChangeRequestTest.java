package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class REST_PasswordChangeRequestTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test // From Java pojo to JSON == Serialize
	public void marshall_REST_PasswordChangeRequest() throws IOException {
		final REST_Password restPassword = new REST_Password("Testar123");
		final REST_PasswordChangeRequest passwordChangeRequest = new REST_PasswordChangeRequest(restPassword, "Testar321");
		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(passwordChangeRequest);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo == Deserialize
	public void unmarshall_REST_PasswordChangeRequest() throws IOException {
		String jsonString = new ResourceString("creator/change-password-request.json").toString();
		assertNotNull(jsonString);

		REST_PasswordChangeRequest passwordChangeRequest = mapper.readValue(jsonString, REST_PasswordChangeRequest.class);
		assertNotNull(passwordChangeRequest);
		System.out.println(passwordChangeRequest);
	}
}
