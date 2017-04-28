package by.stail.data.repository;

import by.stail.data.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @autor Arthur Kushner
 * @since 4/26/17
 */

public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{}")
    Stream<User> findAllUsers();

    User findByUserName(String userName);

    Optional<User> findUserByUserNameAndPassword(String userName, String password);

    Optional<User> findUserById(ObjectId userId);

}
