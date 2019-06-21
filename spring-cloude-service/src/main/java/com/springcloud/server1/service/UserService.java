package com.springcloud.server1.service;

import com.springcloud.server1.model.User;

public interface UserService {
    User getUserById(Long id);
}
