package io.vividcode.junit5.starter.extension.store;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TimingExtension.class)
@DisplayName("timed test")
public class TimedTest {

  @Test
  @DisplayName("sleep")
  void sleep() throws Exception {
    Thread.sleep(100);
  }
}
