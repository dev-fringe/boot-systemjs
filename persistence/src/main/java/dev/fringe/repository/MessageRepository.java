package dev.fringe.repository;

import dev.fringe.domain.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by v.hdlee on 2016-08-16.
 */
public interface MessageRepository extends CrudRepository<Message, Long>{
}
