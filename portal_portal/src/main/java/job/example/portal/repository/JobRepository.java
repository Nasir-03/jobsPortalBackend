package job.example.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import job.example.portal.entity.Job;

public interface JobRepository extends MongoRepository<Job, Long>{
     public List<Job> findByPostedBy(Long postedBy);
}
