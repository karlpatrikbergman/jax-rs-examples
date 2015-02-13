package se.patrikbergman.java.jaxrs.databinding.withbuilder;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonDeserialize(builder = User.Builder.class)
class User {
	public enum Gender { MALE, FEMALE };
	private final Gender gender;
	private final boolean verified;
	private final String firstName;
	private final String lastName;
	private final long phoneNumber;

	public Gender getGender() {
		return gender;
	}

	public boolean isVerified() {
		return verified;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	private User(Builder builder) {
		gender = builder.gender;
		verified = builder.verified;
		firstName = builder.firstName;
		lastName = builder.lastName;
		phoneNumber = builder.phoneNumber;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@JsonPOJOBuilder(buildMethodName = "build")
	public static final class Builder {
		private Gender gender;
		private boolean verified;
		private String firstName;
		private String lastName;
		private long phoneNumber;
//
//		public Builder() {
//		}

		@JsonProperty("gender")
		public Builder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		@JsonProperty("verified")
		public Builder isVerified(boolean verified) {
			this.verified = verified;
			return this;
		}
		@JsonProperty("firstName")
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		@JsonProperty("lastName")
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		@JsonProperty("phoneNumber")
		public Builder phoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}