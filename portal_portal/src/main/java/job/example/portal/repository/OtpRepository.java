package job.example.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import job.example.portal.entity.Otp;
import java.time.LocalDateTime;


@Repository
public interface OtpRepository extends MongoRepository<Otp, String>{
	List<Otp> findByCreationTimeBefore(LocalDateTime expiry);
}
