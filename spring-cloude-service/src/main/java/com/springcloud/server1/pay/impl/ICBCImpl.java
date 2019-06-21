package com.springcloud.server1.pay.impl;

import com.springcloud.server1.dao.AuRuleDao;
import com.springcloud.server1.pay.Pay;
import com.springcloud.server1.pay.Stratege;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Pay(channleId = 1)
public class ICBCImpl extends BeanUtils implements Stratege {

    @Autowired
    private AuRuleDao auRuleDao;

    @Override
    public BigDecimal calRecharge(Integer channleId, Integer goodsId) {
        auRuleDao.select(1L);
        return new BigDecimal(2);
    }
}
