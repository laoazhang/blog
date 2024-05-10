package com.laoazhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laoazhang.user.domain.User;
import com.laoazhang.user.query.UserQuery;

import java.util.List;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 15:16
 * @Description:
 * @Version 1.0
 */
public interface UserMapper extends BaseMapper<User> {

    List<User> page(UserQuery userQuery);

}
