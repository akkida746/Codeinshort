package com.codeinshort.awssns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Slf4j
@SpringBootApplication
public class AwsSnsApplication {

	@Autowired
	private SnsService snsService;

    public static void main(String[] args) {
        SpringApplication.run(AwsSnsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            log.info("Started..");
            log.info("Listing topics");

            SnsClient client = SnsClient.builder().build();
            snsService.listSNSTopics(client);
        };
    }

}
