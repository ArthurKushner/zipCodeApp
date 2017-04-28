package by.stail.data.repository;

import by.stail.data.entities.ZipCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * @autor Arthur Kushner
 * @since 4/26/17
 */
@Repository
public interface ZipCodeRepository extends MongoRepository<ZipCode, Long> {

    @Query("{}")
    Stream<ZipCode> findAllAsStream();
}
