package io.vividcode.junit5.starter;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("RepeatedTest")
public class RepeatedTestExample {

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
}
