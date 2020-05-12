package com.shen.service;

import com.shen.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findByName(String name);

    User findById(String id);
}
