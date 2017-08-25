package io.vividcode.junit5.starter.extension.argumentconverter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("user test")
public class UserTest {

  @ParameterizedTest
  @ValueSource(strings = {"alex", "bob"})
  @DisplayName("get user")
  void testGetUser(@ConvertWith(UserArgumentConverter.class) final User user) {
    assertNotNull(user);
    assertNotNull(user.getName());
  }
}
