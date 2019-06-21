package com.springcloud.server1.pay;

import java.math.BigDecimal;

public class Context {
    public BigDecimal calRecharge(Integer channelId,Integer goodsId) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        StrategeFactory strategeFactory=StrategeFactory.getInstance();
        Stratege stratege=strategeFactory.createStratege(channelId);
        return stratege.calRecharge(channelId,goodsId);
    }
}
