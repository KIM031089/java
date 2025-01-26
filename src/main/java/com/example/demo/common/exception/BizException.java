package com.example.demo.common.exception;

import com.example.demo.common.constant.ErrorCode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizException extends Exception {
  // private String errorCode;
  // private String errorMessage;

  // public BizException(String errorCode) {
  //   this.errorCode = ErrorCode.INTERNAL_SERVER_ERROR.getErrorCode();
  //   this.errorMessage = ErrorCode.INTERNAL_SERVER_ERROR.getErrorName();
  // }

}
