package com.example.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FixedJobConfig {

  // 매 30초마다
  @Scheduled(fixedRate = 30 * 1000)
  public void task1() {
    log.info("task1: 30초에 한번씩 실행됩니다.");
  }

  // 작업 후 30초 뒤
  @Scheduled(fixedDelay = 30 * 1000)
  public void task2() {
    log.info("task2: 작업 종료 후 30초에 한번씩 실행됩니다.");
  }

  @Scheduled(cron = "0 0/1 * * * ?")
  public void task3() {
    log.info("task3: 1분에 한번씩 실행됩니다.");
  }

}
