package net.tangrui.demo.dubbo.hello.repository;

import net.tangrui.demo.dubbo.hello.model.User;

public interface UserRepository {

  User getById(String id);

  void create(User user);

}
