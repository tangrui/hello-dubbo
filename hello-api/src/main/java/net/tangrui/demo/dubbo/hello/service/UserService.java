package net.tangrui.demo.dubbo.hello.service;

import net.tangrui.demo.dubbo.hello.model.User;

public interface UserService {

  User getById(String id);

  // 原有方式
  // void create(User user);

  // 第一种方式
  // 为方法添加返回值
  // User create(User user);

  // 第二种方式
  // 保持原有方法不变
  void create(User user);
  // 添加一个方法，新方法需要有返回值
  User __rpc_create(User user);

}
