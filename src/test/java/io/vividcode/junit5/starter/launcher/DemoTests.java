package io.vividcode.junit5.starter.launcher;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class DemoTests {

  @Test
  public void test(TestReporter testReporter) {
    testReporter.publishEntry("Hello World");
  }
}
