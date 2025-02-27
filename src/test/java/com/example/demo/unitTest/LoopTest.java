package com.example.demo.unitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LoopTest {
  
  @ParameterizedTest(name = "반복 테스트 예제 {0} + {1} = {2}")
  @MethodSource("parameterizedTestParameters")
  void sum(int a, int b, int expectedResult) {
    assertEquals(expectedResult, a + b);
  }

  private static Stream<Arguments> parameterizedTestParameters() {
    return Stream.of(
        Arguments.of(1, 1, 2),
        Arguments.of(1, 2, 3));
  }
}
