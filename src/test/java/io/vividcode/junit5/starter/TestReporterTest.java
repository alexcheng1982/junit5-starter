package io.vividcode.junit5.starter;

import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

@DisplayName("TestReporter")
public class TestReporterTest {

  @Test
  @DisplayName("report single value")
  void reportSingleValue(final TestReporter testReporter) {
    testReporter.publishEntry("name", "Alex");
  }

  @Test
  @DisplayName("report multiple values")
  void publishMultipleValues(final TestReporter testReporter) {
    testReporter.publishEntry(ImmutableMap.of(
        "name", "Alex",
        "email", "alex@example.org"
    ));
  }
}
