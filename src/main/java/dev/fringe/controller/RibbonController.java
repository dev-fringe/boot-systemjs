package dev.fringe.controller;

import dev.fringe.RibbonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "say-hello", configuration = RibbonConfig.class)
public class RibbonController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    public String hi(@RequestParam(value="name", defaultValue="Artaban") String name) {
        String greeting = this.restTemplate.getForObject("http://say-hello/greeting", String.class);
        return String.format("%s, %s!", greeting, name);
    }
}
