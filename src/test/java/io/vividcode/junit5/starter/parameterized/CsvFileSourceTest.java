package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@DisplayName("CsvFileSource")
public class CsvFileSourceTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/users.csv")
  @DisplayName("simple CSV file")
  void simpleCsvFile(final String name, final String email) {
    assertNotNull(name);
    assertNotNull(email);
  }
}
