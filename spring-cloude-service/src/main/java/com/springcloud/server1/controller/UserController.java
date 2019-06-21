package com.springcloud.server1.controller;

import com.springcloud.server1.controller.base.BaseController;
import com.springcloud.server1.model.User;
import com.springcloud.server1.service.UserService;
import com.springcloude.common.message.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserById",method = RequestMethod.GET)
    public ResponseJson getUserById(Long id){
        User user=userService.getUserById(id);
        return responseMsg(0,user);
    }

    /**
     * 统一校验示例
     * @param user
     * @param result
     * @param request
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseJson update(@Valid User user,BindingResult result,HttpServletRequest request){
        if(result.hasErrors()){
            return showErrorJson(result);
        }
        int flag=userService.update(user);
        return responseMsg(0,user);
    }

}
