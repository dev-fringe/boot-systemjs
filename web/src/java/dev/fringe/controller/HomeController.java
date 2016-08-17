package dev.fringe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by v.hdlee on 2016-08-17.
 */
@Controller
public class HomeController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    String root() {
        return "welcome";
    }

    @RequestMapping("/template")
    String data(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "template";
    }
}
