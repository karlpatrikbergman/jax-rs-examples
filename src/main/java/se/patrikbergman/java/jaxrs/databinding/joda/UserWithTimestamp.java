package se.patrikbergman.java.jaxrs.databinding.joda;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
class UserWithTimestamp {

	public enum Gender { MALE, FEMALE };
	private Gender gender;
	private ImmutableName name;
	private boolean verified;
	private byte[] userImage;

	@JsonIgnoreProperties(ignoreUnknown = true)
	private LocalDateTime timestamp;

	@JsonCreator
	public UserWithTimestamp(
			@JsonProperty("gender") Gender gender,
			@JsonProperty("name") ImmutableName name,
			@JsonProperty("verified") boolean verified,
			@JsonProperty("userImage") byte[] userImage,
			@JsonProperty("timestamp") LocalDateTime timestamp) {

		this.gender = gender;
		this.name = name;
		this.verified = verified;
		this.userImage = userImage;
		this.timestamp = timestamp;
	}

	public ImmutableName getName() { return name; }
	public boolean isVerified() { return verified; }
	public Gender getGender() { return gender; }
	public byte[] getUserImage() { return userImage; }

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