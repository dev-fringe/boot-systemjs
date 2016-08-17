package dev.fringe;

import dev.fringe.domain.Customer;
import dev.fringe.domain.Message;
import dev.fringe.repository.CustomerRepository;
import dev.fringe.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created by v.hdlee on 2016-08-16.
 */
@SpringBootApplication
@Configuration
@ConfigurationProperties(locations={"classpath:application.yml"})
public class RepositoryApplicationMessage {

    private static final Logger log = LoggerFactory.getLogger(RepositoryApplicationMessage.class);

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplicationMessage.class);
    }

    @Autowired
    MessageRepository repository;

    @Bean
    public CommandLineRunner init() {
        String data = "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong";
        return (evt) -> Arrays.asList(data.split(",")).forEach(a -> {
            repository.save(new Message(a));
        });
    }
}