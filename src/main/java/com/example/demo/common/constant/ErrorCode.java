package com.example.demo.common.constant;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public enum ErrorCode {
  INTERNAL_SERVER_ERROR("CMN5N0001", "INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),
  PARAM_INVALID_ERROR("CMN1N0001", "PARAM_INVALID", HttpStatus.OK),
  DATA_NOT_FOUND_ERROR("CMN1N0002", "DATA_NOT_FOUND_ERROR", HttpStatus.OK);

  @Getter
  private String errorCode;

  @Getter
  private String errorName;

  @Getter
  private HttpStatus httpStatus;

  ErrorCode(String errorCode, String errorName, HttpStatus httpStatus) {
    this.errorCode = errorCode;
    this.errorName = errorName;
    this.httpStatus = httpStatus;
  }
}
