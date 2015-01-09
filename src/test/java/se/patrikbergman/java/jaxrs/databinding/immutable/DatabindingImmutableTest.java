package se.patrikbergman.java.jaxrs.databinding.immutable;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class DatabindingImmutableTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test
	public void marshallName() throws IOException {
		ImmutableName name = new ImmutableName("Sheila", "Escovedo");
		String jsonString = mapper.writeValueAsString(name);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test
	public void marshallImmutableUser() throws IOException {
		ImmutableName name = new ImmutableName("Sheila", "Escovedo");
		ImmutableUser user = new ImmutableUser(ImmutableUser.Gender.FEMALE, name, true, "somevalue".getBytes());
		String jsonString = mapper.writeValueAsString(user);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void unmarshallName() throws IOException {
		String jsonString = new ResourceString("name.json").toString();
		assertNotNull(jsonString);
		System.out.println(jsonString);

		ImmutableName name = mapper.readValue(jsonString, ImmutableName.class);
		assertNotNull(name);
		System.out.println(name);
	}

	@Test //From JSON to Java pojo
	public void umarshallImmutableUser() throws IOException {
		String jsonString = new ResourceString("user.json").toString();
		ImmutableUser user = mapper.readValue(jsonString, ImmutableUser.class);
		System.out.println(jsonString);
	}
}
