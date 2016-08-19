package dev.fringe.controller;

import dev.fringe.config.LoadBalanceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RibbonClient(name="fringe", configuration = LoadBalanceConfig.class)
public class LoadBalanceController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

//    @RequestMapping("/{path}/{data}")
//    public String pathdata(@PathVariable String path, @PathVariable String data, @RequestParam(value="name", defaultValue="fringe") String name) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("path", path);
//        params.put("data", data);
//        params.put("name", name);
//        String greeting = this.restTemplate.getForObject("http://{name}/{path}/{data}", String.class, params);
//        return String.format("%s, %s!", greeting, name);
//    }
//
//    @RequestMapping("/{path}")
//    public String path(@PathVariable String path, @RequestParam(value="name", defaultValue="fringe") String name) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("path", path);
//        params.put("name", name);
//        String greeting = this.restTemplate.getForObject("http://{name}/{path}", String.class, params);
//        return String.format("%s, %s!", greeting, "sdd");
//    }
}
