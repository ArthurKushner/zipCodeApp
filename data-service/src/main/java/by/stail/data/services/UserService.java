package by.stail.data.services;

import by.stail.data.entities.Group;
import by.stail.data.entities.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @autor Arthur Kushner
 * @since 4/26/17
 */
@Service
public interface UserService {

    User createNewUser(User user);

    Stream<User> getAllUsers();

    Optional<User> findUserById(ObjectId userId);

    Optional<User> findUserByName(String userName);

    Optional<User> findUserByNameAndPassword(String userName, String password);

    /**
     * Returns {@link Group} to which current user is belong
     *
     * @param userId id for current session
     * @return {@link Group} for current user. If user is not authorized
     * he will be matched with the GUEST group
     */
    String getUserGroup(ObjectId userId);

}
