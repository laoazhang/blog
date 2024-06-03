package com.laoazhang.controller;

import com.laoazhang.service.IPermissionService;
import com.laoazhang.utils.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoazhang
 * @date 2024/6/3 11:42
 */
@Api(tags = "权限接口")
@RestController
@RequestMapping("/permission")
public class PermissionController {

    private IPermissionService permissionService;

    public PermissionController(IPermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @ApiOperation(value = "根据id获取权限信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long")})
    @GetMapping("/{id}")
    public Result selectById(@ApiParam(value = "权限id", required = true) @PathVariable("id") Long id) {
        return permissionService.selectById(id);
    }
}
