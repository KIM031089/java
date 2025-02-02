package com.example.demo.common.exception;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import com.example.demo.common.constant.ErrorCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizException extends Exception {
  private String errorCode;
  private String errorMessage;
  private HttpStatus httpStatus;

  public BizException(ErrorCode errorCode) {
    this.errorCode = errorCode.getErrorCode();
    this.errorMessage = errorCode.getErrorName();
    this.httpStatus = errorCode.getHttpStatus();
  }

  public String getMessage() {
    return StringUtils.isNotBlank(this.errorMessage) ? this.errorMessage : super.getMessage();
  }
}
