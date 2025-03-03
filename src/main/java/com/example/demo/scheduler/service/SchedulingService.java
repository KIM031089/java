package com.example.demo.scheduler.service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.function.Consumer;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchedulingService {

  private final TaskScheduler taskScheduler;
  private Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

  public <T> String scheduleTask(T target, Consumer<T> action, String cronExpression) {
    SchedulingTask<T> task = new SchedulingTask<>(target, action);
    UUID id = UUID.randomUUID();
    scheduledTasks.put(id.toString(), taskScheduler.schedule(task, new CronTrigger(cronExpression)));
    return id.toString();
  }

  public void stopTask(String id) {
    scheduledTasks.get(id).cancel(true);
  }

  @AllArgsConstructor
  private static class SchedulingTask<T> implements Runnable {
    private final T target;
    private final Consumer<T> task;

    @Override
    public void run() {
      task.accept(target);
    }
  }

}