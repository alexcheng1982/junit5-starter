package io.vividcode.junit5.starter.extension.lifecycle;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingExtension implements BeforeAllCallback,
    BeforeEachCallback,
    BeforeTestExecutionCallback,
    AfterTestExecutionCallback,
    AfterEachCallback,
    AfterAllCallback {

  @Override
  public void beforeAll(final ExtensionContext context) throws Exception {
    log(context, "beforeAll");
  }

  @Override
  public void beforeEach(final ExtensionContext context) throws Exception {
    log(context, "beforeEach");
  }

  @Override
  public void beforeTestExecution(final ExtensionContext context)
      throws Exception {
    log(context, "beforeTestExecution");
  }

  @Override
  public void afterTestExecution(final ExtensionContext context)
      throws Exception {
    log(context, "afterTestExecution");
  }

  @Override
  public void afterEach(final ExtensionContext context) throws Exception {
    log(context, "afterEach");
  }

  @Override
  public void afterAll(final ExtensionContext context) throws Exception {
    log(context, "afterAll");
  }

  private void log(final ExtensionContext context, final String stage) {
    System.out.printf("%s => %s%n", stage, context.getDisplayName());
  }
}
