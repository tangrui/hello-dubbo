package net.tangrui.demo.dubbo.hello.service.impl;

import net.tangrui.demo.dubbo.hello.model.User;
import net.tangrui.demo.dubbo.hello.service.HelloService;
import net.tangrui.demo.dubbo.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("helloService")
public class DefaultHelloService implements HelloService {

  @Autowired
  private UserService userService;

  @Override
  public String sayHello(String userId) {
    User user = this.userService.getById(userId);
    return String.format("Hello, %s.", user);
  }

}
