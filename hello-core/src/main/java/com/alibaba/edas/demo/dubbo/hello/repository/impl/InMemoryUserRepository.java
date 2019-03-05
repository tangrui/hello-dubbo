package com.alibaba.edas.demo.dubbo.hello.repository.impl;

import com.alibaba.edas.demo.dubbo.hello.model.User;
import com.alibaba.edas.demo.dubbo.hello.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryUserRepository implements UserRepository {

  private static final Map<String, User> STORE = new HashMap<>();

  @Override
  public User getById(String id) {
    return STORE.get(id);
  }

  @Override
  public void create(User user) {
    STORE.put(user.getId(), user);
  }

}
