package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of fail")
public class FailExample {

  @Test
  @DisplayName("simple fail")
  void simpleFail() {
    fail("Boom!", new IllegalArgumentException());
  }

  @Test
  void failIn() {
    Stream.of(1, 2, 3).map(v -> fail("Not here"));
  }
}
