package by.javaguru.jdmik12.accountingservice.repository;

import by.javaguru.jdmik12.accountingservice.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByRequestId(String requestId);
}
