package dev.fringe.repository.custom;

import dev.fringe.domain.Customer;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by v.hdlee on 2016-08-17.
 */
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {

    @PersistenceContext private EntityManager entityManager;
    @Value("${hibernate.jdbc.batch_size}")
    private int batchSize;

    public List<Customer> batchOperation(Collection entities) {
        final List savedEntities = new ArrayList(entities.size());
        int i = 0;
        for (Object t : entities) {
            entityManager.persist(t);
            savedEntities.add(t);
            i++;
            if (i % batchSize == 0) {
                // Flush a batch of inserts and release memory.
                entityManager.flush();
                entityManager.clear();
            }
        }
        return savedEntities;
    }

}
