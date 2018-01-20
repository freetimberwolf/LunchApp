package app;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="repository")
@EntityScan(basePackages="entity")
@ComponentScan(basePackages={"util","service","controller"})
public class ApplicationConfig {

}
