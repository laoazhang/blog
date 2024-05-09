package com.laoazhang.user.query;


import com.laoazhang.query.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author laoazhang
 * @CreateTime 2024/5/8 14:46
 * @Description: user模块查询条件类
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserQuery extends BaseQuery {

    private String keyword;

}
