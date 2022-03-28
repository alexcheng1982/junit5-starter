package io.vividcode.junit5.starter.extension.exceptionhandling;

import io.vividcode.junit5.starter.Abort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CatchAllExceptionHandler.class)
@DisplayName("OutOfMemory")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OutOfMemoryTest {

  @Test
  @DisplayName("throw OutOfMemoryError")
  @Order(1)
  @Abort
  void outOfMemory() {
    throw new OutOfMemoryError();
  }

  @Test
  @DisplayName("normal test")
  @Order(2)
  void normalTest() {

  }
}
