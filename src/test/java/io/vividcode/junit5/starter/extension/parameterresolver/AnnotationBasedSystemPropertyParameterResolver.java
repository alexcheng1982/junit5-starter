package io.vividcode.junit5.starter.extension.parameterresolver;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class AnnotationBasedSystemPropertyParameterResolver
    implements ParameterResolver {

  @Override
  public boolean supportsParameter(final ParameterContext parameterContext,
      final ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.isAnnotated(EnvProperty.class);
  }

  @Override
  public Object resolveParameter(final ParameterContext parameterContext,
      final ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return parameterContext.findAnnotation(EnvProperty.class)
        .map(envProperty -> System.getProperty(envProperty.value()))
        .orElseThrow(() ->
            new ParameterResolutionException("Cannot find system property"));
  }
}
