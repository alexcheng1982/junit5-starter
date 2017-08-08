package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsExample {

  @Test
  @DisplayName("Example of assertTrue")
  void testAssertTrue() {
    final String message = "This must be true.";
    assertTrue(true);
    assertTrue(true, message);
    assertTrue(() -> true);
    assertTrue(() -> true, message);
    assertTrue(true, () -> message);
    assertTrue(() -> true, () -> message);
  }

  @Test
  @DisplayName("Example of assertFalse")
  void testAssertFalse() {
    final String message = "This must be false.";
    assertFalse(false);
    assertFalse(false, message);
    assertFalse(() -> false);
    assertFalse(() -> false, message);
    assertFalse(false, () -> message);
    assertFalse(() -> false, () -> message);
  }

  @Test
  @DisplayName("Example of assertNull")
  void testAssertNull() {
    final String message = "This must be null.";
    assertNull(null);
    assertNull(null, message);
    assertNull(null, () -> message);
  }

  @Test
  @DisplayName("Example of assertNotNull")
  void testAssertNotNull() {
    final String message = "This must not be null.";
    assertNotNull("");
    assertNotNull(1, message);
    assertNotNull(new Object(), () -> message);
  }

  @Test
  @DisplayName("Example of assertEquals")
  void testAssertEquals() {
    final String message = "Two values must be equal.";
    assertEquals(1, 1);
    assertEquals(1, 1, message);
    assertEquals(1, 1, () -> message);

    assertEquals(1.0, 1.1, 0.2);
  }
}
