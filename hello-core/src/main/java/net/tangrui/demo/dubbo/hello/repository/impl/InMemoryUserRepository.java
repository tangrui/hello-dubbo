package net.tangrui.demo.dubbo.hello.repository.impl;

import net.tangrui.demo.dubbo.hello.model.User;
import net.tangrui.demo.dubbo.hello.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {

  private static final Map<String, User> STORE = new HashMap<>();

  static {
    User tom = new User();
    tom.setId("tom");
    tom.setName("Tom Sawyer");
    tom.setCreatedTime(new Date());
    STORE.put(tom.getId(), tom);
  }

  @Override
  public User getById(String id) {
    return STORE.get(id);
  }

  @Override
  public void create(User user) {
    STORE.put(user.getId(), user);
  }

}
