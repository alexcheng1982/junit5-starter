package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of assertAll")
public class AssertAllTests {

  @Test
  @DisplayName("Simple assertAll")
  void simpleAssertAll() {
    assertAll(
        () -> assertTrue(true),
        () -> assertEquals(1, 1)
    );
    assertAll(
        Stream.of(
            () -> assertTrue(true),
            () -> assertEquals(1, 1)
        )
    );
  }

  @Test
  @DisplayName("Failed assertAll")
  @Fail
  void failedAssertAll() {
    assertAll(
        () -> assertTrue(false),
        () -> assertEquals(1, 2)
    );
  }

  @Test
  @DisplayName("Failed assertAll with custom heading message")
  @Fail
  void failedAssertAllWithHeading() {
    assertAll(
        "Boom!",
        () -> assertTrue(false),
        () -> assertEquals(1, 2)
    );
  }
}
