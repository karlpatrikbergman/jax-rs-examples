package se.patrikbergman.java.jaxrs.databinding.joda;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.LocalDateTime;

class NameWithTimestamp {
	private String first, last;
	private LocalDateTime timestamp;

	@JsonCreator
	public NameWithTimestamp(
			@JsonProperty("first") String first,
			@JsonProperty("last") String last,
			@JsonProperty("timestamp") LocalDateTime timestamp) {

		this.first = first;
		this.last = last;
	}

	public String getFirst() { return first; }
	public String getLast() { return last; }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}