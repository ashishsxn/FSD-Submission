package com.ibm.admin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.ibm.admin.entities.Skills;
import com.ibm.admin.entities.TrainerDetails;
import com.ibm.admin.entities.Users;
import com.ibm.admin.repository.SkillsRepository;
import com.ibm.admin.repository.TrainerDetailsRepository;
import com.ibm.admin.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(value = { "com.ibm.admin"})
@Configuration
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@EntityScan(basePackages = "com.ibm.admin")
@EnableJpaAuditing
@EnableJpaRepositories
public class AdminApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoData(SkillsRepository repo,TrainerDetailsRepository tdr,UserRepository ur) {
		return args -> {
			Skills skills = new Skills("na");
			repo.save(skills);
			Users users = new Users();
			TrainerDetails trainerDetails = new TrainerDetails();
			trainerDetails.setEmail("trainer@fsd.com");
			tdr.save(trainerDetails);
			users.setEmail("admin@fsd.com");
			users.setPassword("admin");
			users.setRole("admin");
			users.setUserName("ADMIN");
			users.setTrainerDetails(trainerDetails);
			ur.save(users);
		};
	}

}
