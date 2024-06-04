package com.laoazhang.controller;

import com.laoazhang.auth.PermissionScanAnno;
import com.laoazhang.service.IPermissionService;
import com.laoazhang.utils.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

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


    @PermissionScanAnno(name = "根据id查询", sn = "permission:get")
    @ApiOperation(value = "根据id获取权限信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "long")})
    @GetMapping("/{id}")
    public Result selectById(@ApiParam(value = "权限id", required = true) @PathVariable("id") Long id) {
        return permissionService.selectById(id);
    }


    @PermissionScanAnno(name = "根据sn查询权限信息", sn = "permission:getSn")
    @ApiOperation(value = "根据sn查询权限信息")
    @ApiImplicitParams(value = {@ApiImplicitParam(name = "sn", value = "权限标识", required = true, dataType = "String")})
    @GetMapping("/selectBySn")
    public Result selectBySn(@RequestParam("sn") String sn) {
        return permissionService.selectBySn(sn);
    }
}
