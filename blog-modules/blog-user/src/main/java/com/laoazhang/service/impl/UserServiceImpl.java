package com.laoazhang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laoazhang.enums.ResultCodeEnum;
import com.laoazhang.mapper.UserMapper;
import com.laoazhang.service.IUserService;
import com.laoazhang.user.domain.User;
import com.laoazhang.user.query.UserQuery;
import com.laoazhang.utils.Result;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public Result insert(User user) {
        int insert = userMapper.insert(user);
        return insert == 1 ? Result.success("添加成功") : Result.error(ResultCodeEnum.ERROR);
    }

    @Override
    public Result delete(Long id) {
        int delete = userMapper.deleteById(id);
        return delete == 1 ? Result.success("删除成功", delete) : Result.error(ResultCodeEnum.ERROR);
    }

    @Override
    public Result batchDel(List<Long> ids) {
        int i = userMapper.deleteBatchIds(ids);
        return i != 0 ? Result.success("删除成功", i) : Result.error(ResultCodeEnum.ERROR);
    }

    @Override
    public Result update(User user) {
        int update = userMapper.updateById(user);
        return update == 1 ? Result.success("删除成功", update) : Result.error(ResultCodeEnum.ERROR);
    }

    @Override
    public Result selectById(Long id) {
        User user = userMapper.selectById(id);
        return user != null ? Result.success("查询成功", user) : Result.error(ResultCodeEnum.ERROR);
    }

    @Override
    public Result page(UserQuery userQuery) {
//        PageHelper.startPage(userQuery.getCurrentPage(), userQuery.getPageSize());
//        List<User> users = userMapper.page(userQuery);
//        PageInfo<User> pageInfo = new PageInfo<>(users);
//        return new Result(200, "查询成功", pageInfo);
        IPage<User> ipage = new Page<>(userQuery.getCurrentPage(), userQuery.getPageSize());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (null != userQuery.getKeyword() && "" != userQuery.getKeyword()) {
            queryWrapper.like("user_name", userQuery.getKeyword())
                    .or().like("real_name", userQuery.getKeyword())
                    .or().like("email", userQuery.getKeyword())
                    .or().like("phone", userQuery.getKeyword());
        }
        IPage<User> userIPage = userMapper.selectPage(ipage, queryWrapper);
        return userIPage != null ? Result.success("查询成功", userIPage) : Result.error(ResultCodeEnum.ERROR);
    }

}
