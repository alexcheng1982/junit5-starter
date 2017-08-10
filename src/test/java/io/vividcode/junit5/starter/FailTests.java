package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of fail")
@Fail
public class FailTests {

  @Test
  @DisplayName("simple fail")
  void simpleFail() {
    fail("Boom!", new IllegalArgumentException());
  }
}
