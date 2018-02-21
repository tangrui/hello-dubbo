package net.tangrui.demo.dubbo.hello.service.stub;

import net.tangrui.demo.dubbo.hello.model.User;
import net.tangrui.demo.dubbo.hello.service.UserService;

public class UserServiceStub implements UserService {

  private UserService userService;

  public UserServiceStub(UserService userService) {
    this.userService = userService;
  }

  @Override
  public User getById(String id) {
    return this.userService.getById(id);
  }

  @Override
  public void create(User user) {
    User newUser = this.__rpc_create(user);
    user.setCreatedTime(newUser.getCreatedTime());
  }

  @Override
  public User __rpc_create(User user) {
    return this.userService.__rpc_create(user);
  }

}
