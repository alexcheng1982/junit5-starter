package io.vividcode.junit5.starter.extension.testtemplate;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

public class FileSourceTestInvocationContextProvider implements
    TestTemplateInvocationContextProvider {

  @Override
  public boolean supportsTestTemplate(ExtensionContext context) {
    return false;
  }

  @Override
  public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(
      ExtensionContext context) {
    return null;
  }
}
