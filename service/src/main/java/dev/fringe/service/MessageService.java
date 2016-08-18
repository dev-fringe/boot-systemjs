package dev.fringe.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.fringe.domain.Message;
import org.atmosphere.config.managed.Decoder;
import org.atmosphere.config.managed.Encoder;
import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@ManagedService(path = "/message")
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    private Message message;
    @Ready
    public void onReady(final AtmosphereResource resource) {
        this.logger.info("Connected", resource.uuid());
        message.setUuid(resource.uuid());
    }

    @Disconnect
    public void onDisconnect(AtmosphereResourceEvent event) {
        this.logger.info("Client {} disconnected [{}]", event.getResource().uuid(),(event.isCancelled() ? "cancelled" : "closed"));
    }

    @org.atmosphere.config.service.Message(encoders = JacksonEncoderDecoder.class, decoders = JacksonEncoderDecoder.class)
    public Message onMessage(Message message) throws IOException {
        this.logger.info("Author {} sent message {}", message.getAuthor(),message.getMessage());
        message.setUuid(this.message.getUuid());
        return message;
    }

    public static class JacksonEncoderDecoder implements Encoder<Message, String>, Decoder<String, Message> {

        private final ObjectMapper mapper = new ObjectMapper();
        public String encode(Message m) {
            try {
                return this.mapper.writeValueAsString(m);
            }catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        }
        public Message decode(String s) {
            try {
                return this.mapper.readValue(s, Message.class);
            }catch (IOException ex) {
                throw new IllegalStateException(ex);
            }
        }
    }
}
