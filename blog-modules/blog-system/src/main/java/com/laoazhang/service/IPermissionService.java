package com.laoazhang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laoazhang.system.domain.Permission;
import com.laoazhang.utils.Result;

/**
 * @author laoazhang
 * @date 2024/6/3 11:42
 */
public interface IPermissionService extends IService<Permission> {


    Result selectById(Long id);

    Result selectBySn(String sn);
}
