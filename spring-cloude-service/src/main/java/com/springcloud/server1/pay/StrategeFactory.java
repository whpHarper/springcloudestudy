package com.springcloud.server1.pay;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Set;

public class StrategeFactory {

    public static StrategeFactory strategeFactory=new StrategeFactory();
    private StrategeFactory(){}

    public static StrategeFactory getInstance(){
        return strategeFactory;
    }

    public static HashMap<Integer,String> servers=new HashMap<>();

    static{
        Reflections reflections=new Reflections("com.springcloud.server1.pay.impl");
        Set<Class<?>> classes= reflections.getTypesAnnotatedWith(Pay.class);
        for(Class clazz:classes){
            Pay pay=(Pay)clazz.getAnnotation(Pay.class);
            servers.put(pay.channleId(),clazz.getCanonicalName());
        }
    }

    public Stratege createStratege(Integer channleId) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String clazz=servers.get(channleId);
        Class clazz_=Class.forName(clazz);
        return (Stratege)clazz_.newInstance();
    }


}
