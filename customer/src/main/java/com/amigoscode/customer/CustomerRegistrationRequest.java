package com.amigoscode.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRegistrationRequest {
	private String firstName;
	private String lastName;
	private String email;

	public CustomerRegistrationRequest(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
}
