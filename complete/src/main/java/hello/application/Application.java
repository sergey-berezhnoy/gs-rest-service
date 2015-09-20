package hello.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = { hello.controller.Controllers.class, hello.service.Services.class })
@EnableMongoRepositories(basePackageClasses = { hello.dao.Daos.class })

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
