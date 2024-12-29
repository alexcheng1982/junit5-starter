package io.vividcode.junit5.starter.challenge.stack;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Stack")
public class StackTest {

  Stack<Integer> stack;

  @Nested
  @DisplayName("When empty")
  class WhenEmpty {

    @BeforeEach
    void createNewStack() {
      stack = new Stack<>();
    }

    @Test
    @DisplayName("can push values")
    void canPush() {
      assertNotNull(stack.push(1));
      assertNotNull(stack.push(2));
    }

    @Test
    @DisplayName("cannot pop values")
    void cannotPop() {
      assertThrows(EmptyStackException.class, () -> stack.pop());
    }
  }

  @Nested
  @DisplayName("When not empty")
  class WhenNotEmpty {

    @BeforeEach
    void createNewStack() {
      stack = new Stack<>();
      stack.push(1);
      stack.push(2);
    }

    @Test
    @DisplayName("can push values")
    void canPush() {
      assertNotNull(stack.push(3));
      assertNotNull(stack.push(4));
    }

    @Test
    @DisplayName("can pop values")
    void canPop() {
      assertNotNull(stack.pop());
    }

    @Test
    @DisplayName("pop values until empty")
    void popUntilEmpty() {
      assertNotNull(stack.pop());
      assertNotNull(stack.pop());
      assertThrows(EmptyStackException.class, () -> stack.pop());
    }
  }
}
