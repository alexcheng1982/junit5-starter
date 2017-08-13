package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("TestInfo")
public class TestInfoTest {

  public TestInfoTest(final TestInfo testInfo) {
    assertEquals("TestInfo", testInfo.getDisplayName());
  }

  @Test
  @Tag("demo")
  @DisplayName("tags")
  void testTags(final TestInfo testInfo) {
    assertEquals("tags", testInfo.getDisplayName());
    assertTrue(testInfo.getTags().contains("demo"));
    assertEquals(TestInfoTest.class, testInfo.getTestClass().get());
    assertTrue(testInfo.getTestMethod().isPresent());
    assertEquals("testTags", testInfo.getTestMethod().get().getName());
  }
}
