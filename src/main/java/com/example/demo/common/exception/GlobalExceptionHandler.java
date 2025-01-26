package com.example.demo.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.common.constant.ErrorCode;
import com.example.demo.common.vo.CommonResponse;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Hidden
@Slf4j
public class GlobalExceptionHandler {
  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  // @ExceptionHandler(BizException.class)
  // public ResponseEntity<CommonResponse> bizExceptionHandler(BizException e) {

  //   LOGGER.error(e.getMessage(), e);    

  //   return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus())
  //       .body(CommonResponse.builder()
  //           .resultCode(e.getCode())
  //           .resultMessage(e.getMessage())
  //           .build());
  // }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<CommonResponse> exceptionHandler(Exception e) {

    LOGGER.error(e.getMessage(), e);

    return ResponseEntity.status(ErrorCode.INTERNAL_SERVER_ERROR.getHttpStatus())
        .body(CommonResponse.builder()
            .resultCode(ErrorCode.INTERNAL_SERVER_ERROR.getErrorCode())
            .resultMessage(ErrorCode.INTERNAL_SERVER_ERROR.getErrorName())
            .build());
  }
}
