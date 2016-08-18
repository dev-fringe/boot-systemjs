package dev.fringe.repository;

import dev.fringe.FringeServiceApplication;
import dev.fringe.RepositoryApplication;
import dev.fringe.domain.Message;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by v.hdlee on 2016-08-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryApplication.class},webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class MessageRepositoryTest {

    private static Log logger = LogFactory.getLog(MessageRepositoryTest.class);

    @LocalServerPort
    private int port = 1234;

    @Autowired
    private MessageRepository repository;

    @Test
    public void save() throws Exception {
        Message message = new Message("message");
        repository.save(message);
        for (Message msg: repository.findAll()){
            System.out.println(msg);
        }
    }
}
