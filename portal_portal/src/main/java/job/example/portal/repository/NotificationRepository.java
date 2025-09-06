package job.example.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import job.example.portal.dto.NotificationStatus;
import job.example.portal.entity.Notification;

public interface NotificationRepository extends MongoRepository<Notification, Long>{

	public List<Notification> findByUserIdAndStatus(Long userId,NotificationStatus status);
}
