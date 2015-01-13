package se.patrikbergman.java.jaxrs.databinding.enuum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class Human {
	private final Sex sex;
	private final String name;

	@JsonCreator
	public Human(
			@JsonProperty("sex")Sex sex,
			@JsonProperty("name") String name) {
		this.sex = sex;
		this.name = name;
	}

	public Sex getSex() {
		return sex;
	}

	public String getName() {
		return name;
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
