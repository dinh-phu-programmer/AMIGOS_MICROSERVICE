package com.amigoscode.customer;

import org.springframework.stereotype.Service;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.notification.NotificationClient;
import com.amigoscode.clients.notification.NotificationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final FraudClient fraudClient;
	private final NotificationClient notificationClient;

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
		notificationClient.sendNotification(new NotificationRequest(customer.getId(), customer.getEmail(),
				String.format("Hi %s, welcome to Amigoscode...", customer.getFirstName())));
	}
}
