package io.vividcode.junit5.starter.extension.testinstance;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class ConfigAwareTestInstancePostProcessor implements TestInstancePostProcessor {

  @Override
  public void postProcessTestInstance(final Object testInstance, final ExtensionContext context)
      throws Exception {
    if (testInstance instanceof ConfigAware) {
      ((ConfigAware) testInstance).setConfig(new Config());
    }
  }
}
