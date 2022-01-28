package io.vividcode.junit5.starter.parameterized;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("MethodSource")
public class MethodSourceTest {

  @ParameterizedTest
  @MethodSource("names")
  @DisplayName("simple")
  void simpleMethod(final String str) {
    assertNotNull(str);
  }

  static List<String> names() {
    return Lists.newArrayList("hello", "world");
  }

  @ParameterizedTest
  @MethodSource({"numbers1", "numbers2"})
  @DisplayName("int stream")
  void intStream(final int number) {
    assertTrue(number > 0);
  }

  static IntStream numbers1() {
    return IntStream.of(1, 2, 3);
  }

  static Stream<Integer> numbers2() {
    return Stream.of(4, 5);
  }

  @ParameterizedTest
  @MethodSource("stringInts")
  @DisplayName("multiple arguments")
  void multipleArguments(final String str, final int number) {
    assertNotNull(str);
    assertTrue(number > 0);
  }

  static Stream<Arguments> stringInts() {
    return Stream.of(
        Arguments.of("hello", 1),
        Arguments.of("world", 2)
    );
  }
}
