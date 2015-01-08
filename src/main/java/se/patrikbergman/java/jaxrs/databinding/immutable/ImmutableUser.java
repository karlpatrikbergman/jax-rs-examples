package se.patrikbergman.java.jaxrs.databinding.immutable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class ImmutableUser {

	public enum Gender { MALE, FEMALE };
	private Gender gender;
	private ImmutableName name;
	private boolean isVerified;
	private byte[] userImage;

	@JsonCreator
	public ImmutableUser(
			@JsonProperty("gender") Gender gender,
			@JsonProperty("name") ImmutableName name,
			@JsonProperty("isVerified") boolean isVerified,
			@JsonProperty("userImage") byte[] userImage) {

		this.gender = gender;
		this.name = name;
		this.isVerified = isVerified;
		this.userImage = userImage;
	}



	public ImmutableName getName() { return name; }
	public boolean isVerified() { return isVerified; }
	public Gender getGender() { return gender; }
	public byte[] getUserImage() { return userImage; }

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}