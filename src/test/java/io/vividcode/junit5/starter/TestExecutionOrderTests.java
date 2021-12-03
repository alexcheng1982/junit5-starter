package io.vividcode.junit5.starter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class TestExecutionOrderTests {

  @Test
  @DisplayName("Database setup")
  @Order(1)
  void testDb() {

  }

  @Test
  @DisplayName("Application start successfully")
  @Order(2)
  void testApplicationStart() {

  }

  @Test
  @DisplayName("API operation")
  @Order(3)
  void testApi() {

  }
}
