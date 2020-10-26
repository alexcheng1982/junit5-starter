package io.vividcode.junit5.starter.extension.parameterresolver;

import java.lang.reflect.Parameter;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class SystemPropertyParameterResolver implements ParameterResolver {

  private static final String PREFIX = "env";

  @Override
  public boolean supportsParameter(final ParameterContext parameterContext,
      final ExtensionContext extensionContext)
      throws ParameterResolutionException {
    final Parameter parameter = parameterContext.getParameter();
    return Objects.equals(parameter.getType(), String.class) &&
        parameter.getName().startsWith(PREFIX);
  }

  @Override
  public Object resolveParameter(final ParameterContext parameterContext,
      final ExtensionContext extensionContext)
      throws ParameterResolutionException {
    final String name = parameterContext.getParameter().getName();
    final String property = String
        .join(".",
            StringUtils.
                splitByCharacterTypeCamelCase(
                    name.substring(PREFIX.length())))
        .toLowerCase();
    return System.getProperty(property);
  }
}
