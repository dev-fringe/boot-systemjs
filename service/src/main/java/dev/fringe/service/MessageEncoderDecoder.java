package dev.fringe.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.fringe.domain.Message;
import org.atmosphere.config.managed.Decoder;
import org.atmosphere.config.managed.Encoder;
import java.io.IOException;

/**
 * Created by v.hdlee on 2016-08-18.
 */
public class MessageEncoderDecoder implements Encoder<Message, String>, Decoder<String, Message> {
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

