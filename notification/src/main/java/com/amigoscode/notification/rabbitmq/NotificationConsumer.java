package com.amigoscode.notification.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.notification.NotificationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {
	private final NotificationService notificationService;
	
	@RabbitListener(queues="${rabbitmq.queue.notification}")
	public void consumer(NotificationRequest notificationRequest) {
		log.info("Consume {} from queue", notificationRequest);
		notificationService.send(notificationRequest);
	}
}