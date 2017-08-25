package io.vividcode.junit5.starter.extension.argumentconverter;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public class UserService {

  private final Map<String, User> users = ImmutableMap.of(
      "alex", new User("alex", "Alex", "alex@example.org"),
      "bob", new User("bob", "Bob", "bob@example.org")
  );

  public User findUser(final String id) {
    return this.users.get(id);
  }
}
