package se.patrikbergman.java.jaxrs.databinding.enuum;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class DataBindingEnumTest {

	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test // From Java pojo to JSON
	public void marshall() throws IOException {
		Human human = new Human(Sex.HEN, "Gaia");
		String jsonString = mapper.writeValueAsString(human);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test //From JSON to Java pojo
	public void unmarshall() throws IOException {
		String jsonString = new ResourceString("enuum/human.json").toString();
		assertNotNull(jsonString);

		Human human = mapper.readValue(jsonString, Human.class);
		assertNotNull(human);
		System.out.println(human);
	}
}
