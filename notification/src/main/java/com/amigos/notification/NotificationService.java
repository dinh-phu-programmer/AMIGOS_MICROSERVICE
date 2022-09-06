package com.amigos.notification;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigoscode.clients.notification.NotificationRequest;

@Service
public class NotificationService {
	private final NotificationRepository repo;
	
	@Autowired
	public NotificationService(NotificationRepository repo) {
		this.repo = repo;
	}

	public void send(NotificationRequest notificationRequest) {
		// TODO Auto-generated method stub
		repo.save(
				Notification.builder()
				.toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerName())
                .sender("Amigoscode")
                .message(notificationRequest.getMessage())
                .sentAt(LocalDateTime.now())
				.build()
				);
	}
	
	
}
