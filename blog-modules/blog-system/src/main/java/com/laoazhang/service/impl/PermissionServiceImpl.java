package com.laoazhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laoazhang.enums.ResultCodeEnum;
import com.laoazhang.mapper.PermissionMapper;
import com.laoazhang.service.IPermissionService;
import com.laoazhang.system.domain.Permission;
import com.laoazhang.utils.Result;
import org.springframework.stereotype.Service;

/**
 * @author laoazhang
 * @date 2024/6/3 11:49
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    private PermissionMapper permissionMapper;

    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    @Override
    public Result selectById(Long id) {
        Permission permission = permissionMapper.selectById(id);
        return permission != null ? Result.success("查询成功", permission) : Result.error(ResultCodeEnum.ERROR);
    }

    @Override
    public Result selectBySn(String sn) {
        Permission permission = permissionMapper.selectBySn(sn);
        return permission != null ? Result.success("查询成功", permission) : Result.error(ResultCodeEnum.ERROR);
    }

}
