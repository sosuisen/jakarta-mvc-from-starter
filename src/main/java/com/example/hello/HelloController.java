package com.example.hello;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Controller
@RequestScoped
@Path("hello")
public class HelloController {
    @Inject
    private Models models;

    @GET
    public String hello(@QueryParam("name") String name) {
        if ((name == null) || name.trim().isEmpty()) {
            name = "Jakarta EE";
        }
        models.put("name", name);
        return "hello.html";
    }
}