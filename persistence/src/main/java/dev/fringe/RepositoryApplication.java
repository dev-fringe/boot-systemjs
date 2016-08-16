package dev.fringe;

import dev.fringe.domain.Customer;
import dev.fringe.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by v.hdlee on 2016-08-16.
 */
@SpringBootApplication
@Configuration
@ConfigurationProperties(locations={"classpath:application.yml"})
public class RepositoryApplication {

    private static final Logger log = LoggerFactory.getLogger(RepositoryApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class);
    }

    @Autowired
    CustomerRepository repository;

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            log.info("save a couple of customers");
            save();
            log.info("");
            log.info("fetch all customers");
            fetchAllCustomers();
            log.info("");
            log.info("fetch an individual customer by ID");
            fetchCustomerById(1L);
            log.info("");
            log.info("fetch customers by last name");
            fetchCustomersByLastName("Bauer");
            log.info("");
        };
    }

    private void fetchCustomersByLastName(String lastName) {
        // fetch customers by last name
        for (Customer bauer : repository.findByLastName(lastName)) {
            log.info(bauer.toString());
        }
    }

    private void fetchCustomerById(long id) {
        // fetch an individual customer by ID
        Customer customer = repository.findOne(id);
        log.info(customer.toString());
        log.info("");
    }

    private void fetchAllCustomers() {
        // fetch all customers
        for (Customer customer : repository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");
    }

    private void save() {
        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
    }
}