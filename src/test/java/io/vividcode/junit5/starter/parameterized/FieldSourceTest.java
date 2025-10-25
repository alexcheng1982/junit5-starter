package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.FieldSource;

@DisplayName("FieldSource")
public class FieldSourceTest {

  @ParameterizedTest
  @FieldSource
  void userNames(String name) {
    assertNotNull(name);
  }

  @ParameterizedTest
  @FieldSource("moreUserNames")
  void testUserNames(String name) {
    assertNotNull(name);
  }

  @ParameterizedTest
  @FieldSource({"userNames", "moreUserNames"})
  void testAllUserNames(String name) {
    assertNotNull(name);
  }

  static final List<String> userNames = Arrays.asList("Alex", "Bob", "David");

  static final String[] moreUserNames = new String[]{"Mary", "John"};
}
