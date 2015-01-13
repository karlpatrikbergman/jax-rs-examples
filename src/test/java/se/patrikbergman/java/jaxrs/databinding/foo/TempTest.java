package se.patrikbergman.java.jaxrs.databinding.foo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class TempTest {
	ObjectMapper mapper;

	@Before
	public void setup() {
		mapper = new ObjectMapper();
	}

	@Test
	public void marshall() throws JsonProcessingException {
		Album album = new Album("Number of the Beast");
		String jsonString = mapper.writeValueAsString(album);
		assertNotNull(jsonString);
		System.out.println(jsonString);
	}

	@Test
	public void unmarshall() throws IOException {
		String jsonString = new ResourceString("foo/album.json").toString();
		assertNotNull(jsonString);
		Album album = mapper.readValue(jsonString, Album.class);
		assertNotNull(album);
	}

}
