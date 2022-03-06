package casestudy.telehealth.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "casestudy.telehealth.database")
public class DatabaseConfig {


}
