package com.springcloud.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.springcloud.consumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "fallBack",commandKey = "helloKey",ignoreExceptions = {HystrixBadRequestException.class})
    public String getServer1() {
        return restTemplate.getForEntity("http://CONSUME-SERVICE/api/v1/compute/test", String.class).getBody();
    }

    public String fallBack(){
        return "error";
    }

    public Long getUserByIdCacheKey(Long id){
        return id;
    }

    @CacheResult(cacheKeyMethod="getUserByIdCacheKey")
    @HystrixCommand
    public Future<User> getUserByIdAsync(final String id){
        return new com.netflix.hystrix.contrib.javanica.command.AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("",User.class,1L);
            }
        };
    }

    @HystrixCommand
    public Observable<User> getUserById(final long id){
        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                try{
                    if(!subscriber.isUnsubscribed()){
                        User user=restTemplate.getForObject("",User.class,1L);
                        subscriber.onNext(user);
                        subscriber.onCompleted();
                    }
                }catch (Exception ex){
                    subscriber.onError(ex);
                }
            }
        });
    }

}
