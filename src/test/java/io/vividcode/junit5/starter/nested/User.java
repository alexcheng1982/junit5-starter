package io.vividcode.junit5.starter.nested;

public class User {

  private final String name;
  private final String email;

  public User(final String name, final String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }
}
