package io.vividcode.junit5.starter.extension.exceptionhandling;

import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(NoIOExceptionHandler.class)
@DisplayName("No IOException")
public class NoIOExceptionTest {

  @Test
  @DisplayName("throw IOException")
  void testThrow() throws IOException {
    throw new IOException();
  }
}
