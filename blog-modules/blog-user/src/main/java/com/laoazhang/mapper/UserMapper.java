package com.laoazhang.mapper;

import com.laoazhang.user.domain.User;
import com.laoazhang.user.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 15:16
 * @Description:
 * @Version 1.0
 */
@Mapper
public interface UserMapper {

    User selectById(Long id);

    List<User> list();

    void insert(User user);

    void update(User user);

    void deleteById(Long id);

    Integer total(UserQuery userQuery);

    List<User> page(UserQuery userQuery);

    void batchDel(List<Long> ids);
}
