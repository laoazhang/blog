package com.laoazhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface UserMapper extends BaseMapper<User> {

    User selectById(Long id);

    int insert(User user);

    int update(User user);

    int deleteById(Long id);

    Integer total(UserQuery userQuery);

    List<User> page(UserQuery userQuery);

    int batchDel(List<Long> ids);
}
