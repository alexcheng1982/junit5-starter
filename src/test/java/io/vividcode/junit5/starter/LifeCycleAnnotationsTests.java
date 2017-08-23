package io.vividcode.junit5.starter;

import io.vividcode.junit5.starter.extension.lifecycle.LoggingExtension;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(LoggingExtension.class)
public class LifeCycleAnnotationsTests {

  @BeforeAll
  static void beforeAll() {
    System.out.println("Before all");
  }

  @BeforeEach
  void beforeEach() {
    System.out.println("Before each");
  }

  @Test
  void simpleTest1() {
    System.out.println("Test1");
  }

  @Test
  void simpleTest2() {
    System.out.println("Test2");
  }

  @AfterEach
  void afterEach() {
    System.out.println("After each");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("After all");
  }
}
