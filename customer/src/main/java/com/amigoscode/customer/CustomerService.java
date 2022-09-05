package com.amigoscode.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final RestTemplate restTemplate;
	private final FraudClient fraudClient;

	@Autowired
	public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate, FraudClient fraudClient) {
		this.customerRepository = customerRepository;
		this.restTemplate = restTemplate;
		this.fraudClient = fraudClient;
	}

	public void registerCustomer(CustomerRegistrationRequest request) {
		Customer customer = Customer.builder().firstName(request.getFirstName()).lastName(request.getLastName())
				.email(request.getEmail()).build();

		// TODO: check if email valid

		// TODO: check if email not taken
		// TODO: store customer in db
		customerRepository.saveAndFlush(customer);

		// TODO: check if fraudster
//		FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//				"http://FRAUD/api/v1/fraud-check/{customerId}", FraudCheckResponse.class, customer.getId());
		FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
		if (fraudCheckResponse.getIsFraudster()) {
			throw new IllegalStateException("fraudster");
		}

		// TODO: send notification
	}
}
