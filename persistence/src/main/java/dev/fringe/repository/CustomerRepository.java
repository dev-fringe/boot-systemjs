package dev.fringe.repository;

import java.util.List;
import dev.fringe.domain.Customer;
import dev.fringe.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>, CustomerRepositoryCustom {
    List<Customer> findByLastName(String lastName);
}
