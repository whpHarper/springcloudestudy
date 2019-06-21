package com.springcloud.server1.controller;

import com.springcloud.server1.model.User;
import com.springcloud.server1.pay.Context;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/api/v1/pay")
public class PayController {
    @RequestMapping(value = "/getPay",method = RequestMethod.GET)
    public BigDecimal getPay(Long id){
        Context context=new Context();
        try {
            BigDecimal result=context.calRecharge(1,1);
            return result;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
