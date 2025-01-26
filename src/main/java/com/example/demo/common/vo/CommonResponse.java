package com.example.demo.common.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResponse {
  private String resultCode;
  private String resultMessage;

  public CommonResponse() {
    this.resultCode = "0";
    this.resultMessage = "SUCCESS";
  }

  @Builder
  public CommonResponse(String resultCode,String resultMessage) {
    this.resultCode = resultCode;
    this.resultMessage = resultMessage;
  }
}
