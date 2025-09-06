package job.example.portal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import job.example.portal.entity.Profile;

public interface ProfileRepository extends MongoRepository<Profile, Long>{

}
