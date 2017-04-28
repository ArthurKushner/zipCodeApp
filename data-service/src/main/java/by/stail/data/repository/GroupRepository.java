package by.stail.data.repository;

import by.stail.data.entities.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @autor Arthur Kushner
 * @since 4/28/17
 */
@Repository
public interface GroupRepository extends MongoRepository<Group,String> {
}
