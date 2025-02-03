package com.example.demo.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StringUtils {
  private static final ObjectMapper MAPPER = new ObjectMapper();

  public static String toJsonString(Object target) {
    try {
      return MAPPER.writeValueAsString(target);
    } catch (JsonProcessingException e) {
      return "";
    }
  }

}
