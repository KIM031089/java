package com.example.demo.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {

  public static LocalDateTime getCurrentDate() {
    return LocalDateTime.now();
  }

  public static String convertLocalTimeToString(LocalDateTime localDateTime, String format) {
    if (localDateTime == null)
      return "";
    if (StringUtils.isEmpty(format))
      format = "yyyy-MM-dd HH:mm:ss";
    try {
      return localDateTime.format(DateTimeFormatter.ofPattern(format));
    } catch (Exception e) {
      return "";
    }
  }
}
