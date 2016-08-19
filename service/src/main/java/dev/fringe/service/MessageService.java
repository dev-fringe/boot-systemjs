package dev.fringe.service;

import dev.fringe.domain.Message;
import dev.fringe.SpringApplicationContext;
import org.atmosphere.config.service.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * Created by v.hdlee on 2016-08-18.
 */
@ManagedService(path = "/message")
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @org.atmosphere.config.service.Message(encoders = MessageEncoderDecoder.class, decoders = MessageEncoderDecoder.class)
    public Message onMessage(Message message) throws IOException {
//        ApiService chatService = SpringApplicationContext.getBean(ApiService.class);
        this.logger.info("sent message {}", message);
        return message;
    }

}
