package com.ibm.user;

import com.ibm.user.entities.Skills;
import com.ibm.user.repository.SkillsRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(value = { "com.ibm.user"})
@EnableEurekaClient
@Configuration
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@EntityScan(basePackages = "com.ibm.user")
@EnableJpaAuditing
@EnableJpaRepositories
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(SkillsRepository repo) {
		return args -> {
			Skills skills = new Skills("na");
			repo.save(skills);
		};
	}

}
