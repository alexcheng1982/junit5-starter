package io.vividcode.junit5.starter.extension.argumentconverter;

public class User {

  private final String id;
  private final String name;
  private final String email;

  public User(final String id, final String name, final String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }
}
