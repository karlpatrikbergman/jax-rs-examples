package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class REST_BankAccountRequestTest {

	private ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test // From Java pojo to JSON
	public void marshallWithInsecurePassword() throws IOException {
		final REST_Password restPassword = new REST_InsecurePassword("Testar99");
		final REST_BankAccountRequest bankAccountRequest = new REST_BankAccountRequest("7003038911", "3300", restPassword);
		final String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bankAccountRequest);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test // From Java pojo to JSON
	public void marshallWithSecurePassword() throws IOException {
		final REST_Password restPassword = new REST_Password("Testar99");
		final REST_BankAccountRequest bankAccountRequest = new REST_BankAccountRequest("7003038911", "3300", restPassword);
		final String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(bankAccountRequest);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void unmarshall() throws IOException {
		final String jsonString = new ResourceString("creator/bank-account-request.json").toString();
		assertNotNull(jsonString);

		final REST_BankAccountRequest bankAccountRequest = mapper.readValue(jsonString, REST_BankAccountRequest.class);
		assertNotNull(bankAccountRequest);
		System.out.println(bankAccountRequest);
	}
}
