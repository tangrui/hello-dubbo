package com.alibaba.edas.demo.dubbo.hello.service.impl;

import com.alibaba.edas.demo.dubbo.hello.model.User;
import com.alibaba.edas.demo.dubbo.hello.repository.UserRepository;
import com.alibaba.edas.demo.dubbo.hello.service.UserService;
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

  @Override
  public User create(User user) {
    user.setCreatedTime(new Date());
    this.userRepository.create(user);
    LOGGER.info(user.toString());
    return user;
  }

}
