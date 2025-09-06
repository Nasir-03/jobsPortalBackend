package job.example.portal.mapper;

import java.time.LocalDateTime;

import job.example.portal.dto.NotificationDTO;
import job.example.portal.entity.Notification;

public class NotificationMapper {

	public static Notification toEntity(NotificationDTO dtos) {
		return new Notification(
				dtos.getId(),
				dtos.getUserId(),
				dtos.getMessage(),
				dtos.getAction(),
				dtos.getRoute(),
				dtos.getStatus(),
				dtos.getTimeStamp());
				
	}
	
	public static NotificationDTO toDto(Notification notification) {
		return new NotificationDTO(
				notification.getId(),
				notification.getUserId(),
				notification.getMessage(),
				notification.getAction(),
				notification.getRoute(),
				notification.getStatus(),
				notification.getTimeStamp());
				
	}
}
