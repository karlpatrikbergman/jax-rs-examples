package se.patrikbergman.java.jaxrs.databinding.enuum;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@JsonSerialize(using = SexSerializer.class)
@JsonDeserialize(using = SexDeserializer.class)
//@JsonFormat(shape=JsonFormat.Shape.OBJECT) Not needed in this case since I have a custom serializer
enum Sex implements Serializable {

	MARE("male", "M"),
	FEMALE("female", "F"),
	HEN("hen", "H"),
	UNKNOWN(null, "");

	private final String name;
	private final String code;

	private Sex(String name, String code) {
		this.name = name;
		this.code = code;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	public static Sex fromName(final String name) {
		for (Sex sex : Sex.values()) {
			if (sex.name.equalsIgnoreCase(name)) {
				return sex;
			}
		}
		return UNKNOWN;
	}

	public static Sex fromCode(final String infoCode) {
		for (Sex sex : Sex.values()) {
			if (sex.code.equalsIgnoreCase(infoCode)) {
				return sex;
			}
		}
		return UNKNOWN;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}