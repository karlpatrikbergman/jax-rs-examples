package se.patrikbergman.java.jaxrs.databinding.joda;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.LocalDateTime;

class UserWithTimestamp {

	public enum Gender { MALE, FEMALE };
	private Gender gender;
	private Name name;
	private boolean isVerified;
	private byte[] userImage;
	private LocalDateTime timestamp;

	@JsonCreator
	public UserWithTimestamp(
			@JsonProperty("gender") Gender gender,
			@JsonProperty("name") Name name,
			@JsonProperty("isVerified") boolean isVerified,
			@JsonProperty("userImage") byte[] userImage,
			@JsonProperty("timestamp") LocalDateTime timestamp) {

		this.gender = gender;
		this.name = name;
		this.isVerified = isVerified;
		this.userImage = userImage;
		this.timestamp = timestamp;
	}

	public static class Name {
		private String first, last;

		@JsonCreator
		public Name(
				@JsonProperty("first") String first,
				@JsonProperty("last") String last) {

			this.first = first;
			this.last = last;
		}

		public String getFirst() { return first; }
		public String getLast() { return last; }
	}

	public Name getName() { return name; }
	public boolean isVerified() { return isVerified; }
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