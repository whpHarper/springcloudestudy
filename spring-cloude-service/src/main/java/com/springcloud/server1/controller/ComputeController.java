package com.springcloud.server1.controller;

import com.springcloud.server1.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/api/v1/compute")
public class ComputeController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "hello world";
    }
    @RequestMapping(value = "/getRedirect", method = RequestMethod.GET)
    @ResponseBody
    public void redirect(HttpServletResponse response){
        try {
            response.sendRedirect("https://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    @ResponseBody
    public String hello1(@RequestParam String name){
        return "hello "+name;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    @ResponseBody
    public User hello2(@RequestHeader String name,@RequestHeader Integer age){
        return new User(name,age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    @ResponseBody
    public String hello3(@RequestBody User user){
        return "hello "+user.getName()+","+user.getAge();
    }
}
