package com.springcloud.consumer.controller;

import com.springcloud.consumer.model.User;
import com.springcloud.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;

@Controller
@RequestMapping("/api/v1/consumer")
public class ConsumerController {

    @Autowired
    HelloService helloService;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/server1", method = RequestMethod.GET)
    @ResponseBody
    public String getServer1(){
        return helloService.getServer1();
    }

    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(HttpServletRequest request,HttpServletResponse response){
//        Observable<User> ho=helloService.getUserById(1L);
        ResponseEntity<String> responseEntity=restTemplate.exchange("http://127.0.0.1:5555/api/v1/compute/getRedirect",HttpMethod.GET,null,String.class);
        HttpHeaders headers=responseEntity.getHeaders();
        URI uri= headers.getLocation();
        return new User();
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



}
