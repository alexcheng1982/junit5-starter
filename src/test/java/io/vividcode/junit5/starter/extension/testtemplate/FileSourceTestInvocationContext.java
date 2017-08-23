package io.vividcode.junit5.starter.extension.testtemplate;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

public class FileSourceTestInvocationContext implements TestTemplateInvocationContext {

  private final Line line;

  public FileSourceTestInvocationContext(final Line line) {
    this.line = line;
  }

  @Override
  public String getDisplayName(int invocationIndex) {
    return String.format("Line %s - %s", invocationIndex, line.getText());
  }

  @Override
  public List<Extension> getAdditionalExtensions() {
    return Collections.singletonList(new LineParameterResolver(line));
  }
}
