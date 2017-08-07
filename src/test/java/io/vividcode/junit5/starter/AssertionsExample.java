package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsExample {

  @Test
  @DisplayName("Example of assertTrue")
  public void testAssertTrue() {
    final String message = "This must be true.";
    assertTrue(true);
    assertTrue(true, message);
    assertTrue(() -> true);
    assertTrue(() -> true, message);
    assertTrue(true, () -> message);
    assertTrue(() -> true, () -> message);
  }
}
