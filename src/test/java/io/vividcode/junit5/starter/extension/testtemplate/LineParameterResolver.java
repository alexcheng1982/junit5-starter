package io.vividcode.junit5.starter.extension.testtemplate;

import java.util.Objects;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class LineParameterResolver implements ParameterResolver {

  private final Line line;

  public LineParameterResolver(Line line) {
    this.line = line;
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return Objects.equals(parameterContext.getParameter().getType(), Line.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return this.line;
  }
}
