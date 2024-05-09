package com.laoazhang.service.impl;

import com.laoazhang.mapper.UserMapper;
import com.laoazhang.service.IUserService;
import com.laoazhang.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Administrator
 * @CreateTime 2024/5/8 15:15
 * @Description:
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public void insert(User user) {

    }
}
