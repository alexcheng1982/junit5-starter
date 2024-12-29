package io.vividcode.junit5.starter.challenge.restapi;

import java.util.Objects;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class RestApiTestParameterResolver implements ParameterResolver {

  private final RestApiTest restApiTest;

  public RestApiTestParameterResolver(RestApiTest restApiTest) {
    this.restApiTest = restApiTest;
  }

  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return Objects.equals(parameterContext.getParameter().getType(),
        RestApiTest.class);
  }

  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    return this.restApiTest;
  }
}
