package com.amigoscode.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = { "com.amigoscode.notification", "com.amigoscode.amqp" })
@EnableEurekaClient
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
//		return args -> {
//			producer.publish(new Person("Dinh Phu",30), notificationConfig.getInternalExchange(),
//					notificationConfig.getInternalNotificationRoutingKeys());
//		};
//	}
//
//	@Getter
//	@Setter
//	@AllArgsConstructor
//	static class Person {
//		private String name;
//		private int age;
//	}
}
