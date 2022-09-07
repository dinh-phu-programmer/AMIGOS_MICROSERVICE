package com.amigoscode.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amigoscode.clients.notification.NotificationRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {
	private final NotificationService service;

	@Autowired
	public NotificationController(NotificationService service) {
		this.service = service;
	}

	@PostMapping
	public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
		log.info("New notification... {}", notificationRequest);
		service.send(notificationRequest);
	}
}
