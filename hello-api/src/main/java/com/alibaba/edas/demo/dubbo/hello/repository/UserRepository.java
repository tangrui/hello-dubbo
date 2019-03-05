package com.alibaba.edas.demo.dubbo.hello.repository;

import com.alibaba.edas.demo.dubbo.hello.model.User;

public interface UserRepository {

  User getById(String id);

  void create(User user);

}
