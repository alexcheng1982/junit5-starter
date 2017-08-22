package io.vividcode.junit5.starter.extension.testinstance;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ConfigAwareTestInstancePostProcessor.class)
@DisplayName("config-aware test")
public class ConfigAwareTest implements ConfigAware {

  private Config config;

  @Override
  public void setConfig(final Config config) {
    this.config = config;
  }

  @Test
  void testGetConfig() {
    assertNotNull(this.config);
  }
}
