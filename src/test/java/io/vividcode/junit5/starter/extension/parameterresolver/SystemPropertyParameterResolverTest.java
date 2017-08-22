package io.vividcode.junit5.starter.extension.parameterresolver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SystemPropertyParameterResolver.class)
@DisplayName("Parameter resolver using system properties")
public class SystemPropertyParameterResolverTest {

  @Test
  @DisplayName("resolve property")
  void testResolveProperty(final String envHost) {
    assertNotNull(envHost);
  }
}
