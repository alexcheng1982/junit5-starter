package io.vividcode.junit5.starter.extension.parameterresolver;

import java.util.Objects;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class AnnotationBasedSystemPropertyParameterResolver implements ParameterResolver {

  @Override
  public boolean supportsParameter(final ParameterContext parameterContext,
      final ExtensionContext extensionContext)
      throws ParameterResolutionException {
    return Objects.nonNull(parameterContext.getParameter().getAnnotation(EnvProperty.class));
  }

  @Override
  public Object resolveParameter(final ParameterContext parameterContext,
      final ExtensionContext extensionContext)
      throws ParameterResolutionException {
    final EnvProperty envProperty = parameterContext.getParameter()
        .getAnnotation(EnvProperty.class);
    return System.getProperty(envProperty.value());
  }
}
