package io.vividcode.junit5.starter.challenge.restapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;

@DisplayName("Google search")
@ExtendWith(RestApiTestJsonInvocationContextProvider.class)
public class GoogleSearchTest {

  @DisplayName("google search")
  @RestApiJsonTest("/google-search.json")
  void testSearch(RestApiTest restApiTest) {
    restApiTest.verify();
  }
}
