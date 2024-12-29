package io.vividcode.junit5.starter.challenge.cdi;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(CDIExtension.class)
@DisplayName("User service")
public class UserServiceTest {

  @Inject
  UserService userService;

  @Test
  @DisplayName("find user")
  void testFindUser() {
    User user = new User(1, "test", "test@example.com");
    this.userService.createOrUpdate(user);
    assertTrue(this.userService.find(1L).isPresent());
  }

  @Test
  @DisplayName("delete user")
  void testDeleteUser() {
    User user = new User(1, "test", "test@example.com");
    this.userService.createOrUpdate(user);
    assertTrue(this.userService.find(1L).isPresent());
    this.userService.delete(1L);
    assertFalse(this.userService.find(1L).isPresent());
  }
}
