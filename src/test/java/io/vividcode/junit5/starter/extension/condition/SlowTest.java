package io.vividcode.junit5.starter.extension.condition;

import io.vividcode.junit5.starter.Slow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SlowTestExecutionCondition.class)
@DisplayName("slow tests")
public class SlowTest {

  @Test
  @Slow
  @DisplayName("slow test")
  void slowTest() {

  }
}
