package by.stail.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Provides API for working with application properties.
 *
 * @autor Arthur Kushner
 * @since 4/26/17
 */
@Service
public class PropertyService {


    @Value("${mongo.database.name}")
    private String mongoDatabaseName;

    @Value("${mongo.database.url}")
    private String mongoDatabaseUrl;


    public String getMongoDatabaseName() {
        return mongoDatabaseName;
    }

    public void setMongoDatabaseName(String mongoDatabaseName) {
        this.mongoDatabaseName = mongoDatabaseName;
    }

    public String getMongoDatabaseUrl() {
        return mongoDatabaseUrl;
    }

    public void setMongoDatabaseUrl(String mongoDatabaseUrl) {
        this.mongoDatabaseUrl = mongoDatabaseUrl;
    }


}
