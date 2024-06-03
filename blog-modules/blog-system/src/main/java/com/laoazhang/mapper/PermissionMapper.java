package com.laoazhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laoazhang.system.domain.Permission;

/**
 * @author laoazhang
 * @date 2024/6/3 12:42
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    // 根据sn编码查询权限
    Permission selectBySn(String permissionSn);
}
