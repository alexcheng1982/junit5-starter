package io.vividcode.junit5.starter.extension.exceptionhandling;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class NoIOExceptionHandler implements TestExecutionExceptionHandler {

  @Override
  public void handleTestExecutionException(final ExtensionContext context,
      final Throwable throwable)
      throws Throwable {
    if (!(throwable instanceof IOException)) {
      throw throwable;
    }
  }
}
