package com.laoazhang.controller;

import com.laoazhang.service.IUserService;
import com.laoazhang.user.domain.User;
import com.laoazhang.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public R<List<User>> list() {
        return R.ok("查询所有成功！", userService.list());
    }


    /**
     * 查询单个用户信息
     * @param id 用户Id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取用户信息")
    public R<User> selectById(@ApiParam(value = "用户 ID", required = true) @PathVariable("id") Long id) {
        return R.ok("查询单个成功！", userService.selectById(id));
    }

}
