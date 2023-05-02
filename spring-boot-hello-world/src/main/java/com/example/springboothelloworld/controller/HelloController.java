package com.example.springboothelloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping(value = "/")
  public String index() {
    return "Success";
  }

  @GetMapping(value = "/hello")
  public String hello() {
    return "Hello World";
  }

  @GetMapping(value = "/welcome")
  public String welcome() {
    return "Welcome Spring Boot";
  }
}
