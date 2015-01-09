package se.patrikbergman.java.jaxrs.databinding.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * Data Binding converts JSON to and from POJOs based either on property accessor conventions or annotations.
 * There are two variants: simple and full data binding
 * - Simple data binding means converting to and from Java Maps, Lists, Strings, Numbers, Booleans and nulls
 * - Full data binding means converting to and from any Java bean type (as well as "simple" types mentioned above)
 */

public class DataBindingSimpleTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test // From Java pojo to JSON
	public void marshall() throws IOException {
		User user = new User();
		User.Name name = new User.Name();
		name.setFirst("Trent");
		name.setLast("Raznor");
		user.setName(name);
		user.setGender(User.Gender.MALE);
		user.setUserImage("somerandomstring".getBytes());
		user.setVerified(false);

		String jsonString = mapper.writeValueAsString(user);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void unmarshall() throws IOException {
		String jsonString = new ResourceString("user.json").toString();
		assertNotNull(jsonString);

		User user = mapper.readValue(jsonString, User.class);
		assertNotNull(user);
		System.out.println(user);
	}
}
