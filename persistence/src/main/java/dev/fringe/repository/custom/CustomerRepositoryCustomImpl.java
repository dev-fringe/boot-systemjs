package dev.fringe.repository.custom;

import dev.fringe.domain.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by v.hdlee on 2016-08-17.
 */
class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {

    @PersistenceContext private EntityManager em;
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

//    @Override
//    public List<Customer> myCustomBatchOperation() {
//        return null;
//    }
}
