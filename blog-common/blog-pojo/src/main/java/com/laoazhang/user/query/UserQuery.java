package com.laoazhang.user.query;


import com.laoazhang.query.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("查询条件实体类")
public class UserQuery extends BaseQuery {

    @ApiModelProperty(value = "关键词")
    private String keyword;

}
