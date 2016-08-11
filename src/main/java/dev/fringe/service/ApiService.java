package dev.fringe.service;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by v.hdlee on 2016-08-11.
 */
@Component
@Path("/hello")
public class ApiService {

    @GET
    public String message() {
        return "Hello World";
    }

}
