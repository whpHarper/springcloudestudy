package com.springcloud.consumer.command;

import com.netflix.hystrix.HystrixCommand;
import com.springcloud.consumer.model.User;
import org.springframework.web.client.RestTemplate;

public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private Long id;

    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(setter);
        this.restTemplate=restTemplate;
        this.id=id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("",User.class,id);
    }

    /*public static void main(String[] args){
        RestTemplate restTemplate;
        User user=new UserCommand(restTemplate,1L).execute();
    }*/
}
