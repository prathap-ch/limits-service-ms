package com.skillUp.MyRestService;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.skillUp.*")
@EntityScan({"com.skillUp.user","com.skillUp.beans"})
@EnableJpaRepositories({"com.skillUp.user","com.skillUp.beans"})
public class MyRestServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyRestServiceApplication.class, args);
	}

}
