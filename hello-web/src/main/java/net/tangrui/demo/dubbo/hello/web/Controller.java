package net.tangrui.demo.dubbo.hello.web;

import net.tangrui.demo.dubbo.hello.model.User;
import net.tangrui.demo.dubbo.hello.service.HelloService;
import net.tangrui.demo.dubbo.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  private HelloService helloService;

  @Autowired
  private UserService userService;

  @RequestMapping("/hello/{userId}")
  public String sayHello(@PathVariable("userId") String userId) {
    return this.helloService.sayHello(userId);
  }

  // 原有方式
  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public String createUser(@RequestParam("userId") String userId, @RequestParam("name") String name) {
    User user = new User();
    user.setId(userId);
    user.setName(name);

    this.userService.create(user);
    return user.toString();
  }

  // 第一种方式
  /*
  @RequestMapping(path = "/create", method = RequestMethod.POST)
  public String createUser(@RequestParam("userId") String userId, @RequestParam("name") String name) {
    User user = new User();
    user.setId(userId);
    user.setName(name);

    // 接收返回值
    User newUser = this.userService.create(user);
    return newUser.toString();
  }
  */

}
