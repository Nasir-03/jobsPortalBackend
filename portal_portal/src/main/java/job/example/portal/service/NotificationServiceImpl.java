package job.example.portal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import job.example.portal.dto.NotificationDTO;
import job.example.portal.dto.NotificationStatus;
import job.example.portal.entity.Notification;
import job.example.portal.mapper.NotificationMapper;
import job.example.portal.repository.NotificationRepository;
import job.example.portal.utility.SequenceGeneratorService;

@Service
public class NotificationServiceImpl implements NotificationService{

	private SequenceGeneratorService sequenceGeneratorService;
	private NotificationRepository notificationRepository;
	
	@Autowired
	public NotificationServiceImpl(SequenceGeneratorService sequenceGeneratorService,
			NotificationRepository notificationRepository) {
		this.sequenceGeneratorService = sequenceGeneratorService;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void sendNotification(NotificationDTO notificationDTO) {
		notificationDTO.setId(sequenceGeneratorService.generateSequence("notification"));
		notificationDTO.setTimeStamp(LocalDateTime.now());
		notificationDTO.setStatus(NotificationStatus.UNREAD);
		notificationRepository.save(NotificationMapper.toEntity(notificationDTO));
	}

	@Override
	public List<Notification> getUnreadNotification(Long userId) {
		return notificationRepository.findByUserIdAndStatus(userId, NotificationStatus.UNREAD);
	}

}
