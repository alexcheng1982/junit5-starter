package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of assertTimeout")
public class AssertTimeoutExample {

  @Test
  @DisplayName("Simple assertTimeout")
  void simpleTimeout() {
    assertTimeout(Duration.ofSeconds(5), () -> Thread.sleep(3000));
  }

  @Test
  @DisplayName("assertTimeout with return value")
  void timeoutWithReturnValue() {
    final Integer result = assertTimeout(Duration.ofSeconds(5), () -> {
      Thread.sleep(3000);
      return 1;
    });
    assertEquals(Integer.valueOf(1), result);
  }

  @Test
  @DisplayName("timeout happens")
  void timeout() {
    assertTimeout(Duration.ofSeconds(5), () -> Thread.sleep(30000));
  }
}
