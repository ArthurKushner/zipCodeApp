package by.stail.data.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @autor Arthur Kushner
 * @since 4/26/17
 */
@Configuration
@Import(SimpleMongoConfiguration.class)
public class DataServiceConfig {

    /**
     * This is a custom configuration of {@link PropertySourcesPlaceholderConfigurer}
     * which allows to load multiple property *.yml files from different modules
     * @throws IOException
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer ymlProperties() throws IOException {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();

        YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();

        ClassLoader cl = DataServiceConfig.class.getClassLoader();

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
        Resource[] resources = resolver.getResources("classpath*:/*.yml");

        yamlFactory.setResources(resources);
        propertySourcesPlaceholderConfigurer.setProperties(yamlFactory.getObject());

        return propertySourcesPlaceholderConfigurer;
    }
}
