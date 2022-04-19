package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.vividcode.junit5.starter.Fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.AssertionFailedError;

@DisplayName("ValueSource")
public class ValueSourceTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 4})
  @DisplayName("simple")
  void simpleValue(final int num) {
    assertTrue(num > 0);
  }

  @ParameterizedTest(name = "Run #{index} => {arguments}")
  @ValueSource(ints = {1, 2, 4})
  @DisplayName("custom display name")
  void customDisplayName(final int num) {
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

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  @DisplayName("with failed cases")
  @Fail
  void withFailedCases(int value) {
    if (value % 2 == 0) {
      throw new AssertionFailedError("Values should be odd numbers");
    }
    assertTrue(value > 0);
  }
}
