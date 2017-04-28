package by.stail.application.config;

import by.stail.data.config.DataServiceConfig;
import by.stail.data.config.SimpleMongoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @autor Arthur Kushner
 * @since 4/11/17
 */
@Configuration
@ComponentScan(value = {"by.stail.application"})
@Import(DataServiceConfig.class)
public class AppConfiguration {


}

