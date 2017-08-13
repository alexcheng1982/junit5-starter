package io.vividcode.junit5.starter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("RepeatedTest")
public class RepeatedTestExample {

  @RepeatedTest(3)
  @DisplayName("simple")
  void simpleTest() {
  }
}
