package com.example.demo.board.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  @Value("${spring.profiles.active:default}")
  private String activeProfile;

  @Value("${sample.value}")
  private String value;

  @GetMapping("/sample/active-profile")
  public String getActiveProfile() {
    return activeProfile;
  }

  @GetMapping("/sample/get-value")
  public String getValue() {
    return value;
  }

}
