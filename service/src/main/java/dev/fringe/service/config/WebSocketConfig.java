package dev.fringe.service.config;

import org.atmosphere.cpr.AtmosphereServlet;
import org.atmosphere.cpr.ContainerInitializer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Collections;

/**
 * Created by v.hdlee on 2016-08-18.
 */
@Configuration
public class WebSocketConfig {
    @Bean
    public EmbeddedAtmosphereInitializer atmosphereInitializer() {
        return new EmbeddedAtmosphereInitializer();
    }
    @Bean
    public ServletRegistrationBean atmosphereServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new AtmosphereServlet(), "/message/*");
        registration.addInitParameter("org.atmosphere.cpr.packages", "fringe");
        registration.addInitParameter("org.atmosphere.interceptor.HeartbeatInterceptor"+ ".clientHeartbeatFrequencyInSeconds", "10");
        registration.setLoadOnStartup(0);
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);// Need to occur before the EmbeddedAtmosphereInitializer
        return registration;
    }

    private static class EmbeddedAtmosphereInitializer extends ContainerInitializer implements ServletContextInitializer {
        public void onStartup(ServletContext servletContext) throws ServletException {
            onStartup(Collections.<Class<?>> emptySet(), servletContext);
        }
    }}
