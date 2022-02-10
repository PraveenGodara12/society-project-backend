package com.SocietyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages= {"com.SocietyProject.Model"})
@ComponentScan(basePackages={"com.SocietyProject.Controller"})
public class SocietyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocietyProjectApplication.class, args);
	}

}
