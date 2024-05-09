package com.laoazhang.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 14:29
 * @Description: 查询条件工具类
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseQuery {
    // 页码
    private Integer currentPage = 1;
    // 每页展示条数
    private Integer pageSize = 5;

    // 计算分页起始位置
    public Integer getBegin() {
        return (this.currentPage - 1) * this.pageSize;
    }

}
