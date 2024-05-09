package com.laoazhang.service;

import com.laoazhang.user.domain.User;

import java.util.List;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 15:02
 * @Description:
 * @Version 1.0
 */
public interface IUserService {

    User selectById(Long id);

    List<User> list();

    void insert(User user);

}
