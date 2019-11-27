package com.ibm.mentor;

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

import com.ibm.mentor.entities.Skills;
import com.ibm.mentor.repository.SkillsRepository;

@SpringBootApplication
@ComponentScan(value = { "com.ibm.mentor"})
@EnableEurekaClient
@Configuration
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@EntityScan(basePackages = "com.ibm.mentor")
@EnableJpaAuditing
@EnableJpaRepositories
public class MentorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(SkillsRepository repo) {
		return args -> {
			Skills skills = new Skills("other");
			repo.save(skills);
		};
	}

}
