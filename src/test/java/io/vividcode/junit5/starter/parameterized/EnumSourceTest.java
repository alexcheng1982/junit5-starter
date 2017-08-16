package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;

@DisplayName("EnumSource")
public class EnumSourceTest {

  @ParameterizedTest
  @EnumSource(Color.class)
  @DisplayName("simple")
  void simpleEnum(final Color color) {
    assertNotNull(color);
  }

  @ParameterizedTest
  @EnumSource(value = Color.class, names = {"RED", "GREEN"})
  @DisplayName("included constants")
  void includedConstants(final Color color) {
    assertNotNull(color);
  }

  @ParameterizedTest
  @EnumSource(value = Color.class, names = {"RED", "GREEN"}, mode = Mode.EXCLUDE)
  @DisplayName("excluded constants")
  void excludedConstants(final Color color) {
    assertNotNull(color);
  }

  @ParameterizedTest
  @EnumSource(value = Color.class,
      names = {".*R.*", ".*N.*"},
      mode = Mode.MATCH_ALL)
  @DisplayName("match all")
  void matchAll(final Color color) {
    assertNotNull(color);
  }

  @ParameterizedTest
  @EnumSource(value = Color.class,
      names = {".*R.*", ".*N.*"},
      mode = Mode.MATCH_ANY)
  @DisplayName("match all")
  void matchAny(final Color color) {
    assertNotNull(color);
  }
}
