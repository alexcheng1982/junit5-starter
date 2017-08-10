package io.vividcode.junit5.starter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("disabled tests")
public class DisabledTests {

  @Test
  @DisplayName("normal test")
  void normalTest() {

  }

  @Disabled
  @Test
  @DisplayName("disabled test")
  void disabledTest() {

  }
}
