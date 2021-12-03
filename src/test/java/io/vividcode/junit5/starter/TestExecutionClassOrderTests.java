package io.vividcode.junit5.starter;

import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(OrderAnnotation.class)
public class TestExecutionClassOrderTests {

  @Nested
  @Order(1)
  class DatabaseTests {

    @Test
    void setup() {

    }
  }

  @Nested
  @Order(2)
  class ApiTests {

    @Test
    void request() {
    }

  }
}
