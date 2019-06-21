package com.springcloud.server1.controller;

import com.springcloud.server1.controller.base.BaseController;
import com.springcloud.server1.model.User;
import com.springcloud.server1.service.UserService;
import com.springcloude.common.message.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    public ResponseJson getUserById(Long id){
        User user=userService.getUserById(id);
        return responseMsg(0,user);
    }

}
