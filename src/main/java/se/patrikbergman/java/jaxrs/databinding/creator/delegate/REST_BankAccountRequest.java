package se.patrikbergman.java.jaxrs.databinding.creator.delegate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class REST_BankAccountRequest {
	private final String account;
	private final String clearingNumber;
	private final REST_Password password;

	@JsonCreator
	public REST_BankAccountRequest(
			@JsonProperty("account") String account,
			@JsonProperty("clearingNumber") String clearingNumber,
			@JsonProperty("password") REST_Password password) {
		this.account = account;
		this.clearingNumber = clearingNumber;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public String getClearingNumber() {
		return clearingNumber;
	}

	public REST_Password getPassword() {
		return password;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("REST_BankAccountRequest{");
		sb.append("account='").append(account).append('\'');
		sb.append(", clearingNumber='").append(clearingNumber).append('\'');
		sb.append(", password=").append("****");
		sb.append('}');
		return sb.toString();
	}
}
