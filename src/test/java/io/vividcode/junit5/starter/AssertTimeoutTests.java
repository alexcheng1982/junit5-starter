package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of assertTimeout")
public class AssertTimeoutTests {

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
  @DisplayName("timeout happens - wait for 10s")
  @Fail
  void timeout() {
    assertTimeout(Duration.ofSeconds(5), () -> Thread.sleep(10000));
  }

  @Test
  @DisplayName("timeout happens - wait for 5s")
  @Fail
  void timeoutPreemptively() {
    assertTimeoutPreemptively(Duration.ofSeconds(5), () -> Thread.sleep(10000));
  }
}
