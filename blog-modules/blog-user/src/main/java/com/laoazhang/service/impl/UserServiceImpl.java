package com.laoazhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.laoazhang.mapper.UserMapper;
import com.laoazhang.service.IUserService;
import com.laoazhang.user.domain.User;
import com.laoazhang.user.query.UserQuery;
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
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<User> list() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(wrapper);
        return users;
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public PageInfo<User> page(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getCurrentPage(), userQuery.getPageSize());
        List<User> page = userMapper.page(userQuery);
        PageInfo<User> userPageInfo = new PageInfo<>(page);
        return userPageInfo;
    }
}
