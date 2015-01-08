package se.patrikbergman.java.jaxrs;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class MappingTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test
	public void jsonToJava() throws IOException {
		String jsonString = new ResourceString("user.json").toString();
		assertNotNull(jsonString);

		User user = mapper.readValue(jsonString, User.class);
		assertNotNull(user);
		System.out.println(user);
	}


	@Test
	public void javaToJson() throws IOException {
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
}
