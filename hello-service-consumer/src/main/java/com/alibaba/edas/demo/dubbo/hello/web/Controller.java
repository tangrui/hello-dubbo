package com.alibaba.edas.demo.dubbo.hello.web;

import com.alibaba.edas.demo.dubbo.hello.model.User;
import com.alibaba.edas.demo.dubbo.hello.service.HelloService;
import com.alibaba.edas.demo.dubbo.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private HelloService helloService;

    @Autowired
    private UserService userService;

    @RequestMapping("/hello/{userId}")
    public String sayHello(@PathVariable("userId") String userId) {
        return this.helloService.sayHello(userId);
    }

   
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public User createUser(@RequestParam("id") String userId, @RequestParam("name") String name) {
    	User user = new User();
    	user.setId(userId);
    	user.setName(name);

    	return this.userService.create(user);
    }

}
