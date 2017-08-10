package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of assertLinesMatch")
public class AssertLinesMatchTests {

  @Test
  @DisplayName("simple assertLinesMatch")
  void simpleLinesMatch() {
    assertLinesMatch(
        Lists.newArrayList("Hello"),
        Lists.newArrayList("Hello")
    );
  }

  @Test
  @DisplayName("assertLinesMatch using regular expressions")
  void regularExpressionMatch() {
    assertLinesMatch(
        Lists.newArrayList("The result is \\d+"),
        Lists.newArrayList("The result is 10")
    );
  }

  @Test
  @DisplayName("assertLinesMatch using fast-forward marker")
  void fastForwardMatch() {
    assertLinesMatch(
        Lists.newArrayList(">> Discarded output >>",
            "The first result is \\d+",
            ">> Discarded output again >>",
            "The second result is \\d+"),
        Lists.newArrayList("This line will be skipped",
            "Yet another skipped line",
            "The first result is 10",
            "skipped",
            "The second result is 20")
    );
    assertLinesMatch(
        Lists.newArrayList(">> 2 >>",
            "The result is \\d+"),
        Lists.newArrayList("skipped line 1",
            "skipped line 2",
            "The result is 10")
    );
  }
}
