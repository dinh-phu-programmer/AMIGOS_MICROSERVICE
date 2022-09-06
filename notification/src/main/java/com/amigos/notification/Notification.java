package com.amigos.notification;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Notification {
	@Id
	@SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
	private Integer id;

	private Integer notificationId;
	private Integer toCustomerId;
	private String toCustomerEmail;
	private String sender;
	private String message;
	private LocalDateTime sentAt;

}
