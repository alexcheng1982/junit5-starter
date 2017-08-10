package io.vividcode.junit5.starter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class WithTagsTests {

  @Test
  @DisplayName("normal test")
  void normalTest() {

  }

  @Test
  @Tag("hello")
  @Tag("world")
  @Tag("hello world")
  void manyTags() {

  }

  @Test
  @Tags({@Tag("hello"), @Tag("world")})
  void manyTagsAgain() {

  }

  @Test
  @DisplayName("slow test")
  @Slow
  void slowTest() {

  }
}
