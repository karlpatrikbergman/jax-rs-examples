package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class REST_PasswordChangeRequest {

	private final REST_Password oldPassword;
	private final String newPassword;

	@JsonCreator
	public REST_PasswordChangeRequest(
			@JsonProperty("oldPassword") REST_Password oldPassword,
			@JsonProperty("newPassword") String newPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	public REST_Password getOldPassword() {
		return oldPassword;
	}
	
	@JsonIgnore
	public String getNewPassword() {
		return newPassword;
	}

	@Override
	public String toString() {
		return "REST_PasswordChangeRequest [oldPassword=***, newPassword=***]";
	}

}
