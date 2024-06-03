package com.laoazhang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laoazhang.system.domain.Permission;
import com.laoazhang.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author laoazhang
 * @date 2024/6/3 11:42
 */
public interface IPermissionService extends IService<Permission> {


    Result selectById(Long id);
}
