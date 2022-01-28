package io.vividcode.junit5.starter.extension.exceptionhandling;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class CatchAllExceptionHandler implements TestExecutionExceptionHandler {

  @Override
  public void handleTestExecutionException(ExtensionContext context,
      Throwable throwable) throws Throwable {

  }
}
