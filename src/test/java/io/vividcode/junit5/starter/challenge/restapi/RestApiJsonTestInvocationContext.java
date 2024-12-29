package io.vividcode.junit5.starter.challenge.restapi;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;

public class RestApiJsonTestInvocationContext implements
    TestTemplateInvocationContext {

  private final RestApiTest restApiTest;

  public RestApiJsonTestInvocationContext(RestApiTest restApiTest) {
    this.restApiTest = restApiTest;
  }

  @Override
  public String getDisplayName(int invocationIndex) {
    return String.format("API %s - %s", invocationIndex, this.restApiTest.name);
  }

  @Override
  public List<Extension> getAdditionalExtensions() {
    return Collections.singletonList(
        new RestApiTestParameterResolver(this.restApiTest));
  }
}
