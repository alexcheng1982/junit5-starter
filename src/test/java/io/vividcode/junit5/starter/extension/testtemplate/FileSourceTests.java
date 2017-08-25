package io.vividcode.junit5.starter.extension.testtemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("use @FileSourceTest")
@ExtendWith(FileSourceTestInvocationContextProvider.class)
public class FileSourceTests {

  @FileSourceTest("/sample.txt")
  @DisplayName("for each line")
  void testForEachLine(final Line line) {
    assertNotNull(line);
    assertNotNull(line.getText());
  }
}
