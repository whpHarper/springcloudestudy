package com.springcloud.server1.pay;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface Stratege {
    BigDecimal calRecharge(Integer channleId, Integer goodsId);
}
