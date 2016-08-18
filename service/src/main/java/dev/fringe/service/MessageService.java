package dev.fringe.service;

import dev.fringe.ApplicationContextLoader;
import dev.fringe.domain.Message;
import org.atmosphere.config.service.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by v.hdlee on 2016-08-18.
 * add applicationCpmtextLoader - rest client
 * i think that um.. so.. need some improvement
 */
@ManagedService(path = "/message")
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    public MessageService() {
        this("classpath:/dev/fringe/context-rest.xml");
    }

    @Autowired
    private RestTemplate restTemplate;

    public MessageService(String... configLocations) {
        new ApplicationContextLoader().load(this, configLocations);
    }

    @org.atmosphere.config.service.Message(encoders = JacksonEncoderDecoder.class, decoders = JacksonEncoderDecoder.class)
    public Message onMessage(Message message) throws IOException {
        String uri = "test";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Object> request = new HttpEntity<Object>(null, headers);
        try {
            ResponseEntity<Map> reponse = restTemplate.postForEntity(uri, request, Map.class);
            if (reponse.getStatusCode() == HttpStatus.OK ) {
                System.out.println(reponse.getBody());
            } else {
                logger.error("sendMessage() - " + String.format("%s, %s", reponse.getStatusCode(), reponse.getBody().toString()));
                return null;
            }
        } catch (Exception e) {
            logger.error("sendMessage()", e);
            return null;
        }
        this.logger.info("sent message {}", message);
        return message;
    }

}
