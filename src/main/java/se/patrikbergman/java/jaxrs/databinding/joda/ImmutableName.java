package se.patrikbergman.java.jaxrs.databinding.joda;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class ImmutableName {
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

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}