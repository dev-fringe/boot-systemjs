package dev.fringe.service;

import dev.fringe.domain.Message;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.inject.annotation.RequestScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

@ManagedService(path = "/message")
@RequestScoped
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @org.atmosphere.config.service.Message(encoders = JacksonEncoderDecoder.class, decoders = JacksonEncoderDecoder.class)
    public Message onMessage(Message t) throws IOException {
        this.logger.info("sent message {}", t);
        return t;
    }

}
