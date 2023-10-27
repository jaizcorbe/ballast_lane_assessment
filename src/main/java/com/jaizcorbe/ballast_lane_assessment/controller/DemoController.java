package com.jaizcorbe.ballast_lane_assessment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class DemoController {

  @GetMapping("/resource")
  public Map<String, String> home() {
    return Map.of("id", UUID.randomUUID().toString(),"content", "Hello World");
  }
}
