package com.laoazhang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laoazhang.user.domain.User;
import com.laoazhang.user.query.UserQuery;
import com.laoazhang.utils.Result;

import java.util.List;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 15:02
 * @Description:
 * @Version 1.0
 */
public interface IUserService extends IService<User> {

    Result selectById(Long id);

    Result insert(User user);

    Result update(User user);

    Result page(UserQuery userQuery);

    Result delete(Long id);

    Result batchDel(List<Long> ids);
}
