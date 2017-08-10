package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Examples of Assumptions")
public class AssumptionsTests {

  @Test
  @DisplayName("Simple assumptions")
  void simpleAssumptions() {
    assumeTrue(2 > 1);
    assumeFalse(2 < 1);
    assumeTrue(false);
    System.out.println("This should never happen.");
  }

  @Test
  @DisplayName("assumingThat")
  void testAssumingThat() {
    assumingThat(2 > 1, () -> System.out.println("This must be true!"));
    assumingThat(2 < 1, () -> System.out.println("This should never happen."));
  }
}
