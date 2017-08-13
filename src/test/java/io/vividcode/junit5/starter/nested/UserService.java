package io.vividcode.junit5.starter.nested;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class UserService {

  private Map<String, User> data = Maps.newHashMap();

  public List<User> list() {
    return Lists.newArrayList(this.data.values());
  }

  public Optional<User> find(final String name) {
    return Optional.ofNullable(this.data.get(name));
  }

  public void createOrUpdate(final User user) {
    Objects.requireNonNull(user);
    this.data.put(user.getName(), user);
  }

  public void delete(final String name) {
    this.data.remove(name);
  }

  public boolean isEmpty() {
    return this.data.isEmpty();
  }
}
