package com.example.demo.common.constant;

import java.util.Collection;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {
  INTERNAL_SERVER_ERROR("CMN5N0001", "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);

  private String errorCode;
  private String errorName;
  private HttpStatus httpStatus;
  // private static final Map<String, ErrorCode> = Collections.un

  ErrorCode(String errorCode, String errorName) {
    this.errorCode = errorCode;
    this.errorName = errorName;
    this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  ErrorCode(String errorCode, String errorName, HttpStatus httpStatus) {
    this.errorCode = errorCode;
    this.errorName = errorName;
    this.httpStatus = httpStatus;
  }
}
