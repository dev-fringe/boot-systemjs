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
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by v.hdlee on 2016-08-16.
 */
@SpringBootApplication
public class RepositoryApplication {

    private static final Logger log = LoggerFactory.getLogger(RepositoryApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RepositoryApplication.class);
    }

//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Autowired
//    MessageRepository repository;
//
//    @Bean
//    public CommandLineRunner init() {
//        String data = "jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong";
//        return (evt) -> Arrays.asList(data.split(",")).forEach(a -> {
//            repository.save(new Message(a));
//        });
//    }
//
//    @Bean
//    public CommandLineRunner demo() {
//        return (args) -> {
//            log.info("save a couple of customers");
//            save();
//            log.info("");
//            log.info("fetch all customers");
//            fetchAllCustomers();
//            log.info("");
//            log.info("fetch an individual customer by ID");
//            fetchCustomerById(1L);
//            log.info("");
//            log.info("fetch customers by last name");
//            fetchCustomersByLastName("Bauer");
//            log.info("");
//        };
//    }
//
//    private void fetchCustomersByLastName(String lastName) {
//        // fetch customers by last name
//        for (Customer bauer : customerRepository.findByLastName(lastName)) {
//            log.info(bauer.toString());
//        }
//    }
//
//    private void fetchCustomerById(long id) {
//        // fetch an individual customer by ID
//        Customer customer = customerRepository.findOne(id);
//        log.info(customer.toString());
//    }
//
//    private void fetchAllCustomers() {
//        // fetch all customers
//        for (Customer customer : customerRepository.findAll()) {
//            log.info(customer.toString());
//        }
//    }
//
//    private void save() {
//        // save a couple of customers
//        customerRepository.save(new Customer("Jack", "Bauer"));
//        customerRepository.save(new Customer("Chloe", "O'Brian"));
//        customerRepository.save(new Customer("Kim", "Bauer"));
//        customerRepository.save(new Customer("David", "Palmer"));
//        customerRepository.save(new Customer("Michelle", "Dessler"));
//    }
}