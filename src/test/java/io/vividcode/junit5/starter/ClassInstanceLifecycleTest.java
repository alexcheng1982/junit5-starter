package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ClassInstanceLifecycleTest {

  private int count = 0;

  @BeforeAll
  void setup() {
    System.out.println("Start!");
  }

  @BeforeEach
  void reset() {
    this.count = 0;
  }

  @Test
  @DisplayName("increase")
  void testIncrease() {
    this.count++;
    assertEquals(1, this.count);
  }

  @Test
  @DisplayName("decrease")
  void testDecrease() {
    this.count--;
    assertEquals(-1, this.count);
  }
}
