package io.vividcode.junit5.starter;


import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("RepeatedTest")
public class RepeatedTests {

  @RepeatedTest(3)
  @DisplayName("simple")
  void simpleTest() {
  }

  @RepeatedTest(value = 3, name = RepeatedTest.LONG_DISPLAY_NAME)
  @DisplayName("long")
  void longDisplayName() {
  }

  @RepeatedTest(value = 3, name = "{currentRepetition} / {totalRepetitions}")
  @DisplayName("custom")
  void customDisplayName() {
  }

  @RepeatedTest(value = 3, failureThreshold = 1)
  @DisplayName("failureThreshold")
  void failureThreshold() {
    if (ThreadLocalRandom.current().nextBoolean()) {
      fail("random failure");
    }
  }
}
