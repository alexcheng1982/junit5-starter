package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("ValueSource")
public class ValueSourceTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 4})
  @DisplayName("simple")
  void simple(final int num) {
    assertTrue(num > 0);
  }

  @ParameterizedTest
  @ValueSource(strings = {"hello", "world"})
  @DisplayName("string")
  void strings(final String str) {
    assertTrue(str.length() > 0);
  }

  @ParameterizedTest
  @ValueSource(longs = {1L, 2L, 3L})
  @DisplayName("long")
  void longs(final long num) {
    assertTrue(num > 0);
  }

  @ParameterizedTest
  @ValueSource(doubles = {1.0, 2.0, 3.0})
  @DisplayName("double")
  void doubles(final double val) {
    assertTrue(val > 0);
  }
}
