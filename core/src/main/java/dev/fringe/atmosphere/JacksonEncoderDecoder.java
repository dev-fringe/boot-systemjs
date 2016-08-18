package dev.fringe.atmosphere;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.atmosphere.config.managed.Decoder;
import org.atmosphere.config.managed.Encoder;

import java.io.IOException;

/**
 * Created by v.hdlee on 2016-08-18.
 */
public class JacksonEncoderDecoder<T> implements Encoder<T, String>, Decoder<String, T> {
    protected Class<? extends T> clazz;
    private final ObjectMapper mapper = new ObjectMapper();
    public String encode(T m) {
        try {
            return this.mapper.writeValueAsString(m);
        }catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    public T decode(String s) {
        try {
            return this.mapper.readValue(s, clazz);
        }catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
