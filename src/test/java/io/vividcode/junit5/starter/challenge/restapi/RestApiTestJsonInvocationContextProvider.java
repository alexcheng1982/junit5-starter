package io.vividcode.junit5.starter.challenge.restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.Preconditions;

public class RestApiTestJsonInvocationContextProvider implements
    TestTemplateInvocationContextProvider {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public boolean supportsTestTemplate(ExtensionContext context) {
    return AnnotationUtils.isAnnotated(context.getTestMethod(),
        RestApiJsonTest.class);
  }

  @Override
  public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(
      ExtensionContext context) {
    final AtomicLong invocationCount = new AtomicLong(0);
    final String resourceName = AnnotationUtils
        .findAnnotation(context.getRequiredTestMethod(), RestApiJsonTest.class)
        .get()
        .value();
    final InputStream inputStream = context.getRequiredTestClass()
        .getResourceAsStream(resourceName);
    if (inputStream == null) {
      throw new PreconditionViolationException("File not found");
    }
    try {
      List<RestApiTest> restApiTests = objectMapper.readValue(inputStream,
          new TypeReference<List<RestApiTest>>() {
          });
      return restApiTests
          .stream()
          .map(this::createInvocationContext)
          .peek(invocationContext -> invocationCount.incrementAndGet())
          .onClose(() ->
              Preconditions.condition(invocationCount.get() > 0,
                  () -> "The file should at least one test."));

    } catch (IOException e) {
      throw new PreconditionViolationException("Invalid REST API JSON file");
    }
  }

  private TestTemplateInvocationContext createInvocationContext(
      final RestApiTest restApiTest) {
    return new RestApiJsonTestInvocationContext(restApiTest);
  }
}
