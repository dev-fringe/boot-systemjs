package dev.fringe.service;

import dev.fringe.FringeServiceApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/**
 * Created by v.hdlee on 2016-08-18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FringeServiceApplication.class},webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class MessageServiceTest {
    private static Log logger = LogFactory.getLog(MessageServiceTest.class);

    @LocalServerPort
    private int port = 1234;

    @Test
    public void messageEndpoint() throws Exception {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ClientConfiguration.class, PropertyPlaceholderAutoConfiguration.class).properties("websocket.uri:ws://localhost:" + this.port + "/message").run("--spring.main.web_environment=false");
        long count = context.getBean(ClientConfiguration.class).latch.getCount();
        AtomicReference<String> messagePayloadReference = context.getBean(ClientConfiguration.class).messagePayload;
        context.close();
//        assertThat(count).isEqualTo(1L);
//        assertThat(messagePayloadReference.get()).contains("{\"message\":\"test\",\"author\":\"test\",\"time\":");
    }

    @Configuration
    static class ClientConfiguration implements CommandLineRunner {
        @Value("${websocket.uri}")
        private String webSocketUri;
        private final CountDownLatch latch = new CountDownLatch(1);
        private final AtomicReference<String> messagePayload = new AtomicReference<String>();

        public void run(String... args) throws Exception {
            logger.info("Waiting for response: latch=" + this.latch.getCount());
            if (this.latch.await(10, TimeUnit.SECONDS)) {
                logger.info("Got response: " + this.messagePayload.get());
            }else {
                logger.info("Response not received: latch=" + this.latch.getCount());
            }
        }

        @Bean
        public WebSocketConnectionManager wsConnectionManager() {
            WebSocketConnectionManager manager = new WebSocketConnectionManager(client(),handler(), this.webSocketUri);
            manager.setAutoStartup(true);
            return manager;
        }

        @Bean
        public StandardWebSocketClient client() {
            return new StandardWebSocketClient();
        }

        @Bean
        public TextWebSocketHandler handler() {
            return new TextWebSocketHandler() {
                public void afterConnectionEstablished(WebSocketSession session)throws Exception {
                    session.sendMessage(new TextMessage("{\"author\":\"test\",\"message\":\"test\"}"));
                }
                protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
                    logger.info("Received: " + message + " (" + ClientConfiguration.this.latch.getCount() + ")");
                    session.close();
                    ClientConfiguration.this.messagePayload.set(message.getPayload());
                    ClientConfiguration.this.latch.countDown();
                }
            };
        }
    }
}
