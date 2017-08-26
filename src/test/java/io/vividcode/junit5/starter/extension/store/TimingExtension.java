package io.vividcode.junit5.starter.extension.store;

import java.time.Duration;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;

public class TimingExtension implements BeforeTestExecutionCallback,
    AfterTestExecutionCallback {

  private final Namespace NAMESPACE = Namespace.create(getClass());

  @Override
  public void beforeTestExecution(final ExtensionContext context)
      throws Exception {
    getStore(context)
        .put(context.getRequiredTestMethod(), System.currentTimeMillis());
  }

  @Override
  public void afterTestExecution(final ExtensionContext context)
      throws Exception {
    final long start = getStore(context)
        .remove(context.getRequiredTestMethod(), long.class);
    final long duration = System.currentTimeMillis() - start;
    context
        .publishReportEntry("executionTime",
            Duration.ofMillis(duration).toString());
  }

  private Store getStore(final ExtensionContext context) {
    return context.getStore(this.NAMESPACE);
  }
}
