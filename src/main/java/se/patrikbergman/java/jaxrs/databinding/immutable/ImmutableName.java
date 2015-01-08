package se.patrikbergman.java.jaxrs.databinding.immutable;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImmutableName {
	private String first, last;

	@JsonCreator
	public ImmutableName(
			@JsonProperty("first") String first,
			@JsonProperty("last") String last) {

		this.first = first;
		this.last = last;
	}

	public String getFirst() { return first; }
	public String getLast() { return last; }
}