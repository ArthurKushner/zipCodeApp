package by.stail.data.config;

import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.inject.Inject;

/**
 * Configuration gor MongoDB
 *
 * @autor Arthur Kushner
 * @since 4/11/17
 */
@Configuration
@ComponentScan("by.stail.data")
@EnableMongoRepositories(basePackages = "by.stail.data.repository")
public class SimpleMongoConfiguration extends AbstractMongoConfiguration {

    @Inject
    PropertyService propertyService;

    @Override
    protected String getDatabaseName() {
        return propertyService.getMongoDatabaseName();
    }

    @Override
    public Mongo mongo() throws Exception {

        return new MongoClient(propertyService.getMongoDatabaseUrl());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory(), mongoConverter());
    }


    /**
     * Converter to do mapping of domain objects to {@link DBObject}.
     */
    @Bean(name = "mappingMongoConverter")
    public MappingMongoConverter mongoConverter() throws Exception {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        MongoMappingContext mappingContext = new MongoMappingContext();
        mappingContext.afterPropertiesSet();
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mappingContext);
        converter.setMapKeyDotReplacement("~");
        converter.afterPropertiesSet();
        return converter;
    }
}
