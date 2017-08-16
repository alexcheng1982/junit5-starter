package io.vividcode.junit5.starter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

@DisplayName("dynamic tests")
public class DynamicTests {

  @TestFactory
  @DisplayName("simple")
  List<DynamicTest> simpleDynamicTests() {
    return Lists.newArrayList(
        DynamicTest.dynamicTest("test1", () -> assertTrue(true)),
        DynamicTest.dynamicTest("test2", () -> assertEquals(3, 1 + 2))
    );
  }

  @TestFactory
  @DisplayName("test generators")
  Stream<DynamicTest> testGenerators() {
    return DynamicTest.stream(
        IntStream.range(1, 10).iterator(),
        num -> String.format("Test - %s", num),
        num -> assertTrue(num > 0)
    );
  }

  @TestFactory
  @DisplayName("nested")
  Stream<DynamicNode> nestedTests() {
    return Stream.of(DynamicContainer.dynamicContainer("nested",
        Stream.of(
            DynamicContainer.dynamicContainer("t1",
                Stream.of(
                    DynamicTest.dynamicTest("1", () -> assertTrue(true)),
                    DynamicTest.dynamicTest("2", () -> assertTrue(true))
                )),
            DynamicTest.dynamicTest("t2", () -> assertTrue(true))
        )));
  }
}
