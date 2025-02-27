package com.example.demo.unitTest;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DateUtilsTest {

  @Test
  void testConvertLocalTimeToString() {
    Clock clock = Clock.fixed(Instant.parse("2014-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
    String dateTimeExpected = "2014-12-22T10:15:30";

    LocalDateTime dateTime = LocalDateTime.now(clock);

    Assertions.assertEquals(dateTimeExpected, dateTime.toString());
  }
}
