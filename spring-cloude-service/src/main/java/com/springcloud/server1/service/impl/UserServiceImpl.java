package com.springcloud.server1.service.impl;

import com.springcloud.server1.dao.AuRuleDao;
import com.springcloud.server1.model.AuRule;
import com.springcloud.server1.model.User;
import com.springcloud.server1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AuRuleDao auRuleDao;

    @Override
    public User getUserById(Long id) {
        User user=new User();
        user.setId(1L);
        user.setAge(12);
        user.setName("whp");
        user.setSex("男");
        AuRule auRule=auRuleDao.select(1L);
        return user;
    }

    @Override
    public int update(User user) {
        return 0;
    }
}
