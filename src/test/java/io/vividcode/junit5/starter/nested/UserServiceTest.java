package io.vividcode.junit5.starter.nested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("UserService")
public class UserServiceTest {

  UserService userService;

  @Nested
  @DisplayName("when new")
  class WhenNew {

    @BeforeEach
    void createNewUserService() {
      userService = new UserService();
    }

    @Test
    @DisplayName("it has no users")
    void hasNoUsers() {
      assertTrue(userService.isEmpty());
    }

    @Nested
    @DisplayName("after adding a new user")
    class AfterAdding {

      User user = new User("Alex", "alex@example.org");

      @BeforeEach
      void addNewUser() {
        userService.createOrUpdate(user);
      }

      @Test
      @DisplayName("it is no longer empty")
      void isNotEmpty() {
        assertFalse(userService.isEmpty());
      }

      @Test
      @DisplayName("it has one user")
      void hasOneUser() {
        assertEquals(1, userService.list().size());
      }

      @Test
      @DisplayName("it can find the user")
      void canFindTheUser() {
        assertTrue(userService.find(user.getName()).isPresent());
      }

      @Nested
      @DisplayName("then remove the user")
      class ThenRemove {

        @BeforeEach
        void removeUser() {
          userService.delete(user.getName());
        }

        @Test
        @DisplayName("it should be empty")
        void isEmpty() {
          assertTrue(userService.isEmpty());
        }

        @Test
        @DisplayName("it cannot find the user")
        void userNotFound() {
          assertFalse(userService.find(user.getName()).isPresent());
        }
      }
    }
  }
}
