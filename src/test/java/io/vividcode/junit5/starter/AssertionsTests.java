package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionsTests {

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

  @Test
  @DisplayName("Example of assertNotEquals")
  void testAssertNotEquals() {
    final String message = "Two values must not be equal.";
    assertNotEquals(1, "hello");
    assertNotEquals(new Object(), "hello", message);
    assertNotEquals(new Object(), "hello", () -> message);
  }

  @Test
  @DisplayName("Example of assertArrayEquals")
  void testAssertArrayEquals() {
    final String message = "Two arrays must be equal.";
    assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, message);
    assertArrayEquals(new int[]{1, 2}, new int[]{1, 2}, () -> message);

    assertArrayEquals(new double[]{1.0, 2.0}, new double[]{1.1, 2.1}, 0.2);
  }

  @Test
  @DisplayName("Example of assertIterableEquals")
  void testAssertIterableEquals() {
    final String message = "Two iterables must be equal.";
    assertIterableEquals(
        Lists.newArrayList("hello", "world"),
        Lists.newArrayList("hello", "world")
    );
    assertIterableEquals(
        Lists.newArrayList("hello", "world"),
        Lists.newArrayList("hello", "world"),
        message
    );
    assertIterableEquals(
        Lists.newArrayList("hello", "world"),
        Lists.newArrayList("hello", "world"),
        () -> message
    );
  }

  @Test
  @DisplayName("Example of assertSame")
  void testAssertSame() {
    final String message = "Two objects must be same.";
    final Object obj = new Object();
    assertSame(obj, obj);
    assertSame(obj, obj, message);
    assertSame(obj, obj, () -> message);
  }

  @Test
  @DisplayName("Example of assertNotSame")
  void testAssertNotSame() {
    final String message = "Two objects must not be same.";
    assertNotSame(new Object(), new Object());
    assertNotSame(new Object(), new Object(), message);
    assertNotSame(new Object(), new Object(), () -> message);
  }
}
