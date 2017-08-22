package io.vividcode.junit5.starter.extension.parameterresolver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AnnotationBasedSystemPropertyParameterResolver.class)
@DisplayName("Annotation based parameter resolver using system properties")
public class AnnotationBasedSystemPropertyParameterResolverTest {

  @Test
  @DisplayName("resolve property")
  void testResolveProperty(@EnvProperty("host") final String host) {
    assertNotNull(host);
  }
}
