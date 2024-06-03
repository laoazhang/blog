package com.laoazhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laoazhang.system.domain.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author laoazhang
 * @date 2024/6/3 12:42
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
