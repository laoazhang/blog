package com.laoazhang.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author laoazhang
 * @date 2024/6/3 11:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("权限实体类")
public class Permission {
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "权限名称")
    private String name;
    @ApiModelProperty(value = "权限接口地址")
    private String url;
    @ApiModelProperty(value = "权限描述")
    private String descs;
    @ApiModelProperty(value = "权限编码")
    private String sn;
}
