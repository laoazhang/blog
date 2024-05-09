package com.laoazhang.controller;

import com.github.pagehelper.PageInfo;
import com.laoazhang.service.IUserService;
import com.laoazhang.user.domain.User;
import com.laoazhang.user.query.UserQuery;
import com.laoazhang.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 14:49
 * @Description: 用户模块控制器
 * @Version 1.0
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    /**
     * 查询所有用户信息
     * @return 用户的所有信息
     */
    @GetMapping
    @ApiOperation(value = "查询所有用户信息")
    public Result<List<User>> list() {
        return Result.ok("查询所有成功！", userService.list());
    }


    /**
     * 查询单个用户信息
     * @param id 用户Id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取用户信息")
    public Result<User> selectById(@ApiParam(value = "用户 ID", required = true) @PathVariable("id") Long id) {
        return Result.ok("查询单个成功！", userService.selectById(id));
    }

    /**
     * 分页+模糊查询
     * @param userQuery
     * @return
     */
    @PostMapping("/page")
    @ApiOperation(value = "分页查询+模糊查询")
    public Result<PageInfo<User>> page(@RequestBody UserQuery userQuery) {
        return Result.ok("分页查询成功！",userService.page(userQuery));
    }

}
