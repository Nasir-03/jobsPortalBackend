package job.example.portal.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import job.example.portal.entity.User;

import java.security.PublicKey;
import java.util.List;


@Repository
public interface UserRepository extends MongoRepository<User, Long>{

    public boolean existsByEmail(String email);	
    public User findByEmail(String email);	
}
