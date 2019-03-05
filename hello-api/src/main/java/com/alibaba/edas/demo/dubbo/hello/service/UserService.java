package com.alibaba.edas.demo.dubbo.hello.service;

import com.alibaba.edas.demo.dubbo.hello.model.User;

public interface UserService {

  User getById(String id);

  User create(User user);

}
