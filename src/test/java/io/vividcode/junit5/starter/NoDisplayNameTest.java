package io.vividcode.junit5.starter;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
public class NoDisplayNameTest {

  @Test
  void test1() {

  }

  @Test
  void anotherTest() {

  }
}
