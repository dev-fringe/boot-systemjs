package dev.fringe.atmosphere;

import org.atmosphere.config.service.Disconnect;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Ready;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * Created by v.hdlee on 2016-08-18.
 */
public abstract class AtmosphereResourceSupport<T> {

    private final Logger logger = LoggerFactory.getLogger(AtmosphereResourceSupport.class);

    @Ready
    public void onReady(final AtmosphereResource resource) {
        this.logger.info("Connected", resource.uuid());
    }

    @Disconnect
    public void onDisconnect(AtmosphereResourceEvent event) {
        this.logger.info("Client {} disconnected [{}]", event.getResource().uuid(),(event.isCancelled() ? "cancelled" : "closed"));
    }

    @Message(encoders = JacksonEncoderDecoder.class, decoders = JacksonEncoderDecoder.class)
    public T onMessage(T t) throws IOException {
        this.logger.info("sent message {}", t);
        return t;
    }
}