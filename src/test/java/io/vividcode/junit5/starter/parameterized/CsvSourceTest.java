package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("CsvSource")
public class CsvSourceTest {

  @ParameterizedTest
  @CsvSource({"hello, 1", "world, 2"})
  @DisplayName("simple CSV")
  void simpleCsv(final String str, final int number) {
    assertNotNull(str);
    assertTrue(number > 0);
  }

  @ParameterizedTest
  @CsvSource(value = {"hello#1", "world#2"}, delimiter = '#')
  @DisplayName("custom delimiter")
  void customDelimiter(final String str, final int number) {
    assertNotNull(str);
    assertTrue(number > 0);
  }
}
