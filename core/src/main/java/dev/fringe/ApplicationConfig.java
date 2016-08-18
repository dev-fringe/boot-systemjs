package dev.fringe;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(locations={"classpath:application.yml","classpath:persistence.yml","classpath:service.yml","classpath:web.yml"})
public class ApplicationConfig {}
