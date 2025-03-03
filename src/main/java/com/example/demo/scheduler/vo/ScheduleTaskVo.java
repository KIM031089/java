package com.example.demo.scheduler.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ScheduleTaskVo {

  @Data
  public static class AddScheduleReq {
    private String cronExpression;
  }

  @Data
  @AllArgsConstructor
  public static class AddScheduleResp {
    private String id;
  }
}
