package com.example.demo.scheduler.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.utils.DateUtils;
import com.example.demo.common.vo.CommonResponse;
import com.example.demo.scheduler.service.SchedulingService;
import com.example.demo.scheduler.vo.ScheduleTaskVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
public class SchedulingController {

  private final SchedulingService schedulingService;

  @PostMapping("/schedule/v1")
  public ScheduleTaskVo.AddScheduleResp addTask(@RequestBody ScheduleTaskVo.AddScheduleReq param) {
    String id = schedulingService.scheduleTask(new TestObj(), TestObj::makeLog, param.getCronExpression());

    return new ScheduleTaskVo.AddScheduleResp(id);
  }

  @DeleteMapping("/schedule/v1/{id}")
  public CommonResponse stopTask(String id) {
    schedulingService.stopTask(id);
    return new CommonResponse();
  }

  @Slf4j
  private static class TestObj {

    public void makeLog() {
      log.info("{}, 배치 수행!", DateUtils.getCurrentDate());
    }
  }
}
