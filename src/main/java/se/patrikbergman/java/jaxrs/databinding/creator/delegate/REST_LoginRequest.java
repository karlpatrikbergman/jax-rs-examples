package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class REST_LoginRequest {

	private final String username;
	private final REST_Password password;
	private final String challengeResponse;

	/**
	 * Note that REST_Password user delegate based @JsonCreator. To create a REST_Password json for password must
	 * have the form "some-password"
	 */
	@JsonCreator
	public REST_LoginRequest(@JsonProperty("username") String username,
							 @JsonProperty("password") REST_Password password,
							 @JsonProperty("challengeResponse") String challengeResponse) {
		this.username = username;
		this.password = password;
		this.challengeResponse = challengeResponse;
	}

	public String getUsername() {
		return username;
	}

	public REST_Password getPassword() {
		return password;
	}

	public String getChallengeResponse() {
		return challengeResponse;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("REST_LoginRequest{");
		sb.append("username='").append(username).append('\'');
		sb.append(", password='").append("*****").append('\'');
		sb.append(", challengeResponse='").append(challengeResponse).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
