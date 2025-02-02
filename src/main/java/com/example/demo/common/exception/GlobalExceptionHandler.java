package com.example.demo.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

  @ExceptionHandler(BizException.class)
  public ResponseEntity<CommonResponse> bizExceptionHandler(BizException e) {
    LOGGER.error(e.getMessage(), e);

    return ResponseEntity.status(e.getHttpStatus())
        .body(CommonResponse.builder()
            .resultCode(e.getErrorCode())
            .resultMessage(e.getMessage())
            .build());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CommonResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
    LOGGER.error(e.getMessage(), e);

    ErrorCode errorCode = ErrorCode.PARAM_INVALID_ERROR;

    return ResponseEntity.status(errorCode.getHttpStatus())
        .body(CommonResponse.builder()
            .resultCode(errorCode.getErrorCode())
            .resultMessage(
                errorCode.getErrorName() 
                + " - " 
                + e.getBindingResult().getFieldErrors().get(0).getField()
                + " : "
                + e.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
            .build());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<CommonResponse> exceptionHandler(Exception e) {
    LOGGER.error(e.getMessage(), e);

    ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;

    return ResponseEntity.status(errorCode.getHttpStatus())
        .body(CommonResponse.builder()
            .resultCode(errorCode.getErrorCode())
            .resultMessage(errorCode.getErrorName())
            .build());
  }

  //https://velog.io/@jomminii/spring-service-exception 참고
}
