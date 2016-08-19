package dev.fringe.repository.custom;

import dev.fringe.domain.Customer;

import java.util.Collection;
import java.util.List;

/**
 * Created by v.hdlee on 2016-08-17.
 * some bug.
 */
public interface CustomerRepositoryCustom {
    List<Customer> myCustomBatchOperation();
}
