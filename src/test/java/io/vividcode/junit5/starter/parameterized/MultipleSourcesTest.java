package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Multiple source")
public class MultipleSourcesTest {

  @ParameterizedTest
  @ValueSource(strings = {"Hello", "World"})
  @CsvSource({"Line 1", "Line 2"})
  void multipleSources(String value) {
    assertNotNull(value);
  }
}
