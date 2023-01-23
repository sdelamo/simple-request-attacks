package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HomeController {

    @Get(produces = MediaType.TEXT_PLAIN)
    String index() {
        return "Hello World";
    }
}
