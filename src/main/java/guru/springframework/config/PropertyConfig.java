package guru.springframework.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import guru.springframework.examplebeans.FakeDataSource;
import org.springframework.core.env.Environment;

/**
 * @author Ehtiram_Abdullayev on 8/31/2018
 * @project di-demo
 */
@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${demo.username}")
    String user;

    @Value("${demo.password}")
    String password;

    @Value("${demo.dburl}")
    String url;

    @Autowired
    Environment environment;


    @Bean
    public FakeDataSource fakeDataSource(){
        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUser(user);
        fakeDataSource.setUser(environment.getProperty("demo.username"));
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);

        return fakeDataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
