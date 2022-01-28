package io.vividcode.junit5.starter.extension.testtemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;

public class FileSourceTestInvocationContextProvider implements
    TestTemplateInvocationContextProvider {

  @Override
  public boolean supportsTestTemplate(final ExtensionContext context) {
    return AnnotationUtils
        .isAnnotated(context.getTestMethod(), FileSourceTest.class);
  }

  @Override
  public Stream<TestTemplateInvocationContext>
  provideTestTemplateInvocationContexts(final ExtensionContext context) {
    final AtomicLong invocationCount = new AtomicLong(0);
    final String resourceName = AnnotationUtils
        .findAnnotation(context.getRequiredTestMethod(), FileSourceTest.class)
        .get()
        .value();
    final InputStream inputStream = context.getRequiredTestClass()
        .getResourceAsStream(resourceName);
    try (final BufferedReader reader = new BufferedReader(
        new InputStreamReader(inputStream))) {
      return reader.lines()
          .map(this::createInvocationContext)
          .peek(invocationContext -> invocationCount.incrementAndGet())
          .onClose(() ->
              Preconditions.condition(invocationCount.get() > 0,
                  () -> "The file should at least contain one line."));
    } catch (final IOException e) {
      throw new PreconditionViolationException("Invalid file", e);
    }
  }

  private TestTemplateInvocationContext createInvocationContext(
      final String text) {
    return new FileSourceTestInvocationContext(new Line(text));
  }
}
