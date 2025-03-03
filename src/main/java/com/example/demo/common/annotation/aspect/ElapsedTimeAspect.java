package com.example.demo.common.annotation.aspect;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.example.demo.common.annotation.ElapsedTime;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ElapsedTimeAspect {

  @Around("@annotation(com.example.demo.common.annotation.ElapsedTime)")
  public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    ElapsedTime executionTime = methodSignature.getMethod().getAnnotation(ElapsedTime.class);
    String name = StringUtils.isNotEmpty(executionTime.name()) ? executionTime.name()  : methodSignature.getName();
    
    long startTime = System.currentTimeMillis();
    Object proceed = joinPoint.proceed(); // 메소드가 실행됨.
    long endTime = System.currentTimeMillis();

    log.info("{}, 실행시간 : {} ms", name, (endTime - startTime));

    return proceed;
  }
}
