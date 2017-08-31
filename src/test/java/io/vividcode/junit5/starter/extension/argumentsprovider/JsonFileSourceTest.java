package io.vividcode.junit5.starter.extension.argumentsprovider;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

@DisplayName("JSON file source")
public class JsonFileSourceTest {

  @ParameterizedTest
  @JsonFileSource("/users.json")
  @DisplayName("use JSON file source")
  void test(@JsonProperty("name") final String name,
      @JsonProperty("email") final String email) {
    assertNotNull(name);
    assertNotNull(email);
  }
}
