package io.vividcode.junit5.starter.challenge.cdi;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jakarta.inject.Singleton;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Singleton
public class UserService {

  private final Map<Long, User> data = Maps.newHashMap();

  public List<User> list() {
    return Lists.newArrayList(this.data.values());
  }

  public Optional<User> find(final Long id) {
    return Optional.ofNullable(this.data.get(id));
  }

  public void createOrUpdate(final User user) {
    Objects.requireNonNull(user);
    this.data.put(user.getId(), user);
  }

  public void delete(final Long id) {
    this.data.remove(id);
  }

  public boolean isEmpty() {
    return this.data.isEmpty();
  }
}
