package se.patrikbergman.java.jaxrs.databinding.simple;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

class User {

	public enum Gender { MALE, FEMALE };
	private Gender gender;
	private Name name;
	private boolean isVerified;
	private byte[] userImage;

	public static class Name {
		private String first, last;

		public String getFirst() { return first; }
		public String getLast() { return last; }

		public void setFirst(String first) { this.first = first; }
		public void setLast(String last) { this.last = last; }
	}

	public Name getName() { return name; }
	public boolean isVerified() { return isVerified; }
	public Gender getGender() { return gender; }
	public byte[] getUserImage() { return userImage; }

	public void setName(Name name) { this.name = name; }
	public void setVerified(boolean verified) { this.isVerified = verified; }
	public void setGender(Gender gender) { this.gender = gender; }
	public void setUserImage(byte[] userImage) { this.userImage = userImage; }

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}