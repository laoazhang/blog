package com.laoazhang.controller;

import com.laoazhang.service.IUserService;
import com.laoazhang.user.domain.User;
import com.laoazhang.user.query.UserQuery;
import com.laoazhang.utils.Result;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 14:49
 * @Description: 用户模块
 * @Version 1.0
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "新增用户信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "Object")})
    @PostMapping("/insert")
    public Result insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @ApiOperation(value = "根据id删除用户信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")})
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

    @ApiOperation(value = "批量删除用户信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "ids", value = "用户id集合", required = true, dataType = "Object")})
    @PatchMapping("batchDel")
    public Result batchDel(@RequestBody List<Long> ids) {
        return userService.batchDel(ids);
    }

    @ApiOperation(value = "更改用户信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "user", value = "用户对象", required = true, dataType = "Object")})
    @PutMapping("/update")
    public Result update(@RequestBody User user) {
        return userService.update(user);
    }

    @ApiOperation(value = "根据id获取用户信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long")})
    @GetMapping("/{id}")
    public Result selectById(@ApiParam(value = "用户id", required = true) @PathVariable("id") Long id) {
        return userService.selectById(id);
    }

    @ApiOperation(value = "分页查询+模糊查询")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "userQuery", value = "查询条件对象", required = true, dataType = "Object")})
    @PostMapping("/page")
    public Result page(@RequestBody UserQuery userQuery) {
        return userService.page(userQuery);
    }

}
