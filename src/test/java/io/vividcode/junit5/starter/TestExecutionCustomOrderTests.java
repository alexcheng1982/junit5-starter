package io.vividcode.junit5.starter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(NameLengthMethodOrderer.class)
public class TestExecutionCustomOrderTests {

  @Test
  void m() {

  }

  @Test
  void method() {

  }

  @Test
  void longMethod() {

  }
}
