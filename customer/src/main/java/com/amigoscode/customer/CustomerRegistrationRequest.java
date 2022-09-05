package com.amigoscode.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistrationRequest {
	private String firstName;
	private String lastName;
	private String email;

//	public CustomerRegistrationRequest(String firstName, String lastName, String email) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//	}
}
