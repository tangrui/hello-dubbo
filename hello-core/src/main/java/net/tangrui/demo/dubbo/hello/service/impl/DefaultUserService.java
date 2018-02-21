package net.tangrui.demo.dubbo.hello.service.impl;

import net.tangrui.demo.dubbo.hello.model.User;
import net.tangrui.demo.dubbo.hello.repository.UserRepository;
import net.tangrui.demo.dubbo.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("userService")
public class DefaultUserService implements UserService {

  private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUserService.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public User getById(String id) {
    User user = this.userRepository.getById(id);
    LOGGER.info(user.toString());
    return user;
  }

  // 原有方式
  /*
  @Override
  public void create(User user) {
    user.setCreatedTime(new Date());
    this.userRepository.create(user);
    LOGGER.info(user.toString());
  }
  */

  // 第一种方式
  /*
  public User create(User user) {
    user.setCreatedTime(new Date());
    this.userRepository.create(user);
    LOGGER.info(user.toString());
    // 将变更后的数据返回
    return user;
  }
  */

  // 第二种方式
  // 保持原有方法实现不变
  @Override
  public void create(User user) {
    user.setCreatedTime(new Date());
    this.userRepository.create(user);
    LOGGER.info(user.toString());
  }

  // 添加新方法的实现
  @Override
  public User __rpc_create(User user) {
    // 调用原来的方法
    this.create(user);
    // 返回变更后的数据
    return user;
  }

}
