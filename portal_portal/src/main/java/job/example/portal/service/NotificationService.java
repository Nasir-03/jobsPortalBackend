package job.example.portal.service;

import java.util.List;

import job.example.portal.dto.NotificationDTO;
import job.example.portal.entity.Notification;

public interface NotificationService {

	public void sendNotification(NotificationDTO notificationDTO);
    public List<Notification> getUnreadNotification(Long userId);
}
